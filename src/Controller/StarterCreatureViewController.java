package Controller;

import Model.CreatureEvo1;
import Model.Player;
import Model.PlayerData;
import Model.Reader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StarterCreatureViewController {

    @FXML
    private void receiveUsername(ActionEvent event) {
        PlayerData CPlayerDataHolder = PlayerData.getPlayerData();
        Player CPlayer = CPlayerDataHolder.getPlayer();
        String strUsername = CPlayer.getUsername();
        System.out.println(strUsername);
    }

    @FXML
    public void strawanderButtonClicked(ActionEvent event) {
        this.givePlayerCreature("Strawander");
        this.showMainMenu(event);

//        PlayerData CPlayerDataHolder = PlayerData.getPlayerData();
//        Player CPlayer = CPlayerDataHolder.getPlayer();
//        CPlayer.getPlayerInventory().printInventory();
    }

    @FXML
    public void chocowoolButtonClicked(ActionEvent event) {
        this.givePlayerCreature("Chocowool");
        this.showMainMenu(event);
    }

    @FXML
    public void parfwitButtonClicked(ActionEvent event) {
        this.givePlayerCreature("Parwfit");
        this.showMainMenu(event);
    }

    @FXML
    public void brownisaurButtonClicked(ActionEvent event) {
        this.givePlayerCreature("Brownisaur");
        this.showMainMenu(event);
    }

    @FXML
    public void frubatButtonClicked(ActionEvent event) {
        this.givePlayerCreature("Frubat");
        this.showMainMenu(event);
    }

    @FXML
    public void maltsButtonClicked(ActionEvent event) {
        this.givePlayerCreature("Malts");
        this.showMainMenu(event);
    }

    @FXML
    public void squirpieButtonClicked(ActionEvent event) {
        this.givePlayerCreature("Squirpie");
        this.showMainMenu(event);
    }

    @FXML
    public void chocoliteButtonClicked(ActionEvent event) {
        this.givePlayerCreature("Chocolite");
        this.showMainMenu(event);
    }

    @FXML
    public void oshaconeButtonClicked(ActionEvent event) {
        this.givePlayerCreature("Oshacone");
        this.showMainMenu(event);
    }

    private void givePlayerCreature(String strCreatureName) {
        Map<String, CreatureEvo1> mapEvoOneCreatures = new HashMap<>();
        Player CPlayer = new Player();

        try {

            Reader CReader = new Reader(new FileReader("CreaturesList.txt"));
            PlayerData CPlayerDataHolder = PlayerData.getPlayerData();

            mapEvoOneCreatures = CReader.creatureEvo1FileReader();
            CPlayer.getPlayerInventory().addCreature(mapEvoOneCreatures.get(strCreatureName));
            CPlayerDataHolder.setPlayer(CPlayer);

        } catch(Exception error) {
            error.printStackTrace();
        }
    }

    @FXML
    private void showMainMenu(ActionEvent event) {
        try {
            Parent CRoot = FXMLLoader.load(getClass().getResource("../View/IntroView.fxml")); // change to Main Menu View
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
