package beans;

public class UserBean {

	private String username = null;
	private String fullName = null;
	private String email = null;
	
	public UserBean() {}
	
	public void resetUserBean(){
		username = null;
		fullName = null;
		email = null;
	}
	
	public String getUserName() {
		return username;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setUsername(String username) {
		this.username  = username;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
}
