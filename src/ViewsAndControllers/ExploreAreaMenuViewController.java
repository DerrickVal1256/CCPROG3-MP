package ViewsAndControllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ExploreAreaMenuViewController {

    @FXML
    private void areaOneButtonClicked(MouseEvent event) {
        try {
            Parent CRoot = FXMLLoader.load(getClass().getResource("../ViewsAndControllers/AreaOneView.fxml"));
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
    private void areaTwoButtonClicked(MouseEvent event) {
        try {
            Parent CRoot = FXMLLoader.load(getClass().getResource("../ViewsAndControllers/AreaTwoView.fxml"));
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
    private void areaThreeButtonClicked(MouseEvent event) {
        try {
            Parent CRoot = FXMLLoader.load(getClass().getResource("../ViewsAndControllers/AreaThreeView.fxml"));
            Scene CScene = new Scene(CRoot);
            Node CNode = (Node) event.getSource();
            Stage CStage = (Stage) CNode.getScene().getWindow();

            CStage.setScene(CScene);
            CStage.show();
        } catch (Exception error) {
            error.printStackTrace();
        }
    }
}
