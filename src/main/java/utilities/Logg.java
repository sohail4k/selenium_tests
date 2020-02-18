package utilities;
import org.apache.log4j.Logger;

import utilities.Logg;

public class Logg {

	private static Logger log= Logger.getLogger(Logg.class.getName());
	
	public static void StartTestCase(String tc_name) {
		
		log.info("****************************************************************************************");
		 
		 log.info("****************************************************************************************");
		 
		 log.info("$$$$$$$$$$$$$$$$$$$$$                 "+tc_name+ "       $$$$$$$$$$$$$$$$$$$$$$$$$");
		 
		 log.info("****************************************************************************************");
		 
		 log.info("****************************************************************************************");
		 

	}
	
	public static void EndTestCase(String tc_name) {
		
		log.info("XXXXXXXXXXXXXXXXXXXXXXX             "+"-E---N---D-"+"             XXXXXXXXXXXXXXXXXXXXXX");

		log.info("X");

		log.info("X");

		log.info("X");

		log.info("X");

		}
	
	 public static void info(String message) {

			log.info(message);

			}
	 
	 public static void warn(String message) {

		    log.warn(message);

			}
	 public static void error(String message) {

		    log.error(message);

			}

		 public static void fatal(String message) {

		    log.fatal(message);

			}

		 public static void debug(String message) {

		    log.debug(message);

			}


	
}
