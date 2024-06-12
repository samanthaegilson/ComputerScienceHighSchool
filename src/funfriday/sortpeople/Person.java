/** Required package class namespace */
package funfriday.sortpeople;

 
/**
 * Person.java - description
 *
 * @author Samantha Egilson
 * @since Mar 21, 2024, 11:37:06 a.m.
 */
public class Person 
{

    public static boolean byName;
    
    public String name;
    public int age;
    
    /**
     * Default constructor, set class properties
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
         
    public int compareTo(Person that) {
        if (byName) {
            return this.name.compareTo(that.name);
        }
        else {
            if (this.age > that.age) return 1;
            if (this.age < that.age) return -1; 
        }        
        return 0;
    }
    
    public String toString() {
        return name + " " + age;
    }
    
    public Person clone() {
        return new Person(name, age);
    }
    
}