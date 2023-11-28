package Model;
import java.io.*;
import java.util.*;

/**
* This class is a utility for reading data from files.
* It contains methods for reading dimensions and creature data from a file.
*/
public class Reader {
    private FileReader CFileReader;
    private Map<String, CreatureEvo1> mapCreatures1;
    private Map<String, CreatureEvo2> mapCreatures2;
    private Map<String, CreatureEvo3> mapCreatures3;

    /**
    * This constructor initializes a new Reader with a given FileReader.
    * @param CFileReader The FileReader to use for reading data.
    * @throws IOException if there is an error creating the Reader.
    */
    public Reader(FileReader CFileReader) throws IOException {
        this.CFileReader = CFileReader;
        mapCreatures1 = new HashMap<>();
        mapCreatures2 = new HashMap<>();
        mapCreatures3 = new HashMap<>();
        this.creatureFileReader();
    }



    public void creatureFileReader() throws IOException{
        BufferedReader CBufferedReader = new BufferedReader(this.CFileReader);
        String strLine = "";

        for(int i = 0; i < 9; i++) {
            strLine = CBufferedReader.readLine();
            mapCreatures1.put(strLine, new CreatureEvo1(strLine, CBufferedReader.readLine(), CBufferedReader.readLine().charAt(0), Integer.parseInt(CBufferedReader.readLine())));
        }

        for(int i = 0; i < 9; i++) {
            strLine = CBufferedReader.readLine();
            mapCreatures2.put(strLine, new CreatureEvo2(strLine, CBufferedReader.readLine(), CBufferedReader.readLine().charAt(0), Integer.parseInt(CBufferedReader.readLine())));
        }

        for(int i = 0; i < 9; i++) {
            strLine = CBufferedReader.readLine();
            mapCreatures3.put(strLine, new CreatureEvo3(strLine, CBufferedReader.readLine(), CBufferedReader.readLine().charAt(0), Integer.parseInt(CBufferedReader.readLine())));
        }
    }

    public Map<String, CreatureEvo1> getMapCreatures1() {
        return this.mapCreatures1;
    }

    public Map<String, CreatureEvo2> getMapCreatures2() {
        return this.mapCreatures2;
    }

    public Map<String, CreatureEvo3> getMapCreatures3() {
        return this.mapCreatures3;
    }
}
