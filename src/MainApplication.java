import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainApplication extends Application {

    private Game CGame;
    private CreatureView CCreatureView;

    public MainApplication() {
        this.CCreatureView = new CreatureView();
    }

    @Override
    public void start(Stage FStage) throws Exception {
        Group FGroup = new Group();
        Scene FScene = new Scene(FGroup, 1920, 1080, Color.WHITE);
        Game CGame = new Game(this.CCreatureView, FStage);

        Image FIcon = new Image("images/icon.png");
        FStage.getIcons().add(FIcon);
        FStage.setResizable(false);

        FStage.setTitle("Creaturemon");
        FStage.setScene(this.CCreatureView.starterCreature());
        FStage.show();

        CGame.startGameApp();
    }

    public CreatureView getCreatureView() {
        return this.CCreatureView;
    }
}
