/* Lecture 2-2: Prolog Goals and Predicates

First we will trace through out first Star Wars
example to learn how prolog "executes programs"
aka satisfies goals
*/
parent(anakin,luke).
parent(anakin,leia).
parent(padme,luke).
parent(padme,leia).
parent(leia,ben).
parent(han,ben).
grandparent(X,Y) :- parent(X,Z),parent(Z,Y).

/* Recall the style of programming
    1. Declare facts (Lines 7 - 12)
    2. Define rules (Line 13)
    3. Ask questions, meaning we compile our code in the
        SWI interpreter and then type goals in the interpreter to see
        if they succeed or fail and what the results are.
    
*/

/*Ex. Compile the above code and trach thru the following goals
let's understand how prolog evaluates what we type into the interpreter.

?- parent(padme,leia).
    Prolog attempts to unify the foal with each line of code. This occurs at line 10...
    Success. Response is true.

?- parent(leia,A).
    Prolog successfully unifies with Line 11 and A is bound to ben, which
    is printed to the terminal. And then there are no more matches.

?- parent(A,ben).
    Prolog first successfully unifies with Line 11 and A is bound to leia, which is printed.
    The semi-colon forces a fail and then tries to unify again from where it left off. 
    This happens on Line 12 and A is bound to han, which
    is printed. Then there are no more matches.

Now lets look at this process when a rule is involved.

?- grandparent(A,ben).
    Prolog tries to unify this foal and the first and only match is Line 13.
    After unifying we get:

        grandparent(A,ben) :- parent(A,Z),parent(Z,ben).

    Prolog will try to satisfy the goal(s) on the right side of the :- ("pronounced if")
    from left to right. If the goal(s) on the right hand side succeed, then the goal before :- succeeds.

        (Line 7) parent(anakin,luke),parent(luke,ben)
                    true.               false.
        
            NOW BACKTRACKING: Prolog will now go back to the last successful goal and unify again for more possible matches, i.e
            parent(A,Z)

        (Line 8) parent(anakin,leia),parent(leia,ben)
                    true.               true.

                Then parent(leia,ben) is unified with Line 11.
                SUCCESS ON RIGHT SIDE. Prolog will output any instantiated variables that we asked for 
                in the goal weput into the interpreter:
                    A = anakin

                At the prompt we type ; to force a fail and backtrack.

        Line 9: parent(padme,luke),parent(luke,ben)
        but parent(luke,ben) fails. Backtrack

        Line 10: parent(padme,leia),parent(leia,ben)
        and SUCCESS. Output: A = padme. Then ; force fail and backtrack

        Line 11: parent(leia,ben),parent(ben,ben)
        and parent(ben,ben) fails. Then back

        Line 12: parent(han,ben), parent(ben,ben)
        and parent(ben,ben) fails

        there are no more matches. Technically, parent(Z,ben) has failed, and so the final response is false
*/

/* PREDICATES (analog to functions in ML)
Predicates are expression in prolog that evaluate to true or false.
We will first look at some built-in predicates and then practice writing our own predicates.

BUILT-IN PREDICATES

NAME: halt/0
    Exits the compiler.

NAME: consult/1
    loads a file into the compiler

NAME: write/1
    The argument is a prolog term and the predicate writes the terms to the 
    current output stream(the terminal).Always evaluates to true except on backtracking.

NAME: nl/0
    Writes a new line to the current output stream. Always evaluates to true except on backtracking.

NOTES: 
    -every predicate succeeds/evaluates to true or fails/evaluates to false.
    - you can use the write/1 and nl/0 predicates to debug code by displaying 
    variable biniding during code execution.

*/