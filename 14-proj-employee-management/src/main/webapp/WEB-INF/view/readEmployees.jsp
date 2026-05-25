<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en-IN">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>EMS Admin - Read Employees</title>
</head>
<body>

	<header>
		<h1>Add Employee - EMS Admin</h1>
		<nav>
			<ul>
				<li><a href=".">Admin Home</a></li>
			</ul>
		</nav>
	</header>
	
	<main>
		<section>
			<h2>Employees in EMS</h2>
			<table border="1">
				<caption>Records in <code>employee</code> table</caption>
				<c:choose>
					<c:when test="${fn:length(employees) > 0}">
						<!-- Data is present. Row count is greater than zero. -->
						<thead>
							<tr>
								<th>ID</th>
								<th>Name</th>
								<th>Address</th>
								<th>Date Of Birth</th>
								<th>Salary</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${employees}" var="employee">
								<tr>
									<td>${employee.id}</td>
									<td>${employee.name}</td>
									<td>${employee.address}</td>
									<td>${employee.dateOfBirth}</td>
									<td>${employee.salary}</td>
								</tr>
							</c:forEach>
						</tbody>
					</c:when>
					
					<c:otherwise>
						<!-- No data present. -->
						<tbody>
							<tr align="center"><td>No data present in the table</td></tr>
						</tbody>
					</c:otherwise>
				</c:choose>
			</table>
		</section>
	</main>

</body>
</html>
