/** Required package class namespace */
package cs40s.unitproblems.unit0problem4;

/**
 * Balloon.java - represents a balloon. This class has properties for the name,
 * color and direction of the balloon. It also has a constructor method and 4
 * other methods to make a balloon, move the balloon, pop the ballon and to show  
 * the properties of the balloon.
 * 
 * @author Samantha Egilson
 * @since 15-Sep-2023
 */
public class Balloon {
    
    static final String TITLE = "The Carnival"; 
    private  String  name;
    private  String  color;
    private  String  direction;
    
    /**
     * Constructor method to set the name to nothing and to set the direction
     * as up
     */
    public Balloon() {
        name = "";
        direction = "Up";
    }
    
    /**
     * Gives the user a choice for the direction of the balloon
     */
    public void move() {
        if (name.equals("")) {
            Tools.output("You must make a balloon first", TITLE);
            return;
        }
        final String[] OPTIONS = {
            "Up",
            "Down",
            "Left",
            "Right"
        };
        direction = Tools.inputDropDown("What direction would you like to move"
                + " your balloon?", OPTIONS, TITLE);
        show();
    }
    
    /**
     * Pops the balloon and resets the name
     */
    public void pop() {
        if (name.equals("")) {
            Tools.output("You must make a balloon first", TITLE);
            return;
        }
        Tools.output("Your balloon " + name + " has popped!", TITLE);
        name = "";
    }
    
    /**
     * Displays the properties of the balloon
     */
    private void show() {
        Tools.output("Balloon:  " + name 
                + "\nColor:    " + color 
                + "\nFloating: " + direction, TITLE);
    }
    
    /**
     * Displays an input box for the user to enter the balloon's name, and
     * gives the user a choice for the color of the balloon
     */
    public void make() {
        name = Tools.input(
            "Enter the name for your balloon:", TITLE);
        final String[] OPTIONS = {
            "Blue",
            "Red",
            "Green"
        };
        color = Tools.inputDropDown("Select a Balloon color:", OPTIONS, TITLE);
        direction = "Up";
        show();        
    }    
}
