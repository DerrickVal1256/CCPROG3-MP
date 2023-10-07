import java.io.*;
import java.util.*;

public class Reader {
    private FileReader CReader;
    private Map<String, ArrayList<String>> strList;
    private Creatures Creature;

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

    public Map<String, Creatures> creatureFileReader() throws IOException{
        Map<String, Creatures> strList = new HashMap<String, Creatures>();
        BufferedReader CBufferedReader = new BufferedReader(CReader);
        String strLine = "";

        while((strLine = CBufferedReader.readLine()) != null){
            strList.put(strLine, Creature = new Creatures());
            Creature.setType(CBufferedReader.readLine());
            Creature.setFamily(CBufferedReader.readLine().charAt(0));
            Creature.setLevel(Integer.parseInt(CBufferedReader.readLine()));
        }
        return strList;
    }

   

}
