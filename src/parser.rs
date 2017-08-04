use types::*;
use nom::{anychar, alphanumeric, digit};
use std::str;


named!(pub file<&[u8], Vec<Declaration> >, many0!(ws!(declaration)));

named!(declaration<&[u8], Declaration>, alt_complete!(type_declaration | function_declaration | variable_declaration));

named!(type_declaration<&[u8], Declaration>, do_parse!(
    id: map_res!(call!(upper_id), str_from_slice)
 >> tag!(":=")
 >> unoverridable: map!(opt!(tag!("#")), |o| o.is_some())
 >> tag!("$")
 >> extends: many0!(map_res!(call!(upper_id), str_from_slice))
 >> tag!("{")
 >> body: many0!(alt_complete!(function_declaration | variable_declaration))
 >> tag!("}")
 >> (Declaration::Type{id: id, unoverridable: unoverridable, extends: extends, body: Box::new(body)})
));

named!(function_declaration<&[u8], Declaration>, do_parse!(
    id: map_res!(call!(lower_id), str_from_slice)
 >> tag!(":=")
 >> parameters: many0!(parameter)
 >> tag!("->")
 >> instance: map!(opt!(tag!("%")), |o| o.is_some())
 >> body_or_return_type: alt_complete!(
        map!(type_, |type_:Type| FunctionBodyOrReturnType::ReturnType(type_))
      | map!(do_parse!(
            tag!("{")
         >> statements: many0!(function_statement)
         >> tag!("}")
         >> (Box::new(statements))
        ), |body:Body| FunctionBodyOrReturnType::Body(body)))
 >> (match body_or_return_type {
    FunctionBodyOrReturnType::ReturnType(type_) => Declaration::Function{id: id, parameters: parameters, instance: instance, return_type: Some(type_), body: None},
    FunctionBodyOrReturnType::Body(body) => Declaration::Function{id: id, parameters: parameters, instance: instance, return_type: None, body: Some(body)},
    })
));

named!(variable_declaration<&[u8], Declaration>, do_parse!(
    mutable: map!(opt!(tag!("#")), |o| o.is_some())
 >> id: map_res!(call!(any_id), str_from_slice)
 >> value: alt_complete!(
        map!(tag!("_"), { |_| Option::None })
      | map!(expression, Option::Some))
 >> (Declaration::Variable{id: id, mutable: mutable, value: value})
));

named!(parameter<&[u8], Parameter>, do_parse!(
    id: map!(any_id, str_from_slice)
 >> option: map!(many_m_n!(0, 2, tag!("~")), |v| v.len())
 >> type_: type_
 >> (Parameter{id: id.unwrap(), parameter_type: type_, option: match option {2 => ParameterOption::Clone, 1 => ParameterOption::Copy, _ => ParameterOption::Value}})
));

named!(base_type<&[u8], BaseType>, alt_complete!(
    map!(primitive_type, BaseType::Primitive)
  | map!(map_res!(upper_id, str_from_slice), BaseType::Class)
));

named!(type_<&[u8], Type>, do_parse!(
    base_type: base_type
 >> array: map!(opt!(tag!("[]")), |o| o.is_some())
 >> (Type{base_type: base_type, array: array})
));

named!(expression<&[u8], Expression>, alt_complete!(
    do_parse!(
        tag!("(")
     >> expression_: expression
     >> tag!(")")
     >> (expression_)
    )
  | map!(literal, |e| Expression::Literal(e))
  | map!(map_res!(any_id, str_from_slice), Expression::UnknownId)
  | map!(tag!("%"), |e| Expression::This)
  | map!(tag!("$"), |e| Expression::ArrayLength)
  | do_parse!(
        expression_: expression
     >> tag!(".")
     >> data: map_res!(any_id, str_from_slice)
     >> (Expression::UnknownMethodOrField{base: Box::new(expression_), data: data})
    )
  | do_parse!(
        expression_: expression
     >> tag!("[")
     >> index: expression
     >> tag!("]")
     >> (Expression::Array{base: Box::new(expression_), index: Box::new(index)})
    )
  | do_parse!(
        expression_: expression
     >> tag!("(")
     >> parameters: expression_list
     >> tag!(")")
     >> (Expression::FunctionCall{base: Box::new(expression_), parameters: Box::new(parameters)})
    )
    // TODO: add all other expression cases
));

named!(expression_list<&[u8], Expressions>, separated_list_complete!(tag!(","), expression));

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

named!(function_statement<&[u8], Statement>, alt_complete!(
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
));

named!(if_statement<&[u8], Statement>, do_parse!(
    condition: expression
 >> tag!("?")
 >> tag!("{")
 >> statements: many0!(function_statement)
 >> tag!("}")
 >> nextStatements: many0!(do_parse!(
        condition: expression
     >> tag!("?:")
     >> tag!("{")
     >> statements: many0!(function_statement)
     >> tag!("}")
     >> (IfBlock{condition: Some(condition), body: Box::new(statements)})
    ))
 >> end: opt!(do_parse!(
        tag!(":")
     >> tag!("{")
     >> statements: many0!(function_statement)
     >> tag!("}")
     >> (IfBlock{condition: None, body: Box::new(statements)})
    ))
 >> (Statement::If(vec![IfBlock{
        condition: Some(condition),
        body: Box::new(statements)}]
            .into_iter()
            .chain(nextStatements.into_iter())
            .chain( if let Some(end) = end { vec![end].into_iter() } else { vec![].into_iter() } )
            .collect()
    ))
));

named!(while_statement<&[u8], Statement>, do_parse!(
    tag!("@")
 >> condition: expression
 >> tag!("{")
 >> statements: many0!(function_statement)
 >> tag!("}")
 >> (Statement::While{condition: condition, body: Box::new(statements)})
));

named!(for_statement<&[u8], Statement>, do_parse!(
    tag!("@")
 >> variable: map_res!(any_id, str_from_slice)
 >> tag!(":")
 >> iterable: expression
 >> tag!("{")
 >> statements: many0!(function_statement)
 >> tag!("}")
 >> (Statement::For{variable: variable, iterable: iterable, body: Box::new(statements)})
));


named!(
    upper_id,
    recognize!(do_parse!(
        verify!(call!(anychar), |c| c >= 'A' && c <= 'Z')
     >> call!(alphanumeric)
     >> ()
    ))
);

named!(
    lower_id,
    recognize!(do_parse!(
        verify!(call!(anychar), |c| c >= 'a' && c <= 'z')
     >> call!(alphanumeric)
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
            verify!(call!(anychar), |c| c >= '1' && c <= '9')
         >> call!(digit)
         >> ()
        ))
      | recognize!(verify!(call!(anychar), |c| c == '0'))
    )
);

named!(string_literal<&[u8], String>, delimited!(
    tag!("\""),
    map_res!(escaped!(call!(alphanumeric), '\\', is_a!("\"rtn\\")), str_from_slice),
    tag!("\"")
));

fn str_from_slice(slice: &[u8]) -> Result<String, str::Utf8Error> {
    str::from_utf8(slice).and_then(|s| Ok(s.to_owned()))
}
