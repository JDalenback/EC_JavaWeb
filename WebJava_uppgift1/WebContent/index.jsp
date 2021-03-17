<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>form</title>
<link rel="stylesheet" href="./css/style.css">
</head>
<body>
<jsp:include page="./header.jsp"/>

<div id="formwrapper">
	<div id="center">
		<form action="./router.jsp">
			<label for="pageSelect">Select Page</label>
				<select name="pageSelect">
				<option value="first.jsp" selected>first</option>
				<option value="second.jsp">second</option>
				<option value="third.jsp">third</option>
			</select>

			<br>
			<label for="sendValue">Value to send:</label>
			<input type="text" name="sendValue" required>
			<br>
			<input type="submit" value="Submit">
		</form>
	
	</div>
</div>



<jsp:include page="./footer.jsp"/>
</body>
</html>