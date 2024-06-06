/** Required package class namespace */
package files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


/*
 * Files - description
 * 
 * @author Samantha Egilson
 * @since Feb 15, 2024
*/
public class Files
{

    /**
     * Main method for the project
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // To do files, you also need to know about error handling 
        //(try catch block)
        
        try {
            //"tries" to run whatever code is in this block
            
            double number = 3/0;
            int[] a = {1,2,3};
            a[5] = 0;
        } 
        catch (ArithmeticException e) {
            // IF, an error occured in the block above try block, that error is
            // "caught" and code branches to here (instead of crash)
            System.out.println("Caught ArithmeticException error");
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException error");
        }
        
        // Now files...
        
        // HOW TO WRITE "data" TO A FILE...........
        
        String word = "Defenestration";
        
        // Now let's create a file NAME (properly)
        String first = "C:\\Users\\s.egilson\\Desktop\\temp\\";
        String middle = "text";
        String last = ".txt";
        
        String name = first + middle + last;
        
        try {            
            FileWriter writer = new FileWriter(name);
            PrintWriter printer = new PrintWriter(writer);            
            printer.print(word);
            printer.close();            
        } 
        catch (IOException e) {
            System.out.println("File error");
        }
        
        
        // HOW TO READ "data" TO A FILE...........
        
        String newWord = "";
        
        try {
            FileReader reader = new FileReader(name);
            BufferedReader buffer = new BufferedReader(reader);
            String line = buffer.readLine();
            buffer.close();
            newWord = line;
            System.out.println(newWord);
        } 
        catch (IOException e) {
            System.out.println("File error");
        }
        
    }

}
