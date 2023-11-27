package ViewAndControllers;

import Model.Player;
import Model.PlayerData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class IntroViewController {

    @FXML
    public TextField getUsernameTextField;

    @FXML
    private void handleSubmitUsername(ActionEvent event) {
        Player CPlayer = new Player();
        CPlayer.setName(getUsernameTextField.getText());
        Stage CStage = (Stage) getUsernameTextField.getScene().getWindow();
        try {
            Parent CRoot = FXMLLoader.load(getClass().getResource("../ViewAndControllers/StarterCreatureView.fxml"));
            PlayerData CPlayerDataHolder = PlayerData.getPlayerData();

            CPlayerDataHolder.setPlayer(CPlayer);

            Scene CScene = new Scene(CRoot);
            CStage.setScene(CScene);
            CStage.show();
        } catch(IOException error) {
            error.printStackTrace();
        }
    }
}
