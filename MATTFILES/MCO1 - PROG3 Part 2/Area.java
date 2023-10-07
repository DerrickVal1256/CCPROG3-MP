import java.io.*;
import java.util.*;

public class Area {
    private ArrayList<Integer> nDimensions;
    private Reader CReader;
    
    public Area() throws IOException{
        this.CReader = new Reader(new FileReader("AreaDimensions.txt"));
    }

    public void setDimensions(int nAreaNum) throws IOException{
        this.nDimensions = CReader.dimensionFileReader(nAreaNum);
    }

    public ArrayList<Integer> getDimensions(){
        return this.nDimensions;
    }
    
}

