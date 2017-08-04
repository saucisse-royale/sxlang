extern crate clap;
extern crate env_logger;
#[macro_use]
extern crate log;
#[macro_use]
extern crate nom;

use clap::{App, Arg};
use std::io::{self, Read};
use std::fs::File;
use std::str;
use types::*;

#[allow(dead_code)]
mod lexer;
#[allow(dead_code)]
mod token;
mod parser;
#[allow(dead_code)]
mod types;

mod test;
fn main() {
    if let Err(err) = env_logger::init() {
        println!("{:?}", err);
    }

    let matches = App::new("sxlang")
        .name("sxlang")
        .author("Maitre Van Diest, Delthas, (emersion xd)")
        .about("The Ŝ programming language")
        .arg(
            Arg::with_name("INPUT_FILES")
                .required(true)
                .multiple(true)
                .help("The files to compile"),
        )
        .get_matches();

    if let Err(err) = compile(matches.values_of("INPUT_FILES").unwrap().collect()) {
        println!("{:?}", err);
    }
}

fn compile(files: Vec<&str>) -> io::Result<()> {
    let mut declarations : Vec<Declaration> = Vec::new();

    for string in files {
        println!("Parsing file {} ...", string);
        let mut bytes = Vec::new();
        File::open(string)?.read_to_end(&mut bytes)?;
        let mut result = parser::file(&bytes).to_result().unwrap();
        declarations.append(&mut result);
        println!("Parsed file {} successfully!", string);
    }

    for declaration in declarations.iter() {
        println!("{:?}", declaration);
    }

    Ok(())
}
