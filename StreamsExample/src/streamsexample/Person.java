package streamsexample;

/**
 * Person class will be part of a collection in Main program, in order to sort persons by some criteria using
 * lambda expressions
 */
public class Person
{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " (" + age + " years)";
    }
}
