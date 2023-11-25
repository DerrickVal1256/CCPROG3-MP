package Controller;

import Model.Player;
import Model.PlayerData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

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
        System.out.println("Button Clicked");
    }

    @FXML
    public void chocowoolButtonClicked(ActionEvent event) {
        System.out.println("Button Clicked");
    }

    @FXML
    public void parwfitButtonClicked(ActionEvent event) {

    }

    @FXML
    public void brownisaurButtonClicked(ActionEvent event) {
        System.out.println("Button Clicked");
    }

    @FXML
    public void frubatButtonClicked(ActionEvent event) {

    }

    @FXML
    public void maltsButtonClicked(ActionEvent event) {

    }

    @FXML
    public void squirpieButtonClicked(ActionEvent event) {
        System.out.println("Button Clicked");
    }

    @FXML
    public void chocoliteButtonClicked(ActionEvent event) {

    }

    @FXML
    public void oshaconeButtonClicked(ActionEvent event) {

    }

}
