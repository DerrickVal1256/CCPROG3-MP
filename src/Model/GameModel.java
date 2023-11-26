package Model;

import View.MainMenuView;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GameModel {
    private Reader CReader;
    private Area CArea;
    private Player CPlayer;
    private Map<String, CreatureEvo1> mapCreaturesEvo1;
    private Map<String, CreatureEvo2> mapCreaturesEvo2;
    private Map<String, CreatureEvo3> mapCreaturesEvo3;

    private Sound CSound;

    public GameModel() throws IOException {
        this.CReader = new Reader(new FileReader("CreaturesList.txt"));
        this.CArea = null;
//        this.mapCreaturesEvo1 = this.CReader.creatureEvo1FileReader();
        this.mapCreaturesEvo2 = this.CReader.creatureEvo2FileReader();
        this.mapCreaturesEvo3 = this.CReader.creatureEvo3FileReader();
        this.CPlayer = new Player();
        this.CSound = new Sound();
    }

        public String pickStarter(int nStarterNum) {
            MainMenuView CMainMenuView = new MainMenuView();
            String strCreatureAdded = "";
            switch (nStarterNum) {
                case 1 -> {
                    this.CPlayer.getPlayerInventory().addCreature(this.mapCreaturesEvo1.get("Strawander"));
                    strCreatureAdded = "STRAWANDER";
                }
                case 2 -> {
                    CPlayer.getPlayerInventory().addCreature(this.mapCreaturesEvo1.get("Chocowool"));
                    strCreatureAdded = "CHOCOWOOL";
                }
                case 3 -> {
                    CPlayer.getPlayerInventory().addCreature(this.mapCreaturesEvo1.get("Parfwit"));
                    strCreatureAdded = "PARFWIT";
                }
                case 4 -> {
                    CPlayer.getPlayerInventory().addCreature(this.mapCreaturesEvo1.get("Brownisaur"));
                    strCreatureAdded = "BROWNISAUR";
                }
                case 5 -> {
                    CPlayer.getPlayerInventory().addCreature(this.mapCreaturesEvo1.get("Frubat"));
                    strCreatureAdded = "FRUBAT";
                }
                case 6 -> {
                    CPlayer.getPlayerInventory().addCreature(this.mapCreaturesEvo1.get("Malts"));
                    strCreatureAdded = "MALTS";
                }
                case 7 -> {
                    CPlayer.getPlayerInventory().addCreature(this.mapCreaturesEvo1.get("Squirpie"));
                    strCreatureAdded = "SQUIRPIE";
                }
                case 8 -> {
                    CPlayer.getPlayerInventory().addCreature(this.mapCreaturesEvo1.get("Chocolite"));
                    strCreatureAdded = "CHOCOLITE";
                }
                case 9 -> {
                    CPlayer.getPlayerInventory().addCreature(this.mapCreaturesEvo1.get("Oshacone"));
                    strCreatureAdded = "OSHACONE";
                }
            }
            return strCreatureAdded;
        }

        public Map<String, CreatureEvo1> getMapCreaturesEvo1(){
            return this.mapCreaturesEvo1;
        }

        public Map<String, CreatureEvo2> getMapCreaturesEvo2(){
            return this.mapCreaturesEvo2;
        }
        public Map<String, CreatureEvo3> getMapCreaturesEvo3(){
            return this.mapCreaturesEvo3;
        }

        public Map<String, CreatureEvo1> getMapCreatures() {
            Map<String, CreatureEvo1> mapCreatures = new HashMap<>();

            mapCreatures.putAll(this.mapCreaturesEvo1);
            mapCreatures.putAll(this.mapCreaturesEvo2);
            mapCreatures.putAll(this.mapCreaturesEvo3);

            return mapCreatures;
        }

        public Sound getSound() {
            return this.CSound;
        }

        public void sleep() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        public ArrayList<String> passListCreature() {
            ArrayList<String> aCreatureNames = new ArrayList<>();
            for(CreatureEvo1 CCreatures : this.CPlayer.getPlayerInventory().getCreatures()) {
                aCreatureNames.add(CCreatures.getName());
            }
            return aCreatureNames;
        }
}
