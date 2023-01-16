(*Lecture 1-6 ML Input/Output*)

(*
New built in function

    print : string -> unit

        prints an input string to the terminal (side-effect) and returns unit(void)

*)
print("Hello world\n");

(* Ex. Write an ML function with name/type
    printchar : char -> unit

that will input a charcter, print the chracter to the terminal, and then return unit


*)
fun printchar x = print(str(x)^"\n");

printchar(#"X");


(*structures
a structure is a built-in 'library' that contains predefined functions we can import into the 
ML environment

    Int.toString : int -> string
    Bool.toString : bool -> string
    *)

Int.toString(13);
Bool.toString(false);

fun printint x = print(Int.toString(x)^"\n");

printint(13);

(*NEW RESERVED WORD

    open <structure name>

Load all of the structure's functions in the ML environment/stack
*)
open Int;

toString(4);
fromString("24 poo");
fromString("peepee");
fromString("1a2b3c4d")

(*New construct 

    (<exp1>; <exp2>; ...; <exp_n>)

Evaluates several expressions conseculatively. After evaluating all expression, the 
final result is the last expression.

NOTE: This construct is useful for debugging! You can add as many extra print
statements as needed in your code that do not return anything
*)

(*Ex. Write recursive ML function with pattern matching with name/type

    pbools : bool list -> unit

that inputs a list of bools, prints each to the terminal, and then returns unit.
 *)

fun pbools [] = () |   
    pbools (x::xs) = (
        print( Bool.toString(x) );
        print("\n");
        pbools(xs)
        );


pbools([false,true,false,false]);


(*FILE READING

NEW STRUCTURE: TextIO

NEW TYPE: instream

NEW LIBRARY FUNCTIONS:

    TextIO.openIn : string -> instream
        Opens a file for reading and returns a reference to access the file

    TextIO.closeIn : instream -> unit
        Closes a file that was used for reading and returns unit.

    TextIO.endOfStream : instream -> bool
        Checks whether or not we are at the end of a file and returns true or false

    TextIO.inputN : instream * int -> vector (string)
        Reads the next int number of characters from the instream and returns
        them as a string. The file is unchanged and the characters are 
        "consumed" from the instream

    TextIO.input : instream -> vector
        Reads the entire file and returns as a string

    TextIO.inputLine : instream -> string option
        Reads file one line at a time and returns it as a string option

    TextIO.input1 : instream -> elem (char) option
        Reads from a file one character at a time and returns it as char option

    TextIO.lookahead : instream -> char option
        Peeks at the nex character in the instream but does not consume it and
        returns it as char option
*)
TextIO.inputN(TextIO.openIn("a1.sml"),100);

TextIO.inputLine(TextIO.openIn("a1.sml"));

fun helper input = if TextIO.endOfStream(input)
                then SOME ""
                else TextIO.inputLine(input);

val inputFile = "testin.txt";
val inputPath = TextIO.openIn(inputFile);
print(valOf(helper(inputPath)));
TextIO.closeIn(inputPath);

Int.fromString("1234\n");