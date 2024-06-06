
/** required package class namespace */
package shooter.shooter;

/** required imports */
import shooter.gametools.GameObject;
import shooter.gametools.Image;

/**
 * Wall.java - represents a wall in the survivor game
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class Wall extends GameObject
{

    /**
     * Constructor for the class sets class data
     * 
     * @param image the image associated with the game character
     */
    public Wall(Image image) {
        super(image);        
        setDebug(Constants.WALL_TEXT, Constants.WALL_COLOR);
        setBorder(false);
    }

}
