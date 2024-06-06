
/** required package class namespace */
package shooter.tools;

/** required imports */
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * ImageTools.java - useful methods for working with images
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class ImageTools 
{

    /**
     * Resizes the image inside the label to match the size of the label
     * 
     * @param imageLabel the label to resize
     */
    public void resizeImage(JLabel imageLabel) {
        int       w             = imageLabel.getWidth();
        int       h             = imageLabel.getHeight();
        ImageIcon originalIcon  = (ImageIcon)imageLabel.getIcon();
        Image     originalImage = originalIcon.getImage();        
        Image     newImage      = originalImage.getScaledInstance(w,h,
                                                          Image.SCALE_SMOOTH);
        ImageIcon newIcon       = new ImageIcon(newImage); 
        imageLabel.setIcon(newIcon);                
    }

    /**
     * Change the image inside a label to a new image an possibly resize the 
     * image to fit the label size
     * 
     * @param imageLabel the label to change
     * @param newImageFile the new image file to change the label to
     * @param shouldResize the image should resize (true) or not (false)
     */
    public void changeImage(JLabel imageLabel, String newImageFile, 
                            boolean shouldResize) {
        ImageIcon icon = new ImageIcon(getClass().getResource(newImageFile));
        imageLabel.setIcon(icon);
        if (shouldResize) resizeImage(imageLabel);        
    }
    
}
