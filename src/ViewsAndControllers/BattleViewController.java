package ViewsAndControllers;

import Model.Area;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class BattleViewController {
    @FXML
    private Text CEnemyNameText;

    @FXML
    private Text CEnemyEvoLevelText;

    @FXML
    private Text CPlayerNameText;

    @FXML
    private Text CPlayerEvoLevelText;

    @FXML
    private ImageView CPlayerTypeIcon;

    @FXML
    private ImageView CEnemyTypeIcon;

    @FXML
    private Rectangle CHPBarOne;

    @FXML
    private Rectangle CHPBarTwo;

    @FXML
    private Rectangle CHPBarThree;

    @FXML
    private Rectangle CHPBarFour;

    @FXML
    private Rectangle CHPBarFive;

    @FXML
    public void initialize() {

    }
}
