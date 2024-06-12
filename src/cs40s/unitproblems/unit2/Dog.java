/** Required package class namespace */
package cs40s.unitproblems.unit2;

 
/**
 * Dog.java - A class that represents a dog.
 *
 * @author Samantha Egilson
 * @since Dec 4, 2023, 10:10:24 a.m.
 */
public class Dog implements Pet
{

    private String name;  
    private Sale sale;

    /**
     * Mutator that sets the name of the pet
     * 
     * @param name the name given to the pet
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Accessor to retrieve the name of the pet
     * 
     * @return the name of the pet
     */
    @Override
    public String getName() {
        return name;
    }
    
    /**
     * Sells a dog by creating a sale item
     * 
     * @param price the price of the dog
     * @param orderNumber the order number of the dog
     */
    public void sell(double price, int orderNumber) {
        sale = new Sale(sale, orderNumber);
        sale.setPrice(price);
    }
        

    /**
     * Outputs that the dog was sold and it's properties
     */
    @Override
    public void sold() {
        System.out.print("Order " + sale.orderNumber + " " + name +
                " is worth $" + sale.getPrice());
        
    }
    
}