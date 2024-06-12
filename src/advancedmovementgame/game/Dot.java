
/** required package class namespace */
package advancedmovementgame.game;

/** required imports */
import javax.swing.JLabel;
import gametools.Animation;
import gametools.GameObject;


/**
 * Dot.java - representation of a dot in pacman
 *
 * @author Mr. Wachs 
 * @since 15-May-2019 
 */
public class Dot extends GameObject
{

    /**
     * Constructor for the class, sets class property data
     * 
     * @param label the label associated with the image for the game object
     */
    public Dot(JLabel label) {
        super(label);
        String[] images = { 
            Globals.DOT_IMAGES[0], 
            Globals.DOT_IMAGES[1] 
        };                                          // image files array
        int delay = 250;                            // animation delay
        Animation[] animations = new Animation[1];  // create animation
        animations[0] = new Animation(label, images, delay, true);
        sprite.setAnimations(animations);           // set to the sprite
        sprite.animate(0);                          // start animation
    }

}
