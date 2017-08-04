#[derive(Debug, PartialEq, Eq)]
pub enum FunctionBodyOrReturnType {
    Body(Body),
    ReturnType(Type),
}

#[derive(Debug, PartialEq, Eq)]
pub enum Declaration {
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

#[derive(Debug, PartialEq, Eq)]
pub enum Statement {
    If(Vec<IfBlock>),
    While { condition: Expression, body: Body },
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

#[derive(Debug, PartialEq, Eq)]
pub struct IfBlock {
    condition: Option<Expression>,
    body: Body,
}

#[derive(Debug, PartialEq, Eq)]
pub enum Expression {
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
    UnaryOp { base: Box<Expression>, op: UnaryOp },
    BinaryOp {
        left: Box<Expression>,
        right: Box<Expression>,
        op: BinaryOp,
    },
}

#[derive(Debug, PartialEq, Eq)]
pub enum Literal {
    ArrayLiteral {
        array_type: Option<BaseType>,
        body: ArrayLiteralBody,
    },
    StringLiteral(String),
    NumberLiteral {
        number: String,
        number_type: Primitive,
    },
}

#[derive(Debug, PartialEq, Eq)]
pub enum ArrayLiteralBody {
    Count { count: u32, value: Option<String> },
    Values(Vec<String>),
}

pub type Expressions = Vec<Expression>;
pub type Body = Box<Vec<Statement>>;

#[derive(Debug, PartialEq, Eq)]
pub enum ParameterOption {
    Value,
    Copy,
    Clone,
}

#[derive(Debug, PartialEq, Eq)]
pub struct Parameter {
    id: String,
    parameter_type: Type,
    option: ParameterOption,
}

#[derive(Debug, PartialEq, Eq)]
pub struct Type {
    base_type: BaseType,
    array: bool,
}

#[derive(Debug, PartialEq, Eq)]
pub enum BaseType {
    Primitive(Primitive),
    Class(String),
}

#[derive(Debug, PartialEq, Eq)]
pub enum BinaryOp {
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

#[derive(Debug, PartialEq, Eq)]
pub enum UnaryOp {
    PostIncrement,
    PostDecrement,
    PreIncrement,
    PreDecrement,
    PrePlus,
    PreMinus,
    Not,
}

#[derive(Debug, PartialEq, Eq)]
pub enum Primitive {
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
