
/** required package class namespace */
package shooter.shooter;

/** required imports */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import shooter.gametools.GameObject;
import shooter.gametools.Image;

/**
 * SpawnPoint.java - represents the spawn point in the survivor game.
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class SpawnPoint extends GameObject
{

    private Hero        hero;
    private Wall[]      walls;
    private Engine      engine;
    private EnemyMaster enemyMaster;
    private Timer       spawnTimer;
    
    /**
     * Constructor for the class sets class data to the parameters
     * 
     * @param image the image associated with the game character
     * @param hero the hero object to associate with
     * @param walls the walls objects to associate with
     * @param engine the game engine to associate with 
     * @param enemyMaster the enemy master to associate with 
     */
    public SpawnPoint(Image image, Hero hero, Wall[] walls, Engine engine,
                      EnemyMaster enemyMaster) {
        super(image);        
        this.hero        = hero;                // set properties to parameters
        this.walls       = walls;
        this.engine      = engine; 
        this.enemyMaster = enemyMaster;
        spawnTimer       = new Timer(Constants.SPAWN_TIMER_DELAY, 
                               new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                spawnEnemy();
            }
        });
        spawnTimer.start();                     // start spawning timer
    }

    /**
     * Shuts down all enemies and the spawning timer
     */
    public void shutDown() {
        spawnTimer.stop();
    }
    
    /**
     * Spawns a new enemy at the spawn point
     */
    public void spawnEnemy() {
        if (isClear()) {            // location is clear to create a spawn spot
            Image enemyImage = engine.createImage(coordinate.x,coordinate.y,
                    coordinate.width,coordinate.height,Constants.ENEMY_IMAGE);
            Enemy enemy = new Enemy(enemyImage,hero,walls,engine,enemyMaster);
            enemyMaster.enemies.add(enemy);             // add new enemy to list
        }
    }

    /**
     * Determines if the spawn point enemy is clear of any enemies to spawn
     * a new enemy
     * 
     * @return the spawn area is clear (true) or not (false)
     */
    private boolean isClear() {
        if (enemyMaster.enemies == null) return true;   // no enemies to check
        for (int i = 0; i < enemyMaster.enemies.size(); i++) {  // traverse enemies
            Enemy enemy = enemyMaster.enemies.get(i);   // get an enemy
            if (enemy.isColliding(this)) {              // collision with enemy
                return false;                           // not clear
            }
        }
        return true;                                    // coast is clear
    }

}
