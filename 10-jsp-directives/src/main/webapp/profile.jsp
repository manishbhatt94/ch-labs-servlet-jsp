<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile Page</title>
</head>
<body>

	<h1>Welcome to Profile Page</h1>
	<p>This is the profile page of the user.</p>
	
	<h2>Request Parameter from Index Page</h2>
	<p>
        <strong>Username:</strong>
        <%=request.getParameter("username")%>
    </p>
	
	<h2>Accessing Attributes from Different Scopes</h2>
	<p>
		<strong>Message from PAGE scope:</strong>
		<%=pageContext.getAttribute("msg", PageContext.PAGE_SCOPE)%>
	</p>

	<p>
		<strong>Message from REQUEST scope:</strong>
		<%=pageContext.getAttribute("msg", PageContext.REQUEST_SCOPE)%>
	</p>

	<p>
		<strong>Message from SESSION scope:</strong>
		<%=pageContext.getAttribute("msg", PageContext.SESSION_SCOPE)%>
	</p>

	<p>
		<strong>Message from APPLICATION scope:</strong>
		<%=pageContext.getAttribute("msg", PageContext.APPLICATION_SCOPE)%>
	</p>

</body>
</html>
