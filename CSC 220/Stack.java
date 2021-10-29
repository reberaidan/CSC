//===============================
//= Name: Aidan Weinreber
//= Date: 10/28/21
//= Description: implements the idea of a stack using the list class
//================================
public class Stack<mT> {
    
    private List<mT> k;
    //constructor
    public Stack(){
        k = new List<mT>();
    }
    //copy constructor
    public Stack(Stack<mT> s){

        k = new List<mT>(s.k);
        this.k.First();
    }

    //push
    public void Push(mT data){
        this.k.InsertBefore(data);
    }

    //peek
    public mT Peek(){
        this.k.First();
        return this.k.GetValue();

    }


    //pop
    public mT Pop(){
        mT d = Peek();
        this.k.Remove();

        return d;
    }

    //size
    public int Size(){

        return this.k.GetSize();
    }

    public boolean IsFull(){
        return this.k.IsFull();
    }

    public boolean IsEmpty(){
        return this.k.IsEmpty();
    }

    public boolean Equals(Stack<mT> s){
        return this.k.Equals(s.k);
    }

    public Stack<mT> Add(Stack<mT> s){
        Stack<mT> s1 = new Stack<mT>(this);

        s1.k = s1.k.Add(s.k);
        this.k.First();

        return s1;
    }

    public String toString(){
        return this.k.toString();
    }
}
