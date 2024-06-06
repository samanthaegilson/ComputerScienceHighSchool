
/** required package class namespace */
package shooter.shooter;

/** required imports */
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import shooter.gametools.Directions;
import shooter.gametools.GameCharacter;
import shooter.gametools.Image;

/**
 * Hero.java - represents the hero of the survivor game
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class Hero extends GameCharacter
{
    
    private Wall[]                walls;
    private Goal                  goal;
    private Engine                engine;
    private EnemyMaster           enemyMaster;
    private SurvivorUI            survivorUI;    
    private ArrayList<Projectile> projectiles;

    
    /**
     * Constructor for the class sets class data to the parameters
     * 
     * @param image the image associated with the game character
     * @param walls the walls objects to associate with
     * @param goal the goal object to associate with
     * @param survivorUI the user interface to associate with
     * @param engine the game engine to associate with 
     */
    public Hero(Image image, Wall[] walls, Goal goal, SurvivorUI survivorUI, 
                Engine engine) {
        super(image, 
              Directions.STOP,
              Constants.HERO_MOVE_AMOUNT,
              Constants.HERO_TIMER_DELAY,
              Constants.HERO_MOVE_DIRECTIONS);
        this.walls      = walls;            // connect parameters to properties
        this.goal       = goal;
        this.engine     = engine;
        this.survivorUI = survivorUI;
        projectiles     = new ArrayList<>();    // create list
    }

    /** 
     * The actions that this game character performs 
     */
    @Override
    public void action() {
        move();
        checkWalls();
        checkGoal();
        redraw();
    }

    /** 
     * Checks for collisions with walls and reacts 
     */
    private void checkWalls() {
        for (int i = 0; i < walls.length; i++) {
            if (isColliding(walls[i])) {
                stickTo(walls[i]);
                return;
            }
        }
    }

    /** 
     * Checks for collisions with the goal and reacts 
     */
    private void checkGoal() {
        if (isColliding(goal)) {
            engine.shutDown();
        }
    }

    /**
     * Associates this object to the spawner object
     * 
     * @param enemyMaster the enemy master object to connect to
     */
    public void connectTo(EnemyMaster enemyMaster) {
        this.enemyMaster = enemyMaster;
    }
    
    /**
     * The user keyboard action to react to
     * 
     * @param event the keyboard event 
     */
    public void keyPress(KeyEvent event) {
        super.keyPress(event);
        if (event.getKeyCode() == KeyEvent.VK_SPACE) {
            int w = coordinate.width  / 2;
            int h = coordinate.height / 2;
            int x = coordinate.x + w / 2;
            int y = coordinate.y + h / 2;
            Image projectileImage = engine.createImage(x,y,w,h,
                    Constants.PROJECTILE_IMAGE);
            Projectile projectile = new Projectile(projectileImage,enemyMaster,
                                                   walls,coordinate.direction);
            projectiles.add(projectile);
        }
    }

    /**
     * Shuts down the game character and all related timers and media players
     */
    @Override
    public void shutDown() {
        super.shutDown();
        for (int i = 0; i < projectiles.size(); i++) {  // traverse projectiles
            Projectile projectile = projectiles.get(i); // get a projectile
            projectile.hide();                          // hide projectile
            projectile.shutDown();                      // shut down projectile
        }
        projectiles.clear();                            // clear list
    }
    
}
