package ViewsAndControllers;

import Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
    private Text CDamageText;

    @FXML
    private ImageView CEnemyImageView;

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
    private AnchorPane CSwapCreaturePane;

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

    private String strAreaNum;
    private int nPlayerPrevRow;

    private int nPlayerPrevColumn;

    private Player CPlayer;

    private CreatureEvo1 CPlayerCreature;

    private CreatureEvo1 CEnemyCreature;

    private BattlePhase CBattlePhase;

    private PlayerData CPlayerDataHolder;

    @FXML
    public void initialize(String strAreaNum, int nPlayerPrevRow, int nPlayerPrevColumn) {
        try {
            Area CArea = new Area(strAreaNum);
            this.CEnemyCreature = CArea.randomCreature();
            this.strAreaNum = strAreaNum;
            this.nPlayerPrevRow = nPlayerPrevRow;
            this.nPlayerPrevColumn = nPlayerPrevColumn;
            PlayerData CPlayerDateHolder = PlayerData.getPlayerData();
            this.CPlayer = CPlayerDateHolder.getPlayer();
            this.CPlayerCreature = this.CPlayer.getPlayerInventory().getActive();
            this.CBattlePhase = new BattlePhase(this.CPlayerCreature, this.CEnemyCreature);

            /* Adding and setting contents to nodes in the view */
            this.CEnemyNameText.setText(this.CEnemyNameText.getText() + " " + this.CEnemyCreature.getName());
            this.CEnemyEvoLevelText.setText(this.CEnemyEvoLevelText.getText() + " " + this.CEnemyCreature.getLevel());
            this.CEnemyImageView.setImage(new Image(getClass().getResource("../images/Creatures/" + this.CEnemyCreature.getName() + ".png").toExternalForm()));
            this.CEnemyTypeIcon.setImage(creatureIcon(this.CEnemyCreature.getType()));

            this.CPlayerNameText.setText(this.CPlayerNameText.getText() + " " + CPlayer.getPlayerInventory().getActive().getName());
            this.CPlayerEvoLevelText.setText(this.CPlayerEvoLevelText.getText() + " " + CPlayer.getPlayerInventory().getActive().getLevel());
            this.CPlayerTypeIcon.setImage(creatureIcon(CPlayer.getPlayerInventory().getActive().getType()));

            this.CDamageText.setText("");
            this.CDamageText.setVisible(false);

            this.CSwapCreaturePane.setVisible(false);

        } catch (Exception error) {
            error.printStackTrace();
        }
    }

    @FXML
    private void attackButtonClicked(MouseEvent event) throws Exception {
        int nDamage = this.CBattlePhase.playerAttack();
        this.CDamageText.setText(CEnemyCreature.getName() + " was hit for " + nDamage);
        this.CDamageText.setVisible(true);
        StackPane.setAlignment(this.CDamageText, Pos.CENTER);

        if(this.CBattlePhase.getEnemyHP() < 40) {
            this.CHPBarFive.setVisible(false);
        }

        if(this.CBattlePhase.getEnemyHP() < 30) {
            this.CHPBarFour.setVisible(false);
        }

        if(this.CBattlePhase.getEnemyHP() < 20) {
            this.CHPBarThree.setVisible(false);
        }

        if(this.CBattlePhase.getEnemyHP() < 10) {
            this.CHPBarTwo.setVisible(false);
        }

        if(this.CBattlePhase.getEnemyHP() < 0) {
            this.CHPBarOne.setVisible(false);
        }

        if(this.CBattlePhase.getMoves() == 0  || this.CBattlePhase.getEnemyHP() <= 0) {
            this.returnToAreaView(event);
        }
    }

    @FXML
    private void swapCreatureButtonClicked(MouseEvent event) {
        this.CSwapCreaturePane.setVisible(true);
        this.CPlayerDataHolder = PlayerData.getPlayerData();
        this.CPlayer = CPlayerDataHolder.getPlayer();
        this.getCurrent(CPlayer);
        this.displayCreatures();
        this.CCreatureChoiceBox.setOnAction(this::getCurrentSelected);
    }

    @FXML
    private void catchButtonClicked(MouseEvent event) throws Exception {
        boolean nCaught = false;
        if(this.CBattlePhase.catchCreature(this.CPlayer)) {
            nCaught = true;
            try {
                FXMLLoader CLoader = new FXMLLoader(getClass().getResource("../ViewsAndControllers/CreatureCaughtView.fxml"));
                Parent CRoot = CLoader.load();

                CreatureCaughtViewController CCreatureCaughtView = CLoader.getController();
                CCreatureCaughtView.initialize(this.CBattlePhase.getEnemyCreature());

                Scene CScene = new Scene(CRoot);
                Node CNode = (Node) event.getSource();
                Stage CStage = (Stage) CNode.getScene().getWindow();

                CStage.setScene(CScene);
                CStage.show();
            } catch (Exception error) {
                error.printStackTrace();
            }
        } else if(CBattlePhase.getMoves() == 0) {
            this.returnToAreaView(event);
        }
    }

    @FXML
    private void returnToAreaView(MouseEvent event) {
        FXMLLoader CLoader;
        Parent CRoot;
        try {
            if(this.strAreaNum.contains("One")) {
                CLoader = new FXMLLoader(getClass().getResource("../ViewsAndControllers/AreaOneView.fxml"));
                CRoot = CLoader.load();

                AreaOneViewController CAreaOneController = CLoader.getController();
                CAreaOneController.initialize(this.nPlayerPrevRow, this.nPlayerPrevColumn);

            } else if(this.strAreaNum.contains("Two")) {
                CLoader = new FXMLLoader(getClass().getResource("../ViewsAndControllers/AreaTwoView.fxml"));
                CRoot = CLoader.load();

                AreaTwoViewController CAreaTwoViewController = CLoader.getController();
                CAreaTwoViewController.initialize(this.nPlayerPrevRow, this.nPlayerPrevColumn);

            } else {
                CLoader = new FXMLLoader(getClass().getResource("../ViewsAndControllers/AreaThreeView.fxml"));
                CRoot = CLoader.load();

                AreaThreeViewController CAreaThreeViewController = CLoader.getController();
                CAreaThreeViewController.initialize(this.nPlayerPrevRow, this.nPlayerPrevColumn);
            }

            Scene CScene = new Scene(CRoot);

            Node CNode = (Node) event.getSource();
            Stage CStage = (Stage) CNode.getScene().getWindow();

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
        if(this.CPlayer.getPlayerInventory().getCreatures().size() > 1) {
            String strSelectedCreatureName = CCreatureChoiceBox.getValue();
            int nTempID = CPlayer.getPlayerInventory().getSpecificCreature(strSelectedCreatureName).getUniqueID();
            CPlayer.getPlayerInventory().activeCreature(strSelectedCreatureName, nTempID);

            this.CBattlePhase.setMoves(this.CBattlePhase.getMoves() - 1);
            this.CSwapCreaturePane.setVisible(false);
            this.CCreatureChoiceBox.getItems().clear();

            this.CPlayerNameText.setText("Name: " + CPlayer.getPlayerInventory().getActive().getName());
            this.CPlayerEvoLevelText.setText("EvoLevel: " + CPlayer.getPlayerInventory().getActive().getLevel());
            this.CPlayerTypeIcon.setImage(creatureIcon(CPlayer.getPlayerInventory().getActive().getType()));

            if(this.CBattlePhase.getMoves() == 0) {
                this.returnToAreaView(event);
                this.CPlayerDataHolder.setPlayer(this.CPlayer);
                this.getCurrent(CPlayer);
                this.displayCreatures();

                this.CSwapCreaturePane.setVisible(false);
            }
        } else {
            this.CSwapCreaturePane.setVisible(false);
        }
    }
    @FXML
    private void backButtonPressed(MouseEvent event) {
        this.CSwapCreaturePane.setVisible(false);
    }
}
