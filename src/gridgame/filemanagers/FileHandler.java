
package gridgame.filemanagers;

/**
 * required imports
 */
import GeneralTools.Dialogs;
import GeneralTools.ErrorHandler;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * FileHandler.java - useful set of methods for manipulating files
 * @author Mr. Wachs' Computer Science Student
 * @since 16/03/2013
 * @version 1.0
 */
public class FileHandler 
{

    /**
     * saves the String[] array to a file chosen by the user through
     * a dialog where each array index is a line in the file
     * @param data the String[] array to save
     */
    public static void save(String[] data) {
        String fileName = Dialogs.getFileName("save");
        save(data,fileName);        
    }
    
    /**
     * saves the String[] array to a file name passed to the method
     * where each array index is a line in the file
     * @param data the String[] array to save
     * @param fileName the file name to open
     */
    public static void save(String[] data, String filename) {
        if (data == null) return;
        try {
            if (filename == null) return;
            FileWriter writer = new FileWriter(filename);
            PrintWriter file  = new PrintWriter(writer);
            for (int i = 0; i < data.length; i++) {
                file.println(data[i]);
            }
            file.close();
        }
        catch(IOException error) {
            ErrorHandler.display("File Write error",filename,error);
        }        
    }   
    
    /**
     * opens a file after getting the file from the user through a dialog
     * and then returns all the lines from that file as a String[] array
     * @return String[] array of all lines from the chosen file
     */
    public static String[] open() {
        String fileName = Dialogs.getFileName("open");
        return open(fileName);
    }
    
    /**
     * opens a file name passed to the method and then returns 
     * all the lines from that file as a String[] array
     * @param fileName the file name to open
     * @return String[] array of all lines from the chosen file
     */
    public static String[] open(String filename) {
        try {
            if (filename == null) return null;
            int length = getLinesNumber(filename);
            String[] lines = new String[length];
            int i = 0;
            FileReader reader = new FileReader(filename);
            BufferedReader file  = new BufferedReader(reader);
            String line = file.readLine();
            while (line != null) {
                lines[i] = line;
                line = file.readLine();
                i++;
            }
            file.close();
            return lines;
        }
        catch(IOException error) {
            ErrorHandler.display("File Read error",filename,error);
            return null;
        }
    }
    
    /**
     * deletes the filename specified in the parameter from the file system
     * @param fileName the full pathname to the file to delete
     */
    public static void delete(String fileName) {
        if (fileName == null) return;
        File file = new File(fileName);
        if (file != null) file.delete();
    }

    /**
     * gets the number of lines in a file and returns as an integer
     * @param fileName the full pathname to the file
     * @return integer of the number of lines in the file
     */
    private static int getLinesNumber(String fileName) {
        if (fileName == null) return 0;
        try {
            FileReader reader = new FileReader(fileName);
            BufferedReader file = new BufferedReader(reader);
            int lineCount = 0;
            String line = file.readLine();
            while (line != null) {
                lineCount++;
                line = file.readLine();
            }
            file.close();
            return lineCount;
        }
        catch(IOException error) {
            ErrorHandler.display("File Read error",fileName,error);
            return 0;
        }
    }

}
