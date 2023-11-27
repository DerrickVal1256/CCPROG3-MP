package Controller;

import Model.CreatureEvo1;
import Model.Player;
import Model.PlayerData;
import Model.Reader;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.text.Text;

import java.io.FileReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class InventoryViewController implements Initializable {
    public Player CPlayer = new Player();
    @FXML
    private ChoiceBox<String> CCreatureChoiceBox;
    @FXML
    private Label CCreatureName1;
    @FXML
    private Label CCreatureName2;
    @FXML
    private ImageView CCreatureImage1;
    @FXML
    private ImageView CCreatureImage2;
    @FXML
    private Text CCurrentType;
    @FXML
    private Text CCurrentFamily;
    @FXML
    private Text CCurrentEvolutionLevel;
    @FXML
    private Text CSelectedType;
    @FXML
    private Text CSelectedFamily;
    @FXML
    private Text CSelectedEvolutionLevel;
    @FXML
    private Button CSwapCreature;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        CPlayer.getPlayerInventory().addCreature(new CreatureEvo1("derk", "water", 'a', 2));
        CPlayer.getPlayerInventory().addCreature(new CreatureEvo1("name2", "water2", 'b', 3));
        CPlayer.getPlayerInventory().addCreature(new CreatureEvo1("name3", "water3", 'c', 1));
        getCurrent(new ActionEvent());
        for (CreatureEvo1 CCreatures : CPlayer.getPlayerInventory().getCreatures()) {
            String tempName = CCreatures.getName();
            CCreatureChoiceBox.getItems().add(tempName);
        }
        CCreatureChoiceBox.setOnAction(this::getSelected);

    }

    @FXML
    private void getSelected(ActionEvent event) {
        String choice = CCreatureChoiceBox.getValue();
        CreatureEvo1 temp = CPlayer.getPlayerInventory().getSpecificCreature(choice);
        String selectedType = temp.getType();
        char selectedFamily = temp.getFamily();
        int selectedLevel = temp.getLevel();

        CCreatureName2.setText(choice);
        //CCreatureImage2.setImage(new Image(choice + ".png"));
        CSelectedType.setText(selectedType);
        CSelectedFamily.setText(String.valueOf(selectedFamily));
        CSelectedEvolutionLevel.setText(String.valueOf(selectedLevel));
    }

    @FXML
    private void getCurrent(ActionEvent event) {
        String currentName = CPlayer.getPlayerInventory().getActive().getName();
        String currentType = CPlayer.getPlayerInventory().getActive().getType();
        char currentFamily = CPlayer.getPlayerInventory().getActive().getFamily();
        int currentLevel = CPlayer.getPlayerInventory().getActive().getLevel();

        CCreatureName1.setText(currentName);
        //CCreatureImage1.setImage(new Image(currentName + ".png"));
        CCurrentType.setText(currentType);
        CCurrentFamily.setText(String.valueOf(currentFamily));
        CCurrentEvolutionLevel.setText(String.valueOf(currentLevel));
        CCurrentEvolutionLevel.setText(String.valueOf(currentLevel));
    }

    @FXML
    private void swapCreature(ActionEvent event) {
       CPlayer.getPlayerInventory().swapCreatures(CCreatureChoiceBox.getValue());
            try {
                Parent CRoot = FXMLLoader.load(getClass().getResource("../View/InventoryView.fxml")); // change to Main Menu View
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

