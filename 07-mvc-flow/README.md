# Project: `07-mvc-flow`

This project shows the MVC flow & convention of never directly accessing
a (dynamic) JSP resource (or page) from the client.

Instead, have the client access a plain Servlet, then:
- perform whatever logic & processing is needed in the Servlet request method
  handler
- by delegating to service layer & DAO layer objects
- and when all the required data is collected, and control gets back to the
  Servlet's request method handler (doGet etc.)
- then we forward the request to a dynamic JSP page (which is treated as a
  View) after somehow attaching the data that the view needs to render.

In case, such a dynamic JSP page is allowed to be directly accessible by
the client, then the logic, processing & data retrieval performed by the
Servlet, as described above, doesn't get to happen.

So the directly loaded JSP page will fail with issues due to data not being
available, and we'll have to resort to adding null checks everywhere on all
such dynamic JSP pages.

## How to make views not directly accessible?

Keeping view files (HTML, JSP, etc.) inside the path `src/main/webapp/WEB-INF/`,
will make sure that such assets cannot be directly loaded from the client.

Here, we keep our dynamic JSP file `readall.jsp` inside a custom `view/` folder,
inside `src/main/webapp/WEB-INF/`, so that all JSP files are kept separately &
cleanly, without disturbing other contents of the `WEB-INF` directory, such as
`WEB-INF/lib/` (which is used to hold external JAR files), and `WEB-INF/web.xml`
(which is the Deployment Descriptor / DD file).

- Publicly accessible views must be kept directly under path `src/main/webapp/`
    - By the conventions of MVC which we covered in the starting, publicly accessible
      views must not by dynamic.
    - So, we keep static files directly inside `src/main/webapp/` like HTML files
      which cannot contain any dynamic data.
    - Files present at this path are accessible at
      http://localhost:[port]/[context-or-project]/index.html for example if
      we're trying to load the file at `src/main/webapp/index.html`.
- Dynamic views must be kept under path `src/main/webapp/WEB-INF/`
    - The contents here, are not allowed to be accessed from client side.
    - They can only be accessed from a Servlet like when doing a Server-Side
      Request Dispatch using `RequestDispatcher`'s forward() or include() method.
