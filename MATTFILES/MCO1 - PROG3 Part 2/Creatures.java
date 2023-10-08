import java.io.*;
import java.util.*;

public class Creatures {
    private String strName;
    private String strType;
    private char cFamily;
    private int nEvoLevel;
    private Reader CReader;
    private Creatures Creature;
    Map<String, Creatures> map = new HashMap<>();

    public Creatures() throws IOException{
        this.CReader = new Reader(new FileReader("CreaturesList.txt"));
    }

    public Map<String, Creatures> getCreatureMap() throws IOException{
        CReader.creatureFileReader();
        this.map = CReader.getMap();

        return this.map;
    }

    // just for checking values in the HashMap
    // debugger method
    @Override
    public String toString() {
        return  '{' +
                strType + ", " +
                cFamily + ", " +
                nEvoLevel +
                '}';
    }


    public void setType(String strType){
        this.strType = strType;
    }

    public void setFamily(char cFamily){
        this.cFamily = cFamily;
    }

    public void setLevel(int nEvoLevel){
        this.nEvoLevel = nEvoLevel;
    }

    public String getType(){
        return this.strType;
    }

    public char getFamily(){
        return this.cFamily;
    }

     public int getLevel(){
        return this.nEvoLevel;
    }
}
