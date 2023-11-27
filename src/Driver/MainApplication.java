package Driver;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainApplication extends Application {
    @Override
    public void start(Stage CStage) {
//        GameView CGameView = new GameView();
//        GameModel CGameModel = new GameModel();
//        GameController CGameController = new GameController(CGameView, CGameModel, CStage);

        try {
//            URL resourceURL = getClass().getResource("../View/IntroView.fxml");
            Parent CRoot = FXMLLoader.load(getClass().getResource("../ViewAndControllers/IntroView.fxml"));
            Scene CScene = new Scene(CRoot);
//            System.out.println(resourceURL);

            Image FIcon = new Image("images/MenuImages/icon.png");
            CStage.getIcons().add(FIcon);

            CStage.setTitle("Creaturemon");
            CStage.setScene(CScene);
            CStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
