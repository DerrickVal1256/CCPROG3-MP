import java.io.*;
import java.util.*;

public class Area {
    private ArrayList<Integer> nDimensions;
    private Reader CAreaReader;
    private Reader CCreatureReader;
    private Creatures CCreatures;
    private String strNumArea;
    private char[][] cBoard;
    private int nPlayerRow;
    private int nPlayerCol;
    private Display CDisplay;

    public Area(String strNumArea) throws IOException{
        this.CAreaReader = new Reader(new FileReader("AreaDimensions.txt"));
        this.CCreatures = new Creatures(this.CCreatureReader);
        setNumArea(strNumArea);
        setDimensions();
        this.cBoard = new char[nDimensions.get(0)][nDimensions.get(1)];
        this.nPlayerRow = 0;
        this.nPlayerCol = 0;
        initializeArea();
        this.CDisplay = new Display();
    }

    private void initializeArea() {
        for(int i = 0; i < cBoard.length; i++) {
            for(int j = 0; j < cBoard[i].length; j++) {
                cBoard[i][j] = '.';
            }
        }
        cBoard[nPlayerRow][nPlayerCol] = 'P';
    }

    public void printArea() {
        // Print the top border
        System.out.print("\t\t\t");
        for(int i = 0; i < cBoard[0].length + 2; i++) {
            System.out.print("- ");
        }
        System.out.println();

        // Print the side borders
        System.out.print("\t\t\t");
        for(int i = 0; i < cBoard.length; i++) {
            System.out.print("| ");
            for(int j = 0; j < cBoard[i].length; j++) {
                System.out.print(cBoard[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.print("\t\t\t");
        // Print the bottom border
        for(int i = 0; i < cBoard[0].length + 2; i++) {
            System.out.print("- ");
        }
        System.out.println();
    }

    public void movePlayer(Inventory CPlayerInventory, int nPlayerMove) throws IOException{
        int nRow = nPlayerRow;
        int nCol = nPlayerCol;
        String randomCreature;

        switch(nPlayerMove){
            case 1: // UP
                nRow--;
                if(nRow >= 0) {
                    cBoard[nPlayerRow][nPlayerCol] = '.';
                    nPlayerRow = nRow;
                    cBoard[nPlayerRow][nPlayerCol] = 'P';
                    if(creatureSpawning()) {
                        randomCreature = CCreatures.randomCreature();
                        System.out.println("\t\t\tA wild " + randomCreature + " has appeared!");
                        battlePhase(CPlayerInventory, randomCreature);
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
                        randomCreature = CCreatures.randomCreature();
                        System.out.println("\t\t\tA wild " + randomCreature + " has appeared!");
                        battlePhase(CPlayerInventory, randomCreature);
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
                        randomCreature = CCreatures.randomCreature();
                        System.out.println("\t\t\tA wild " + randomCreature + " has appeared!");
                        battlePhase(CPlayerInventory, randomCreature);
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
                        randomCreature = CCreatures.randomCreature();
                        System.out.println("\t\t\tA wild " + randomCreature + " has appeared!");
                        battlePhase(CPlayerInventory, randomCreature);
                    }
                } else {
                    System.out.println("\t\t\t-- Invalid Move! --");
                }
                break;
        }
    }

    public void battlePhase(Inventory CPlayerInventory, String strCreature) throws IOException{
        Creatures CEnemy = this.CCreatures.getCreatureMap().get(strCreature);
        Creatures CPlayer = CPlayerInventory.getActive();
        Scanner CScanner = new Scanner(System.in);
        Random CRandom = new Random();
        int nSwapTo = 0;
        int nActions = 0;
        int nRandomNum = 0;
        int nChoice = 0;
        int nDamage = 0;
        int nHP = 50;
        double dCatchRate = 0.0;
        boolean bBattleEnded = false;
        boolean bCaught = false;

        do {
            System.out.println("\n\t\t\t" + strCreature);
            System.out.println("\t\t\tHP:" + nHP);
            System.out.println("\t\t\tType: " + CEnemy.getType() + "\n");
            this.CDisplay.battleMenu();
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
                    nActions++;
                    break;
                case 2: // Swap
                    CPlayerInventory.printInventory();
                    do{
                        System.out.print("\t\t\tInput: ");
                        nSwapTo = CScanner.nextInt() - 1;
                        if(nSwapTo > CPlayerInventory.getInventory().size()){
                            System.out.println("\t\t\t-- Invalid Index! -- ");
                        } else {
                            CPlayerInventory.activeCreature(nSwapTo);
                            System.out.println("\n\t\t\t" + CPlayerInventory.getActive().getName() + " is now active!");
                        }
                    } while(nSwapTo > CPlayerInventory.getInventory().size());
                    
                    break;
                case 3: // Catch
                    dCatchRate = (40 + 50 - nHP) * .100;
                    nRandomNum = CRandom.nextInt(10) + 1;
                    if(nRandomNum < dCatchRate) { // If random number is under the catch rate, then add the enemy creature to inventory
                        System.out.println("\n\t\t\t-- " + strCreature + " has been captured and added to your inventory! --");
                        bCaught = true;
                        CPlayerInventory.addCreature(CEnemy);
                    } else {
                        System.out.println("\n\t\t\t-- " + "Failed to capture " + strCreature + " --");
                    }
                    nActions++;
                    break;
                case 4: // Run Away
                    System.out.println("\t\t\t-- " + CPlayerInventory.getActive().getName() + " has fled! --");
                    break;
                default:
                    System.out.println("\t\t\t-- Invalid Move! --");
            }

            if(nActions == 3 && !bCaught) {
                System.out.println("\n\t\t\t-- " + strCreature + " has fled! --\n");
                bBattleEnded = true;
            } else if(nHP <= 0) {
                System.out.println("\t\t\t-- " + strCreature + " has died! --");
                bBattleEnded = true;
            } else if(bCaught) {
                bBattleEnded = true;
            }
        } while(!bBattleEnded);
    }

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

    private boolean creatureSpawning() {
        Random CRandom = new Random();
        int nRandomNum = CRandom.nextInt(10) + 1;
        if(nRandomNum < 4)
            return true;
        return false;
    }

    public void setNumArea(String strNumArea){
        this.strNumArea = strNumArea;
    }

    public String getNumArea() {
        return this.strNumArea;
    }

    public void setDimensions() throws IOException{
        this.nDimensions = CAreaReader.dimensionFileReader(this.strNumArea);
    }

    public ArrayList<Integer> getDimensions(){
        return this.nDimensions;
    }
    
}