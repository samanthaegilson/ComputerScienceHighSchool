/** required package class namespace */
package castleprotect.tools;

import tools.Numbers;

 
/**
 * Text.java - a collection of useful methods for working with text
 *
 * @author Mr. Wachs
 * @since Nov. 25, 2019, 3:17:33 p.m.
 */
public class Text_1 
{
    
    // Encapsulated global class properties below..............................
    
    private static final char   ALPHA_LOW     = 'a';
    private static final char   ALPHA_HIGH    = 'z';
    private static final String ARRAY_START   = "[";
    private static final String ARRAY_DIVIDE  = ",";
    private static final String ARRAY_END     = "]";
    private static final String MATRIX_DIVIDE = "\t";
     
     
    /**
     * Generates a random character
     * 
     * @param low lowest character in the range
     * @param high highest character in the range
     * @return random character in range
     */
    public static char random(char low, char high) {
        return (char)(Numbers.random((int)low,(int)high));     
    }
        
    /**
     * Generate a random string of alphabetical characters
     * 
     * @param length the length of the string to generate
     * @param low lowest character in the range
     * @param high highest character in the range
     * @return a random string of characters
     */
    public static String random(int length, char low, char high) {
        String text = "";
        for (int i = 0; i < length; i++) {
            text += random(low, high);
        }
        return text;
    }
    
    /**
     * Generate a random string of alphabetical characters
     * 
     * @param length the length of the string to generate
     * @return a random string of characters
     */
    public static String random(int length) {
        return random(length, ALPHA_LOW, ALPHA_HIGH);
    }    
    
    /**
     * Generates an array of random characters in the range between low and high
     * 
     * @param low the lowest character in the range
     * @param high the highest character in the range
     * @param size the size to make the array
     * @return an array of random characters
     */
    public static char[] random(char low, char high, int size) {
        char[] numbers = new char[size];    // create empty array 
        for (int i = 0; i < size; i++) {    // traverse array size
            numbers[i] = random(low,high);  // assign random value to each index
        }
        return numbers;                     // return completed array
    }
    
    /**
     * Generates an array of random strings  of alphabetical characters
     * 
     * @param low the lowest character in the range
     * @param high the highest character in the range
     * @param length the length of the string to generate
     * @param size the size to make the array
     * @return an array of random strings
     */
    public static String[] random(char low, char high, int length, int size) {
        String[] strings = new String[size]; // create empty array 
        for (int i = 0; i < size; i++) {     // traverse array size
            strings[i] = random(length);     // assign random value to index
        }
        return strings;                      // return completed array
    }       
    
    /**
     * Generates a matrix of random characters in the range between low and high
     * 
     * @param rows the number of rows for the matrix
     * @param columns the number of columns for the matrix 
     * @param low the lowest number in the range
     * @param high the highest number in the range
     * @return a matrix of random characters
     */
    public static char[][] random(int rows, int columns, char low, char high) {
        char[][] matrix = new char[rows][columns];      // create empty matrix
        for (int row = 0; row < rows; row++) {          // traverse rows
            matrix[row] = random(low, high, columns);   // create random row
        }
        return matrix;                              // return completed matrix
    }
    
    /**
     * Generates a matrix of random characters in the range between low and high
     * 
     * @param rows the number of rows for the matrix
     * @param columns the number of columns for the matrix 
     * @param length the size to make the random string
     * @param low the lowest number in the range
     * @param high the highest number in the range
     * @return a matrix of random characters
     */
    public static String[][] random(int rows, int columns, int length, char low, 
            char high) {
        String[][] matrix = new String[rows][columns];  // create empty matrix
        for (int row = 0; row < rows; row++) {          // traverse rows
            matrix[row] = random(low, high, length, columns);   // create row
        }
        return matrix;                              // return completed matrix
    }
    
    /**
     * Formats the array into a string that could be outputted
     * 
     * @param array the array to format
     * @return a string of formatted text
     */
    public static String toString(int[] array) {
        String text = ARRAY_START;
        for (int i = 0; i < array.length-1; i++) {
            text += array[i] + ARRAY_DIVIDE;
        }
        return text + array[array.length-1] + ARRAY_END;
    }
    
    /**
     * Formats the array into a string that could be outputted
     * 
     * @param array the array to format
     * @return a string of formatted text
     */
    public static String toString(double[] array) {
        String text = ARRAY_START;
        for (int i = 0; i < array.length-1; i++) {
            text += array[i] + ARRAY_DIVIDE;
        }
        return text + array[array.length-1] + ARRAY_END;
    }
    
    /**
     * Formats the array into a string that could be outputted
     * 
     * @param array the array to format
     * @return a string of formatted text
     */
    public static String toString(char[] array) {
        String text = ARRAY_START;
        for (int i = 0; i < array.length-1; i++) {
            text += array[i] + ARRAY_DIVIDE;
        }
        return text + array[array.length-1] + ARRAY_END;
    }
    
    /**
     * Formats the array into a string that could be outputted
     * 
     * @param array the array to format
     * @return a string of formatted text
     */
    public static String toString(String[] array) {
        String text = ARRAY_START;
        for (int i = 0; i < array.length-1; i++) {
            text += array[i] + ARRAY_DIVIDE;
        }
        return text + array[array.length-1] + ARRAY_END;
    }
    
    /**
     * Formats the matrix into a string that could be outputted
     * 
     * @param matrix the matrix to format
     * @return a string of formatted text
     */
    public static String toString(int[][] matrix) {
        String text = "";
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                text += matrix[row][column] + MATRIX_DIVIDE;
            }
            text += "\n";
        }
        return text;
    }
    
    /**
     * Formats the matrix into a string that could be outputted
     * 
     * @param matrix the matrix to format
     * @return a string of formatted text
     */
    public static String toString(double[][] matrix) {
        String text = "";
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                text += matrix[row][column] + MATRIX_DIVIDE;
            }
            text += "\n";
        }
        return text;
    }
    
    /**
     * Formats the matrix into a string that could be outputted
     * 
     * @param matrix the matrix to format
     * @return a string of formatted text
     */
    public static String toString(char[][] matrix) {
        String text = "";
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                text += matrix[row][column] + MATRIX_DIVIDE;
            }
            text += "\n";
        }
        return text;
    }
    
    /**
     * Formats the matrix into a string that could be outputted
     * 
     * @param matrix the matrix to format
     * @return a string of formatted text
     */
    public static String toString(String[][] matrix) {
        String text = "";
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                text += matrix[row][column] + MATRIX_DIVIDE;
            }
            text += "\n";
        }
        return text;
    }
        
}
