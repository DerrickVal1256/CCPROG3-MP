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

        try {
            Parent CRoot = FXMLLoader.load(getClass().getResource("../ViewsAndControllers/IntroView.fxml"));
            Scene CScene = new Scene(CRoot);

            Image FIcon = new Image("images/MenuImages/icon.png");
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
