<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>This is Index JSP!</h1>

	<!-- Declarative Tags -->
	<h2>Declarative Tags (No Output)</h2>
	<p><strong>&lt;%! ... %&gt;</strong></p>
	<%!
	double result;
	public void power(int base, int exponent) {
		result = Math.pow(base, exponent);
	}
	%>

	<!-- Scriplet Tags -->
	<h2>Scriptlet Tags</h2>
	<p><strong>&lt;% ... %&gt;</strong></p>
	<%
	// Any Java Code is allowed in Scriplet Tags
	int a = 3;
	int b = 5;
	String firstname = "John";
	String lastname = "Doe";

	// In JSP files, we get some "implicit objects" that are available to us
	// in normal Servlet code, such as the "request", "response" objects:

	// request.getParameter("email"); // request is of type HttpServletRequest

	// For printing to the response, we get an implicit object: "out" of type
	// JspWriter, using which we can write HTML segment to the response, like
	// we did in Servlet code:
	// response.getWriter.println("<h2>Profile Updated Successfully!</h2>");

	out.print("<p style=\"color: purple;\">a + b is equal to: " + (a + b) + "</p>");
	out.println("<dl>");
	out.println("<dt>firstname</dt>");
	out.println("<dd>"+ firstname +"</dd>");
	out.println("<dt>lastname</dt>");
	out.println("<dd>"+ lastname +"</dd>");
	out.println("</dl>");
	
	power(a, b);
	%>
	<h3>Multiplication Table of 25:</h3>
	<ul>
	<% for (int i = 1; i <= 10; i++) { %>
		<li>25 * <%=i%> = <%=(25 * i)%></li>
	<% } %>
	</ul>

	<!-- Expression Tags: -->
	<!-- For printing the value of any expression. -->
	<h2>Expression Tags</h2>
	<p><strong>&lt;%= ... %&gt;</strong></p>
	<p>
		Entered value of query parameter "search": <strong> <%=request.getParameter("search")%>
		</strong>
	</p>
	<p>
		Greeting: Hello, <em> <%=firstname + " " + lastname%>
		</em>!
	</p>
	<p>
		Random number:
		<%=(int) Math.ceil(Math.random() * 10000)%>
	</p>
	<p>
		Result of power(<%=a%>, <%=b%>) method call:
		<strong><%=result%></strong>
	</p>


</body>
</html>
