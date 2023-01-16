(*
Name: Aidan Weinreber
Date: 1/9/22
CSC-330-002
Winter Quarter
Assignment 2
*)



(* strip function takes input and output file, feeds the instream to a helper funtion
and its contents are written to the output file.*)
fun strip (inFile, outFile) = let
                                val input = TextIO.openIn(inFile)
                                val out = TextIO.openOut(outFile)
                              in
                                TextIO.output(out,helper(input));
                                TextIO.closeOut(out);
                                TextIO.closeIn(input)
                              end;


(*helper funciton that takes in instream and filters through lines with only integers.
Helper function checks to see if the input is at the end of the file, otherwise it will
evaluate whether to keep the text or not.
*)
fun helper input = if TextIO.endOfStream(input)
                  then ""
                  else let
                        val x = TextIO.inputLine(input)
                      in
                        if(Int.fromString(valOf(x)) = NONE)
                        then "" ^ helper(input)
                        else (valOf(x) ^ helper(input))
                      end;
