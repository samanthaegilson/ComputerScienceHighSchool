
package gridgame.applicationstructures;

/**
 * required imports
 */
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;

/**
 * MapSquare.java - represents a square on the map object
 * @author Mr. Wachs' Computer Science Student
 * @since 16/03/2013
 * @version 1.0
 */
public class MapSquare 
{
    
    public  JLabel image;
    public  int    type;
    
    private int    clickCount;
    private int    row;
    private int    column;
    private Map    map;

    /**
     * constructor sets the class to the parameters
     * @param image the JLabel image to use
     * @param row the row in the map for this object
     * @param column the column in the map for this object
     * @param map the map object this object is being added to
     */
    public MapSquare(JLabel image, int row, int column, Map map) {
        this.image = image;
        this.row = row;
        this.column = column;
        this.map = map;
        setProperties();
    }

    /**
     * renders this map square on the map
     */
    public void drawMapSquare() {
        Renderer.setMapImage(this,map);
    }

    /**
     * sets the JLabel properties for this map square
     */
    private void setProperties() {
        image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        image.setText("");
        image.setBorder(null);  
        image.setOpaque(true);
        type = 0;
        clickCount = 0; 
        setListener();              
    }
    
    /**
     * action for when the user clicks this map square
     */
    private void imageClick() {
        clickCount++;
        type = clickCount;
        if (clickCount == 3) clickCount = 0;
        drawMapSquare();
    }

    /**
     * sets the action listener for the mouse click for this object
     */
    private void setListener() {
        MouseListener listener = new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                imageClick();
            }
            public void mousePressed(MouseEvent e)  { }
            public void mouseReleased(MouseEvent e) { }
            public void mouseEntered(MouseEvent e)  { }
            public void mouseExited(MouseEvent e)   { }
        };
        image.addMouseListener(listener);
    }
    
}
