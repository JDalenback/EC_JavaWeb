<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.weatherBean"%>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>the weather</title>

  <link href="https://unpkg.com/material-components-web@latest/dist/material-components-web.min.css" rel="stylesheet">
  <script src="https://unpkg.com/material-components-web@latest/dist/material-components-web.min.js"></script>
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
  <link rel="stylesheet" href="./style.css">

</head>
<body>

<%! 
	private String[] splitCookie(String cookie){
		String[] splitCookie = cookie.split("[|]");
		return splitCookie;
	}
%>

<div class="cardWrapper">
	<div class="mdc-card">
		<div class="mdc-card__content">
	  	<h1>Current Search</h1>
	  		  <span class="material-icons">
		filter_drama
	  </span>
		<%
			weatherBean wBean = weatherBean.getInstance();
			
			//long unixTime = System.currentTimeMillis() / 1000l;
			String date = wBean.getDate();
			String city = wBean.getCityStr();
			String country = wBean.getCountryStr();
			String clouds = wBean.getCloudsStr();
			Double temperature = wBean.getAvgTemperature();
			
			
			out.print("<h3>Date: "+ date + "</h3>");
			//out.print("<h3>Unix Timestap: "+ unixTime + "</h3>");
			out.print("<h3>City: "+ city + "</h3>");
			out.print("<h3>Country: "+ country + "</h3>");
			out.print("<h3>Clouds: "+ clouds + "</h3>");
			out.print("<h3>Average temperature: "+ temperature + "</h3>");
		%>
		</div>
	</div>
</div>

<div class="cardWrapper">
	<div class="mdc-card">
	  <div class="mdc-card__content">
	  <h1>Last Search</h1>
	  <span class="material-icons">
		filter_drama
	  </span>
	    	<%
			Cookie[] cookies = request.getCookies();
			
			if(cookies != null){
				for(Cookie cookie : cookies){
					if(cookie.getName().equals("weatherSearch")){
						String[] splitCookie = splitCookie(cookie.getValue());
						out.print("<h3>Date: " + splitCookie[0] + "</h3>");
						out.print("<h3>City: " + splitCookie[1] + "</h3>");
						out.print("<h3>Country: " + splitCookie[2] + "</h3>");
						out.print("<h3>Clouds: " + splitCookie[3] + "</h3>");
						out.print("<h3>Average temperature: " + splitCookie[4] + "</h3>");
					}
				}
			}
		%>
	  </div>
	</div>
</div>

	
	
	

	
	


</body>
</html>