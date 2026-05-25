<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en-IN">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>EMS Admin - Add Employee</title>
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
			<h2>New Employee Form</h2>
			<form action="add-employee" method="post">
				<p>
					<label for="name-input">Employee Name: </label>
					<input type="text" name="name" id="name-input" required="required" maxlength="100"
						minlength="2" placeholder="Enter employee's name...">
				</p>
				<p>
					<label for="address-input">Employee Address: </label>
					<input type="text" name="address" id="address-input" required="required" maxlength="180"
						minlength="4" placeholder="Enter employee's address...">
				</p>
				<p>
					<label for="dob-input">Employee Date-of-Birth: </label>
					<input type="date" name="dob" id="dob-input" required="required" maxlength="100"
						placeholder="Enter employee's date-of-birth (YYYY-MM-DD)...">
				</p>
				<p>
					<label for="salary-input">Employee Salary: </label>
					<input type="number" name="salary" id="salary-input" required="required" maxlength="100"
						placeholder="Enter employee's salary...">
				</p>
				<p>
					<button type="submit">Add Employee</button>
				</p>
			</form>
			<%@ include file="/WEB-INF/includes/result-message.jsp" %>
		</section>
	</main>

</body>
</html>
