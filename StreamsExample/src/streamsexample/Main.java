package streamsexample;

import java.util.ArrayList;
import java.util.List;

/**
 * Main program. It creates a list of Person objects and gets some final results using streams
 */

public class Main {

    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();
        people.add(new Person("Nacho", 42));
        people.add(new Person("Juan", 70));
        people.add(new Person("Mario", 7));
        people.add(new Person("Laura", 4));
        people.add(new Person("Ana", 38));

        // Add here the code to print the names of adult people in the screen (one by line)

        // Add here the code to get a sublist of all the adult people

        // Add here the code to sort the list by ages (ascending) and get a sublist of the 3 first elements

        // Add here the code to get the names, separated by commas, of adult people

        // Add here the code to get the sum of ages of the people in the list

        // Add here the code to get the maximum age of the group

        // Add here the code to get the age average

    }

}
