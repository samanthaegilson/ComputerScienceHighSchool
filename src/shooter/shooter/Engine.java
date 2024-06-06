
/** required package class namespace */
package shooter;

/** required imports */
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import gametools.Image;
import java.io.File;
import javax.swing.ImageIcon;
import tools.FileHandler;
import tools.ImageTools;

/**
 * Engine.java - the logic connected to the user interface that runs game logic
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class Engine 
{

    private Hero        hero;
    private Goal        goal;
    private Wall[]      walls;
    private SurvivorUI  survivorUI;
    private EnemyMaster enemyMaster;
    private ImageTools  imageTool;
    
    /**
     * Constructor for the class sets class data to the parameters
     * 
     * @param heroLabel the label for the hero
     * @param goalLabel the label for the goal
     * @param wallLabels the labels for the walls
     * @param survivorUI the user interface for the game
     */
    public Engine(JLabel heroLabel, JLabel goalLabel, JLabel[] wallLabels, 
                  SurvivorUI survivorUI) {        
        this.survivorUI = survivorUI;   
        imageTool       = new ImageTools();
        imageTool.changeImage(heroLabel, Constants.HERO_IMAGE, true);
        imageTool.changeImage(goalLabel, Constants.GOAL_IMAGE, true);
        Image heroImage = new Image(heroLabel);
        Image goalImage = new Image(goalLabel);
        walls           = new Wall[wallLabels.length];
        for (int i = 0; i < walls.length; i++) {
            walls[i] = new Wall(new Image(wallLabels[i]));
        }
        goal        = new Goal(goalImage);
        hero        = new Hero(heroImage,walls,goal,survivorUI,this);        
        enemyMaster = new EnemyMaster(hero,goal,walls,survivorUI,this);        
        hero.connectTo(enemyMaster);   
        
        survivorUI.setTitle(Constants.SURVIVOR_UI_TITLE);
        survivorUI.setSize(Constants.SURVIVOR_UI_WIDTH, Constants.SURVIVOR_UI_HEIGHT);
        survivorUI.setResizable(false);
        survivorUI.setLocationRelativeTo(null);
        survivorUI.setBackground(Constants.SURVIVOR_UI_BACK_COLOR);
        survivorUI.getContentPane().setBackground(Constants.SURVIVOR_UI_BACK_COLOR);           
        FileHandler tool = new FileHandler(Constants.SURVIVOR_UI_ICON);
        File        file = tool.convertToFile(Constants.SURVIVOR_UI_ICON);
        String      path = file.getAbsolutePath();
        ImageIcon   icon = new ImageIcon(path);
        survivorUI.setIconImage(icon.getImage());        
        survivorUI.setVisible(true);
    }

    /**
     * Shut down the survivor game and all game characters and return
     * to main application menu
     */
    public void shutDown() {
        hero.shutDown();
        enemyMaster.shutDown();        
        survivorUI.dispose();
    }

    /**
     * Sends direction value on to the hero character
     * 
     * @param event the keyboard event 
     */
    public void keypress(KeyEvent event) {
        hero.keyPress(event);
    }

    /**
     * Create a new image for a created object
     * 
     * @param x the x coordinate to create the image in the container
     * @param y the y coordinate to create the image in the container
     * @param w the width coordinate to create the image in the container
     * @param h the height coordinate to create the image in the container
     * @param imageFile the file path to the image file
     * @return a image for a created object 
     */
    public Image createImage(int x, int y, int w, int h, String imageFile) {
        JLabel label = new JLabel();                // instantiate label
        survivorUI.getContentPane().add(label);     // add to container
        label.setSize(w, h);                        // set initial size
        imageTool.changeImage(label, imageFile, true);  // change image
        label.setBounds(x, y, w, h);                // position in container
        Image image = new Image(label);             // create image object
        return image;
    }
    
}
