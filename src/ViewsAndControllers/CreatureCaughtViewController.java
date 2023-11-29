package ViewsAndControllers;

import Model.CreatureEvo1;
import Model.Sound;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class CreatureCaughtViewController {

    @FXML
    private Text CCreatureCaughtText;

    @FXML
    private ImageView CCreatureCaught;

    @FXML
    private ImageView CCreatureCaughtType;

    @FXML
    public void initialize(CreatureEvo1 CCreatureCaught) {
        this.CCreatureCaughtText.setText(CCreatureCaught.getName() + " was successfully caught!");
        this.CCreatureCaught.setImage(new Image(getClass().getResource("../images/Creatures/" + CCreatureCaught.getName() +".png").toExternalForm()));
        this.CCreatureCaughtType.setImage(this.creatureIcon(CCreatureCaught.getType()));
    }

    @FXML
    private void exitButtonClicked(ActionEvent event) {
        try {
            Parent CRoot = FXMLLoader.load(getClass().getResource("../ViewsAndControllers/MainMenuView.fxml"));
            Scene CScene = new Scene(CRoot);
            Node CNode = (Node) event.getSource();
            Stage CStage = (Stage) CNode.getScene().getWindow();

            Sound CSound = Sound.getInstance();
            CSound.play("PkmRS_Littleroot.wav", -1);

            CStage.setScene(CScene);
            CStage.show();
        } catch (Exception error) {
            error.printStackTrace();
        }
    }

    private Image creatureIcon(String strType){
        if(strType.equals("Grass")) {
            return new Image("images/MenuImages/grass.png");
        } else if(strType.equals("Fire")){
            return new Image("images/MenuImages/fire.png");
        } else {
            return new Image("images/MenuImages/water.png");
        }
    }
}
