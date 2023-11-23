package Model;

public class CreatureEvo3 extends Creatures{
    public CreatureEvo3 (String strName, String strType, char cFamily, int nEvoLevel) {
        super(strName, strType, cFamily, nEvoLevel);
        super.bState = false;
    }
}
