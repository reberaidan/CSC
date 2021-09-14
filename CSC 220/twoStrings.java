import java.util.Scanner;

public class twoStrings {
    
    public static void main(String[] args){
        System.out.println("Write a word.");
        Scanner myObj = new Scanner(System.in);
        String x = myObj.nextLine();
        System.out.println("Write another word.");
        String y = myObj.nextLine();
        String s = getString(x,y);
        System.out.println(s);

    }

    static String getString(String x,String y){
        String s = x+" " +y+"!";
        return s;
    }
}
