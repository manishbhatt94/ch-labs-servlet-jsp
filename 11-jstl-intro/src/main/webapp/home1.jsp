<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home #1 page</title>
<style>
.page-subtitle {
    font-style: italic;
    color: #555;
}
.validation-results {
	margin-top: 20px;
	padding: 10px;
	border: 1px solid #ccc;
	background-color: #f9f9f9;
}

.validation-failure {
	color: red;
	font-weight: bold;
}

.validation-success {
	color: green;
	font-weight: bold;
}
</style>
</head>
<body>

	<h1>Welcome to Home #1 page!</h1>
	<p class="page-subtitle">
		This page is using JSP Scriptlets to process the form data.
	</p>

	<h2>Submitted Form Data</h2>
	<p>You entered the following data:</p>
	<ul>
		<li>Name: <%=request.getParameter("name")%></li>
		<li>City: <%=request.getParameter("city")%></li>
	</ul>

	<h2>Validation Result for Submitted Data</h2>
	<div class="validation-results">
		<%
		String name = request.getParameter("name");
		String city = request.getParameter("city");

		if (name.equals(city)) {
		%>
			<p class="validation-failure">Hey, your name and city are the
				same! That's interesting! We don't allow that.</p>
		<%
		} else if (city.startsWith("a")) {
		%>
			<p class="validation-failure">Hey, your city starts with 'a'!
				Sorry, such cities are not cool!</p>
		<%
		} else {
		%>
			<p class="validation-success">Great! Your name and city are
				different, and your city doesn't start with 'a'. Welcome to our site!</p>
		<%
		}
		%>
	</div>

</body>
</html>
