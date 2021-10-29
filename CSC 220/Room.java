import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//main game class; creates the rooms and runs the main game.
class mainGame {
    
    //establish the rooms outside of the create rooms function because main game loop could not reference them there
    static Room currRoom;
    static Room room1 = new Room("Entrance");
    static Room room2 = new Room("Living Room");
    static Room room3 = new Room("Kitchen");
    public static Player you = new Player();

    //main game loop
    public static void main(String[] args){

        Scanner s = new Scanner(System.in);
        boolean gameRunning = true;
        createRooms();
        while(gameRunning){
            System.out.println("=========================");
            System.out.println(currRoom.status());
            System.out.println("press enter");
            s.nextLine();
            System.out.println(currRoom.grabItem("keys", you));
            //System.out.println(room1.items[0].getDescription()); how to look at an item
            break;
        }
        s.close();
        death();
    }

    //instantiates the rooms and populates the rooms with items/observables/exits
    static void createRooms(){
        

        Item keys = new Item("keys","It's the keys to the front door.");
        Item sunglasses = new Item("sunglasses","A cool pair of aviator for a bright day");
        room1.addItem(keys);

        
        room1.addItem(sunglasses);

        

        currRoom = room1;


    }

    //when the game ends without a win, it prints out a death image
    static void death(){
        System.out.println(" ".repeat(17) + "u".repeat(7));
        System.out.println(" ".repeat(13) + "u".repeat(2) + "$".repeat(11) + "u".repeat(2));
        System.out.println(" ".repeat(10) + "u".repeat(2) + "$".repeat(17) + "u".repeat(2));
        System.out.println(" ".repeat(9) + "u" + "$".repeat(21) + "u");
        System.out.println(" ".repeat(8) + "u" + "$".repeat(23) + "u");
        System.out.println(" ".repeat(7) + "u" + "$".repeat(25) + "u");
        System.out.println(" ".repeat(7) + "u" + "$".repeat(25) + "u");
        System.out.println(" ".repeat(7) + "u" + "$".repeat(6) + "\"" + " ".repeat(3) + "\"" + "$".repeat(3) +"\"" + " ".repeat(3) + "\"" + "$".repeat(6) + "u");
        System.out.println(" ".repeat(7) + "\"" + "$".repeat(4) + "\"" + " ".repeat(6) + "u$u" + " ".repeat(7) + "$".repeat(4) + "\"");
        System.out.println(" ".repeat(8) + "$".repeat(3) + "u" + " ".repeat(7) + "u$u" + " ".repeat(7) + "u" +"$".repeat(3));
        System.out.println(" ".repeat(8) + "$".repeat(3) + "u" + " ".repeat(6) + "u" + "$".repeat(3) + "u" + " ".repeat(6) + "u" + "$".repeat(3));
        System.out.println(" ".repeat(9) + "\"" + "$".repeat(4) + "u".repeat(2) + "$".repeat(3) + " ".repeat(3) +"$".repeat(3) + "u".repeat(2) + "$".repeat(4) + "\"");
        System.out.println(" ".repeat(10) + "\"" + "$".repeat(7) + "\"" + " ".repeat(3) + "\"" + "$".repeat(7)+ "\"");
        System.out.println(" ".repeat(12) + "u" + "$".repeat(7) + "u" + "$".repeat(7) + "u");
        System.out.println(" ".repeat(13) + "u$\"$\"$\"$\"$\"$\"$u");
        System.out.println(" ".repeat(2) + "u".repeat(3) + " ".repeat(8) + "$".repeat(2) + "u$ $ $ $ $u" + "$".repeat(2) + " ".repeat(7) + "u".repeat(3));
        System.out.println(" u" + "$".repeat(4) + " ".repeat(8) + "$".repeat(5) + "u$u$u" + "$".repeat(3) + " ".repeat(7) + "u" + "$".repeat(4));
        System.out.println(" ".repeat(2) + "$".repeat(5) + "u".repeat(2) + " ".repeat(6) + "\"" + "$".repeat(9) +"\"" + " ".repeat(5) + "u".repeat(2)+ "$".repeat(6));
        System.out.println("u" + "$".repeat(11) + "u".repeat(2) + " ".repeat(4) + "\"".repeat(5) + " ".repeat(4) +"u".repeat(4) + "$".repeat(10));
        System.out.println("$".repeat(4) + "\"".repeat(3) + "$".repeat(10) + "u".repeat(3) + " ".repeat(3) + "u".repeat(2)+ "$".repeat(9) + "\"".repeat(3) + "$".repeat(3) + "\"");
        System.out.println(" " + "\"".repeat(3) + " ".repeat(6) + "\"".repeat(2) + "$".repeat(11) + "u".repeat(2) +" " + "\"".repeat(2) + "$" + "\"".repeat(3));
        System.out.println(" ".repeat(11) + "u".repeat(4) + " \"\"" + "$".repeat(10) + "u".repeat(3));
        System.out.println(" ".repeat(2) + "u" + "$".repeat(3) + "u".repeat(3) + "$".repeat(9) + "u".repeat(2) +" \"\"" + "$".repeat(11) + "u".repeat(3) + "$".repeat(3));
        System.out.println(" ".repeat(2) + "$".repeat(10) + "\"".repeat(4) + " ".repeat(11) + "\"\"" + "$".repeat(11) + "\"");
        System.out.println(" ".repeat(3) + "\"" + "$".repeat(5) + "\"" + " ".repeat(22) + "\"\"" + "$".repeat(4) + "\"\"");
        System.out.println(" ".repeat(5) + "$".repeat(3) + "\"" + " ".repeat(25) + "$".repeat(4) + "\"");
    }
}

//room class; has items, exits, furniture/observables
public class Room{
    private String name;
    private int[] exits;
    Item[] items = new Item[100];
    private int numberItems = 0;
    private int MAX_ITEMS = 50;
    public Room(String name){
        this.exits = null;
        this.name = name;

    }

    public void addItem(Item object){
        if(!this.IsFull()){
            this.items[this.numberItems] = object;
            this.numberItems++;
        }
        else{
            System.out.println("The room is too full");
        }
    }

    public void removeItem(int place){
        this.items[place] = null;
        this.numberItems--;
        
    }


    public String grabItem(String object, Player player){
        String response = "";
        for(int i = 0; i<numberItems;i++){
            if(object == items[i].getName()){
                player.addInv(this.items[i]);

                this.removeItem(i);

                
                response = "Item picked up.";
                break;
            }
            else{
                response = "Can't find that item.";
            }
        }
        return response;
        
    }

    private String visibleItems() {
        String s = "";
        if(this.items!=null){
            for(int i = 0; i <numberItems;i++){
                s+= this.items[i].getName() + ", ";
                
            }
        }
        else{
            s+= "Nothing";
        }
        return s;
    }

    public void addExit(){

    }

    public String status(){
        
        String s = "You are currently in the "+ this.toString();
        s += "\nYou see: " + this.visibleItems();


        return s;
    }

    

    public boolean IsFull(){
        if(this.numberItems >= MAX_ITEMS){
            return true;
        }
        else{
            return false;
        }
    }
    public String toString(){
        return this.name;
    }

}

class Item{
    private String name;
    private String desc;

    public Item(String title, String description){
        this.name = title;
        this.desc = description;

    }

    public String getDescription(){
        return this.desc;
    }

    public String getName(){
        return this.name;
    }
}

class Player{

    Item inventory[] = new Item[10];
    int MAX_INV = 10;
    int currInv = 0;

    public Player(){

    }

    public void addInv(Item object){
        if(!this.IsFull()){
            this.inventory[this.currInv] = object;
            this.currInv++;
        }
        else{
            System.out.println("Your inventory is too full");
        }
    }

    public void removeItem(int place){
        this.inventory[place] = null;
        this.currInv--;
        
        Item temp;
        System.out.println("Strings in sorted order:");
        for (int j = 0; j < this.inventory.length; j++) {
            for (int i = j + 1; i < this.inventory.length; i++) {
                // comparing adjacent strings
                if (inventory[i].getName().compareTo(inventory[j].getName()) < 0) {
                    temp = inventory[j];
                    inventory[j] = inventory[i];
                    inventory[i] = temp;
                }
        }
        System.out.println(inventory[j]);
    }}

    public boolean IsFull(){
        if(this.currInv >= MAX_INV){
            return true;
        }
        else{
            return false;
        }
    }

}
