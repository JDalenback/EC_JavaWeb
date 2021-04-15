package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DBConnection;

/**
 * Servlet implementation class UserPost
 */
@WebServlet("/UserPost")
public class UserPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserPostServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * If user manually tries to access the UserPostServlet:
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * Connect to DB.
		 * If Connection is not good redirect to dbError page.
		 * If connection is good, try to post query to db.
		 * If the query was not successful redirect to pstError page.
		 * If it was successful forward to /RetrieveUserPosts. 
		 */

		DBConnection dbConnection = new DBConnection();
		if (dbConnection.connectToSQLDatabase("BlankBook")) {
			String userName = request.getParameter("UserName");
			String userPost = request.getParameter("UserPost");
			String tag = request.getParameter("Tag");
			if (!dbConnection.insertIntoDb(userName, userPost, tag)) {
				response.sendRedirect("postError.jsp");
			}
			request.setAttribute("filter", "lastInsert");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/RetrieveUserPosts");
			requestDispatcher.forward(request, response);
		} else {
			response.sendRedirect("dbError.jsp");
		}
	}
}



