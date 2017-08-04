mod parser {
    use parser::*;
    use types::*;

    #[test]
    fn test_any_id() {
        use parser::any_id;
        assert!(any_id(b"foobar").is_done());
    }

    #[test]
    fn test_lower_id() {
        use parser::lower_id;
        assert!(lower_id(b"fOobAr").is_done());
        assert!(lower_id(b"Foobar").is_err());
    }

    #[test]
    fn test_upper_id() {
        use parser::upper_id;
        assert!(upper_id(b"FOobAr").is_done());
        assert!(upper_id(b"fOobAr").is_err());
    }

    #[test]
    fn test_primitive_type() {
        use self::Primitive::*;
        use parser::primitive_type;
        let mut res = vec![];
        let mut input = &b"bu+uu-i+ii-ff+ccf"[..];
        while let ::nom::IResult::Done(r, ty) = primitive_type(input) {
            res.push(ty);
            input = r;
        }
        assert_eq!(
            res,
            vec![
                Byte,
                UInt64,
                UInt32,
                UInt16,
                Int64,
                Int32,
                Int16,
                Float32,
                Float64,
            ]
        );
    }

    #[test]
    fn test_type_declaration() {
        use parser::type_declaration;
        let input = b"Chien:=#$Animale{}";

        if let ::nom::IResult::Done(_,
                                    Declaration::Type {
                                        id,
                                        unoverridable,
                                        extends,
                                        body,
                                    }) = type_declaration(input)
        {
            assert_eq!(id, "Chien".to_owned());
            assert_eq!(unoverridable, true);
            assert_eq!(extends, vec!["Animale".to_owned()]);
            assert_eq!(body, Box::new(vec![]));
        } else {
            panic!("savalasegfault ?")
        }
    }

    // TODO: add more tests
}