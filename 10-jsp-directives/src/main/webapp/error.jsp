<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Oops: Error Occurred</title>
</head>
<body>

	<h1>Oops! An error occurred while processing your request.</h1>
	<p>We apologize for the inconvenience. Please try again later.</p>

	<h2>Error Details:</h2>
	<pre><%=exception%></pre>
	<!-- Implicit object "exception" becomes available in JSP page which
	has a PAGE Directive with isErrorPage attribute having value "true" 
	-->

</body>
</html>
