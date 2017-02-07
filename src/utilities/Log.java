package utilities;

import org.apache.log4j.Logger;

public class Log {
	
		private static Logger Log = Logger.getLogger(Logger.class.getName());	
	
	public static void startTest(String testCaseName){
		Log.info(" *********************  Begin test: " + testCaseName + " *********************  " );
				
	}
	
	public static void endTest(String testCaseName){
		
		Log.info(" ********************* End Test: " + testCaseName + " *********************  " );
		Log.info("###");
		Log.info("###");
		
	}
	
	public static void info(String message){
		Log.info(message);
		
	}
	
	public static void error(String message){
		
		Log.error(message);
	}
	
	public static void fault(String message){
		Log.error(message);
	}
	
	public static void debug(String message){
		Log.debug(message);
	}
	

}
