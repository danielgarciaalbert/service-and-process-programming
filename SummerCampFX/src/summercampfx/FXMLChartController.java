package summercampfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;
import summercampfx.model.Course;
import summercampfx.model.PendingApp;
import summercampfx.utils.SceneLoader;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

/**
 * FXMLChartController is the class in charge of controlling the chart view
 * @author Daniel García
 */
public class FXMLChartController implements Initializable {
    @FXML
    public PieChart chartCourses;

    /**
     * The initialize method will be called every time the class is created.
     * It's useful for fill the chart
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(("FXMLMainView.fxml")));
        try {
            Parent root = (Parent) loader.load();
        } catch (Exception e) { }

        FXMLMainViewController controller = (FXMLMainViewController) loader.getController();
        List<Course> courses = controller.getCourses();
        List<PendingApp> pendingApps = controller.getPendingApps();

        chartCourses.getData().clear();

        Map<String, Integer> result = new HashMap<>();
        int amount = 0;

        for (int i = 0; i < courses.size(); i++) {
            amount = 0;
            for (int j = 0; j < pendingApps.size(); j++) {
                if (pendingApps.get(j).getCourse().equals(courses.get(i))) {
                    amount++;
                }
            }
            result.put(courses.get(i).toString(), amount);
        }

        result.forEach((c, a) -> {
            chartCourses.getData().add(new PieChart.Data(c, a));
        });
    }

    /**
     * This method is used to go back to the main view
     * @param actionEvent
     * @throws IOException
     */
    public void goBack(ActionEvent actionEvent) throws IOException {
        SceneLoader.loadScene("/summercampfx/FXMLMainView.fxml",
                (Stage) ((Node) actionEvent.getSource()).getScene().getWindow());
    }
}
