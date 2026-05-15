<%-- 
PAGE Directive: <%@ page attribute1="value1" attribute2="value2" %>
--%>

<%@ page
	language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	session="false"
	import="java.util.*"
	import="java.text.SimpleDateFormat"
	errorPage="error.jsp"
	buffer="none"
%>

<%--
<%@ page isELIgnored="true" %>
--%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- When PAGE Directive's attribute: session is set to "false",
	then the implicit object "session" is not available in the JSP page.
	 --%>
	<%
	// session.getAttribute("name");
	%>
	
	<%-- When PAGE Directive's attribute: errorPage is set to "error.jsp",
    then when an exception occurs in the JSP page, the control will be transferred to "error.jsp" page.
     --%>
    <ul>
        <% 
        for (int i = 0; i < 20; i++) {
            out.println("<li>" + i + "</li>");
            if (i == 18) {
                throw new RuntimeException("An exception occurred at i = " + i);
            }
        }
        %>
    </ul>

</body>
</html>
