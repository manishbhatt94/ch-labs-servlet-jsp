# Project: `07-mvc-flow`

This project demonstrates the MVC flow and the convention of never allowing
a client to directly access a dynamic JSP resource.

Instead, the client accesses a plain Servlet, which:
- performs whatever logic and processing is needed in its request handler method,
- delegates to service layer and DAO layer objects as required,
- collects all the data the view will need,
- and finally forwards the request to a JSP page (the View), passing along that
  data.

If a dynamic JSP page were directly accessible by the client, the Servlet logic
described above would never execute. The JSP would render with no data available,
forcing defensive null checks everywhere throughout the view layer — exactly the
kind of coupling and fragility MVC is designed to avoid.

## Project Structure

```
src/main/webapp/
├── index.html                        ← static view, publicly accessible
└── WEB-INF/
    ├── web.xml                       ← Deployment Descriptor
    └── view/
        └── readall.jsp               ← dynamic view, NOT publicly accessible
```

```
src/main/java/
└── com/
    └── controller/
        └── TestMvc.java              ← Servlet (Controller)
```

## How to Make Views Not Directly Accessible

Placing view files inside `src/main/webapp/WEB-INF/` makes them inaccessible
to direct client requests. The Servlet container (Tomcat, Jetty, etc.) enforces
this: any HTTP request whose URL resolves to a path under `WEB-INF/` is
automatically blocked with a 404, regardless of whether the file exists there.

The only way to reach a resource under `WEB-INF/` is via a **server-side
dispatch** — using `RequestDispatcher`'s `forward()` or `include()` method
from within a Servlet. This is deliberate: it guarantees the Servlet (the
Controller) always runs first.

In this project, `readall.jsp` is kept inside `WEB-INF/view/` — a custom
subfolder to keep JSP view files cleanly separated from other `WEB-INF`
contents such as `lib/` (external JARs) and `web.xml`.

### Summary of placement rules

- **Static views** → `src/main/webapp/` (directly accessible by the client)
    - e.g. `index.html` is served at
      `http://localhost:[port]/[context]/index.html`
    - Per MVC convention, files here should be static — they cannot contain
      dynamic data processed by a Servlet anyway, and they should not need to.

- **Dynamic views** → `src/main/webapp/WEB-INF/view/` (not directly accessible)
    - e.g. `readall.jsp` cannot be reached by any client URL.
    - Only reachable via a server-side `RequestDispatcher` forward from a Servlet.

## Request Flow

```
Client
  │
  │  GET /read-all
  ▼
TestMvc.doGet()                        (Controller)
  │
  ├─ builds List<String> employees
  ├─ stores it in HttpSession:
  │    session.setAttribute("employees", employees)
  │
  ├─ obtains a RequestDispatcher for /WEB-INF/view/readall.jsp
  └─ calls requestDispatcher.forward(request, response)
                │
                ▼
          readall.jsp                  (View)
            │
            ├─ reads session attribute "employees"
            └─ renders the HTML table
                │
                ▼
              Client receives the final HTML response
```

The client never speaks to `readall.jsp` directly. It only ever sees the
final rendered HTML that the JSP produced after the Servlet prepared its data.

## How Data Is Passed from Servlet to JSP

There are two standard mechanisms for a Servlet to pass data to a JSP before
forwarding to it. This project uses **HttpSession**:

```java
HttpSession session = request.getSession();
session.setAttribute("employees", employees);
```

`readall.jsp` then reads it back via the `session` implicit object:

```jsp
List<String> data = (List<String>) session.getAttribute("employees");
```

The other common mechanism is **request attributes** (`request.setAttribute()`
/ `request.getAttribute()`), which scope the data to the lifetime of the single
forwarded request rather than the entire session. Request attributes are
generally preferred over session attributes for data that is only needed to
render one response, as session-stored data persists across requests until
explicitly removed or the session expires.

## `web.xml` — Servlet Mapping

`web.xml` (the Deployment Descriptor) maps the URL pattern `/read-all` to the
`TestMvc` Servlet class:

```xml
<servlet>
    <servlet-name>TestMvc</servlet-name>
    <servlet-class>com.controller.TestMvc</servlet-class>
</servlet>
<servlet-mapping>
    <servlet-name>TestMvc</servlet-name>
    <url-pattern>/read-all</url-pattern>
</servlet-mapping>
```

This is why `index.html` links to `read-all` (a Servlet URL), not directly
to `readall.jsp` (the view):

```html
<a href="read-all">READ ALL DATA</a>
```

`index.html` is also declared as the first entry in `<welcome-file-list>`,
making it the default page served when the application root URL is accessed.
