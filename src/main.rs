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
        body: Vec<Declaration>,
    },
    Function {
        id: String,
        // ...
    },
    Variable {

    },
}

