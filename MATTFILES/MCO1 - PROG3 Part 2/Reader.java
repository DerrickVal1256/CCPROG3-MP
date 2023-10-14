import java.io.*;
import java.util.*;

public class Reader {
    private FileReader CReader;
    // private Creatures CCreature;

    public Reader(FileReader CReader) throws IOException {
        this.CReader = CReader;
    }

    public ArrayList<Integer> dimensionFileReader(String strKey) throws IOException{
        ArrayList<Integer> nList = new ArrayList<>();
        BufferedReader CBufferedReader = new BufferedReader(CReader);
        String strLine = "";
        String strNextLine = "";
        String[] strNumberStrings = {"", ""};

        while((strLine = CBufferedReader.readLine()) != null){
            if(strLine.equals(strKey)){
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

    public Map<String, Creatures> creatureFileReader() throws IOException{
        Map<String, Creatures> mapList = new HashMap<String, Creatures>();
        BufferedReader CBufferedReader = new BufferedReader(CReader);
        Creatures CCreature;
        String strLine = "";

        while((strLine = CBufferedReader.readLine()) != null){
            mapList.put(strLine, CCreature = new Creatures());
            CCreature.setName(strLine);
            CCreature.setType(CBufferedReader.readLine());
            CCreature.setFamily(CBufferedReader.readLine().charAt(0));
            CCreature.setLevel(Integer.parseInt(CBufferedReader.readLine()));
        }
        return mapList;
    }
}
