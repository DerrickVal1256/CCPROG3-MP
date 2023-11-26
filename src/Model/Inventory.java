package Model;
import java.util.*;

/**
* This class represents the inventory of creatures that a player carries.
*/
public class Inventory {
    private ArrayList<CreatureEvo1> aInventoryList;

    /**
    * Constructs a new, empty Inventory.
    */
    public Inventory(){
        this.aInventoryList = new ArrayList<>();
    }

    /**
    * Adds a creature to the inventory.
    * @param CCreature The creature to add.
    * @return true if the creature was added successfully, false otherwise.
    */
    public boolean addCreature(CreatureEvo1 CCreature){
        if(aInventoryList.add(CCreature)) {
            if(aInventoryList.size() == 1) 
                aInventoryList.get(0).setStatus(true);
            return true;
        }
        return false;
    }

    public CreatureEvo1 getSpecificCreature(String strCreatureName) {
        for(CreatureEvo1 CCreature : this.aInventoryList) {
            if(CCreature.getName().equals(strCreatureName)) {
                return CCreature;
            }
        }
        return null;
    }

    /**
    * Sets a creature in the inventory to active.
    * @param nInput The index of the creature to activate.
    */
    public void activeCreature(int nInput){
        if(nInput >= 0 && nInput < aInventoryList.size()) {
            // Set the creature at the input index to active
            aInventoryList.get(nInput).setStatus(true);
            
            // Loop through the ArrayList
            for (int x = 0; x < aInventoryList.size(); x++) {
                // If the index is not equal to the input
                if (x != nInput) {
                    // Set the creature at this index to inactive
                    aInventoryList.get(x).setStatus(false);
                }
            }
        } 
    }

    /**
    * Returns the currently active creature.
    * @return The active creature, or null if no creature is active.
    */
    public CreatureEvo1 getActive() {
        for (CreatureEvo1 CCreature : aInventoryList) {
            if(CCreature.getStatus())
                return CCreature;
        }
        return null;
    }

    /**
    * Swaps the currently active creature with another creature in the inventory.
    * @return true if the swap was successful, false otherwise.
    */
    public boolean swapCreatures() {
        Scanner CScanner = new Scanner(System.in);
        printInventory();
        System.out.println();
        System.out.print("\t\t\tSelect your Creature: ");
        int nSwapTo = CScanner.nextInt();
        if(nSwapTo > aInventoryList.size() || nSwapTo <= 0){
            System.out.println("\t\t\t-- Invalid Index! -- ");
            return false;
        } else {
            activeCreature(nSwapTo - 1);
            System.out.println("\n\t\t\t" + getActive().getName() + " is now active!\n");
            return true;
        }
    }

    /**
    * Prints the creatures in the inventory.
    */
    public void printInventory(){
        int i = 1;
        sortInventory();
        System.out.println("\n\t\t\t\t     Inventory\n");
        System.out.println("\t\t\t+----+------------+-------+-------+");
        System.out.printf("\t\t\t| %-3s| %-10s | %-5s | %-5s |\n", "No.", "   Name", "Type", "Level");
        System.out.println("\t\t\t+----+------------+-------+-------+");
        for (CreatureEvo1 CCreature : aInventoryList) {
            if(CCreature.getStatus()){
                System.out.printf("\t\t\t| %-1s. | %-10s | %-5s | %-5s | <--- Current \n" , i++, CCreature.getName(), CCreature.getType(), "  " + CCreature.getLevel());
            } else {
                System.out.printf("\t\t\t| %-1s. | %-10s | %-5s | %-5s | \n" , i++, CCreature.getName(), CCreature.getType(), "  " + CCreature.getLevel());
            }
        }
        System.out.println("\t\t\t+----+------------+-------+-------+");
    }

    /**
    * Sorts the creatures in the inventory by level, type, and name.
    */
    private void sortInventory() {
        Comparator<CreatureEvo1> CCreaturesComparator = Comparator.comparing(CreatureEvo1::getLevel).thenComparing(CreatureEvo1::getType).thenComparing(CreatureEvo1::getName);
        Collections.sort(this.aInventoryList, CCreaturesComparator);
    }

    /**
    * Returns the list of creatures in the inventory.
    * @return The list of creatures.
    */
    public ArrayList<CreatureEvo1> getCreatures(){
        return this.aInventoryList;
    }


}
