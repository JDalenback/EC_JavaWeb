package model;

public class UserPost {
	private String username = null;
	private String date = null;
	private String postValue = null;
	private String tag = null;
	
	public UserPost() {}
		
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPostValue() {
		return postValue;
	}

	public void setPostValue(String postValue) {
		this.postValue = postValue;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
}

