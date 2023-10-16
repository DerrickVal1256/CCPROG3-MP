import java.io.*;
import java.util.*;

/**
* This class represents a creature in the game.
*/
public class Creatures {
    private String strName;
    private String strType;
    private char cFamily;
    private int nEvoLevel;
    private boolean bState;
    private Reader CReader;
    private Map<String, Creatures> mapCreatures;
    // private String[] strKeys;

    /**
    * Constructs a new Creatures instance with a given reader.
    * @param CReader The reader to use.
    * @throws IOException if there is an error during the creatures initialization.
    */
    public Creatures(Reader CReader) throws IOException{
        this.CReader = new Reader(new FileReader("CreaturesList.txt"));
        setMapCreatures();
    }

    /**
    * Constructs a new, empty Creatures instance.
    */
    public Creatures() {
        this.strName = "";
        this.strType = "";
        this.cFamily = ' ';
        this.nEvoLevel = 0;
        this.bState = false;
    }

    /**
    * Returns the map of creatures.
    * @return The map of creatures.
    * @throws IOException if there is an error during the map retrieval.
    */
    public Map<String, Creatures> getCreatureMap() throws IOException{
        return this.mapCreatures;
    }

    /**
    * Returns a random creature based on the area number.
    * @param nAreaNum The number of the area.
    * @return The name of the random creature.
    * @throws IOException if there is an error during the creature selection.
    */
    public String randomCreature(int nAreaNum) throws IOException{
        Random random = new Random();
        Set<String> mapKeys = new HashSet<String>();
        int randomIndex = 0;
        /*
         * this is used to generate a list of creatures based on the area number 
         */
        Iterator<Map.Entry<String, Creatures>> CIterator = this.mapCreatures.entrySet().iterator();
        while(CIterator.hasNext()) {
            Map.Entry<String, Creatures> CEntry = CIterator.next();
            Creatures CCreature = CEntry.getValue();
            if(CCreature.getLevel() <= nAreaNum) {
                mapKeys.add(CCreature.getName());
            }
        }

        String[] strKeys = mapKeys.toArray(new String[0]);

        randomIndex = random.nextInt(strKeys.length);
        String randomCreature = strKeys[randomIndex];

        return randomCreature;
    }

    /**
     * Sets the name of the creature.
     * @param strName The name to set.
     */
    public void setName(String strName) {
        this.strName = strName;
    }

    /**
    * Sets the type of the creature.
    * @param strType The type to set.
    */
    public void setType(String strType){
        this.strType = strType;
    }

    /**
    * Sets the family of the creature.
    * @param cFamily The family to set.
    */
    public void setFamily(char cFamily){
        this.cFamily = cFamily;
    }

    /**
    * Sets the level of the creature.
    * @param nEvoLevel The level to set.
    */
    public void setLevel(int nEvoLevel){
        this.nEvoLevel = nEvoLevel;
    }

    /**
    * Sets the map of creatures.
    * @throws IOException if there is an error during the map setting.
    */
    public void setMapCreatures() throws IOException{
        this.mapCreatures = this.CReader.creatureFileReader();
    }

    /**
    * Sets the state of the creature.
    * @param bState The state to set.
    */
    public void setStatus(boolean bState){
        this.bState = bState;
    }

    /**
    * Returns the name of the creature.
    * @return The name of the creature.
    */
    public String getName() {
        return this.strName;
    }

    /**
    * Returns the type of the creature.
    * @return The type of the creature.
    */
    public String getType(){
        return this.strType;
    }

    /**
    * Returns the family of the creature.
    * @return The family of the creature.
    */
    public char getFamily(){
        return this.cFamily;
    }

    /**
    * Returns the level of the creature.
    * @return The level of the creature.
    */
     public int getLevel(){
        return this.nEvoLevel;
    }

    /**
    * Returns the state of the creature.
    * @return The state of the creature.
    */
    public boolean getState(){
        return this.bState;
    }

    /**
    * Returns a string representation of the creature.
    * @return A string representation of the creature.
    */
    // debugger method
    @Override
    public String toString() {
        return  '{' +
                strName + ", " +
                strType + ", " +
                nEvoLevel +
                '}';
    }
}