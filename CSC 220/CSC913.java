import java.util.Scanner;
public class CSC913 {
    

    public static void main(String[] args){
        int num = getNumber();
        System.out.println(num);
        
    }

    static int getNumber(){
        System.out.println("Please enter a whole number.");
        Scanner myObj = new Scanner(System.in);
        int num = myObj.nextInt();
        num +=3;
        return num;
    }
}
