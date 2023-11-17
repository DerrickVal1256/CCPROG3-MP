package Driver;
import Controller.GameController;
import Model.GameModel;
import View.GameView;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainApplication extends Application {
    @Override
    public void start(Stage CStage) throws Exception {
        GameView CGameView = new GameView();
        GameModel CGameModel = new GameModel();
        GameController CGameController = new GameController(CGameView, CGameModel, CStage);

        Image FIcon = new Image("images/MenuImages/icon.png");
        CStage.getIcons().add(FIcon);
        CStage.setResizable(false);

        CStage.setTitle("Creaturemon");
        CStage.setScene(CGameView.getStarterCreatureView().starterCreature());
        CStage.show();
    }
}
