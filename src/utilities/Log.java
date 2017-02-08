package utilities;

import org.apache.log4j.Logger;

public class Log {
	
	// Initialize Log4j logs
		private static Logger Log = Logger.getLogger(Logger.class.getName());	
	
	public static void startTest(String testCaseName){
		
		Log.info(" *********************  Begin test: " + testCaseName + " *********************  " );
				
	}
	
	public static void endTest(String testCaseName){
		
		Log.info("****************************************************************************************");
		Log.info("                             BEGINNING OF TEST:  " + testCaseName);
		
		Log.info("****************************************************************************************");
		Log.info(" ");
		
	}
	

	//This is to print log for the ending of the test case
 
 public static void endTestCase(String testCaseName){
 
	Log.info("                           "+"END OF TEST " +testCaseName + "             ");
    
	Log.info("X");
 
	Log.info("X");
 
	Log.info("X");
 
	Log.info("X");
 
	}
	// Need to create these methods, so that they can be called  
 
	public static void info(String message) {
	
		Log.info(message);	
			}
	
	public static void warn(String message) {
	
	  Log.warn(message);
	}
	
	public static void error(String message) {
	
	  Log.error(message);
	
		}
	
	public static void fatal(String message) {
	
	  Log.fatal(message);
	
		}
	
	public static void debug(String message) {
	
	  Log.debug(message);
	
		}
	

}
