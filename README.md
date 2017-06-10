# sxlang

The official interpreter for the Ŝlang language. Written in Rust.

# Spécification de sxlang
```
Déclaration de variable
x := _
Initialisation de variable
x := <expression>

Blocs de code
{ }

Commentaires
//
/* */

Flux de contrôle
(expression booléenne) ? {} (expression booléenne) ?: {} : {}

Boucles
@ (expression booléenne) {}
@ <identifiant> : <iterable> {}

Break, Continue, Return
Break : >, Break deux boucles : >>, ...
Continue : <, Continuedeux boucles : <<, ...
Return : §

Fonctions
x := a i b i -> {
    
}
si c'est une méthode (pas statique) d'une classe :
x := a i b i ->% {
    
}
et dans ce cas le "this" est % : %.a correspond à this.a en Java

Allocation
Tableaux : taille compile time -> pile ; taille pas compile time
Classes : si final et hérite de rien -> pile ; sinon tas
Le reste : pile

Passage
Tout est passé par pointeur sauf les primitifs, mais on peut copy et clone avec ~a et ~~a. On peut clone et copy dans les paramètres de fonction, etc.

Primitifs
b (1 byte)
i- (signed int 2 bytes), i (signed int 4 bytes), i+ (signed int 8 bytes)
u- (unsigned int 2 bytes), u (unsigned int 4 bytes), u+ (unsigned int 8 bytes)
f (float 4 bytes), f+ (float 8 bytes)

Tableaux
Le type se note i[]
L'expression d'un tableau c'est [<taille> <valeur d'init>] ou [el1, el2, ...] pour l'init direct, on peut préciser le type avec type[...] par exemple i[5 3] ; i[3, 2, 3], et on peut ne pas init avec i[5 _]
i[3]
i[2..5] renvoie une portion du tableau (pas une copie)
i[..2], i[0..] valide
i[2..$-2] valide

Expressions littérales
32 32i- 32i+ 32b 32u 32u- 32u+ 32.0f 32.45454f+
Faire attention à 1f+ + 3

Chaînes de caractères 
"ta m7re !qu swag \"\r\n \t \u200b \" \\ sava"  sont des objets string

Immutabilité
Toutes les lvalue sont immutables, sauf contre-indiqué par #, e.g. #x := 5. L'immutabilité est transitive et valide pour toute la durée de vie du truc (pas seulement pour le scope).

Classes
<nom> = ${
}
si c final : <nom> := #$ {}
si on extend les interfaces truc et troc : <nom> := $truc troc{}

Interfaces
<nom> = #${
    // que des fonctions du style :
    f := a i b i -> sava
    // sava est le type de retour
}

Opérateurs
+ ++ += - -- -= * *= / /= % %= [] <opérateur itération>
peuvent être overridés

EXEMPLE: L'Algorithme D'Euclide

f := a i b i -> {
      b == 0 ? {
        § a
     } : {
        § f(b, a%b)   
    }
}
```