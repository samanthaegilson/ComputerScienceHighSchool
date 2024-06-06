/** required package class namespace */
package castleprotect.tools;

import java.awt.Color;
import java.awt.Font;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import tools.Numbers;

 
/**
 * Dialogs.java - a collection of useful methods for working with dialogs
 *
 * @author Mr. Wachs
 * @since Nov. 21, 2019, 3:49:53 p.m.
 */
public class Dialogs 
{
    
    private static final String DEFAULT_TITLE       = "Sample App";
    private static final String DEFAULT_FONT_FACE   = "Consolas";
    private static final int    DEFAULT_FONT_SIZE   = 12;
    private static final int    DEFAULT_RED_COLOR   = 238;
    private static final int    DEFAULT_GREEN_COLOR = 238;
    private static final int    DEFAULT_BLUE_COLOR  = 238;
    
    private static final Font   DEFAULT_FONT        = new Font(
            DEFAULT_FONT_FACE,Font.PLAIN,DEFAULT_FONT_SIZE);
    private static final Color  DEFAULT_BACKGROUND  = new Color(
            DEFAULT_RED_COLOR,DEFAULT_GREEN_COLOR,DEFAULT_BLUE_COLOR);
    private static final Color  DEFAULT_FOREGROUND  = new Color(0,0,0);
    
    public static String title      = DEFAULT_TITLE;
    public static Font   font       = DEFAULT_FONT;
    public static Color  background = DEFAULT_BACKGROUND;
    public static Color  foreground = DEFAULT_FOREGROUND;
    
    
    /**
     * Default constructor, set class properties
     * 
     * @param title
     * @param font
     * @param background
     * @param foreground 
     */
    public Dialogs(String title, Font font, Color background, 
            Color foreground) {
        this.title      = title;
        this.font       = font;
        this.background = background;
        this.foreground = foreground;        
    }
    
    /**
     * Ask the user a yes and no question, in a confirm dialog box
     * 
     * @param text the yes no question to ask in the dialog
     * @return true (yes), false (no)
     */
    public static boolean yesNo(String text) {
        JTextArea area  = formatArea(text);
        int response = JOptionPane.showConfirmDialog(null,area,title,
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) return true;
        else                                    return false;
    }
    
    /**
     * Asks the user for a string input in a input dialog box
     * 
     * @param text the text for the dialog box
     * @return a valid string
     */
    public static String input(String text) {
        JTextArea area  = formatArea(text);
        String    value = JOptionPane.showInputDialog(null, 
                area,title,JOptionPane.QUESTION_MESSAGE);
        while (value == null || value.equals("")) {
            area  = formatArea("Error, please enter again\n\n" + text);
            value = JOptionPane.showInputDialog(null,area,title,
                    JOptionPane.QUESTION_MESSAGE);
        }
        return value;
    }
    
    /**
     * Asks the user for a number (integer) in a input dialog box
     * 
     * @param text the text for the dialog box
     * @return a valid integer
     */
    public static int inputInteger(String text) {
        String value = input(text);
        while (Numbers.isInteger(value) == false) {
            value = input("Error, please enter again\n\n" + text);
        }
        int number = Integer.parseInt(value);
        return number;        
    }
    
    /**
     * Asks the user for a number (integer) in a input dialog box
     * 
     * @param text the text for the dialog box
     * @param minimum the lowest value in the input range
     * @param maximum the highest value in the input range
     * @return a valid integer
     */
    public static int inputInteger(String text, int minimum, int maximum) {
        final String ERROR_1 = "Error, invalid number\n\n" + text;
        final String ERROR_2 = "Error, number not inside range\n\n" + text;
        String value = input(text);
        int number = 0;
        boolean done = false;
        while (!done) {
            if (Numbers.isInteger(value) == false) value = input(ERROR_1);
            else {
                number = Integer.parseInt(value);
                if (Numbers.inRange(number, minimum, maximum)) done = true;
                else value = input(ERROR_2);
            }            
        }
        return number;        
    }
    
    /**
     * Asks the user for a number (double) in a input
     * dialog box
     * 
     * @param text the text for the dialog box
     * @return a valid integer
     */
    public static double inputDouble(String text) {
        String value = input(text);
        while (Numbers.isDouble(value) == false) {
            value = input("Error, please enter again\n\n" + text);
        }
        double number = Double.parseDouble(value);
        return number;        
    }
    
    /**
     * Asks the user for a number (integer) in a input dialog box
     * 
     * @param text the text for the dialog box
     * @param minimum the lowest value in the input range
     * @param maximum the highest value in the input range
     * @return a valid double
     */
    public static double inputDouble(String text, int minimum, int maximum) {
        final String ERROR_1 = "Error, invalid number\n\n" + text;
        final String ERROR_2 = "Error, number not inside range\n\n" + text;
        String value = input(text);
        double number = 0d;
        boolean done = false;
        while (!done) {
            if (Numbers.isDouble(value) == false) value = input(ERROR_1);
            else {
                number = Double.parseDouble(value);
                if (Numbers.inRange(number, minimum, maximum)) done = true;
                else value = input(ERROR_2);
            }            
        }
        return number;        
    }
        
    /**
     * Outputs text in a more visual graphical dialog 
     * 
     * @param text the text to display
     * @param imageName the name of the image to display
     */
    public static void output(String text, String imageName) {
        JTextArea area    = formatArea(text);
        Icon      picture = new ImageIcon(imageName);
        JOptionPane.showMessageDialog(null,area,title,
                JOptionPane.PLAIN_MESSAGE,picture);        
    }
    
    /**
     * Outputs text in a more visual graphical dialog 
     * 
     * @param text the text to display
     */
    public static void output(String text) {
        JTextArea area = formatArea(text);
        JOptionPane.showMessageDialog(null,area,title,
                JOptionPane.PLAIN_MESSAGE);        
    }
    
    /**
     * Sets up a fancy display area for the text to display
     * 
     * @param text the string of text to format
     * @return the formatted text area for display
     */
    public static JTextArea formatArea(String text) {
        // create a graphics object to display the graphical things
        JTextArea area = new JTextArea();
        // assign the font, colors, and text to the area
        area.setFont(font);
        area.setBackground(background);
        area.setForeground(foreground);
        area.setText(text);
        return area;
    }
        
    /**
     * Ask the user if they want to play again, in a dialog box
     * 
     * @return true (yes, play again), false (no)
     */
    public static boolean playAgain() {
        return yesNo("Do you want to play again?");
    }
            
    /**
     * Presents an input dialog with a drop down selection of options
     * 
     * @param text the text to show in the dialog
     * @param options the array of option to have in the drop down
     * @return the option they choose
     */
    public static String choices(String text, String[] options) {
        JTextArea area = formatArea(text);
        Object object = JOptionPane.showInputDialog(null, area, title, 
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (object == null)  return "";
        else                 return object.toString();
    }
    
}
