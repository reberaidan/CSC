val infile = TextIO.openIn("text.txt");



(*makes val a string of whatever is in the file from the beginning to end of number*)
TextIO.inputN(infile, 3);
val i = TextIO.inputN(infile, 1);
TextIO.inputN(infile, 56);

TextIO.endOfStream(infile);


val infile2 = TextIO.openIn("text.txt");
TextIO.input1(infile2);
TextIO.input1(infile2);
TextIO.input1(infile2);
TextIO.input1(infile2);
TextIO.input1(infile2);
TextIO.input1(infile2);

val infile3 = TextIO.openIn("text.txt");

TextIO.inputLine(infile3);

TextIO.closeIn(infile);
TextIO.closeIn(infile2);
TextIO.closeIn(infile3);

(*file writing

NEW TYPE: outstream

NEW FUNCTIONS:

    TextIO.openOut : string -> outstream
        Inputs the name of a file and returns the 
        reference to the file for writing

    TextIO.openAppend : string -> outstream
        Inputs the name of a file and returns the 
        reference to the file for appending

    TextIO.closeOut : outstream -> unit
        Closes the output file by giving it the reference

    TextIO.output : outstream * stream -> unit

    TextIO.stdIn : instream
    TextIO.stdOut : outstream
*)

val out = TextIO.openAppend("output.txt");

TextIO.output(out, "printing output");

TextIO.closeOut(out);