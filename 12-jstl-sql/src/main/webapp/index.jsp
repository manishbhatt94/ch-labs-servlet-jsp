<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index page</title>
</head>
<body>

	<header>
		<h1>Welcome to JSTL SQL Tags Demo Application</h1>
		<nav>
			<ul>
				<li><a href="read.jsp">READ DATA</a></li>
			</ul>
		</nav>
	</header>

	<section>
		<h2>Insert new data record</h2>
		<form action="insert.jsp" method="post">
			<p>
				<label for="name">Name: </label>
				<input type="text" name="name" required id="name" placeholder="Enter your name" />
			</p>
			<p>
				<label for="city">City: </label>
				<input type="text" name="city" required id="city" placeholder="Enter your city" />
			</p>
			<input type="submit" value="Insert Data" />
		</form>
	</section>

</body>
</html>
