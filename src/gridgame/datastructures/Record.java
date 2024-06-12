
package gridgame.datastructures;

/**
 * Record.java - record object for Node object
 * @author Mr. Wachs' Computer Science Student
 * @since 16/03/2013
 * @version 1.0
 */
public class Record 
{
    
    /**
     * String of the record's data
     */
    public String data;
    
    /**
     * index number for this record
     */
    public int index;
    
    /**
     * default constructor for the class
     */
    public Record() {
        this(null);
    }
    
    /**
     * constructor sets the parameter data to the class data
     * @param data String of data
     */
    public Record (String data) {
        dispose();
        this.data = data;
    }
    
    /**
     * String representation of this record object
     * @return String representation of the object
     */
    @Override
    public String toString() {
        return data;
    }
    
    /**
     * gives a clone (exact duplicate) of the current Record object
     * @return Record object clone of current Record
     */
    @Override
    public Record clone() {
        Record record = new Record();
        record.data = this.data;
        record.index = this.index;
        return record;
    }
    
    /**
     * compares the current Record object to the parameter Record object
     * @param record the Record object to compare to
     * @return integer value equal to 0 if the two objects are equal, 
     * a value > 0 if the parameter is greater than the current object,
     * a value < 0 if the parameter is less than the current object,
     */
    public int compareTo(Record record) {
        return this.toString().compareTo(record.toString());
    }
    
    /**
     * compares the current Record object to the parameter Record object to
     * see if they are equal or not
     * @param record the Record object to compare to
     * @return they are equal (true) or not (false)
     */
    public boolean equals(Record record) {
        return this.toString().equals(record.toString());
    }
    
    /**
     * disposes of the current object and all it's properties
     */
    public void dispose() {
        data = null;
        index = 0;
    }
    
}
