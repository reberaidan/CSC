
import java.util.*;

public class Echo {
    
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        ArrayList<Integer> grades = new ArrayList<Integer>();

        while(s.hasNextInt()){
            grades.add(s.nextInt());
        }

        System.out.println("Done");

        //print contents of array
        for(int i : grades){
            System.out.print(i + " ");

        s.close();
        }
    }
}
