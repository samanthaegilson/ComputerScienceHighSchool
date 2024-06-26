package castleprotect.clicker;

import collections.LinkedList;
import castleprotect.data.EnemyGenerator;
import static castleprotect.data.EnemyGenerator.enemies;
import castleprotect.data.Hero;
import castleprotect.gametools.Directions;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 * CastleProtect.java - This program is a game in which the player has to buy
 * defenders in order to protect their castle. They must survive against
 * swarming enemies until the time runs out.
 *
 * @author Samantha Egilson
 * @since Dec 1, 2024
 */
public class CastleProtect extends javax.swing.JFrame {

    static final String TITLE = "Castle Protect";
    static final int COUNTDOWN = 1000; //1000 = 1 second
    static final int LEVEL_TIME = 62000;
    static final int COIN_TIME = 2000;
    final static int DELAY = 2;
    final static int CONVERSION = 1000;
    static int second = (LEVEL_TIME / CONVERSION) - DELAY;
    private static Timer coinTimer;
    private static Timer gameTimer;
    private static Timer levelTimer;
    public static int coins = 0;  
    private Hero hero;    

    static LinkedList<Defender> defenders;

    /**
     * Creates new form CastleProtect
     */
    public CastleProtect() {
        EnemyGenerator.castleProtect = this;        
        final int SPOT_LENGTH = 4;
        initComponents();
        hero = new Hero(castleLabel, gamePanel);          // Instantiate Hero
        EnemyGenerator.panel = gamePanel;        // Associate the enemy
        EnemyGenerator.hero = hero;             // generator with hero,
        this.setTitle(TITLE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        levelTimer = new Timer(LEVEL_TIME, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                winLevel();
            }
        });
        gameTimer = new Timer(COUNTDOWN, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timeLabel.setText("Time remaining: " + second);
                second--;
            }
        });
        coinTimer = new Timer(COIN_TIME, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                coins++;
                coinsLabel.setText("Coins: " + coins);
            }
        });

        for (int i = 1; i <= SPOT_LENGTH; i++) {
            spot.add("" + i);
        }

        defenders = new LinkedList<>();
        
        coinTimer.start();
        gameTimer.start();
        levelTimer.start();
        EnemyGenerator.start();                             // Start generator
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        coinsLabel = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        spot = new java.awt.Choice();
        buyButton = new javax.swing.JButton();
        quitButton = new javax.swing.JButton();
        healthBar = new javax.swing.JProgressBar();
        gamePanel = new javax.swing.JPanel();
        castleLabel = new javax.swing.JLabel();
        defender1 = new javax.swing.JLabel();
        defender2 = new javax.swing.JLabel();
        defender3 = new javax.swing.JLabel();
        defender4 = new javax.swing.JLabel();
        display1 = new javax.swing.JLabel();
        display2 = new javax.swing.JLabel();
        display3 = new javax.swing.JLabel();
        display4 = new javax.swing.JLabel();
        spotDescreption = new javax.swing.JLabel();
        spotInfo = new javax.swing.JLabel();
        information = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(java.awt.Color.green);
        setMinimumSize(new java.awt.Dimension(1735, 1100));
        setResizable(false);
        setSize(new java.awt.Dimension(1735, 1100));
        getContentPane().setLayout(null);

        coinsLabel.setFont(new java.awt.Font("Garamond", 0, 36)); // NOI18N
        coinsLabel.setText("Coins: 0");
        coinsLabel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                coinsLabelKeyPressed(evt);
            }
        });
        getContentPane().add(coinsLabel);
        coinsLabel.setBounds(20, 870, 310, 41);

        timeLabel.setFont(new java.awt.Font("Garamond", 0, 36)); // NOI18N
        timeLabel.setText("Time remaining:");
        getContentPane().add(timeLabel);
        timeLabel.setBounds(20, 0, 340, 41);

        spot.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(spot);
        spot.setBounds(750, 890, 170, 20);

        buyButton.setFont(new java.awt.Font("Garamond", 0, 24)); // NOI18N
        buyButton.setText("Buy Defender");
        buyButton.setAlignmentY(0.0F);
        buyButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buyButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyButtonActionPerformed(evt);
            }
        });
        getContentPane().add(buyButton);
        buyButton.setBounds(750, 920, 170, 40);

        quitButton.setFont(new java.awt.Font("Garamond", 0, 24)); // NOI18N
        quitButton.setText("Quit");
        quitButton.setAlignmentY(0.0F);
        quitButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        quitButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        quitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(quitButton);
        quitButton.setBounds(750, 970, 170, 30);

        healthBar.setForeground(new java.awt.Color(153, 0, 0));
        healthBar.setValue(100);
        healthBar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(healthBar);
        healthBar.setBounds(693, 10, 370, 30);

        gamePanel.setBackground(new java.awt.Color(102, 102, 0));
        gamePanel.setLayout(null);

        castleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        castleLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clicker/castle2.png"))); // NOI18N
        castleLabel.setAlignmentY(0.0F);
        castleLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                castleLabelMouseClicked(evt);
            }
        });
        gamePanel.add(castleLabel);
        castleLabel.setBounds(740, 250, 250, 260);

        defender1.setBackground(new java.awt.Color(51, 51, 0));
        defender1.setForeground(new java.awt.Color(51, 255, 51));
        defender1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        defender1.setAlignmentY(0.0F);
        defender1.setOpaque(true);
        gamePanel.add(defender1);
        defender1.setBounds(670, 190, 40, 40);

        defender2.setBackground(new java.awt.Color(51, 51, 0));
        defender2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        defender2.setAlignmentY(0.0F);
        defender2.setOpaque(true);
        gamePanel.add(defender2);
        defender2.setBounds(670, 530, 40, 40);

        defender3.setBackground(new java.awt.Color(51, 51, 0));
        defender3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        defender3.setAlignmentY(0.0F);
        defender3.setOpaque(true);
        gamePanel.add(defender3);
        defender3.setBounds(1010, 530, 40, 40);

        defender4.setBackground(new java.awt.Color(51, 51, 0));
        defender4.setForeground(new java.awt.Color(51, 255, 51));
        defender4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        defender4.setAlignmentY(0.0F);
        defender4.setOpaque(true);
        gamePanel.add(defender4);
        defender4.setBounds(1010, 190, 40, 40);

        getContentPane().add(gamePanel);
        gamePanel.setBounds(20, 50, 1680, 810);

        display1.setFont(new java.awt.Font("Garamond", 0, 18)); // NOI18N
        display1.setText("1");
        getContentPane().add(display1);
        display1.setBounds(990, 900, 8, 21);

        display2.setFont(new java.awt.Font("Garamond", 0, 18)); // NOI18N
        display2.setText("2");
        getContentPane().add(display2);
        display2.setBounds(990, 930, 8, 21);

        display3.setFont(new java.awt.Font("Garamond", 0, 18)); // NOI18N
        display3.setText("3");
        getContentPane().add(display3);
        display3.setBounds(1030, 930, 8, 21);

        display4.setFont(new java.awt.Font("Garamond", 0, 18)); // NOI18N
        display4.setText("4");
        getContentPane().add(display4);
        display4.setBounds(1030, 900, 8, 21);

        spotDescreption.setFont(new java.awt.Font("Garamond", 0, 18)); // NOI18N
        spotDescreption.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        spotDescreption.setText("Spot numbers:");
        getContentPane().add(spotDescreption);
        spotDescreption.setBounds(950, 860, 130, 40);

        spotInfo.setFont(new java.awt.Font("Garamond", 0, 18)); // NOI18N
        spotInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        spotInfo.setText("Spot:");
        getContentPane().add(spotInfo);
        spotInfo.setBounds(800, 870, 70, 20);

        information.setFont(new java.awt.Font("Garamond", 0, 18)); // NOI18N
        information.setText("Defender = 10 coins");
        information.setToolTipText("");
        information.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(information);
        information.setBounds(940, 960, 150, 21);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyButtonActionPerformed
        String spotChoice = spot.getSelectedItem();
        if (coins >= 10) {
            coins -= 10;
            coinsLabel.setText("Coins: " + coins);
            if (spotChoice.equals("1")) {
                defenders.add(new castleprotect.clicker.Defender(defender1, Directions.RIGHT,
                        gamePanel));
                defender1.setBackground(Color.white);
            } else if (spotChoice.equals("2")) {
                defenders.add(new castleprotect.clicker.Defender(defender2, Directions.UP,
                        gamePanel));
                defender2.setBackground(Color.white);
            } else if (spotChoice.equals("3")) {
                defenders.add(new castleprotect.clicker.Defender(defender3, Directions.LEFT,
                        gamePanel));
                defender3.setBackground(Color.white);
            } else {
                defenders.add(new castleprotect.clicker.Defender(defender4, Directions.DOWN,
                        gamePanel));
                defender4.setBackground(Color.white);
            }
            for (int i = 0; i < defenders.size(); i++) {
                if (!defenders.get(i).isActive) {
                    defenders.get(i).isActive = true;
                }
            }            
        } else {
            Tools.output("Not enough coins!", TITLE);
        }
    }//GEN-LAST:event_buyButtonActionPerformed

    private void quitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitButtonActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_quitButtonActionPerformed

    private void coinsLabelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_coinsLabelKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_coinsLabelKeyPressed

    private void castleLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_castleLabelMouseClicked
        // TODO add your handling code here:
        coins++;
        coinsLabel.setText("Coins: " + coins);
    }//GEN-LAST:event_castleLabelMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buyButton;
    private javax.swing.JLabel castleLabel;
    private javax.swing.JLabel coinsLabel;
    public javax.swing.JLabel defender1;
    public javax.swing.JLabel defender2;
    public javax.swing.JLabel defender3;
    public javax.swing.JLabel defender4;
    private javax.swing.JLabel display1;
    private javax.swing.JLabel display2;
    private javax.swing.JLabel display3;
    private javax.swing.JLabel display4;
    private javax.swing.JPanel gamePanel;
    public static javax.swing.JProgressBar healthBar;
    private javax.swing.JLabel information;
    private javax.swing.JButton quitButton;
    public java.awt.Choice spot;
    private javax.swing.JLabel spotDescreption;
    private javax.swing.JLabel spotInfo;
    private javax.swing.JLabel timeLabel;
    // End of variables declaration//GEN-END:variables

    /**
     * Stops all timers when the game time runs out and outputs a message box to
     * the user
     */
    private void winLevel() {
        gameTimer.stop();
        coinTimer.stop();
        EnemyGenerator.timer.stop();
        for (int i = 0; i < EnemyGenerator.enemies.size(); i++) {
            EnemyGenerator.remove(enemies.get(i));            
        }    
        Tools.output("Time's up!", TITLE);
        Tools.output("Congratulations, you survived!", TITLE);
        System.exit(0);
    }
    
    /**
     * Stops all timers when the player loses and exits the program
     */
    public static void gameOver() {        
        gameTimer.stop();
        coinTimer.stop();
        levelTimer.stop();
        EnemyGenerator.timer.stop();
        for (int i = 0; i < EnemyGenerator.enemies.size(); i++) {
            EnemyGenerator.remove(enemies.get(i));            
        }        
        Tools.output("You have died :(", TITLE);
        System.exit(0);
    }

}
