class Generic {
    public static void main(String[] args){
        Integer[] x = {1,2,3,4,5};
        printArr(x);

        Double[] y = {1.1, 2.2, 3.3, 4.4, 5.5};
        printArr(y);

        String[] z = {"this", "shit", "important", "stop", "sleeping"};
        printArr(z);
    }    

    public static <mT> void printArr(mT[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
