(*
Name: Aidan Weinreber
Date: 12/19/22
CSC 330 - 002
Winter Quarter
Exam 1, Part 2
*)

(*Problem 1 *)
fun fill (_,_,0) = [] |
    fill (x,s,n) = x::fill(x+s,s,n-1);



(*Problem 2 *)
fun h (cv:int,acc:int ) = if(cv >acc)
                then cv
                else acc;

foldl h 0 [2,8,5,1,7,6];