package View;

public class GameView {
    private StarterCreatureView CStarterCreatureView;
    private MenuView CMenuView;
    private InventoryView CInventoryView;
    public GameView() {
        this.CStarterCreatureView = new StarterCreatureView();
        this.CMenuView = new MenuView();
        this.CInventoryView = new InventoryView();
    }

    /* Getters */

    public StarterCreatureView getStarterCreatureView() {
        return this.CStarterCreatureView;
    }

    public MenuView getMenuView() {
        return this.CMenuView;
    }

    public InventoryView getInventoryView() {
        return this.CInventoryView;
    }
}
