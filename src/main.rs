extern crate clap;
extern crate env_logger;
#[macro_use]
extern crate log;
#[macro_use]
extern crate nom;

use clap::{App, Arg};
use std::io::{self, Write, Read};
use std::fs::File;

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

fn compile(files : Vec<&str>) -> io::Result<()> {
    let mut declarations = Vec::new();

    for string in files {
        println!("Parsing file {} ...", string);
        let mut bytes = Vec::new();
        File::open(string)?.read_to_end(&mut bytes)?;
        declarations.append(&mut parse_file(&bytes[..]));
        println!("Parsed file {} successfully!", string);
    }
    Ok(())
}

fn parse_file(bytes : &[u8]) -> Vec<Declaration> {
    unimplemented!()
}

enum Declaration {
    Type {
        id: String,
        unoverridable: bool,
        extends: Vec<String>,
        body: Body,
    },
    Function {
        id: String,
        parameters: Vec<Parameter>,
        instance: bool,
        body: Option<Body>,
        return_type: Type,
    },
    Variable {
        id: String,
        mutable: bool,
        value: Option<Statement>,
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
