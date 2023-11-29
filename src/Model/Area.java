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

    /**
    * This constructor initializes a new area with a given number.
    * @param strNumArea The number of the area.
    */
    public Area(String strNumArea) {
        try {
            aCreatureList = new ArrayList<>();
            this.strNumArea = strNumArea;
            this.initializeCreatureList(strNumArea);
        } catch (IOException error) {
            error.printStackTrace();
        }

    }

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
