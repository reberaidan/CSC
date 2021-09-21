import java.util.Scanner;
public class getNumber {
    

    public static void main(String[] args){
        int num = getNum();
        System.out.println(num);
        
    }

    static int getNum(){
        System.out.println("Please enter a whole number.");
        Scanner myObj = new Scanner(System.in);
        int num = myObj.nextInt();
        num +=3;
        myObj.close();
        return num;
    }
}
