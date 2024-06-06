
/** Required package class namespace */
package sortpeople;

import java.util.ArrayList;


/*
 * SortPeople - description
 * 
 * @author Samantha Egilson
 * @since Mar 21, 2024
 */
public class SortPeople {

    /**
     * Main method for the project
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final int MAX = 100;
        ArrayList<Person> people = new ArrayList<>();
        for (int i = 0; i < MAX; i++) {
            people.add(new Person(getName(), getAge()));
        }
        output(people);
        Person.byName = true;
        sort(people);
        output(people);

    }

    public static String getName() {
        String first = "";
        String last = "";
        for (int i = 0; i < 5; i++) {
            char letter1 = (char) ((122d - 97d + 1d) * Math.random() + 97d);
            char letter2 = (char) ((122d - 97d + 1d) * Math.random() + 97d);
            first += letter1;
            last += letter2;
        }

        return first + " " + last;
    }

    private static int getAge() {
        return (int) (120d * Math.random() + 1d);
    }

    private static void output(ArrayList<Person> people) {
        System.out.println(people.toString());
    }

    private static void sort(ArrayList<Person> people) {
        // the simpliest to "write" is the basic bubble sort

        for (int i = people.size()-1; i > 0; i--) {
            boolean didISwap = false;
            // Travel through the list...
            for (int j = 0; j < i; j++) {
                Person p1 = people.get(j);
                Person p2 = people.get(j + 1);
                // Check if the value is greater than the next value
                if (p1.compareTo(p2) > 0) {
                    didISwap = true;
                    // Swap them
                    Person p3 = p1.clone();
                    p1 = new Person(p2.name, p2.age);
                    p2 = new Person(p3.name, p3.age);
                    // Update the list
                    people.set(j, p1);
                    people.set(j + 1, p2);
                }
            }
            // Check if no swaps took place
            if (didISwap == false) {
                return;
            }
        }
        // Do it again

    }

}
