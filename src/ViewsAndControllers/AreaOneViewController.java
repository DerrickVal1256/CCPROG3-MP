package ViewsAndControllers;

import Model.Area;
import Model.CreatureEvo1;
import Model.Reader;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AreaOneViewController {

    @FXML
    private ImageView CPlayerImageView;

    @FXML
    private Text CAreaNum;

    @FXML
    public void initialize(int nRow, int nCol) {
        GridPane.setRowIndex(this.CPlayerImageView, nRow);
        GridPane.setColumnIndex(this.CPlayerImageView, nCol);
    }

    @FXML
    private void leftButtonClicked(MouseEvent event) {
        int nCol = GridPane.getColumnIndex(this.CPlayerImageView);
        if(nCol > 0) {
            nCol--;
            GridPane.setColumnIndex(this.CPlayerImageView, nCol);
            if(Area.creatureSpawning()) {
                try {
                    FXMLLoader CLoader = new FXMLLoader(getClass().getResource("../ViewsAndControllers/BattleView.fxml"));
                    Parent CRoot = CLoader.load();

                    BattleViewController CBattleViewController = CLoader.getController();

                    CBattleViewController.initialize(CAreaNum.getText(), 0, GridPane.getColumnIndex(this.CPlayerImageView));

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
    }

    @FXML
    private void rightButtonClicked(MouseEvent event) {
        int nCol = GridPane.getColumnIndex(this.CPlayerImageView);
        if(nCol < 5) {
            nCol++;
            GridPane.setColumnIndex(this.CPlayerImageView, nCol);
            if(Area.creatureSpawning()) {
                try {
                    FXMLLoader CLoader = new FXMLLoader(getClass().getResource("../ViewsAndControllers/BattleView.fxml"));
                    Parent CRoot = CLoader.load();

                    BattleViewController CBattleViewController = CLoader.getController();

                    CBattleViewController.initialize(CAreaNum.getText(), 0, GridPane.getColumnIndex(this.CPlayerImageView));
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
