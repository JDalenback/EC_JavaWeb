<%! String pageURL = ""; %>
<% pageURL = request.getParameter("pageSelect") + "?sendValue" +request.getParameter("sendValue"); %>
<jsp:forward page="<%=pageURL %>"/>