package ViewsAndControllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AreaThreeViewController {
    @FXML
    private ImageView CPlayerImageView;

    @FXML
    private GridPane CGridPane;

    @FXML
    private void leftButtonClicked(MouseEvent event) {
        int nCol = GridPane.getColumnIndex(this.CPlayerImageView);
        if(nCol > 0) {
            nCol--;
            this.CGridPane.setColumnIndex(this.CPlayerImageView, nCol);
            // chance of spawning
            // once spawned change view to battle view
        }
    }

    @FXML
    private void rightButtonClicked(MouseEvent event) {
        int nCol = GridPane.getColumnIndex(this.CPlayerImageView);
        if(nCol < 3) {
            nCol++;
            this.CGridPane.setColumnIndex(this.CPlayerImageView, nCol);
        }
    }

    @FXML
    private void upButtonClicked(MouseEvent event) {
        int nRow = GridPane.getRowIndex(this.CPlayerImageView);
        if(nRow > 0) {
            nRow--;
            this.CGridPane.setRowIndex(this.CPlayerImageView, nRow);
            // chance of spawning
            // once spawned change view to battle view
        }
    }

    @FXML
    private void downButtonClicked(MouseEvent event) {
        int nRow = GridPane.getRowIndex(this.CPlayerImageView);
        if(nRow < 3) {
            nRow++;
            this.CGridPane.setRowIndex(this.CPlayerImageView, nRow);
        }
    }

    @FXML
    private void exitButtonClicked(MouseEvent event) {
        try {
            Parent CRoot = FXMLLoader.load(getClass().getResource("../ViewsAndControllers/MainMenuView.fxml"));
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
