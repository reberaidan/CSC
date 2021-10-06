
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class gameOfLife {
    private static int size; //size of the board
    private static int gen; //number of generations
    public static void main(String[] args)
    {
        //how many generations needed
        gen = (args.length == 0) ? 10 : Integer.parseInt(args[0]);

        //read teh file and store the inputs in the boolean array
        boolean[][] board= readFile();

        //play the game
        for(int i=0;i<gen;i++)
        {
            printBoard(board,i);
            board = computeNext(board);
        }
        
    }

    //read the file
    public static boolean[][] readFile()
    {
        int i = 0;
        //setting entire board to null
        boolean[][] board = null;
        try{
            //reads contents of the file
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line;

            while((line = br.readLine()) != null)
            {
                //initializes size at the start
                if(i==0)
                {
                    size = line.length();
                    board = new boolean[size][size];
                }
                //populates the board with values
                fillBoard(board,i,line);
                i++;
            }
            br.close();//closes reader
        }
        catch(Exception c){
            
        }
        return board;
    }

    public static void fillBoard(boolean[][] board, int row, String line){
        for(int i = 0; i <line.length();i++){
            board[row][i] = (line.charAt(i) == '*');// ? true : false; //tenrary operator  

        }
    }
    //compute the next generation
    public static boolean[][] computeNext(boolean[][] previous){
        //create a new board with the same dimensions as the previous one
        boolean[][] newboard = new boolean[previous.length][previous.length];
        //start at 1 to ignore border
        for(int i = 1; i<previous.length-1;i++){
            for(int j = 1;j<previous.length-1;j++){
                int neighbors = countNeighbors(previous,i,j);
                // apply the rules of the game
                if(previous[i][j]){
                    newboard[i][j] = (neighbors == 2 || neighbors ==3);
                }
                else{
                    newboard[i][j] = (neighbors == 3);
                }
            }
        }
        return newboard;
    }
    //counts the given cell's neighbors
    public static int countNeighbors(boolean[][] board, int a, int b){
        int neighbors = 0;

        for(int i = -1; i <=1; i++){
            for (int j = -1; j<=1; j++){
                if(!(i == 0 && j==0) && board[1+a][j+b]){
                    neighbors++;
                }
            }
        }
        return neighbors;
    }
    //print the board
    public static void printBoard(boolean[][] board, int gen){
        System.out.println("Generation " + gen);

        for(int i= 0; i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print((board[i][j] ? '*' : ' ')+ " ");
                
            }
            System.out.println();
        }
    }
}
