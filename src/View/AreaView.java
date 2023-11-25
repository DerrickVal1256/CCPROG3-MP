package View;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class AreaView {

    private Button    CButtonUp,
                      CButtonDown,
                      CButtonLeft,
                      CButtonRight;
    private Rectangle CRectangleBlack;
    public AreaView() {
        this.CButtonUp = new Button();
        this.CButtonDown = new Button();
        this.CButtonLeft = new Button();
        this.CButtonRight = new Button();
        this.CRectangleBlack = new Rectangle(100, 100);

        String strHoverStyle = "-fx-background-color: #e0e0e0; -fx-padding: 8px; -fx-border-color: BLACK; -fx-border-width: 2;";
        String strExitStyle = "-fx-background-color: transparent; -fx-padding: 8px; -fx-border-color: BLACK; -fx-border-width: 2;";

        Image CButtonMove = new Image("images/MenuImages/triangle.png");
        ImageView CButtonUpImageView = new ImageView(CButtonMove);
        CButtonUpImageView.setFitWidth(80);
        CButtonUpImageView.setFitHeight(80);

        ImageView CButtonDownImageView = new ImageView(CButtonMove);
        CButtonDownImageView.setFitWidth(80);
        CButtonDownImageView.setFitHeight(80);
        CButtonDownImageView.setRotate(180);

        ImageView CButtonLeftImageView = new ImageView(CButtonMove);
        CButtonLeftImageView.setFitWidth(80);
        CButtonLeftImageView.setFitHeight(80);
        CButtonLeftImageView.setRotate(-90);

        ImageView CButtonRightImageView = new ImageView(CButtonMove);
        CButtonRightImageView.setFitWidth(80);
        CButtonRightImageView.setFitHeight(80);
        CButtonRightImageView.setRotate(90);

        this.CRectangleBlack.setFill(Color.BLACK);
        this.CRectangleBlack.setLayoutX(254);
        this.CRectangleBlack.setLayoutY(456);

        /* Button Up */

        this.CButtonUp.setGraphic(CButtonUpImageView);
        this.CButtonUp.setMaxWidth(100);
        this.CButtonUp.setMaxWidth(100);
        this.CButtonUp.setLayoutX(254);
        this.CButtonUp.setLayoutY(357);
        this.CButtonUp.setStyle(strExitStyle);

        this.CButtonUp.setOnMouseEntered(e -> this.CButtonUp.setStyle(strHoverStyle));
        this.CButtonUp.setOnMouseExited(e -> this.CButtonUp.setStyle(strExitStyle));

        /* Button Down */

        this.CButtonDown.setGraphic(CButtonDownImageView);
        this.CButtonDown.setMaxWidth(100);
        this.CButtonDown.setMaxWidth(100);
        this.CButtonDown.setLayoutX(254);
        this.CButtonDown.setLayoutY(555);
        this.CButtonDown.setStyle(strExitStyle);

        this.CButtonDown.setOnMouseEntered(e -> this.CButtonDown.setStyle(strHoverStyle));
        this.CButtonDown.setOnMouseExited(e -> this.CButtonDown.setStyle(strExitStyle));

        /* Button Left */

        this.CButtonLeft.setGraphic(CButtonLeftImageView);
        this.CButtonLeft.setMaxWidth(100);
        this.CButtonLeft.setMaxWidth(100);
        this.CButtonLeft.setLayoutX(155);
        this.CButtonLeft.setLayoutY(456);
        this.CButtonLeft.setStyle(strExitStyle);

        this.CButtonLeft.setOnMouseEntered(e -> this.CButtonLeft.setStyle(strHoverStyle));
        this.CButtonLeft.setOnMouseExited(e -> this.CButtonLeft.setStyle(strExitStyle));

        /* Button Right */

        this.CButtonRight.setGraphic(CButtonRightImageView);
        this.CButtonRight.setMaxWidth(100);
        this.CButtonRight.setMaxWidth(100);
        this.CButtonRight.setLayoutX(353);
        this.CButtonRight.setLayoutY(456);
        this.CButtonRight.setStyle(strExitStyle);

        this.CButtonRight.setOnMouseEntered(e -> this.CButtonRight.setStyle(strHoverStyle));
        this.CButtonRight.setOnMouseExited(e -> this.CButtonRight.setStyle(strExitStyle));
    }

    public Scene certainAreaView(int nArea) {
        Pane CPane = new Pane();
        GridPane CGridPane = new GridPane();

        CGridPane.setLayoutX(0);
        CGridPane.setLayoutY(0);

        /* Default Area dimensions (Area 1) */

        int nRows = 0;
        int nCols = 5;

        if(nArea == 2) {
            nRows = 3;
            nCols = 3;
        } else {
            nRows = 4;
            nCols = 4;
        }

        for(int i = 0; i <= nRows; i++) {
            for(int j = 0; j <= nCols; j++) {
                Rectangle CRectangle = new Rectangle(150, 150);
                CRectangle.setFill(Color.WHITE);
                CRectangle.setStroke(Color.BLACK);
                CRectangle.setStrokeWidth(2);

                CGridPane.add(CRectangle, i, j);
            }
        }


        CPane.getChildren().addAll(this.CButtonUp, this.CButtonDown, this.CButtonLeft, this.CButtonRight, this.CRectangleBlack, CGridPane);

        return new Scene(CPane, 1920, 1080);
    }

}
