package utility;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class FWLogger {

	private static Logger Log = Logger.getLogger(FWLogger.class.getName());
	
	public static void initLogger() {
		PropertyConfigurator.configure("log4j.properties");
	}
	
	public static void startTestCase(String sTestCaseName) {
		
		
		Log.info("********************************************************************************************");
		Log.info("STARTED " + sTestCaseName + " ");
		
	}

	public static void endTestCase(String sTestCaseName) {
		Log.info("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX  -E-----N-----D-    XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		
	}

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
