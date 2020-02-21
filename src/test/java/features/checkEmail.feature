Feature: Check register user email

Scenario Outline: Verify if User is being sucessfully added using CreateUserAPI
   Given Add User Payload with "<first_name>" "<email>"
   When user calls "CreateUserAPI" with "Post" http request
   Then the API call got success with status code 200
    And "message" in response body is "Success"
    And verify users email created with "<email>" using "getEmailAPI"
    
        
 Examples:
     |first_name | email               |
     |rahul      | rahultest1@gmail.com|
    