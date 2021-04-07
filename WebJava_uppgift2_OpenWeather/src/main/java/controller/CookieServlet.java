package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.weatherBean;

/**
 * Servlet implementation class CookieServlet
 */
@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		weatherBean wBean = weatherBean.getInstance();
		String date = wBean.getDate();
		String city  = wBean.getCityStr();
		String country = wBean.getCountryStr().trim();
		String clouds = wBean.getCloudsStr().replaceAll(" ", "_");
		Double temperature = wBean.getAvgTemperature();
		//long unixTime = System.currentTimeMillis() / 1000l;
		
		String cookieValue = date+"|"+city+"|"+country+"|"+clouds+"|"+String.valueOf(temperature);
		
		try {
			Cookie weatherSearch = new Cookie("weatherSearch", cookieValue);
			
			weatherSearch.setMaxAge(120);
			
			response.addCookie(weatherSearch);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("showWeather.jsp");
		rd.forward(request, response);
	}	
}
