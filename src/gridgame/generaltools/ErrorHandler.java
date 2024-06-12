
package gridgame.generaltools;

/**
 * ErrorHandler.java - static methods for tracking and displaying errors
 * @author Mr. Wachs' Computer Science Student
 * @since 16/03/2013
 * @version 1.0
 */
public class ErrorHandler 
{

    private static int errorNumber = 0;
    
    /**
     * displays the error message and the current error number
     * @param message the string message to display
     */
    public static void display(String message) {
        errorNumber++;
        Dialogs.error(message,"Error # " + errorNumber);        
    }

    /**
     * displays the error message and the current error number
     * @param message the string message to display
     * @param filename the filename causing the error
     * @param error the Exception that was thrown
     */
    public static void display(String message, String filename, Exception error) {
        display(message + " - with file: " + filename + "\n" +
                "Error was:\n\n" + error.getLocalizedMessage());
    }
    
}
