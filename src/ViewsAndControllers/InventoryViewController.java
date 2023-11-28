package ViewsAndControllers;

import Model.CreatureEvo1;
import Model.Player;
import Model.PlayerData;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class InventoryViewController implements Initializable {
    private Player CPlayer = new Player();
    private PlayerData CPlayerDataHolder = PlayerData.getPlayerData();
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
        this.CPlayerDataHolder = PlayerData.getPlayerData();
        this.CPlayer = CPlayerDataHolder.getPlayer();
        CPlayer.getPlayerInventory().printInventory();
        this.getCurrent(CPlayer);
        this.displayCreatures();
        CCreatureChoiceBox.setOnAction(this::getCurrentSelected);
    }

        private void displayCreatures(){
            for (CreatureEvo1 CCreatures : CPlayer.getPlayerInventory().getCreatures()) {
                if (!CCreatures.getStatus()){
                    String tempName = CCreatures.getName();
                    CCreatureChoiceBox.getItems().add(tempName);
                }
            }
        }
        @FXML
        private void getCurrentSelected(ActionEvent event) {
            String strChoice = CCreatureChoiceBox.getValue();

            if (strChoice != null) {
                CreatureEvo1 temp = CPlayer.getPlayerInventory().getSpecificCreature(strChoice);

                if (temp != null) {
                    this.CCreatureName2.setText(temp.getName());
                    this.CSelectedType.setText(temp.getType());
                    CCreatureImage2.setImage(new Image(getClass().getResource("../images/Creatures/" + temp.getName() + ".png").toExternalForm()));
                    this.CSelectedFamily.setText(String.valueOf(temp.getFamily()));
                    this.CSelectedEvolutionLevel.setText(String.valueOf(temp.getLevel()));
                    CCreatureChoiceBox.setOnAction(this::getCurrentSelected);
                 }
            }
        }

        @FXML
        private void getCurrent(Player CPlayer) {
            String currentName = CPlayer.getPlayerInventory().getActive().getName();
            String currentType = CPlayer.getPlayerInventory().getActive().getType();
            char currentFamily = CPlayer.getPlayerInventory().getActive().getFamily();
            int currentLevel = CPlayer.getPlayerInventory().getActive().getLevel();

            CCreatureName1.setText(currentName);
            CCreatureImage1.setImage(new Image(getClass().getResource("../images/Creatures/" + currentName + ".png").toExternalForm()));
            CCurrentType.setText(currentType);
            CCurrentFamily.setText(String.valueOf(currentFamily));
            CCurrentEvolutionLevel.setText(String.valueOf(currentLevel));
            CCurrentEvolutionLevel.setText(String.valueOf(currentLevel));
        }

        @FXML
        private void swapCreature(MouseEvent event) {
          String strSelectedCreatureName = CCreatureChoiceBox.getValue();
          int ntempID = CPlayer.getPlayerInventory().getSpecificCreature(strSelectedCreatureName).getUniqueID();
          CPlayer.getPlayerInventory().activeCreature(strSelectedCreatureName, ntempID);

          try {
              Parent CRoot = FXMLLoader.load(getClass().getResource("../ViewsAndControllers/InventoryView.fxml"));
              Scene CScene = new Scene(CRoot);
              Node CNode = (Node) event.getSource();
              Stage CStage = (Stage) CNode.getScene().getWindow();

              this.CPlayerDataHolder.setPlayer(this.CPlayer);
              CPlayer.getPlayerInventory().printInventory();
              this.getCurrent(CPlayer);
              this.displayCreatures();

              CStage.setScene(CScene);
              CStage.show();

              CCreatureChoiceBox.setValue(strSelectedCreatureName);
          } catch (Exception error) {
              error.printStackTrace();
          }
      }

    @FXML
    private void backButtonPressed(ActionEvent event) {
        try {
            Parent CRoot = FXMLLoader.load(getClass().getResource("../ViewsAndControllers/MainMenuView.fxml")); // change to Main Menu View
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

