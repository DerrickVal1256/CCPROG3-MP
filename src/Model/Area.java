package Model;
import java.io.*;
import java.util.*;

/**
 * This class represents an area in the game where the player can move and interact with creatures.
 * It maintains the state of the area, including dimensions, the current state of the board, and the player's position.
 */
public class Area {
    private ArrayList<Integer> nDimensions;
    private Reader CAreaReader;
    private Reader CCreatureReader;
    private Creatures CCreatures;
    private String strNumArea;
    private char[][] cBoard;
    private int nPlayerRow;
    private int nPlayerCol;
//    private MenuView CDisplay;
    private Sound CSound;

    /**
    * This constructor initializes a new area with a given number.
    * @param strNumArea The number of the area.
    * @throws IOException if there is an error reading the area dimensions or creature data.
    */
    public Area(String strNumArea) throws IOException{
        this.CAreaReader = new Reader(new FileReader("AreaDimensions.txt"));
//        this.CCreatures = new Creatures(this.CCreatureReader);
        this.setNumArea(strNumArea);
        this.setDimensions();
        this.cBoard = new char[nDimensions.get(0)][nDimensions.get(1)];
        this.nPlayerRow = 0;
        this.nPlayerCol = 0;
        this.initializeArea();
        this.CSound = new Sound();
    }

    /**
    * This method initializes the area by setting all positions to '.', except the player's position, which is set to 'P'.
    */
    private void initializeArea() {
        for(int i = 0; i < cBoard.length; i++) {
            for(int j = 0; j < cBoard[i].length; j++) {
                cBoard[i][j] = '.';
            }
        }
        cBoard[nPlayerRow][nPlayerCol] = 'P';
    }

    /**
    * This method prints the current state of the area to the console.
    */
    public void printArea() {
        // Print the top border
        System.out.print("\t\t\t    ");
        for(int i = 0; i < cBoard[0].length + 2; i++) {
            System.out.print("- ");
        }
        System.out.println();

        // Print the side borders
        for(int i = 0; i < cBoard.length; i++) {
            System.out.print("\t\t\t    | ");
            for(int j = 0; j < cBoard[i].length; j++) {
                System.out.print(cBoard[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.print("\t\t\t    ");
        // Print the bottom border
        for(int i = 0; i < cBoard[0].length + 2; i++) {
            System.out.print("- ");
        }
        System.out.println();
    }

    /**
     * This method moves the player in the area according to a given move and potentially triggers a battle with a creature.
     * @param CPlayerInventory The player's inventory.
     * @param nPlayerMove The move to make (1: UP, 2: DOWN, 3: LEFT, 4: RIGHT).
     * @param nAreaNum The number assigned to the area
     * @param CSound The sound utility class to play sounds
     * @throws IOException if there is an error during the battle phase.
     */
    public void movePlayer(Inventory CPlayerInventory, int nPlayerMove, int nAreaNum, Sound CSound) throws IOException{
        int nRow = nPlayerRow;
        int nCol = nPlayerCol;
        String randomCreature;

        if(CSound.getClip().getFramePosition() == 0)
            CSound.play("Model/PkmRS_Littleroot.wav");

        switch(nPlayerMove){
            case 1: // UP
                nRow--;
                if(nRow >= 0) {
                    cBoard[nPlayerRow][nPlayerCol] = '.';
                    nPlayerRow = nRow;
                    cBoard[nPlayerRow][nPlayerCol] = 'P';
                    if(creatureSpawning()) {
                        randomCreature = CCreatures.randomCreature(nAreaNum);
                        System.out.println("\t\t\tA wild " + randomCreature + " has appeared!");
                        battlePhase(CPlayerInventory, randomCreature, CSound);
                    }
                } else {
                    System.out.println("\t\t\t-- Invalid Move! --");
                }

                break;
            case 2: // DOWN
                nRow++;
                if(nRow < nDimensions.get(0)) {
                    cBoard[nPlayerRow][nPlayerCol] = '.';
                    nPlayerRow = nRow;
                    cBoard[nPlayerRow][nPlayerCol] = 'P';
                    if(creatureSpawning()) {
                        randomCreature = CCreatures.randomCreature(nAreaNum);
                        System.out.println("\t\t\tA wild " + randomCreature + " has appeared!");
                        battlePhase(CPlayerInventory, randomCreature, CSound);
                    }
                } else {
                    System.out.println("\t\t\t-- Invalid Move! --");
                }
                break;
            case 3: // LEFT
                nCol--;
                if(nCol >= 0) {
                    cBoard[nPlayerRow][nPlayerCol] = '.';
                    nPlayerCol = nCol;
                    cBoard[nPlayerRow][nPlayerCol] = 'P';
                    if(creatureSpawning()) {
                        randomCreature = CCreatures.randomCreature(nAreaNum);
                        System.out.println("\t\t\tA wild " + randomCreature + " has appeared!");
                        battlePhase(CPlayerInventory, randomCreature, CSound);
                    }
                } else {
                    System.out.println("\t\t\t-- Invalid Move! --");
                }
                break;
            case 4: // RIGHT
                nCol++;
                if(nCol < nDimensions.get(1)) {
                    cBoard[nPlayerRow][nPlayerCol] = '.';
                    nPlayerCol = nCol;
                    cBoard[nPlayerRow][nPlayerCol] = 'P';
                    if(creatureSpawning()) {
                        randomCreature = CCreatures.randomCreature(nAreaNum);
                        System.out.println("\t\t\tA wild " + randomCreature + " has appeared!");
                        battlePhase(CPlayerInventory, randomCreature, CSound);
                    }
                } else {
                    System.out.println("\t\t\t-- Invalid Move! --");
                }
                break;
            case 5: // LEAVE
                cBoard[nPlayerRow][nPlayerCol] = '.';
                nPlayerCol = 0;
                nPlayerRow = 0;
                cBoard[nPlayerRow][nPlayerCol] = 'P';
                break;
            default: // OUT OF BOUNDS
                System.out.println("\t\t\t-- Input out of bounds! -- ");
                break;
        }
    }

    /**
    * This method handles the battle phase when a creature is encountered.
    * It implements the logic for the player's actions, including attacking, swapping creatures, 
    * catching creatures, and running away. It also handles the creature's health, 
    * the possibility of the creature fleeing, and the end of the battle phase.
    * @param CPlayerInventory The player's inventory.
    * @param strCreature The name of the encountered creature.
    * @param CSound The sound object used for playing sounds during the battle.
    * @throws IOException if there is an error during the battle phase.
    */
    public void battlePhase(Inventory CPlayerInventory, String strCreature, Sound CSound) throws IOException{
        Creatures CEnemy = this.CCreatures.getCreatureMap().get(strCreature);
        Creatures CPlayer = CPlayerInventory.getActive();
        Scanner CScanner = new Scanner(System.in);
        Random CRandom = new Random();
        int nActions = 0;
        int nRandomNum = 0;
        int nChoice = 0;
        int nDamage = 0;
        int nHP = 50;
        double dCatchRate = 0.0;
        boolean bBattleEnded = false;
        boolean bCaught = false;
        boolean bRan = false;
        CSound.stop();
        this.CSound.play("Trainer_Music.wav");
        do 
        {
            System.out.println("\n\t\t\tName: " + strCreature);
            System.out.printf("\n\t\t\tHP: ");
            printHPBar(nHP);
            System.out.println("\t\t\tType: " + CEnemy.getType());
            System.out.println("\t\t\tLevel: "+ CEnemy.getLevel() + "\n");
            System.out.println("\n\t\t\tActive Creature: " + CPlayerInventory.getActive().getName());
            System.out.println("\t\t\tType: "+ CPlayerInventory.getActive().getType());
            System.out.println("\t\t\tLevel: "+ CPlayerInventory.getActive().getLevel() + "\n");
            if(!bRan) {
                bRan = true;
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            
//            this.CDisplay.battleMenu();
            System.out.print("\n\t\t\tInput: ");
            nChoice = CScanner.nextInt();
            switch(nChoice) {
                case 1: // Attack
                    nRandomNum = CRandom.nextInt(10) + 1;
                    if(isEnemyWeaker(CPlayer.getType(), CEnemy.getType())) {
                        nDamage = (int)Math.round(nRandomNum * CPlayer.getLevel() * 1.5);
                        nHP -= nDamage;
                    } else {
                        nDamage = nRandomNum * CPlayer.getLevel();
                        nHP -= nDamage;
                    }
                    System.out.println("\n\t\t\t" + strCreature + " was hit for " + nDamage + " damage!");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    nActions++;
                    break;
                case 2: // Swap
                    if(CPlayerInventory.getCreatures().size() != 1) {
                        while(!CPlayerInventory.swapCreatures());
                        nActions++;
                    } else {
                        System.out.println("\n\t\t\t-- You currently only have 1 creature in your inventory --\n");
                        try {
                        Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3: // Catch
                    dCatchRate = (40 + 50 - nHP) * .100;
                    nRandomNum = CRandom.nextInt(10) + 1;
                    if(nRandomNum < dCatchRate) { // If random number is under the catch rate, then add the enemy creature to inventory
                        this.CSound.stop();
                        try {
                            this.CSound.play("successful_catch.wav");
                            Thread.sleep(1900);
                            System.out.println("\n\t-- " + strCreature + " has been captured and added to your inventory! --\n");
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        bCaught = true;
                        CPlayerInventory.addCreature(CEnemy);
                    } else {
                        System.out.println("\n\t\t\t-- " + "Failed to capture " + strCreature + " --\n");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    nActions++;
                    break;
                case 4: // Run Away
                    System.out.println("\n\t\t\t-- " + CPlayerInventory.getActive().getName() + " has fled! --\n");
                    try {
                    Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    bBattleEnded = true;
                    break;
                default:
                    System.out.println("\n\t\t\t-- Invalid Move! --\n");
            }

            if(nHP <= 0) {
                System.out.println("\n\t\t\t-- " + strCreature + " has fallen! --");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                bBattleEnded = true;
            } else if(nActions == 3 && !bCaught) { 
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("\n\t\t\t   -- " + strCreature + " has fled! --\n");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                bBattleEnded = true;
            } else if(bCaught) {
                bBattleEnded = true;
            }
        } while(!bBattleEnded);
        this.CSound.stop();
    }

   /**
    * This method determines if the player's creature is stronger than the enemy creature based on their types.
    * @param strPlayerType The type of the player's creature.
    * @param strEnemyType The type of the enemy creature.
    * @return true if the player's creature is stronger, false otherwise.
    */
    private boolean isEnemyWeaker(String strPlayerType, String strEnemyType) {
        switch(strPlayerType) {
            case "Fire":
                if(strEnemyType.equals("Grass"))
                    return true;
            case "Grass":
                if(strEnemyType.equals("Water")) 
                    return true;
            case "Water":
                if(strEnemyType.equals("Fire")) 
                    return true;
        }
        return false;
    }

    /**
    * This method decides if a creature will spawn based on a random number.
    * @return true if a creature should spawn, false otherwise.
    */
    private boolean creatureSpawning() {
        Random CRandom = new Random();
        int nRandomNum = CRandom.nextInt(10) + 1;
        if(nRandomNum < 4)
            return true;
        return false;
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

    /**
    * This method sets the dimensions of the area based on the area number.
    * @throws IOException if there is an error reading the dimensions file.
    */
    public void setDimensions() throws IOException{
        this.nDimensions = CAreaReader.dimensionFileReader(this.strNumArea);
    }

    /**
    * This method gets the dimensions of the area.
    * @return The dimensions of the area.
    */
    public ArrayList<Integer> getDimensions(){
        return this.nDimensions;
    }
    
}
