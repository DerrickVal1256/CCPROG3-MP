//import javafx.stage.Stage;
//
//import java.io.*;
//import java.util.*;
//import java.util.concurrent.atomic.AtomicBoolean;
//
///**
//* This class represents the main game logic.
//*/
//public class Game {
//        private Area CArea;
//        private Creatures CCreature;
//        private Inventory CPlayerInventory;
//        private Sound CSound;
//        private CreatureView CCreatureView;
//        private MenuView CMenuView;
//        private Stage FStage;
//
//    /**
//    * Constructs a new Game instance.
//    * @throws IOException if there is an error during the game initialization.
//    */
//    public Game(CreatureView CCreatureView, MenuView CMenuView, Stage FStage) throws IOException {
//        this.CCreature = new Creatures(new Reader(new FileReader("CreaturesList.txt")));
//        this.CPlayerInventory = new Inventory();
//        this.CSound = new Sound();
//        this.CCreatureView = CCreatureView;
//        this.CMenuView = CMenuView;
//        this.FStage = FStage;
//        this.gameHandlers();
//    }
//
////    public void startGame() throws Exception {
////        Scanner CScanner = new Scanner(System.in);
////        int nChoice = 0;
////        int nInvChoice = 0;
////        int nAreaChoice = 0;
////
////        while(!pickStarter(CPlayerInventory));
////        System.out.println();
////        this.CSound.play("PkmRS_Littleroot.wav");
////        do{
//////            CDisplay.mainMenu();
////            System.out.print("\t\t\tInput: ");
////            nChoice = CScanner.nextInt();
////            switch(nChoice){
////                case 1: // View Inventory
////                    nInvChoice = 0;
////                    CPlayerInventory.printInventory();
////                    System.out.println();
////                    if(CPlayerInventory.getInventory().size() > 1) {
////                        while(nInvChoice < 1 || nInvChoice > 2){
////                            System.out.println("\t\t\tWould you like to select a different creature?: ");
////                            System.out.println("\n\t\t\t   [1] Yes");
////                            System.out.println("\t\t\t   [2] No");
////                            System.out.println();
////                            System.out.print("\t\t\tInput: ");
////                            nInvChoice = CScanner.nextInt();
////
////                            if(nInvChoice == 1) {
////                                while(!CPlayerInventory.swapCreatures());
////                            } else {
////                                System.out.println("\n\t\t\t-- Input out of bounds! --\n");
////                            }
////                        }
////
////                    }
////                    break;
////                case 2: // Explore Area
////                    System.out.println();
////                    nAreaChoice = 0;
////
////                    while(nAreaChoice > 3 || nAreaChoice < 1) {
////                        CDisplay.areas();
////                        System.out.print("\t\t\tInput: ");
////                        nAreaChoice = CScanner.nextInt();
////
////                        if(nAreaChoice == 1  /* || nAreaChoice == 2 || nAreaChoice == 3 */) {  // for MCO2
////                            this.CArea = new Area("Area " + nAreaChoice);
////                            this.CSound.stop();
////                            exploreArea(nAreaChoice);
////                            this.CSound.play("PkmRS_Littleroot.wav");
////                        } else if(nAreaChoice == 2 || nAreaChoice == 3) {
////                            System.out.println("\n\n\t      -- This area will be added to the next Major Update! --\n\n");
////                        } else {
////                            System.out.println("   \n\t\t\t-- Invalid Choice! --\n");
////                        }
////                    }
////                    break;
////                case 3: // Evolve Creature (will be added in MC02)
////                    System.out.println("\n\n\t    -- This feature will be added to the next Major Update! --\n\n");
////                    break;
////                case 4: // Exit
////                    break;
////                default:
////                    System.out.println("   \n\t\t\t-- Invalid Choice! --\n");
////                    break;
////            }
////
////        } while(nChoice != 4);
////
////
////    }
//
//    /**
//    * Allows the player to explore an area.
//    * @param nAreaNum The number of the area to explore.
//    * @throws Exception if there is an error during the exploration.
//    */
//    public void exploreArea(int nAreaNum) throws Exception{
//        Scanner CScanner = new Scanner(System.in);
//        boolean bLeaveArea = false;
//        while(!bLeaveArea) {
//            CArea.printArea();
//            System.out.println();
////            this.CDisplay.movement();
//
//            System.out.print("\t\t\tInput: ");
//            int nMove = CScanner.nextInt();
//
//            System.out.println();
//            CArea.movePlayer(CPlayerInventory, nMove, nAreaNum, this.CSound);
//
//            if(nMove == 5) {
//                bLeaveArea = true;
//            }
//        }
//    }
//
//
//    public void gameHandlers() throws IOException {
//        this.creatureViewHandler();
//        this.menuViewHandler();
//    }
//    public void creatureViewHandler() throws IOException {
//        this.CCreatureView.getStarterButton1().setOnAction(event -> {
//            try {
//                this.CPlayerInventory.addCreature(CCreature.getCreatureMap().get("Strawander"));
//                this.FStage.setScene(CCreatureView.StarterAdded("Strawander"));
//                this.sleep();
//                this.CSound.play("PkmRS_Littleroot.wav");
//                this.FStage.setScene(CMenuView.mainMenu());
//            } catch (Exception exception) {
//                exception.printStackTrace();
//            }
//        });
//        this.CCreatureView.getStarterButton2().setOnAction(event -> {
//            try {
//                this.CPlayerInventory.addCreature(CCreature.getCreatureMap().get("Brownisaur"));
//                this.FStage.setScene(CCreatureView.StarterAdded("Brownisaur"));
//                this.sleep();
//                this.CSound.play("PkmRS_Littleroot.wav");
//                this.FStage.setScene(CMenuView.mainMenu());
//            } catch (Exception exception) {
//                exception.printStackTrace();
//            }
//        });
//        this.CCreatureView.getStarterButton3().setOnAction(event -> {
//            try {
//                this.CPlayerInventory.addCreature(CCreature.getCreatureMap().get("Squirpie"));
//                this.FStage.setScene(CCreatureView.StarterAdded("Squirpie"));
//                this.sleep();
//                this.CSound.play("PkmRS_Littleroot.wav");
//                this.FStage.setScene(CMenuView.mainMenu());
//            } catch (Exception exception) {
//                exception.printStackTrace();
//            }
//        });
//    }
//
//    public void menuViewHandler() throws IOException{
//        this.CMenuView.getViewInventoryButton().setOnAction(event -> {
//            System.out.println("hi");
//        });
//
//        this.CMenuView.getExploreAreaButton().setOnAction(event -> {
//
//        });
//
//        this.CMenuView.getEvolveCreatureButton().setOnAction(event -> {
//
//        });
//
//        this.CMenuView.getExitButton().setOnAction(event -> {
//            System.exit(0);
//        });
//    }
//
//    public void sleep() {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//}
