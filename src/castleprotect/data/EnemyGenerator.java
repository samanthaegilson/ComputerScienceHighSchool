/** Required package class namespace */
package castleprotect.data;

/**
 * Required API imports
 */
import castleprotect.clicker.CastleProtect;
import castleprotect.clicker.Defender;
import collections.LinkedList;
import castleprotect.gametools.Directions;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import tools.Numbers;

/**
 * EnemyGenerator.java - class to generate enemies on the user interface at
 * random times and in random locations
 *
 * @author Mr. Wachs
 * @since Jan 15, 2024, 9:13:19 a.m.
 */
public class EnemyGenerator {

    public static JPanel panel;                 // Associations with UI elements
    public static Hero hero;                  // Associations with Hero
    public static LinkedList<Enemy> enemies;   // List of all enemies
    public static Timer timer;     // Timer to spawn enemies
    private final static int MIN_DELAY = 100;   // Constants for timer
    private final static int MAX_DELAY = 1000;
    private final static int SIZE = 20;    // Constant for enemy size
    private static int trackCount = 0;          // For enemy tracking number
    public static CastleProtect castleProtect;

    /**
     * Starts up the enemy generator
     */
    public static void start() {
        enemies = new LinkedList<>();                       // Instantiate list
        timer = new Timer(MAX_DELAY, new ActionListener() { // Build Timer
            public void actionPerformed(ActionEvent e) {
                spawnEnemy();
            }
        });
        timer.start();                                      // Start timer
    }

    /**
     * Generates and spawns an enemy on screen
     */
    private static void spawnEnemy() {
        JLabel label = new JLabel();            // Instantiate Label object
        int x = Numbers.random(1, panel.getWidth() - SIZE - 1);    // Random x
        int y = Numbers.random(1, panel.getHeight() - SIZE - 1);    // and y
        int red = Numbers.random(0, 255);             // Random color values
        int green = Numbers.random(0, 255);
        int blue = Numbers.random(0, 255);
        Color color = new Color(red, green, blue);      // Assign color
        panel.add(label);                               // Add to panel
        label.setBounds(x, y, SIZE, SIZE);              // Position and size
        label.setOpaque(true);                          // Allow for backcolors
        label.setBackground(color);                     // Set color
        int direction = Directions.STOP;                // Initial direction
        Enemy enemy = new Enemy(label, direction, panel, hero);  // Create enemy
        trackCount++;                                   // Increase tracking
        enemy.trackingNumber = trackCount;              // number for this enemy
        enemies.add(enemy);                             // Add enemy to list
        int delay = Numbers.random(MIN_DELAY, MAX_DELAY);   // New random delay
        timer.setDelay(delay);                          // Assign to timer
    }

    /**
     * Removes an enemy from the user interface and removes it from the list
     *
     * @param enemy the enemy to remove
     */
    public static void remove(Enemy enemy) {
        if (enemy == null) {
            System.out.println("null enemy");
            return;
        }
        if (enemy.image == null) {
            System.out.println("null enemy image");
            return;
        }
        if (panel == null) {
            System.out.println("null panel");
            return;
        }

        panel.remove(enemy.image);                  // Remove label from UI 
        enemies.remove(enemy);                      // Remove from linked list
        enemy.despawn();                            // Destroy enemy 
        enemy.finalize();
    }

    /**
     * Checks if the enemy was hit by a defender's bullet
     * 
     * @param defender the defender that hit the enemy
     */
    public static void checkWithDefender(Defender defender) {
        if (enemies == null) {
            return;
        }
        for (int i = 0; i < enemies.size(); i++) {
            Enemy enemy = enemies.get(i);
            JLabel enemyLabel = enemy.image;
            for (int j = 0; j < defender.bullets.size(); j++) {
                JLabel bulletLabel = defender.bullets.get(i);
                if (bulletLabel == null) {
                    return;
                }
                Rectangle enemyHitbox = enemyLabel.getBounds();
                Rectangle bulletHitbox = bulletLabel.getBounds();
                if (enemyHitbox.intersects(bulletHitbox)) {
                    System.out.println("hit");
                    remove(enemy);
                }
            }
        }

    }

}
