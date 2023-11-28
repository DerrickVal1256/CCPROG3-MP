package Model;

public class CreatureEvo2 extends CreatureEvo1 {
    public CreatureEvo2 (String strName, String strType, char cFamily, int nEvoLevel) {
        super(strName, strType, cFamily, nEvoLevel);
        super.bState = false;
        super.nUniqueID = 0;
    }

}
