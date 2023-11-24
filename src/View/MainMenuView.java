package View;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.Button;


/**
* This class provides methods for displaying various game menus.
*/
public class MainMenuView {
    private Button CViewInventoryButton,
                   CExploreAreaButton,
                   CEvolveCreatureButton,
                   CExitButton,
                   CAreaOneButton,
                   CAreaTwoButton,
                   CAreaThreeButton;

    public MainMenuView() {
        this.CViewInventoryButton = new Button();
        this.CExploreAreaButton = new Button();
        this.CEvolveCreatureButton = new Button();
        this.CExitButton = new Button();
        this.CAreaOneButton = new Button();
        this.CAreaTwoButton = new Button();
        this.CAreaThreeButton = new Button();
    }

    public Scene mainMenu() {
        StackPane CStackLayout = new StackPane();
        GridPane CGridLayout = new GridPane();

        /* Rectangle for border the menu */
        Rectangle CRectangle = new Rectangle(500, 700);
        CRectangle.setStroke(Color.BLACK);
        CRectangle.setFill(null);
        CRectangle.setStrokeWidth(2);
        StackPane.setAlignment(CRectangle, Pos.CENTER);
        StackPane.setMargin(CRectangle, new Insets(10, 10, 10, 10));

        /* These are to create a gray border around the button when hovering over them */
        String strHoverStyle = "-fx-background-color: #e0e0e0; -fx-padding: 12px;";
        String strExitStyle = "-fx-background-color: transparent; -fx-padding: 12px;";

        /* Different Images for the buttons */
        Image CInventoryImage = new Image("images/MenuImages/inventory.png");
        Image CExploreAreaImage = new Image("images/MenuImages/explore.jpg");
        Image CEvolveImage = new Image("images/MenuImages/evolve.png");
        Image CExit = new Image("images/MenuImages/exit.png");

        /* ImageViews for the buttons' HBoxes */
        ImageView CInventoryImageView = new ImageView(CInventoryImage);
        CInventoryImageView.setPreserveRatio(true);
        CInventoryImageView.setFitWidth(80);

        ImageView CExploreAreaImageView = new ImageView(CExploreAreaImage);
        CExploreAreaImageView.setPreserveRatio(true);
        CExploreAreaImageView.setFitWidth(80);

        ImageView CEvolveImageView = new ImageView(CEvolveImage);
        CEvolveImageView.setPreserveRatio(true);
        CEvolveImageView.setFitWidth(80);

        ImageView CExitImageView = new ImageView(CExit);
        CExitImageView.setPreserveRatio(true);
        CExitImageView.setFitWidth(80);

        Text CMenuTitle = new Text("Main Menu");
        CMenuTitle.setFont(Font.font("Pokemon Hollow", 40));
        StackPane.setAlignment(CMenuTitle, Pos.TOP_CENTER);
        StackPane.setMargin(CMenuTitle, new Insets(200, 10, 10, 10));

        /* View Inventory  */

        Text CViewInventoryText = new Text(" View Inventory ");
        CViewInventoryText.setFill(Color.BLACK);
        CViewInventoryText.setFont(Font.font("Ebrima", 18));

        Line CBSideBorder1 = new Line(0, 0, 0, 80);
        CBSideBorder1.setStroke(Color.BLACK);
        CBSideBorder1.setStrokeWidth(2);

        HBox CBHBox1 = new HBox(CInventoryImageView, CBSideBorder1, CViewInventoryText);
        CBHBox1.setAlignment(Pos.CENTER_LEFT);
        CBHBox1.setStyle("-fx-border-color: BLACK; -fx-border-width: 2;");

        this.CViewInventoryButton.setGraphic(CBHBox1);
        this.CViewInventoryButton.setStyle(strExitStyle);

        /* Explore Area  */

        Text CExploreAreaText = new Text(" Explore an Area ");
        CExploreAreaText.setFill(Color.BLACK);
        CExploreAreaText.setFont(Font.font("Ebrima", 18));

        Line CBSideBorder2 = new Line(0, 0, 0, 80);
        CBSideBorder2.setStroke(Color.BLACK);
        CBSideBorder2.setStrokeWidth(2);

        HBox CBHBox2 = new HBox(CExploreAreaImageView, CBSideBorder2, CExploreAreaText);
        CBHBox2.setAlignment(Pos.CENTER_LEFT);
        CBHBox2.setStyle("-fx-border-color: BLACK; -fx-border-width: 2;");

        this.CExploreAreaButton.setGraphic(CBHBox2);
        this.CExploreAreaButton.setStyle(strExitStyle);

        /* Evolve Creature */

        Text CEvolveCreatureText = new Text(" Evolve Creature ");
        CExploreAreaText.setFill(Color.BLACK);
        CEvolveCreatureText.setFont(Font.font("Ebrima", 18));

        Line CBSideBorder3 = new Line(0, 0, 0, 80);
        CBSideBorder3.setStroke(Color.BLACK);
        CBSideBorder3.setStrokeWidth(2);

        HBox CBHBox3 = new HBox(CEvolveImageView, CBSideBorder3, CEvolveCreatureText);
        CBHBox3.setAlignment(Pos.CENTER_LEFT);
        CBHBox3.setStyle("-fx-border-color: BLACK; -fx-border-width: 2;");

        this.CEvolveCreatureButton.setGraphic(CBHBox3);
        this.CEvolveCreatureButton.setStyle(strExitStyle);

        /* Exit */

        Text CExitText = new Text(" Exit ");
        CExitText.setFill(Color.BLACK);
        CExitText.setFont(Font.font("Ebrima", 18));

        Line CBSideBorder4 = new Line(0, 0, 0, 80);
        CBSideBorder4.setStroke(Color.BLACK);
        CBSideBorder4.setStrokeWidth(2);

        HBox CBHBox4 = new HBox(CExitImageView, CBSideBorder4, CExitText);
        CBHBox4.setAlignment(Pos.CENTER_LEFT);
        CBHBox4.setStyle("-fx-border-color: BLACK; -fx-border-width: 2;");

        this.CExitButton.setGraphic(CBHBox4);
        this.CExitButton.setStyle(strExitStyle);

        this.CViewInventoryButton.setOnMouseEntered(e -> this.CViewInventoryButton.setStyle(strHoverStyle));
        this.CViewInventoryButton.setOnMouseExited(e -> this.CViewInventoryButton.setStyle(strExitStyle));

        this.CExploreAreaButton.setOnMouseEntered(e -> this.CExploreAreaButton.setStyle(strHoverStyle));
        this.CExploreAreaButton.setOnMouseExited(e -> this.CExploreAreaButton.setStyle(strExitStyle));

        this.CEvolveCreatureButton.setOnMouseEntered(e -> this.CEvolveCreatureButton.setStyle(strHoverStyle));
        this.CEvolveCreatureButton.setOnMouseExited(e -> this.CEvolveCreatureButton.setStyle(strExitStyle));

        this.CExitButton.setOnMouseEntered(e -> this.CExitButton.setStyle(strHoverStyle));
        this.CExitButton.setOnMouseExited(e -> this.CExitButton.setStyle(strExitStyle));

        CGridLayout.add(this.CViewInventoryButton, 0, 0);
        CGridLayout.add(this.CExploreAreaButton, 0, 1);
        CGridLayout.add(this.CEvolveCreatureButton, 0, 2);
        CGridLayout.add(this.CExitButton, 0, 3);

        CGridLayout.setAlignment(Pos.CENTER);
        CGridLayout.setHgap(80);
        CGridLayout.setVgap(30);

        CStackLayout.getChildren().addAll(CRectangle, CMenuTitle);

        return new Scene(new StackPane(CStackLayout, CGridLayout), 1920, 1080);
    }

    public Scene areaPickerMenu() {
        StackPane CStackPane = new StackPane();
        GridPane CGridLayout = new GridPane();
        StackPane CMainStackPane = new StackPane();

        /* These are to create a gray border around the button when hovering over them */
        String strHoverStyle = "-fx-background-color: #e0e0e0; -fx-padding: 12px;";
        String strExitStyle = "-fx-background-color: transparent; -fx-padding: 12px;";

        /* Box Style */
        String strBoxStyle = "-fx-border-color: BLACK; -fx-border-width: 2;";

        /* Rectangle to border the menu */
        Rectangle CRectangle = new Rectangle(500, 700);
        CRectangle.setStroke(Color.BLACK);
        CRectangle.setFill(null);
        CRectangle.setStrokeWidth(2);
        StackPane.setAlignment(CRectangle, Pos.CENTER);
        StackPane.setMargin(CRectangle, new Insets(10, 10, 10, 10));

        Text CMenuTitle = new Text("Pick an Area \n to Explore");
        CMenuTitle.setFont(Font.font("Pokemon Hollow", 40));
        StackPane.setAlignment(CMenuTitle, Pos.TOP_CENTER);
        StackPane.setMargin(CMenuTitle, new Insets(200, 10, 10, 10));

        /* Area One Button */

        Text CAreaOneText = new Text(" Area One ");
        CAreaOneText.setFill(Color.BLACK);
        CAreaOneText.setFont(Font.font("Ebrima", 30));

        HBox CAreaOneBox = new HBox(CAreaOneText);
        CAreaOneBox.setStyle(strBoxStyle);

        this.CAreaOneButton.setGraphic(CAreaOneBox);
        this.CAreaOneButton.setStyle(strExitStyle);

        /* Area Two Button */

        Text CAreaTwoText = new Text(" Area Two ");
        CAreaTwoText.setFill(Color.BLACK);
        CAreaTwoText.setFont(Font.font("Ebrima", 30));

        HBox CAreaTwoBox = new HBox(CAreaTwoText);
        CAreaTwoBox.setStyle(strBoxStyle);

        this.CAreaTwoButton.setGraphic(CAreaTwoBox);
        this.CAreaTwoButton.setStyle(strExitStyle);

        /* Area Three Button */

        Text CAreaThreeText = new Text(" Area Three ");
        CAreaThreeText.setFill(Color.BLACK);
        CAreaThreeText.setFont(Font.font("Ebrima", 30));

        HBox CAreaThreeBox = new HBox(CAreaThreeText);
        CAreaThreeBox.setStyle(strBoxStyle);

        this.CAreaThreeButton.setGraphic(CAreaThreeBox);
        this.CAreaThreeButton.setStyle(strExitStyle);

        CGridLayout.add(this.CAreaOneButton, 0, 0);
        CGridLayout.add(this.CAreaTwoButton, 0, 1);
        CGridLayout.add(this.CAreaThreeButton, 0, 2);

        this.CAreaOneButton.setOnMouseEntered(e -> this.CAreaOneButton.setStyle(strHoverStyle));
        this.CAreaOneButton.setOnMouseExited(e -> this.CAreaOneButton.setStyle(strExitStyle));

        this.CAreaTwoButton.setOnMouseEntered(e -> this.CAreaTwoButton.setStyle(strHoverStyle));
        this.CAreaTwoButton.setOnMouseExited(e -> this.CAreaTwoButton.setStyle(strExitStyle));

        this.CAreaThreeButton.setOnMouseEntered(e -> this.CAreaThreeButton.setStyle(strHoverStyle));
        this.CAreaThreeButton.setOnMouseExited(e -> this.CAreaThreeButton.setStyle(strExitStyle));

        CGridLayout.setAlignment(Pos.CENTER);
        CGridLayout.setHgap(80);
        CGridLayout.setVgap(30);

        CStackPane.getChildren().addAll(CRectangle, CMenuTitle);

        CMainStackPane.getChildren().addAll(CGridLayout, CStackPane);

        Scene CAreaPickerMenu = new Scene(CMainStackPane, 1920, 1080);

        return CAreaPickerMenu;
    }

    /**
    * Displays the area selection menu.
    */
    public void areas(){
        System.out.println("\t\t\t+-------------------+");
        System.out.println("\t\t\t|       Areas       |");
        System.out.println("\t\t\t|                   |");
        System.out.println("\t\t\t|        [1]        |");
        System.out.println("\t\t\t|        [2]        |");
        System.out.println("\t\t\t|        [3]        |");
        System.out.println("\t\t\t|                   |");
        System.out.println("\t\t\t+-------------------+");
    }

    /**
    * Displays the movement options.
    */
    public void movement() {
        System.out.println("\t\t\t+-------------------+");
        System.out.println("\t\t\t|       Move        |");
        System.out.println("\t\t\t|                   |");
        System.out.println("\t\t\t|    [1] Up         |");
        System.out.println("\t\t\t|    [2] Down       |");
        System.out.println("\t\t\t|    [3] Left       |");
        System.out.println("\t\t\t|    [4] Right      |");
        System.out.println("\t\t\t|    [5] Leave      |");
        System.out.println("\t\t\t|                   |");
        System.out.println("\t\t\t+-------------------+");
    }

    /**
    * Displays the battle menu.
    */
    public void battleMenu(){
        System.out.println("\t\t\t+-------------------+");
        System.out.println("\t\t\t|      Actions      |");
        System.out.println("\t\t\t|                   |");
        System.out.println("\t\t\t|   [1] Attack      |");
        System.out.println("\t\t\t|   [2] Swap        |");
        System.out.println("\t\t\t|   [3] Catch       |");
        System.out.println("\t\t\t|   [4] Run Away    |");
        System.out.println("\t\t\t|                   |");
        System.out.println("\t\t\t+-------------------+");
    }

    public Button getViewInventoryButton() {
        return this.CViewInventoryButton;
    }

    public Button getExploreAreaButton() {
        return this.CExploreAreaButton;
    }

    public Button getEvolveCreatureButton() {
        return this.CEvolveCreatureButton;
    }

    public Button getExitButton() {
        return this.CExitButton;
    }

    public Button getCAreaOneButton() {
        return this.CAreaOneButton;
    }

    public Button getCAreaTwoButton() {
        return this.CAreaTwoButton;
    }

    public Button getCAreaThreeButton() {
        return this.CAreaThreeButton;
    }

}
