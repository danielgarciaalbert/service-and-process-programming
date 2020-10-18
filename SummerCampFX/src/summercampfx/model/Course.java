package summercampfx.model;

import java.time.Month;

public class Course {
    String name;
    Enum<Month> month;
    int weeksDuration;

    public Course(String name, Enum<Month> month, int weeksDuration) {
        this.name = name;
        this.month = month;
        this.weeksDuration = weeksDuration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Enum getMonth() {
        return month;
    }

    public void setMonth(Enum month) {
        this.month = month;
    }

    public int getWeeksDuration() {
        return weeksDuration;
    }

    public void setWeeksDuration(int weeksDuration) {
        this.weeksDuration = weeksDuration;
    }

    /*
    @Override
    public boolean equals(Object o) {
        boolean equals = false;
        if (this.name.equals(((Course) o).name) &&
                this.month == ((Course) o).month &&
                this.weeksDuration == ((Course) o).weeksDuration) {
            equals = true;
        }

        return equals;
    }
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Course other = (Course) obj;
        if (name.equals(other.name) && month.equals(other.month) && weeksDuration == other.weeksDuration)
            return true;
        return false;
    }

    @Override
    public String toString() {
        return name + " " + month + " Duration: " + weeksDuration + " weeks";
    }
}
