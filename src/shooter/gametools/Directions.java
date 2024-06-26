
/** required package class namespace */
package shooter.gametools;

/**
 * Directions.java - directional constants for movement
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class Directions 
{
    
    // type of game movement
    public static final int TWO_DIRECTIONS   = 2;
    public static final int FOUR_DIRECTIONS  = 4;
    public static final int EIGHT_DIRECTIONS = 8;
        
    // no directional movement
    public static final int STOP             = 0;
    
    // 8 direction game or diagonal game
    public static final int NORTH            = 1;
    public static final int NORTH_EAST       = 2;
    public static final int EAST             = 3;
    public static final int SOUTH_EAST       = 4;
    public static final int SOUTH            = 5;
    public static final int SOUTH_WEST       = 6;
    public static final int WEST             = 7;
    public static final int NORTH_WEST       = 8;
    
    // 4 direction game, or 2 direction game
    public static final int UP               = NORTH;
    public static final int DOWN             = SOUTH;
    public static final int LEFT             = WEST;
    public static final int RIGHT            = EAST;
    
}
