
package gridgame.mainprogram;

/**
 * required imports
 */
import ApplicationConstants.GUIConstants;
import ApplicationConstants.KeyBoardConstants;
import ApplicationStructures.LargeMap;
import ApplicationStructures.SmallMap;
import GeneralTools.Dialogs;
import GeneralTools.FormTools;
import java.awt.Color;
import java.awt.List;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
                

/**
 * ProgramEngine.java - the program logic for this application
 * @author Mr. Wachs' Computer Science Student
 * @since 16/03/2013
 * @version 1.0
 */   
public class ProgramEngine 
{
    
    private JFrame gui;
    private JPanel largeMapPanel;
    private JPanel smallMapPanel;
    private JPanel statusPanel;
    private List   statusList;
    private JLabel[][] smallMapImages;
    private JLabel[][] largeMapImages;
    private LargeMap largeMap;
    private SmallMap smallMap;
    
            
    /**
     * default constructor for the class
     */
    public ProgramEngine(JFrame gui, JPanel largeMapPanel, 
            JPanel smallMapPanel, JPanel statusPanel, List statusList) {
        this.largeMapPanel = largeMapPanel;
        this.smallMapPanel = smallMapPanel;
        this.statusPanel = statusPanel;
        this.statusList = statusList;
        this.gui = gui;
        setLabels();
        setObjects();
        setGUI();
    }

    /**
     * the form is closing
     */
    public void closing() {
        Dialogs.exit(gui);
    }

    /**
     * user keyboard event action
     * @param event 
     */
    public void keyPress(KeyEvent event) {
        int code = event.getKeyCode();
        String status = "";        
        if (code == KeyBoardConstants.KEY_SAVE) {
            status = "Saving Map!";
            largeMap.saveMap();
        }
        else if (code == KeyBoardConstants.KEY_MOVE_UP) {
            status = "moving up to (x = " + smallMap.getX() + ", y = " +
                    smallMap.getY() + ")...";
            boolean result = smallMap.moveUp();
            if (!result) status = "cannot move up from (x,y) at: (" + 
                    smallMap.getX() + "," + smallMap.getY() + ")...";
        }
        else if (code == KeyBoardConstants.KEY_MOVE_DOWN) {
            status = "moving down to (x = " + smallMap.getX() + ", y = " +
                    smallMap.getY() + ")...";
            boolean result = smallMap.moveDown();
            if (!result) status = "cannot move down from (x,y) at: (" + 
                    smallMap.getX() + "," + smallMap.getY() + ")...";
        }
        else if (code == KeyBoardConstants.KEY_MOVE_LEFT) {
            status = "moving left to (x = " + smallMap.getX() + ", y = " +
                    smallMap.getY() + ")...";
            boolean result = smallMap.moveLeft();
            if (!result) status = "cannot move left from (x,y) at: (" + 
                    smallMap.getX() + "," + smallMap.getY() + ")...";
        }
        else if (code == KeyBoardConstants.KEY_MOVE_RIGHT) {
            status = "moving right to (x = " + smallMap.getX() + ", y = " +
                    smallMap.getY() + ")...";
            boolean result = smallMap.moveRight();
            if (!result) status = "cannot move right from (x,y) at: (" + 
                    smallMap.getX() + "," + smallMap.getY() + ")...";
        }
        else {
            status = "Key code = " + code;
        }
        updateStatus(status);
    }    
    
    /**
     * updates the status of the list box
     * @param text the text to add to the list box
     */
    private void updateStatus(String text) {
        int lastItem = statusList.getItemCount();
        statusList.add(text);
        statusList.select(lastItem);
        gui.requestFocus();
    }

    /**
     * sets up the large and the small JLable image matrices
     */
    private void setLabels() {
        smallMapImages = new JLabel[GUIConstants.SMALL_MAP_ROWS][GUIConstants.SMALL_MAP_COLUMNS];        
        int x = GUIConstants.SMALL_MAP_STARTING_X;
        int y = GUIConstants.SMALL_MAP_STARTING_Y;
        for (int i = 0; i < smallMapImages.length; i++) {
            for (int j = 0; j < smallMapImages[i].length; j++) {
                smallMapImages[i][j] = new JLabel();                
                smallMapPanel.add(smallMapImages[i][j]);
                smallMapImages[i][j].setBounds(x,y,GUIConstants.SMALL_MAP_TILE_WIDTH,GUIConstants.SMALL_MAP_TILE_HEIGHT);
                x += GUIConstants.SMALL_MAP_TILE_WIDTH + GUIConstants.SMALL_MAP_TILE_SPACE;
            }
            x = 10;
            y += GUIConstants.SMALL_MAP_TILE_HEIGHT + GUIConstants.SMALL_MAP_TILE_SPACE;
        }
        largeMapImages = new JLabel[GUIConstants.LARGE_MAP_ROWS][GUIConstants.LARGE_MAP_COLUMNS];
        x = GUIConstants.LARGE_MAP_STARTING_X;
        y = GUIConstants.LARGE_MAP_STARTING_Y;
        for (int i = 0; i < largeMapImages.length; i++) {
            for (int j = 0; j < largeMapImages[i].length; j++) {
                largeMapImages[i][j] = new JLabel();                
                largeMapPanel.add(largeMapImages[i][j]);
                largeMapImages[i][j].setBounds(x,y,GUIConstants.LARGE_MAP_TILE_WIDTH,GUIConstants.LARGE_MAP_TILE_HEIGHT);
                x += GUIConstants.LARGE_MAP_TILE_WIDTH + GUIConstants.LARGE_MAP_TILE_SPACE;
            }
            x = 10;
            y += GUIConstants.LARGE_MAP_TILE_HEIGHT + GUIConstants.LARGE_MAP_TILE_SPACE;
        }
    }
    
    /**
     * sets the class association objects
     */
    private void setObjects() {
        largeMap = new LargeMap(largeMapImages);
        smallMap = new SmallMap(smallMapImages,largeMap,
                GUIConstants.SMALL_MAP_POSITION_X,
                GUIConstants.SMALL_MAP_POSITION_Y);
    }

    /**
     * sets the look and feel of the gui
     */
    private void setGUI() {
        FormTools.startFormCenter(gui,GUIConstants.FORM_WIDTH,
                GUIConstants.FORM_HEIGHT, true, false, 
                GUIConstants.FORM_TITLE);
        this.largeMapPanel.setBackground(Color.white);
        this.smallMapPanel.setBackground(Color.white);
        this.statusPanel.setBackground(Color.white);        
        this.gui.setBackground(Color.white);
        this.gui.getContentPane().setBackground(Color.white);          
        this.gui.requestFocus();
    }

}
