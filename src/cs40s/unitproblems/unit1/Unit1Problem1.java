/** Required package class namespace */
package cs40s.unitproblems.unit1;


/*
 * Unit1Problem1 - This program runs the McCarthy 91 function for numbers 
 * from 0 to 300. If a number is over 100, it takes 10 from it and returns it. 
 * If the number is under 100, it will find the McCarthy of the McCarthy of the 
 * number plus 11, and return it.
 * 
 * @author Samantha Egilson
 * @since Sep 29, 2023
 */
public class Unit1Problem1 {

    /**
     * Main method for the project
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final int MIN = 0;
        final int MAX = 300;
        final int ADD = 20;
        for (int number = MIN; number <= MAX; number = number + ADD) {
            int answer = mcCarthy91(number);
            System.out.println("Number = " + number + "     McCarthey value = "
                    + answer);
        }
    }

    /**
     * Calculates the McCarthy version of a number using recursion.
     *
     * @param n the number inserted
     * @return the McCarthy version of the number
     */
    private static int mcCarthy91(int n) {
        if (n > 100) {
            return n - 10;
        }
        return mcCarthy91(mcCarthy91(n + 11));
    }

}
