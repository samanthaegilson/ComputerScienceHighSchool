/** Required package class namespace */
package binarytrees;

 
/**
 * Node.java - description
 *
 * @author Samantha Egilson
 * @since Apr 19, 2024, 11:27:27 a.m.
 */
public class Node 
{    
    
    public int data;    
    public Node left;
    public Node right;
    
    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;        
    }
    
    public Node() {
        this(0, null, null);
    }
    
    public String toString() {
        return String.valueOf(data);        
    }
    
    public void insert(int data) {
        if (data < this.data) {
            if (this.left == null) {
                this.left = new Node(data, null, null);
            }
            else {
                this.left.insert(data);
            }
        }
        else if (data > this.data) {
            if (this.right == null) {
                this.right = new Node(data, null, null);
            }
            else {
                this.right.insert(data);
            }
        }                
    }
    
    
}