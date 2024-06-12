/** Required package class namespace */
package cs40s.unitproblems.unit0problem4;

import java.awt.Color;
import java.awt.Font;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 * Tools.java - This class is for my methods
 * 
 * @author Samantha Egilson
 * @since 15-Sep-2023
 */
public class Tools {
    
    static final Font   FONT       = new Font("Consolas",Font.PLAIN,15);
    static final Color  BACKGROUND = new Color(238,238,238);
    static final Color  FOREGROUND = new Color(238,90,0);
    
    /**
     * Starts the application and welcomes user with a dialog
     * 
     * @param title the title of the application
     */
    public static void start(String title) {
        Tools.output("Welcome to " + title, title);
    }
    
    /**
     * Ends the application with a dialog and terminates the application
     * 
     * @param title the title of the application
     */
    public static void end(String title) {
        Tools.output("Thanks for using " + title, title);
    }
    
    /**
     * Generates a random number in a range between two numbers
     * 
     * @param low the lowest number in the range
     * @param high the highest number in the range
     * @return random number less than or equal to low and less than or
     * equal to the high number
     */
    public static int random(int low, int high) {
        double seed   = Math.random();
        double L      = (double)low;
        double H      = (double)high;
        double number = (H - L + 1) * seed + L; 
        return (int)number;
    }
    
    /**
     * Outputs text in a dialog box
     * 
     * @param text the text to display
     * @param title the title at the top
     */
    public static void output(String text, String title) {
        JTextArea area = formatArea(text);
        String path = "C:\\Users\\s.egilson\\Desktop\\Pictures\\";
        String name = path + "balloon.png";
         Icon image = new ImageIcon(name);        
        JOptionPane.showMessageDialog(null,area,title,
                JOptionPane.PLAIN_MESSAGE, image);  
    }    
    
    /**
     * Asks the user for a string input in a input dialog box
     * 
     * @param text the text for the dialog box
     * @param title the title at the top
     * @return a valid string
     */
    public static String input(String text, String title) {        
        JTextArea area = formatArea(text);
        String path = "C:\\Users\\s.egilson\\Desktop\\Pictures\\";
        String name = path + "balloon.png";               
        Icon image = new ImageIcon(name);
        Object object = JOptionPane.showInputDialog(
                null, 
                area, 
                title, 
                JOptionPane.PLAIN_MESSAGE, 
                image, 
                null,
                null);
        String value = object.toString();               
        final String ERROR = "Error, please enter again\n\n";
        while (value == null || value.equals("")) {
            area  = formatArea(ERROR + text);
            object = JOptionPane.showInputDialog(
                null, 
                area, 
                title, 
                JOptionPane.PLAIN_MESSAGE, 
                image, 
                null,
                null);
            value = object.toString();
        }        
        return value;           
    }

    /**
     * Asks the user for a string input in a input dialog box
     * 
     * @param text the text for the dialog box
     * @param options the options for the drop down
     * @param title the title at the top
     * @return a valid string
     */
    public static String inputDropDown(String text, String[] options, String title) {        
        JTextArea area = formatArea(text);
        String path = "C:\\Users\\s.egilson\\Desktop\\Pictures\\";
        String name = path + "balloon.png";               
        Icon image = new ImageIcon(name);
        Object object = JOptionPane.showInputDialog(
                null,
                area, 
                title, 
                JOptionPane.PLAIN_MESSAGE, 
                image, 
                options,
                options[0]);
        String value = object.toString();               
        final String ERROR = "Error, please enter again\n\n";
        while (value == null || value.equals("")) {
            area  = formatArea(ERROR + text);
            object = JOptionPane.showInputDialog(
                null, 
                area, 
                title, 
                JOptionPane.PLAIN_MESSAGE, 
                image, 
                options,
                options[0]);
            value = object.toString();
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
            value = JOptionPane.showInputDialog(null,ERROR + 
                    text,title,JOptionPane.QUESTION_MESSAGE);
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
                "Do you want to play again?",title,
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE);        
        if (response == JOptionPane.YES_OPTION) {
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Sets up a fancy display area for the text to display
     * 
     * @param text the string of text to format
     * @return the formatted text area for display
     */
    public static JTextArea formatArea(String text) {
        // Create a graphics object to display the graphical things
        JTextArea area = new JTextArea();
        // Assign the global variable font, colors, and passed text to the area
        area.setFont(FONT);
        area.setBackground(BACKGROUND);
        area.setForeground(FOREGROUND);
        area.setText(text);
        return area;
    }
    
    
}
