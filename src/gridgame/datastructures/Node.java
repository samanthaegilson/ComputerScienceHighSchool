
package gridgame.datastructures;


/**
 * Node.java - node object for LinkedList ADT
 * @author Mr. Wachs' Computer Science Student
 * @since 16/03/2013
 * @version 1.0
 */
public class Node 
{
    
    /**
     * the data stored by the node
     */
    public Record data;
    /**
     * a reference to the next node object
     */
    public Node next;
    /**
     * a reference to the previous node object
     */
    public Node previous;
    
    /**
     * default constructor for the class
     */
    public Node() {
        this(null,null,null);
    }
    
    /**
     * constructor that uses the passes record object
     * @param record the String object to use
     */
    public Node(Record data) {
        this(data,null,null);
    }
    
    /**
     * constructor that uses the passes data object, and a
     * reference to the next node
     * @param data the String object to use
     * @param next the next node object to connect to
     */
    public Node(Record data, Node next) {
        this(data,next,null);
    }
    
    /**
     * constructor that uses the passes data object, a
     * reference to the next node, and the previous node
     * @param data the String object to use
     * @param next the next node object to connect to
     * @param previous the previous node to connect to
     */
    public Node(Record data, Node next, Node previous) {
        this.data = data;
        this.next = next;
        this.previous = previous;
    }

    /**
     * destroys the node object's contents 
     */
    public void destroy() {
        this.data   = null;
        this.next     = null;
        this.previous = null;
    }
    
    /**
     * a string representation of the node object
     * @return string representation of the node
     */
    @Override
    public String toString() {
        return data.toString();
    }
    
    /**
     * creates and returns an exact duplicate object to the current object
     * @return exact duplicate of the current object
     */
    @Override
    public Node clone() {
        Record record = this.data.clone();
        Node node = new Node(record,null,null);
        return node;
    }
       
}
