import java.io.*;
import java.util.*;

public class Driver {
    public static void main(String args[]) throws IOException{
        Area Area = new Area("Area 2"); // will get this from user chosen area
        Creatures Creature = new Creatures();
        Map<String, Creatures> map = new HashMap<>();
        Scanner CScanner = new Scanner(System.in);

        
        // System.out.println(Area.getNumArea());
        // Area.printArea();
        //CReader.creatureFileReader();

        map = Creature.getCreatureMap();

        String randomCreature = Creature.randomCreature();

        // confirms that hashmap is filled up
        // System.out.println(map.entrySet());

        char family = map.get(randomCreature).getFamily();
        String type = map.get(randomCreature).getType();
        int level = map.get(randomCreature).getLevel();

        System.out.println(randomCreature);
        System.out.println(family);
        System.out.println(type);
        System.out.println(level);

        CScanner.close();
    }
}
