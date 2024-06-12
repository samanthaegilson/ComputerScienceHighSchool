
package gridgame.datastructures;

/**
 * LinkedList.java - ADT Linked List of Node objects
 * @author Mr. Wachs' Computer Science Student
 * @since 16/03/2013
 * @version 1.0
 */
public class LinkedList 
{

    private Node head;
    private Node tail;
    private int length;
    
    /**
     * default constructor for the class
     */
    public LinkedList() {
        head = null;
        tail = null;
        length = 0;
    }

    /**
     * constructor builds a LinkedList object from a string array
     * @param data the Record array to build the list from
     */
    public LinkedList(Record[] data) {
        this();
        for (int i = 0; i < data.length; i++) {
            add(data[i]);
        }
    }
    
    /**
     * constructor copies the parameter LinkedList into this object 
     * @param list the LinkedList object to copy from
     */
    public LinkedList(LinkedList list) {
        this();
        for (int i = 0; i < list.length(); i++) {
            Record record = list.get(i).data;
            add(record);
        }
    }
    
    /**
     * inserts the data into the LinkedList at the head
     * @param data the Record data to insert
     */
    public void insertHead(Record data) {
        if (data == null) return;
        Node node = new Node(data);
        if (isEmpty()) {
            head = node;
            tail = node;
        }
        else {
            head.previous = node;
            node.next = head;
            head = node;
        }        
        length++;
    }
    
    /**
     * inserts the data into the LinkedList at the tail
     * @param data the Record data to insert
     */
    public void insertTail(Record data) {
        if (data == null) return;
        Node node = new Node(data);
        if (isEmpty()) {
            head = node;
            tail = node;
        }
        else {
            tail.next = node;
            node.previous = tail;
            tail = node;
        }        
        length++;
    }
    
    /**
     * inserts the data into the LinkedList before the index parameter
     * @param data the Record data to insert
     * @param index the index number to insert before
     */
    public void insertBefore(Record data, int index) {
        if (!inRange(index))        return;
        else if (index == 0)        insertHead(data);
        else if (index == length-1) insertTail(data);
        else {
            Node node = new Node(data);
            Node current = get(index);
            Node before = current.previous;
            before.next = node;
            node.previous = before;
            current.previous = node;
            node.next = current;
            length++;
        }
    }
    
    /**
     * retrieves the data from the LinkedList after the index parameter 
     * @param index the index in the LinkedList
     * @return Record data of the data after the index
     */
    public Record after(int index) {
        if (inRange(index+1) == false) return null;
        else                           return get(index+1).data;
    }
    
    /**
     * retrieves the data from the LinkedList before the index parameter 
     * @param index the index in the LinkedList
     * @return Record data of the data before the index
     */
    public Record before(int index) {
        if (inRange(index-1) == false) return null;
        else                           return get(index-1).data;
    }
    
    /**
     * retrieves the data from the LinkedList at the tail of the list 
     * @return Record data at the tail
     */
    public Record last() {
        if (isEmpty()) return null;
        else           return tail.data;
    }
    
    /**
     * retrieves the data from the LinkedList at the head of the list 
     * @return Record data at the head
     */
    public Record first() {
        if (isEmpty()) return null;
        else           return head.data;
    }
    
    /**
     * the number of nodes in the list
     * @return the list length
     */
    public int size() {
        return length;
    }
        
    /**
     * adds a Record object to the end (tail) of the list
     * @param data the Record object to add
     */
    public void add(Record data) {
        insertTail(data);
    }
    
    /**
     * searches for the data parameter object and if found, deletes
     * it from the list
     * @param data the Record object to delete
     */
    public void delete(Record data) {
        if (isEmpty()) return;
        Node current = find(data);
        if (current == null) return;
        if (length == 1) {
            head = null;
            tail = null;
        }
        else {
            if (current == head) {
                head = current.next;
                current.next.previous = null;
            }
            else if (current == tail) {
                tail = current.previous;
                current.previous.next = null;
            }
            else {
                current.next.previous = current.previous;
                current.previous.next = current.next;
            }
            current.destroy();
        }
        length--;
    }

    /**
     * searches for the original Record object, and if found, replaces 
     * it with the new data object
     * @param original the original Record object
     * @param newRecord the new Record object
     */
    public void edit(Record original, Record newRecord) {
        Node current = find(original);
        if (current != null) current.data = newRecord;
    }

    /**
     * searches for a Record object and determines if it is in the list
     * @param data the Record object to search for
     * @return exists (true) or does not exist (false) in the list
     */
    public boolean exists(Record data) {
        Node current = find(data);
        if (current == null)  return false;
        else                  return true;
    }
       
    /**
     * the Record representation of the LinkedList object
     * @return string representation of the list
     */
    @Override
    public String toString() {
        String output = "";
        Node current = head;
        while (current != null) {
            output += current + "\n";
            current = current.next;
        }
        return output;
    }

    /**
     * turns the entire LinkedList object into an array of Records
     * @return Record[] representation of the entire LinkedList
     */
    public Record[] toArray() {
        Record[] array = new Record[length];
        for (int i = 0; i < array.length; i++) {
            Node node = get(i);
            array[i] = node.data;
        }
        return array;
    }
        
    /**
     * the number of Nodes in the list
     * @return the list length
     */
    public int length() {
        return length;
    }

    /**
     * retrieves a reference to the Node object at the passed index
     * @param index the list index to retrieve
     * @return a reference to the Node object at the index (or null)
     */
    public Node get(int index) {
        if (inRange(index)) {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current;
        }
        return null;
    }

    /**
     * destroys all Node objects in the list
     */
    public void destroy() {
        Node current = head;
        while (current != null) {
            Node active = current;
            current = current.next;
            if (active != null) active.destroy();
        }
        head = null;
        tail = null;
        length = 0;
    }
    
    /**
     * determines if the passed index is inside the range of the list
     * @param index the index to check
     * @return index is in range (true) or not (false)
     */
    private boolean inRange(int index) {
        if (index < 0)            return false;
        else if (index >= length) return false;
        else                      return true;
    }
    
        /**
     * determines of the list is empty or not
     * @return empty (true) or not (false)
     */
    private boolean isEmpty() {
        if (head == null || tail == null || length == 0) return true;
        else                                             return false;
    }

    /**
     * searches for the Record object in the list and returns
     * a reference to the Node object containing that data
     * @param data the Record object to search for
     * @return a reference to the Node object if found or null if not
     */
    private Node find(Record data) {
        Node current = head;
        while(current != null) {
            if (current.data.equals(data)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
    
    /**
     * creates and returns an exact duplicate object to the current object
     * @return exact duplicate of the current object
     */
    @Override
    public LinkedList clone() {
        if (isEmpty()) return null;
        LinkedList copy = new LinkedList();
        Node current = head;
        while (current != null) {
            Node node = current.clone();
            Record record = node.data;
            copy.add(record);
            current = current.next;
        }
        return copy;
    }
    
}
