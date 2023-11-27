package ViewAndControllers;

public class GameView {
    private StarterCreatureView CStarterCreatureView;
    private MainMenuView CMainMenuView;
    private InventoryView CInventoryView;
    private AreaView CAreaView;

    public GameView() {
        this.CStarterCreatureView = new StarterCreatureView();
        this.CMainMenuView = new MainMenuView();
        this.CInventoryView = new InventoryView();
        this.CAreaView = new AreaView();
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

    public AreaView getAreaView() {
        return this.CAreaView;
    }
}
