(* Lecture 1-3: ML Functions*)

(* Syntax to create functions in ML

    fun <identifier> <parameter(s):T1> = <expression:T2>

The name and type of this function will be 
    <identifer> : T1 -> T2
*)

fun fun1 x = x+1;

fun f2 x = x*x;

(* Write a function with name/type
    rsquare : real -> real
    that inputs a real number and returns its square

*)
fun rsquare x:real = x*x;


(*
    Write function with name/type
    toUpper : char -> char
that capitalizes a lower case character
*)

fun toUpper x = chr(ord(x)-32);