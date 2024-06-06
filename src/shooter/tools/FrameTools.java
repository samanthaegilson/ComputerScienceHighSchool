
/** required package class namespace */
package shooter.tools;

/** required imports */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 * FrameTools.java - tools for working with frame containers
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class FrameTools 
{

    /**
     * Sets a icon to the frame based on the passed file name
     * 
     * @param frame the frame to set the icon to
     * @param iconFileName the file name for the icon 
     */
    public void setIcon(Window frame, String iconFileName) {
        if (frame == null) return;
        if (iconFileName == null) return;       
        FileHandler tool = new FileHandler(iconFileName);
        File        file = tool.convertToFile(iconFileName);
        String      path = file.getAbsolutePath();
        ImageIcon   icon = new ImageIcon(path);
        frame.setIconImage(icon.getImage());
    }    
        
    /**
     * Sets a background color to the frame based on the passed color
     * 
     * @param frame the frame to set the icon to
     * @param background the color for the frame's background
     */
    public void setBackground(JFrame frame, Color background) {
        if (frame == null) return;
        if (background != null) {
            frame.getContentPane().setBackground(background);
            frame.setBackground(background);
        }
    }
    
    /**
     * Sets a frame to full screen (no decoration)
     * 
     * @param frame the frame to set to full screen
     */
    public void setFullScreen(JFrame frame) {
        if (frame == null) return;        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int       width      = (int)screenSize.getWidth();
        int       height     = (int)screenSize.getHeight();
        setUndecorated(frame, true);
        frame.setSize(width, height);
    }
    
    /**
     * Sets a frame to be undecorated
     * 
     * @param frame the frame to set to undecorated
     * @param isUndecorated undecorated (true) or not (false)
     */
    public void setUndecorated(JFrame frame, boolean isUndecorated) {
        if (isUndecorated) frame.setUndecorated(true);
    }
    
    /**
     * Sets the default close operation for the frame to exit the application
     * or do nothing
     * 
     * @param frame the frame to set the close operation to
     * @param closeShouldEndApp should exit app (true) or do nothing (false)
     */
    public void setCloseOpertion(JFrame frame, boolean closeShouldEndApp) {
        if (closeShouldEndApp) frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        else                   frame.setDefaultCloseOperation(
                                                        DISPOSE_ON_CLOSE);
    }
    
    /**
     * Sets the frame to center screen
     * 
     * @param frame the frame to center on the screen
     * @param isCenterScreen should be center screen (true) or not (false)
     */
    public void setCenterScreen(Window frame, boolean isCenterScreen) {
        if (isCenterScreen) frame.setLocationRelativeTo(null);
    }
    
    /**
     * Initializes a JFrame to the set parameter values
     * 
     * @param frame the JFrame to initialize
     * @param title the frame's title
     * @param width the frame's width
     * @param height the frame's height
     */
    public void startup(JFrame frame, String title, int width, int height) {
        if (frame == null) return;
        frame.setTitle(title);
        frame.setSize(width, height);
        frame.setVisible(true);
    }    
        
    /**
     * Initializes a JFrame to the set parameter values
     * 
     * @param frame the JFrame to initialize
     * @param title the frame's title
     * @param width the frame's width
     * @param height the frame's height
     * @param resizable should the user resize the frame (true) or not (false)
     * @param isCenterScreen is the frame center screen (true) or not (false)
     * @param closeShouldEndApp should close end the app (true) or not (false)
     * @param isUndecorated should frame have control box (true) or not (false)
     * @param background the background color for the frame
     * @param iconFileName the file name for the frame icon
     */
    public void startup(JFrame frame, String title, int width, int height,
                     boolean resizable, boolean isCenterScreen, 
                     boolean closeShouldEndApp, boolean isUndecorated,
                     Color background, String iconFileName) {
        if (frame == null) return;
        frame.setTitle(title);
        frame.setSize(width, height);
        frame.setResizable(resizable);
        setUndecorated(frame, isUndecorated);
        setCenterScreen(frame,isCenterScreen);
        setCloseOpertion(frame, closeShouldEndApp);
        setBackground(frame, background);
        setIcon(frame, iconFileName);
        frame.setVisible(true);
    }
    
    /**
     * Initializes a JFrame to the set parameter values
     * 
     * @param dialog the JDialog to initialize
     * @param title the frame's title
     * @param width the frame's width
     * @param height the frame's height
     * @param isCenterScreen is the frame center screen (true) or not (false)
     * @param iconFileName the file name for the frame icon
     */
    public void startup(JDialog dialog, String title, int width, int height,
                        boolean isCenterScreen, String iconFileName) {
        if (dialog == null) return;
        dialog.setTitle(title);
        dialog.setSize(width, height);
        setCenterScreen(dialog,isCenterScreen);
        setIcon(dialog, iconFileName);
        dialog.setVisible(true);
    }
    
}
