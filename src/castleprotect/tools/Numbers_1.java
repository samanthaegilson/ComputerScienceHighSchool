/** required package class namespace */
package castleprotect.tools;

 
/**
 * Numbers.java - a collection of useful methods for working with numbers
 *
 * @author Mr. Wachs
 * @since Nov. 21, 2019, 3:49:35 p.m.
 */
public class Numbers_1 
{

    // Encapsulated global class properties below..............................
    
    private static final char   NEGATIVE = '-';
    private static final char   DECIMAL  = '.';
    
    /**
     * Checks the value to see if it contains numerical characters or a "-" 
     * or a "."
     * 
     * @param value the string of characters to check
     * @return is a number (true) or not (false)
     */
    public static boolean isDouble(String value) {
        char[] characters = value.toCharArray();
        for (int i = 0; i < characters.length; i++) {            
            if (Character.isDigit(characters[i]) == false) {
                if (characters[i] != DECIMAL && 
                    characters[i] != NEGATIVE) {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Checks the value to see if it contains numerical characters or a "-"
     * 
     * @param value the string of characters to check
     * @return is a number (true) or not (false)
     */
    public static boolean isInteger(String value) {
        char[] characters = value.toCharArray();
        for (int i = 0; i < characters.length; i++) {            
            if (Character.isDigit(characters[i]) == false) {
                if (characters[i] != NEGATIVE) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Determines if a number if odd or even
     * 
     * @param number the number to check
     * @return true (if even), false (if odd)
     */
    public static boolean isEven(int number) {
        if (number % 2 == 0) return true;
        else                 return false;
    }
    
    /**
     * Checks to make sure the number is in the range
     * 
     * @param number the number to check
     * @param low lowest in the range
     * @param high highest in the range
     * @return in range (true) or not (false)
     */
    public static boolean inRange(int number, int low, int high) {
        if (number >= low && number <= high) return true;
        return false;
    }
    
    /**
     * Checks to make sure the number is in the range
     * 
     * @param number the number to check
     * @param low lowest in the range
     * @param high highest in the range
     * @return in range (true) or not (false)
     */
    public static boolean inRange(double number, double low, double high) {
        if (number >= low && number <= high) return true;
        return false;
    }
    
    /**
     * Generate a random number in a range
     * 
     * @param low the lowest number in the range
     * @param high the highest number in the range
     * @return random number in the range
     */
    public static int random(int low, int high) {
        return (int)(random((double)low, (double)high));
    }
    
    /**
     * Generate a random number in a range
     * 
     * @param low the lowest number in the range
     * @param high the highest number in the range
     * @return random number in the range
     */
    public static double random(double low, double high) {
        return ((high - low + 1d) * Math.random() + low);
    }

    /**
     * Generates an array of random integers in the range between low and high
     * 
     * @param low the lowest number in the range
     * @param high the highest number in the range
     * @param size the size to make the array
     * @return an array of random integers
     */
    public static int[] random(int low, int high, int size) {
        int[] numbers = new int[size];      // create empty array of passed size
        for (int i = 0; i < size; i++) {    // traverse array size
            numbers[i] = random(low,high);  // assign random value to each index
        }
        return numbers;                     // return completed array
    }
    
    /**
     * Generates an array of random doubles in the range between low and high
     * 
     * @param low the lowest number in the range
     * @param high the highest number in the range
     * @param size the size to make the array
     * @return an array of random doubles
     */
    public static double[] random(double low, double high, int size) {
        double[] numbers = new double[size]; // create empty array 
        for (int i = 0; i < size; i++) {    // traverse array size
            numbers[i] = random(low,high);  // assign random value to each index
        }
        return numbers;                     // return completed array
    }
   
    /**
     * Generates a matrix of random integers in the range between low and high
     * 
     * @param rows the number of rows for the matrix
     * @param columns the number of columns for the matrix 
     * @param low the lowest number in the range
     * @param high the highest number in the range
     * @return a matrix of random integers
     */
    public static int[][] random(int rows, int columns, int low, int high) {
        int[][] matrix = new int[rows][columns];    // create empty matrix
        for (int row = 0; row < rows; row++) {      // traverse rows
            matrix[row] = random(low, high, columns);   // create random row
        }
        return matrix;                              // return completed matrix
    }
    
    /**
     * Generates a matrix of random doubles in the range between low and high
     * 
     * @param rows the number of rows for the matrix
     * @param columns the number of columns for the matrix 
     * @param low the lowest number in the range
     * @param high the highest number in the range
     * @return a matrix of random doubles
     */
    public static double[][] random(int rows, int columns, double low, 
            double high) {
        double[][] matrix = new double[rows][columns];    // create empty matrix
        for (int row = 0; row < rows; row++) {      // traverse rows
            matrix[row] = random(low, high, columns);   // create random row
        }
        return matrix;                              // return completed matrix
    }
    
}
