
/** Required package class namespace */
package castleprotect.data;

/** Required API imports */
import castleprotect.gametools.Directions;
import castleprotect.gametools.GameCharacter;
import javax.swing.JLabel;
import javax.swing.JPanel;

 
/**
 * Character.java - the moving characters in this simulation
 *
 * @author Mr. Wachs
 * @since Jan 15, 2024
 */
public class Character extends GameCharacter 
{

    private JPanel boundary;         // The outside boundry to move and spawn in

    private static final int MOVE_AMOUNT = 1;          // Constants for movement
    private static final int MOVE_DELAY   = 1;
    
    /**
     * Constructor for the class, sets class property data
     * 
     * @param image the label associated with the image for the game character
     * @param direction the direction the game character will move
     * @param boundary the panel acting as a boundary
     */
    public Character(JLabel image, int direction, JPanel boundary) {
        super(image, MOVE_AMOUNT, direction, MOVE_DELAY, 
              Directions.EIGHT_DIRECTIONS);
        this.boundary = boundary;       // Associate parameter with property
    }
    
    /**
     * The action this character does in it's timer
     */
    @Override
    public void action() {
        mover.move();                   // Move the character
        checkBoundries();               // Check to stay in boundries
        redraw();                       // Redraw on screen
    }    
    
    /**
     * Checks the outside boundries for movement of the character
     */
    private void checkBoundries() {
        if (boundary == null) return;            // Error check
        int width  = boundary.getWidth();        // Get width and height of
        int height = boundary.getHeight();       // boundry area
        if (coordinates.top <= 0) {             // Outside the top boundry
            coordinates.y = 1;                  // Set inside the boundry
            coordinates.recalculate();          // Recalculate other values
        }
        if (coordinates.bottom >= height) {
            coordinates.y = height - coordinates.height - 1;
            coordinates.recalculate();
        }
        if (coordinates.left <= 0) {
            coordinates.x = 1;
            coordinates.recalculate();
        }
        if (coordinates.right >= width) {
            coordinates.x = width - coordinates.width - 1;
            coordinates.recalculate();
        }
    }
    
    /**
     * Destroy this object and free up memory resources
     */
    @Override
    public void finalize() {
        timer.stop();                       // Stop the timer
        input    = null;                    // Nullify the objects
        timer    = null;
        boundary = null;                  
        System.gc();                        // Call system garbage collection
    }
    
}
