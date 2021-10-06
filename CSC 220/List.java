
/* ***************************************************
 * <your name>
 * <the date>
 * <the file name>
 *
 * <a simple, short program/class description>
 *************************************************** */


// the EasyList class
class List
{
	public static final int MAX_SIZE = 50;

	private int end;	// the index of the last valid item in the list
	private int curr;	// the index of the current item in the list
	private int[] list;	// the list

	// constructor
	// remember that an empty list has a "size" of -1 and its "position" is at -1
	public List()
	{
        this.list = new int[MAX_SIZE];
        this.end = this.curr = -1;
	}

	// copy constructor
	// clones the list l and sets the last element as the current
	public List(List l)
	{
		this.list = new int[MAX_SIZE];
		this.end = this.curr =-1;

		for(int i = 0;i<l.GetSize(); i++){
			this.InsertAfter(l.list[i]);
		}
	}

	// navigates to the beginning of the list
	public void First()
	{
		if(!this.IsEmpty()){
			this.curr=0;
		}
	}

	// navigates to the end of the list
	// the end of the list is at the last valid item in the list
	public void Last()
	{
		if(!this.IsEmpty()){
			this.curr= this.end;
		}
	}

	// navigates to the specified element (0-index)
	// this should not be possible for an empty list
	// this should not be possible for invalid positions
	public void SetPos(int pos)
	{
		if(!this.IsEmpty() && pos>=0 && pos<= this.end){
			this.curr = pos;
		}
	}

	// navigates to the previous element
	// this should not be possible for an empty list
	// there should be no wrap-around
	public void Prev()
	{
		if(this.curr != 0){
			this.curr--;
		}
	}

	// navigates to the next element
	// this should not be possible for an empty list
	// there should be no wrap-around
	public void Next()
	{
		if(!this.IsEmpty() && this.curr< this.end){
			this.curr++;
		}
	}

	// returns the location of the current element (or -1)
	public int GetPos()
	{
        return this.curr;
	}

	// returns the value of the current element (or -1)
	public int GetValue()
	{
        if(this.IsEmpty()){
            return -1;
        }
        else{
            return this.list[this.curr];
        }
	}

	// returns the size of the list
	// size does not imply capacity
	public int GetSize()
	{
        return (this.end +1);
	}

	// inserts an item before the current element
	// the new element becomes the current
	// this should not be possible for a full list
	public void InsertBefore(int data)
	{
		// make sure the list is not full
		if(!this.IsFull()){
			//check if list is empty
			if(this.IsEmpty()){
				this.curr++;
			}
			// otherwise shift items to the right
			else{
				for(int i = this.end; i >= this.curr; i--){
					this.list[i+1] = this.list[i];
				}
			}
			this.list[this.curr] = data;
			this.end++;
		}
	}

	// inserts an item after the current element
	// the new element becomes the current
	// this should not be possible for a full list
	public void InsertAfter(int data)
	{
		if(!this.IsFull()){
			if(this.curr == this.end){
				this.curr++;
				this.list[this.curr] = data;
				this.end++;
			}
			else{
				this.Next();
				this.InsertBefore(data);
			}
				
			
		}
		
	}

	// removes the current element (collapsing the list)
	// this should not be possible for an empty list
	public void Remove()
	{
		if(!this.IsEmpty()){
			if(this.curr ==this.end){
				this.curr -= 1;

			}
			else{
				for(int i = this.curr; i< this.end; i++){
					this.list[i] = this.list[i+1];
				}
			}
			this.end--;

		}
	}

	// replaces the value of the current element with the specified value
	// this should not be possible for an empty list
	public void Replace(int data)
	{
		if(!this.IsEmpty()){
			this.list[this.curr] = data;
		}
	}

	// returns if the list is empty
	public boolean IsEmpty()
	{
        if(this.end == -1){
            return true;
        }
        else{
            return false;
        }
    }

	// returns if the list is full
	public boolean IsFull()
	{
        return (this.end +1 == MAX_SIZE);
	}

	// returns if two lists are equal (by value)
	public boolean Equals(List l)
	{
		boolean IsEquals = true;
		if(l.end !=  this.end){
			IsEquals = false;
		}
        if(IsEquals){for(int i = 0; i<MAX_SIZE;i++){
			
			if(this.list[i] == l.list[i] && IsEquals){
				IsEquals = true;
			}
			else{
				IsEquals = false;
			}
		}}
		return IsEquals;
	}

	// returns the concatenation of two lists
	// l should not be modified
	// l should be concatenated to the end of *this
	// the returned list should not exceed MAX_SIZE elements
	// the last element of the new list is the current
	public List Add(List l)
	{
        List t = new List(this);

		for(int i = 0; i <l.GetSize(); i++){
			t.InsertAfter(l.list[i]);
		}
		return t;
	}

	// returns a string representation of the entire list (e.g., 1 2 3 4 5)
	// the string "NULL" should be returned for an empty list
	public String toString()
	{
        if(IsEmpty()){
            return "NULL";
        }
        else{
            String s = "";
            for(int i = 0;i<this.GetSize();i++){
                s+= this.list[i] + " ";
            }
            return s;
        }
        
	}
}