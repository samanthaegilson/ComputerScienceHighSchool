/** required package class namespace */
package cs40s.unitproblems.unit0problem5;

/**
 * Unit0Problem5.java - This program gets the user to input a number between 1 
 * and 3. If the user guesses the same number as the computer, they get a point,
 * if they guess a different number, then they lose a point. When the user runs
 * out of points, the program ends.
 *
 * @author Samantha Egilson
 * @since Sep 20, 2023
 */
public class Unit0Problem5 {

    static final String TITLE = "Guess a Number Game";
    
    /**
     * Main method for the project
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final int LOW = 1;
        final int HIGH = 3;
        Tools.start(TITLE);
        boolean keepPlaying = true;
        ScoreKeeper scoreKeeper = new ScoreKeeper();
        do{
            int computerNumber = Tools.random(LOW, HIGH);
            int playerNumber = Tools.inputInteger(
                    "Pick a number between 1 and 3:", TITLE);
            boolean inRange = Tools.inRange(playerNumber, LOW,
                    HIGH);
            while (inRange == false) {
                playerNumber = Tools.inputInteger("Error, number not inside " +
                        "range\n\nPick a number between 1 and 3:", TITLE);
                inRange = Tools.inRange(playerNumber, LOW, HIGH);
            }
            int score = scoreKeeper.getScore();
            if (playerNumber == computerNumber) {
                score = scoreKeeper.increase();
                Tools.output("You picked " + playerNumber +
                        "\nThe computer picked " + computerNumber +
                        "\nYou win!" + 
                        "\nYou have " + score + " points!", TITLE);    
            }
            else {
                score = scoreKeeper.decrease();
                Tools.output("You picked " + playerNumber +
                        "\nThe computer picked " + computerNumber +
                        "\nYou lose!" + 
                        "\nYou have " + score + " points!", TITLE);
            }
            keepPlaying = scoreKeeper.stillPlaying();
        } while (keepPlaying == true);
        Tools.output("Sorry, you are out of points!", TITLE);
        Tools.end(TITLE);    
    }

}
