<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert page</title>
<style>
code {
	display: inline-block;
	vertical-align: center;
	margin: 0 2px;
	border: 1px solid #444;
	border-radius: 4px;
	padding: 2px 6px;
	background-color: #b1b1b1;
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
</style>
</head>
<body>

	<header>
		<h1>JSTL SQL Tags Demo App - INSERT DATA Page</h1>
		<nav>
			<ul>
				<li><a href="index.jsp">INDEX PAGE</a></li>
			</ul>
		</nav>
	</header>

	<p class="page-subtitle">
		This page is using JSTL SQL tags to INSERT the form data as a new
		record in the database table <code>ch_labs_jdbc_01.jstl_user</code>
	</p>

	<h2>Submitted Form Data</h2>
	<p>You entered the following data:</p>
	<ul>
		<li>Name: ${param.name}</li>
		<li>City: ${param.city}</li>
	</ul>

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

	<h2>Insert new record in the table (with &lt;sql:update&gt; Tag)</h2>
	
	<p>
		Executed below DML query:<br>
		<code>INSERT INTO jstl_user (name, city) VALUES (?, ?);</code>
	</p>

	<sql:update
		dataSource="${connection}"
		sql="INSERT INTO jstl_user (name, city) VALUES (?, ?);"
		var="rowsUpdated"
	>
		<sql:param value="${param.name}"></sql:param>
		<sql:param value="${param.city}"></sql:param>
	</sql:update>

	<p>
		<strong>Rows Updated Count:</strong>
		<c:out value="${rowsUpdated}"></c:out>
	</p>

	<h3>Insertion Status</h3>
	<div>
		<c:if test="${rowsUpdated == 1}">
			<p class="op-status op-status--success">SUCCESS: Record insertion was successful!</p>
		</c:if>
		<c:if test="${rowsUpdated != 1}">
			<p class="op-status op-status--failure">FAILURE: Record insertion failed!</p>
		</c:if>
	</div>

</body>
</html>
