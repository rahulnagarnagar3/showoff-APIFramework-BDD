package stepDefinitions;


import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@CreateUser")
	public void beforeScenario() throws IOException {
		
		createUser steps=new createUser();
		if(createUser.email==null)
		{
		steps.add_User_Payload("Rahul", "rahul123@gmail.com");
		steps.user_calls_with_Post_http_request("CreateUserAPI", "POST");
		steps.verify_users_email_created_with_using("rahul123@gmail.com", "getEmailAPI");
		
	}}

}
