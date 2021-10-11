public class Generic {
    public static void main(String[] args){
        int[] x = {1,2,3,4,5};
        printArr(x);
    }    

    public static void printArr(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
