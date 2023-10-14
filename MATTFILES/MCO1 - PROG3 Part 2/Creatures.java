import java.io.*;
import java.util.*;

public class Creatures {
    private String strName;
    private String strType;
    private char cFamily;
    private int nEvoLevel;
    private Creatures CCreature;
    private boolean bState;
    private Reader CReader;
    private Map<String, Creatures> mapCreatures;
    private String[] strKeys;

    public Creatures(Reader CReader) throws IOException{
        this.CReader = new Reader(new FileReader("CreaturesList.txt"));
        setMapCreatures();
        Set<String> mapKeys = new HashSet<String>();
        mapKeys = mapCreatures.keySet();
        this.strKeys = mapKeys.toArray(new String[0]);
    }

    public Creatures() {
        this.strName = "";
        this.strType = "";
        this.cFamily = ' ';
        this.nEvoLevel = 0;
        this.bState = false;
    }

    public Map<String, Creatures> getCreatureMap() throws IOException{
        return this.mapCreatures;
    }

    public String randomCreature() throws IOException{
        Random random = new Random();
        int randomIndex = random.nextInt(strKeys.length);
        System.out.println(randomIndex);
        String randomCreature = strKeys[randomIndex];

        return randomCreature;
    }

    public void setName(String strName) {
        this.strName = strName;
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

    public void setMapCreatures() throws IOException{
        this.mapCreatures = this.CReader.creatureFileReader();
    }

    public void setStatus(boolean bState){
        this.bState = bState;
    }

    public String getName() {
        return this.strName;
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

    public boolean getState(){
        return this.bState;
    }

        // just for checking values in the HashMap
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