package basic.testcase;

import java.io.IOException;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restapi.base.BaseClass;
import io.restassured.response.Response;
import resources.pojoclasses.CreateRepoPOJO;
import utility.Authn;
import utility.CommonUtilFunctions;
import utility.CreateURI;
import utility.PayloadGenerator;
import utility.FWLogger;

public class CreateGITRepoTest {

	String endPoint = CreateURI.getBaseURI("/user/repos");
	String bearer_Token = Authn.getBearearToken();
	Response res;
	ObjectMapper objectMapper;
	CreateRepoPOJO req_payLoadPojo;
	String req_payLoadJson;

	@Test
	public void createRepositryTestcase() throws IOException {
		PropertyConfigurator.configure("log4j.properties");
		FWLogger.startTestCase("TEST 1: createRepositryTestcase");

		req_payLoadJson = PayloadGenerator.generateStringPayload("creategitrepo.JSON");
		FWLogger.info("Request payload is " + req_payLoadJson);

		res = BaseClass.postRequest(endPoint, req_payLoadJson, bearer_Token);
		res.then().assertThat().statusCode(201);
		String resString = res.asString();
		FWLogger.info("request response");
		FWLogger.info(resString);

		Assert.assertEquals(CommonUtilFunctions.getResponseKeyValue(resString, "name"), "API-PostMan-Repo--909");
		Assert.assertEquals(CommonUtilFunctions.getResponseKeyValue(resString, "full_name"),
				"ayyaK9/API-PostMan-Repo--909");
		Assert.assertEquals(CommonUtilFunctions.getResponseKeyValue(resString, "owner.login"), "ayyaK9");
		FWLogger.endTestCase("createRepositryTestcase");
	}

	/**
	 * @throws JsonProcessingException
	 * @throws IOException
	 */
	@Test
	public void createRepositryTestcasePOJO() throws JsonProcessingException {
		PropertyConfigurator.configure("log4j.properties");
		FWLogger.startTestCase("TEST 2: createRepositryTestcasePOJO");

		req_payLoadPojo = new CreateRepoPOJO("POJO-repo", "POJO description");
		objectMapper = new ObjectMapper();
		String reqPayload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(req_payLoadPojo);
		res = BaseClass.postRequest(endPoint, reqPayload, bearer_Token);
		res.then().assertThat().statusCode(201);

		Assert.assertEquals(CommonUtilFunctions.getResponseKeyValue(res.asString(), "name"), "POJO-repo");
		FWLogger.endTestCase("createRepositryTestcasePOJO");
	}

	@Test
	public void deleteRepo() throws IOException {
		PropertyConfigurator.configure("log4j.properties");
		FWLogger.startTestCase("TEST 3: deleteRepo1");

		res = BaseClass.deleteRequestWithBearerToken(
				CreateURI.getBaseURI() + "/repos/ayyaK9/" + req_payLoadPojo.getName(), bearer_Token);
		
		Assert.assertEquals(CommonUtilFunctions.getStatusCode(res),204);
		FWLogger.endTestCase("deleteRepo");
	}

	@Test
	public void deleteRepo2() throws IOException {
		PropertyConfigurator.configure("log4j.properties");
		FWLogger.startTestCase("Test 4: deleteRepo2");

		res = BaseClass.deleteRequestWithBearerToken(CreateURI.getBaseURI() + "/repos/ayyaK9/"
				+ CommonUtilFunctions.getResponseKeyValue(req_payLoadJson, "name"), bearer_Token);
		Assert.assertEquals(CommonUtilFunctions.getStatusCode(res),204);
		FWLogger.endTestCase("deleteRepo");
	}
}
