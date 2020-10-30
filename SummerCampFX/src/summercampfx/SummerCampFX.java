package summercampfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * SummerCampFX class is the one in charge of launch the application
 * @author Daniel García
 */
public class SummerCampFX extends Application {

    /**
     * This method launch de application and sets some properties
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("FXMLMainView.fxml"));
        primaryStage.setTitle("SummerCampFX");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.resizableProperty().setValue(false);
        primaryStage.show();
    }

    /**
     * This is the main method of the application
     */
    public static void main(String[] args) {
        launch(args);
    }
}
