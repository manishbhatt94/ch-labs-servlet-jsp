<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home #2 page</title>
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

	<h1>Welcome to Home #2 page!</h1>
	<p class="page-subtitle">
		This page is using JSTL Core and Functions tags to process the form data.
	</p>

	<h2>Submitted Form Data</h2>
	<p>You entered the following data:</p>
	<ul>
		<li>Name: ${param.name}</li>
		<li>City: ${param.city}</li>
	</ul>
	
	<%-- Setting variables using JSTL Core Library's <c:set> tag --%>
	<c:set var="name" value="${param.name}"></c:set>
	<c:set var="city" value="${param.city}"></c:set>

	<h2>Validation Result for Submitted Data</h2>
	<div class="validation-results">
		<c:choose>
			<c:when test="${name == city}">
				<p class="validation-failure">
					Hey, your name and city are the same! That's interesting! We don't allow that.
				</p>
			</c:when>

			<c:when test="${fn:startsWith(city, 'a')}">
				<p class="validation-failure">
					Hey, your city starts with 'a'! Sorry, such cities are not cool!
				</p>
			</c:when>

			<c:otherwise>
				<p class="validation-success">
					Great! Your name and city are different, and your city doesn't start with 'a'.
					Welcome to our site!
				</p>
			</c:otherwise>
		</c:choose>
	</div>

</body>
</html>
