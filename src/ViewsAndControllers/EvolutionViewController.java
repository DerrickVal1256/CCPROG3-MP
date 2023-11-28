package ViewsAndControllers;

import Model.Evolution;
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
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EvolutionViewController implements Initializable {
    private PlayerData CPlayerDataHolder;
    private Player CPlayer;
    @FXML
    private ImageView creature1Image;
    @FXML
    private ImageView creature2Image;
    @FXML
    private ChoiceBox<String> selectCreature1;
    @FXML
    private ChoiceBox<String> selectCreature2;
    @FXML
    private Button evolveButton;
    @FXML
    private Button backButton;
    @FXML
    private Text creature1Name;
    @FXML
    private Text creature2Name;
    @FXML
    private Text creature1Level;
    @FXML
    private Text creature2Level;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.CPlayerDataHolder = PlayerData.getPlayerData();
        this.CPlayer = CPlayerDataHolder.getPlayer();
        this.displayCreatures(selectCreature1);
        selectCreature1.setOnAction(this::returnCreature1);
        selectCreature2.setOnAction(this::returnCreature2);
      }

    private void displayCreatures(ChoiceBox<String> temp) {
        temp.getItems().clear();
        for(CreatureEvo1 CCreature: CPlayer.getPlayerInventory().getCreatures()){
            temp.getItems().add(CCreature.getName());
      }
    }

    private void displayCreatures2(ChoiceBox<String> temp2, String strCreatureName) {
        temp2.getItems().clear();
        int nTempID = CPlayer.getPlayerInventory().getSpecificCreature(strCreatureName).getUniqueID();
        for(CreatureEvo1 CCreature: CPlayer.getPlayerInventory().getCreatures()){
            if(CCreature.getName().equals(strCreatureName) && CCreature.getUniqueID() != nTempID)
                temp2.getItems().add(CCreature.getName());
        }
    }

    @FXML
    private void returnCreature1(ActionEvent event) {
       String tempName = this.selectCreature1.getValue();
       CreatureEvo1 temp = this.CPlayer.getPlayerInventory().getSpecificCreature(tempName);
       this.creature1Name.setText(temp.getName());
       this.creature1Level.setText(String.valueOf(temp.getLevel()));
       this.creature1Image.setImage(new Image(getClass().getResource("../images/Creatures/"+ tempName +".png").toExternalForm()));
       this.displayCreatures2(selectCreature2, tempName);
    }

    @FXML
    private void returnCreature2(ActionEvent event) {
       String tempName = selectCreature2.getValue();
       CreatureEvo1 temp = CPlayer.getPlayerInventory().getSpecificCreature(tempName);
       creature2Name.setText(temp.getName());
       creature2Level.setText(String.valueOf(temp.getLevel()));
       creature2Image.setImage(new Image(getClass().getResource("../images/Creatures/"+ tempName +".png").toExternalForm()));
    }

   @FXML
   private void backButtonPressed(ActionEvent event) {
       try {
           Parent CRoot = FXMLLoader.load(getClass().getResource("../ViewsAndControllers/MainMenuView.fxml"));
           Scene CScene = new Scene(CRoot);
           Node CNode = (Node) event.getSource();
           Stage CStage = (Stage) CNode.getScene().getWindow();

           CStage.setScene(CScene);
           CStage.show();
            }catch (Exception error) {
                error.printStackTrace();
            }
       }

   @FXML
   private void evolveButtonPressed(ActionEvent event) throws IOException {
        Evolution CEvolve = new Evolution();
        CreatureEvo1 CTemp1 = CPlayer.getPlayerInventory().getSpecificCreature(selectCreature1.getValue());
        CreatureEvo1 CTemp2 = CPlayer.getPlayerInventory().getNextInstanceOfCreature(selectCreature2.getValue());
        if(CEvolve.evolve(this.CPlayer, CTemp1, CTemp2)) {
            PlayerData CPlayerDataHolder = PlayerData.getPlayerData();
            CPlayerDataHolder.setPlayer(this.CPlayer); 
            CreatureEvo1 evolvedTemp = CPlayer.getPlayerInventory().getCreatures().get(CPlayer.getPlayerInventory().getCreatures().size()-1);

            try{
                FXMLLoader CLoader = new FXMLLoader(getClass().getResource("../ViewsAndControllers/EvolvedView.fxml"));
                Parent CRoot = CLoader.load();

                EvolvedViewController CEvolutionViewController = CLoader.getController();
                CEvolutionViewController.initialize(CPlayer.getPlayerInventory().getCreatures().get(CPlayer.getPlayerInventory().getCreatures().size() - 1));
                
                Scene CScene = new Scene(CRoot);
                Node CNode = (Node) event.getSource();
                Stage CStage = (Stage) CNode.getScene().getWindow();

                CStage.setScene(CScene);
                CStage.show();
            }catch (Exception error) {
                error.printStackTrace();
            }
        } else {
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
}
