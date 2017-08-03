extern crate clap;
extern crate env_logger;
#[macro_use]
extern crate log;
#[macro_use]
extern crate nom;
extern crate regex;

use clap::{App, Arg};
use std::io::{self, Write, Read};
use std::fs::File;
use std::str;
use nom::{anychar, alphanumeric};

#[allow(dead_code)]
mod lexer;
#[allow(dead_code)]
mod token;

fn main() {
    if let Err(err) = env_logger::init() {
        println!("{:?}", err);
    }

    let matches = App::new("sxlang")
        .name("sxlang")
        .author("Maitre Van Diest, Delthas, (emersion xd)")
        .about("The Ŝ programming language")
        .arg(Arg::with_name("INPUT_FILES").required(true).multiple(true).help(
            "The files to compile",
        ))
        .get_matches();

    if let Err(err) = compile(matches.values_of("INPUT_FILES").unwrap().collect()) {
        println!("{:?}", err);
    }
}

fn compile(files: Vec<&str>) -> io::Result<()> {
    let mut declarations = Vec::new();

    for string in files {
        println!("Parsing file {} ...", string);
        let mut bytes = Vec::new();
        File::open(string)?.read_to_end(&mut bytes)?;
        let mut result = file(&bytes[..]).to_result().unwrap();
        declarations.append(&mut result);
        println!("Parsed file {} successfully!", string);
    }
    Ok(())
}

named!(file<&[u8], Vec<Declaration> >, many0!(ws!(declaration)));

named!(declaration<&[u8], Declaration>, alt!(type_declaration | function_declaration | variable_declaration));

named!(type_declaration<&[u8], Declaration>, do_parse!(
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
 >> (Parameter{id: id, parameter_type: type_, option: match option {2 => ParameterOption::Clone, 1 => ParameterOption::Copy, _ => ParameterOption::Value}})
));

named!(type_<&[u8], Type>, do_parse!(
    base_type: alt!(
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
  | // TODO: add other expression cases
));

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
     >> (Statement::Continue(continues.len()))
    )
  | do_parse!(
        breaks: many1!(tag!("<"))
     >> (Statement::Break(breaks.len()))
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
     >> (IfBlock{condition: condition, body: Box::new(statements)})
    ))
 >> end: opt!(do_parse!(
        tag!(":")
     >> tag!("{")
     >> statements: many0!(function_statement)
     >> tag!("}")
     >> (IfBlock{condition: None, body: Box::new(statements)})
    ))
 >> (Statement::If([IfBlock{condition: condition, body: Box::new(statements)}].iter().chain(nextStatements).chain(end).collect()))
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
 >> (Statement::For{variable: variable, iterable: iterable, body: Box::new(statements)})
));


named!(upper_id, recognize!(do_parse!(
    verify!(call!(anychar), |c| c >= 'A' && c <= 'Z')
 >> call!(alphanumeric)
 >> ()
)));

named!(lower_id, recognize!(do_parse!(
    verify!(call!(anychar), |c| c >= 'a' && c <= 'z')
 >> call!(alphanumeric)
 >> ()
)));

named!(any_id, recognize!(do_parse!(
    call!(alphanumeric)
 >> ()
)));

enum FunctionBodyOrReturnType {
    Body(Body),
    ReturnType(Type),
}

enum Declaration {
    Type {
        id: String,
        unoverridable: bool,
        extends: Vec<String>,
        body: Box<Vec<Declaration>>,
    },
    Function {
        id: String,
        parameters: Vec<Parameter>,
        instance: bool,
        return_type: Option<Type>,
        body: Option<Body>,
    },
    Variable {
        id: String,
        mutable: bool,
        value: Option<Expression>,
    },
}

enum Statement {
    If(Vec<IfBlock>),
    While {
        condition: Expression,
        body: Body,
    },
    For {
        variable: String,
        iterable: Expression,
        body: Body,
    },
    Return(Expression),
    Continue(u32),
    Break(u32),
    Expression(Expression),
}

struct IfBlock {
    condition: Option<Expression>,
    body: Body,
}

enum Expression {
    Literal(Literal),
    Class(String),
    Function(String),
    Variable(String),
    This,
    ArrayLength,
    Method {
        base: Box<Expression>,
        method: String,
    },
    Field {
        base: Box<Expression>,
        field: String,
    },
    Array {
        base: Box<Expression>,
        index: Box<Expression>,
    },
    FunctionCall {
        base: Box<Expression>,
        parameters: Box<Expressions>,
    },
    UnaryOp {
        base: Box<Expression>,
        op: UnaryOp,
    },
    BinaryOp {
        left: Box<Expression>,
        right: Box<Expression>,
        op: BinaryOp,
    },
}

enum Literal {
    ArrayLiteral {
        array_type: Option<BaseType>,
        body: ArrayLiteralBody,
    },
    StringLiteral(String),
    NumberLiteral {
        number: String,
        number_type: Primitive,
    }
}

enum ArrayLiteralBody {
    Count {
        count: u32,
        value: Option<String>,
    },
    Values(Vec<String>),
}

type Expressions = Vec<Expression>;
type Body = Box<Vec<Statement>>;

enum ParameterOption {
    Value,
    Copy,
    Clone,
}

struct Parameter {
    id: String,
    parameter_type: Type,
    option: ParameterOption,
}

struct Type {
    base_type: BaseType,
    array : bool,
}

enum BaseType {
    Primitive(Primitive),
    Class(String),
}

enum BinaryOp {
    Multplication,
    Division,
    Modulo,
    Addition,
    Subtraction,
    LessThan,
    LessEqualThan,
    GreaterThan,
    GreaterEqualThan,
    Equals,
    NotEquals,
    ShiftLeft,
    ShiftRight,
    ShiftLogicalRight,
    BitAnd,
    BitXor,
    BitOr,
    And,
    Or,
    Assign,
    AssignAddition,
    AssignSubtraction,
    AssignMultiplication,
    AssignDivision,
    AssignModulo,
    AssignBitAnd,
    AssignBitOr,
    AssignBitXor,
    AssignShiftLeft,
    AssignShiftRight,
    AssignShiftLogicalRight,
}

enum UnaryOp {
    PostIncrement,
    PostDecrement,
    PreIncrement,
    PreDecrement,
    PrePlus,
    PreMinus,
    Not,
}

enum Primitive {
    Byte,
    UInt16,
    UInt32,
    UInt64,
    Int16,
    Int32,
    Int64,
    Float32,
    Float64,
}


