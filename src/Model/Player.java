package Model;

public class Player {
    private String strName;
    private Inventory CPlayerInventory;
    private int nNumCaught;
    public Player() {
        this.strName = "";
        this.CPlayerInventory = new Inventory();
        this.nNumCaught = 0;
    }

    /* Methods */

    public void addCaught() {
        this.nNumCaught += 1;
    }

    /* Getters and Setters */

    public Inventory getPlayerInventory() {
        return this.CPlayerInventory;
    }

    public int getNumCaught() {
        return this.nNumCaught;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    public String getUsername() {
        return this.strName;
    }
}
