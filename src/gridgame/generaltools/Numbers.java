
package gridgame.generaltools;

/**
 * Numbers.java - static methods for manipulating numbers
 * @author Mr. Wachs' Computer Science Student
 * @since 16/03/2013
 * @version 1.0
 */
public class Numbers 
{

    /**
     * gives a random integer in the range between the low and high
     * @param low the lowest possible random number
     * @param high the highest possible random number
     * @return the random number in the range
     */
    public static int randomInteger(int low, int high) {
        double seed   = Math.random();
        double L      = (double)low;
        double H      = (double)high;
        double random = (H - L + 1) * seed + L;
        return (int)random;
    }

    /**
     * determines if the passed text is a valid integer
     * @param text the string to check
     * @return is a valid integer (true) or not (false)
     */
    public static boolean isValidInteger(String text) {
        if (text == null) return false;
        if (text.equals("")) return false;
        for (int i = 0; i < text.length(); i++) {
            char value = text.charAt(i);
            if (Character.isDigit(value) == false) return false;
        }
        return true;
    }
    
    /**
     * finds the maximum value in the passed array
     * @param array the array to search through
     * @return the maximum value in the array 
     */
    public static int findMax(int[] array) {
        if (array == null) return -1;
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) max = array[i];
        }
        return max;
    }

    /**
     * finds the minimum value in the passed array
     * @param array the array to search through
     * @return the minimum value in the array 
     */
    public static int findMin(int[] array) {
        if (array == null) return -1;
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) min = array[i];
        }
        return min;
    }
    
}
