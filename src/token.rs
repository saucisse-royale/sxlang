#[derive(Debug, Clone, PartialEq, Eq)]
pub enum Token {
    Illegal,
    // EOF not needed, it is just None
    KeyWord,
    Identifier,
    Litteral(String),
    // TODO implement different types of numeric values
    Integer(i32),

    LeftParenthesis,
    RightParenthesis,
    LeftBrace,
    RightBrace,
    LeftBracket,
    RightBracket,

    ColonEqual, // := (": =" is illegal)
    AtSign, // @
    QuestionMark,
    Dollar,
    Hash,
    Paragraph, // §
    RightArrow, // ->
    Dot, // .
    DoubleDot, // ..
    Quote, // "
    Backslash, // \
    Tilda, // ~
    DoubleTilda, // ~~

    // Binary operators
    Plus,
    Minus,
    Star,
    Slash,
    Percent,
    Caret,
    And,
    Or,
    Shl,
    Shr,
    LessThan,
    GreaterThan,
}
