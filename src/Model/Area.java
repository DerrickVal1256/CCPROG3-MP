package Model;
import java.io.*;
import java.util.*;

/**
 * This class represents an area in the game where the player can move and interact with creatures.
 * It maintains the state of the area, including dimensions, the current state of the board, and the player's position.
 */
public class Area {
    private String strNumArea;

    private List<CreatureEvo1> aCreatureList;

//    /**
//    * This constructor initializes a new area with a given number.
//    * @param strNumArea The number of the area.
//    * @throws IOException if there is an error reading the area dimensions or creature data.
//    */
    public Area(String strNumArea) {
        try {
            aCreatureList = new ArrayList<>();
            this.initializeCreatureList(strNumArea);
        } catch (IOException error) {
            error.printStackTrace();
        }

    }


//    /**
//    * This method handles the battle phase when a creature is encountered.
//    * It implements the logic for the player's actions, including attacking, swapping creatures,
//    * catching creatures, and running away. It also handles the creature's health,
//    * the possibility of the creature fleeing, and the end of the battle phase.
//    * @param CPlayerInventory The player's inventory.
//    * @param strCreature The name of the encountered creature.
//    * @param CSound The sound object used for playing sounds during the battle.
//    * @throws IOException if there is an error during the battle phase.
//    */
//    public void battlePhase(Inventory CPlayerInventory, String strCreature, Sound CSound) throws IOException{
//        CreatureEvo1 CEnemy = this.CCreatures.getCreatureMap().get(strCreature);
//        CreatureEvo1 CPlayer = CPlayerInventory.getActive();
//        Scanner CScanner = new Scanner(System.in);
//        Random CRandom = new Random();
//        int nActions = 0;
//        int nRandomNum = 0;
//        int nChoice = 0;
//        int nDamage = 0;
//        int nHP = 50;
//        double dCatchRate = 0.0;
//        boolean bBattleEnded = false;
//        boolean bCaught = false;
//        boolean bRan = false;
//        CSound.stop();
//        this.CSound.play("Trainer_Music.wav");
//        do
//        {
//            System.out.println("\n\t\t\tName: " + strCreature);
//            System.out.printf("\n\t\t\tHP: ");
//            printHPBar(nHP);
//            System.out.println("\t\t\tType: " + CEnemy.getType());
//            System.out.println("\t\t\tLevel: "+ CEnemy.getLevel() + "\n");
//            System.out.println("\n\t\t\tActive Creature: " + CPlayerInventory.getActive().getName());
//            System.out.println("\t\t\tType: "+ CPlayerInventory.getActive().getType());
//            System.out.println("\t\t\tLevel: "+ CPlayerInventory.getActive().getLevel() + "\n");
//            if(!bRan) {
//                bRan = true;
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//
////            this.CDisplay.battleMenu();
//            System.out.print("\n\t\t\tInput: ");
//            nChoice = CScanner.nextInt();
//            switch(nChoice) {
//                case 1: // Attack
//                    nRandomNum = CRandom.nextInt(10) + 1;
//                    if(isEnemyWeaker(CPlayer.getType(), CEnemy.getType())) {
//                        nDamage = (int)Math.round(nRandomNum * CPlayer.getLevel() * 1.5);
//                        nHP -= nDamage;
//                    } else {
//                        nDamage = nRandomNum * CPlayer.getLevel();
//                        nHP -= nDamage;
//                    }
//                    System.out.println("\n\t\t\t" + strCreature + " was hit for " + nDamage + " damage!");
//
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                    nActions++;
//                    break;
//                case 2: // Swap
////                    if(CPlayerInventory.getCreatures().size() != 1) {
////                        while(!CPlayerInventory.swapCreatures());
////                        nActions++;
////                    } else {
////                        System.out.println("\n\t\t\t-- You currently only have 1 creature in your inventory --\n");
////                        try {
////                        Thread.sleep(1000);
////                        } catch (InterruptedException e) {
////                            e.printStackTrace();
////                        }
////                    }
//                    break;
//                case 3: // Catch
//                    dCatchRate = (40 + 50 - nHP) * .100;
//                    nRandomNum = CRandom.nextInt(10) + 1;
//                    if(nRandomNum < dCatchRate) { // If random number is under the catch rate, then add the enemy creature to inventory
//                        this.CSound.stop();
//                        try {
//                            this.CSound.play("successful_catch.wav");
//                            Thread.sleep(1900);
//                            System.out.println("\n\t-- " + strCreature + " has been captured and added to your inventory! --\n");
//                            Thread.sleep(3000);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                        bCaught = true;
//                        CPlayerInventory.addCreature(CEnemy);
//                    } else {
//                        System.out.println("\n\t\t\t-- " + "Failed to capture " + strCreature + " --\n");
//                        try {
//                            Thread.sleep(1000);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                    nActions++;
//                    break;
//                case 4: // Run Away
//                    System.out.println("\n\t\t\t-- " + CPlayerInventory.getActive().getName() + " has fled! --\n");
//                    try {
//                    Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    bBattleEnded = true;
//                    break;
//                default:
//                    System.out.println("\n\t\t\t-- Invalid Move! --\n");
//            }
//
//            if(nHP <= 0) {
//                System.out.println("\n\t\t\t-- " + strCreature + " has fallen! --");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                bBattleEnded = true;
//            } else if(nActions == 3 && !bCaught) {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("\n\t\t\t   -- " + strCreature + " has fled! --\n");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                bBattleEnded = true;
//            } else if(bCaught) {
//                bBattleEnded = true;
//            }
//        } while(!bBattleEnded);
//        this.CSound.stop();
//    }

    public void initializeCreatureList(String strNumArea) throws IOException {
        Reader CReader = new Reader(new FileReader("CreaturesList.txt"));

        switch (strNumArea) {
            case "Area One" -> {
                this.aCreatureList.addAll(CReader.getMapCreatures1().values());
            }
            case "Area Two" -> {
                this.aCreatureList.addAll(CReader.getMapCreatures1().values());
                this.aCreatureList.addAll(CReader.getMapCreatures2().values());
            }
            case "Area Three" -> {
                this.aCreatureList.addAll(CReader.getMapCreatures1().values());
                this.aCreatureList.addAll(CReader.getMapCreatures2().values());
                this.aCreatureList.addAll(CReader.getMapCreatures3().values());
            }
        }
    }

    public CreatureEvo1 randomCreature() {
        // Choose a random creature from the list
        Random CRandom = new Random();
        int randomIndex = CRandom.nextInt(aCreatureList.size());
        return this.aCreatureList.get(randomIndex);
    }

    /**
    * This method decides if a creature will spawn based on a random number.
    * @return true if a creature should spawn, false otherwise.
    */
    public static boolean creatureSpawning() {
        Random CRandom = new Random();
        int nRandomNum = CRandom.nextInt(10) + 1;
        return nRandomNum < 4;
    }

    /**
    * This method prints a health bar for the player's creature based on its current HP.
    * @param nHP The current HP of the player's creature.
    */
    private void printHPBar(int nHP) {
        int i = 0;

        while(i < nHP) {
            System.out.print("|");
            i += 10;
        }

        System.out.println();
    }

    /**
    * This method sets the number of the area.
    * @param strNumArea The number to set for the area.
    */
    public void setNumArea(String strNumArea){
        this.strNumArea = strNumArea;
    }

    /**
    * This method gets the number of the area.
    * @return The number of the area.
    */
    public String getNumArea() {
        return this.strNumArea;
    }

    
}
