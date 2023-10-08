import java.io.*;
import java.util.*;

public class Reader {
    private FileReader CReader;
    private Map<String, Creatures> mapList;
    private Creatures CCreature;

    public Reader(FileReader CReader) throws IOException {
        this.CReader = CReader;
    }

    public ArrayList<Integer> dimensionFileReader(int nKey) throws IOException{
        ArrayList<Integer> nList = new ArrayList<>();
        BufferedReader CBufferedReader = new BufferedReader(CReader);
        String strLine = "";
        String strNextLine = "";
        String[] strNumberStrings = {"", ""};

        while((strLine = CBufferedReader.readLine()) != null){
            if(strLine.contains(String.valueOf(nKey))){
                strNextLine = CBufferedReader.readLine();
                if(strNextLine != null){
                    strNumberStrings = strNextLine.split(" ");
                    for(String strNumberString : strNumberStrings) {
                        nList.add(Integer.parseInt(strNumberString));
                    }
                }
            }
        }
        CBufferedReader.close();
        return nList;
    }

    public void creatureFileReader() throws IOException{
        Map<String, Creatures> mapList = new HashMap<String, Creatures>();
        BufferedReader CBufferedReader = new BufferedReader(CReader);
        String strLine = "";

        while((strLine = CBufferedReader.readLine()) != null){
            mapList.put(strLine, this.CCreature = new Creatures());
            this.CCreature.setType(CBufferedReader.readLine());
            this.CCreature.setFamily(CBufferedReader.readLine().charAt(0));
            this.CCreature.setLevel(Integer.parseInt(CBufferedReader.readLine()));
        }
        this.mapList = mapList;
    }

    public Map<String, Creatures> getMap(){
        return this.mapList;
    }

}
