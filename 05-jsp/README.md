# Project `05-jsp`

Introduces JSP syntax.

## JSP Architecture

JSP is like a web resource exactly how a Servlet is.

In fact, when a request for a JSP resource hits the server, the **JSP Container**
part of the server (Tomcat, Jetty, etc.) will:
1. Translate the JSP file into a Servlet java file, which is called a
    **JSP Generated Servlet**,
1. Compile it, and create the bytecode (.class file).
1. Ask JVM to load the class.
1. Runs the initialization lifecycle of this generated Servlet *ONCE*. That is,
    creates a single object - one single object that caters to all requests to
    this JSP resource (same with plain Servlets), and calls the `init()` method
    on this object.
1. Above steps (1-4) happen only for the first request for this particular JSP
    resource. For subsequent requests, only the `service(req, res)` method is
    invoked.
1. The `service()` method is invoked. This method is called `_jspService(req, res)`
    in the JSP Generated Servlet class.

**Note:** JSP files have access to certain <u>*implicit objects*</u> that are
available to us in Servlet classes normally. These include:
- `request`: Instance of *HttpServletRequest*. Can be used to access data about
    request, like using `request.getParameter("email")` etc.
- `response`: Instance of *HttpServletResponse*.
- `out`: Instance of *JspWriter*. This is similar to the `response.getWriter()`
    object of type PrintWriter, that we use inside Servlet methods to write any
    data to the response stream.

## JSP Tag Types

1. Scriptlet Tags `<% ... %>`
1. Expression Tags `<%= ... %>`
1. Declarative Tags `<%! ... %>`
1. Directive Tags `<%@ ... %>`

In this project, we only cover Tag Types 1-3, i.e. Scriptlet, Expression, & Declarative Tags.

### Scriptlet Tags: <% ... %>

- These can embed Java code inside them.
- The code inside, is placed inside the `service()` or more accurately, the `_jspService()`
    method in the JSP Generated Servlet class.
- Since this code is placed inside a method (as stated above), therefore, we cannot define
    methods inside Scriptlet Tags.
- We need to use the `out.print("<p>..</p>")` or the `out.println("<ul><li>...</li></ul>")`
    method calls to write data to the response.
- These can even be used to write conditions and / or that wrap around some HTML, that can
    conditionally render some piece of HTML, or render it in a loop for some iterations.

### Expression Tags: <%= ... %>

- These can contain a Java expression, who value is evaluated, and printed to the response,
    at the same location where the Expression Tag was used in the JSP source.
- These are a convenience tag to easily print the value of a Java expression, without having
    to write `out.println(...)` calls in Scriptlet Tags.

### Declarative Tags: <%! ... %>

