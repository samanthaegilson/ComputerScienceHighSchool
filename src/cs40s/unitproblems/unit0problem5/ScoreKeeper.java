/** Required package class namespace */
package cs40s.unitproblems.unit0problem5;

/**
 * ScoreKeeper.java - This is a class to keep score for the player. It has as
 * encapsulated property for the score and methods for getting the score,
 * increasing the score, decreasing the score, and to check if the player's 
 * score has reached 0.
 * 
 * @author Samantha Egilson
 * @since Sep 20, 2023
 */
public class ScoreKeeper {
    
    private int score;
    
    /**
     * Constructor method to set the score
     */
    public ScoreKeeper() {
        //sets the starting score at the beginning of the game
        final int START_SCORE = 10;
        score = START_SCORE;
    }
    
    /**
     * Lets the program access the score
     * 
     * @return the player's score
     */
    public int getScore() {
        return score;
    }
    
    /**
     * Increases the score of the player
     * 
     * @return the new score
     */
    public int increase() {
        score++;
        return score;
    }
    
    /**
     * Decreases the score of the player
     * 
     * @return the new score
     */
    public int decrease() {
        score--;
        return score;
    }
    
    /**
     * Determines if the game should continue based on the player's score
     * 
     * @return if the game should continue (true) or not (false)
     */
    public boolean stillPlaying() {
        if (score > 0) {
            return true;
        }
        else {
            return false;
        }        
    }
    
}