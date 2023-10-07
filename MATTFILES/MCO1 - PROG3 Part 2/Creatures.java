import java.io.*;
import java.util.*;

public class Creatures {
    private String strName;
    private String strType;
    private char cFamily;
    private int nEvoLevel;
    private FileReader CReader;
    private Creatures Creature;
    Map<String, Creatures> map = new HashMap<>();

    public Creatures() throws IOException{
        // this.CReader = new Reader(new FileReader("CreaturesList.txt"));
    }

    public void loadCreatures() throws IOException{
    //    CReader.creatureFileReader().forEach((key, value) -> System.out.println(key + " = " + getType() + getFamily() + getLevel()));
    //    this.strName = ;
    //    this.strType = ;
    //    this.cFamily = ;
    //    this.nEvoLevel = ;
        for (Creatures Creature : this.map.values()) {
            System.out.println(Creature);
        }
        
    }

    public Map<String, Creatures> getMap(){
        return this.map;
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
