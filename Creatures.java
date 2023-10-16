import java.io.*;
import java.util.*;

public class Creatures {
    private String strName;
    private String strType;
    private char cFamily;
    private int nEvoLevel;
    private boolean bState;
    private Reader CReader;
    private Map<String, Creatures> mapCreatures;
    // private String[] strKeys;

    public Creatures(Reader CReader) throws IOException{
        this.CReader = new Reader(new FileReader("CreaturesList.txt"));
        setMapCreatures();
        // Set<String> mapKeys = new HashSet<String>();
        // mapKeys = mapCreatures.keySet();
        // this.strKeys = mapKeys.toArray(new String[0]);
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