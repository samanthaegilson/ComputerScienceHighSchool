
/** required package class namespace */
package shooter.tools;

import java.util.concurrent.TimeUnit;

/**
 * TimeTools.java - description here...
 *
 * @author Mr. Wachs (login: lawrence.wachs)
 * @since Jun 14, 2018 
 * @instructor Mr. Wachs
 */
public class TimeTools 
{

    public static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        }
        catch (InterruptedException ex) {

        }        
    }
    
    
}
