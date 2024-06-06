
/** required package */
package shooter.tools;

/** required imports */
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * ImageLabel.java - a custom label for images that can be rotated
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class ImageLabel extends JLabel
{
    
    private ImageIcon   imageIcon;
    private RotatableIcon rotatedIcon;
    private int         x;
    private int         y;
    private int         width;
    private int         height;
        
    
    /**
     * Constructor for the class sets class properties to the parameters
     * 
     * @param originalLabel the label to modify
     * @param x the x coordinate of the original label
     * @param y the y coordinate of the original label
     * @param width the width coordinate of the original label
     * @param height the height coordinate of the original label
     */
    public ImageLabel(JLabel originalLabel, int x, int y, int width, 
                      int height) {
        this.x      = x;
        this.y      = y;
        this.width  = width;
        this.height = height;        
        imageIcon   = (ImageIcon)originalLabel.getIcon();
        rotatedIcon = new RotatableIcon(imageIcon,0.0);
        this.setIcon(rotatedIcon);
    }    
    
    /**
     * Constructor for the class sets class properties to the parameters
     * 
     * @param filename the class referenced filename of the image file
     * @param x the starting x coordinate in the container
     * @param y the starting y coordinate in the container
     * @param width the width of the label in the container
     * @param height the height of the label in the container
     */
    public ImageLabel(String filename, int x, int y, int width, int height) {
        this.x      = x;
        this.y      = y;
        this.width  = width;
        this.height = height;        
        imageIcon   = new ImageIcon(getClass().getResource(filename));
        rotatedIcon = new RotatableIcon(imageIcon,0.0);
        this.setIcon(rotatedIcon);
    }
        
    /**
     * Moves the image label in the container up
     * 
     * @param amount the amount to move
     */
    public void moveUp(int amount) {
        rotatedIcon = new RotatableIcon(imageIcon,RotatableIcon.Rotate.UP);
        y -= amount;
        this.setBounds(x,y,width,height);
        this.setIcon(rotatedIcon);
    }
    
    /**
     * Moves the image label in the container down
     * 
     * @param amount the amount to move
     */
    public void moveDown(int amount) {
        rotatedIcon = new RotatableIcon(imageIcon,RotatableIcon.Rotate.DOWN);
        y += amount;
        this.setBounds(x,y,width,height);
        this.setIcon(rotatedIcon);
    }
    
    /**
     * Moves the image label in the container left
     * 
     * @param amount the amount to move
     */
    public void moveLeft(int amount) {
        rotatedIcon = new RotatableIcon(imageIcon,
                RotatableIcon.Rotate.UPSIDE_DOWN);
        x -= amount;
        this.setBounds(x,y,width,height);
        this.setIcon(rotatedIcon);
    }
    
    /**
     * Moves the image label in the container right
     * 
     * @param amount the amount to move
     */
    public void moveRight(int amount) {
        rotatedIcon = new RotatableIcon(imageIcon,
                RotatableIcon.Rotate.ABOUT_CENTER);
        x += amount;
        this.setBounds(x,y,width,height);
        this.setIcon(rotatedIcon);
    }
    
    /**
     * Rotates the image label in the container
     * 
     * @param degrees the amount of degrees to turn the image label
     */
    public void turn(double degrees) {
        rotatedIcon = new RotatableIcon(imageIcon,degrees);
        this.setBounds(x,y,width,height);
        this.setIcon(rotatedIcon);
    }

    /**
     * Gets the current rotation amount in degrees
     * 
     * @return the current rotation amount in degrees
     */
    public double getRotation() {
        return rotatedIcon.getDegrees();
    }
    
}
