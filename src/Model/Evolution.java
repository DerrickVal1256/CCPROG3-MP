package Model;

import java.io.FileReader;
import java.io.IOException;

public class Evolution {

    public Evolution() {

    }
    public boolean evolve(Player CPlayer, CreatureEvo1 CTemp1, CreatureEvo1 CTemp2) throws IOException {
        Reader CReader = new Reader(new FileReader("CreaturesList.txt"));
        if(CTemp1.getLevel() == CTemp2.getLevel() && CTemp1.getFamily() == CTemp2.getFamily() && CTemp1.getUniqueID() != CTemp2.getUniqueID()) {
            if(CTemp1.getLevel() == 1) {
                CPlayer.getPlayerInventory().removeCreature(CTemp1);
                CPlayer.getPlayerInventory().removeCreature(CTemp2);
                for(CreatureEvo1 CCreature : CReader.getMapCreatures2().values()) {
                    if(CCreature.getFamily() == CTemp1.getFamily()) {
                        CPlayer.getPlayerInventory().addCreature(CCreature);
                        CCreature.setID(CPlayer.getPlayerInventory().getCreatures().size() + 1);
                        CPlayer.getPlayerInventory().activeCreature(CCreature.getName(), CCreature.getUniqueID());
                        return true;
                    }
                }
            } else if(CTemp1.getLevel() == 2){
                CPlayer.getPlayerInventory().removeCreature(CTemp1);
                CPlayer.getPlayerInventory().removeCreature(CTemp2);
                for(CreatureEvo1 CCreature : CReader.getMapCreatures3().values()) {
                    if(CCreature.getFamily() == CTemp1.getFamily()) {
                        CPlayer.getPlayerInventory().addCreature(CCreature);
                        CCreature.setID(CPlayer.getPlayerInventory().getCreatures().size() + 1);
                        CPlayer.getPlayerInventory().activeCreature(CCreature.getName(), CCreature.getUniqueID());
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
