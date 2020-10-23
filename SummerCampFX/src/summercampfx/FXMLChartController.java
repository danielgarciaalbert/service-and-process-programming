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

public class FXMLChartController implements Initializable {
    @FXML
    public PieChart chartCourses;

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

        /*
        result = courses.stream().
                collect(Collectors.groupingBy(
                        c -> c.toString(),
                        Collectors.summingInt(c -> c.getMonth().ordinal() + 1)
                ));
        */

        result.forEach((c, a) -> {
            chartCourses.getData().add(new PieChart.Data(c, a));
        });
    }

    public void goBack(ActionEvent actionEvent) throws IOException {
        SceneLoader.loadScene("/summercampfx/FXMLMainView.fxml",
                (Stage) ((Node) actionEvent.getSource()).getScene().getWindow());
    }
}
