Feature: Create authentication token for the app

#Create Token
Scenario Outline: Verify if token is being sucessfully generated using CreateTokenAPI
   Given Add Token Payload with "<username>" "<password>"
   When user calls "CreateTokenAPI" with "Post" http request
   Then the API call got success with status code 200
    And "message" in response body is "Success"
    
 Examples:
     |username            | password  |
     |rahultest@showoff.ie| passowrd  |
 
# Revoke Token  
Scenario: Verify if token is being sucessfully revoked using RevokeTokenAPI
   Given Add Revoke Token Payload
   When user calls "RevokeTokenAPI" with "Post" http request
   Then the API call got success with status code 200
    And "message" in response body is "Token Successfully Revoked"
