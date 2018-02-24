# sxlang

The official compiler for the Ŝlang language.

The current (Java) compiler is located at [java/](java/).

The old (Rust, uncomplete) compiler is located at [rust/](rust/).

# Usage

Compile your sxlang files into a native object file:
```
sxlang main.sx aux.sx
```

Then link the native object file into an executable file:
- On Windows (in a "VS2015 x64 Native Tools Command Prompt"):
```
link ucrt.lib msvcrt.lib Ws2_32.lib sxlang.o
```
- On Linux:
```
ld sxlang.o -lc
```

# Todo
- [ ] Class constructors
- [ ] Static initializers
- [ ] Dynamic dispatch
- [ ] Char literals
- [ ] String literals
- [ ] String literals unicode escapes
- [ ] Type inference
- [ ] Static array analysis -> alloca
- [ ] Generics
- [ ] Array slices
- [ ] Iterables
- [ ] Operator override

# Specification

Variable declaration
x :: <type> := _
Variable initialisation
x :: <type> := <expression>

Code block
{ }

Comments
//
/* */

Control flow
(expression) ? {} (expression) ?: {} : {}

Boucles
@ (expression) {}
@ <id> : <iterable> {}

Break, Continue, Return
Break: >, Break two loops: >>, ...
Continue: <, Continue two loops: <<, ...
Return: §

Functions
x := a i b i -> {
    
}
Method (not static)
x := a i b i ->% {
    
}
"this" is "%" (%.a corresponds to e.g. this.a in Java)

Allocation
Arrays: malloc (heap)
Classes: if final, no extends -> stack ; else heap
Everything else: stack

Parameters
By default: by pointer, including primitives.
Parameters may be shallow copied with ~a, deep copied with ~~a.

Primitives
b (1 byte)
i- (signed int 2 bytes), i (signed int 4 bytes), i+ (signed int 8 bytes)
u- (unsigned int 2 bytes), u (unsigned int 4 bytes), u+ (unsigned int 8 bytes)
f (float 4 bytes), f+ (float 8 bytes)

Arrays
e.g. i[]
Array initializer: <type>[<size> <value>] or <type>[el1, el2, ...]
<value> may be _ -> no initialization
i[3]
i[2..5] slice of array (not yet implemented)
i[..2], i[0..]
i[2..$-2]

Litterals
32 32i- 32i+ 32b 32u 32u- 32u+ 32.0f 32.45454f+
"ta m7re !qu swag \"\r\n \t \u200b \" \\ sava"

Immutability
All lvalues are immutable by default, except if specified with #, e.g. #x ::i := 5

Classes
<id> := ${
}
if final: <id> := #$ {}
extending a and b: <id> := a b{}

Interfaces
<id> := #${
    // only prototypes
    f := a i b i -> sava
}

Operators
+ ++ += - -- -= * *= / /= % %= [] <iter op>
may be overriden

EXAMPLE: "L'Algorithme D'Euclide"
```
f := a i b i -> i {
  b == 0 ? {
    § a
  } : {
    § f(b, a%b)   
  }
}
```
