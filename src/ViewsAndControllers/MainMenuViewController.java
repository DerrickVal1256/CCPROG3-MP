package ViewsAndControllers;

import Model.Player;
import Model.PlayerData;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MainMenuViewController {

    @FXML
    private void viewInventoryButtonClicked(MouseEvent event) {
        try {
            PlayerData CPlayerDataHolder = PlayerData.getPlayerData();
            Player CPlayer = CPlayerDataHolder.getPlayer();
            CPlayer.getPlayerInventory().printInventory();
            Parent CRoot = FXMLLoader.load(getClass().getResource("../ViewsAndControllers/InventoryView.fxml"));
            Scene CScene = new Scene(CRoot);
            Node CNode = (Node) event.getSource();
            Stage CStage = (Stage) CNode.getScene().getWindow();

            CStage.setScene(CScene);
            CStage.show();
        } catch (Exception error) {
            error.printStackTrace();
        }
    }

    @FXML
    private void exploreAreaButtonClicked(MouseEvent event) {
        try {
            Parent CRoot = FXMLLoader.load(getClass().getResource("../ViewsAndControllers/ExploreAreaMenuView.fxml"));
            Scene CScene = new Scene(CRoot);
            Node CNode = (Node) event.getSource();
            Stage CStage = (Stage) CNode.getScene().getWindow();

            CStage.setScene(CScene);
            CStage.show();
        } catch (Exception error) {
            error.printStackTrace();
        }
    }

    @FXML
    private void evolveButtonClicked(MouseEvent event) {
        try {
            Parent CRoot = FXMLLoader.load(getClass().getResource("../ViewsAndControllers/EvolveMenuView.fxml"));
            Scene CScene = new Scene(CRoot);
            Node CNode = (Node) event.getSource();
            Stage CStage = (Stage) CNode.getScene().getWindow();

            CStage.setScene(CScene);
            CStage.show();
        } catch (Exception error) {
            error.printStackTrace();
        }
    }

    @FXML
    private void exitButtonClicked(MouseEvent event) {
        Platform.exit();
    }
}
