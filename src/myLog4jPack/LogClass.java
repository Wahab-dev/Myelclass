/**
 * 
 */
package myLog4jPack;

import org.apache.log4j.Logger; 
/**
 * @author Wahab
 *
 */
public class LogClass {
	
	private static org.apache.log4j.Logger log = Logger.getLogger(LogClass.class);
	
	public static void main(String args[]){
		
		log.trace("bismillah..Trace");
		log.debug("Debug");
		log.info("Info");
		log.warn("Warn");
		log.error("Error");
		log.fatal("Fatal");
	}

}
