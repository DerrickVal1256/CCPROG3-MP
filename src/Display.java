import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
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


/**
* This class provides methods for displaying various game menus.
*/
public class Display extends VBox{

    public Display() {

    }
    /**
    * Displays the main menu.
    */
//    public Scene mainMenu(){
//        System.out.println("\t\t\t************************************");
//        System.out.println("\t\t\t|            Main Menu             |");
//        System.out.println("\t\t\t|                                  |");
//        System.out.println("\t\t\t|        [1] View Inventory        |");
//        System.out.println("\t\t\t|        [2] Explore an Area       |");
//        System.out.println("\t\t\t|        [3] Evolve Creature       |");
//        System.out.println("\t\t\t|        [4] Exit                  |");
//        System.out.println("\t\t\t|                                  |");
//        System.out.println("\t\t\t************************************");
//        return new Scene(800, 800);
//    }

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

    public Button getButton(Button FButton) {
        return FButton;
    }


}
