/** Required package class namespace */
package funfriday.virus;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

 
/**
 * Controller.java - description
 *
 * @author Samantha Egilson
 * @since Mar 1, 2024, 11:37:25 a.m.
 */
class Controller 
{    

    public void init(Virus virus) {
        virus.setLocationRelativeTo(null);
        virus.setResizable(false);
        
        
    }

    public void click() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.showOpenDialog(null);                
        File folder = chooser.getCurrentDirectory();        
        if (folder.isDirectory()) {
            try {
                String path = folder.getAbsolutePath();
                File file = new File(path);
                
                file.createNewFile();
                
                
            } catch (IOException ex) {
                System.out.println("Error");
            }
            
            
        }
        
        
    }
    
}