package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserBean;
import db.DBConnection;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
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
		 * If user manually tries to access the LoginServlet:
		 * Check if there is a valid session, if so redirect to main.jsp.
		 * Otherwise send back to index via LogoutServlet/Logout.
		 */
		if(request.getSession().getAttribute("user") != null) {
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
		UserBean userBean = new UserBean();

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		userBean.setUsername(username);

		DBConnection dbConnection = new DBConnection();
		HttpSession httpSession = request.getSession();
		httpSession.setMaxInactiveInterval(600);
		
		// If there is a valid session skip login and go to main.jsp
		if(request.getSession().getAttribute("user") != null) {
			response.sendRedirect("main.jsp");
		}
		
		/*
		* Make Connection to DB.
		* If connection is not good send to dbError page.
		* If connection is good check if username and password mathches user in db.
		* If it does send to main.jsp
		* Else send back to index via LogoutServlet/Logout.
		 */
		if (dbConnection.connectToSQLDatabase("BlankBook")) {
			if (dbConnection.validateUserLogin(userBean, password)) {
				httpSession.setAttribute("user", userBean);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/RetrieveUserPosts");
				requestDispatcher.forward(request, response);
			} else {
				response.sendRedirect("index.jsp");
			}
		} else {
			response.sendRedirect("dbError.jsp");
		}
	}
}
