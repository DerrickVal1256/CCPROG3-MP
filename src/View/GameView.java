package View;

public class GameView {
    private StarterCreatureView CStarterCreatureView;
    private MainMenuView CMainMenuView;
    private InventoryView CInventoryView;
    public GameView() {
        this.CStarterCreatureView = new StarterCreatureView();
        this.CMainMenuView = new MainMenuView();
        this.CInventoryView = new InventoryView();
    }

    /* Getters */

    public StarterCreatureView getStarterCreatureView() {
        return this.CStarterCreatureView;
    }

    public MainMenuView getMainMenuView() {
        return this.CMainMenuView;
    }

    public InventoryView getInventoryView() {
        return this.CInventoryView;
    }
}
