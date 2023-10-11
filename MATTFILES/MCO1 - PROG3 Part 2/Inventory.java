import java.util.*;

public class Inventory {
    private ArrayList<Creatures> aInventoryList;

    public Inventory(){
        this.aInventoryList = new ArrayList<>();
    }

    public boolean addCreature(Creatures Creature){
        if (aInventoryList.add(Creature))
            return true;
        return false;
    }

    public void activeCreature(int input){
        if(input >= 0 && input < aInventoryList.size()) {
            // Set the creature at the input index to active
            aInventoryList.get(input).setActive(true);
            
            // Loop through the ArrayList
            for (int x = 0; x < aInventoryList.size(); x++) {
                // If the index is not equal to the input
                if (x != input) {
                    // Set the creature at this index to inactive
                    aInventoryList.get(x).setActive(false);
                }
            }
        } else {
            System.out.println("Invalid index: " + input);
        }
    }

    public void printInventory(){
        for (Creatures creature : aInventoryList) {
            System.out.println(creature.toString());
        }
    }
}
