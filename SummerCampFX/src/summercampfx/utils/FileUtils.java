package summercampfx.utils;

import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import summercampfx.FXMLMainViewController;
import summercampfx.model.Course;
import summercampfx.model.PendingApp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.valueOf;

public class FileUtils {
    public static List<PendingApp> loadApps() {
        try {
            return Files.lines(Paths.get("pendingApps.txt"))
                    .map(line -> new PendingApp(
                            line.split(";")[0],
                            line.split(";")[1],
                            LocalDate.parse(line.split(";")[2], DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                            new Course(
                                    line.split(";")[3],
                                    Month.of(Integer.parseInt(line.split(";")[4])),
                                    Integer.parseInt(line.split(";")[5]))))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            return null;
        }
    }

    public static List<Course> loadCourses() {
        List<Course> courses = new ArrayList<>() ;
        try {
            BufferedReader inputFile = new BufferedReader(
                    new FileReader(new File("courses.txt")));
            String line;

            do {
                line = inputFile.readLine();
                if (line != null) {
                    courses.add(new Course(
                            line.split(";")[0],
                            Month.of(Integer.parseInt(line.split(";")[1])),
                            Integer.parseInt(line.split(";")[2])));
                }
            }
            while (line != null);
            inputFile.close();
        } catch (IOException fileError) {
            //TO DO
        }

        return courses;
    }

    public static void saveApps() {}
    public static void saveApp() {}
    public static void saveCourse() {}
    public static void saveCabin() {}

}
