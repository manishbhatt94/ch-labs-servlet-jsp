<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<style>
    html {
        font-family: Arial, Helvetica, sans-serif;
        font-size: 125%; 
    }
    code {
        background-color: #f4f4f4;
        display: inline-block;
        margin: 12px 0;
        padding: 10px;
        border-radius: 5px;
        font-family: Consolas, "Courier New", monospace;
        border: 1px solid #ddd;
    }
</style>
</head>
<body>

    <h1>Welcome to Home Page</h1>
    <p>Request Parameter "name": <%=request.getParameter("name")%></p>
    
    <%!
    // This gets default value of String class which is null.
    // This instance variable is shared across all requests and all users.
    private String name; // instance variable of the "JSP Generated Servlet" class.
    %>
    
    <%
    String name = request.getParameter("name");
    
    this.name = this.name + name;
    %>
    
    <p>Executed below code:</p>
    
    <code>
    this.name = this.name + request.getParameter("name");
    </code>
    
    <p>Now, we inspect the value of instance variable "name"</p>
    
    <p>
    Instance variable "name": <%=this.name%>
    </p>

</body>
</html>
