/* 
Comments in Prolog files are within slash-stars
*/

% this is also a comment

/*INTRO TO PROLOG

We will write a small intro artificial intellegence
program in Prolog so that we can ask it who are Ben
Solo's grandparents in Star Wars
*/

/*
Prolog is in the logic style of programming that 
consists of:
    1. Declare facts
    2. Define rules
    3. Ask questions
*/

parent(anakin,luke).

parent(anakin,leia).

parent(padme,luke).

parent(padme,leia).

parent(leia,ben).

parent(han,ben).

/* the previous lines of code are declaring facts*/

grandparent(X,Y) :- parent(X,Z),parent(Z,Y).

/* The previos line of code is defining a rule*/

/* The process of asking questions is handled through the compiler*/

/* compile: ['<filename.type>']*/

/*
BASIC SYNTAX AND COMMANDS FOR PROLOG

- every statement in prolog ends with .

- the command to start the swiprolog compiler from a 
    terminal is 

        swipl

- the command to quit is 

    halt.

the commands to load a .pl file into the compiler are:

    ['<filename>'].
    consult('<filename>').

- in prolog, terms are the funamental "building blocks"
for prolog programs. The TERMS in prolog are:

    NUMBERS

    ATOMS/CONSTANTS/LITERALS
        -sequence of letters, numbers, or underscores that 
        begin with a lowercase letter
        - sequence of character within single quotes
        -sequecne of special characters such as =, _, etc.

    VARIABLES
        -sequence of letters, numbers, or underscores that begin with an 
        uppercase letter

    COMPOUND TERMS have the form
        <atom>(<a sequence of terms separated by commas>)

    VOCABULARY:
    -the atom of a compund term is called a functor
    -the number of arguments inside the parentheses 
    of a compund terms is called its arity

    Ex. The compound term parent(han,ben)
    has functor parent and arity 2

    NOTATION: in written text, we reference a compund term as: 
    <functor>/<arity>.

Ex. Write a compound term named siblings/3 for jason's family

    sibings(jason,jacob,james).


*/

siblings(jason,james,jacob).

/*
RESERVED WORDS: true, false, fail, print
*/