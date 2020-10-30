package summercampfx.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * This is PendingApp class
 * @author Daniel García
 */
public class PendingApp {
    String name;
    String surnames;
    LocalDate birthdate;
    Course course;

    /**
     * This is the constructor of PendingApp class
     * @param name
     * @param surnames
     * @param birthdate
     * @param course
     */
    public PendingApp(String name, String surnames, LocalDate birthdate, Course course) {
        this.name = name;
        this.surnames = surnames;
        this.birthdate = birthdate;
        this.course = course;
    }

    /**
     * This method returns a string (the name)
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * This method returns a integer. That number is the age, calculated with the birthdate and the current date
     * @return age
     */
    public Integer getAge() {
        int aDate = birthdate.getYear();
        int now = LocalDate.now().getYear();
        return now - aDate;
    }

    /**
     * This method returns a String
     * @return surnames
     */
    public String getSurnames() {
        return surnames;
    }

    /**
     * This method returns a LocalDate
     * @return birthdate
     */
    public LocalDate getBirthdate() {
        return birthdate;
    }

    /**
     * This method returns a Course
     * @return course
     */
    public Course getCourse() {
        return course;
    }

    /**
     * This is toString method that returns three of the parameters, splited by semicolon.
     * @return name, surname and birthdate
     */
    @Override
    public String toString() {
        return name + ";" + surnames + ";" + birthdate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    /**
     * This is like another toString method that returns al parameters (including each one from the course), splited by semicolon.
     * @return all parameters
     */
    public String toStringWithCourse() {
        return name + ";" + surnames + ";" + birthdate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                + ";" + course.toStringWithSemicolon();
    }
}
