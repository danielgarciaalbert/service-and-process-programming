package summercampfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import summercampfx.model.Course;
import summercampfx.model.PendingApp;
import summercampfx.utils.FileUtils;
import summercampfx.utils.MessageUtils;
import summercampfx.utils.SceneLoader;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class FXMLMainViewController implements Initializable {
    @FXML
    public TableColumn<PendingApp, String> colName;
    @FXML
    public TableColumn<PendingApp, String> colSurname;
    @FXML
    public TableColumn<PendingApp, LocalDate> colBirthDate;
    @FXML
    public TableColumn<PendingApp, String> colNameRight;
    @FXML
    public TableColumn<PendingApp, String> colSurnamesRight;
    @FXML
    public Button btnChart;
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
    private TableView<PendingApp> tableStudentsRight;
    @FXML
    private Button btnSaveCabin;
    private boolean sortingAscendent = true;

    List<Course> courses;
    List<PendingApp> pendingApps;
    List<String> cabins;
    List<PendingApp> finalList;
    List<PendingApp> rightTable;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        courses = FileUtils.loadCourses();
        pendingApps = FileUtils.loadApps();
        cabins = FileUtils.loadCabins();
        FillCoursesCombo();
        FillLeftTable(pendingApps);
        FillCabinsListView();
        loadAges(comboAges);
        rightTable = new ArrayList<>();
        finalList = new ArrayList<>();
    }

    private void loadAges(ComboBox comboBox) {
        for (int i = 6; i <= 16; i++) {
            comboBox.getItems().addAll(i);
        }
    }

    private void FillCabinsListView() {
        if (cabins.size() > 0)
            lstFullCabins.setItems(FXCollections.observableArrayList(cabins));
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

    public void addFilters(ActionEvent actionEvent) {
        finalList = new ArrayList<>();

        try {
            if (comboCourses.getValue() == null) {
                finalList = pendingApps.stream()
                        .filter(pa -> pa.getAge() == comboAges.getSelectionModel().getSelectedItem())
                        .collect(Collectors.toList());
            } else if (comboAges.getValue() == null) {
                finalList = pendingApps.stream()
                        .filter(pa -> pa.getCourse().equals(comboCourses.getSelectionModel().getSelectedItem()))
                        .collect(Collectors.toList());
            } else {
                finalList = pendingApps.stream()
                        .filter(pa -> pa.getCourse().equals(comboCourses.getSelectionModel().getSelectedItem())
                                && pa.getAge() == comboAges.getSelectionModel().getSelectedItem())
                        .collect(Collectors.toList());
            }

        } catch (Exception e) {
            MessageUtils.showError("Adding Filters Error", "An error has ocurred adding filters");
        }

        FillLeftTable(finalList);
    }

    public void addApplication(ActionEvent actionEvent) throws IOException {
        SceneLoader.loadScene("/summercampfx/FXMLNewApplicationView.fxml",
                (Stage) ((Node) actionEvent.getSource()).getScene().getWindow());
    }

    public void addCourse(ActionEvent actionEvent) throws IOException {
        SceneLoader.loadScene("/summercampfx/FXMLNewCourseView.fxml",
                (Stage) ((Node) actionEvent.getSource()).getScene().getWindow());
    }

    public void orderByName(ActionEvent actionEvent) {
        if (finalList.size() > 0) {
            if (sortingAscendent) {
                sortingAscendent = false;
                finalList.sort(Comparator.comparing(PendingApp::getName));
            } else {
                sortingAscendent = true;
                finalList.sort(Comparator.comparing(PendingApp::getName).reversed());
            }
            FillLeftTable(finalList);
        }
    }

    public void orderBySurnames(ActionEvent actionEvent) {
        if (finalList.size() > 0) {
            if (sortingAscendent) {
                sortingAscendent = false;
                finalList.sort(Comparator.comparing(PendingApp::getSurnames)
                        .thenComparing(PendingApp::getName));
            } else {
                sortingAscendent = true;
                finalList.sort(Comparator.comparing(PendingApp::getSurnames)
                        .thenComparing(PendingApp::getName).reversed());
            }
            FillLeftTable(finalList);
        }
    }

    public void orderByBirthdate(ActionEvent actionEvent) {
        if (finalList.size() > 0) {
            if (sortingAscendent) {
                sortingAscendent = false;
                finalList.sort(Comparator.comparing(PendingApp::getBirthdate));
            } else {
                sortingAscendent = true;
                finalList.sort(Comparator.comparing(PendingApp::getBirthdate).reversed());
            }
            FillLeftTable(finalList);
        }
    }

    public void fillCabin(ActionEvent actionEvent) {
        colNameRight.setCellValueFactory(new PropertyValueFactory("name"));
        colSurnamesRight.setCellValueFactory(new PropertyValueFactory("surnames"));

        if (comboCourses.getValue() == null || comboAges.getValue() == null) {
            MessageUtils.showError("Fill Cabin Error",
                    "COURSE and AGE must have value");
        } else {
            if (tableStudentsRight.getItems().size() == 0) {
                if (tableStudentsLeft.getItems().size() > 10) {
                    for (int i = 0; i < 10; i++) {
                        rightTable.add(finalList.get(i));
                    }
                    tableStudentsRight.setItems(FXCollections.observableArrayList(rightTable));
                } else if (tableStudentsLeft.getItems().size() > 0){
                    rightTable.addAll(finalList);
                    tableStudentsRight.setItems(FXCollections.observableArrayList(rightTable));
                } else if (tableStudentsLeft.getItems().size() <= 0) {
                    MessageUtils.showError("Fill Cabin Error", "There is no apps in the table");
                }
            } else {
                MessageUtils.showError("Fill Cabin Error", "The right table already has data");
            }
        }
    }

    public void saveCabin(ActionEvent actionEvent) {
        if (txtFieldCabinSituation.getText().equals("")) {
            MessageUtils.showError("Cabin Ubication Error", "Cabin ubication can't be empty");
        } else if (tableStudentsRight.getItems().size() <= 0) {
            MessageUtils.showError("Save Cabin Error", "Right table is empty");
        } else {
            FileUtils.saveCabin("./cabins/" + txtFieldCabinSituation.getText() + ".txt", rightTable);
            pendingApps.removeAll(rightTable);
            rightTable.clear();
            FileUtils.saveApps(pendingApps);
            cabins = FileUtils.loadCabins();
            FillCabinsListView();
            txtFieldCabinSituation.setText("");
            tableStudentsRight.getItems().clear();
            comboCourses.getSelectionModel().clearSelection();
            comboAges.getSelectionModel().clearSelection();
            FillLeftTable(pendingApps);
        }
    }

    public void showChart(ActionEvent actionEvent) throws IOException {
        SceneLoader.loadScene("/summercampfx/FXMLChartView.fxml",
                (Stage) ((Node) actionEvent.getSource()).getScene().getWindow());
    }

    public List<Course> getCourses() {
        return courses;
    }
    public List<PendingApp> getPendingApps() {
        return pendingApps;
    }
}
