package summercampfx.model;

import java.time.Month;

/**
 * This is Course class
 * @author Daniel García
 */
public class Course {
    String name;
    Enum<Month> month;
    int weeksDuration;

    /**
     * This is the constructor of the Course class
     * @param name
     * @param month
     * @param weeksDuration
     */
    public Course(String name, Enum<Month> month, int weeksDuration) {
        this.name = name;
        this.month = month;
        this.weeksDuration = weeksDuration;
    }

    /**
     * This is the equals method. It useful to compare two courses.
     * @param obj
     * @return true or false, depending on whether the compared courses are the same or not
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        if (name.toUpperCase().equals(((Course) obj).name.toUpperCase())
                && month.equals(((Course) obj).month) && weeksDuration == ((Course) obj).weeksDuration)
            return true;
        else
            return false;
    }

    /**
     * This is toString method that returns all parameters in a way to show.
     * @return name, month and weeksDuration
     */
    @Override
    public String toString() {
        return name + " " + month + " Duration: " + weeksDuration + " weeks";
    }

    /**
     * This is toString method that returns all parameters, splited by semicolon.
     * @return name, month and weeksDuration
     */
    public String toStringWithSemicolon() {
        int monthLikeInteger = month.ordinal() + 1;
        return name + ";" + monthLikeInteger + ";" + weeksDuration;
    }
}
