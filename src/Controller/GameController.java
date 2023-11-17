package Controller;
import Model.GameModel;
import View.GameView;
import Model.Sound;

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
        this.gameHandlers();
    }

    public void gameHandlers() {
        this.starterCreatureViewHandler();
    }

    public void starterCreatureViewHandler() {
        this.CGameView.getStarterCreatureView().getStarterButton1().setOnAction(event -> {
            if(this.CGameModel.pickStarter(1)) {
                this.CStage.setScene(this.CGameView.getStarterCreatureView().starterAdded("Strawander"));
                this.sleep();
                this.CStage.setScene(this.CGameView.getMenuView().mainMenu());
            }
        });

        this.CGameView.getStarterCreatureView().getStarterButton2().setOnAction(event -> {
            if(this.CGameModel.pickStarter(2)) {
                this.CStage.setScene(this.CGameView.getStarterCreatureView().starterAdded("Brownisaur"));
                this.sleep();
                this.CStage.setScene(this.CGameView.getMenuView().mainMenu());
            }
        });

        this.CGameView.getStarterCreatureView().getStarterButton3().setOnAction(event -> {
            if (this.CGameModel.pickStarter(3)) {
                this.CStage.setScene(this.CGameView.getStarterCreatureView().starterAdded("Squirpie"));
                this.sleep();
                this.CStage.setScene(this.CGameView.getMenuView().mainMenu());
            }
        });
    }

    public void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
