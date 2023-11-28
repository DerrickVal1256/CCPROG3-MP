package ViewsAndControllers;

import Model.Area;
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

public class AreaTwoViewController {
    @FXML
    private ImageView CPlayerImageView;

    @FXML
    private GridPane CGridPane;

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
            this.CGridPane.setColumnIndex(this.CPlayerImageView, nCol);
            if(Area.creatureSpawning()) {
                try {
                    FXMLLoader CLoader = new FXMLLoader(getClass().getResource("../ViewsAndControllers/BattleView.fxml"));
                    Parent CRoot = CLoader.load();

                    BattleViewController CBattleViewController = CLoader.getController();

                    CBattleViewController.initialize(CAreaNum.getText(), GridPane.getRowIndex(this.CPlayerImageView), GridPane.getColumnIndex(this.CPlayerImageView));

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
        if(nCol < 2) {
            nCol++;
            this.CGridPane.setColumnIndex(this.CPlayerImageView, nCol);
            if(Area.creatureSpawning()) {
                try {
                    FXMLLoader CLoader = new FXMLLoader(getClass().getResource("../ViewsAndControllers/BattleView.fxml"));
                    Parent CRoot = CLoader.load();

                    BattleViewController CBattleViewController = CLoader.getController();

                    CBattleViewController.initialize(CAreaNum.getText(), GridPane.getRowIndex(this.CPlayerImageView), GridPane.getColumnIndex(this.CPlayerImageView));
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
    private void upButtonClicked(MouseEvent event) {
        int nRow = GridPane.getRowIndex(this.CPlayerImageView);
        if(nRow > 0) {
            nRow--;
            this.CGridPane.setRowIndex(this.CPlayerImageView, nRow);
            if(Area.creatureSpawning()) {
                try {
                    FXMLLoader CLoader = new FXMLLoader(getClass().getResource("../ViewsAndControllers/BattleView.fxml"));
                    Parent CRoot = CLoader.load();

                    BattleViewController CBattleViewController = CLoader.getController();

                    CBattleViewController.initialize(CAreaNum.getText(), GridPane.getRowIndex(this.CPlayerImageView), GridPane.getColumnIndex(this.CPlayerImageView));
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
    private void downButtonClicked(MouseEvent event) {
        int nRow = GridPane.getRowIndex(this.CPlayerImageView);
        if(nRow < 2) {
            nRow++;
            this.CGridPane.setRowIndex(this.CPlayerImageView, nRow);
            if(Area.creatureSpawning()) {
                try {
                    FXMLLoader CLoader = new FXMLLoader(getClass().getResource("../ViewsAndControllers/BattleView.fxml"));
                    Parent CRoot = CLoader.load();

                    BattleViewController CBattleViewController = CLoader.getController();

                    CBattleViewController.initialize(CAreaNum.getText(), GridPane.getRowIndex(this.CPlayerImageView), GridPane.getColumnIndex(this.CPlayerImageView));
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
