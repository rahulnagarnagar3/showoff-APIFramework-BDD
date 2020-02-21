package stepDefinitions;

import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.TestDataBuild;
import resources.Utils;
import static io.restassured.RestAssured.given;

import java.io.IOException;

public class createToken extends Utils{
	RequestSpecification res;
	Response response;
	TestDataBuild data=new TestDataBuild();
	static String token;
	
	@Given("Add Token Payload with {string} {string}")
	public void add_Token_Payload_with(String username, String password) throws IOException {
		
		res=given().spec(RequestSpecification()).body(data.createTokenPayload(username, password));
		    
	}
	
	@Given("Add Revoke Token Payload")
	public void add_Revoke_Token_Payload() throws IOException {
	    
		token=getJsonPath(response, token);
		res=given().spec(RequestSpecification()).header("Authorization","Bearer "+token)
				                                .body(data.revokeToken(token));
	}
	
	
}