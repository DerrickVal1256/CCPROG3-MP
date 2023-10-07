import java.io.*;
import java.util.*;

public class Area {
    private ArrayList<Integer> nDimensions;
    private 
    private Reader CReader;
    
    public Area() throws IOException{
        this.CReader = new Reader(new FileReader("AreaDimensions.txt"));
    }

    public int[] playerMovement() {

        return playerPosition;
    }



    public void setDimensions(int nAreaNum) throws IOException{
        this.nDimensions = CReader.fileReader(nAreaNum);
    }

    public ArrayList<Integer> getDimensions(){
        return this.nDimensions;
    }
    
}

