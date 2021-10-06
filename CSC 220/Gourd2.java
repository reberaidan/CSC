
//Aidan Weinreber
//Class CSC 220 H01
//imports scanner to get input
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Gourd2 {
       public static void main(String[] args)throws FileNotFoundException{
        // variables including the largest sum, and an array with a length of 400
        int largestSum = 0;
        int[] numbers = new int[400];
        int tempSum;

        File inputfile = new File(args[0]);
        Scanner scan = new Scanner(inputfile);
        
        //assigns given numbers to grid
        for(int i = 0; i < 400; i++){
            numbers[i] = scan.nextInt();
        }
        
        scan.close();
        
        //for loops to go through all viable coordinates
        for(int i = 0;i<17;i++){
            for(int j = 0;j<20;j++){
                //calls function to get current sum
                tempSum = sum(numbers, j,i);
                if(tempSum>largestSum){
                    largestSum = tempSum;
                }
            }
        }
        
        //output for the program
        System.out.println(largestSum);
        
    }
    //gets the sum for every four numbers in a vertical row
    public static int sum(int[] list, int col,int row){
        int currentSum = 0;
        currentSum = list[row*20 + col] + list[row*20 + col+20] + list[row*20 + col +(20*2)] + list[row*20 + col+(20*3)];
        //System.out.println(currentSum);
        return currentSum;
    }
}
