/** Required package class namespace */
package cs40s.unitproblems.unit2;

 
/**
 * Order.java - enforcing "the rules" of an order.
 *
 * @author Samantha Egilson
 * @since Dec 4, 2023, 10:10:02 a.m.
 */
public abstract class Order 
{

    /**
     * Represents an order number
     */
    protected int orderNumber;
    
    /**
     * Mutator that sets the price of the pet
     * 
     * @param price the price of the pet
     */
    public abstract void setPrice(double price);
    
    /**
     * Accessor to retrieve the price of the pet
     * 
     * @return the price of the pet
     */
    public abstract double getPrice();
    
}