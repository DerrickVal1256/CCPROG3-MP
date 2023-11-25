package View;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.Button;

import javax.swing.*;

public class StarterCreatureView {

    private Button CStarterButton1,
                   CStarterButton2,
                   CStarterButton3,
                   CStarterButton4,
                   CStarterButton5,
                   CStarterButton6,
                   CStarterButton7,
                   CStarterButton8,
                   CStarterButton9;

    public StarterCreatureView() {
        this.CStarterButton1 = new Button();
        this.CStarterButton2 = new Button();
        this.CStarterButton3 = new Button();
        this.CStarterButton4 = new Button();
        this.CStarterButton5 = new Button();
        this.CStarterButton6 = new Button();
        this.CStarterButton7 = new Button();
        this.CStarterButton8 = new Button();
        this.CStarterButton9 = new Button();
    }

    /**
     * Displays the starter creature selection menu.
     */
    public Scene starterCreature(){
        StackPane CStackLayout = new StackPane();
        GridPane CGridLayout = new GridPane();

        /* These are to create a gray border around the button when hovering over them */
        String strHoverStyle = "-fx-background-color: #e0e0e0; -fx-padding: 12px;";
        String strExitStyle = "-fx-background-color: transparent; -fx-padding: 12px;";

        /* For the buttons to have the same size */
        double DVBoxWidth = 120;
        double DVBoxHeight = 160;
        double DImageWidth = 80;

        Rectangle CRectangle = new Rectangle(700, 1000);
        CRectangle.setStroke(Color.BLACK);
        CRectangle.setFill(null);
        CRectangle.setStrokeWidth(2);
        StackPane.setAlignment(CRectangle, Pos.CENTER);
        StackPane.setMargin(CRectangle, new Insets(10, 10, 10, 10));

        Image CStarter1 = new Image("images/A/1.png");
        Image CStarter2 = new Image("images/B/1.png");
        Image CStarter3 = new Image("images/C/1.png");
        Image CStarter4 = new Image("images/D/1.png");
        Image CStarter5 = new Image("images/E/1.png");
        Image CStarter6 = new Image("images/F/1.png");
        Image CStarter7 = new Image("images/G/1.png");
        Image CStarter8 = new Image("images/H/1.png");
        Image CStarter9 = new Image("images/I/1.png");

        ImageView CImageView1 = new ImageView(CStarter1);
        CImageView1.setPreserveRatio(true);
        CImageView1.setFitWidth(100);

        ImageView CImageView2 = new ImageView(CStarter2);
        CImageView2.setPreserveRatio(true);
        CImageView2.setFitWidth(100);

        ImageView CImageView3 = new ImageView(CStarter3);
        CImageView3.setPreserveRatio(true);
        CImageView3.setFitWidth(100);

        ImageView CImageView4 = new ImageView(CStarter4);
        CImageView4.setPreserveRatio(true);
        CImageView4.setFitWidth(100);

        ImageView CImageView5 = new ImageView(CStarter5);
        CImageView5.setPreserveRatio(true);
        CImageView5.setFitWidth(100);

        ImageView CImageView6 = new ImageView(CStarter6);
        CImageView6.setPreserveRatio(true);
        CImageView6.setFitWidth(100);

        ImageView CImageView7 = new ImageView(CStarter7);
        CImageView7.setPreserveRatio(true);
        CImageView7.setFitWidth(100);

        ImageView CImageView8 = new ImageView(CStarter8);
        CImageView8.setPreserveRatio(true);
        CImageView8.setFitWidth(100);

        ImageView CImageView9 = new ImageView(CStarter9);
        CImageView9.setPreserveRatio(true);
        CImageView9.setFitWidth(100);

        /* Strawander */

        Text CBText1 = new Text("STRAWANDER");
        CBText1.setFill(Color.WHITE);
        CBText1.setFont(Font.font("Ebrima", 12));
        CBText1.setStyle("-fx-font-weight: bold;");

        Rectangle CBRectangle1 = new Rectangle(105, 30);
        CBRectangle1.setFill(Color.web("#db424a"));

        Line CBTopBorder1 = new Line(0, 0, 103, 0);
        CBTopBorder1.setStroke(Color.BLACK);
        CBTopBorder1.setStrokeWidth(2);

        StackPane CBLayout1 = new StackPane(CBRectangle1, CBText1, CBTopBorder1);
        CBLayout1.setAlignment(Pos.CENTER);
        CBLayout1.setAlignment(CBTopBorder1, Pos.TOP_CENTER);

        VBox CBVBox1 = new VBox(CImageView1, CBLayout1);
        CBVBox1.setAlignment(Pos.CENTER);
        CBVBox1.setSpacing(10);
        CBVBox1.setStyle("-fx-border-color: BLACK; -fx-border-width: 2;");

        this.CStarterButton1.setGraphic(CBVBox1);
        this.CStarterButton1.setStyle(strExitStyle);

        /* Chocowool */

        Text CBText2 = new Text("CHOCOWOOL");
        CBText2.setFill(Color.WHITE);
        CBText2.setFont(Font.font("Ebrima", 12));
        CBText2.setStyle("-fx-font-weight: bold;");

        Rectangle CBRectangle2 = new Rectangle(105, 30);
        CBRectangle2.setFill(Color.web("#db424a"));

        Line CBTopBorder2 = new Line(0, 0, 103, 0);
        CBTopBorder2.setStroke(Color.BLACK);
        CBTopBorder2.setStrokeWidth(2);

        StackPane CBLayout2 = new StackPane(CBRectangle2, CBText2, CBTopBorder2);
        CBLayout2.setAlignment(Pos.CENTER);
        CBLayout2.setAlignment(CBTopBorder2, Pos.TOP_CENTER);

        VBox CBVBox2 = new VBox(CImageView2, CBLayout2);
        CBVBox2.setAlignment(Pos.CENTER);
        CBVBox2.setSpacing(10);
        CBVBox2.setStyle("-fx-border-color: BLACK; -fx-border-width: 2;");


        this.CStarterButton2.setGraphic(CBVBox2);
        this.CStarterButton2.setStyle(strExitStyle);

        /* Parfwit */

        Text CBText3 = new Text("PARFWIT");
        CBText3.setFill(Color.WHITE);
        CBText3.setFont(Font.font("Ebrima", 12));
        CBText3.setStyle("-fx-font-weight: bold;");

        Rectangle CBRectangle3 = new Rectangle(105, 30);
        CBRectangle3.setFill(Color.web("#db424a"));

        Line CBTopBorder3 = new Line(0, 0, 103, 0);
        CBTopBorder3.setStroke(Color.BLACK);
        CBTopBorder3.setStrokeWidth(2);

        StackPane CBLayout3 = new StackPane(CBRectangle3, CBText3, CBTopBorder3);
        CBLayout3.setAlignment(Pos.CENTER);
        CBLayout3.setAlignment(CBTopBorder3, Pos.TOP_CENTER);

        VBox CBVBox3 = new VBox(CImageView3, CBLayout3);
        CBVBox3.setAlignment(Pos.CENTER);
        CBVBox3.setSpacing(10);
        CBVBox3.setStyle("-fx-border-color: BLACK; -fx-border-width: 2;");
//        CBVBox3.setMinSize(DVBoxWidth, DVBoxHeight);
//        CBVBox3.setMaxSize(DVBoxWidth, DVBoxHeight);

        this.CStarterButton3.setGraphic(CBVBox3);
        this.CStarterButton3.setStyle(strExitStyle);

        /* Brownisaur */

        Text CBText4 = new Text("BROWNISAUR");
        CBText4.setFill(Color.WHITE);
        CBText4.setFont(Font.font("Ebrima", 12));
        CBText4.setStyle("-fx-font-weight: bold;");

        Rectangle CBRectangle4 = new Rectangle(105, 30);
        CBRectangle4.setFill(Color.web("#449f4d"));

        Line CBTopBorder4 = new Line(0, 0, 103, 0);
        CBTopBorder4.setStroke(Color.BLACK);
        CBTopBorder4.setStrokeWidth(2);

        StackPane CBLayout4 = new StackPane(CBRectangle4, CBText4, CBTopBorder4);
        CBLayout4.setAlignment(Pos.CENTER);
        CBLayout4.setAlignment(CBTopBorder4, Pos.TOP_CENTER);

        VBox CBVBox4 = new VBox(CImageView4, CBLayout4);
        CBVBox4.setAlignment(Pos.CENTER);
        CBVBox4.setSpacing(10);
        CBVBox4.setStyle("-fx-border-color: BLACK; -fx-border-width: 2;");
//        CBVBox4.setMinSize(DVBoxWidth, DVBoxHeight);
//        CBVBox4.setMaxSize(DVBoxWidth, DVBoxHeight);

        this.CStarterButton4.setGraphic(CBVBox4);
        this.CStarterButton4.setStyle(strExitStyle);

        /* Frubat */

        Text CBText5 = new Text("FRUBAT");
        CBText5.setFill(Color.WHITE);
        CBText5.setFont(Font.font("Ebrima", 12));
        CBText5.setStyle("-fx-font-weight: bold;");

        Rectangle CBRectangle5 = new Rectangle(105, 30);
        CBRectangle5.setFill(Color.web("#449f4d"));

        Line CBTopBorder5 = new Line(0, 0, 103, 0);
        CBTopBorder5.setStroke(Color.BLACK);
        CBTopBorder5.setStrokeWidth(2);

        StackPane CBLayout5 = new StackPane(CBRectangle5, CBText5, CBTopBorder5);
        CBLayout5.setAlignment(Pos.CENTER);
        CBLayout5.setAlignment(CBTopBorder5, Pos.TOP_CENTER);

        VBox CBVBox5 = new VBox(CImageView5, CBLayout5);
        CBVBox5.setAlignment(Pos.CENTER);
        CBVBox5.setSpacing(10);
        CBVBox5.setStyle("-fx-border-color: BLACK; -fx-border-width: 2;");
//        CBVBox5.setMinSize(DVBoxWidth, DVBoxHeight);
//        CBVBox5.setMaxSize(DVBoxWidth, DVBoxHeight);

        this.CStarterButton5.setGraphic(CBVBox5);
        this.CStarterButton5.setStyle(strExitStyle);

        /* Malts */

        Text CBText6 = new Text("MALTS");
        CBText6.setFill(Color.WHITE);
        CBText6.setFont(Font.font("Ebrima", 12));
        CBText6.setStyle("-fx-font-weight: bold;");

        Rectangle CBRectangle6 = new Rectangle(105, 30);
        CBRectangle6.setFill(Color.web("#449f4d"));

        Line CBTopBorder6 = new Line(0, 0, 103, 0);
        CBTopBorder6.setStroke(Color.BLACK);
        CBTopBorder6.setStrokeWidth(2);

        StackPane CBLayout6 = new StackPane(CBRectangle6, CBText6, CBTopBorder6);
        CBLayout6.setAlignment(Pos.CENTER);
        CBLayout6.setAlignment(CBTopBorder6, Pos.TOP_CENTER);

        VBox CBVBox6 = new VBox(CImageView6, CBLayout6);
        CBVBox6.setAlignment(Pos.CENTER);
        CBVBox6.setSpacing(10);
        CBVBox6.setStyle("-fx-border-color: BLACK; -fx-border-width: 2;");
//        CBVBox6.setMinSize(DVBoxWidth, DVBoxHeight);
//        CBVBox6.setMaxSize(DVBoxWidth, DVBoxHeight);

        this.CStarterButton6.setGraphic(CBVBox6);
        this.CStarterButton6.setStyle(strExitStyle);

        /* Squirpie */

        Text CBText7 = new Text("SQUIRPIE");
        CBText7.setFill(Color.WHITE);
        CBText7.setFont(Font.font("Ebrima", 12));
        CBText7.setStyle("-fx-font-weight: bold;");

        Rectangle CBRectangle7 = new Rectangle(105, 30);
        CBRectangle7.setFill(Color.web("#56b8e2"));

        Line CBTopBorder7 = new Line(0, 0, 103, 0);
        CBTopBorder7.setStroke(Color.BLACK);
        CBTopBorder7.setStrokeWidth(2);

        StackPane CBLayout7 = new StackPane(CBRectangle7, CBText7, CBTopBorder7);
        CBLayout7.setAlignment(Pos.CENTER);
        CBLayout7.setAlignment(CBTopBorder7, Pos.TOP_CENTER);

        VBox CBVBox7 = new VBox(CImageView7, CBLayout7);
        CBVBox7.setAlignment(Pos.CENTER);
        CBVBox7.setSpacing(10);
        CBVBox7.setStyle("-fx-border-color: BLACK; -fx-border-width: 2;");
//        CBVBox7.setMinSize(DVBoxWidth, DVBoxHeight);
//        CBVBox7.setMaxSize(DVBoxWidth, DVBoxHeight);

        this.CStarterButton7.setGraphic(CBVBox7);
        this.CStarterButton7.setStyle(strExitStyle);

        /* Chocolite */

        Text CBText8 = new Text("CHOCOLITE");
        CBText8.setFill(Color.WHITE);
        CBText8.setFont(Font.font("Ebrima", 12));
        CBText8.setStyle("-fx-font-weight: bold;");

        Rectangle CBRectangle8 = new Rectangle(105, 30);
        CBRectangle8.setFill(Color.web("#56b8e2"));

        Line CBTopBorder8 = new Line(0, 0, 103, 0);
        CBTopBorder8.setStroke(Color.BLACK);
        CBTopBorder8.setStrokeWidth(2);

        StackPane CBLayout8 = new StackPane(CBRectangle8, CBText8, CBTopBorder8);
        CBLayout8.setAlignment(Pos.CENTER);
        CBLayout8.setAlignment(CBTopBorder8, Pos.TOP_CENTER);

        VBox CBVBox8 = new VBox(CImageView8, CBLayout8);
        CBVBox8.setAlignment(Pos.CENTER);
        CBVBox8.setSpacing(10);
        CBVBox8.setStyle("-fx-border-color: BLACK; -fx-border-width: 2;");
//        CBVBox8.setMinSize(DVBoxWidth, DVBoxHeight);
//        CBVBox8.setMaxSize(DVBoxWidth, DVBoxHeight);

        this.CStarterButton8.setGraphic(CBVBox8);
        this.CStarterButton8.setStyle(strExitStyle);


        /* Oshacone */

        Text CBText9 = new Text("OSHACONE");
        CBText9.setFill(Color.WHITE);
        CBText9.setFont(Font.font("Ebrima", 12));
        CBText9.setStyle("-fx-font-weight: bold;");

        Rectangle CBRectangle9 = new Rectangle(105, 30);
        CBRectangle9.setFill(Color.web("#56b8e2"));

        Line CBTopBorder9 = new Line(0, 0, 103, 0);
        CBTopBorder9.setStroke(Color.BLACK);
        CBTopBorder9.setStrokeWidth(2);

        StackPane CBLayout9 = new StackPane(CBRectangle9, CBText9, CBTopBorder9);
        CBLayout9.setAlignment(Pos.CENTER);
        CBLayout9.setAlignment(CBTopBorder9, Pos.TOP_CENTER);

        VBox CBVBox9 = new VBox(CImageView9, CBLayout9);
        CBVBox9.setAlignment(Pos.CENTER);
        CBVBox9.setSpacing(10);
        CBVBox9.setStyle("-fx-border-color: BLACK; -fx-border-width: 2;");
//        CBVBox9.setMinSize(DVBoxWidth, DVBoxHeight);
//        CBVBox9.setMaxSize(DVBoxWidth, DVBoxHeight);

        this.CStarterButton9.setGraphic(CBVBox9);
        this.CStarterButton9.setStyle(strExitStyle);

        /* Adding the buttons to the grid inside the rectangle */

        CGridLayout.add(this.CStarterButton1, 0, 0);
        CGridLayout.add(this.CStarterButton2, 1, 0);
        CGridLayout.add(this.CStarterButton3, 2,0);
        CGridLayout.add(this.CStarterButton4, 0, 1);
        CGridLayout.add(this.CStarterButton5, 1, 1);
        CGridLayout.add(this.CStarterButton6, 2,1);
        CGridLayout.add(this.CStarterButton7, 0, 2);
        CGridLayout.add(this.CStarterButton8, 1, 2);
        CGridLayout.add(this.CStarterButton9, 2,2);

        CGridLayout.setAlignment(Pos.CENTER);
        CGridLayout.setHgap(80);
        CGridLayout.setVgap(80);

        this.CStarterButton1.setOnMouseEntered(e -> this.CStarterButton1.setStyle(strHoverStyle));
        this.CStarterButton1.setOnMouseExited(e -> this.CStarterButton1.setStyle(strExitStyle));

        this.CStarterButton2.setOnMouseEntered(e -> this.CStarterButton2.setStyle(strHoverStyle));
        this.CStarterButton2.setOnMouseExited(e -> this.CStarterButton2.setStyle(strExitStyle));

        this.CStarterButton3.setOnMouseEntered(e -> this.CStarterButton3.setStyle(strHoverStyle));
        this.CStarterButton3.setOnMouseExited(e -> this.CStarterButton3.setStyle(strExitStyle));

        this.CStarterButton4.setOnMouseEntered(e -> this.CStarterButton4.setStyle(strHoverStyle));
        this.CStarterButton4.setOnMouseExited(e -> this.CStarterButton4.setStyle(strExitStyle));

        this.CStarterButton5.setOnMouseEntered(e -> this.CStarterButton5.setStyle(strHoverStyle));
        this.CStarterButton5.setOnMouseExited(e -> this.CStarterButton5.setStyle(strExitStyle));

        this.CStarterButton6.setOnMouseEntered(e -> this.CStarterButton6.setStyle(strHoverStyle));
        this.CStarterButton6.setOnMouseExited(e -> this.CStarterButton6.setStyle(strExitStyle));

        this.CStarterButton7.setOnMouseEntered(e -> this.CStarterButton7.setStyle(strHoverStyle));
        this.CStarterButton7.setOnMouseExited(e -> this.CStarterButton7.setStyle(strExitStyle));

        this.CStarterButton8.setOnMouseEntered(e -> this.CStarterButton8.setStyle(strHoverStyle));
        this.CStarterButton8.setOnMouseExited(e -> this.CStarterButton8.setStyle(strExitStyle));

        this.CStarterButton9.setOnMouseEntered(e -> this.CStarterButton9.setStyle(strHoverStyle));
        this.CStarterButton9.setOnMouseExited(e -> this.CStarterButton9.setStyle(strExitStyle));

        Text CStarterText = new Text("Choose your starter!");
        CStarterText.setFont(Font.font("Pokemon Hollow", 40));
        StackPane.setAlignment(CStarterText, Pos.TOP_CENTER);
        StackPane.setMargin(CStarterText, new Insets(100, 10, 10, 10));

        CStackLayout.setAlignment(Pos.CENTER);
        CStackLayout.getChildren().addAll(CRectangle, CStarterText);

        return new Scene(new StackPane(CStackLayout, CGridLayout), 1920, 1080);
    }

    public Scene starterAdded(String CreatureName) {
        StackPane CStackPane = new StackPane();

        Text CSuccessText = new Text("Successfully added " + CreatureName + " to your inventory!");
        CSuccessText.setFont(Font.font("Pokemon Hollow", 40));

        CStackPane.setAlignment(Pos.CENTER);
        CStackPane.getChildren().add(CSuccessText);

        return new Scene(CStackPane, 1920, 1080, Color.WHITE);
    }

    public Button getStarterButton1() {
        return this.CStarterButton1;
    }

    public Button getStarterButton2() {
        return this.CStarterButton2;
    }

    public Button getStarterButton3() {
        return this.CStarterButton3;
    }
    public Button getStarterButton4() {
        return this.CStarterButton4;
    }

    public Button getStarterButton5() {
        return this.CStarterButton5;
    }

    public Button getStarterButton6() {
        return this.CStarterButton6;
    }

    public Button getStarterButton7() {
        return this.CStarterButton7;
    }

    public Button getStarterButton8() {
        return this.CStarterButton8;
    }

    public Button getStarterButton9() {
        return this.CStarterButton9;
    }

}
