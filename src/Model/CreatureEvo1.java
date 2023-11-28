package Model;
import java.io.*;
import java.util.*;

/**
* This class represents a creature in the game.
*/
public class CreatureEvo1 {
    protected String strName;
    protected String strType;
    protected char cFamily;
    protected int nEvoLevel;
    protected boolean bState;
    protected int nUniqueID;

    /**
    * Constructs a new, empty Creatures instance.
    */
    public CreatureEvo1(String strName, String strType, char cFamily, int nEvoLevel) {
        this.strName = strName;
        this.strType = strType;
        this.cFamily = cFamily;
        this.nEvoLevel = nEvoLevel;
        this.bState = false;
        this.nUniqueID = 0;
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
                nEvoLevel + ", " +
                bState +
                '}';
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
    public boolean getStatus(){
        return this.bState;
    }

    public int getUniqueID(){
        return this.nUniqueID;
    }
    public void setID(int nID){
        this.nUniqueID = nID;
    }
}
