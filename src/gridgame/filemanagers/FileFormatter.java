
package gridgame.filemanagers;

/**
 * required imports
 */
import java.io.File;
import java.net.URL;



/**
 * FileFormatter.java - class for formatting file names for use in class
 * references
 * @author Mr. Wachs' Computer Science Student
 * @since 16/03/2013
 * @version 1.0
 */
public class FileFormatter 
{

    /**
     * converts the standard file name to a class reference 
     * @param filename the file name to convert
     * @return string file name for use as a class reference
     */
    public String getClassFileName(String filename) {
        URL url = getClass().getResource(filename);
        File fileObject = new File(url.getPath());
        String filePath = fileObject.getAbsolutePath(); 
        return filePath;
//        return filename;
    }
    
}
