package Driver;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.net.URL;

public class MainApplication extends Application {
    @Override
    public void start(Stage CStage) throws Exception {
//        GameView CGameView = new GameView();
//        GameModel CGameModel = new GameModel();
//        GameController CGameController = new GameController(CGameView, CGameModel, CStage);
      try {
       URL resourceURL = getClass().getResource("../View/InventoryView.fxml");
           Parent CRoot = FXMLLoader.load(getClass().getResource("../View/InventoryView.fxml"));
            Scene CScene = new Scene(CRoot);
         System.out.println(resourceURL);

            Image FIcon = new Image("images/MenuImages/icon.png");
            CStage.getIcons().add(FIcon);
            //CStage.setResizable(false);

            CStage.setTitle("Creaturemon");
<<<<<<< Updated upstream
                CStage.setScene(CScene);
=======
           CStage.setScene(CScene);
>>>>>>> Stashed changes
            CStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
