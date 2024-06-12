
package gridgame.generaltools;

/**
 * required imports
 */
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 * FormTools.java - static methods for manipulating JFrame forms
 * @author Mr. Wachs' Computer Science Student
 * @since 16/03/2013
 * @version 1.0
 */
public class FormTools 
{
    
    /**
     * places the passed JFrame form in the center of the operating system's
     * screen, and sets the form's width, height, size-ability, title, 
     * and visibility
     * @param form the JFrame to set
     * @param width the form's width to set
     * @param height the form's height to set
     * @param visible the form's visibility to set
     * @param resizable the form's resizability to set
     * @param title the form's title to set
     */
    public static void startFormCenter(JFrame form, int width, int height, 
            boolean visible, boolean resizable, String title) {
        form.setSize(width,height);
        centerForm(form);
        form.setResizable(resizable);
        form.setTitle(title);
        form.setVisible(visible);
    }
    
    /**
     * centers the passed JFrame form in the operating system's screen
     * @param form the JFrame to set to center screen
     */
    public static void centerForm(JFrame form) {
        Dimension dimensions = Toolkit.getDefaultToolkit().getScreenSize();
        int width  = form.getSize().width;
        int height = form.getSize().height;
        int x      = (dimensions.width  - width)  / 2;
        int y      = (dimensions.height - height) / 2;
        form.setLocation(x, y);
    }

    /**
     * sets the passed JFrame to a full screen application
     * @param form the JFrame to set to full screen
     * @param visible the form's visibility to set
     * @param resizable the form's resizability to set
     * @param title the form's title to set
     */
    public static void setFullScreen(JFrame form, boolean visible, 
            boolean resizable, String title) {
        form.setVisible(visible);
        form.setResizable(resizable);
        Dimension dimensions = Toolkit.getDefaultToolkit().getScreenSize();
        int width  = dimensions.width;
        int height = dimensions.height;
        form.setSize(width,height);
    }
    
}
