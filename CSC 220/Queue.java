//===============================
//= Name: Aidan Weinreber
//= Date: 10/28/21
//= Description: implements the idea of a queue using the list class
//================================

public class Queue<mT> {
    
    private List<mT> k;

    //constructor
    public Queue(){
        k = new List<mT>();

    }

    //copy constructor
    public Queue(Queue<mT> s){

        k = new List<mT>(s.k);
        this.k.First();
    }

    //enqueue
    public void Enqueue(mT data){
        this.k.Last();
        this.k.InsertAfter(data);
    }

    //peek
    public mT Peek(){
        this.k.First();
        return this.k.GetValue();
    }

    //dequeue; takes the first item off
    public mT Dequeue(){
        mT d = Peek();
        this.k.Remove();

        return d;
    }
    //size
    public int Size(){
        return this.k.GetSize();
    }

    //checks is full
    public boolean IsFull(){
        return this.k.IsFull();
    }

    //checks is empty
    public boolean IsEmpty(){
        return this.k.IsEmpty();
    }

    //checks if equal
    public boolean Equals(Queue<mT> q){
        return this.k.Equals(q.k);
    }


    //concatenates two queues
    public Queue<mT> Add(Queue<mT> q){
        Queue<mT> q1 = new Queue<mT>(this);

        q1.k = q1.k.Add(q.k);
        this.k.First();

        return q1;
    }

    //string result
    public String toString(){
        return this.k.toString();
    }

}
