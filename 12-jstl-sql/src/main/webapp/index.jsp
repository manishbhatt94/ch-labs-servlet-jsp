<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index page</title>
</head>
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
label {
	display: inline-block;
	vertical-align: center;
	min-width: 100px;
}
input[type="text"] {
	display: inline-block;
	vertical-align: center;
	min-width: 200px;
	padding: 4px 12px;
}
input[type="submit"] {
	display: inline-block;
	font-size: 1.2em;
	padding: 4px 12px;
}
.page-subtitle {
    font-style: italic;
    color: #555;
}
</style>
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
				<input type="text" name="name" required="required" id="name" placeholder="Enter your name" autofocus="autofocus" />
			</p>
			<p>
				<label for="city">City: </label>
				<input type="text" name="city" required="required" id="city" placeholder="Enter your city" />
			</p>
			<input type="submit" value="Insert Data" />
		</form>
	</section>

</body>
</html>
