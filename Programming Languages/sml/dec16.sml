(* cont lecture 1.5*)

(*
The syntax to greate a custom data type is 

    datatype <typename> = <val1> | <val2> | ...

where each value can be a literal or a constructor of the form

    <constructor name> of <type>



*)

datatype color = blue | red | yellow;

blue;

datatype linkedlist = empty | node of int * linkedlist;

empty;

node(2,empty);
node(2,node(3,empty));

fun isEmpty empty = true |
    isEmpty (node(_,_)) = false;

isEmpty(it);

datatype bst = empty | node of int * bst * bst;

node(2,node(3,empty,empty),empty);

(*MAP
The built-in function map inputs a function and a list, and then returns the list after the function
has been applied to each element.
*)

val L = [2,3,5,7];
fun f(x) = x*x;

map f L;

fun g(x) = x-1;

map g L;

(*Use the built in function map to append "ed" to every string in the list
["lock", "fix","box"]
*)
val l = ["lock", "fix","box"];
fun s(x) = x^"ed";

map s l;

(*REDUCE
the built in reduce functions are foldl and foldr. The inputs are a two variable function an initiail value, ad a list
The output is the function applied to each value in the list continuously
starting with the initial value given.

*)
val L = [2,3,5,7];

fun myfun(cv,acc) = cv+acc;

myfun(4,5);

foldl myfun 0 L;
foldr myfun 0 L;

(* use one of the feduce function to concatenate all the stirng on a list
for example
    <foldl or foldr> <f> <IV> ["use","the","force"]
    
    *)
val s = ["use","the","force"];

fun sfun(cv,acc) = acc^cv;

foldl sfun "" s;

(* Use one of the reduce functions to multiply all of the integers on a list. For example
    [2,3,5,7];
    *)

val L = [2,3,5,7];

fun mfun(cv,acc) = acc*cv;

foldl mfun 1 L;

(*use one of the reduce functions to duplicate all the elements on a list
for example [2,3,5,7] goes to [2,2,3,3,5,5,7,7]
*)

fun dfun(cv,acc) = cv::cv::acc;

foldr dfun [] L;

fun dfun2(cv,acc) = acc@[cv,cv];

foldl dfun2 [] L;

(*
Exam 1: Monday, 19 Dec 2022

Sections 1.1-5

format
*)