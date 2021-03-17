<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Third</title>
<link rel="stylesheet" href="./css/style.css">
</head>
<body>
<jsp:include page="./header.jsp"/>

<h1>Third page: Param that was sent:</h1>
<%
String param = request.getParameter("sendValue");

if(param != null) out.print("<h1>" + param + "</h1>");
%>

<jsp:include page="./footer.jsp"/>
</body>
</html>