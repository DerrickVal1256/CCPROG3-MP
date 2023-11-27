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
import javafx.stage.Stage;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class AreaOneViewController {

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
            if(Area.creatureSpawning()) {
                try {
                    Parent CRoot = FXMLLoader.load(getClass().getResource("../ViewsAndControllers/BattleView.fxml"));
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
            this.CGridPane.setColumnIndex(this.CPlayerImageView, nCol);
            if(Area.creatureSpawning()) {
                try {
                    Parent CRoot = FXMLLoader.load(getClass().getResource("../ViewsAndControllers/BattleView.fxml"));
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

    public String randomCreature() throws IOException {
        Random CRandom = new Random();
        Reader CReader = new Reader(new FileReader("CreaturesList.txt"));
        Set<String> mapKeys = new HashSet<String>();
        int randomIndex = 0;
        /*
         * this is used to generate a list of creatures based on the area number
         */
        for (Map.Entry<String, CreatureEvo1> CEntry : CReader.creatureEvo1FileReader().entrySet()) {
            CreatureEvo1 CCreature = CEntry.getValue();
        }

        String[] strKeys = mapKeys.toArray(new String[0]);

        randomIndex = CRandom.nextInt(strKeys.length);

        return strKeys[randomIndex];
    }

}
