
/** required package class namespace */
package shooter.tools;

/** required imports */
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import javax.swing.Icon;

/**
 * RotatableIcon.java - allows you to change the orientation of an Icon by 
 * rotating the Icon before it is painted
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class RotatableIcon implements Icon 
{

    /** 
     * Enumeration for the class directions 
     */
    public enum Rotate { DOWN, UP, UPSIDE_DOWN, ABOUT_CENTER; }    
    
    private Icon   icon;
    private Rotate rotate;
    private double degrees;

    /**
     * Constructor to create a RotatedIcon that is rotated DOWN
     * 
     * @param icon the Icon to rotate
     */
    public RotatableIcon(Icon icon) {
        this(icon, Rotate.UP);
    }

    /**
     * Constructor that creates a RotatedIcon
     * 
     * @param icon the Icon to rotate
     * @param rotate the direction of rotation
     */
    public RotatableIcon(Icon icon, Rotate rotate) {
        this.icon   = icon;
        this.rotate = rotate;
    }

    /**
     * Create a RotatedIcon. The icon will rotate about its center. This
     * constructor will automatically set the Rotate enum to ABOUT_CENTER
     * 
     * @param icon the Icon to rotate
     * @param degrees the degrees of rotation
     */
    public RotatableIcon(Icon icon, double degrees) {
        this(icon, Rotate.ABOUT_CENTER);
        this.degrees = degrees;
    }

    /**
     * Gets the Icon to be rotated
     * 
     * @return the Icon to be rotated
     */
    public Icon getIcon() {
        return icon;
    }

    /**
     * Gets the Rotate enum which indicates the direction of rotation
     * 
     * @return the Rotate enum
     */
    public Rotate getRotate() {
        return rotate;
    }

    /**
     * Gets the degrees of rotation. Only used for Rotate.ABOUT_CENTER
     * 
     * @return the degrees of rotation
     */
    public double getDegrees() {
        return degrees;
    }

    /**
     * Set the degrees of rotation. Only used for Rotate.ABOUT_CENTER. This
     * method only sets the degrees of rotation, it will not cause the Icon to
     * be repainted
     * 
     * @param degrees the degrees of rotation
     */
    public void setDegrees(double degrees) {
        this.degrees = degrees;
    }

    /**
     * Gets the width of this icon
     * 
     * @return the width of the icon in pixels.
     */
    @Override
    public int getIconWidth() {
        if (rotate == Rotate.ABOUT_CENTER) {
            double radians = Math.toRadians(degrees);
            double sin     = Math.abs(Math.sin(radians));
            double cos     = Math.abs(Math.cos(radians));
            int    w       = icon.getIconWidth();
            int    h       = icon.getIconHeight();
            int    width   = (int) Math.floor(w * cos + h * sin);
            return width;
        } 
        else if (rotate == Rotate.UPSIDE_DOWN) {
            return icon.getIconWidth();
        } 
        else {
            return icon.getIconHeight();
        }
    }

    /**
     * Gets the height of this icon
     * 
     * @return the height of the icon in pixels
     */
    @Override
    public int getIconHeight() {
        if (rotate == Rotate.ABOUT_CENTER) {
            double radians = Math.toRadians(degrees);
            double sin     = Math.abs(Math.sin(radians));
            double cos     = Math.abs(Math.cos(radians));
            int    w       = icon.getIconWidth();
            int    h       = icon.getIconHeight();
            int    height  = (int) Math.floor(h * cos + w * sin);
            return height;
        } 
        else if (rotate == Rotate.UPSIDE_DOWN) {
            return icon.getIconHeight();
        } 
        else {
            return icon.getIconWidth();
        }
    }

    /**
     * Paint the icons of this compound icon at the specified location
     * 
     * @param component The component on which the icon is painted
     * @param graphics the graphics context
     * @param x the X coordinate of the icon's top-left corner
     * @param y the Y coordinate of the icon's top-left corner
     */
    @Override
    public void paintIcon(Component component, Graphics graphics, 
                          int x, int y) {
        Graphics2D graphics2D = (Graphics2D) graphics.create();
        int cWidth            = icon.getIconWidth() / 2;
        int cHeight           = icon.getIconHeight() / 2;
        int xAdjustment       = (icon.getIconWidth() % 2) == 0 ? 0 : -1;
        int yAdjustment       = (icon.getIconHeight() % 2) == 0 ? 0 : -1;
        if (rotate == Rotate.DOWN) {
            graphics2D.translate(x + cHeight, y + cWidth);
            graphics2D.rotate(Math.toRadians(90));
            icon.paintIcon(component, graphics2D, -cWidth, 
                           yAdjustment - cHeight);
        } 
        else if (rotate == Rotate.UP) {
            graphics2D.translate(x + cHeight, y + cWidth);
            graphics2D.rotate(Math.toRadians(-90));
            icon.paintIcon(component, graphics2D, 
                           xAdjustment - cWidth, -cHeight);
        } 
        else if (rotate == Rotate.UPSIDE_DOWN) {
            graphics2D.translate(x + cWidth, y + cHeight);
            graphics2D.rotate(Math.toRadians(180));
            icon.paintIcon(component, graphics2D, 
                           xAdjustment - cWidth, yAdjustment - cHeight);
        } 
        else if (rotate == Rotate.ABOUT_CENTER) {
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                                        RenderingHints.VALUE_ANTIALIAS_ON);
            AffineTransform original = graphics2D.getTransform();
            AffineTransform at = new AffineTransform();
            at.concatenate(original);
            int w = icon.getIconWidth();
            int h = icon.getIconHeight();
            at.translate((getIconWidth() - w) / 2, (getIconHeight() - h) / 2);
            at.rotate(Math.toRadians(degrees), x + cWidth, y + cHeight);
            graphics2D.setTransform(at);
            icon.paintIcon(component, graphics2D, x, y);
            graphics2D.setTransform(original);
        }
    }
    
}