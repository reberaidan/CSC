(*
Name: Aidan Weinreber
Date: 12/14/22
CSC 330 002
Winter Quarter
Assignment 1
*)

fun replace ([],_,_) = [] |
    replace (x::xs,y,z) = if(x=y) then z::replace(xs,y,z)
                                else x::replace(xs,y,z);

fun stringfun (s) = fn x => x^s;

fun avg (x:real list) =
    let
      fun sum ([]:real list) = 0.0 |
            sum(y::ys:real list) = y + sum(ys)
    in
      sum(x)/real(length(x))
    end;

