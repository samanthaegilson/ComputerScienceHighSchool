
package gridgame.generaltools;

/**
 * required imports
 */
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Dialogs.java - collection of static methods for display dialogs
 * @author Mr. Wachs' Computer Science Student
 * @since 16/03/2013
 * @version 1.0
 */
public class Dialogs 
{
    
    private static final String EXIT_QUESTION = "Do you wish to exit this program?";
    private static final String OPEN_FILE_TITLE = "Open File...";
    private static final String SAVE_FILE_TITLE = "Save File...";
    private static final boolean YES = true;

    /**
     * flag to indicate the save dialog 
     */
    public static final String SAVE_FILE = "save";
    /**
     * flag to indicate the open dialog 
     */
    public static final String OPEN_FILE = "open";
    
    
    /**
     * the JFrame user interface that the dialog will parent to
     */
    public static JFrame gui;
    
    /**
     * Question based dialog box
     * @param message the dialog's main message
     * @param title the dialog's box title
     * @return a string the user enters
     */
    public static String question(String message, String title) {
        return JOptionPane.showInputDialog(gui,message,title,
                JOptionPane.QUESTION_MESSAGE);
    }

    /**
     * Question based dialog box
     * @param message the dialog's main message
     * @return  a string the user enters
     */
    public static String question(String message) {
        return question(message,null);        
    }
    
    /**
     * Warning based dialog box
     * @param message the dialog's main message
     * @param title the dialog's box title 
     */
    public static void warning(String message, String title) {
        JOptionPane.showMessageDialog(gui,message,title,
                JOptionPane.WARNING_MESSAGE);
    }

    /**
     * Warning based dialog box
     * @param message the dialog's main message
     */
    public static void warning(String message) {
        warning(message,null);  
    }
    
    /**
     * Error based dialog box
     * @param message the dialog's main message
     * @param title the dialog's box title
     */
    public static void error(String message, String title) {
        JOptionPane.showMessageDialog(gui,message,title,
                JOptionPane.ERROR_MESSAGE);
    }   
    
    /**
     * uses a swing file chooser dialog to retrieve a filename from the user
     * @param format whether to display a "open" dialog or a "save" dialog
     * @return string of the user chosen filename
     */
    public static String getFileName(String format) {
        JFileChooser chooser = new JFileChooser();       
        if (format.equals(OPEN_FILE)) {
            chooser.setDialogTitle(OPEN_FILE_TITLE);
            chooser.showOpenDialog(gui);
        }
        else if (format.equals(SAVE_FILE)) {
            chooser.setDialogTitle(SAVE_FILE_TITLE);
            chooser.showSaveDialog(gui);
        }
        else return null;
        File file = chooser.getSelectedFile();
        if (file == null) return null;
        return file.getAbsolutePath();
    }
    
    /**
     * Drop down based dialog box
     * @param message the dialog's main message
     * @param options array of string options for the user to choose from
     * @param title the dialog's box title 
     * @return a string the user chooses from the options
     */
    public static String choices(String message, String options[], 
            String title) {
        Object object = JOptionPane.showInputDialog(gui,message,title, 
                JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
        if (object == null) return null;
        else                return object.toString();
    }
      
    /**
     * Drop down based dialog box
     * @param options array of string options for the user to choose from
     */
    public static String choices(String options[]) {
        return choices(null,options,null);
    }

    /**
     * Dialog asking to exit the program
     * @param form the JFrame to center parent to
     */
    public static boolean exit(JFrame form) {
        gui = form;
        return exit();
    }

    /**
     * Dialog asking to exit the program
     */
    public static boolean exit() {
        if (yesNo(EXIT_QUESTION) == YES) System.exit(0);
        return false;
    }
    
    /**
     * Dialog displaying yes and no buttons
     * @param message the dialog's main message
     * @param title the dialog's box title
     * @return yes (true) or no (false)
     */
    public static boolean yesNo(String message, String title) {
        if (JOptionPane.showConfirmDialog(gui, message,
                title,JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
            return true;
        else 
            return false;
    }
    
    /**
     * Dialog displaying yes and no buttons
     * @param message the dialog's main message
     * @return yes (true) or no (false)
     */
    public static boolean yesNo(String message) {
        return yesNo(message,null);
    }

    /**
     * Dialog displaying a message
     * @param message the dialog's main message
     * @param title the dialog's box title
     */
    public static void show(String message, String title) {
        JOptionPane.showMessageDialog(gui, message, title, 
                JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * Dialog displaying a message
     * @param message the dialog's main message
     */
    public static void show(String message) {
        show(message,null);
    }

    /**
     * Dialog getting user input and returning a string 
     * @param message the dialog's main message
     * @return the user inputted string
     */
    public static String inputString(String message) {
        return JOptionPane.showInputDialog(message);
    }

    /**
     * Dialog getting user input and returning an integer 
     * @param message the dialog's main message
     * @return the user inputted integer
     */
    public static int inputInteger(String message) {
        String text = inputString(message);
        if (Numbers.isValidInteger(text)) return Integer.parseInt(text);
        else                              return 0;
    }
    
    
        /**
     * Modification of the JOptionPane inputDialog
     * @param choices the choices to present in the combo box drop down
     * @param description text to display above the combo box
     * @param title the title of the dialog
     * @param style the style of the dialog
     * @param frame the frame to parent to 
     * @return the choice from the string array in the combo box they chose
     */
    public static String choice(String[] choices, String description, 
            String title, int style, JFrame frame) {
        Object data = JOptionPane.showInputDialog(frame, description, title, 
                style, null, choices, choices[0]);
        return data.toString();
    }
    
}
