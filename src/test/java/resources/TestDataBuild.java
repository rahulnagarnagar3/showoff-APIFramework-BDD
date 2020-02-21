package resources;

import pojo.AddUser;
import pojo.GenerateToken;
import pojo.User;

public class TestDataBuild {
	AddUser user=new AddUser();
	User detailUser=new User();
	
	public AddUser addUserPayload(String first_name,String email)
	{		
		user.setClient_id("277ef29692f9a70d511415dc60592daf4cf2c6f6552d3e1b769924b2f2e2e6fe");
		user.setClient_secret("d6106f26e8ff5b749a606a1fba557f44eb3dca8f48596847770beb9b643ea352");
		detailUser.setFirst_name(first_name);
		detailUser.setLast_name("User");
		detailUser.setPassword("password");
		detailUser.setEmail(email);
		detailUser.setImage_url("https://static.thenounproject.com/png/961-200.png");
		
		return user;
	}
	
	public GenerateToken createTokenPayload(String username,String password)
	
	{
		GenerateToken token=new GenerateToken();
		token.setGrant_type("password");
		user.setClient_id("277ef29692f9a70d511415dc60592daf4cf2c6f6552d3e1b769924b2f2e2e6fe");
		user.setClient_secret("d6106f26e8ff5b749a606a1fba557f44eb3dca8f48596847770beb9b643ea352");
		token.setUsername(username);
		token.setPassword(password);
		
		return token;
		
	}

	public String revokeToken(String token)
	{
		return "{\r\n" + "	\"token\":\""+token+"\"\r\n" + "}";
	}

	public AddUser resetPassword(String email)
	{
		detailUser.setEmail(email);
		user.setClient_id("277ef29692f9a70d511415dc60592daf4cf2c6f6552d3e1b769924b2f2e2e6fe");
		user.setClient_secret("d6106f26e8ff5b749a606a1fba557f44eb3dca8f48596847770beb9b643ea352");
		
		return user;
		
	}
}
