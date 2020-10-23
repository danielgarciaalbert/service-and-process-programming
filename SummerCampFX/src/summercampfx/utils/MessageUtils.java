package summercampfx.utils;

import javafx.scene.control.Alert;

public class MessageUtils {
    public static void showError(String header, String message) {
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setHeaderText(header);
        errorAlert.setContentText(message);
        errorAlert.showAndWait();
    }
    public static void showMessage(String header, String message) {}
}
