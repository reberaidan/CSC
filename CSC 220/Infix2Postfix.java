import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Infix2Postfix {
    

    public static void main(String[] args)throws FileNotFoundException{
        Queue<Queue<Character>> queues = new Queue<Queue<Character>>();
        
        //File inputfile = new File(args[0]);
        Scanner scan = new Scanner(System.in);

        while(scan.hasNextLine()){
            Queue<Character> exp = new Queue<Character>();
            String infix = scan.nextLine();
            for(int i = 0; i<infix.length();i++){
                exp.Enqueue(infix.charAt(i));
            }
            queues.Enqueue(exp);
        }

        while(!queues.IsEmpty()){
            Queue<Character> currQueue = queues.Dequeue();
            System.out.println(currQueue);
            System.out.println(toPostfix(currQueue));

        }



        scan.close();
    }

    public static Queue<Character> toPostfix(Queue<Character> infix){
        Queue<Character> postfixQ = new Queue<Character>();
        Stack<Character> operS = new Stack<Character>();

        while(infix.Size()!=0){
            Character token = infix.Dequeue();
            if(isOperand(token)){
                postfixQ.Enqueue(token);
            }
            else if(token == ')'){
                Character op = operS.Pop();
                while(op!='('){
                    postfixQ.Enqueue(op);
                    op = operS.Pop();
                }
            }
            else{
                Character op = operS.Peek();
                while(importance(op)>=importance(token)){
                    op = operS.Pop();
                    postfixQ.Enqueue(op);
                    op = operS.Peek();
                }
                operS.Push(token);
            }
        }
        while(operS.Size()!=0){
            Character op = operS.Pop();
            postfixQ.Enqueue(op);
        }

        return postfixQ;
    }

    public static boolean isOperand(Character operand){

        switch(operand){
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                return true;
        }
        return false;
    }

    public boolean isOperator(Character operator){

        switch(operator){
            case '+':
            case '-':
            case '*':
            case '/':
            case '^':
            case '(':
            case ')':
                return true;
        }
        return false;
    }

    static int importance(Character c){
        switch (c){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    //static double evalPostFix(Queue<Character> postFix){

        
        
    //}

    static double operations(int a, int b, Character op){

        switch(op){
            case '+':
                double d = a+b;
                return d;
            case '-':
                d = a-b;
                return d;
            case '*':
                d = a*b;
                return d;
            case '/':
                d = a/b;
                return d;
            case '^':
                d = Math.pow(a,b);
                return d;
            
        }
        return 0;
    }
}
