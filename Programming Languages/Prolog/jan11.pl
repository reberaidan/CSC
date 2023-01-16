/* Lecture 2-1: Prolog Unification

Recall terms in Prolog

    NUMBERS
    ATOMS
    VARIABLES
    COMPOUND TERMS

UNIFICATION
    Unificiation is the primary 'action'
    that prolog does when executing
    programs.

    the prolog infix operator for unification is =

    The prolog operator for 'and'
    is the comma

    The following is a description of how prolog unifies:

        - Two atoms unify if and only if
        they are (literally) the same

        - Two numbers unify iff
        they are the same

        - Two compound terms unify iff
        they have the smae functor, the 
        same arity, and their arguments
        unify pairwise (from left to right).

        - An unbound variables and a term that is 
        not a variable always unify, and the varibale is 
        unbound (instantiated) to that term
            Note: Scope ends at the period

        - Two unbound variables always unify and
        are bound to each other.

        - A bound variable is treated
        as the value to which
        it is bound.

        - Any other combination of terms
        fails to unify.
*/
/*
1. true.
2. false.wrong
true.
3. false.
4. false.
5. X = john,
    Y = mary
6. false.
7. false.
8. X = likes(john,mary).
9. X = john,
    Y = smith,
    Z = 27.
10. false.
11. wrongfalse.
(X = john,
Y = smith,
Z = dog(fido).
)
12. A=X,
    Y = smith,
    Z = 27.
13. A = X,
    X = john,
    B = mary
14. A = X,
    X = john,
    B = mary yes
15. false. yes
16. X = john. yes


*/

class(csc330,time(1400,1515)).
class(csc330,time(1100,1215)).

boy(alex).
boy(brandon).
girl(carla).
girl(denise).

couple(P,Q) :- boy(P), girl(Q).
