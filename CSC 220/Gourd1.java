
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
public class Gourd1 {
    private static DecimalFormat df = new DecimalFormat("0.00");
    
    //instantiation of variables
    static int first;
    static int[] amountDigs = new int[10];
    static boolean numbers = false;
    public static void main(String[] args)throws FileNotFoundException{
        //setting entire board to null
        ArrayList<Integer> nums = new ArrayList<Integer>();
        int tempInt;
        File file = new File(args[0]);

        Scanner scan = new Scanner(file);

        while(scan.hasNextInt()){
            tempInt = scan.nextInt();
            nums.add(tempInt);
        }
        scan.close();
        //processes each number in the array
        for(int i : nums){
            numbers = true;
            if(i>9){
                first = firstDigit(i);
                amountDigs[first]++;
            }
            else{
                first = i;
                amountDigs[first]++;
            }
        
        }
        //Displays ending table
        printTable(amountDigs);

    }

    //finds the first digit in the number
    public static int firstDigit(int num){
        while(num>9){
            num/=10;
        }
        return num;
    }
    //Displays the table
    public static void printTable(int[] leadingDigs){
        //if no numbers are input, then the total sum of percentages will be zero
        double totalSum = 0.00;
        //if there is at least one number in the array, then the total percentage will be 100
        if(numbers){
            totalSum = 100.00;
        }
        //header
        System.out.println("-----------------------------------\nLeading Digit   Count\t\t%\n---------------------------------");
        
        // for loop to add all of the values
        for(int i = 0; i<10; i++){
            System.out.print(i + "\t\t" + leadingDigs[i] + "\t    "+ df.format(average(leadingDigs,i))+ "%");
            System.out.println("");
        }

        //footer
        System.out.println("----------------------------------\nTOTAL\t\t" +sum(leadingDigs) +  "\t    " + totalSum + "%\n==================================");
    }
    //finds the percent amount of times the number occurs
    public static float average(int[] amount, int a){
        float total = 0;
        float average = 0;
        for (int i = 0;i<amount.length;i++){
            total +=amount[i];
        }
        average = amount[a]/total;
        average*=100;
        return average;
    }
    // gives the total sum of numbers in the array
    public static int sum(int[] amount){
        int total = 0;
        for (int i = 0;i<amount.length;i++){
            total +=amount[i];
        }
        return total;
    }
}
