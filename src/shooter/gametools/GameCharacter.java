
/** required package class namespace */
package shooter.gametools;

/** required imports */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.Timer;

/**
 * GameCharacter.java - representation of a character in a game 
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public abstract class GameCharacter extends GameObject
{
    
    private Timer timer;

    /**
     * Constructor for the class sets class data
     * 
     * @param image the label associated with the image for the game character
     * @param direction the direction the game character will move
     * @param amount the amount the game character will move
     * @param delay the delay in milliseconds of the character's timer
     * @param numberOfDirections the number of directions defined
     */
    public GameCharacter(Image image, int direction, int amount, int delay,
                         int numberOfDirections) {
        super(image);                               // build game object
        super.coordinate = new Coordinate(image, direction, amount,
                                          numberOfDirections);
        timer = new Timer(delay, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                action();
            }
        });
        timer.start();                              // start character's timer
    }

    /**
     * The abstract action this character does in it's timer
     */
    public abstract void action();
    
    /**
     * Re-positions the character in it's container based on game character's 
     * data
     */
    public void redraw() {
        if (!isAlive) return;                       // no need for this action
        image.redraw(coordinate);
    }
    
    /**
     * Moves based on game character's coordinate data
     */
    public void move() {
        if (!isAlive) return;                       // no need for this action
        coordinate.move();
    }
        
    /**
     * Positions the game character correctly against (sticks to) the target
     * 
     * @param target the Game Object to stick to
     */
    public void stickTo(GameObject target) {
        if (!target.isAlive) return;                            // do not check
        coordinate.stickTo(target.coordinate);
    }
    
    /**
     * Changes current direction and bounces off the target 
     * 
     * @param target the Game Object to bounce off
     */
    public void bounceOff(GameObject target) {
        if (!target.isAlive) return;                            // do not check
        coordinate.bounceOff(target.coordinate);
    }
    
    /**
     * Moves a random direction based on how many directions of movement 
     * are defined
     */
    public void randomDirection() {
        coordinate.randomDirection();
    }
   
    /**
     * Puts this game character's position in the middle both horizontally and 
     * vertically to the target
     * 
     * @param target the Game Object to land on
     */
    public void landOn(GameObject target) {
        if (!target.isAlive) return;                            // do not check
        coordinate.landOn(target.coordinate);
    }
    
    /**
     * Centers this game character's position in the center and above the 
     * top of the target
     * 
     * @param target the Game Object to center to the top of
     */
    public void centerOnTop(GameObject target) {
        if (!target.isAlive) return;                            // do not check
        coordinate.centerOnTop(target.coordinate);
    }
    
    /**
     * Centers this game character's position in the center and below the 
     * bottom of the target
     * 
     * @param target the Game Object to center to the bottom of
     */
    public void centerOnBottom(GameObject target) {
        if (!target.isAlive) return;                            // do not check
        coordinate.centerOnBottom(target.coordinate);
    }
    
    /**
     * Centers this game character's position in the center and to the left 
     * of the target
     * 
     * @param target the Game Object to center to the left of
     */
    public void centerOnLeft(GameObject target) {
        if (!target.isAlive) return;                            // do not check
        coordinate.centerOnLeft(target.coordinate);
    }
    
    /**
     * Centers this game character's position in the center and to the right 
     * of the target
     * 
     * @param target the Game Object to center to the right of
     */
    public void centerOnRight(GameObject target) {
        if (!target.isAlive) return;                            // do not check
        coordinate.centerOnRight(target.coordinate);
    }    

    /**
     * The user's keyboard event of pressing a key to respond to
     * 
     * @param event the keyboard event registered
     */
    public void keyPress(KeyEvent event) {
        if (coordinate.numberOfDirections == Directions.TWO_DIRECTIONS) {
            if (event.getKeyCode() == KeyEvent.VK_LEFT)  
                     coordinate.direction = Directions.LEFT;
            else if (event.getKeyCode() == KeyEvent.VK_RIGHT) 
                     coordinate.direction = Directions.RIGHT;    
        }
        else if (coordinate.numberOfDirections == Directions.FOUR_DIRECTIONS) {
            if      (event.getKeyCode() == KeyEvent.VK_UP)    
                     coordinate.direction = Directions.UP;
            else if (event.getKeyCode() == KeyEvent.VK_DOWN)  
                     coordinate.direction = Directions.DOWN;
            else if (event.getKeyCode() == KeyEvent.VK_LEFT)  
                     coordinate.direction = Directions.LEFT;
            else if (event.getKeyCode() == KeyEvent.VK_RIGHT) 
                     coordinate.direction = Directions.RIGHT;    
        }
        else if (coordinate.numberOfDirections == Directions.EIGHT_DIRECTIONS) {
            if      (event.getKeyCode() == KeyEvent.VK_NUMPAD8)    
                     coordinate.direction = Directions.NORTH;
            else if (event.getKeyCode() == KeyEvent.VK_NUMPAD9)  
                     coordinate.direction = Directions.NORTH_EAST;
            else if (event.getKeyCode() == KeyEvent.VK_NUMPAD6)  
                     coordinate.direction = Directions.EAST;
            else if (event.getKeyCode() == KeyEvent.VK_NUMPAD3)  
                     coordinate.direction = Directions.SOUTH_EAST;
            else if (event.getKeyCode() == KeyEvent.VK_NUMPAD2)  
                     coordinate.direction = Directions.SOUTH;
            else if (event.getKeyCode() == KeyEvent.VK_NUMPAD1)  
                     coordinate.direction = Directions.SOUTH_WEST;
            else if (event.getKeyCode() == KeyEvent.VK_NUMPAD4)  
                     coordinate.direction = Directions.WEST;
            else if (event.getKeyCode() == KeyEvent.VK_NUMPAD7)  
                     coordinate.direction = Directions.NORTH_WEST;
        }        
    }
    
    /**
     * Stops all movement if it is taking place
     */
    public void stop() {
        coordinate.direction = Directions.STOP;
    }
    
    /**
     * Shuts this character down stops the timer, hides the character, and sets
     * it to not alive
     */
    public void shutDown() {
        image.hide();
        timer.stop();
        isAlive = false;
    }
    
}
