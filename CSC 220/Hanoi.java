public class Hanoi {
    

    public static void main(String[] args){
        tower(3,"A","C","B");
    }

    static void tower(int disks, String src, String dest, String spr){
        if(disks==1){
            System.out.println(src + "->" + dest);
        }
        else{
            tower(disks - 1, src,spr,dest);
            tower(1,src,dest,spr);
            tower(disks-1,spr,dest,src);
        }
    }
}