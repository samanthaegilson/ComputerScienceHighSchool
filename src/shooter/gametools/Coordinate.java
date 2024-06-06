
/** required package class namespace */
package shooter.gametools;

/**
 * Coordinate.java - stores data on position and movement as well as methods 
 * to move those values
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class Coordinate 
{

    /** 
     * Property data tracking an object's location and movement 
     */
    public int x,y,width,height,
               left,right,top,bottom,
               amount,direction, numberOfDirections;
    
    private Image hitbox;                      // the Image hitbox image
    
    /**
     * Default constructor for the class 
     */
    public Coordinate() {
        this(0,0,0,0);
    }
    
    /**
     * Constructor for the class sets class properties
     * 
     * @param x the x value coordinate
     * @param y the y value coordinate
     * @param width the width value coordinate
     * @param height the height value coordinate 
     */
    public Coordinate(int x, int y, int width, int height) {
        hitbox             = null;              // set image to null
        direction          = Directions.STOP;   // set movement to stop
        amount             = Directions.STOP;
        numberOfDirections = Directions.STOP;
        this.x      = x;                    // assign parameters to properties
        this.y      = y;
        this.width  = width;
        this.height = height;
        recalculate();
    }
    
    /**
     * Constructor for the class sets class properties
     * 
     * @param image the JLabel hitbox image
     */
    public Coordinate(Image image) {
        hitbox             = image;             // assign parameter to property
        direction          = Directions.STOP;   // set movement to stop
        amount             = Directions.STOP;
        numberOfDirections = Directions.STOP;
        update();                               // update coordinate data
    }
    
    /**
     * Constructor for the class sets class properties
     * 
     * @param image the JLabel hitbox image
     * @param direction the starting direction of movement
     * @param amount the starting amount of movement
     * @param numberOfDirections the number of directions defined
     */
    public Coordinate(Image image, int direction, int amount, 
                      int numberOfDirections) {
        hitbox         = image;                 // assign parameter to property
        this.direction = direction;             // assign parameter to property
        this.amount    = amount;                // assign parameter to property
        this.numberOfDirections = numberOfDirections;
        update();                               // update coordinate data
    }
      
    /**
     * Updates the current location of the coordinates box in its container
     */
    public void update() {
        x      = hitbox.getX();         // get x coordinate from hitbox
        y      = hitbox.getY();         // get y coordinate from hitbox
        width  = hitbox.getWidth();     // get width coordinate from hitbox
        height = hitbox.getHeight();    // get height coordinate from hitbox
        recalculate();                  // recalculate other needed data
    }

    /**
     * Recalculates needed movement data
     */
    public void recalculate() {
        left   = x;                         // calculate left from x
        top    = y;                         // calculate top from y
        right  = left + width;              // right calculated left + width
        bottom = top  + height;             // bottom calculated top + height
    }
    
    /**
     * Determines if one set of coordinate data is overlapping (colliding) 
     * with the target coordinate data horizontally
     * 
     * @param target the coordinate data to check against 
     * @return it is colliding (true) or not (false) horizontally
     */
    public boolean isOverlappingHorizontally(Coordinate target) {
        if      (left         >= target.left && 
                 left         <= target.right)      return true;
        else if (right        >= target.left && 
                 right        <= target.right)      return true;
        else if (target.left  >= left        && 
                 target.left  <= right)             return true;
        else if (target.right >= left        && 
                 target.right <= right)             return true;
        else                                        return false;
    }
    
    /**
     * Determines if one set of coordinate data is overlapping (colliding) 
     * with the target coordinate data vertically
     * 
     * @param target the coordinate data to check against 
     * @return it is colliding (true) or not (false) vertically
     */
    public boolean isOverlappingVertically(Coordinate target) {
        if      (top           >= target.top && 
                 top           <= target.bottom)    return true;
        else if (bottom        >= target.top && 
                 bottom        <= target.bottom)    return true;
        else if (target.top    >= top        && 
                 target.top    <= bottom)           return true;
        else if (target.bottom >= top        && 
                 target.bottom <= bottom)           return true;
        else                                        return false;
    }
    
    /**
     * Determines if one set of coordinate data is overlapping (colliding) 
     * with the target coordinate data both vertically and horizontally
     * 
     * @param target the coordinate data to check against 
     * @return it is colliding (true) or not (false) 
     */
    public boolean isOverlapping(Coordinate target) {
        if (isOverlappingVertically(target) &&
            isOverlappingHorizontally(target)) {
            return true;                            // is colliding
        }
        else {
            return false;                           // is not colliding
        }
    }
    
    /**
     * Moves all coordinate data up
     */    
    public void moveUp() {
        direction = Directions.UP;      // assign direction
        y = y - amount;                 // move y towards origin point
        recalculate();                  // recalculate other coordinate data
    }
    
    /**
     * Moves all coordinate data down
     */
    public void moveDown() {
        direction = Directions.DOWN;    // assign direction
        y = y + amount;                 // move y away from origin point
        recalculate();                  // recalculate other coordinate data
    }
    
    /**
     * Moves all coordinate data left
     */
    public void moveLeft() {
        direction = Directions.LEFT;    // assign direction
        x = x - amount;                 // move x towards origin point
        recalculate();                  // recalculate other coordinate data
    }
    
    /**
     * Moves all coordinate data right
     */
    public void moveRight() {
        direction = Directions.RIGHT;   // assign direction
        x = x + amount;                 // move x away from origin point
        recalculate();                  // recalculate other coordinate data
    }
    
    /**
     * Moves all coordinate data north
     */
    public void moveNorth() {
        moveUp();
        direction = Directions.NORTH;   // assign direction
    }
    
    /**
     * Moves all coordinate data south
     */
    public void moveSouth() {
        moveDown();
        direction = Directions.SOUTH;   // assign direction
    }
    
    /**
     * Moves all coordinate data east
     */
    public void moveEast() {
        moveRight();
        direction = Directions.EAST;    // assign direction
    }
    
    /**
     * Moves all coordinate data west
     */
    public void moveWest() {
        moveLeft();
        direction = Directions.WEST;    // assign direction
    }
    
    /**
     * Moves all coordinate data north east
     */
    public void moveNorthEast() {
        moveNorth();
        moveEast();
        direction = Directions.NORTH_EAST;  // assign direction
    }
    
    /**
     * Moves all coordinate data north west
     */
    public void moveNorthWest() {
        moveNorth();
        moveWest();
        direction = Directions.NORTH_WEST;  // assign direction
    }

    /**
     * Moves all coordinate data south east
     */
    public void moveSouthEast() {
        moveSouth();
        moveEast();
        direction = Directions.SOUTH_EAST;  // assign direction
    }
    
    /**
     * Moves all coordinate data south west
     */
    public void moveSouthWest() {
        moveSouth();
        moveWest();
        direction = Directions.SOUTH_WEST;  // assign direction
    }
    
    /**
     * Moves all the coordinate data based on the direction
     */
    public void move() {
        if      (direction == Directions.UP)         moveUp();
        else if (direction == Directions.DOWN)       moveDown();
        else if (direction == Directions.LEFT)       moveLeft();
        else if (direction == Directions.RIGHT)      moveRight();        
        else if (direction == Directions.NORTH)      moveNorth();
        else if (direction == Directions.NORTH_EAST) moveNorthEast();
        else if (direction == Directions.EAST)       moveEast();
        else if (direction == Directions.SOUTH_EAST) moveSouthEast();
        else if (direction == Directions.SOUTH)      moveSouth();
        else if (direction == Directions.SOUTH_WEST) moveSouthWest();
        else if (direction == Directions.WEST)       moveWest();
        else if (direction == Directions.NORTH_WEST) moveNorthWest();        
    }
    
    /**
     * Moves a random direction based on how many directions of movement 
     * are defined
     */
    public void randomDirection() {
        int random = (int)((numberOfDirections) * Math.random() + 1d);
        if (numberOfDirections == Directions.TWO_DIRECTIONS) {
            if      (random == 1) direction = Directions.LEFT;
            else if (random == 2) direction = Directions.RIGHT;
        }
        else if (numberOfDirections == Directions.FOUR_DIRECTIONS) {
            if      (random == 1) direction = Directions.UP;
            else if (random == 2) direction = Directions.DOWN;
            else if (random == 3) direction = Directions.LEFT;
            else if (random == 4) direction = Directions.RIGHT;
        }
        else if (numberOfDirections == Directions.EIGHT_DIRECTIONS) {
            if      (random == 1) direction = Directions.NORTH;
            else if (random == 2) direction = Directions.NORTH_EAST;
            else if (random == 3) direction = Directions.EAST;
            else if (random == 4) direction = Directions.SOUTH_EAST;
            else if (random == 5) direction = Directions.SOUTH;
            else if (random == 6) direction = Directions.SOUTH_WEST;
            else if (random == 7) direction = Directions.WEST;
            else if (random == 8) direction = Directions.NORTH_WEST;
        }
        else {
            direction = Directions.STOP;
        }
    }
    
    /**
     * Positions the coordinate data correctly against (sticks to) the target
     * coordinate data
     * 
     * @param target the coordinate data to stick to
     */
    public void stickTo(Coordinate target) {
        if      (direction == Directions.UP)    
                                            y = target.y + target.height + 1;
        else if (direction == Directions.DOWN)  
                                            y = target.y - height        - 1;
        else if (direction == Directions.RIGHT) 
                                            x = target.x - width         - 1;
        else if (direction == Directions.LEFT)  
                                            x = target.x + target.width  + 1;
        recalculate();
    }
    
    /**
     * Changes current direction and bounces off the target coordinate data
     * 
     * @param target the coordinate data to bounce off
     */
    public void bounceOff(Coordinate target) {
        stickTo(target);
        if      (direction == Directions.UP)    direction = Directions.DOWN;
        else if (direction == Directions.DOWN)  direction = Directions.UP;
        else if (direction == Directions.LEFT)  direction = Directions.RIGHT;
        else if (direction == Directions.RIGHT) direction = Directions.LEFT;        
    }

    /**
     * Puts this object's position in the middle both horizontally and 
     * vertically to the target
     * 
     * @param target the coordinate data to land on
     */
    public void landOn(Coordinate target) {
        if      (target.width  > width)          
            x = target.x + (target.width / 2)  - (width / 2);
        else if (width         > target.width)   
            x = target.x - (width / 2)         + (width / 2);        
        if      (target.height > height)         
            y = target.y + (target.height / 2) - (height / 2);
        else if (height        > target.height)  
            y = target.y - (height / 2)        + (height / 2);        
        recalculate();
    }
    
    /**
     * Centers this object's position in the center and above the top of 
     * the target
     * 
     * @param target the coordinate data to center to the top of
     */
    public void centerOnTop(Coordinate target) {
        landOn(target);
        y = target.top - height - 1;  
        recalculate();
    }
    
    /**
     * Centers this object's position in the center and below the bottom of 
     * the target
     * 
     * @param target the coordinate data to center to the bottom of
     */
    public void centerOnBottom(Coordinate target) {
        landOn(target);
        y = target.bottom + 1;  
        recalculate();
    }
    
    /**
     * Centers this object's position in the center and to the left of the 
     * target
     * 
     * @param target the coordinate data to center to the left of
     */
    public void centerOnLeft(Coordinate target) {
        landOn(target);
        x = target.left - width - 1;  
        recalculate();
    }
    
    /**
     * Centers this object's position in the center and to the right of the 
     * target
     * 
     * @param target the coordinate data to center to the right of
     */
    public void centerOnRight(Coordinate target) {
        landOn(target);
        x = target.right + 1;  
        recalculate();
    }
    
    /**
     * Checks if the current set of coordinates is above the passed set
     * 
     * @param target the coordinates to see if we are above
     * @return we are above (true) or not (false)
     */
    public boolean isAbove(Coordinate target) {
        if (bottom < target.top) return true;
        return false;
    }
    
    /**
     * Checks if the current set of coordinates is below the passed set
     * 
     * @param target the coordinates to see if we are below
     * @return we are above (true) or not (false)
     */
    public boolean isBelow(Coordinate target) {
        if (top > target.bottom) return true;
        return false;
    }
    
    /**
     * Checks if the current set of coordinates is right of the passed set
     * 
     * @param target the coordinates to see if we are right of
     * @return we are above (true) or not (false)
     */
    public boolean isRightOf(Coordinate target) {
        if (left > target.right) return true;
        return false;
    }
    
    /**
     * Checks if the current set of coordinates is left of the passed set
     * 
     * @param target the coordinates to see if we are left of
     * @return we are above (true) or not (false)
     */
    public boolean isLeftOf(Coordinate target) {
        if (right < target.left) return true;
        return false;
    }
    
}
