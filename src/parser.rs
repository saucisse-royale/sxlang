use types::*;
use nom::{self, anychar, alphanumeric, digit};


named!(file<&[u8], Vec<Declaration> >, many0!(ws!(declaration)));

named!(declaration<&[u8], Declaration>, alt!(type_declaration | function_declaration | variable_declaration));

named!(pub type_declaration<&[u8], Declaration>, do_parse!(
    id: map_res!(call!(upper_id), String::from_utf8)
 >> tag!(":=")
 >> unoverridable: map!(opt!(tag!("#")), Option::is_some)
 >> tag!("$")
 >> extends: many0!(map_res!(call!(upper_id), String::from_utf8))
 >> tag!("{")
 >> body: many0!(alt!(function_declaration | variable_declaration))
 >> tag!("}")
 >> (Declaration::Type{id: id, unoverridable: unoverridable, extends: extends, body: Box::new(body)})
));

named!(function_declaration<&[u8], Declaration>, do_parse!(
    id: map_res!(call!(lower_id), String::from_utf8)
 >> tag!(":=")
 >> parameters: many0!(parameter)
 >> tag!("->")
 >> instance: map!(opt!(tag!("%")), Option::is_some)
 >> body_or_return_type: alt!(
        map!(opt!(type_), |type_:Type| FunctionBodyOrReturnType::ReturnType(type_))
      | map!(opt!(do_parse!(
            tag!("{")
         >> statements: many0!(function_statement)
         >> tag!("}")
         >> (statements)
        )), |body:Body| FunctionBodyOrReturnType::Body(body)))
 >> (Declaration::Function{id: id, parameters: parameters, instance: instance,
    return_type: match body_or_return_type {FunctionBodyOrReturnType::ReturnType(type_) => Some(type_), _ => None},
    body: match body_or_return_type {FunctionBodyOrReturnType::Body(body) => Some(body), _ => None}})
));

named!(variable_declaration<&[u8], Declaration>, do_parse!(
    mutable: map!(opt!(tag!("#")), Option::is_some)
 >> id: map_res!(call!(any_id), String::from_utf8)
 >> value: alt!(
        map!(tag!("_"), |_| None)
      | expression)
 >> (Declaration::Variable{id: id, mutable: mutable, value: value})
));

named!(parameter<&[u8], Parameter>, do_parse!(
    id: map!(any_id, String::from_utf8)
 >> option: map!(many_m_n!(0, 2, tag!("~")), |v| v.len())
 >> type_: type_
 >> (Parameter{id: id.unwrap(), parameter_type: type_, option: match option {2 => ParameterOption::Clone, 1 => ParameterOption::Copy, _ => ParameterOption::Value}})
));

named!(type_<&[u8], Type>, do_parse!(
    base_type: alt!(
        // FIX: savapatrap la syntax Byte(truc), c'est pas un tuple-struct
        map!(tag!("b"), |e| BaseType::Primitive(Primitive::Byte(e)))
      | map!(tag!("i-"), |e| BaseType::Primitive(Primitive::Int16(e)))
      | map!(tag!("i+"), |e| BaseType::Primitive(Primitive::Int64(e)))
      | map!(tag!("i"), |e| BaseType::Primitive(Primitive::Int32(e)))
      | map!(tag!("u-"), |e| BaseType::Primitive(Primitive::UInt16(e)))
      | map!(tag!("u+"), |e| BaseType::Primitive(Primitive::UInt64(e)))
      | map!(tag!("u"), |e| BaseType::Primitive(Primitive::UInt32(e)))
      | map!(tag!("f+"), |e| BaseType::Primitive(Primitive::Float64(e)))
      | map!(tag!("f"), |e| BaseType::Primitive(Primitive::Float32(e)))
      | map!(upper_id, |e| BaseType::String(String::from_utf8(e)))
    )
 >> array: map!(opt!(tag!("[]")), Option::is_some)
 >> (Type{base_type: base_type, array: array})
));

named!(expression<&[u8], Expression>, alt!(
    do_parse!(
        tag!("(")
     >> expression: expression
     >> tag!(")")
     >> (expression)
    )
    // TODO: add more expressions
));

named!(pub primitive_type<&[u8], Primitive>,
    alt!(
        tag!("b") => { |_| Primitive::Byte }
      | tag!("u-") => { |_| Primitive::UInt16 }
      | tag!("u") => { |_| Primitive::UInt32 }
      | tag!("u+") => { |_| Primitive::UInt64 }
      | tag!("i-") => { |_| Primitive::Int16 }
      | tag!("i") => { |_| Primitive::Int32 }
      | tag!("i+") => { |_| Primitive::Int64 }
      | tag!("f") => { |_| Primitive::Float32 }
      | tag!("f+") => { |_| Primitive::Float64 }
    )
);

named!(pub literal<&[u8], Literal>, alt!(
        do_parse!(
            // number literal
            // !! la regex est chiée ?? --> (\+ | -)? [0-9]+(\.[0-9]*)? NUMBER_SUFFIX?
            number: map_res!(recognize!(do_parse!(
                opt!(alt!(tag!("+") | tag!("-")))
             >> call!(digit)
             >> opt!(
                do_parse!(
                // optional floating point literal
                    tag!(".")
                 >> call!(digit)
                 >> ()
                )
             )
             >> ()
            )), String::from_utf8)
         >> number_type: opt!(call!(primitive_type))
         >> (Literal::NumberLiteral {
                number,
                number_type: number_type.unwrap_or_else(|| {
                    if number.find('.').is_some() {
                        Primitive::Float32
                    } else {
                        Primitive::Int32 // does not handle yet u overflowing as i
                    }
                })
            })
        )
        // TODO: implement the rest
    )
);

named!(function_statement<&[u8], Statement>, alt!(
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
 >> variable: map!(any_id, String::from_utf8)
 >> tag!(":")
 >> iterable: expression
 >> tag!("{")
 >> statements: many0!(function_statement)
 >> tag!("}")
 >> (Statement::For{variable: variable.unwrap(), iterable: iterable, body: Box::new(statements)})
));


named!(
    pub upper_id,
    recognize!(do_parse!(
        verify!(call!(anychar), |c| c >= 'A' && c <= 'Z') >>
            call!(alphanumeric) >> ()
    ))
);

named!(
    pub lower_id,
    recognize!(do_parse!(
        verify!(call!(anychar), |c| c >= 'a' && c <= 'z') >>
            call!(alphanumeric) >> ()
    ))
);

named!(pub any_id, recognize!(do_parse!(
    call!(alphanumeric)
 >> ()
)));