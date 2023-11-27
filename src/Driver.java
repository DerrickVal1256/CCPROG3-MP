<<<<<<< Updated upstream
import javafx.application.*;
import Driver.*;
=======
import javafx.application.Application;
import Driver.MainApplication;
>>>>>>> Stashed changes
/**
 * The driver class 
 */
public class Driver {
    /**
     * The main method of the program
     * @param args The standard driver arguments
     * @throws Exception if there is an error in running the driver
     */
    public static void main(String[] args) throws Exception {
        Application.launch(MainApplication.class, args);
    }
}
