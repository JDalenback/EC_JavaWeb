<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OpenWeather</title>

  <link href="https://unpkg.com/material-components-web@latest/dist/material-components-web.min.css" rel="stylesheet">
  <script src="https://unpkg.com/material-components-web@latest/dist/material-components-web.min.js"></script>
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
  <link  rel="stylesheet" href="./style.css">

</head>
<body>

<div id="form">
 <form action="<%=request.getContextPath()%>/OWservlet" method="get">  
    
    <label class="mdc-text-field mdc-text-field--outlined">
  		<span class="mdc-notched-outline">
    		<span class="mdc-notched-outline__leading"></span>
    		<span class="mdc-notched-outline__notch">
      			<span class="mdc-floating-label" id="my-label-id"></span>
    		</span>
   		<span class="mdc-notched-outline__trailing"></span>
  		</span>
  		<input type="text" class="mdc-text-field__input" aria-labelledby="my-label-id" name="city" onfocus="this.value=''" value="City">
	</label>
	
	    <label class="mdc-text-field mdc-text-field--outlined">
  		<span class="mdc-notched-outline">
    		<span class="mdc-notched-outline__leading"></span>
    		<span class="mdc-notched-outline__notch">
      			<span class="mdc-floating-label" id="my-label-id"></span>
    		</span>
   		<span class="mdc-notched-outline__trailing"></span>
  		</span>
  		<input type="text" class="mdc-text-field__input" aria-labelledby="my-label-id" name="country" onfocus="this.value=''" value="Country code">
	</label>
    
    <button class="mdc-button mdc-button--outlined" type="submit">
  		<span class="mdc-button__ripple"></span>
  		<span class="mdc-button__label">Go</span>
	</button>

    </form>  

</div>


</body>
</html>