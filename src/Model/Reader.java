package Model;
import java.io.*;
import java.util.*;

/**
* This class is a utility for reading data from files.
* It contains methods for reading dimensions and creature data from a file.
*/
public class Reader {
    private FileReader CFileReader;

    /**
    * This constructor initializes a new Reader with a given FileReader.
    * @param CFileReader The FileReader to use for reading data.
    * @throws IOException if there is an error creating the Reader.
    */
    public Reader(FileReader CFileReader) throws IOException {
        this.CFileReader = CFileReader;
    }

    /**
    * This method reads dimensions data from a file.
    * @param strKey The key to look for in the file.
    * @return A list of integers representing the dimensions data.
    * @throws IOException if there is an error reading the file.
    */
    public ArrayList<Integer> dimensionFileReader(String strKey) throws IOException{
        ArrayList<Integer> nList = new ArrayList<>();
        BufferedReader CBufferedReader = new BufferedReader(this.CFileReader);
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
    public Map<String, CreatureEvo1> creatureEvo1FileReader() throws IOException{
        Map<String, CreatureEvo1> mapList = new HashMap<String, CreatureEvo1>();
        BufferedReader CBufferedReader = new BufferedReader(this.CFileReader);
        String strLine = "";

        while(!(strLine = CBufferedReader.readLine()).equals("Strawleon")){
            mapList.put(strLine, new CreatureEvo1(strLine, CBufferedReader.readLine(), CBufferedReader.readLine().charAt(0), Integer.parseInt(CBufferedReader.readLine())));
        }
        return mapList;
    }

    public Map<String, CreatureEvo2> creatureEvo2FileReader() throws IOException{
        Map<String, CreatureEvo2> mapList = new HashMap<String, CreatureEvo2>();
        BufferedReader CBufferedReader = new BufferedReader(this.CFileReader);
        String strLine = "";

        while(!(strLine = CBufferedReader.readLine()).equals("Strawizard")){
            mapList.put(strLine, new CreatureEvo2(strLine, CBufferedReader.readLine(), CBufferedReader.readLine().charAt(0), Integer.parseInt(CBufferedReader.readLine())));
        }
        return mapList;
    }

    public Map<String, CreatureEvo3> creatureEvo3FileReader() throws IOException{
        Map<String, CreatureEvo3> mapList = new HashMap<String, CreatureEvo3>();
        BufferedReader CBufferedReader = new BufferedReader(this.CFileReader);
        String strLine = "";

        while((strLine = CBufferedReader.readLine()) != null){
            mapList.put(strLine, new CreatureEvo3(strLine, CBufferedReader.readLine(), CBufferedReader.readLine().charAt(0), Integer.parseInt(CBufferedReader.readLine())));
        }
        return mapList;
    }
}
