
import java.util.Scanner;

public class Infix2Postfix{

    static int importance(char c){
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


    static String infixToPostFix(String expression){

        String result = "";
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i <expression.length() ; i++) {
            char c = expression.charAt(i);

            //check if char is operator
            if(importance(c)>0){
                while(stack.IsEmpty()==false && importance(stack.Peek())>=importance(c)){
                    result += stack.Pop();
                }
                stack.Push(c);
            }else if(c==')'){
                char x = stack.Pop();
                while(x!='('){
                    result += x;
                    x = stack.Pop();
                }
            
            }else if(c=='('){
                stack.Push(c);
            }else{
                //if character is not an operator, then its a operand 
                result += c;
            }
        }
        for (int i = 0; i <=stack.Size() ; i++) {
            result += stack.Pop();
        }
        
        //collapsing(stack);
        return result;
    }
    
    public static void main(String[] args){

        String exp = "((((((9-9))))))";

        String postfix = infixToPostFix(exp);
        System.out.println(exp);
        System.out.println(postfix);
        System.out.println(evalPostfix(postfix));
        


    }

    // Function to evaluate a given postfix expression
    public static int evalPostfix(String exp)
    {
        // base case
        if (exp == null || exp.length() == 0) {
            System.exit(-1);
        }
 
        // create an empty stack
        Stack<Integer> stack = new Stack<>();
 
        // traverse the given expression
        for (char c: exp.toCharArray())
        {
            // if the current character is an operand, push it into the stack
            if (Character.isDigit(c)) {
                stack.Push(c - '0');
            }
            // if the current character is an operator
            else {
                // remove the top two elements from the stack
                int x = stack.Pop();
                int y = stack.Pop();
 
                // evaluate the expression 'x op y', and push the
                // result back to the stack
                if (c == '+') {
                    stack.Push(y + x);
                }
                else if (c == '-') {
                    stack.Push(y - x);
                }
                else if (c == '*') {
                    stack.Push(y * x);
                }
                else if (c == '/') {
                    stack.Push(y / x);
                }
                else if(c == '^'){
                    Double temp = Math.pow(y,x);
                    stack.Push(temp.intValue());
                }
            }
        }
 
        // At this point, the stack is left with only one element, i.e.,
        // expression result
        return stack.Pop();
    }

    
}


