
/** required package class namespace */
package advancedmovementgame.game;

/** required imports */
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import gametools.Animation;
import gametools.Directions;
import tools.FileHandler;
import gametools.GameCharacter;
import tools.MediaPlayer;


/**
 * Enemy.java - representation of a enemy in a game 
 *
 * @author Mr. Wachs 
 * @since 15-May-2019 
 */
public class Ghost extends GameCharacter
{

    private Wall[]      walls;
    private Pacman      pacman;
    private MediaPlayer player;    
    private FileHandler file;
    
    
    /**
     * Constructor for the class, sets class property data
     * 
     * @param ghostLabel the label associated with the image for the game character
     * @param pacman the pacman object
     * @param walls the array of wall objects
     * @param player the media player object
     * @param file the file handler object
     */
    public Ghost(
            JLabel ghostLabel, 
            Pacman pacman, 
            Wall[] walls, 
            MediaPlayer player,
            FileHandler file) {
        super(ghostLabel, 1, Directions.STOP, 10,
                Directions.FOUR_DIRECTIONS);
        this.walls  = walls;                // associate parameters with objects
        this.pacman = pacman;
        this.player = player;        
        this.file   = file; 
        mover.randomDirection();            // start in a random direction
        String[] ghostImages = {
            Globals.GHOST_IMAGES[0],
            Globals.GHOST_IMAGES[1],
            Globals.GHOST_IMAGES[2],
            Globals.GHOST_IMAGES[3],
            Globals.GHOST_IMAGES[4],
            Globals.GHOST_IMAGES[5]
        };                                  // array of animation images
        int delay = 2000;                   // animation delay
        Animation[] animations = new Animation[1];  // create animation
        animations[0] = new Animation(ghostLabel, ghostImages, delay, true);
        sprite.setAnimations(animations);
        sprite.animate(0);                  // start animating
        spawn();                            // spawn this ghost
    }

    /** 
     * The action this ghost does in it's timer 
     */
    @Override
    public void action() {
        mover.move();                               // move coordinates
        for (int i = 0; i < walls.length; i++) {    // traverse walls
            if (detector.isOverLapping(walls[i])) { // colliding with wall
                reactor.bounceOff(walls[i]);        // bounce off wall
                mover.randomDirection();            // go random direction
                i = walls.length;                   // exit loop early 
            }
        }
        if (detector.isOverLapping(pacman)) {       // checking for pacman
            pacman.mover.stop();                    // stop pacman
            pacman.sprite.animate(0);               // change pacman animation
            player.playWAV(Globals.PACMAN_DEATH_SOUND); // play sound
            String name = JOptionPane.showInputDialog("Enter name"); // get name
            String[] data = { name, "" + pacman.points };       // make array
            file.write(data);                       // save array to file
            System.exit(0);                         // exit application
        }        
        redraw();                                   // redraw ghost
    }

}
