/** Required package class namespace */
package binarytrees;

 
/**
 * Tree.java - description
 *
 * @author Samantha Egilson
 * @since Apr 19, 2024, 11:27:42 a.m.
 */
public class Tree 
{

    private Node root;
    
    public Tree() {
        root = null;
    }
    
    public void insert(int data) {
        if (root == null) {
            root = new Node(data, null, null);
        }
        else root.insert(data);
    }
    
    public boolean search(int data) {
        if (root == null) {
            return false;
        }
        else {
            return recursiveSearch(data, root);
        }
    }

    private boolean recursiveSearch(int data, Node current) {
        if (current == null) {
            return false;
        }
        else if (data < current.data) {
            return recursiveSearch(data, current.left);
        }
        else if (data > current.data) {
            return recursiveSearch(data, current.right);
        }
        else {
            return true;
        }
    }
    
    public void traverse(String type) {
        if (type.equals("pre")) preOrder(root);
        else if (type.equals("post")) postOrder(root);
        else if (type.equals("in")) inOrder(root);
    }

    private void preOrder(Node current) {
        if (current != null) {
            System.out.print(current.data + " ");
            preOrder(current.left);
            preOrder(current.right);
        }        
    }
    
    private void postOrder(Node current) {
        if (current != null) {            
            postOrder(current.left);
            postOrder(current.right);
            System.out.print(current.data + " ");
        }  
        
    }

    private void inOrder(Node current) {
        if (current != null) {            
            inOrder(current.left);
            System.out.print(current.data + " ");
            inOrder(current.right);
        }  
    }
    
}