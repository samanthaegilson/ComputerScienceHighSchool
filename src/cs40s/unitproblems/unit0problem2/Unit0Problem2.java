/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cs40s.unitproblems.unit0problem2;

import javax.swing.JOptionPane;

/**
 * Unit0Problem2.java - This program gets the user to input a month and a day
 * and determines if the date is before, after, or is February 18th.
 *
 * @author Samantha Egilson
 * @since 11-Sep-2023
 */
public class Unit0Problem2 {

    static final String TITLE = "The Special Day";
    static final String SPECIAL_TEXT = "February 18th";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean playAgain = true;
        final int LOW = 1;
        final int HIGH_MONTH = 12;
        final int HIGH_DAY = 31;
        do {
            start();
            int monthNumber = calculate("Please enter the month\n\n"
                    + "(1 for January up to 12 for December)", LOW, HIGH_MONTH);
            int day = calculate("Please enter the day\n\n"
                    + "(days 1 to 31 only)", LOW, HIGH_DAY);
            String month = determineMonth(monthNumber);
            specialDay(monthNumber, month, day);
            playAgain = playAgain();
        } while (playAgain == true);
        end();
    }

    /**
     * Starts the application and welcomes user with a dialog
     */
    private static void start() {
        output("Welcome to " + TITLE);
    }

    /**
     * Asks the user for a number (integer) in a input dialog box
     *
     * @param text the text for the dialog box
     * @return a valid integer
     */
    private static int input(String text) {
        String value = JOptionPane.showInputDialog(
                null,
                text,
                TITLE,
                JOptionPane.QUESTION_MESSAGE);
        final String ERROR = "Error, please enter again\n\n";
        while (value == null || value.equals("")) {

            value = JOptionPane.showInputDialog(null, ERROR
                    + text, TITLE, JOptionPane.QUESTION_MESSAGE);
        }
        int answer = Integer.parseInt(value);
        return answer;
    }

    /**
     * Checks to make sure the number is in the range
     *
     * @param number the number to check
     * @param low lowest in the range
     * @param high highest in the range
     * @return in range (true) or not (false)
     */
    private static boolean inRange(int number, int low, int high) {
        if (number >= low && number <= high) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Outputs text in a dialog box
     *
     * @param text the text to display
     */
    private static void output(String text) {
        JOptionPane.showMessageDialog(
                null,
                text,
                TITLE,
                JOptionPane.PLAIN_MESSAGE
        );
    }

    /**
     * Ask the user if they want to play again, in a dialog box
     *
     * @return true (yes, play again), false (no)
     */
    private static boolean playAgain() {
        // Send the yesNo method the play again message
        int response = JOptionPane.showConfirmDialog(null,
                "Do you want to play again?", TITLE,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Ends the application with a dialog and terminates the application
     */
    private static void end() {
        output("Thanks for using " + TITLE);
    }

    /**
     * Gets the user to input a number and checks that it is within the correct
     * range
     *
     * @param text the text in the input box
     * @param low lowest in the range
     * @param high highest in the range
     * @return the number the user inputted
     */
    private static int calculate(String text, int low, int high) {
        int number = input(text);
        boolean value = true;
        value = inRange(number, low, high);
        while (value == false) {
            number = input(text);
            value = inRange(number, low, high);
        }
        return number;
    }

    /**
     * Converts the number of a month to string of it's name
     *
     * @param monthNumber number of the month
     * @return name of the month
     */
    private static String determineMonth(int monthNumber) {
        String month = "";
        if (monthNumber == 1) {
            month = "January";
        } else if (monthNumber == 2) {
            month = "February";
        } else if (monthNumber == 3) {
            month = "March";
        } else if (monthNumber == 4) {
            month = "April";
        } else if (monthNumber == 5) {
            month = "May";
        } else if (monthNumber == 6) {
            month = "June";
        } else if (monthNumber == 7) {
            month = "July";
        } else if (monthNumber == 8) {
            month = "August";
        } else if (monthNumber == 9) {
            month = "September";
        } else if (monthNumber == 10) {
            month = "October";
        } else if (monthNumber == 11) {
            month = "November";
        } else {
            month = "December";
        }

        return month;
    }

    /**
     * Decides whether the date is before, after or is the special day
     *
     * @param monthNumber number of the month
     * @param month name of the month
     * @param day day of the month
     */
    private static void specialDay(int monthNumber, String month, int day) {
        final int SPECIAL_MONTH = 2;
        final int SPECIAL_DAY = 18;
        if (SPECIAL_MONTH == monthNumber && SPECIAL_DAY == day) {
            special(month, day);
        } else if (SPECIAL_MONTH == monthNumber && SPECIAL_DAY > day) {
            before(month, day);
        } else if (SPECIAL_MONTH == monthNumber && SPECIAL_DAY < day) {
            after(month, day);
        } else if (SPECIAL_MONTH > monthNumber) {
            before(month, day);
        } else if (SPECIAL_MONTH < monthNumber) {
            after(month, day);
        }
    }

    /**
     * Outputs a dialog box explaining the day is before the special day
     *
     * @param month name of the month
     * @param day day of the month
     */
    private static void before(String month, int day) {
        output("The date: " + month + " " + day + " is before " + SPECIAL_TEXT);
    }

    /**
     * Outputs a dialog box explaining the day is after the special day
     *
     * @param month name of the month
     * @param day day of the month
     */
    private static void after(String month, int day) {
        output("The date: " + month + " " + day + " is after " + SPECIAL_TEXT);
    }

    /**
     * Outputs a dialog box explaining the day is the special day
     *
     * @param month name of the month
     * @param day day of the month
     */
    private static void special(String month, int day) {
        output("The date: " + month + " " + day + " is the special "
                + SPECIAL_TEXT);
    }

}
