import java.io.*;
import java.util.*;

public class Creatures {
    private String strName;
    private String strType;
    private char cFamily;
    private int nEvoLevel;
    private Reader CReader;
    private Map<String, Creatures> mapCreatues;
    private String[] strKeys;

    public Creatures(Reader CReader) throws IOException{
        this.CReader = new Reader(new FileReader("CreaturesList.txt"));
        setMapCreatures();
        Set<String> mapKeys = new HashSet<String>();
        mapKeys = mapCreatues.keySet();
        this.strKeys = mapKeys.toArray(new String[0]);
    }

    public Creatures() {
        this.strName = "";
        this.strType = "";
        this.cFamily = ' ';
        this.nEvoLevel = 0;
    }


    public Map<String, Creatures> getCreatureMap() throws IOException{
        return this.mapCreatues;
    }

    public String randomCreature() throws IOException{
        Random random = new Random();
        int randomIndex = random.nextInt(strKeys.length);
        System.out.println(randomIndex);
        // if(randomIndex > strKeys.length) {
        //     randomIndex -= strKeys.length;
        // }
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
        this.mapCreatues = this.CReader.creatureFileReader();
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


}
