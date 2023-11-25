package Controller;
import Model.GameModel;
import View.GameView;

import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class GameController {
    private GameModel CGameModel;
    private GameView CGameView;
    private Stage CStage;


    public GameController(GameView CGameView, GameModel CGameModel, Stage CStage) throws IOException {
        this.CGameView = CGameView;
        this.CGameModel = CGameModel;
        this.CStage = CStage;
        this.starterCreatureHandler();
        this.mainMenuHandler();
    }

    public void starterCreatureHandler() {
        this.CGameView.getStarterCreatureView().getStarterButton1().setOnAction(event -> this.eventPickStarter(1));

        this.CGameView.getStarterCreatureView().getStarterButton2().setOnAction(event -> this.eventPickStarter(2));

        this.CGameView.getStarterCreatureView().getStarterButton3().setOnAction(event -> this.eventPickStarter(3));

        this.CGameView.getStarterCreatureView().getStarterButton4().setOnAction(event -> this.eventPickStarter(4));

        this.CGameView.getStarterCreatureView().getStarterButton5().setOnAction(event -> this.eventPickStarter(5));

        this.CGameView.getStarterCreatureView().getStarterButton6().setOnAction(event -> this.eventPickStarter(6));

        this.CGameView.getStarterCreatureView().getStarterButton7().setOnAction(event -> this.eventPickStarter(7));

        this.CGameView.getStarterCreatureView().getStarterButton8().setOnAction(event -> this.eventPickStarter(8));

        this.CGameView.getStarterCreatureView().getStarterButton9().setOnAction(event -> this.eventPickStarter(9));
    }

    public void mainMenuHandler () {
        this.CGameView.getMainMenuView().getViewInventoryButton();
        this.CGameView.getMainMenuView().getExploreAreaButton().setOnAction(event -> this.setScene(this.CGameView.getMainMenuView().areaPickerMenu()));
        this.CGameView.getMainMenuView().getEvolveCreatureButton();
        this.CGameView.getMainMenuView().getExitButton().setOnAction(event -> System.exit(0));
        this.CGameView.getMainMenuView().getAreaOneButton().setOnAction(event -> this.setScene(this.CGameView.getAreaView().certainAreaView(1)));
        this.CGameView.getMainMenuView().getAreaTwoButton();
        this.CGameView.getMainMenuView().getAreaThreeButton();
    }

    private void eventPickStarter(int nStarterNum) {
        this.setScene(CGameView.getStarterCreatureView().starterAdded(CGameModel.pickStarter(nStarterNum)));
        this.sleep(1);
        this.CGameModel.getSound().play("PkmRS_Littleroot.wav");
        this.setScene(CGameView.getMainMenuView().mainMenu());
    }

    public void setScene(Scene CScene) {
        this.CStage.setScene(CScene);
        this.CStage.show();
    }

    public GameView getCGameView() {
        return this.CGameView;
    }

    public void sleep(int nSeconds) {
        nSeconds *= 1000;
        try {
            Thread.sleep(nSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
