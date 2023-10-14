import java.util.*;

public class Inventory {
    private ArrayList<Creatures> aInventoryList;

    public Inventory(){
        this.aInventoryList = new ArrayList<>();
    }

    public boolean addCreature(Creatures Creature){
        if(aInventoryList.add(Creature)) {
            if(aInventoryList.size() == 1) 
                aInventoryList.get(0).setStatus(true);
            return true;
        }
        return false;
    }

    public void activeCreature(int input){
        if(input >= 0 && input < aInventoryList.size()) {
            // Set the creature at the input index to active
            aInventoryList.get(input).setStatus(true);
            
            // Loop through the ArrayList
            for (int x = 0; x < aInventoryList.size(); x++) {
                // If the index is not equal to the input
                if (x != input) {
                    // Set the creature at this index to inactive
                    aInventoryList.get(x).setStatus(false);
                }
            }
        } else {
            System.out.println("\t\t\tInvalid index: " + input);
        }
    }

    public Creatures getActive() {
        for (Creatures CCreature : aInventoryList) {
            if(CCreature.getState())
                return CCreature;
        }
        return null;
    }

    public boolean swapCreatures() {
        Scanner CScanner = new Scanner(System.in);
        printInventory();
        System.out.println();
        System.out.print("\t\t\tSelect your Creature: ");
        int nSwapTo = CScanner.nextInt() - 1;
        if(nSwapTo > aInventoryList.size() || nSwapTo < 0){
            System.out.println("\t\t\t-- Invalid Index! -- ");
        } else {
            activeCreature(nSwapTo);
            System.out.println("\n\t\t\t" + getActive().getName() + " is now active!\n");
            return true;
        }
        return false;
    }

    public void printInventory(){
        int i = 1;
        System.out.println("\n\t\t\t\t     Inventory\n");
        System.out.println("\t\t\t+----+------------+-------+-------+");
        System.out.printf("\t\t\t| %-3s| %-10s | %-5s | %-5s |\n", "No.", "   Name", "Type", "Level");
        System.out.println("\t\t\t+----+------------+-------+-------+");
        for (Creatures CCreature : aInventoryList) {
            if(CCreature.getState()){
                System.out.printf("\t\t\t| %-1s. | %-10s | %-5s | %-5s | <--- Current \n" , i++, CCreature.getName(), CCreature.getType(), "  " + CCreature.getLevel());
            } else {
                System.out.printf("\t\t\t| %-1s. | %-10s | %-5s | %-5s | \n" , i++, CCreature.getName(), CCreature.getType(), "  " + CCreature.getLevel());
            }
        }
        System.out.println("\t\t\t+----+------------+-------+-------+");
    }

    public ArrayList<Creatures> getInventory(){
        return this.aInventoryList;
    }
}