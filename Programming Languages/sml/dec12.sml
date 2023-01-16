(* Lecture 1-4: ML Recursion

In ML, loops are frowned upon. That's a 
procedurual system, not functional

Ex. Write our own length function using recursion

*)

fun myLength1 L = if L = [] then 0
                    else 1 + myLength1(tl(L));
(*
''a means that you are using comparison operator and
 that is only allowed for certain types

There is a built in function to test 
for an empty list

    null : 'a list -> int

*)

fun myLength2 L = if null(L) then 0
        else 1 + myLength2(tl(L));

(* NEW CONSTRUCT: Pattern Matching
This is a better way to define functions
on lists in ML

    fun <identifier> <pattern1> = <exp1>
        | <identifier> <pattern2> = <exp2>
        ...
        | <identifier> <pattern_n> = <exp_n>

Allowed <patterns> are constants/literals or expressions with ::
*)

fun myLength3 [] = 0 | myLength3 (x::xs) = 1 + myLength3(xs);

(* The wild card symbol in ml is the underscore
it is used when the value of a variable is not 
needed/anonymous.

*)

fun myLength4 [] = 0 | myLength4 (_::xs) = 1 + myLength3(xs);

(* NEW CONSTRUCT: case
Plays the role of switch and has the form

    case <expression> of <match>

Then <match> will have the firm

    <pattern1> => <exp1> | <pattern2> => 
    <exp2> | ... | <pattern_n> => <exp_n>

This is just an alternate to pattern match
*)

fun myLength5 L = case L of [] => 0 | (_::xs) => 1 + myLength5(xs);

(* write a recursvie ML function using pattern matching that inputs a list 
integers and returns the sum of all integers in the list*)

fun sum [] = 0 | sum (x::xs) = x + sum(xs);

fun fact 0 = 1 | fact x = x * fact(x-1);

(* Ex. Write a recursive ML function with pattern matching named sum2
that inputs an (int*int) list and returns the sum of all integers in the list 


 *)

fun sum2 [] = 0 | sum2 ((x,y)::xs) = x + y + sum2(xs);

(* NEW CONSTRUCT: and
Allows you to do more than one declaration
simultaneously.

*)

(* Ex. Write multually recursive functions 
with pattern matching named isOdd and isEven
that inputs a nonnegative integer
and returns the correct bool value. For example,
    - isOdd(0);
    return false
    - isEven(4);
    returns true

*)

fun isOdd 0 = false | isOdd(x) = isEven(x-1) 
and 
    isEven 0 = true | isEven x = isOdd(x-1);


(*NEW CONSTRUCT
    let <declarations> in <exp> end
Allows temporary value/function declarations that can be used in 
<exp>. This construct evaluates to <exp>
*)

(*
Write a funtion that inputs a real numer that returns the 50th pwer.
We do not recommend f(x) = x*x*x*x*.....
*)

fun pow50(x:real) = 
    let
      val y = x*x*x*x*x (* y = x^5*)
      val z = y*y*y*y*y (*z = x^25*)
    in
      z*z
    end;

(*
Ex. Write a recursive function using pattern matching that 
inputs a 2-tuple: an int list and an int. It shall return
the position of the first occurance of the int value on the list
Assume a starting index of one. If the value is not on the list, 
return the length of the list + 1

    - linSearch([2,3,5,7], 7);
    val it = 4 : int
    - linSearch([2,3,5,7],9);
    fal in = 5 : int

*)

fun linSearch ([],_) = 1 | linSearch (x::xs,y) = if (x=y) then 1
                                    else 1 + linSearch(xs,y);


(* To "save" data in a functional programming language
we need only an extra argument/helper functions. Let's
demonstrate by saving the number of elements in the list 
in case the search fails 

*)

fun helper ([],_,l) = ~l - 1 |
    helper (x::xs,y,l) = if (x=y)
                        then 1
                        else 1 + helper(xs,y,l);

fun linSearch2 (L,y) = helper(L,y,length(L));

(* 
Ex. Write a recursive function using pattern matching using name/type

    sortedMerge : int list * int list -> int list

    imports two sorted lists and returns thier combined lists sorted

    sortedMerge([2,3,5,7],[4,5,6]);
    [2,3,4,5,5,6,7]


NEW CONSTRUCT: as
Allows you to use an identifier or parts of an indentifier in
an expression
*)

fun sortedMerge2 ([],[]) = [] |
    sortedMerge2 (x::xs,y::ys) = if (x>y) then y::sortedMerge(x::xs,ys)
                                        else x::sortedMerge(xs,y::ys);


fun sortedMerge (A,[]) = A |
    sortedMerge ([],B) = B |
    sortedMerge (A as x::xs,B as y::ys) = if (x<y) then x::sortedMerge(xs,B)
                                                    else y::sortedMerge(A,ys);