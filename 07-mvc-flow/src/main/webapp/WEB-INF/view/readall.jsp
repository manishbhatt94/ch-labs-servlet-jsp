<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	html {
		font-size: 125%;
	}
    body {
		font-family: Arial, Helvetica, sans-serif;
    }
</style>
</head>
<body>

	<h1>All Data</h1>
	<p>Note: This page is a dynamic JSP Page. It cannot be accessed
		directly publicly, but only via a Servlet</p>

	<h2>Employees List</h2>

	<table border="1">
        <thead>
			<tr>
				<th>S.No.</th>
				<th>Name</th>
			</tr>
        </thead>
        <tbody>
        <%
			List<String> data;
			if (session.getAttribute("employees") != null) {
				data = (List<String>) session.getAttribute("employees");
			} else {
				data = new ArrayList<>();
			}

			for (int i = 1; i <= data.size(); i++) {
        %>
				<tr>
					<td><%= i %></td>
					<td><%= data.get(i - 1) %></td>
				</tr>
		<%  } %>
		</tbody>
	</table>

</body>
</html>
