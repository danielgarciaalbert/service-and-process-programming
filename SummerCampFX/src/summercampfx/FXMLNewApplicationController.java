package summercampfx;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import summercampfx.model.Course;
import summercampfx.utils.FileUtils;
import summercampfx.utils.MessageUtils;
import summercampfx.utils.SceneLoader;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

/**
 * FXMLNewApplicationController is the class in charge of controlling the create application view
 * @author Daniel García
 */
public class FXMLNewApplicationController implements Initializable {
    @FXML
    public TextField txtName;
    @FXML
    public DatePicker dateBirthday;
    @FXML
    public TextField txtSurname;
    @FXML
    public ComboBox comboCourse;
    @FXML
    public Button btnAddApplication;

    /**
     * The initialize method will be called every time the class is created.
     * It's useful for fill the combo Courses
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboCourse.setItems(FXCollections.observableArrayList(FileUtils.loadCourses()));
    }

    /**
     * This method creates a new app if all the fields contain data
    * @param actionEvent
    */
    public void addApplication(ActionEvent actionEvent) {
        try {
            if (txtName.getText().equals("")
                    || txtSurname.getText().equals("")
                    || dateBirthday.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) == null
                    || comboCourse.getSelectionModel().getSelectedItem() == null) {
                MessageUtils.showError("Empty field",
                        "No field can be left empty");
            } else {
                String application = txtName.getText() + ";" + txtSurname.getText() + ";" +
                        dateBirthday.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ";" +
                        ((Course) comboCourse.getSelectionModel().getSelectedItem()).toStringWithSemicolon() ;

                FileUtils.saveApp(application);
                SceneLoader.loadScene("/summercampfx/FXMLMainView.fxml",
                        (Stage) ((Node) actionEvent.getSource()).getScene().getWindow());
            }
        } catch (Exception e) {
            MessageUtils.showError("Create new application",
                    "An error occurred while trying to create a new application");
            System.out.println(e);
        }
    }
}
