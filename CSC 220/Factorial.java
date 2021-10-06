
import java.util.Scanner;
public class Factorial {
    
    
    public static void main(String[] args){

        Scanner myObj = new Scanner(System.in);
        int x = myObj.nextInt();
        //double result = whileLoop(x);
        //double result = forLoop(x);
        int result = recursionLoop(x);
        System.out.println(result);
        myObj.close();

    }

    static double whileLoop(int x){
        double fact= 1;
        while(x>0){
            if(x==0){
                fact = 1;
        }
            else{
                fact = fact*(x);
                System.out.println(fact);
                x--;
            }
        }
        return fact;
    }
    static double forLoop(int x){
        double fact = 1;
        for(int i = x;i>0;i--){
            fact = fact*x;
            x--;
        }
        return fact;
    }

    static int recursionLoop(int x){
        if(x==1){
            return 1;
        }
        else{
            return x*recursionLoop(x-1);
        }
    }
 }
    

