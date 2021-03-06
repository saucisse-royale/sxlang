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
    pub condition: Option<Expression>,
    pub body: Body,
}

#[derive(Debug, PartialEq, Eq)]
pub enum Expression {
    Literal(Literal),
    Class(String),
    Function(String),
    Variable(String),
    UnknownId(String),
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
    UnknownMethodOrField {
        base: Box<Expression>,
        data: String,
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
        body: Box<ArrayLiteralBody>,
    },
    StringLiteral(String),
    NumberLiteral {
        negative: bool,
        number: String,
        number_type: Option<Primitive>,
    },
}

#[derive(Debug, PartialEq, Eq)]
pub enum ArrayLiteralBody {
    Count { count: Expression, value: Option<Expression> },
    Values(Vec<Expression>),
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
    pub id: String,
    pub parameter_type: Type,
    pub option: ParameterOption,
}

#[derive(Debug, PartialEq, Eq)]
pub struct Type {
    pub base_type: BaseType,
    pub array: bool,
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
