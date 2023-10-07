import java.io.*;
import java.util.*;

public class Driver {
    public static void main(String args[]) throws IOException{
        Area Area = new Area(); // will get this from user chosen area
        Creatures Creature = new Creatures();
        /* 
        Area.setDimensions(2);
        System.out.println(Area.getDimensions()); 
        ^^^ used for testing Reader and Area classes
        */ 

       Creature.loadCreatures();

    }
}
