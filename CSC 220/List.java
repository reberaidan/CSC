/* ***************************************************
 * <your name>
 * <the date>
 * <the file name>
 *
 * <a simple, short program/class description>
 *************************************************** */

// the Node class
class Node
{
	private int data;
	private Node link;
	private int index;

	// constructor
	public Node()
	{
		this.data = -1;
		this.index = -1;
		this.link = null;
	}

	// accessor and mutator for the data component
	public int getData()
	{
		return this.data;
	}

	public void setData(int data)
	{
		this.data = data;
	}

	public int getIndex()
	{
		return this.index;
	}

	public void setIndex(int index)
	{
		this.index = index;
	}

	// accessor and mutator for the link component
	public Node getLink()
	{
		return this.link;
	}

	public void setLink(Node link)
	{
		this.link = link;
	}
}

// the List class
public class List
{
	public static final int MAX_SIZE = 50;

	private Node head;
	private Node tail;
	private Node curr;
	private int num_items;

	// constructor
	// remember that an empty list has a "size" of -1 and its "position" is at -1
	public List()
	{
		num_items= 0;
		this.head = this.curr = this.tail = new Node();
		
	}

	// copy constructor
	// clones the list l and sets the last element as the current
	public List(List l)
	{
		this.num_items = 0;
		this.head = this.curr = this.tail = new Node();
		int lCurr = l.GetPos();
		l.First();
		for(int i = 0; i <l.GetSize();i++){
			this.InsertAfter(l.GetValue());
			l.Next();
			
		}
		l.SetPos(lCurr);
		indexUpdater();
	}

	// navigates to the beginning of the list
	public void First()
	{
		if(!(this.IsEmpty())){
			this.curr = this.head;
		}
	}

	// navigates to the end of the list
	// the end of the list is at the last valid item in the list
	public void Last()
	{
		if(!(this.IsEmpty())){
			this.curr = this.tail;
		}
	}

	// navigates to the specified element (0-index)
	// this should not be possible for an empty list
	// this should not be possible for invalid positions
	public void SetPos(int pos)
	{
		if(!(this.IsEmpty())){
			if(pos>=0&&pos<this.tail.getIndex()+1){
				this.curr = this.head;
				for(int i =0; i <pos;i++){
					this.curr = this.curr.getLink();
				}
			}
		}

			
		
	}

	// navigates to the previous element
	// this should not be possible for an empty list
	// there should be no wrap-around
	public void Prev()
	{
		if(!(this.IsEmpty()||(this.curr == this.head))){
			this.SetPos(this.curr.getIndex()-1);
		}

	}

	// navigates to the next element
	// this should not be possible for an empty list
	// there should be no wrap-around
	public void Next()
	{
		if(!(this.IsEmpty()||(this.curr == this.tail))){
			this.curr = this.curr.getLink();
		}
	}

	// returns the location of the current element (or -1)
	public int GetPos()
	{
		return curr.getIndex();

	}

	// returns the value of the current element (or -1)
	public int GetValue()
	{
		return this.curr.getData();
	}

	// returns the size of the list
	// size does not imply capacity
	public int GetSize()
	{
		return this.num_items;
	}

	// inserts an item before the current element
	// the new element becomes the current
	// this should not be possible for a full list
	public void InsertBefore(int data)
	{
		if(!(this.IsFull())){
			if(!(this.IsEmpty())){
				
			
			
				if(this.curr == this.head){
					this.curr = new Node();
					this.curr.setLink(this.head);
					this.curr.setData(data);
					this.head = this.curr;
				}
				else{
					Node previous = this.head;
					for(int i = 0; i < this.curr.getIndex()-1;i++){
						previous = previous.getLink();
					}
					Node next = this.curr;
					this.curr = new Node();
					previous.setLink(this.curr);
					this.curr.setLink(next);
				}
			}
			this.num_items++;
			this.curr.setData(data);
			indexUpdater();
		}
	}

	// inserts an item after the current element
	// the new element becomes the current
	// this should not be possible for a full list
	public void InsertAfter(int data)
	{
		if(!this.IsFull()){
			if(this.IsEmpty()){
				this.num_items=1;
				this.head.setData(data);
				indexUpdater();
			}
			else{
				if(this.curr == this.tail){
					this.num_items++;
					this.curr = new Node();
					this.tail.setLink(this.curr);
					this.curr.setData(data);
					this.tail = this.curr;
					indexUpdater();
				}
				else{
					this.Next();
					this.InsertBefore(data);
				}
			}
		}

		
	}

	// removes the current element (collapsing the list)
	// this should not be possible for an empty list
	public void Remove()
	{
		if(!this.IsEmpty()){
			if(this.curr == this.head){
				if(this.head.getLink()!=null){
					this.curr = this.head.getLink();
					this.head = this.curr;
				}
				else{
					this.head.setIndex(-1);
				}
			}
			else{
				Node previous = this.head;
				for(int i = 0; i < this.curr.getIndex()-1;i++){
					previous = previous.getLink();
				}
				if(this.curr == this.tail){
					previous.setLink(null);
					this.curr = previous;
					this.tail = this.curr;
				}
				else{
					this.Next();
					previous.setLink(this.curr);
				}
				
			}
			this.num_items--;
				indexUpdater();
		}
	}

	// replaces the value of the current element with the specified value
	// this should not be possible for an empty list
	public void Replace(int data)
	{
		if(!IsEmpty()){
			this.curr.setData(data);
		}
	}

	// returns if the list is empty
	public boolean IsEmpty()
	{
		if(this.num_items == 0){
			return true;
		}
		else{
			return false;
		}
			
		
	}

	// returns if the list is full
	public boolean IsFull()
	{
		if(this.num_items == MAX_SIZE){
			return true;
		}
		else{
			return false;
		}
	}

	// returns if two lists are equal (by value)
	public boolean Equals(List l)
	{
		if(this.GetSize() == l.GetSize()){
			int lCurr = l.GetPos();
			int thisCurr = this.GetPos();

			l.First();
			this.First();
			
			for(int i =0; i<l.GetSize();i++){
				if(this.curr.getData() != l.GetValue()){
					l.SetPos(lCurr);
					this.SetPos(thisCurr);
					return false;
				}
				this.Next();
				l.Next();
			}
			l.SetPos(lCurr);
			this.SetPos(thisCurr);
			return true;

		}
		else{
			return false;
		}
	}

	// returns the concatenation of two lists
	// l should not be modified
	// l should be concatenated to the end of *this
	// the returned list should not exceed MAX_SIZE elements
	// the last element of the new list is the current
	public List Add(List l)
	{
		List k = new List(this);
		int lCurr = l.GetPos();
		k.Last();
		l.First();
		for(int i = 0; i <l.GetSize();i++){
			if(k.GetSize()<=MAX_SIZE){
				k.InsertAfter(l.GetValue());
				l.Next();
			}
			
		}
		l.SetPos(lCurr);
		return k;
		
	}

	// returns a string representation of the entire list (e.g., 1 2 3 4 5)
	// the string "NULL" should be returned for an empty list
	public String toString()
	{
		String s = " ";
		if(this.IsEmpty()){
			s+= "NULL";
		}
		else{
			Node temp = this.head;
			for(int i = 0; i <this.num_items; i++){
				s+= temp.getData();
				s+= " ";
				temp = temp.getLink();
			}
		}
		return s;
	}


private void indexUpdater(){
	Node temp = this.head;
	for(int i = 0; i <this.num_items; i++){
		temp.setIndex(i);
		temp = temp.getLink();
	}
}
}