<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Read page</title>
<style>
html {
	font-family: Arial, Helvetica, sans-serif;
}
body {
	padding: 20px 40px;
}
code {
	display: inline-block;
	vertical-align: center;
	margin: 0 2px;
	border: 1px solid #444;
	border-radius: 4px;
	padding: 2px 6px;
	background-color: #b1b1b1;
}
header {
	margin-bottom: 60px;
}
section {
	margin-bottom: 50px;
}
.page-subtitle {
    font-style: italic;
    color: #555;
}
.op-status {
	display: inline-block;
	vertical-align: center;
	padding: 10px 18px;
	border: 1px solid;
	border-radius: 5px;
	margin: 4px 0 8px;
	font-weight: bold;
}
.op-status--success {
	color: #006600;
	background-color: #99ff99;
}
.op-status--failure {
	color: #b30000;
	background-color: #ff9999;
}
table {
	border: 2px solid black;
	min-width: 400px;
}
table caption {
	font-style: italic;
	font-size: 0.9em;
	margin: 8px 0 4px;
}
th, td {
	padding: 4px 10px;
}
th {
	background-color: #b1b1b1;
}
</style>
</head>
<body>

	<header>
		<h1>JSTL SQL Tags Demo App - READ DATA Page</h1>
		<nav>
			<ul>
				<li><a href="index.jsp">INDEX PAGE</a></li>
			</ul>
		</nav>
	</header>

	<p class="page-subtitle">
		This page is using JSTL SQL tags to READ DATA from the database table
		<code>ch_labs_jdbc_01.jstl_user</code>
	</p>

	<section>
		<h2>Establish DB Connection (with &lt;sql:setDataSource&gt; Tag)</h2>	
		<sql:setDataSource
			var="connection"
			driver="com.mysql.cj.jdbc.Driver"
			url="jdbc:mysql://localhost:3306/ch_labs_jdbc_01"
			user="root"
			password="manish"
		/>
		<p>
			<strong>Connection object:</strong>
			<c:out value="${connection}"></c:out>
		</p>
	</section>

	<section>
		<h2>Read records from the table (with &lt;sql:query&gt; Tag)</h2>
		
		<p>
			Executed below DQL (Data Query Language) query:<br>
			<code>SELECT * FROM jstl_user ORDER BY id DESC LIMIT 5;</code>
		</p>
	
		<sql:query
			dataSource="${connection}"
			sql="SELECT * FROM jstl_user ORDER BY id DESC LIMIT 5;"
			var="resultSet"
		>
		</sql:query>
	
		<p>
			<strong>Result Set like object:</strong>
			<c:out value="${resultSet}"></c:out>
		</p>
		
		<p>
			<strong>Length of resultSet.rows = </strong>
			<c:out value="${fn:length(resultSet.rows)}"></c:out>
			record(s).
		</p>
	
		<h3>Table records</h3>
		<table border="1">
			<caption>Latest 5 records of <code>jstl_user</code> table</caption>
			<c:choose>
				<c:when test="${fn:length(resultSet.rows) > 0}">
					<!-- Data is present. Row count is greater than zero. -->
					<thead>
						<tr><th>id</th><th>name</th><th>city</th></tr>
					</thead>
					<tbody>
						<c:forEach items="${resultSet.rows}" var="data">
							<tr>
								<td>${data.id}</td>
								<td>${data.name}</td>
								<td>${data.city}</td>
							</tr>
						</c:forEach>
					</tbody>
				</c:when>
				
				<c:otherwise>
					<!-- No data present. Row count is zero. -->
					<tbody>
						<tr align="center"><td>No data present in the table</td></tr>
					</tbody>
				</c:otherwise>
			</c:choose>
		</table>
	</section>

</body>
</html>
