
package gridgame.generaltools;

/**
 * RandomTools.java - various methods for generating random objects
 * @author Mr. Wachs' Computer Science Student
 * @since 16/03/2013
 * @version 1.0
 */
public class RandomTools 
{
        
    /**
     * generates a random string of characters for a string of the passed size
     * @param size the size of the string to make
     * @return a string of random characters
     */
    public static String randomString(int size) {
        String text = "";
        int randomSize = randomInteger(1,size);
        for (int i = 0; i < randomSize; i++) {
            text += randomChar(97,122);
        }
        return text;
    }

    /**
     * a random char within the range of the ascii values
     * @param low the lowest ascii value to chose from 
     * @param high the highest ascii value to chose from
     * @return the random char in the range
     */
    public static char randomChar(int low, int high) {
        int ascii = randomInteger(low,high);
        char letter = (char)ascii;
        return letter;
    }
    
    /**
     * generates a random integer inside a range
     * @param low the lowest range value to generate
     * @param high the highest range value to generate
     * @return a random integer inside a range
     */
    public static int randomInteger(int low, int high) {
        return Numbers.randomInteger(low,high);
    }
    
}
