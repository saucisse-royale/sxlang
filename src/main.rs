extern crate clap;
extern crate env_logger;
#[macro_use]
extern crate log;

use clap::{App, Arg};
use std::io::{self, Write};

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
        .arg(
            Arg::with_name("interpret")
                .short("i")
                .long("interpret")
                .help("Use sxlang in interpreter mode."),
        )
        .arg(
            Arg::with_name("compile")
                .short("c")
                .long("compile")
                .help("Use sxlang in compiler mode.")
                .conflicts_with("interpret")
                .requires("INPUT_FILES"),
        )
        .arg(Arg::with_name("INPUT_FILES").multiple(true).help(
            "The files to interpret/compile",
        ))
        .get_matches();

    if matches.is_present("interpret") {
        info!("Interpreter mode.");
        if let Err(err) = interpret() {
            println!("{:?}", err);
        }
    } else {
        info!("Compiler mode.");
        if let Err(err) = compile() {
            println!("{:?}", err);
        }
    }
}

fn interpret() -> io::Result<()> {
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

    // Ok(())
}

fn compile() -> io::Result<()> {
    unimplemented!()
}
