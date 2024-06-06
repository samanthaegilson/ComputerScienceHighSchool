
/** required package class namespace */
package shooter.shooter;

/** required imports */
import java.util.ArrayList;
import shooter.gametools.GameObject;
import shooter.gametools.Image;
import shooter.tools.MediaPlayer;
import shooter.tools.Numbers;

/**
 * EnemyMaster.java - the spawner logic in the survivor game.
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class EnemyMaster 
{
        
    private Hero                  hero;
    private Goal                  goal;
    private Wall[]                walls;
    private SurvivorUI            survivorUI;
    private Engine                engine;
    private MediaPlayer           player;
    
    /**
     * List of all spawn point objects the spawner tracks
     */
    public  ArrayList<SpawnPoint> allSpawnPoints;    
    
    /**
     * list of all enemies the spawner tracks
     */
    public  ArrayList<Enemy> enemies;
    
    /**
     * Constructor for the class sets class data to the parameters
     * 
     * @param hero the hero game character to associate with
     * @param goal the goal game object to associate with
     * @param walls the walls game objects to associate with
     * @param survivorUI the user interface to associate with
     * @param engine the game logic engine to associate with
     */
    public EnemyMaster(Hero hero, Goal goal, Wall[] walls, SurvivorUI survivorUI, 
                    Engine engine) {
        this.hero       = hero;         // connect parameters with properties
        this.goal       = goal;
        this.walls      = walls;
        this.survivorUI = survivorUI;
        this.engine     = engine;
        allSpawnPoints  = new ArrayList<>();    // create new lists
        enemies         = new ArrayList<>();
        player          = new MediaPlayer();    // create media player
        createSpawnPoint();                     // create initial spawn point
    }

    /**
     * Create a spawn point at a clear random location
     */
    private void createSpawnPoint() {
        int x = 0;                              // location variables
        int y = 0;
        int w = Constants.SPAWN_POINT_WIDTH;    // set dimensions
        int h = Constants.SPAWN_POINT_HEIGHT;
        do {                                    // start loop
            x = Numbers.random(Constants.SPAWN_LOW_X, Constants.SPAWN_HIGH_X);
            y = Numbers.random(Constants.SPAWN_LOW_Y, Constants.SPAWN_HIGH_Y);            
        } while (isClear(x, y, 
                         w + Constants.SPAWN_POINT_BUFFER, 
                         h + Constants.SPAWN_POINT_BUFFER) == false);                
        Image image = engine.createImage(x,y,w,h,Constants.SPAWN_POINT_IMAGE);
        SpawnPoint spawnPoint = new SpawnPoint(image,hero,walls,engine,this);
        allSpawnPoints.add(spawnPoint);        // add to list
    }
    
    /**
     * Shuts down and all related timers and media players
     */
    public void shutDown() {
        player.stop();
        for (int i = 0; i < enemies.size(); i++) {
            Enemy enemy = enemies.get(i);                   // get an enemy 
            enemy.hide();                                   // hide enemy
            enemy.shutDown();                               // shut down enemy
        }
        enemies.clear();                                    // clear list
        for (int i = 0; i < allSpawnPoints.size(); i++) {
            SpawnPoint spawnPoint = allSpawnPoints.get(i);  // get a spawn point 
            spawnPoint.hide();                              // hide spawn point 
            spawnPoint.shutDown();                      // shut down spawn point            
        }
        allSpawnPoints.clear();                             // clear list
    }

    /**
     * Checks to see if this projectile is hitting any spawn points or enemies
     * 
     * @param projectile the current projectile to check
     */
    public void check(Projectile projectile) {        
        checkSpawnPoints(projectile);            
        checkEnemies(projectile);
    }

    /**
     * Checks to see if this projectile is hitting any enemies
     * 
     * @param projectile the current projectile to check
     */
    private void checkEnemies(Projectile projectile) {
        for (int i = 0; i < enemies.size(); i++) {      // traverse enemies
            Enemy enemy = enemies.get(i);               // get en enemy
            if (projectile.isColliding(enemy)) {        // collision with enemy
                enemies.remove(enemy);                  // remove from list
                enemy.hide();                           // hide enemy
                enemy.shutDown();                       // shut down enemy
                projectile.hide();                      // hide projectile
                projectile.shutDown();                  // shut down projectile
                player.playWAV(Constants.ENEMY_DIE_SOUND_FILE); // play sound
                return;                                 // exit loop
            }
        }
    }

    /**
     * Checks to see if this projectile is hitting any spawn points
     * 
     * @param projectile the current projectile to check
     */
    private void checkSpawnPoints(Projectile projectile) {
        for (int i = 0; i < allSpawnPoints.size(); i++) {
            SpawnPoint spawnPoint = allSpawnPoints.get(i);  // get projectile
            if (projectile.isColliding(spawnPoint)) {   // collision
                allSpawnPoints.remove(spawnPoint);      // remove fromlist
                spawnPoint.hide();                      // hide spawn point
                spawnPoint.shutDown();                  // shut down spawn point
                projectile.hide();                      // hide projectile
                projectile.shutDown();                  // shut down projectile
                player.playWAV(Constants.ENEMY_DIE_SOUND_FILE); // play sound
                createSpawnPoint();                     // create 2 new
                createSpawnPoint();                     // spawn points
                return;                                 // exit loop
            }
        }
    }

    /**
     * Determines if the spawn point area is clear of any obstacles to spawn
     * a new spawn point here
     * 
     * @param x the x coordinate to check
     * @param y the y coordinate to check
     * @param width the width coordinate to check
     * @param height the height coordinate to check
     * @return the area is clear (true) or not (false)
     */
    private boolean isClear(int x, int y, int width, int height) {
        GameObject location = new GameObject(x,y,width,height);
        if (location.isColliding(hero)) return false;
        if (location.isColliding(goal)) return false;
        for (int i = 0; i < walls.length; i++) {
            if (location.isColliding(walls[i])) return false;        
        }
        for (int i = 0; i < enemies.size(); i++) {
            Enemy enemy = enemies.get(i);
            if (location.isColliding(enemy)) return false;        
        }
        return true;
    }

}
