package pojo;

public class AddUser {
	
	private String client_id;
	private String client_secret;
	private User user;
	
	//Getter and Setter Methods 
	
	//Client Id
	public String getClient_id() {
		return client_id;
	}
	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}
	
	//Client Secret
	public String getClient_secret() {
		return client_secret;
	}
	public void setClient_secret(String client_secret) {
		this.client_secret = client_secret;
	}
	
	//User Class
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
