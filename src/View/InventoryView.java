package View;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;

public class InventoryView {
    private ArrayList<Button> aInventoryButtons;

    public InventoryView() {
        this.aInventoryButtons = new ArrayList<Button>();
    }


    public Scene displayInventory(ArrayList<String> aInventoryCreatures) {

        StackPane CStackLayout = new StackPane();
        GridPane CGridLayout = new GridPane();
         

        /* These are to create a gray border around the button when hovering over them */
        String strHoverStyle = "-fx-background-color: #e0e0e0; -fx-padding: 12px;";
        String strExitStyle = "-fx-background-color: transparent; -fx-padding: 12px;";

        Rectangle CRectangle = new Rectangle(1000, 700);
        CRectangle.setStroke(Color.BLACK);
        CRectangle.setFill(null);
        CRectangle.setStrokeWidth(2);
        StackPane.setAlignment(CRectangle, Pos.CENTER);
        StackPane.setMargin(CRectangle, new Insets(10, 10, 10, 10));

        return new Scene(new StackPane(CStackLayout, CGridLayout), 1920, 1080);
    }



    public ArrayList<Button> getInventoryButtons() {
        return this.aInventoryButtons;
    }

}
