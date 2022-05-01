package com.restapi.base;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utility.FWLogger;

public class BaseClass {

//Basic functions of Framework

	public static Response getRequest(String requestURI) {
		FWLogger.initLogger();
		FWLogger.info("Request URI is - "+requestURI);
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.get(requestURI);
		FWLogger.info("Response is - "+response.getBody().asString());
		return response;
	}

	public static Response putRequest(String requestURI, String requestPayLoad) {
		FWLogger.initLogger();
		FWLogger.info("Request URI is - "+requestURI);
		RequestSpecification requestSpecification = RestAssured.given().body(requestPayLoad);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.put(requestURI);
		FWLogger.info("Response is - "+response.getBody().asString());
		return response;
	}

	public static Response postRequest(String requestURI, String requestPayLoad) {
		FWLogger.initLogger();
		FWLogger.info("Request URI is - "+requestURI);
		RequestSpecification requestSpecification = RestAssured.given().body(requestPayLoad);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.post(requestURI);
		FWLogger.info("Response is - "+response.getBody().asString());
		return response;
	}

	public static Response postRequest(String requestURI, String requestPayLoad, String bearearToken) {
		FWLogger.initLogger();
		FWLogger.info("Request URI is - "+requestURI);
		RequestSpecification requestSpecification = RestAssured.given().body(requestPayLoad).header("Authorization",
				"Bearer " + bearearToken);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.post(requestURI);
		FWLogger.info("Response is - "+response.getBody().asString());
		return response;
	}

	public static Response deleteRequest(String requestURI) {
		FWLogger.initLogger();
		FWLogger.info("Request URI is - "+requestURI);
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.delete(requestURI);
		FWLogger.info("Response Status code is  - "+response.getStatusCode());
		return response;
	}
	
	public static Response deleteRequestWithBearerToken(String requestURI,String bearerToken) {
		FWLogger.initLogger();
		FWLogger.info("Request URI is - "+requestURI);
		RequestSpecification requestSpecification = RestAssured.given().header("Authorization",
				"Bearer " + bearerToken);;
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.delete(requestURI);
		FWLogger.info("Response Status code is  - "+response.getStatusCode());
		return response;
	}
	
	public static Response deleteRequest(String requestURI, String requestPayLoad) {
		FWLogger.initLogger();
		FWLogger.info("Request URI is - "+requestURI);
		RequestSpecification requestSpecification = RestAssured.given().body(requestPayLoad);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.delete(requestURI);
		FWLogger.info("Response Status code is  - "+response.getStatusCode());
		return response;
	}
}
