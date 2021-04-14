package beans;

import java.util.List;

import model.UserPost;

import java.util.ArrayList;

public class PostBean {
	List<UserPost> userPost = new ArrayList<>();
	public static final PostBean instance = new PostBean();
	
	public PostBean() {}
	
	public void populateUserPost(List<String> queryResult) {
		while(queryResult.size() > 0) {
			UserPost post = new UserPost();
			
			post.setUsername(queryResult.get(0));
			queryResult.remove(0);
			post.setDate(queryResult.get(0));
			queryResult.remove(0);
			post.setPostValue(queryResult.get(0));
			queryResult.remove(0);
			post.setTag(queryResult.get(0));
			queryResult.remove(0);
			
			userPost.add(0, post);
		}
		
	}	
	
	public static PostBean getInstance() {
		return instance;
	}
	
	public List<UserPost> getUserPost(){
		return userPost;
	}
}
