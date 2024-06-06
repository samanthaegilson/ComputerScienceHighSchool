/** Required package class namespace */
package binarytrees;


/*
 * BinaryTrees - description
 * 
 * @author Samantha Egilson
 * @since Apr 19, 2024
*/
public class BinaryTrees
{

    /**
     * Main method for the project
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(27);
        tree.insert(35);
        tree.insert(75);
        tree.insert(14);
        tree.insert(83);
        tree.insert(61);
        
        boolean result = tree.search(14);
        System.out.println("Results for 14 = " + result);
        result = tree.search(44);
        System.out.println("Results for 44 = " + result);
        System.out.println("\nPre-order: ");
        tree.traverse("pre");
        System.out.println("\nPost-order: ");
        tree.traverse("post");
        System.out.println("\nIn-order: ");
        tree.traverse("in");
        
        
    }

}
