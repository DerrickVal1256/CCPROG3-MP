import java.io.*;
import java.util.*;

/**
* This class is a utility for reading data from files.
* It contains methods for reading dimensions and creature data from a file.
*/
public class Reader {
    private FileReader CReader;

    /**
    * This constructor initializes a new Reader with a given FileReader.
    * @param CReader The FileReader to use for reading data.
    * @throws IOException if there is an error creating the Reader.
    */
    public Reader(FileReader CReader) throws IOException {
        this.CReader = CReader;
    }

    /**
    * This method reads dimensions data from a file.
    * @param strKey The key to look for in the file.
    * @return A list of integers representing the dimensions data.
    * @throws IOException if there is an error reading the file.
    */
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

    
    /**
    * This method reads creature data from a file.
    * @return A map of creature names to corresponding creature objects.
    * @throws IOException if there is an error reading the file.
    */
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
