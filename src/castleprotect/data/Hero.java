
/** Required package class namespace */
package castleprotect.data;

/** Required API imports */
import castleprotect.gametools.Directions;
import javax.swing.JLabel;
import javax.swing.JPanel;

 
/**
 * Hero.java - class represents the hero moving on the user interface
 *
 * @author Mr. Wachs
 * @since Jan 15, 2024, 8:05:36 a.m.
 */
public class Hero extends Character
{
    private int health;
    final int HEALTH_AMOUNT = 100;
    
    
    /**
     * Constructor for the class, sets class property data
     * 
     * @param image the label associated with the image for the game character
     * @param boundry 
     */
    public Hero(JLabel image, JPanel boundry) {
        super(image, Directions.STOP, boundry);     // Construct parent class
        final int MOVE_AMOUNT = 5;                  // Move amount
        coordinates.amount = MOVE_AMOUNT;           // set to character
        
        health = HEALTH_AMOUNT;        
    }
    
    /**
     * 
     * @param health 
     */
    public void setHealth(int health) {
        this.health = health;
    }
 
    /**
     * 
     * @return 
     */
    public int getHealth() {
        return health;
    }
    
    public void die() {
        
    }
    
}
