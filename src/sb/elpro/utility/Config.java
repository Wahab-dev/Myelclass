/**
* This class draws .
* @author Wahab
* @version 1.2
*/

package sb.elpro.utility;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author Wahab
 *
 */
public class Config implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        System.setProperty("org.apache.el.parser.COERCE_TO_ZERO", "false");
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        // NOOP
    }

}