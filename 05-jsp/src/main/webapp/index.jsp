<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>This is Index JSP!</h1>
	
	<!-- Scriplet Tags -->
	<%
	// Any Java Code is allowed in Scriplet Tags
	int a = 10;
	int b = 20;
	
	// In JSP files, we get some "implicit objects" that are available to us
	// in normal Servlet code, such as the "request", "response" objects:
	
	// request.getParameter("email"); // request is of type HttpServletRequest
	
	// For printing to the response, we get an implicit object: "out" of type
	// JspWriter, using which we can write HTML segment to the response, like
	// we did in Servlet code:
	// response.getWriter.println("<h2>Profile Updated Successfully!</h2>");
	
	out.print("<p style=\"color: purple;\">a + b is equal to: " + (a + b) +"</p>");
	%>

</body>
</html>
