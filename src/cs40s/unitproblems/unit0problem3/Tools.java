/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs40s.unitproblems.unit0problem3;

import javax.swing.JOptionPane;

/**
 * Tools.java - This class is for my methods
 *
 * @author Samantha Egilson
 * @since 13-Sep-2023
 */
public class Tools {

    /**
     * Generates a random number in a range between two numbers
     *
     * @param low the lowest number in the range
     * @param high the highest number in the range
     * @return random number less than or equal to low and less than or equal to
     * the high number
     */
    public static int random(int low, int high) {
        double seed = Math.random();
        double L = (double) low;
        double H = (double) high;
        double number = (H - L + 1) * seed + L;
        return (int) number;
    }

    /**
     * Outputs text in a dialog box
     *
     * @param text the text to display
     * @param title the title at the top
     */
    public static void output(String text, String title) {
        JOptionPane.showMessageDialog(
                null,
                text,
                title,
                JOptionPane.PLAIN_MESSAGE
        );
    }

    /**
     * Asks the user for a string input in a input dialog box
     *
     * @param text the text for the dialog box
     * @param title the title at the top
     * @return a valid string
     */
    public static String input(String text, String title) {
        String value = JOptionPane.showInputDialog(null,
                text, title, JOptionPane.PLAIN_MESSAGE);
        final String ERROR = "Error, please enter again\n\n";
        while (value == null || value.equals("")) {
            value = JOptionPane.showInputDialog(null, ERROR
                    + text, title, JOptionPane.PLAIN_MESSAGE);
        }
        return value;
    }

    /**
     * Asks the user for a number (integer) in a input dialog box
     *
     * @param text the text for the dialog box
     * @param title the title at the top
     * @return a valid integer
     */
    public static int inputInteger(String text, String title) {
        String value = JOptionPane.showInputDialog(
                null,
                text,
                title,
                JOptionPane.QUESTION_MESSAGE);
        final String ERROR = "Error, please enter again\n\n";
        while (value == null || value.equals("")) {
            value = JOptionPane.showInputDialog(null, ERROR
                    + text, title, JOptionPane.QUESTION_MESSAGE);
        }
        int answer = Integer.parseInt(value);
        return answer;
    }

    /**
     * Ask the user if they want to play again, in a dialog box
     *
     * @return true (yes, play again), false (no)
     */
    public static boolean playAgain(String title) {
        // Send the yesNo method the play again message
        int response = JOptionPane.showConfirmDialog(null,
                "Do you want to play again?", title,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            return true;
        } else {
            return false;
        }
    }
}
