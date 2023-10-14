import java.io.*;
import java.util.*;

public class Game {
        Area CArea; 
        Creatures Creature; 
        Inventory CPlayerInventory;   
        Display CDisplay;
        Sound CSound;
        

    public Game() throws IOException {
        this.CArea = new Area("Area 1"); // will get this from user chosen area
        this.Creature = new Creatures(new Reader(new FileReader("CreaturesList.txt")));
        this.CPlayerInventory = new Inventory();
        this.CDisplay = new Display();
        this.CSound = new Sound();
    }

    public void startGame() throws Exception {
        Scanner CScanner = new Scanner(System.in);
        int nChoice = 0;
        int nInvChoice = 0;

        this.CSound.play("PkmRS_Littleroot.wav");

        while(!pickStarter(CPlayerInventory));
        System.out.println();

        do{
            CDisplay.mainMenu();
            System.out.print("\t\t\tInput: ");
            nChoice = CScanner.nextInt();
            switch(nChoice){
                case 1: // View Inventory
                    CPlayerInventory.printInventory();
                    System.out.println();
                    if(CPlayerInventory.getInventory().size() > 1) {
                        System.out.println("\t\t\t Would you like to select a different creature?: ");
                        System.out.println("\n\t\t\t   [1] Yes");
                        System.out.println("\t\t\t   [2] No");
                        System.out.println();
                        System.out.print("\t\t\tInput: ");
                        nInvChoice = CScanner.nextInt();
                        if(nInvChoice == 1) {
                            while(!CPlayerInventory.swapCreatures());
                        } else if(nInvChoice > 2 && nInvChoice < 1) {
                            System.out.println("\t\t\t-- Input out of bounds! --");
                        }
                    }
                    break;
                case 2: // Explore Area
                    System.out.println();
                    this.CSound.stop();
                    exploreArea();
                    this.CSound.play("PkmRS_Littleroot.wav");
                    break;
                case 3: // Evolve Creature
                    System.out.println("\n\n\t\t\t-- This feature will be addded to the next Major Update! --\n\n");
                    break;
                case 4: // Exit
                    break;
                default:
                    System.out.println("\t\t\t-- Invalid Choice! --\n");
                    break;
            }

        } while(nChoice != 4);


    }

    public boolean pickStarter(Inventory CPlayerInventory) throws IOException {
        this.CDisplay.starterPokemon();
        System.out.print("\n\t\t\tInput: ");
        int nStarter = new Scanner(System.in).nextInt();

        switch(nStarter) {
            case 1:
                CPlayerInventory.addCreature(Creature.getCreatureMap().get("Strawander"));
                break;
            case 2:
                CPlayerInventory.addCreature(Creature.getCreatureMap().get("Brownisaur"));
                break;
            case 3:
                CPlayerInventory.addCreature(Creature.getCreatureMap().get("Squirpie"));
                break;
            default:
                System.out.println("\n\t\t\t-- Input out of bounds! --\n");
                return false;
        }
        
        return true;
    }

    public void exploreArea() throws Exception{
        Scanner CScanner = new Scanner(System.in);
        boolean bLeaveArea = false;
        while(!bLeaveArea) {
            CArea.printArea();
            System.out.println();
            this.CDisplay.movement();

            System.out.print("\t\t\tInput: ");
            int nMove = CScanner.nextInt();

            System.out.println();
            CArea.movePlayer(CPlayerInventory, nMove);

            if(nMove == 5) {
                bLeaveArea = true;
            }
        }
    }
}
