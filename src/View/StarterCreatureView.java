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

public class StarterCreatureView extends VBox {

    private Button CStarterButton1,
                   CStarterButton2,
                   CStarterButton3;

    public StarterCreatureView() {
        this.CStarterButton1 = new Button();
        this.CStarterButton2 = new Button();
        this.CStarterButton3 = new Button();
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

        Rectangle CRectangle = new Rectangle(700, 500);
        CRectangle.setStroke(Color.BLACK);
        CRectangle.setFill(null);
        CRectangle.setStrokeWidth(2);
        StackPane.setAlignment(CRectangle, Pos.CENTER);
        StackPane.setMargin(CRectangle, new Insets(10, 10, 10, 10));

        Image CStarter1 = new Image("images/A/1.png");
        Image CStarter2 = new Image("images/D/1.png");
        Image CStarter3 = new Image("images/G/1.png");

        ImageView CImageView1 = new ImageView(CStarter1);
        CImageView1.setPreserveRatio(true);
        CImageView1.setFitWidth(100);

        ImageView CImageView2 = new ImageView(CStarter2);
        CImageView2.setPreserveRatio(true);
        CImageView2.setFitWidth(100);

        ImageView CImageView3 = new ImageView(CStarter3);
        CImageView3.setPreserveRatio(true);
        CImageView3.setFitWidth(100);

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

        /* Brownisaur */

        Text CBText2 = new Text("BROWNISAUR");
        CBText2.setFill(Color.WHITE);
        CBText2.setFont(Font.font("Ebrima", 12));
        CBText2.setStyle("-fx-font-weight: bold;");

        Rectangle CBRectangle2 = new Rectangle(105, 30);
        CBRectangle2.setFill(Color.web("#449f4d"));

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

        /* Squirpie */

        Text CBText3 = new Text("SQUIRPIE");
        CBText3.setFill(Color.WHITE);
        CBText3.setFont(Font.font("Ebrima", 12));
        CBText3.setStyle("-fx-font-weight: bold;");

        Rectangle CBRectangle3 = new Rectangle(105, 30);
        CBRectangle3.setFill(Color.web("#56b8e2"));

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

        this.CStarterButton3.setGraphic(CBVBox3);
        this.CStarterButton3.setStyle(strExitStyle);

        /* Adding the buttons to the grid inside the rectangle */

        CGridLayout.add(this.CStarterButton1, 0, 0);
        CGridLayout.add(this.CStarterButton2, 1, 0);
        CGridLayout.add(this.CStarterButton3, 2,0);

        CGridLayout.setAlignment(Pos.CENTER);
        CGridLayout.setHgap(80);
        CGridLayout.setVgap(80);

        this.CStarterButton1.setOnMouseEntered(e -> this.CStarterButton1.setStyle(strHoverStyle));
        this.CStarterButton1.setOnMouseExited(e -> this.CStarterButton1.setStyle(strExitStyle));

        this.CStarterButton2.setOnMouseEntered(e -> this.CStarterButton2.setStyle(strHoverStyle));
        this.CStarterButton2.setOnMouseExited(e -> this.CStarterButton2.setStyle(strExitStyle));

        this.CStarterButton3.setOnMouseEntered(e -> this.CStarterButton3.setStyle(strHoverStyle));
        this.CStarterButton3.setOnMouseExited(e -> this.CStarterButton3.setStyle(strExitStyle));

        Text CStarterText = new Text("Choose your starter!");
        CStarterText.setFont(Font.font("Pokemon Hollow", 40));
        StackPane.setAlignment(CStarterText, Pos.TOP_CENTER);
        StackPane.setMargin(CStarterText, new Insets(200, 10, 10, 10));

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

}
