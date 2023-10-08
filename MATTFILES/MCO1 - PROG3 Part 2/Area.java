import java.io.*;
import java.util.*;

public class Area {
    private ArrayList<Integer> nDimensions;
    private Reader CReader;
    private Creatures CCreature;
    private String strNumArea;
    private char[][] cBoard;
    private int nPlayerRow;
    private int nPlayerCol;

    public Area(String strNumArea) throws IOException{
        this.CReader = new Reader(new FileReader("AreaDimensions.txt"));
        setNumArea(strNumArea);
        setDimensions();
        this.cBoard = new char[nDimensions.get(0)][nDimensions.get(1)];
        this.nPlayerRow = 0;
        this.nPlayerCol = 0;
        initializeArea();

    }

    private void initializeArea() {
        for(int i = 0; i < cBoard.length; i++) {
            for(int j = 0; j < cBoard[i].length; j++) {
                cBoard[i][j] = '.';
            }
        }
        cBoard[nPlayerRow][nPlayerCol] = 'P';
    }

    public void printArea() {
        // Print the top border
        for(int i = 0; i < cBoard[0].length + 2; i++) {
            System.out.print("- ");
        }
        System.out.println();

        // Print the side borders
        for(int i = 0; i < cBoard.length; i++) {
            System.out.print("| ");
            for(int j = 0; j < cBoard[i].length; j++) {
                System.out.print(cBoard[i][j] + " ");
            }
            System.out.println("|");
        }
        
        // Print the bottom border
        for(int i = 0; i < cBoard[0].length + 2; i++) {
            System.out.print("- ");
        }
        System.out.println();
    }

    public void movePlayer(String strMovement) {
        int nRow = nPlayerRow;
        int nCol = nPlayerCol;

        switch(strMovement){
            case "UP":
                nRow--;
                if(nRow >= 0) {
                    cBoard[nPlayerRow][nPlayerCol] = '.';
                    nPlayerRow = nRow;
                    cBoard[nPlayerRow][nPlayerCol] = 'P';
                } else {
                    System.out.println("-- Invalid Move! --");
                }

                break;
            case "DOWN":
                nRow++;
                if(nRow < nDimensions.get(0)) {
                    cBoard[nPlayerRow][nPlayerCol] = '.';
                    nPlayerRow = nRow;
                    cBoard[nPlayerRow][nPlayerCol] = 'P';
                } else {
                    System.out.println("-- Invalid Move! --");
                }
                break;
            case "LEFT":
                nCol--;
                if(nCol >= 0) {
                    cBoard[nPlayerRow][nPlayerCol] = '.';
                    nPlayerCol = nCol;
                    cBoard[nPlayerRow][nPlayerCol] = 'P';
                } else {
                    System.out.println("-- Invalid Move! --");
                }
                break;
            case "RIGHT":
                nCol++;
                if(nCol < nDimensions.get(1)) {
                    cBoard[nPlayerRow][nPlayerCol] = '.';
                    nPlayerCol = nCol;
                    cBoard[nPlayerRow][nPlayerCol] = 'P';
                } else {
                    System.out.println("-- Invalid Move! --");
                }
                break;
        }
    }

    private boolean creatureSpawning() {
        Random CRandom = new Random();
        int nRandomNum = CRandom.nextInt(10);

        if(nRandomNum < 4)
            return true;
        return false;
    }

    public void setNumArea(String strNumArea){
        this.strNumArea = strNumArea;
    }

    public String getNumArea() {
        return this.strNumArea;
    }

    public void setDimensions() throws IOException{
        this.nDimensions = CReader.dimensionFileReader(this.strNumArea);
    }

    public ArrayList<Integer> getDimensions(){
        return this.nDimensions;
    }
    
}

