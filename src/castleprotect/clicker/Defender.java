/** Required package class namespace */
package castleprotect.clicker;

import collections.LinkedList;
import castleprotect.data.Enemy;
import castleprotect.data.EnemyGenerator;
import static castleprotect.data.EnemyGenerator.remove;
import castleprotect.gametools.Directions;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Defender.java - A class for the 4 defenders that surround the castle. This
 * class creates bullets for the defenders to fire and sets the direction that
 * the bullets will fire.
 *
 * @author Samantha Egilson
 * @since Jan 22, 2024, 3:45:21 p.m.
 */
public class Defender {

    private final int SIZE = 10;
    private JLabel defenderLabel;
    private int fireDirection;
    private JPanel panel;
    public LinkedList<JLabel> bullets;
    public static Timer timerMove;
    public static Timer timerSpawn;
    private final int AMOUNT = 10;
    private final int DELAY = 100;
    private final int SPAWN_DELAY = 750;
    public boolean isActive = false;

    /**
     * Default constructor, set class properties
     *
     * @param defenderLabel the label of the defender
     * @param fireDirection the direction the bullets will fire
     * @param panel the panel of the game
     */
    public Defender(JLabel defenderLabel, int fireDirection, JPanel panel) {
        this.defenderLabel = defenderLabel;
        this.fireDirection = fireDirection;
        this.panel = panel;
        bullets = new LinkedList<>();
        timerSpawn = new Timer(SPAWN_DELAY, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createBullet();
            }
        });
        timerSpawn.start();

        timerMove = new Timer(DELAY, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                moveAllBullets();
            }
        });
        timerMove.start();

    }

    /**
     * A method to fire bullets from the defenders. It creates bullets, moves
     * them and checks for enemies
     */
    void moveAllBullets() {
        if (bullets.isEmpty()) {
            return;
        }
        for (int i = 0; i < bullets.size(); i++) {
            JLabel bulletLabel = bullets.get(i);
            int x = bulletLabel.getX();
            int y = bulletLabel.getY();
            if (fireDirection == Directions.UP) {
                y -= AMOUNT;
            } else if (fireDirection == Directions.DOWN) {
                y += AMOUNT;
            } else if (fireDirection == Directions.LEFT) {
                x -= AMOUNT;
            } else if (fireDirection == Directions.RIGHT) {
                x += AMOUNT;
            }

            if (x < 0 || y < 0) {
                x = -100;
                y = -100;
            }
            if (x > EnemyGenerator.castleProtect.getWidth()
                    || y > EnemyGenerator.castleProtect.getHeight()) {
                x = -100;
                y = -100;
            }

            bulletLabel.setBounds(x, y, SIZE, SIZE);        // Position and size

            for (int j = 0; j < EnemyGenerator.enemies.size(); j++) {
                Enemy enemy = EnemyGenerator.enemies.get(j);
                JLabel enemyLabel = enemy.image;
                Rectangle enemyHitbox = enemyLabel.getBounds();
                Rectangle bulletHitbox = bulletLabel.getBounds();
                if (enemyHitbox.intersects(bulletHitbox)) {
                    remove(enemy);
                }
            }
        }
    }

    /**
     * Creates a bullet and sets it's direction
     */
    private void createBullet() {
        JLabel bulletLabel = new JLabel();          // Instantiate Label object
        int x = 0;
        int y = 0;
        if (fireDirection == Directions.UP) {
            x = defenderLabel.getX() + (defenderLabel.getWidth() / 2) - 
                    (SIZE / 2);
            y = defenderLabel.getY() - SIZE;
        } else if (fireDirection == Directions.DOWN) {
            x = defenderLabel.getX() + (defenderLabel.getWidth() / 2) - 
                    (SIZE / 2);
            y = defenderLabel.getY() + defenderLabel.getHeight();
        } else if (fireDirection == Directions.LEFT) {
            x = defenderLabel.getX() - SIZE;
            y = defenderLabel.getY() + (defenderLabel.getHeight() / 2) - 
                    (SIZE / 2);
        } else if (fireDirection == Directions.RIGHT) {
            x = defenderLabel.getX() + defenderLabel.getWidth();
            y = defenderLabel.getY() + (defenderLabel.getHeight() / 2) - 
                    (SIZE / 2);
        }
        panel.add(bulletLabel);                         // Add to panel
        bulletLabel.setBounds(x, y, SIZE, SIZE);        // Position and size
        bulletLabel.setOpaque(true);                    // Allow for backcolors
        bulletLabel.setBorder(BorderFactory.createEtchedBorder());
        bulletLabel.setBackground(Color.black);         // Set color
        bullets.add(bulletLabel);
    }

}
