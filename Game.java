import java.io.*;
import java.util.*;

/**
* This class represents the main game logic.
*/
public class Game {
        Area CArea; 
        Creatures Creature; 
        Inventory CPlayerInventory;   
        Display CDisplay;
        Sound CSound;
        
    /**
    * Constructs a new Game instance.
    * @throws IOException if there is an error during the game initialization.
    */
    public Game() throws IOException {
        this.Creature = new Creatures(new Reader(new FileReader("CreaturesList.txt")));
        this.CPlayerInventory = new Inventory();
        this.CDisplay = new Display();
        this.CSound = new Sound();
    }

    /**
    * Starts the game and handles the main game loop.
    * @throws Exception if there is an error during the game.
    */
    public void startGame() throws Exception {
        Scanner CScanner = new Scanner(System.in);
        int nChoice = 0;
        int nInvChoice = 0;
        int nAreaChoice = 0;

        while(!pickStarter(CPlayerInventory));
        System.out.println();
        this.CSound.play("PkmRS_Littleroot.wav");
        do{
            CDisplay.mainMenu();
            System.out.print("\t\t\tInput: ");
            nChoice = CScanner.nextInt();
            switch(nChoice){
                case 1: // View Inventory
                    nInvChoice = 0;
                    CPlayerInventory.printInventory();
                    System.out.println();
                    if(CPlayerInventory.getInventory().size() > 1) {
                        while(nInvChoice < 1 || nInvChoice > 2){
                            System.out.println("\t\t\tWould you like to select a different creature?: ");
                            System.out.println("\n\t\t\t   [1] Yes");
                            System.out.println("\t\t\t   [2] No");
                            System.out.println();
                            System.out.print("\t\t\tInput: ");
                            nInvChoice = CScanner.nextInt();

                            if(nInvChoice == 1) {
                                while(!CPlayerInventory.swapCreatures());
                            } else {
                                System.out.println("\n\t\t\t-- Input out of bounds! --\n");
                            }
                        }
                        
                    }
                    break;
                case 2: // Explore Area
                    System.out.println();
                    nAreaChoice = 0;

                    while(nAreaChoice > 3 || nAreaChoice < 1) {
                        CDisplay.areas();
                        System.out.print("\t\t\tInput: ");
                        nAreaChoice = CScanner.nextInt();

                        if(nAreaChoice == 1  /* || nAreaChoice == 2 || nAreaChoice == 3 */) {  // for MCO2
                            this.CArea = new Area("Area " + nAreaChoice);
                            this.CSound.stop();
                            exploreArea(nAreaChoice);
                            this.CSound.play("PkmRS_Littleroot.wav");
                        } else if(nAreaChoice == 2 || nAreaChoice == 3) {
                            System.out.println("\n\n\t      -- This area will be addded to the next Major Update! --\n\n");
                        } else {
                            System.out.println("   \n\t\t\t-- Invalid Choice! --\n");
                        }
                    }
                    break;
                case 3: // Evolve Creature (will be added in MC02)
                    System.out.println("\n\n\t    -- This feature will be addded to the next Major Update! --\n\n");
                    break;
                case 4: // Exit
                    break;
                default:
                    System.out.println("   \n\t\t\t-- Invalid Choice! --\n");
                    break;
            }

        } while(nChoice != 4);


    }

    /**
    * Allows the player to pick a starter creature.
    * @param CPlayerInventory The player's inventory.
    * @return true if the player successfully picked a starter creature, false otherwise.
    * @throws IOException if there is an error during the creature selection.
    */
    public boolean pickStarter(Inventory CPlayerInventory) throws IOException {
        this.CDisplay.starterPokemon();
        System.out.print("\n\t\t\tInput: ");
        int nStarter = new Scanner(System.in).nextInt();

        switch(nStarter) {
            case 1:
                CPlayerInventory.addCreature(Creature.getCreatureMap().get("Strawander"));
                System.out.println("\n\n\t         -- Successfully added Strawander to your inventory! --\n");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                CPlayerInventory.addCreature(Creature.getCreatureMap().get("Brownisaur"));
                System.out.println("\n\n\t         -- Successfully added Brownisaur to your inventory! --\n");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                CPlayerInventory.addCreature(Creature.getCreatureMap().get("Squirpie"));
                System.out.println("\n\n\t         -- Successfully added Squirpie to your inventory! --\n");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("\n\t\t\t-- Input out of bounds! --\n");
                return false;
        }
        
        return true;
    }

    /**
    * Allows the player to explore an area.
    * @param nAreaNum The number of the area to explore.
    * @throws Exception if there is an error during the exploration.
    */
    public void exploreArea(int nAreaNum) throws Exception{
        Scanner CScanner = new Scanner(System.in);
        boolean bLeaveArea = false;
        while(!bLeaveArea) {
            CArea.printArea();
            System.out.println();
            this.CDisplay.movement();

            System.out.print("\t\t\tInput: ");
            int nMove = CScanner.nextInt();

            System.out.println();
            CArea.movePlayer(CPlayerInventory, nMove, nAreaNum, this.CSound);

            if(nMove == 5) {
                bLeaveArea = true;
            }
        }
    }
}
