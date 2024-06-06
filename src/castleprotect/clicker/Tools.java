/** Required package class namespace */
package castleprotect.clicker;

import javax.swing.JOptionPane;

 
/**
 * Tools.java - description
 *
 * @author Samantha Egilson
 * @since Nov 29, 2023, 10:10:33 a.m.
 */
public class Tools 
{
     
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
    
    /**
     * String representation of this object
     *
     * @return The object represented as a String
     */
    @Override
    public String toString() {
        return "Tools: " + super.toString();
    }
   
    /**
     * Deep comparison, determines if two objects are "equal" in this context
     *
     * @param object the object to compare to
     * @return the objects are "equal" (true) or not (false)
     */
    @Override
    public boolean equals(Object object) {
        return super.equals(object);
    }
       
    /**
     * a Deep clone, creates a duplicate object using new memory
     *
     * @return a "clone" of the object using new memory
     */
    @Override
    public Tools clone() {
        return this;
    }
    
}