
package gridgame.mainprogram;

/**
 * required imports
 */
import GeneralTools.Dialogs;
import UserInterfaces.MainGUI;

/**
 * MainClass.java - the application's main class
 * @author Mr. Wachs' Computer Science Student
 * @since 16/03/2013
 * @version 1.0
 */
public class MainClass 
{

    /**
     * the program's main method
     * @param args command line arguments
     */
    public static void main(String[] args) 
    {       
        MainGUI gui = new MainGUI();                 
        Dialogs.gui = gui;
    }

}

        
        
