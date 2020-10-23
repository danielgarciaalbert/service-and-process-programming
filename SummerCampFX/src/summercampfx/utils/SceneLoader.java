package summercampfx.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneLoader {
    public static void loadScene(String viewPath, Stage stage) throws IOException {
        Parent root = FXMLLoader.load(SceneLoader.class.getResource(viewPath));
        Scene viewScene = new Scene(root);
        stage.setScene(viewScene);
    }
}
