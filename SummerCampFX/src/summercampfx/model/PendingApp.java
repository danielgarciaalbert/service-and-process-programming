package summercampfx.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class PendingApp {
    String name;
    String surnames;
    LocalDate birthdate;
    Course course;

    public PendingApp(String name, String surnames, LocalDate birthdate, Course course) {
        this.name = name;
        this.surnames = surnames;
        this.birthdate = birthdate;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        int aDate = birthdate.getYear();
        int now = LocalDate.now().getYear();
        return now - aDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return name + ";" + surnames + ";" + birthdate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public String toStringWithCourse() {
        return name + ";" + surnames + ";" + birthdate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                + ";" + course.toStringWithSemicolon();
    }
}
