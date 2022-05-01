package utility;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CommonUtilFunctions {
static JsonPath jsonPath;

 public static String getResponseKeyValue(String response_body, String response_key) {
	jsonPath = new JsonPath(response_body);
	 String value =jsonPath.get(response_key);
	return value;
}
 
 public static int getStatusCode(Response response_body) {
	FWLogger.initLogger();
	int status_code = response_body.getStatusCode();
	FWLogger.info("Request Response Status Code is - "+status_code);
	return status_code;
}
 
 public static String getStatusMessage(Response response_body) {
	 FWLogger.initLogger();
	String status_line = response_body.getStatusLine();
	FWLogger.info("Request Response Status message is - "+status_line);
	return status_line;
}
 

 public static String getResponseHeader(Response response_body,String header_key) {
	 FWLogger.initLogger();
	String response_header = response_body.getHeader(header_key);
	FWLogger.info("Request Response header for header key - "+header_key+" is - "+response_header);
	return response_header;
}
 
 public static String getResponseContentType(Response response_body) {
	 FWLogger.initLogger();
	String response_contentType = response_body.getContentType();
	FWLogger.info("Request Response content type is - "+response_contentType);
	return response_contentType;
}

 public static int getResponseExecutionTime(Response response_body) {
	 FWLogger.initLogger();
	int response_executionTime = (int) response_body.getTime();
	FWLogger.info("Request Response Execution Time is - "+response_executionTime);
	return response_executionTime;
}
 
}
