/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cs40s.unitproblems.unit0problem3;

/**
 * Unit0Problem3.java - This program gets the user to input 10 titles, then
 * gives them the option to look at all the titles, to see one specific title,
 * to change a title, or to quit the program.
 *
 * @author Samantha Egilson
 * @since 13-Sep-2023
 */
public class Unit0Problem3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final String TITLE = "The Comic Book Store";
        start(TITLE);
        String[] titles = enterTitles(TITLE);
        int[] choices = {1, 2, 3, 4};
        int choice = 0;
        do {
            choice = Tools.inputInteger("What would you like to do?\n"
                    + "\n1 - See the entire database"
                    + "\n2 - See an index title"
                    + "\n3 - Change an index title"
                    + "\n4 - Quit the program", TITLE);
            if (choice == choices[0]) {
                seeDatabase(titles, TITLE);
            } else if (choice == choices[1]) {
                seeIndex(titles, TITLE);
            } else if (choice == choices[2]) {
                changeIndex(titles, TITLE);
            }
        } while (choice != choices[3]);
        end(TITLE);
    }

    /**
     * Starts the application and welcomes user with a dialog
     *
     * @param title the title of the application
     */
    private static void start(String title) {
        Tools.output("Welcome to " + title, title);
    }

    /**
     * Displays input boxes for the user to input the index titles
     *
     * @param title the title of the application
     * @return the titles of the indexes
     */
    private static String[] enterTitles(String title) {
        String[] titles = new String[10];
        for (int i = 0; i < titles.length; i++) {
            titles[i] = Tools.input("Enter new title for index " + (i + 1),
                    title);
        }
        return titles;
    }

    /**
     * Ends the application with a dialog and terminates the application
     *
     * @param title the title of the application
     */
    private static void end(String title) {
        Tools.output("Thanks for using " + title, title);
    }

    /**
     * Displays all the index titles in a dialog box
     *
     * @param titles the titles of the indexes
     * @param title the title of the application
     */
    private static void seeDatabase(String[] titles, String title) {
        String text = title + ":\n";
        for (int i = 0; i < titles.length; i++) {
            text = text + "\nIndex " + (i + 1) + ": " + titles[i];
        }
        Tools.output(text, title);
    }

    /**
     * Asks the user which index with an input box, then displays the title of
     * the index in a dialog box
     *
     * @param titles the titles of the indexes
     * @param title the title of the application
     */
    private static void seeIndex(String[] titles, String title) {
        final int HIGH = 10;
        final int LOW = 1;
        int index = Tools.inputInteger("Enter index to see:", title);
        if (index > HIGH || index < LOW) {
            Tools.output("Index " + index + " is outside of the database",
                    title);
        } else {
            Tools.output("Index " + index + " is set to " + titles[index - 1],
                    title);
        }
    }

    /**
     * Asks the user which index with an input box, then displays an input box
     * for the user to enter the new title
     *
     * @param titles the titles of the indexes
     * @param title the title of the application
     */
    private static void changeIndex(String[] titles, String title) {
        final int HIGH = 10;
        final int LOW = 1;
        int index = Tools.inputInteger("Enter index to change:",
                title);
        if (index > HIGH || index < LOW) {
            Tools.output("Index " + index + " is outside of the database",
                    title);
        } else {
            titles[index - 1] = Tools.input("Enter new title for index " + index
                    + ":", title);
            Tools.output("Index " + index + " has been changed to "
                    + titles[index - 1], title);
        }
    }
}
