package stepDefinitions;


import io.cucumber.java.en.Given;
import static org.junit.Assert.*;
import java.io.IOException;
import static io.restassured.RestAssured.given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class createUser extends Utils{
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
    TestDataBuild data=new TestDataBuild();
    static String email;
   	
    @Given("Add User Payload with {string} {string}")
	public void add_User_Payload(String first_name ,String email) throws IOException {
	    	
		res=given().spec(RequestSpecification()).body(data.addUserPayload(first_name,email));
		
	}

	@When("user calls {string} with {string} http request")
	public void user_calls_with_Post_http_request(String resource,String httpMethod) {
		
		APIResources resourceAPI=APIResources.valueOf(resource);
		
		resspec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		if(httpMethod.equalsIgnoreCase("POST"))
		response=res.when().post(resourceAPI.getResource());
		
		else if(httpMethod.equalsIgnoreCase("GET"))
			response=res.when().get(resourceAPI.getResource());
	}

	@Then("the API call got success with status code {int}")
	public void the_API_call_got_success_with_status_code(Integer int1) {
	    
		assertEquals(response.getStatusCode(),200);
		
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String ExpectedValue) {
	    assertEquals(getJsonPath(response, keyValue),ExpectedValue); 
		
	}
	
	//GET (Check Email) Request
	@Then("verify users email created with {string} using {string}")
	public void verify_users_email_created_with_using(String expectedEmail, String resource) throws IOException {
	  
		String actualEmail=getJsonPath(response,expectedEmail);
		res=given().spec(RequestSpecification()).queryParam("email", actualEmail)
				                                .queryParam("client_id", "277ef29692f9a70d511415dc60592daf4cf2c6f6552d3e1b769924b2f2e2e6fe")
				                                .queryParam("client_secret", "d6106f26e8ff5b749a606a1fba557f44eb3dca8f48596847770beb9b643ea352");
		user_calls_with_Post_http_request(resource, "GET");
		assertEquals(actualEmail,expectedEmail);
		
		
	}
		
// Reset Password
	
	@Given("Add ResetPassword Payload")
	public void add_ResetPassword_Payload(String email) throws IOException {
	    
		email=getJsonPath(response, email);
		res=given().spec(RequestSpecification()).body(data.resetPassword(email));
	}

}
