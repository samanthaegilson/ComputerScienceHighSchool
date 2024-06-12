
package gridgame.applicationstructures;

/**
 * required imports
 */
import ApplicationConstants.MapConstants;
import FileManagers.FileFormatter;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * Renderer.java - renders various graphics in the application
 * @author Mr. Wachs' Computer Science Student
 * @since 16/03/2013
 * @version 1.0
 */
public class Renderer 
{

    /**
     * sets the map quare image on the map object by changing the image
     * @param mapSquare the map square object to render
     * @param map the map to render the map square on
     */
    public static void setMapImage(MapSquare mapSquare, Map map) {
        Icon icon = null;
        String filename = null;
        if (map instanceof LargeMap) {
            if (mapSquare.type == MapConstants.WATER_ONLY_TYPE) {
                mapSquare.image.setBackground(Color.blue);
                filename = new FileFormatter().getClassFileName(MapConstants.LARGE_MAP_WATER_ONLY_IMAGE);
            }
            else if (mapSquare.type == MapConstants.GRASS_ONLY_TYPE) {
                mapSquare.image.setBackground(Color.green);
                filename = new FileFormatter().getClassFileName(MapConstants.LARGE_MAP_GRASS_ONLY_IMAGE);
            }
            else if (mapSquare.type == MapConstants.MOUNTAIN_ONLY_TYPE) {
                mapSquare.image.setBackground(Color.gray);
                filename = new FileFormatter().getClassFileName(MapConstants.LARGE_MAP_MOUNTAIN_ONLY_IMAGE);
            }
        }
        else if (map instanceof SmallMap) {
            if      (mapSquare.type == MapConstants.WATER_ONLY_TYPE) {
                mapSquare.image.setBackground(Color.magenta);
                filename = new FileFormatter().getClassFileName(MapConstants.SMALL_MAP_WATER_ONLY_IMAGE);
            }
            else if (mapSquare.type == MapConstants.GRASS_ONLY_TYPE) {
                mapSquare.image.setBackground(Color.orange);
                filename = new FileFormatter().getClassFileName(MapConstants.SMALL_MAP_GRASS_ONLY_IMAGE);
            }
            else if (mapSquare.type == MapConstants.MOUNTAIN_ONLY_TYPE) {
                mapSquare.image.setBackground(Color.darkGray);
                filename = new FileFormatter().getClassFileName(MapConstants.SMALL_MAP_MOUNTAIN_ONLY_IMAGE);
            }
        }
        else {
            mapSquare.image.setBackground(Color.yellow);
        }
        icon = new ImageIcon(filename);
        mapSquare.image.setIcon(icon);
//        mapSquare.image.setBorder(BorderFactory.createEtchedBorder());
        
    }
    
}
