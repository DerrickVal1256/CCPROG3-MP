package ViewsAndControllers;

import Model.CreatureEvo1;

import Model.Player;
import Model.PlayerData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.text.Text;


public class EvolvedViewController {
    @FXML
    private ImageView evolvedCreatureImage;
    @FXML
    private Text evolutionText;
    @FXML
    private Button backButton;

    @FXML
    public void initialize(CreatureEvo1 CEvolvedCreature) {
        String strName = CEvolvedCreature.getName();
        this.evolutionText.setText(strName);
        this.evolvedCreatureImage.setImage(new Image(getClass().getResource("../images/Creatures/"+ strName + ".png").toExternalForm()));
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

}
