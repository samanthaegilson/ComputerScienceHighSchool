
package gridgame.applicationstructures;

/**
 * required imports
 */
import gridgame.applicationconstants.MapConstants;
import gridgame.filemanagers.FileFormatter;
import FileManagers.FileHandler;
import javax.swing.JLabel;

/**
 * LargeMap.java - representation of a large map object
 * @author Mr. Wachs' Computer Science Student
 * @since 16/03/2013
 * @version 1.0
 */
public class LargeMap extends Map
{
 
    /**
     * constructor sets the large map to the passed images
     * @param mapImages 2D array of JLabel images
     */
    public LargeMap(JLabel[][] mapImages) {
        super(mapImages);
    }
    
    /**
     * load the map from the data file
     */
    public void loadMap() {
        String filename = new FileFormatter().getClassFileName(MapConstants.LARGE_MAP_FILE);
        
        System.out.println(filename);
        
        String[] mapData = FileHandler.open(filename);
        int rows    = Integer.parseInt(mapData[0]);
        int columns = Integer.parseInt(mapData[1]);
        int i = 2;
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                int type = Integer.parseInt(mapData[i]);
                super.setType(row,column,type);
                i++;
            }
        }
        super.drawMap();
    }
    
    /**
     * save the map data to the data file
     */
    public void saveMap() {
        int rows    = super.getRows();
        int columns = super.getColumns();
        int lines = (rows * columns) + 2;
        String[] mapData = new String[lines];
        mapData[0] = "" + rows;
        mapData[1] = "" + columns;
        int i = 2;
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                int type = super.getType(row,column);
                mapData[i] = "" + type;
                i++;
            }
        }
        String filename = new FileFormatter().getClassFileName(MapConstants.LARGE_MAP_FILE);
        FileHandler.save(mapData,filename);
    }
    
}
