<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>BlankBook</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/sign-in/">

    

    <!-- Bootstrap core CSS -->
<link href="./css/bootstrap.min.css" rel="stylesheet">
<link href="./css/signin.css" rel="stylesheet">

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>

    
    <!-- Custom styles for this template -->
    <link href="signin.css" rel="stylesheet">
  </head>
  <body class="text-center">
  
  <%
  	if(session.getAttribute("user") != null){
  		%>
  		<jsp:forward page="main.jsp" />
  		<%
  	}
  %>
    
<main class="form-signin">
  <form action="<%=request.getContextPath()%>/Login" method="POST">
    <img class="mb-4" src="./brand/snapsvg-seeklogo.com.svg" alt="" width="72" height="57">
    <h1 class="h3 mb-3 fw-normal">Please sign in</h1>

    <div class="form-floating">
      <input type="text" class="form-control" id="floatingInput" placeholder="Username" name="username" required>
      <label for="floatingInput">Username</label>
    </div>
    <div class="form-floating">
      <input type="password" class="form-control" id="floatingPassword" placeholder="Password" name="password" required>
      <label for="floatingPassword">Password</label>
    </div>

    <div class="checkbox mb-3">
    <!--  
      <label>
        <input type="checkbox" value="remember-me"> Remember me
      </label>  
    -->
    </div>
    <button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
    <p class="mt-5 mb-3 text-muted">&copy; 2017-2021</p>
  </form>
</main>


    
  </body>
</html>
