package devConfig;

/*
 * This is a class to  "hide" the database login.
 * Should not be included in any distribution.
 */
public class dbLogin {
	
	private static final String username = "root";
	private static final String password = "1337";
	
	public dbLogin() {}
	
	public static String getUsername() {
		return username;
	}
	
	public static String getPassword() {
		return password;
	}
}
