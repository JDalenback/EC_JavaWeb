package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GettheWeather;
import model.weatherBean;

/**
 * Servlet implementation class OWservlet
 */
@WebServlet("/OWservlet")
public class OWservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OWservlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String cityStr = request.getParameter("city");
		String countryStr = request.getParameter("country");

		weatherBean wBean = weatherBean.getInstance();
		wBean.setCityStr(cityStr);
		wBean.setCountryStr(countryStr);

		GettheWeather.getWeather(wBean);

		request.setAttribute("wBean", wBean);
		
		RequestDispatcher rd = request.getRequestDispatcher("CookieServlet");
		rd.forward(request, response);

	}

}
