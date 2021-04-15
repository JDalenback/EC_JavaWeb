package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.PostBean;
import db.DBConnection;

/**
 * Servlet implementation class RetreiveUserPosts
 */
@WebServlet("/RetrieveUserPosts")
public class RetrieveUserPostsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetrieveUserPostsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * If user manually tries to access this servlet:
		 * Check if there is a valid session, if so redirect to main.jsp.
		 * Otherwise send back to index via LogoutServlet/Logout.
		 */
		if (request.getSession().getAttribute("user") != null) {
			response.sendRedirect("main.jsp");
		} else {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Logout");
			requestDispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DBConnection dbConnection = new DBConnection();
		HttpSession httpSession = request.getSession();
		
		// Used to in check to to see if we should retrieve all posts or just the last one.
		String filter = (String) request.getAttribute("filter");
		
		/*
		 * Make Connection to DB.
		 * If connection is not good send to dbError page.
		 * If it is send to main.jsp
		 * Else send to postError page.
		 */
		if (dbConnection.connectToSQLDatabase("BlankBook")) {
			List<String> queryResult;
			
			// Check if we want to get all posts or just the last based on the filter variable.
			if(filter != null && filter.equals("lastInsert")) {
				queryResult = dbConnection.retrieveLastUserPostsFromSQLDatabase();
			} else {
				queryResult = dbConnection.retrieveUserPostsFromSQLDatabase();
			}
			
			// If querySize has result.
			if (queryResult.size() > 0) {
							
				PostBean postBean = PostBean.getInstance();
				postBean.populateUserPost(queryResult);
				httpSession.setAttribute("postBean", postBean);
				
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("main.jsp");
				requestDispatcher.forward(request, response);
			} else {
				response.sendRedirect("postError.jsp");
			}
		} else {
			response.sendRedirect("dbError.jsp");
		}
	}

}
