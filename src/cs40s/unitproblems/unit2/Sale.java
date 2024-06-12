/** Required package class namespace */
package cs40s.unitproblems.unit2;

 
/**
 * Sale.java - A class that represents a sale.
 *
 * @author Samantha Egilson
 * @since Dec 4, 2023, 10:10:13 a.m.
 */
public class Sale <T> extends Order 
{

    private T saleItem;    
    private double price;
    
    /**
     * Constructor method to set the order number
     */
    public Sale(T saleItem, int orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * Mutator that sets the price of the pet
     * 
     * @param price the price of the pet
     */
    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Accessor to retrieve the price of the pet
     * 
     * @return the price of the pet
     */
    @Override
    public double getPrice() {
        return price;
    }
     
    /**
     * Accessor to retrieve the order number of the pet
     * 
     * @return the order number of the pet
     */
    public int getOrderNumber() {
        return orderNumber;
    }
    
}