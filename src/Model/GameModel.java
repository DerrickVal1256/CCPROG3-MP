package Model;

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

    public boolean pickStarter(int nStarterNum) {
        switch (nStarterNum) {
            case 1 -> {
                CPlayer.getPlayerInventory().addCreature(this.mapCreatures.get("Strawander"));
                this.CSound.play("PkmRS_Littleroot.wav");
                return true;
            }
            case 2 -> {
                CPlayer.getPlayerInventory().addCreature(this.mapCreatures.get("Brownisaur"));
                this.CSound.play("PkmRS_Littleroot.wav");
                return true;
            }
            case 3 -> {
                CPlayer.getPlayerInventory().addCreature(this.mapCreatures.get("Squirpie"));
                this.CSound.play("PkmRS_Littleroot.wav");
                return true;
            }
        }
        return false;
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
