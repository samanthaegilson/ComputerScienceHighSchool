
/** required package class namespace */
package shooter;

/** required imports */
import gametools.GameCharacter;
import gametools.Image;
import tools.MediaPlayer;

/**
 * Projectile.java - represents a projectile in the survivor game
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class Projectile extends GameCharacter
{

    private Wall[]      walls;
    private EnemyMaster enemyMaster;
    private MediaPlayer player;
    
    
    /**
     * Constructor for the class sets class data to the parameters
     * 
     * @param image the image associated with the game character
     * @param spawners the spawners object to associate with
     * @param walls the walls objects to associate with
     * @param direction the direction to move the projectile
     */
    public Projectile(Image image, EnemyMaster enemyMaster, Wall[] walls, 
                      int direction) {
        super(image,
              direction, 
              Constants.PROJECTILE_MOVE_AMOUNT, 
              Constants.PROJECTILE_TIMER_DELAY, 
              Constants.PROJECTILE_MOVE_DIRECTIONS);           
        this.walls       = walls;           // connect parameters to properties
        this.enemyMaster = enemyMaster;        
        player           = new MediaPlayer();           // create media player
        player.playWAV(Constants.PROJECTILE_SOUND_FILE);    // play spawn sound
    }

    /** 
     * The actions that this game character performs 
     */
    @Override
    public void action() {
        move();
        checkWalls();
        enemyMaster.check(this);
        redraw();
    }

    /** 
     * Checks for collisions with walls and reacts 
     */
    private void checkWalls() {
        for (int i = 0; i < walls.length; i++) {
            if (isColliding(walls[i])) {
                hide();
                shutDown();
                return;
            }
        }
    }

    /**
     * Shuts down the game character and all related timers and media players
     */
    public void shutDown() {
        super.shutDown();
        player.stop();
    }
    
}
