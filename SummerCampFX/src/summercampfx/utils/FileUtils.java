package summercampfx.utils;

import summercampfx.model.Course;
import summercampfx.model.PendingApp;

import java.io.*;
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
            return new ArrayList<PendingApp>();
        }
    }

    public static void saveApps(List<PendingApp> newPendingApps) {
        PrintWriter output = null;
        try {
            output = new PrintWriter(new BufferedWriter(
                    new FileWriter("pendingApps.txt", false)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < newPendingApps.size(); i++) {
            output.println(newPendingApps.get(i).toStringWithCourse());
        }
        output.close();
    }
    public static void saveApp(String application) {
        try {
            //Files.write(Paths.get("pendingApps.txt"), application.getBytes(), StandardOpenOption.APPEND);

            /*
            BufferedWriter outputFile = new BufferedWriter(
                    new FileWriter(new File("pendingApps.txt")));
            outputFile.newLine();
            outputFile.write(application);
            outputFile.close();
            */

            PrintWriter output = new PrintWriter(new BufferedWriter(
                    new FileWriter("pendingApps.txt", true)));
            output.println(application);
            output.close();

        }catch (IOException e) {
            MessageUtils.showError("Save app error", "");
        }
    }

    public static List<Course> loadCourses() {
        List<Course> courses = new ArrayList<>() ;
        try {
            BufferedReader inputFile = new BufferedReader(
                    new FileReader((new File("courses.txt"))));
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



    public static void saveCourse(String course) throws IOException {
        try {
            PrintWriter output = new PrintWriter(new BufferedWriter(
                    new FileWriter("courses.txt", true)));
            output.println(course);
            output.close();

        } catch (IOException e) {
            MessageUtils.showError("Save app error", "");
        }
    }

    public static void saveCabin(String fileName, List<PendingApp> pendingApps) {
        try {
            FileWriter myWriter = new FileWriter(fileName);
            for (int i = 0; i < pendingApps.size(); i++) {
                myWriter.write(String.valueOf(pendingApps.get(i)) + "\n");
            }
            myWriter.close();
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }

    public static List<String> loadCabins() {
        List<String> cabins = new ArrayList<>();
        try {
            File folder = new File("./cabins");
            File[] listOfFiles = folder.listFiles();

            for (File file : listOfFiles) {
                if (file.isFile()) {
                    cabins.add(file.getName());
                }
            }
        } catch (NullPointerException f) {
            System.out.println("MIERDA");
        } catch (Exception e) {
            System.out.println("MAS MIERDA AUN SI CABE");
        }

        return cabins;
    }
}
