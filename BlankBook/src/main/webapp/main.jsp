<%@page import="beans.UserBean"%>
<%@page import="beans.PostBean"%>
<%@page import="model.UserPost"%>

<!doctype html>
<html lang="en">
<head>

<jsp:include page="mainHeader.jsp" />

</head>
<body>

	<%!	UserBean userBean;
		PostBean postBean;
	%>
	
	<%
	userBean = (UserBean) session.getAttribute("user");
	if (userBean == null) {
	%>
	<jsp:forward page="index.jsp" />
	<%
	}

	postBean = (PostBean) session.getAttribute("postBean");
	%>

	<div class="px-4 py-5 my-5 text-center fullsize">
		<img class="d-block mx-auto mb-4" src="./brand/bootstrap-logo.svg"
			alt="" width="72" height="57">
		<h1 class="display-5 fw-bold">
			Welcome
			<%=userBean.getUserName()%></h1>
		<div class="col-lg-6 mx-auto">
			<p class="lead mb-4">What do you want to post today?</p>
			<div class="d-grid gap-2 d-sm-flex justify-content-sm-center">

				<form id="UserPostForm"
					action="<%=request.getContextPath()%>/UserPost" method="POST">
					<input type="hidden" name="UserName"
						value="<%=userBean.getUserName()%>">
					<textarea name="UserPost" form="UserPostForm" rows="5" cols="50"
						maxlength="200" placeholder="Max 200 characters" required></textarea>
					<input type="text" name="Tag" maxlength="20" placeholder="Tag your post">
					<button type="submit" class="btn btn-primary btn-lg px-4 me-sm-3">Post</button>
				</form>
			</div>
		</div>
	</div>
	<div class="logout">
		<form action="<%=request.getContextPath()%>/Logout">
			<button type="submit" class="btn btn-outline-secondary btn-lg px-4">Logout</button>
		</form>
	</div>

	<div class="b-example-divider"></div>
	
	<div class="px-4 py-5 my-5 text-center">
			<h1 class="display-5 fw-bold">
				Posts:
			</h1>
	</div>
	
	<!-- POSTS -->
	
	<!-- Original htlm code for the post 
	<div class="container my-5">
		<div
			class="row p-4 pb-0 pe-lg-0 pt-lg-5 align-items-center rounded-3 border shadow-lg">
			<div class="col-lg-7 p-3 p-lg-5 pt-lg-3">
				<h1 class="display-5 fw-bold lh-1">UserName</h1>
				<h3 class="display-8 fw-bold lh-1">Date</h3>
				<p class="lead">The Actual Post</p>
				<div class="tag">
					<p>Tag: </p>
				</div>
			</div>
		</div>
	</div>
	-->
	
	<%

		for(UserPost userPost : postBean.getUserPost()){
			String userName = userPost.getUsername();
			String date = userPost.getDate();
			String postValue = userPost.getPostValue();
			String tag = userPost.getTag();
			
			out.print("<div class=\"container my-5\">");
			out.print("<div class=\"row p-4 pb-0 pe-lg-0 pt-lg-5 align-items-center rounded-3 border shadow-lg\">");
			out.print("<div class=\"col-lg-7 p-3 p-lg-5 pt-lg-3\">");
			out.print("<h1 class=\"display-5 fw-bold lh-1\"> " + userName + "</h1>");
			out.print("<h3 class=\"display-8 fw-bold lh-1\">" + date + "</h3>");
			out.print("<p class=\"lead\">" + postValue + "</p>");
			out.print("<div class=\"tag\"><p>Tag: " + tag + "</p></div>");
			out.print("</div></div></div>");
		}
	%>

	<!-- END POST -->




	<div class="b-example-divider"></div>

	<div class="bg-dark text-secondary px-4 py-5 text-center">
		<div class="py-5">
			<h1 class="display-5 fw-bold text-white">Dark mode hero</h1>
			<div class="col-lg-6 mx-auto">
				<p class="fs-5 mb-4">Quickly design and customize responsive
					mobile-first sites with Bootstrap, the world’s most popular
					front-end open source toolkit, featuring Sass variables and mixins,
					responsive grid system, extensive prebuilt components, and powerful
					JavaScript plugins.</p>
				<div class="d-grid gap-2 d-sm-flex justify-content-sm-center">
					<button type="button"
						class="btn btn-outline-info btn-lg px-4 me-sm-3 fw-bold">Custom
						button</button>
					<button type="button" class="btn btn-outline-light btn-lg px-4">Secondary</button>
				</div>
			</div>
		</div>
	</div>

	<div class="b-example-divider mb-0"></div>


	<script src="../assets/dist/js/bootstrap.bundle.min.js"></script>


</body>
</html>
