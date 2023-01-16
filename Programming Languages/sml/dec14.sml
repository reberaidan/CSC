(*lecture 1-5: ML advanced types*)

(* NEW TYPE: 'a option
This new type has two values

    NONE
    SOME x, where x is of type 'a

*)

(* 
Write a recursive function using pattern matching
with name and type

    optionsum : int option list -> int

inputs a list of int options and returns the sum of all intergers in
the list while ignoring all instances of NONE

*)

fun optionsum [] = 0 |
    optionsum ((SOME x)::xs) = x+optionsum(xs) |
    optionsum (NONE::xs) = optionsum(xs) ;

fun optionstr [] = "" |
    optionstr (SOME x::xs) = x^optionstr(xs) |
    optionstr (NONE::xs) = optionstr(xs);

fun optionbase [] = [] |
    optionbase ((SOME x)::xs) = x::optionbase(xs) |
    optionbase (NONE::xs) = optionbase(xs);

val x = SOME 4;

SOME(x)+0;
open String;