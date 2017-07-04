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
                '@' => Some(Token::AtSign),
                '§' => Some(Token::Paragraph),
                '?' => Some(Token::QuestionMark),
                '#' => Some(Token::Hash),
                '%' => Some(Token::Percent),

                ':' => {
                    if self.is_next_char('=') {
                        self.input.next();
                        return Some(Token::ColonEqual);
                    }
                    Some(Token::Illegal)
                }

                '<' => {
                    if self.is_next_char('<') {
                        self.input.next();
                        return Some(Token::Shl);
                    }
                    Some(Token::LessThan)
                }

                '>' => {
                    if self.is_next_char('>') {
                        self.input.next();
                        return Some(Token::Shr);
                    }
                    Some(Token::GreaterThan)
                }

                '~' => {
                    if self.is_next_char('~') {
                        self.input.next();
                        return Some(Token::DoubleTilda);
                    }
                    Some(Token::Tilda)
                }

                '.' => {
                    if self.is_next_char('.') {
                        self.input.next();
                        return Some(Token::DoubleDot);
                    }
                    Some(Token::Dot)
                }

                ' ' | '\n' | '\t' | '\r' => self.next_token(),
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

    fn is_next_char(&mut self, expected: char) -> bool {
        self.input.peek() == Some(&expected)
    }
}

#[test]
fn test_get_integer_token() {
    let mut input = Lexer::new("123456 sava");
    assert_eq!(input.next_token(), Some(Token::Integer(123456)));
}

#[test]
fn test_non_prefix_monochar_token() {
    let mut input = Lexer::new("?§#    @");
    let mut tokens = vec![];

    while let Some(tok) = input.next_token() {
        tokens.push(tok);
    }

    use self::Token::*;
    assert_eq!(tokens, vec![QuestionMark, Paragraph, Hash, AtSign]);
}

#[test]
fn test_various_tokens() {
    let mut input = Lexer::new(
        "
        @@ :  1
          § :=   #
    ",
    );

    let mut tokens = vec![];
    while let Some(tok) = input.next_token() {
        tokens.push(tok);
    }

    use self::Token::*;
    assert_eq!(
        tokens,
        vec![
            AtSign,
            AtSign,
            Illegal,
            Integer(1),
            Paragraph,
            ColonEqual,
            Hash,
        ]
    );
}
