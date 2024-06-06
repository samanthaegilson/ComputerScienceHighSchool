/** Required package class namespace */
package arraylists;

import java.util.ArrayList;


/*
 * ArrayLists - review for AP
 * 
 * @author Samantha Egilson
 * @since Apr 18, 2024
*/
public class ArrayLists
{

    /**
     * Main method for the project
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Create (declare) an ArrayList by importing the ArrayList
        // class from the core "java.util" API
        ArrayList<Integer> list = new ArrayList<>();
        
        System.out.println("...");
        
        int size = list.size();
        
        System.out.println("Method to get the size of the ArrayList...");
        
        System.out.println("...");
        
        System.out.println("size = " + size);
       
        System.out.println("...");
        
        System.out.print("Method to add values dynamically into the");
        System.out.print("ArrayList. Note that it will always append the ");
        System.out.println("item to the end of the ArrayList");
        
        System.out.println("...");
        
        System.out.println("size = " + size);
        
        //        
        boolean success = list.add(20);        
        System.out.println("Operation was " + success + " list = " + list.toString());
        
        //
        for (int i = 0; i < 5; i++) {
            int value = i * 10 + 30;
            success = list.add(value);
            System.out.println("Operation was " + success + " list = " + list.toString());
        }
        
        //
        
        list.add(3, 99);
        System.out.println(list.toString());
        list.add(0, 99);
        System.out.println(list.toString());
        list.add(list.size(), 99);
        System.out.println(list.toString());
        
        //
        System.out.println("Get 3 -> " + list.get(3));
        System.out.println("Get 0 -> " + list.get(0));
        System.out.println("Get list.size()-1 -> " + list.get(list.size()-1));
        
        //        
        System.out.println("Set(3,1) -> " + list.set(3, 1));
        System.out.println(list);
        System.out.println("Set(0,1) -> " + list.set(0, 1));
        System.out.println(list);
        System.out.println("Set(list.size()-1,1) -> " + list.set(list.size()-1, 1));
        System.out.println(list);
        
        //
        System.out.println("Remove 2 -> " + list.remove(2));
        System.out.println(list);
        System.out.println("Remove 0 -> " + list.remove(0));
        System.out.println(list);
        System.out.println("Remove list.size()-1 -> " + list.remove(list.size()-1));
        System.out.println(list);
        
        //
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        
        for (Integer integer : list) {
            System.out.println(integer.toString());
        }
        
        
        
    }

}
