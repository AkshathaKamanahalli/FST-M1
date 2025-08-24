package project;

import java.util.HashMap;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class GitHubProjectTest {

	// SSH key to test with
	String sshkey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIIEnTrnp3iQewoDGBFMETBUoApvW5Ilv8gyeoBO/Ndai";
	// Temp variable to share id
	int keyId;
	// Declare the request and response specs

	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;

	@BeforeClass
	public void setUp() {
		// Initialize the request Specification
		requestSpec = new RequestSpecBuilder().setBaseUri("https://api.github.com/user/keys")
				.addHeader("Content-Type", "application/json")
				.addHeader("Authorization", "token")
				.addHeader("X-GitHub-Api-Version", "2022-11-28"). // this is custom header
				build();

		// Initialize the response Specification
		responseSpec = new ResponseSpecBuilder().expectBody("title", Matchers.equalTo("TestKeys"))
				.expectBody("key", Matchers.equalTo(sshkey)).expectResponseTime(Matchers.lessThanOrEqualTo(3000L))
				.build();

	}

	@Test(priority = 1)
	public void postRequest() {
		// Create Request Body
		HashMap<String, String> reqBody = new HashMap<String, String>();
		reqBody.put("title", "TestKeys");
		reqBody.put("key", sshkey);
		// send request , save response
		Response response = RestAssured.given().spec(requestSpec).body(reqBody).log().all().when().post();
		// Extract the Id from Response
		keyId = response.then().extract().path("id");
		// Assertions
		response.then().statusCode(201).spec(responseSpec).log().all();

	}

	@Test(priority = 2)
	public void getRequestTest() {
		// Send request, save response
		RestAssured.given().spec(requestSpec).pathParam("keyId", keyId).when().get("/{keyId}").then().statusCode(200)
				.spec(responseSpec);
	}

	@Test(priority = 3)
	public void getDeleteTest() {
		// Send request, save response
		RestAssured.given().spec(requestSpec).pathParam("keyId", keyId).when().delete("/{keyId}").then().statusCode(204)
				.time(Matchers.lessThanOrEqualTo(3000L));
	}

}
