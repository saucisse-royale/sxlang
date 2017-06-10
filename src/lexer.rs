use token::Token;

use std::str::Chars;
use std::iter;

pub struct Lexer<'a> {
    input: iter::Peekable<Chars<'a>>,
}

impl<'a> Lexer<'a> {
    pub fn new<'b>(input: &'b str) -> Lexer<'b> {
        Lexer { input: input.chars().peekable() }
    }

    pub fn next_token(&mut self) -> Option<Token> {
        if let Some(repr) = self.input.next() {
            match repr {
                c @ '0'...'9' => Some(Token::Integer(self.get_integer_token(c))),
                // TODO complete
                _ => Some(Token::Illegal),
            }
        } else {
            None
        }
    }

    fn get_integer_token(&mut self, first_digit: char) -> i32 {
        let mut ret: String = first_digit.to_string();

        loop {
            match self.input.peek() {
                Some(c @ &'0'...'9') => ret += &c.to_string(),
                _ => break,
            }
            self.input.next();
        }

        // TODO remove unwrap
        ret.parse().unwrap()
    }
}

#[test]
fn test_get_integer_token() {
    let mut input = Lexer::new("123456 sava");
    if let Some(Token::Integer(n)) = input.next_token() {
        assert_eq!(n, 123456);
    } else {
        panic!()
    }
}
