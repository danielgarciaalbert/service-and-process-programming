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

    @Override
    public String toString() {
        return name + " " + month + " Duration: " + weeksDuration + " weeks";
    }

    public String toStringWithSemicolon() {
        int monthLikeInteger = month.ordinal() + 1;
        return name + ";" + monthLikeInteger + ";" + weeksDuration;
    }
}
