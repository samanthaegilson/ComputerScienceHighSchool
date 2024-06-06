
/** required package class namespace */
package shooter.tools;

/** required imports */
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 * Dialogs.java - a collection of useful methods for user dialog boxes
 * 
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class Dialogs 
{
    /** 
     * The title to appear on the dialog 
     */
    public String dialogTitle;
    
    /** 
     * The parent frame to parent the dialog to 
     */
    public JFrame parent;

    
    /** 
     * Default constructor for the class 
     */
    public Dialogs() {
        this("",null);
    }
    
    /**
     * Constructor sets class data
     * 
     * @param dialogTitle the title to appear on the dialog
     */
    public Dialogs(String dialogTitle) {
        this(dialogTitle,null);
    }
    
    /**
     * Constructor sets class data
     * 
     * @param dialogTitle the title to appear on the dialog
     * @param parent the parent frame to parent the dialog to
     */
    public Dialogs(String dialogTitle, JFrame parent) {
        this.dialogTitle = dialogTitle;
        this.parent      = parent;
    }
    
    /**
     * Shows a dialog with a drop down of choices
     * 
     * @param text to display in the dialog
     * @param choices to display in the drop down
     * @return the choice the user selects
     */
    public String choose(String text, String[] choices) {        
        JTextArea area = new JTextArea(text);
        Font font = new Font("Arial",Font.BOLD,12);
        Color background = new Color(238,238,238);
        area.setFont(font);
        area.setBackground(background);
        Object object = JOptionPane.showInputDialog(parent, area, dialogTitle,
                JOptionPane.PLAIN_MESSAGE, null, choices, choices[0]);
        if (object == null) return null;
        else                return object.toString();        
    }
    
    /**
     * Shows a dialog with a series of buttons
     * 
     * @param text to display in the dialog
     * @param buttonTexts the text on the various buttons
     * @return the text of the button that was clicked
     */
    public String buttons(String text, String[] buttonTexts) {
        int result = JOptionPane.showOptionDialog(null, text, dialogTitle,
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, 
                buttonTexts, buttonTexts[0]);
        if (result == -1) return "";
        return buttonTexts[result];
    }
        
    /**
     * Gets user input as a integer with dialog box with error checking
     * 
     * @param text the text to display in the dialog
     * @param title the title of the dialog
     * @return the integer the user entered
     */
    public int getInteger(String text, String title) {
        String error = "";
        while (true) {                        // get the initial user input
            String user = JOptionPane.showInputDialog(null,
                    error + text, title, JOptionPane.PLAIN_MESSAGE);     
            if (user == null) { // hit cancel or red X
                error = "Please enter a proper number\n";
            }
            else if (user.equals("")) { // hit ok without typing
                error = "Please enter something\n";
            }
            else { // typed in something other than a valid int
                boolean valid = true;
                for (int i = 0; i < user.length(); i++) {
                    // travel through characters in string, get each 
                    char character = user.charAt(i);
                    if (Character.isDigit(character) == false) {
                        error = "Please do not enter non numeric "
                                + "characters\n";
                        i = user.length();
                        valid = false;
                    }
                }
                if (valid == true) { // passes all checks:
                    int number = Integer.parseInt(user);
                    return number;    
                }
            }
        }
    }
    
    /**
     * Dialog with a drop down display for the user to select from
     * 
     * @param text the text to display in the dialog
     * @param title the title of the dialog
     * @param options all the options to show in the drop down
     * @return the drop down option the user selects
     */
    public String dropdown(String text, String title, 
                                   String[] options) { 
        Object object = JOptionPane.showInputDialog(null,text,title,
                JOptionPane.PLAIN_MESSAGE,null,options,options[0]);
        while (object == null) {
            object = JOptionPane.showInputDialog(null,text,title,
                    JOptionPane.PLAIN_MESSAGE,null,options,options[0]);
        }
        return object.toString();
    }
    
    /**
     * Dialog output of the message and title
     * 
     * @param message the text to display in the dialog
     * @param title the title of the dialog
     */
    public void output(String message, String title) {
        JTextArea area = new JTextArea(message);
        Font font = new Font("Arial",Font.BOLD,12);
        Color background = new Color(238,238,238);
        area.setFont(font);
        area.setBackground(background);
        JOptionPane.showMessageDialog(parent, area, title, 
                JOptionPane.PLAIN_MESSAGE, null);
    }

    /**
     * Dialog confirm with yes/no buttons, the message and the title
     * 
     * @param message the text to display in the dialog
     * @return user selected yes (true) or not (false)
     */
    public boolean yesNo(String message) {
        int result = JOptionPane.showConfirmDialog(parent, message, dialogTitle, 
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
        if (result == JOptionPane.YES_OPTION) return true;
        else                                  return false;        
    }
    
}
