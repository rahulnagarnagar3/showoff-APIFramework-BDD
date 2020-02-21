Feature: Add new user to the app

@CreateUser
Scenario Outline: Verify if User is being sucessfully added using CreateUserAPI
   Given Add User Payload with "<first_name>" "<email>"
   When user calls "CreateUserAPI" with "Post" http request
   Then the API call got success with status code 200
    And "message" in response body is "Success"
    
 Examples:
     |first_name | email               |
     |rahul      | rahultest1@gmail.com|
     |showTest   |showoff@gmail.com    |
     

 @ResetUserPassword 
  # Reset Password
 Scenario: Verify if User is able to ResetPassword using ResetPasswordAPI
   Given Add ResetPassword Payload 
   When user calls "ResetPasswordAPI" with "Post" http request
   Then the API call got success with status code 200
    And "message" in response body is "Password reset email sent to michael-61@showoff.ie. Please check your email address for further instructions."  