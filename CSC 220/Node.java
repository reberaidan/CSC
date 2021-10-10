public class Node {
    private int data;
    private Node link;

    public Node(){
        this.data = 0;
        this.link = null;
    }


    public int getData(){
        return this.data;
    }

    public void setData(int value){
        this.data = value;
    }

    public Node getLink(){
        return this.link;
    }

    public void setLink(Node n){
        this.link = n;
    }

}

class NodeTest
{
    public static void main(String[] args){
        /*Node head;
        Node curr;

        head = new Node();

        head.setData(17);

        curr = head;

        curr.setLink(new Node());
        curr = curr.getLink();
        curr.setData(10);

        curr.setLink(new Node());
        curr.getLink().setData(15);

        curr.getLink().setLink(new Node());
        curr.getLink().getLink().setData(32);

        curr = curr.getLink().getLink();

        Node newNode = new Node();
        curr.setLink(newNode);
        newNode.setData(72);

        Node p;
        Node q;

        p = curr;
        q = curr.getLink();

        Node newerNode = new Node();
        newerNode.setData(88);

        p.setLink(newerNode);
        newerNode.setLink(q);

        q.setLink(q.getLink());

        System.out.println("Head's data: " + head.getData());
        System.out.println("Head's link: " + head.getLink());

        System.out.println("Curr's data: " + curr.getData());
        System.out.println("Curr's link: " + curr.getLink());

        System.out.println("P's data: " + p.getData());
        System.out.println("Q's data: " + q.getData());

        System.out.print("List Contents: ");
        Traverse(head);*/
        BuildForward();
        //Traverse(head);
    }
    //build and populate a linked list using array elements
    public static void BuildForward(){
        Node first;
        Node last;
        Node curr;

        first = null;
        last = null;

        int[] num = {8,6,7,5,3,0,9,99};

        for(int i = 0; i <num.length; i ++){
            curr = new Node();
            curr.setData(num[i]);

            //if list is empty, then first and last are the same
            if(first == null)
            {
                first = curr;
                last = curr;
            }
            else{
                last.setLink(curr);
                last=curr;
            }
        }
        Traverse(first);
    }
    public static void Traverse(Node n){
        while(n !=null){
            System.out.print(n.getData()+ " ");

            n = n.getLink();
        
        }
        System.out.println();
    }
}
