use types::*;
use nom::{anychar, alphanumeric, digit};
use std::str;


named!(space, eat_separator!(&b" \t"[..]));

macro_rules! sp (
  ($i:expr, $($args:tt)*) => (
    {
      sep!($i, space, $($args)*)
    }
  )
);

named!(newlines<&[u8], ()>, sp!(do_parse!(
    many0!(do_parse!(opt!(line_comment) >> line_ending >> ()))
 >> ()
)));

named!(newlines1<&[u8], ()>, sp!(do_parse!(
    many1!(do_parse!(opt!(line_comment) >> line_ending >> ()))
 >> ()
)));

named!(pub file<&[u8], Vec<Declaration> >, sp!(separated_list_complete!(newlines1, declaration)));

named!(declaration<&[u8], Declaration>, sp!(delimited!(newlines, alt_complete!(type_declaration | function_declaration | variable_declaration), newlines)));

named!(type_declaration<&[u8], Declaration>, sp!(do_parse!(
    id: map_res!(call!(upper_id), str_from_slice)
 >> tag!(":=")
 >> unoverridable: map!(opt!(tag!("#")), |o| o.is_some())
 >> tag!("$")
 >> extends: many0!(map_res!(call!(upper_id), str_from_slice))
 >> tag!("{")
 >> body: delimited!(newlines, separated_list_complete!(newlines1, alt_complete!(function_declaration | variable_declaration)), newlines)
 >> tag!("}")
 >> (Declaration::Type{id: id, unoverridable: unoverridable, extends: extends, body: Box::new(body)})
)));

named!(function_declaration<&[u8], Declaration>, sp!(delimited!(newlines,do_parse!(
    id: map_res!(call!(lower_id), str_from_slice)
 >> tag!(":=")
 >> parameters: many0!(parameter)
 >> tag!("->")
 >> instance: map!(opt!(tag!("%")), |o| o.is_some())
 >> body_or_return_type: alt_complete!(
        map!(type_, |type_:Type| FunctionBodyOrReturnType::ReturnType(type_))
      | map!(do_parse!(
            tag!("{")
         >> statements: function_statements
         >> tag!("}")
         >> (Box::new(statements))
        ), |body:Body| FunctionBodyOrReturnType::Body(body)))
 >> (match body_or_return_type {
    FunctionBodyOrReturnType::ReturnType(type_) => Declaration::Function{id: id, parameters: parameters, instance: instance, return_type: Some(type_), body: None},
    FunctionBodyOrReturnType::Body(body) => Declaration::Function{id: id, parameters: parameters, instance: instance, return_type: None, body: Some(body)},
    })
), newlines)));

named!(variable_declaration<&[u8], Declaration>, sp!(delimited!(newlines,do_parse!(
    mutable: map!(opt!(tag!("#")), |o| o.is_some())
 >> id: map_res!(call!(any_id), str_from_slice)
 >> value: alt_complete!(
        map!(tag!("_"), { |_| Option::None })
      | map!(expression, Option::Some))
 >> (Declaration::Variable{id: id, mutable: mutable, value: value})
), newlines)));

named!(parameter<&[u8], Parameter>, sp!(do_parse!(
    id: map!(any_id, str_from_slice)
 >> option: map!(many_m_n!(0, 2, tag!("~")), |v| v.len())
 >> type_: type_
 >> (Parameter{id: id.unwrap(), parameter_type: type_, option: match option {2 => ParameterOption::Clone, 1 => ParameterOption::Copy, _ => ParameterOption::Value}})
)));

named!(base_type<&[u8], BaseType>, sp!(alt_complete!(
    map!(primitive_type, BaseType::Primitive)
  | map!(map_res!(upper_id, str_from_slice), BaseType::Class)
)));

named!(type_<&[u8], Type>, sp!(do_parse!(
    base_type: base_type
 >> array: map!(opt!(tag!("[]")), |o| o.is_some())
 >> (Type{base_type: base_type, array: array})
)));

named!(expression_list<&[u8], Expressions>, sp!(separated_list_complete!(tag!(","), expression)));

named!(primitive_type<&[u8], Primitive>,
    alt_complete!(
        tag!("b") => { |_| Primitive::Byte }
      | tag!("u-") => { |_| Primitive::UInt16 }
      | tag!("u+") => { |_| Primitive::UInt64 }
      | tag!("u") => { |_| Primitive::UInt32 }
      | tag!("i-") => { |_| Primitive::Int16 }
      | tag!("i+") => { |_| Primitive::Int64 }
      | tag!("i") => { |_| Primitive::Int32 }
      | tag!("f+") => { |_| Primitive::Float64 }
      | tag!("f") => { |_| Primitive::Float32 }
    )
);

named!(literal<&[u8], Literal>, alt_complete!(
    do_parse!(
        negative: opt!(alt_complete!(tag!("-") => { |_| true } | tag!("+") => { |_| false }))
     >> integer_part: map_res!(number_literal_value, str_from_slice)
     >> float_part: opt!(map_res!(do_parse!(
            tag!(".")
         >> digits: call!(digit)
         >> (digits)
        ), str_from_slice))
     >> suffix: opt!(primitive_type)
     >> (Literal::NumberLiteral{negative: if let Some(b) = negative {b} else {false}, number: match float_part {Some(f) => integer_part + &f, _ => integer_part}, number_type: suffix})
    )
  | map!(string_literal, Literal::StringLiteral)
  | do_parse!(
        type_: opt!(base_type)
     >> tag!("[")
     >> body: alt_complete!(
            do_parse!(
                count: expression
             >> value: alt_complete!(
                     tag!("_") => { |_| None }
                   | expression => { |e| Some(e) }
                )
             >> (ArrayLiteralBody::Count{count: count, value: value})
            )
          | expression_list => { |l| ArrayLiteralBody::Values(l) }
        )
     >> (Literal::ArrayLiteral{array_type: type_, body: Box::new(body)})
    )
));

named!(function_statement<&[u8], Statement>, sp!(alt_complete!(
    if_statement
  | while_statement
  | for_statement
  | do_parse!(
        tag!("§")
     >> expression: expression
     >> (Statement::Return(expression))
    )
  | do_parse!(
        continues: many1!(tag!(">"))
     >> (Statement::Continue(continues.len() as u32))
    )
  | do_parse!(
        breaks: many1!(tag!("<"))
     >> (Statement::Break(breaks.len() as u32))
    )
  | do_parse!(
        expression: expression
     >> (Statement::Expression(expression))
    )
)));

named!(function_statements<&[u8], Vec<Statement> >,
    sp!(delimited!(newlines, separated_list_complete!(newlines1, function_statement), newlines))
);

named!(if_statement<&[u8], Statement>, sp!(do_parse!(
    condition: expression
 >> tag!("?")
 >> tag!("{")
 >> statements: function_statements
 >> tag!("}")
 >> next_statements: many0!(sp!(do_parse!(
        condition: expression
     >> tag!("?:")
     >> tag!("{")
     >> statements: function_statements
     >> tag!("}")
     >> (IfBlock{condition: Some(condition), body: Box::new(statements)})
    )))
 >> end: opt!(sp!(do_parse!(
        tag!(":")
     >> tag!("{")
     >> statements: function_statements
     >> tag!("}")
     >> (IfBlock{condition: None, body: Box::new(statements)})
    )))
 >> (Statement::If(vec![IfBlock{
        condition: Some(condition),
        body: Box::new(statements)}]
            .into_iter()
            .chain(next_statements.into_iter())
            .chain( if let Some(end) = end { vec![end].into_iter() } else { vec![].into_iter() } )
            .collect()
    ))
)));

named!(while_statement<&[u8], Statement>, sp!(do_parse!(
    tag!("@")
 >> condition: expression
 >> tag!("{")
 >> statements: function_statements
 >> tag!("}")
 >> (Statement::While{condition: condition, body: Box::new(statements)})
)));

named!(for_statement<&[u8], Statement>, sp!(do_parse!(
    tag!("@")
 >> variable: map_res!(any_id, str_from_slice)
 >> tag!(":")
 >> iterable: expression
 >> tag!("{")
 >> statements: function_statements
 >> tag!("}")
 >> (Statement::For{variable: variable, iterable: iterable, body: Box::new(statements)})
)));


named!(
    upper_id,
    recognize!(do_parse!(
        verify!(call!(anychar), |c| c >= 'A' && c <= 'Z')
     >> opt!(call!(alphanumeric))
     >> ()
    ))
);

named!(
    lower_id,
    recognize!(do_parse!(
        verify!(call!(anychar), |c| c >= 'a' && c <= 'z')
     >> opt!(call!(alphanumeric))
     >> ()
    ))
);

named!(
    any_id,
    recognize!(do_parse!(
        call!(alphanumeric)
     >> ()
    ))
);

named!(
    number_literal_value,
    alt_complete!(
        recognize!(do_parse!(
            verify!(call!(anychar), |c| c >= '1' && c <= '9') >>
                call!(digit) >> ()
        )) | recognize!(verify!(call!(anychar), |c| c == '0'))
    )
);

named!(string_literal<&[u8], String>, delimited!(
//TODO use escaped_transform!
    tag!("\""),
    map_res!(escaped!(call!(alphanumeric), '\\', is_a!("\"rtn\\")), str_from_slice),
    tag!("\"")
));

named!(line_comment, recognize!(do_parse!(
    tag!("//")
 >> take_while!(call!(|c| c != '\r' as u8 && c != '\n' as u8))
 >> ()
)));

named!(line_ending, recognize!(do_parse!(
    opt!(tag!("\r"))
 >> tag!("\n")
 >> ()
)));

fn str_from_slice(slice: &[u8]) -> Result<String, str::Utf8Error> {
    str::from_utf8(slice).and_then(|s| Ok(s.to_owned()))
}

macro_rules! binop {
    (
        $name: ident,
        $next: ident,
        $submac: ident!( $($args:tt)* )
    ) => {
    named!($name<&[u8], Expression>, sp!(do_parse!(
        init: $next
     >> result: fold_many0!(pair!($submac!($($args)*), $next), init, |e:Expression, next:(BinaryOp, Expression)| Expression::BinaryOp{left: Box::new(e), op: next.0, right: Box::new(next.1)})
     >> (result))));
    }
}

named!(expression<&[u8], Expression>, call!(assign_expr));

named!(assign_expr<&[u8], Expression>, sp!(do_parse!(
    init: or_expr
 >> result: fold_many0!(pair!(
        alt_complete!(
            tag!("=") => { |_| BinaryOp::Assign }
          | tag!("+=") => { |_| BinaryOp::AssignAddition }
          | tag!("-=") => { |_| BinaryOp::AssignSubtraction }
          | tag!("*=") => { |_| BinaryOp::AssignMultiplication }
          | tag!("/=") => { |_| BinaryOp::AssignDivision }
          | tag!("%=") => { |_| BinaryOp::AssignModulo }
          | tag!("&=") => { |_| BinaryOp::AssignBitAnd }
          | tag!("|=") => { |_| BinaryOp::AssignBitOr }
          | tag!("^=") => { |_| BinaryOp::AssignBitXor }
          | tag!(">>=") => { |_| BinaryOp::AssignShiftRight }
          | tag!(">>>=") => { |_| BinaryOp::AssignShiftLogicalRight }
          | tag!("<<=") => { |_| BinaryOp::AssignShiftLeft }
        ), assign_expr), init, |e:Expression, next:(BinaryOp, Expression)| Expression::BinaryOp{left: Box::new(e), op: next.0, right: Box::new(next.1)})
 >> (result)
)));

binop!(or_expr, and_expr, map!(tag!("||"), |_| BinaryOp::Or));
binop!(and_expr, compare_expr, map!(tag!("&&"), |_| BinaryOp::And));

binop!(compare_expr, bitor_expr, alt_complete!(
    tag!("==") => { |_| BinaryOp::Equals }
  | tag!("!=") => { |_| BinaryOp::NotEquals }
  | tag!(">=") => { |_| BinaryOp::GreaterEqualThan }
  | tag!("<=") => { |_| BinaryOp::LessEqualThan }
  | tag!(">") => { |_| BinaryOp::GreaterThan }
  | tag!("<") => { |_| BinaryOp::LessThan }));

binop!(bitor_expr, bitxor_expr, do_parse!(not!(tag!("||")) >> not!(tag!("|=")) >> tag!("|") >> (BinaryOp::BitOr)));
binop!(bitxor_expr, bitand_expr, do_parse!(not!(tag!("^=")) >> tag!("^") >> (BinaryOp::BitXor)));
binop!(bitand_expr, shift_expr, do_parse!(not!(tag!("&=")) >> not!(tag!("&&")) >> tag!("&") >> (BinaryOp::BitAnd)));

binop!(shift_expr, arith_expr, alt_complete!(
    tag!(">>>") => { |_| BinaryOp::ShiftLogicalRight }
  | tag!(">>") => { |_| BinaryOp::ShiftRight }
  | tag!("<<") => { |_| BinaryOp::ShiftLeft }
));

binop!(arith_expr, term_expr, alt_complete!(
    tag!("+") => { |_| BinaryOp::Addition }
  | tag!("-") => { |_| BinaryOp::Subtraction }
));

binop!(term_expr, trailer_expr, alt_complete!(
    tag!("*") => { |_| BinaryOp::Multplication }
  | tag!("/") => { |_| BinaryOp::Division }
  | tag!("%") => { |_| BinaryOp::Modulo }
));

named!(trailer_expr<&[u8], Expression>, sp!(do_parse!(
    init: atom_expr
 >> result: fold_many0!(alt_complete!(
        delimited!(tag!("("), expression_list, tag!(")")) => { ExpressionPartialTrailer::FunctionCall }
      | preceded!(tag!("."), map_res!(any_id, str_from_slice)) => { ExpressionPartialTrailer::UnknownMethodOrField }
      | delimited!(tag!("["), expression, tag!("]")) => { ExpressionPartialTrailer::Array }
    ), init, |e:Expression, next:ExpressionPartialTrailer|
        match next {
            ExpressionPartialTrailer::FunctionCall(next) => Expression::FunctionCall{base: Box::new(e), parameters: Box::new(next)},
            ExpressionPartialTrailer::UnknownMethodOrField(next) => Expression::UnknownMethodOrField{base: Box::new(e), data: next},
            ExpressionPartialTrailer::Array(next) => Expression::Array{base: Box::new(e), index: Box::new(next)},
        }
    )
 >> (result)
)));

named!(atom_expr<&[u8], Expression>, sp!(alt_complete!(
    delimited!(tag!("("), expression, tag!(")"))
  | map!(literal, Expression::Literal)
  | map!(map_res!(any_id, str_from_slice), Expression::UnknownId)
  | map!(tag!("%"), |_| Expression::This)
  | map!(tag!("$"), |_| Expression::ArrayLength)
)));

enum FunctionBodyOrReturnType {
    Body(Body),
    ReturnType(Type),
}

enum ExpressionPartialTrailer {
    FunctionCall(Expressions),
    UnknownMethodOrField(String),
    Array(Expression),
}
