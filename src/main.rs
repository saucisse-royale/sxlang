use std::io::{self, Write};

#[allow(dead_code)]
mod lexer;
#[allow(dead_code)]
mod token;

fn main() {
    match run() {
        Ok(_) => {}
        Err(err) => println!("{:?}", err),
    }
}

fn run() -> io::Result<()> {
    let stdin = io::stdin();

    loop {
        print!("Ŝ>> ");
        io::stdout().flush()?;

        let mut line = String::new();
        stdin.read_line(&mut line)?;

        loop {
            // process input
            // break at EOF
            unimplemented!()
        }
    }

    Ok(())
}
