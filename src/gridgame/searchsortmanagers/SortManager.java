
package gridgame.searchsortmanagers;

/**
 * SortManager.java - class for sorting generic collections
 * @author Mr. Wachs' Computer Science Student
 * @since 16/03/2013
 * @version 1.0
 */
public class SortManager 
{

    /**
     * bubble sort algorithm sorts the array
     * @param <T> Generic class type
     * @param array Generic array to sort
     */
    public static <T> void bubbleSort(T[] array) {
        for (int i = array.length-1; i >= 0; i--) {
            boolean sorted = true;
            for (int j = 0; j < i; j++) {
                if (compareTo(array,j,j+1) > 0) {
                    swap(array,j,j+1);
                    sorted = false;
                }
            }
            if (sorted) return;
        }
    }
    
    /**
     * swap algorithm on two array locations
     * @param <T> Generic class type
     * @param array Generic array to swap
     * @param x array location 1
     * @param y array location 2
     */
    private static <T> void swap(T[] array, int x, int y) {
        T temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
    
    /**
     * compares two array locations as string values
     * @param <T> Generic class type
     * @param array Generic array to compare
     * @param x array location 1 
     * @param y array location 2
     * @return integer value equal to 0 if values are equal,
     * value less than 0 if less than, and greater than 0
     * if greater than
     */
    private static <T> int compareTo(T[] array, int x, int y) {
        String a = array[x].toString();
        String b = array[y].toString();
        return a.compareTo(b);
    }

}
