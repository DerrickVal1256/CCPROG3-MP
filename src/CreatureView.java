import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.awt.event.ActionListener;

public class CreatureView extends VBox {

    private Button FStarterButton1, FStarterButton2, FStarterButton3;

    public CreatureView() {
        this.FStarterButton1 = null;
        this.FStarterButton2 = null;
        this.FStarterButton3 = null;
    }

    /**
     * Displays the starter creature selection menu.
     */
    public Scene starterCreature(){
        StackPane FStackLayout = new StackPane();
        GridPane FGridLayout = new GridPane();

        Rectangle FRectangle = new Rectangle(700, 500);
        FRectangle.setStroke(Color.BLACK);
        FRectangle.setFill(null);
        FRectangle.setStrokeWidth(2);
        StackPane.setAlignment(FRectangle, Pos.CENTER);
        StackPane.setMargin(FRectangle, new Insets(10, 10, 10, 10));

        Image FStarter1 = new Image("images/Strawander.jpg");
        Image FStarter2 = new Image("images/Brownisaur.jpg");
        Image FStarter3 = new Image("images/Squirpie.jpg");

        ImageView FImageView1 = new ImageView(FStarter1);
        FImageView1.setPreserveRatio(true);
        FImageView1.setFitWidth(100);

        ImageView FImageView2 = new ImageView(FStarter2);
        FImageView2.setPreserveRatio(true);
        FImageView2.setFitWidth(100);

        ImageView FImageView3 = new ImageView(FStarter3);
        FImageView3.setPreserveRatio(true);
        FImageView3.setFitWidth(100);

        /* Strawander */

        this.FStarterButton1 = new Button();

        Text FBText1 = new Text("STRAWANDER");
        FBText1.setFill(Color.WHITE);
        FBText1.setFont(Font.font("Ebrima", 12));
        FBText1.setStyle("-fx-font-weight: bold;");

        Rectangle FBRectangle1 = new Rectangle(105, 30);
        FBRectangle1.setFill(Color.web("#db424a"));

        Line FBTopBorder1 = new Line(0, 0, 103, 0);
        FBTopBorder1.setStroke(Color.BLACK);
        FBTopBorder1.setStrokeWidth(2);

        StackPane FBLayout1 = new StackPane(FBRectangle1, FBText1, FBTopBorder1);
        FBLayout1.setAlignment(Pos.CENTER);
        FBLayout1.setAlignment(FBTopBorder1, Pos.TOP_CENTER);

        VBox FBVBox1 = new VBox(FImageView1, FBLayout1);
        FBVBox1.setAlignment(Pos.CENTER);
        FBVBox1.setSpacing(10);
        FBVBox1.setStyle("-fx-border-color: BLACK; -fx-border-width: 2;");

        this.FStarterButton1.setGraphic(FBVBox1);
        this.FStarterButton1.setStyle("-fx-background-color: WHITE;");

        /* Brownisaur */

        this.FStarterButton2 = new Button();

        Text FBText2 = new Text("BROWNISAUR");
        FBText2.setFill(Color.WHITE);
        FBText2.setFont(Font.font("Ebrima", 12));
        FBText2.setStyle("-fx-font-weight: bold;");

        Rectangle FBRectangle2 = new Rectangle(105, 30);
        FBRectangle2.setFill(Color.web("#449f4d"));

        Line FBTopBorder2 = new Line(0, 0, 103, 0);
        FBTopBorder2.setStroke(Color.BLACK);
        FBTopBorder2.setStrokeWidth(2);

        StackPane FBLayout2 = new StackPane(FBRectangle2, FBText2, FBTopBorder2);
        FBLayout2.setAlignment(Pos.CENTER);
        FBLayout2.setAlignment(FBTopBorder2, Pos.TOP_CENTER);

        VBox FBVBox2 = new VBox(FImageView2, FBLayout2);
        FBVBox2.setAlignment(Pos.CENTER);
        FBVBox2.setSpacing(10);
        FBVBox2.setStyle("-fx-border-color: BLACK; -fx-border-width: 2;");

        this.FStarterButton2.setGraphic(FBVBox2);
        this.FStarterButton2.setStyle("-fx-background-color: WHITE;");

        /* Squirpie */

        this.FStarterButton3 = new Button();

        Text FBText3 = new Text("SQUIRPIE");
        FBText3.setFill(Color.WHITE);
        FBText3.setFont(Font.font("Ebrima", 12));
        FBText3.setStyle("-fx-font-weight: bold;");

        Rectangle FBRectangle3 = new Rectangle(105, 30);
        FBRectangle3.setFill(Color.web("#56b8e2"));

        Line FBTopBorder3 = new Line(0, 0, 103, 0);
        FBTopBorder3.setStroke(Color.BLACK);
        FBTopBorder3.setStrokeWidth(2);

        StackPane FBLayout3 = new StackPane(FBRectangle3, FBText3, FBTopBorder3);
        FBLayout3.setAlignment(Pos.CENTER);
        FBLayout3.setAlignment(FBTopBorder3, Pos.TOP_CENTER);

        VBox FBVBox3 = new VBox(FImageView3, FBLayout3);
        FBVBox3.setAlignment(Pos.CENTER);
        FBVBox3.setSpacing(10);
        FBVBox3.setStyle("-fx-border-color: BLACK; -fx-border-width: 2;");

        this.FStarterButton3.setGraphic(FBVBox3);
        this.FStarterButton3.setStyle("-fx-background-color: WHITE;");

        FGridLayout.add(this.FStarterButton1, 0, 0);
        FGridLayout.add(this.FStarterButton2, 1, 0);
        FGridLayout.add(this.FStarterButton3, 2,0);

        FGridLayout.setAlignment(Pos.CENTER);
        FGridLayout.setHgap(80);
        FGridLayout.setVgap(80);

//        FGridLayout.setGridLinesVisible(true);

        String strHoverStyle = "-fx-background-color: #e0e0e0; -fx-padding: 12px;";
        String strExitStyle = "-fx-background-color: transparent; -fx-padding: 10px;";

        this.FStarterButton1.setOnMouseEntered(e -> this.FStarterButton1.setStyle(strHoverStyle));
        this.FStarterButton1.setOnMouseExited(e -> this.FStarterButton1.setStyle(strExitStyle));

        this.FStarterButton2.setOnMouseEntered(e -> this.FStarterButton2.setStyle(strHoverStyle));
        this.FStarterButton2.setOnMouseExited(e -> this.FStarterButton2.setStyle(strExitStyle));

        this.FStarterButton3.setOnMouseEntered(e -> this.FStarterButton3.setStyle(strHoverStyle));
        this.FStarterButton3.setOnMouseExited(e -> this.FStarterButton3.setStyle(strExitStyle));

        Text FStarterText = new Text("Choose your starter!");
        FStarterText.setFont(Font.font("Pokemon Hollow", 40));
        StackPane.setAlignment(FStarterText, Pos.TOP_CENTER);
        StackPane.setMargin(FStarterText, new Insets(200, 10, 10, 10));

        FStackLayout.setAlignment(Pos.CENTER);
        FStackLayout.getChildren().addAll(FRectangle, FStarterText);

        return new Scene(new StackPane(FStackLayout, FGridLayout), 1920, 1080);
    }

    public Scene display() {
        Group FGroup = new Group();
        return new Scene(FGroup, 1920, 1080, Color.BLACK);
    }

//    public Scene displayAddedStarter() {
//
//    }

    public Button getStarterButton1() {
        return this.FStarterButton1;
    }

    public Button getStarterButton2() {
        return this.FStarterButton2;
    }

    public Button getStarterButton3() {
        return this.FStarterButton3;
    }

}
