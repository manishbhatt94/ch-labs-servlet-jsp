<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home page</title>
</head>
<body>

	<h1>Welcome to Home Page</h1>

	<p>You have successfully submitted the form.</p>
	<p>
		<strong>Username:</strong>
		<%=request.getParameter("username")%>
	</p>

	<%
	// #=#=#=# Setting attributes in different scopes #=#=#=#

	// ==== Setting attribute(s) in PAGE scope: ====
	pageContext.setAttribute("msg", "This is my page level message.", PageContext.PAGE_SCOPE);

	// ==== Setting attribute(s) in SESSION scope: ====
	// 1. Using 'session' implicit object:
	session.setAttribute("msg", "This is my session level message."); // OR:
	// 2. Using 'pageContext' implicit object:
	pageContext.setAttribute("msg", "This is my session level message.", PageContext.SESSION_SCOPE);

	// ==== Setting attribute(s) in REQUEST scope: ====
	// 1. Using 'request' implicit object:
	request.setAttribute("msg", "This is my request level message."); // OR:
	// 2. Using 'pageContext' implicit object:
	pageContext.setAttribute("msg", "This is my request level message.", PageContext.REQUEST_SCOPE);

	// ==== Setting attribute(s) in APPLICATION scope: ====
	// 1. Using 'application' implicit object:
	// ('application' refers to the ServletContext object)
	application.setAttribute("msg", "This is my application level message."); // OR:
	// 2. Using 'pageContext' implicit object:
	pageContext.setAttribute("msg", "This is my application level message.", PageContext.APPLICATION_SCOPE);

	// #=#=#=# Accessing init parameters from ServletConfig #=#=#=#
	// 'config' refers to the ServletConfig object:
	config.getInitParameter("some-config-param");
	%>
	
	<%
	// pageContext.include("ad-banner-main.jsp");
	%>
	
	<%
	pageContext.forward("profile.jsp");
	%>

</body>
</html>
