/** Required package class namespace */
package funfriday.searching;

import java.util.ArrayList;


/*
 * Searching - description
 * 
 * @author Samantha Egilson
 * @since Feb 29, 2024
*/
public class Searching
{

    /**
     * Main method for the project
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Array of items to search through
        String[] array = {
            "Adam",
            "Chylsy",
            "Colton",
            "Foxx",
            "James",
            "Lanze",
            "Manskrit",
            "Miles",
            "Samantha",
            "Scott",            
            "Tyler",
            "Wachs"
        };
        // An item to search for
        String item = "Samantha";
        // Get the simple result of a search
        boolean result = search(array, item);
        
        // Display the result
        if(result) System.out.println("Found");
        else System.out.println("Not found");
        
        // Get a more detailed result of a search
        int index = linearSearch(array, item);
        
        // Display the result
        System.out.println(item + " was at " + index);
        
        
        // Now with a list structure(ADT)
        ArrayList<String> list = new ArrayList<>();        
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        
        index = linearSearch(list, item);
        System.out.println(item + " was at " + index);
        
        index = binarySearch(array,item);
        System.out.println("Binary Search: " + item + " was at " + index);
        
    }

    private static boolean search(String[] array, String item) {
        // Traverse (travel through, "visit" every spot, loop) the array
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(item)) {
                return true;
            }
        }
        // Go through the entire array, never found it
        return false;
    }

    private static int linearSearch(String[] array, String item) {
        // Traverse (travel through, "visit" every spot, loop) the array
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        // Go through the entire array, never found it
        return -1;

        // Alternative loop structure
//        int i = 0;
//        while (i < array.length) {
//            if (array[i].equals(item)) {
//                return i;
//            }
//        }
//        // Go through the entire array, never found it
//        return -1;
    }

    private static int linearSearch(ArrayList<String> list, String item) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(item)) return i;
        }
        return -1;
    }

    private static int binarySearch(String[] array, String item) {
        int low = 0;                    // Marker for the low end
        int high = array.length - 1;    // Marker for the high end
        while(low <= high) {            // continue while markers not collapsed                   
            int middle = (high + low) / 2; // Calculate middle between markers            
            if (array[middle].equals(item)) return middle; // found it      
            else if (array[middle].compareTo(item) > 0) high = middle - 1;
            else if (array[middle].compareTo(item) < 0) low = middle + 1;
        }
        return -1; // Not found
    }

    
    
}
