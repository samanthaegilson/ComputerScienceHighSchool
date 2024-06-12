package cs40s.unitproblems.unit2;

/**
 * Pet.java - enforcing "the rules" of a pet.
 * 
 * @author s.egilson
 */
public interface Pet {
    
    /**
     * Mutator that sets the name of the pet
     * 
     * @param name the name given to the pet
     */
    void setName(String name);
    
    /**
     * Accessor to retrieve the name of the pet
     * 
     * @return the name of the pet
     */
    String getName();
    
    /**
     * The pet is sold
     */
    void sold();
}
