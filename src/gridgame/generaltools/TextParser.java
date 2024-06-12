
package gridgame.generaltools;

/**
 * TextParser.java - various methods for parsing text
 * @author Mr. Wachs' Computer Science Student
 * @since 16/03/2013
 * @version 1.0
 */
public class TextParser 
{
    
    /**
     * retrieves a string from the passed parameter at the value indicated
     * in the parameter based on the parameter delimiter
     * @param data the String to parse from
     * @param wordNumber the number of the word to retrieve
     * @param delimiter the delimiter to use to parse the text
     * @return String of the word parsed out
     */
    public static String getWord(String data, int wordNumber, char delimiter) {
        int currentWord = 0;
        String value = "";
        for (int i = 0; i < data.length(); i++) {
            char letter = data.charAt(i);
            if (letter == delimiter) {
                currentWord++;
                if (currentWord == wordNumber) 
                    return value;
            }
            else {
                if (wordNumber - currentWord == 1) 
                    value += letter;
            }
        }
        return value;
    }
    
}
