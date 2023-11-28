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

    public CreatureEvo1 getNextInstanceOfCreature(String strCreatureName) {
        ArrayList<CreatureEvo1> aTemp = new ArrayList<>();
        for(CreatureEvo1 CCreature : this.aInventoryList) {
            if(CCreature.getName().equals(strCreatureName)) {
                aTemp.add(CCreature);
            }
        }
        return aTemp.get(aTemp.size() - 1);
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


    public void activeCreature(String strCreatureName, int nUniqueID) {
        boolean bSetActive = false;
        for(int i = 0; i < aInventoryList.size(); i++) {
            if(aInventoryList.get(i).getName().equals(strCreatureName) && aInventoryList.get(i).getUniqueID() == nUniqueID) {
                aInventoryList.get(i).setStatus(true);
                System.out.println("Setting to true: " + aInventoryList.get(i));
            } else if(aInventoryList.get(i).getStatus()) {
                aInventoryList.get(i).setStatus(false);
                System.out.println("Setting to false: " + aInventoryList.get(i));
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
//    public boolean swapCreatures(String strCreatureName) {
//        if(!getSpecificCreature(strCreatureName).getStatus()){
//            activeCreature(strCreatureName);
//            return true;
//        } else {
//            return false;
//        }
//    }

    /**
     * Prints the creatures in the inventory.
     */
    public void printInventory() {
        int i = 1;
        System.out.println("\n\t\t\t\t    Inventory\n");
        System.out.println("\t\t\t+----+------------+-------+-------+------------+");
        System.out.printf("\t\t\t| %-3s| %-10s | %-5s | %-5s | %-10s |\n", "No.", "  Name", "Type", "Level", "Unique ID");
        System.out.println("\t\t\t+----+------------+-------+-------+------------+");
        for (CreatureEvo1 CCreature : aInventoryList) {
            if (CCreature.getStatus()) {
                System.out.printf("\t\t\t| %-1s. | %-10s | %-5s | %-5s | %-10s | <--- Current \n", i++, CCreature.getName(), CCreature.getType(), " " + CCreature.getLevel(), CCreature.getUniqueID());
            } else {
                System.out.printf("\t\t\t| %-1s. | %-10s | %-5s | %-5s | %-10s | \n", i++, CCreature.getName(), CCreature.getType(), " " + CCreature.getLevel(), CCreature.getUniqueID());
            }
        }
        System.out.println("\t\t\t+----+------------+-------+-------+------------+");
    }

    /**
     * Sorts the CreatureEvo1 in the inventory by level, type, and name.
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

    public boolean removeCreature(CreatureEvo1 CCreature){
        return aInventoryList.remove(CCreature);
    }

}
