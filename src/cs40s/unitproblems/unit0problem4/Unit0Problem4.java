/** Required package class namespace */
package cs40s.unitproblems.unit0problem4;

/**
 * Unit0Problem4.java - This program gives the user the choice of making a 
 * balloon, moving a balloon, popping a balloon or quitting the program. When 
 * you make a balloon, the user must choose a name and a color for the balloon.
 * 
 * @author Samantha Egilson
 * @since 14-Sep-2023
 */
public class Unit0Problem4 {

    static final String TITLE = "The Carnival";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        Tools.start(TITLE);         
        Balloon balloon = new Balloon();
        final String[] OPTIONS = {
            "Make a balloon",
            "Move your balloon",
            "Pop your balloon",
            "Quit"
        };
        String choice = " ";
        do{
            choice = Tools.inputDropDown("Welcome to the Carnival, "
                    + "what would you like to do?", OPTIONS, TITLE);
            if (choice.equals(OPTIONS[0])) {
                balloon.make();
            }
            else if (choice.equals(OPTIONS[1])) {
                balloon.move();
            }
            else if (choice.equals(OPTIONS[2])) {
                balloon.pop();
            }
        } while (choice.equals(OPTIONS[0]) || choice.equals(OPTIONS[1]) 
                || choice.equals(OPTIONS[2]));
        Tools.end(TITLE);                
    }
    
}
