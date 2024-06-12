
/** required package class namespace */
package advancedmovementgame.game;

 
/**
 * Globals.java - global environmental values used throughout the classes for
 * the game
 *
 * @author Mr. Wachs
 * @since Jan. 9, 2020, 7:28:44 a.m.
 */
public class Globals 
{
    
    public static final String PATH                   = "/media/";
    public static final String PACMAN_DEATH_SOUND     = PATH + "pacman_death.wav";    
    public static final String PACMAN_CHOMP_SOUND     = PATH + "pacman_chomp.wav";
    public static final String PACMAN_EAT_GHOST_SOUND = PATH + "pacman_eatghost.wav";    
    public static final String DATA_FILE              = PATH + "data.txt";
    
    public static final String[] DOT_IMAGES = {
        PATH + "dot01.png",
        PATH + "dot02.png"
    };
        
    public static final String[] PACMAN_UP_IMAGES = {
            PATH + "pacmanUp01.png",
            PATH + "pacmanUp02.png",
            PATH + "pacmanUp03.png"            
    };
    
    public static final String[] PACMAN_DOWN_IMAGES = {
            PATH + "pacmanDown01.png",
            PATH + "pacmanDown02.png",
            PATH + "pacmanDown03.png"            
    };
    
    public static final String[] PACMAN_LEFT_IMAGES = {
            PATH + "pacmanLeft01.png",
            PATH + "pacmanLeft02.png",
            PATH + "pacmanLeft03.png"            
    };
    
    public static final String[] PACMAN_RIGHT_IMAGES = {
            PATH + "pacmanRight01.png",
            PATH + "pacmanRight02.png",
            PATH + "pacmanRight03.png"            
    };
    
    public static final String[] PACMAN_IDLE_IMAGES = {
            PATH + "pacmanIdle01.png",
            PATH + "pacmanIdle02.png",
            PATH + "pacmanIdle03.png",
            PATH + "pacmanIdle04.png"
    };
    
    public static final String[] GHOST_IMAGES = {
            PATH + "ghost01.png",
            PATH + "ghost02.png",
            PATH + "ghost03.png",
            PATH + "ghost04.png",
            PATH + "ghost05.png",
            PATH + "ghost06.png"
    };
    
}
