package resources;

public enum APIResources {
	
	CreateUserAPI("/api/v1/users"),
	CreateTokenAPI("/oauth/token"),
	getEmailAPI("/api/v1/users/email"),
	RevokeTokenAPI("/oauth/revoke"),
	ResetPasswordAPI("/api/v1/users/reset_password");
	
	private String resource;
	
	APIResources(String resource)
	{
		this.resource=resource;
	}
	
	public String getResource()
	{
		return resource;
	}

}
