package summercampfx;

import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import summercampfx.model.Course;
import summercampfx.model.PendingApp;
import summercampfx.utils.FileUtils;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FXMLMainViewController implements Initializable {
    @FXML
    public TableColumn<PendingApp, String> colName;
    @FXML
    public TableColumn<PendingApp, String> colSurname;
    @FXML
    public TableColumn<PendingApp, LocalDate> colBirthDate;
    @FXML
    private ComboBox comboCourses;
    @FXML
    private ComboBox comboAges;
    @FXML
    private TableView<PendingApp> tableStudentsLeft;
    @FXML
    private Button btnTableName;
    @FXML
    private Button btnTableSurname;
    @FXML
    private Button btnTableBirthDate;
    @FXML
    private Button btnNewCourse;
    @FXML
    private Button btnNewApp;
    @FXML
    private ListView lstFullCabins;
    @FXML
    private Button btnFillCabin;
    @FXML
    private TextField txtFieldCabinSituation;
    @FXML
    private TableView tableStudentsRight;
    @FXML
    private Button btnSaveCabin;

    List<Course> courses;
    List<PendingApp> pendingApps;
    List<PendingApp> pendingAppsWithFilters;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        courses = FileUtils.loadCourses();
        pendingApps = FileUtils.loadApps();
        FillCoursesCombo();
        FillLeftTable(pendingApps);
        loadAges(comboAges);
    }

    private void loadAges(ComboBox comboBox) {
        for (int i = 6; i <= 16; i++) {
            comboBox.getItems().addAll(i);
        }
    }

    private void FillCoursesCombo() {
        comboCourses.setItems(FXCollections.observableArrayList(courses));
    }

    private void FillLeftTable(List<PendingApp> pendingApps) {
        colName.setCellValueFactory(new PropertyValueFactory("name"));
        colSurname.setCellValueFactory(new PropertyValueFactory("surnames"));
        colBirthDate.setCellValueFactory(new PropertyValueFactory("birthdate"));
        tableStudentsLeft.setItems(FXCollections.observableArrayList(pendingApps));
    }

    /*
    public void addCourseFilter(ActionEvent actionEvent) {
        List<PendingApp> finalList = new ArrayList<>();

        try {
            if (comboAges.getSelectionModel().getSelectedItem() == null) {
                finalList = pendingApps.stream()
                    .filter(pa -> pa.getCourse().equals(comboCourses.getSelectionModel().getSelectedItem()))
                    .collect(Collectors.toList());
            } else {
                finalList = pendingApps.stream()
                    .filter(pa -> pa.getCourse().equals(comboCourses.getSelectionModel().getSelectedItem())
                            && pa.getAge().equals(comboAges.getSelectionModel().getSelectedItem().toString()))
                    .collect(Collectors.toList());
            }

        } catch (Exception e) {

        }

        FillLeftTable(finalList);
    }

    public void addAgeFilter(ActionEvent actionEvent) {
        List<PendingApp> finalList = new ArrayList<>();

        try {
            if (comboCourses.getSelectionModel().getSelectedItem() == null) {
                finalList = pendingApps.stream()
                    .filter(pa -> pa.getAge().equals(comboAges.getSelectionModel().getSelectedItem().toString()))
                    .collect(Collectors.toList());
            } else {
                finalList = pendingApps.stream()
                    .filter(pa -> pa.getCourse().equals(comboCourses.getSelectionModel().getSelectedItem())
                        && pa.getAge().equals(comboAges.getSelectionModel().getSelectedItem().toString()))
                    .collect(Collectors.toList());
            }

        } catch (Exception e) {

        }

        FillLeftTable(finalList);
    }
    */

    public void addFilters(ActionEvent actionEvent) {
        List<PendingApp> finalList = new ArrayList<>();

        try {
            if (comboCourses.getSelectionModel().getSelectedItem() == null) {
                finalList = pendingApps.stream()
                        .filter(pa -> pa.getAge().equals(comboAges.getSelectionModel().getSelectedItem().toString()))
                        .collect(Collectors.toList());
            } else if (comboAges.getSelectionModel().getSelectedItem() == null) {
                finalList = pendingApps.stream()
                        .filter(pa -> pa.getCourse().equals(comboCourses.getSelectionModel().getSelectedItem()))
                        .collect(Collectors.toList());
            } else {
                finalList = pendingApps.stream()
                        .filter(pa -> pa.getCourse().equals(comboCourses.getSelectionModel().getSelectedItem())
                                && pa.getAge().equals(comboAges.getSelectionModel().getSelectedItem().toString()))
                        .collect(Collectors.toList());
            }

        } catch (Exception e) {
            System.out.println("Error adding a filter");
        }

        FillLeftTable(finalList);
    }
}
