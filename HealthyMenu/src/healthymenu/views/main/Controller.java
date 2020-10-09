package healthymenu.views.main;

import healthymenu.data.Food;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class Controller implements Initializable {
    @FXML
    private TextField txtFoodName;
    @FXML
    private ComboBox<String> comboFoodCategory;
    @FXML
    private TextField txtFoodWeight;
    @FXML
    private Button btnAdd;
    @FXML
    private TableView<Food> tableFood;
    @FXML
    private TableColumn<Food, String> colFoodName;
    @FXML
    private TableColumn<Food, String> colFoodCategory;
    @FXML
    private TableColumn<Food, Integer> colFoodWeightG;
    @FXML
    private TableColumn<Food, String> colFoodWeightOz;
    private ObservableList<Food> food;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboFoodCategory.getItems().addAll(
                "Fruits and vegetables",
                "Meat and fish",
                "Milk derivatives",
                "Other"
        );

        food = FXCollections.observableArrayList(readFile());

        colFoodName.setCellValueFactory(new PropertyValueFactory("name"));
        colFoodCategory.setCellValueFactory(new PropertyValueFactory("category"));
        colFoodWeightG.setCellValueFactory(new PropertyValueFactory("weight"));
        colFoodWeightOz.setCellValueFactory(new PropertyValueFactory("weightInOz"));

        colFoodWeightG.setStyle("-fx-alignment: CENTER-RIGHT;");
        colFoodWeightOz.setStyle("-fx-alignment: CENTER-RIGHT;");

        tableFood.setItems(food);
    }

    public void addFood(ActionEvent actionEvent) {
        if (txtFoodName.getText().isEmpty() ||
                txtFoodWeight.getText().isEmpty() ||
                comboFoodCategory.getValue().isEmpty()) {
            Alert dialog = new Alert(Alert.AlertType.ERROR);
            dialog.setTitle("Error");
            dialog.setHeaderText("Error adding data");
            dialog.setContentText("No field can be empty");
            dialog.showAndWait();
        } else {
            String name = txtFoodName.getText();
            String category = (String) comboFoodCategory.getValue();
            int weight = Integer.parseInt(txtFoodWeight.getText());
            food.add(new Food(name, category, weight));
            saveFile(food);
        }


    }

    private List<Food> readFile() {
        try {
            return Files.lines(Paths.get("food.txt"))
                    .map(line -> new Food(line.split(";")[0], line.split(";")[1],
                        Integer.parseInt(line.split(";")[2])))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            return null;
        }
    }

    private void saveFile(List<Food> food) {
        try (PrintWriter pw = new PrintWriter("food.txt")) {
            food.stream().forEach(f -> pw.println(f.toString()));
        } catch (Exception e) {}
    }
}
