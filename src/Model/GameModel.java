package Model;

import View.MainMenuView;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class GameModel {
    private Reader CReader;
    private Area CArea;
    private Player CPlayer;
    private Map<String, Creatures> mapCreatures;

    private Sound CSound;

    public GameModel() throws IOException {
        this.CReader = new Reader(new FileReader("CreaturesList.txt"));
        this.CArea = null;
        this.mapCreatures = this.CReader.creatureFileReader();
        this.CPlayer = new Player();
        this.CSound = new Sound();
    }

    public String pickStarter(int nStarterNum) {
        MainMenuView CMainMenuView = new MainMenuView();
        String strCreatureAdded = "";
        switch (nStarterNum) {
            case 1 -> {
                this.CPlayer.getPlayerInventory().addCreature(this.mapCreatures.get("Strawander"));
                strCreatureAdded = "Strawander";
            }
            case 2 -> {
                CPlayer.getPlayerInventory().addCreature(this.mapCreatures.get("Chocowool"));
                strCreatureAdded = "Chocowool";
            }
            case 3 -> {
                CPlayer.getPlayerInventory().addCreature(this.mapCreatures.get("Parwif"));
                strCreatureAdded = "Parwif";
            }
            case 4 -> {
                CPlayer.getPlayerInventory().addCreature(this.mapCreatures.get("Brownisaur"));
                strCreatureAdded = "Brownisaur";
            }
            case 5 -> {
                CPlayer.getPlayerInventory().addCreature(this.mapCreatures.get("Frubat"));
                strCreatureAdded = "Frubat";
            }
            case 6 -> {
                CPlayer.getPlayerInventory().addCreature(this.mapCreatures.get("Malts"));
                strCreatureAdded = "Malts";
            }
            case 7 -> {
                CPlayer.getPlayerInventory().addCreature(this.mapCreatures.get("Squirpie"));
                strCreatureAdded = "Squirpie";
            }
            case 8 -> {
                CPlayer.getPlayerInventory().addCreature(this.mapCreatures.get("Chocolite"));
                strCreatureAdded = "Chocolite";
            }
            case 9 -> {
                CPlayer.getPlayerInventory().addCreature(this.mapCreatures.get("Oshacone"));
                strCreatureAdded = "Oshacone";
            }
        }
        return strCreatureAdded;
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
}
