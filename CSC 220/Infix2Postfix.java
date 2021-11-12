public class Infix2Postfix {
    

    public static void main(String[] args){
        
    }

    public Queue<Character> toPostfix(Queue<Character> infix){
        Queue<Character> postfixQ = new Queue<Character>();
        Stack<Character> operS = new Stack<Character>();

        while(infix.Size()!=0){
            Character token = infix.Dequeue();
        }







        return postfixQ;
    }

    public boolean isOperand(Character operand){

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
}
