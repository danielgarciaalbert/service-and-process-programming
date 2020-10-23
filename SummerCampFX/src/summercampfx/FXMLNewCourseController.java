package summercampfx;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class FXMLNewCourseController implements Initializable {
    @FXML
    public TextField txtName;
    @FXML
    public ComboBox comboMonth;
    @FXML
    public Button btnAddCourse;
    @FXML
    public ComboBox comboWeeksDuration;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboMonth.setItems(FXCollections.observableArrayList(new ArrayList<String>(Arrays.asList(
                "JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE",
                "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"))));
        comboWeeksDuration.setItems(FXCollections.observableArrayList(
                new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))));
    }

    public void addCourse(ActionEvent actionEvent) {
        try {
            if (txtName.getText().equals("")
                    || txtName.getText().equals("")
                    || comboMonth.getSelectionModel().getSelectedItem() == null
                    || comboWeeksDuration.getSelectionModel().getSelectedItem() == null) {
                MessageUtils.showError("Empty field",
                        "No field can be left empty");
            } else {
                int month = comboMonth.getSelectionModel().getSelectedIndex() + 1;
                String course = txtName.getText() + ";" + month + ";" +
                        comboWeeksDuration.getSelectionModel().getSelectedItem();

                FileUtils.saveCourse(course);
                SceneLoader.loadScene("/summercampfx/FXMLMainView.fxml",
                        (Stage) ((Node) actionEvent.getSource()).getScene().getWindow());
            }
        } catch (Exception e) {
            MessageUtils.showError("Create new course",
                    "An error occurred while trying to create a new course");
            System.out.println(e);
        }
    }
}
