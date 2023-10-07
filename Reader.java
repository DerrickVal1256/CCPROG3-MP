import java.io.*;
import java.util.*;

public class Reader {
    private FileReader CReader;

    public Reader(FileReader CReader) throws IOException {
        this.CReader = CReader;
    }

    public ArrayList<Integer> fileReader(int nKey) throws IOException{
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
}
