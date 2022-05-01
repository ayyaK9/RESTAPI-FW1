package basic.testcase;

import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

import utility.FWLogger;

public class SampleLoggingGenerator {

	@Test
	public void REST_TEST01(){
		PropertyConfigurator.configure("log4j.properties");
		FWLogger.startTestCase("REST_TEST01");
		FWLogger.info("Info level logs");
		FWLogger.info("Info level logs");
		FWLogger.info("Info level logs");
		FWLogger.info("Info level logs");
		FWLogger.info("Info level logs");
		FWLogger.endTestCase("REST_TEST01");
	}
	
	@Test
	public void REST_TEST02(){
		PropertyConfigurator.configure("log4j.properties");
		FWLogger.startTestCase("REST_TEST02");
		FWLogger.info("Info level logs");
		FWLogger.info("Info level logs");
		FWLogger.info("Info level logs");
		FWLogger.info("Info level logs");
		FWLogger.info("Info level logs");
		FWLogger.endTestCase("REST_TEST02");
	}
	
	
}
