package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import beans.UserBean;
import devConfig.dbLogin;

public class DBConnection {

	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	public boolean connectToSQLDatabase(String databaseName) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("Exception loading driver " + e.getMessage());
			return false;
		}

		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:8889/" + databaseName + "?serverTimezone=UTC", dbLogin.getUsername(),
					dbLogin.getPassword());
			return true;
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
			return false;
		}
	}

	private List<String> querySQLDatabase(String query, String... queryParameters) {
		ArrayList<String> queryResult = new ArrayList<>();
		try {
			prepareSQLstatement(query, queryParameters);

			resultSet = preparedStatement.executeQuery();

			ResultSetMetaData rsmd = resultSet.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			while (resultSet.next()) {
				for (int i = 1; i <= columnsNumber; i++) {
					String columnValue = resultSet.getString(i);
					queryResult.add(columnValue);
				}
			}

			connection.endRequest();
			connection.close();
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		}
		return queryResult;
	}
	
	private boolean querySQLDatabaseInsert(String query, String... queryParameters) {
		boolean isSuccessfullInsert = false;
		try {
			prepareSQLstatement(query, queryParameters);

			int executeReturn = preparedStatement.executeUpdate();
			
			if(executeReturn > 0) isSuccessfullInsert = true;

			connection.endRequest();
			connection.close();
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		}
		return isSuccessfullInsert;
	}
	
	private void prepareSQLstatement(String query, String[] queryParameters) {
		try {
			preparedStatement = connection.prepareStatement(query);

			int numberOfQueryParams = queryParameters.length;
			if (numberOfQueryParams > 0) {
				for (int i = 0; i < numberOfQueryParams; i++) {
					preparedStatement.setString(i + 1, queryParameters[i]);
				}
			}
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		}
	}

	public boolean validateUserLogin(UserBean userBean, String password) {
		String query = "SELECT Email, FullName FROM Users WHERE Username = ? AND Password = ?";
		List<String> queryResult = querySQLDatabase(query, userBean.getUserName(), password);

		if (queryResult.size() == 2) {
			userBean.setEmail(queryResult.get(0));
			userBean.setFullName(queryResult.get(1));
			return true;
		}
		return false;
	}
	
	public List<String> retrieveUserPostsFromSQLDatabase() {
		String query = "SELECT UserName, PostDate, PostValue, Tag from UserPost";
		List<String> queryResult = querySQLDatabase(query);
				
		return queryResult;
	}
	
	public List<String> retrieveLastUserPostsFromSQLDatabase() {
		String query = "SELECT UserName, PostDate, PostValue, Tag from UserPost WHERE TagId = ( SELECT MAX(TagId) FROM UserPost);";
		List<String> queryResult = querySQLDatabase(query);
				
		return queryResult;
	}
	
	

	public boolean insertIntoDb(String userName, String insertValue, String tag) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime now = LocalDateTime.now();
		String dateTime = dtf.format(now);
		String query = "INSERT INTO UserPost(UserName, PostDate, PostValue, Tag) VALUES(?, ?, ?, ?)";

		return querySQLDatabaseInsert(query, userName, dateTime, insertValue, tag);
	}
}
