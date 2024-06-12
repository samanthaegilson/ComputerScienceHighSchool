
/** required package class namespace */
package shooter.shooter;

/** required imports */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import shooter.gametools.Directions;
import shooter.gametools.GameCharacter;
import shooter.gametools.Image;
import shooter.tools.MediaPlayer;
import shooter.tools.Numbers;

/**
 * Enemy.java - represents an enemy of the survivor game
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class Enemy extends GameCharacter
{
    
    private Wall[]      walls;
    private Hero        hero;
    private Engine      engine;
    private EnemyMaster enemyMaster;
    private MediaPlayer player;
    private Timer       tracker;
    
    /**
     * Tracking number to identify each enemy separately
     */
    public int number;

    
    /**
     * Constructor for the class sets class data to the parameters
     * 
     * @param image the image associated with the game character
     * @param hero the hero object to associate with
     * @param walls the walls objects to associate with
     * @param engine the game engine to associate with
     * @param enemyMaster the enemy master object to associate with
     */
    public Enemy(Image image, Hero hero, Wall[] walls, Engine engine, 
                 EnemyMaster enemyMaster) {
        super(image, 
              Directions.STOP,
              Constants.ENEMY_MOVE_AMOUNT,
              Constants.ENEMY_TIMER_DELAY,
              Constants.ENEMY_MOVE_DIRECTIONS);
        this.walls       = walls;           // connect parameters to properties
        this.hero        = hero;
        this.engine      = engine;
        this.enemyMaster = enemyMaster;        
        player           = new MediaPlayer();           // create media player
        number           = enemyMaster.enemies.size();  // assign number
        tracker          = new Timer(Constants.ENEMY_TRACKER_TIMER_DELAY, 
                            new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trackHero();
            }
        });
        tracker.start();                    // start hero tracking timer
        randomDirection();                  // start in a random direction
        player.playWAV(Constants.SPAWN_ENEMY_SOUND_FILE);   // play spawn sound
    }

    /** 
     * The actions that this game character performs 
     */
    @Override
    public void action() {
        move();        
        checkWalls();
        checkOtherEnemies();
        checkHero();
        redraw();
    }
    
    /** 
     * Checks for collisions with walls and reacts 
     */
    private void checkWalls() {
        for (int i = 0; i < walls.length; i++) {
            if (isColliding(walls[i])) {
                bounceOff(walls[i]);
                randomDirection();
                return;
            }
        }
    }

    /** 
     * Checks for collisions with the hero and reacts 
     */
    private void checkHero() {
        if (isColliding(hero)) {
            engine.shutDown();
        }
    }

    /** 
     * Checks for collisions with other enemies and reacts 
     */
    private void checkOtherEnemies() {
        if (enemyMaster.enemies == null) return;     // no enemies yet
        for (int i = 0; i < enemyMaster.enemies.size(); i++) {  // traverse
            Enemy enemy = enemyMaster.enemies.get(i);   // get an enemy
            if (enemy.equals(this) == false) {          // not hiting self
                if (isColliding(enemy)) {               // collision
                    bounceOff(enemy);
                    randomDirection();
                    return;
                }
            }
        }
    }
    
    /**
     * Checks to see if an enemy is equal to another enemy
     * 
     * @param enemy the enemy to check with
     * @return is the same enemy (true) or not (false)
     */
    public boolean equals(Enemy enemy) {
        if (this.number == enemy.number) return true;
        else                             return false;
    }

    /**
     * Tracks the hero on the vertical plane and moves toward the hero
     */
    private void trackHeroVertially() {
        if      (hero.isAbove(this)) coordinate.direction = Directions.UP;
        else if (hero.isBelow(this)) coordinate.direction = Directions.DOWN;
    }
    
    /**
     * Tracks the hero on the horizontal plane and moves toward the hero
     */
    private void trackHeroHorizontally() {
        if      (hero.isRightOf(this)) coordinate.direction = Directions.RIGHT;
        else if (hero.isLeftOf(this))  coordinate.direction = Directions.LEFT;
    }

    /**
     * Tracks the hero and randomly decides to track vertically or 
     * horizontally, then moves toward the hero
     */
    private void trackHero() {
        int chance = Numbers.random(1, 2);
        if      (chance == 1) trackHeroVertially();
        else if (chance == 2) trackHeroHorizontally();
    }
    
    /**
     * Shuts down the game character and all related timers and media players
     */
    @Override
    public void shutDown() {
        super.shutDown();
        player.stop();
    }

}
