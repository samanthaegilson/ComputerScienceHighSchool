
/** required package class namespace */
package shooter.tools;

/** required imports */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * FileHandler.java - various methods for saving and opening files
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class FileHandler 
{

    private String filename;
    
    
    /**
     * Default constructor for the class, sets class properties
     * 
     * @param filename the filename to associate the class with 
     */
    public FileHandler(String filename) {
        this.filename = filename;
    }

    /**
     * Reads the data from the file and returns all the lines as a string array
     * 
     * @return a string array of all the lines from the file 
     */
    public String[] read() {
        try {
            File           file   = convertToFile(filename);
            FileReader     reader = new FileReader(file);
            BufferedReader buffer = new BufferedReader(reader);
            String         line   = buffer.readLine();
            if (line == null) return null;
            int            length = Integer.parseInt(line);
            String[]       lines  = new String[length-1];
            for (int i = 0; i < lines.length; i++) {
                lines[i]   = buffer.readLine();
            }
            buffer.close();
            return lines;
        }
        catch (IOException e) {
            System.out.println("I/O error");
        }
        catch (NullPointerException e) {
            System.out.println("Read Null error");
        }
        return null;
    }

    /**
     * Writes the passed data to the file
     * 
     * @param data string array to write to the file
     */
    public void write(String[] data) {
        try {
            File        file    = convertToFile(filename);
            FileWriter  writer  = new FileWriter(file);
            PrintWriter printer = new PrintWriter(writer);
            for (int i = 0; i < data.length; i++) {
                printer.println(data[i]);
            }
            printer.close();
        }
        catch (IOException e) {
            System.out.println("I/O error");
        }
        catch (NullPointerException e) {
            System.out.println("Write Null error");
        }
    }
    
    /**
     * Converts the file name string into a file object relative to the 
     * application package
     * 
     * @return a file object converted from the file name string 
     */
    public File convertToFile(String filename) {
        try {
            URL  url  = getClass().getResource(filename);
            URI  uri  = url.toURI();
            File file = new File(uri);
            if (!file.exists()) file.createNewFile();
            return file;
        }
        catch (URISyntaxException ex) {
            System.out.println("URI error");
        } 
        catch (IOException ex) {
            System.out.println("I/O error");
        }
        return null;
    }
    
}
