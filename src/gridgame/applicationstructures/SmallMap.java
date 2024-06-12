
package gridgame.applicationstructures;

/**
 * required imports
 */
import ApplicationConstants.MapConstants;
import javax.swing.JLabel;

/**
 * SmallMap.java - representation of a small map object
 * @author Mr. Wachs' Computer Science Student
 * @since 16/03/2013
 * @version 1.0
 */
public class SmallMap extends Map
{
    
    private LargeMap largerMap;
    private int      x;
    private int      y;    
    private int      rows;    
    private int      columns;      
    private int      width;
    private int      height;    
    
    /**
     * constructor sets the large map to the passed parameters
     * @param mapImages 2D array of JLabel images
     * @param largerMap the larger map to associate with
     * @param x the starting x coordinate for the small map
     * @param y the starting y coordinate for the small map
     */
    public SmallMap(JLabel[][] mapImages, LargeMap largerMap, 
            int x, int y) {
        super(mapImages);
        this.x = x;
        this.y = y;
        this.rows = super.getRows();
        this.columns = super.getColumns();
        this.width  = mapImages[0].length;
        this.height = mapImages.length;
        this.largerMap = largerMap;
        largerMap.loadMap();
        readMap();
    }
    
    /**
     * reads the large map data from the current coordinates (x,y) and
     * renders it onto this small map
     */
    private void readMap() {
        int currentRow = y;
        int currentColumn = x;        
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                int type = largerMap.getType(currentRow,currentColumn);
                super.setType(row,column,type);
                currentColumn++;
            }
            currentColumn = x;
            currentRow++;
        }
        this.drawMap();
    }
    
    /**
     * moves the small map up as associated with the large map and
     * checks the bounds of the large map
     * @return whether it moved (true) or not (false)
     */
    public boolean moveUp() {
        y -= MapConstants.SMALL_MAP_MOVE_AMOUNT;
        if (checkBounds()) {
            readMap();
            return true;
        }
        else return false;
    }
    
    /**
     * moves the small map down as associated with the large map and
     * checks the bounds of the large map
     * @return whether it moved (true) or not (false)
     */
    public boolean moveDown() {
        y += MapConstants.SMALL_MAP_MOVE_AMOUNT;
        if (checkBounds()) {
            readMap();
            return true;
        }
        else return false;
    }

    /**
     * moves the small map left as associated with the large map and
     * checks the bounds of the large map
     * @return whether it moved (true) or not (false)
     */
    public boolean moveLeft() {
        x -= MapConstants.SMALL_MAP_MOVE_AMOUNT;
        if (checkBounds()) {
            readMap();
            return true;
        }
        else return false;
    }
    
    /**
     * moves the small map right as associated with the large map and
     * checks the bounds of the large map
     * @return whether it moved (true) or not (false)
     */
    public boolean moveRight() {
        x += MapConstants.SMALL_MAP_MOVE_AMOUNT;
        if (checkBounds()) {
            readMap();
            return true;
        }
        else return false;
    }
    
    /**
     * checks the small map movement with the bounds of the large
     * map to make sure the movement can occur
     * @return movement is possible (true) or not (false)
     */
    private boolean checkBounds() {
        int maxX = largerMap.getColumns(); 
        int maxY = largerMap.getRows();         
        if (x < 0) {
            x = 0;
            return false;
        }
        else if ((x+width) > maxX) {
            x = maxX-width;
            return false;
        }
        if (y < 0) {
            y = 0;
            return false;
        }
        else if ((y+height) > maxY) {
            y = maxY-height;
            return false;
        }        
        return true;
    }
    
    /**
     * gets the current x location (top left corner) 
     * @return x coordinate of this map
     */
    public int getX() {
        return x;
    }
    
    /**
     * gets the current y location (top left corner) 
     * @return y coordinate of this map
     */
    public int getY() {
        return y;
    }
    
}
