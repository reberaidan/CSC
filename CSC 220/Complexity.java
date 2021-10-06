
public class Complexity {
    
    public static void main(String[] args){
        int runs = 0;
        int n = 20;
        int k = 1;
        do{
            int j = 1;
            do{
                runs++;
                System.out.println(runs);
                j*=3;
            }while(j<n);
            k++;

        }while(k<n);
        }
    }

