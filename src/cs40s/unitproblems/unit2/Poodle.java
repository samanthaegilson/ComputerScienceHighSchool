/** Required package class namespace */
package cs40s.unitproblems.unit2;

 
/**
 * Poodle.java - A class that represents a poodle.
 *
 * @author Samantha Egilson
 * @since Dec 4, 2023, 10:09:22 a.m.
 */
public class Poodle extends Dog
{

    private static int poodlesSold;    
    private final static double POODLE_PRICE = 99.99;
    
    /**
     * Constructor method to set the name and order number
     * 
     * @param name the name of the poodle
     * @param orderNumber the order number of the poodle
     */
    public Poodle(String name, int orderNumber) {
        poodlesSold++;
        sell(POODLE_PRICE, orderNumber);
        setName(name);
        sold();
    }
        
    /**
     * Outputs that the poodle was sold and it's properties
     */
    @Override
    public void sold() {
        super.sold();
        System.out.println(" and we have sold " + poodlesSold + " poodles");
    }
    
}