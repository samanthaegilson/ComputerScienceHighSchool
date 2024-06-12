
package gridgame.applicationstructures;

/**
 * required imports
 */
import javax.swing.JLabel;

/**
 * Map.java - representation of a general map object
 * @author Mr. Wachs' Computer Science Student
 * @since 16/03/2013
 * @version 1.0
 */
public class Map 
{
    
    private MapSquare[][] map;
    private int rows;
    private int columns;
    
    /**
     * constructor builds the map with the passed images
     * @param mapImages 2D array of JLabel images
     */
    public Map(JLabel[][] mapImages) {
        this.rows =  mapImages.length;
        this.columns = mapImages[0].length;
        this.map = new MapSquare[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                map[row][column] = new MapSquare(mapImages[row][column],row,column,this);
            }
        }
    }

    /**
     * sets the map square type using the parameters
     * @param row the row to set
     * @param column the column to set
     * @param type the map square type to set to
     */
    public void setType(int row, int column, int type) {
        map[row][column].type = type;
    }

    /**
     * renders the map square at the parameter's coordinates
     * @param row the row to render
     * @param column the column to render
     */
    public void drawMapSquare(int row, int column) {
        map[row][column].drawMapSquare();
    }
    
    /**
     * the number of rows in the map
     * @return the number of rows
     */
    public int getRows() {
        return rows;
    }

    /**
     * the number of columns in the map
     * @return the number of columns 
     */
    public int getColumns() {
        return columns;
    }

    /**
     * gets the map square type using the parameters
     * @param row the row to get
     * @param column the column to get
     * @return the map square type at the coordinates
     */
    public int getType(int row, int column) {
        return map[row][column].type;
    }
    
    /**
     * renders the entire map
     */
    public void drawMap() {
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                drawMapSquare(row,column);
            }
        }
    }
    
}
