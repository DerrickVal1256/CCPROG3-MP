import java.io.*;
import java.util.*;

public class Game {
        Area Area; 
        Creatures Creature; 
        Inventory CPlayerInventory; 
        Map<String, Creatures> map; 
        Scanner CScanner; 
        boolean gameStart; 
        int nMove;
        Display CDisplay;
        

    public Game() throws IOException {
        this.Area = new Area("Area 1"); // will get this from user chosen area
        this.Creature = new Creatures(new Reader(new FileReader("CreaturesList.txt")));
        this.CPlayerInventory = new Inventory();
        this.CScanner = new Scanner(System.in);
        this.gameStart = true;
        this.CDisplay = new Display();
    }

    public void startGame() throws Exception {
        int nMove = 0;
        Sound MySound = new Sound("PkmRS_Littleroot.wav");
        MySound.play();
        pickStarter(CPlayerInventory);
        Area.printArea();

        while(gameStart) {
            System.out.print("\t\t\tInput: ");
            nMove = CScanner.nextInt();
            System.out.println();
            switch(nMove) {
                case 1:
                    Area.movePlayer(CPlayerInventory, nMove);
                    Area.printArea();
                    break;
                case 2:
                    Area.movePlayer(CPlayerInventory, nMove);
                    Area.printArea();
                    break;
                case 3:
                    Area.movePlayer(CPlayerInventory, nMove);
                    Area.printArea();
                    break;
                case 4:
                    Area.movePlayer(CPlayerInventory, nMove);
                    Area.printArea();
                    break;
                default:
                    System.out.println("-- Input out of bounds! --");
            }
        }
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
                System.out.println("-- Input out of bounds! --");
                return false;
        }
        return true;
    }
}
