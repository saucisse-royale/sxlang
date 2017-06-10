pub enum Token {
    Illegal,

    KeyWord,
    Identifier,
    Litteral(String),
    Integer(i32),

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

    // TODO complete
}
