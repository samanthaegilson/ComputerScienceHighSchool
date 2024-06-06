
/** required package class namespace */
package shooter.tools;

/**
 * Numbers.java - tools for working with numbers
 *
 * @author Mr. Wachs
 * @since May 28, 2018 
 * @instructor Mr. Wachs
 */
public class Numbers 
{
    
    /**
     * Generates a random integer in the range
     * 
     * @param low the lowest random integer to generate
     * @param high the highest random integer to generate
     * @return a random integer inside the range
     */
    public static int random(int low, int high) {
        double L      = (double)low;
        double H      = (double)high;
        double seed   = Math.random();
        double random = (H - L + 1d) * seed + L;
        return (int)random;
    } 
    
}
