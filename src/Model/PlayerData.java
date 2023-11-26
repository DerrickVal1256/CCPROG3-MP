package Model;

public class PlayerData {
    private static PlayerData CPlayerDataInstance = new PlayerData();

    private Player CPlayer;

    private PlayerData() {

    }

    public static PlayerData getPlayerData() {
        return CPlayerDataInstance;
    }

    public void setPlayer(Player CPlayer) {
        this.CPlayer = CPlayer;
    }

    public Player getPlayer() {
        return this.CPlayer;
    }
}
