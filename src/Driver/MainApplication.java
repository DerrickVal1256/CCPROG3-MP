package Driver;

import Model.Sound;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.net.URL;

public class MainApplication extends Application {
    @Override
    public void start(Stage CStage) {
//        GameView CGameView = new GameView();
//        GameModel CGameModel = new GameModel();
//        GameController CGameController = new GameController(CGameView, CGameModel, CStage);

        try {
            String currentName = "Squirpie";
            URL resourceURL = getClass().getResource("../images/Creatures/" + currentName + ".png");
            Parent CRoot = FXMLLoader.load(getClass().getResource("../ViewsAndControllers/IntroView.fxml"));
            Scene CScene = new Scene(CRoot);
            System.out.println(resourceURL);

            Image FIcon = new Image("images/MenuImages/icon.png");
            Sound CSound = Sound.getInstance();
            CSound.play("PkmRS_Littleroot.wav", -1);
            CStage.getIcons().add(FIcon);

            CStage.setTitle("Creaturemon");
            CStage.setResizable(false);
            CStage.setScene(CScene);
            CStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
