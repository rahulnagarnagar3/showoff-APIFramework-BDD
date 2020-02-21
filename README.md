# showoff-APIFramework-BDD

Rahul Nagar -showoff.ie (Docs)

5 endpoints selected and tested implemented Cucumber -BDD framework in Java using MAVEN
BaseURL: https://showoff-rails-react-production.herokuapp.com

Tag	Module	Request (HTTP Method)	Endpoints
1.	Authentication	POST -Create token	https://showoff-rails-react-production.herokuapp.com/oauth/token
2.	Authentication	POST -Revoke token	https://showoff-rails-react-production.herokuapp.com/oauth/revoke
3.	Users->Widgets	POST-Create User	https://showoff-rails-react-production.herokuapp.com/api/v1/users
4.	Users->Widgets	GET-Check Email	
5.	Users->Widgets	POST-Reset Password	https://showoff-rails-react-production.herokuapp.com/api/v1/users/reset_password

API  Test Actions
Each test is comprised of test actions. These are the individual actions a test needs to take per API test flow. For each API request, the test would need to take the following actions: 
1. Verify correct HTTP status code. For example, creating a resource should return 201 CREATED and unpermitted requests should return 403 FORBIDDEN, etc.
2. Verify response payload. Check valid JSON body and correct field names, types, and values — including in error responses.
I have implemented Cucumber -Maven BDD framework in Java for testing, framework consists of 
1.	MAVEN project implemented- using pom.xml file
2.	Used RESTASSURED lib for http request & response
3.	Features file (Gherkins)
4.	Step Definitions file
5.	Enum class for passing method and constant endpoint in one java class
6.	Generated Payload for POST request and pass it into the body
7.	Generate Logging file which is used to refer any failure of script
8.	Define Hooks of the Cucumber to run the BeforeScenario test cases (Create user before getting user)
9.	POJO -Page Object Class define in which describes about the each JSON payload passing to the steps in the file
10.	Generate Excellent Cucumber Report for the API Testing (add plugin in Runner class)
11.	Cucumber-Junit used to run the test



Description of Endpoints
1.	POST : {BaseURL}/oauth/token
This endpoint is used to generate the token for the User by using user name, password , client id and secret key 
 Token Payload 
{
    "grant_type": "password",
    "client_id": "277ef29692f9a70d511415dc60592daf4cf2c6f6552d3e1b769924b2f2e2e6fe",
    "client_secret": "d6106f26e8ff5b749a606a1fba557f44eb3dca8f48596847770beb9b643ea352",
    "username": "michael-61@showoff.ie",
    "password": "password"
}

2.	POST: {BaseURL}/oauth/revoke
This endpoint is used to reveal the token by passing the generated token id from the above endpoint
 Revoke Payload
{
	"token":"42eaddaa5ce0d26bf2f29002fe87d64268188f5d86070901d9a7897478b91a0d"
}

3.	POST: {BaseURL}/api/v1/users
This endpoint is used to add new user to the application.

Create User Payload 
{
	"client_id": "277ef29692f9a70d511415dc60592daf4cf2c6f6552d3e1b769924b2f2e2e6fe",
	"client_secret": "d6106f26e8ff5b749a606a1fba557f44eb3dca8f48596847770beb9b643ea352",
	"user": {
		"first_name": "A",
		"last_name": "User",
		"password": "password",
		"email": "michael-61@showoff.ie",
		"image_url": "https://static.thenounproject.com/png/961-200.png"
	}
}

4.	GET: {BaseURL}/api/v1/users/email?email=test@showoff.ie&client_id=277ef29692f9a70d511415dc60592daf4cf2c6f6552d3e1b769924b2f2e2e6fe&client_secret=d6106f26e8ff5b749a606a1fba557f44eb3dca8f48596847770beb9b643ea352
                This endpoint is used to reveal the user by registered email  

5.	POST: {BaseURL}/api/v1/users/reset_password
This endpoint used to reset the password of the registered user only

Reset Payload

{
   "user" : {
       "email" : "michael-61@showoff.ie"
   },
   "client_id": "277ef29692f9a70d511415dc60592daf4cf2c6f6552d3e1b769924b2f2e2e6fe",
   "client_secret": "d6106f26e8ff5b749a606a1fba557f44eb3dca8f48596847770beb9b643ea352"
}
Request (HTTP Method)	Endpoints
POST/ oauth/token	Create a new token
POST / oauth/revoke	Revoke Create token
POST//api/v1/users	Create new user
GET/ api/v1/users/email?email={{email}}&client_id={{client_id}}&client_secret={{client_secret}}
	Get user by email
POST/ api/v1/users/reset_password	Reset Password for registered user

