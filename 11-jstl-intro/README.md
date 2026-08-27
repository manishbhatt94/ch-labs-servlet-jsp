# Project &nbsp; <u>"11-jstl-intro"</u>

Explores JSP Standard Tag Library (JSTL) usage - which makes our JSP pages
a lot less complex - by removing need to use Scriptlets for majority of
use-cases - and replaces them with custom tags that wrap some functionality
like looping, etc.


# Setting Up JSTL 1.2 in a Java Web Project

This guide provides step-by-step instructions for adding the JavaServer Pages Standard Tag Library (JSTL) to a Dynamic Web Project (Web Module version 2.3) using Java 1.8 in Eclipse.

### Why is JSTL Not Bundled with Apache Tomcat?

Apache Tomcat is a web server and servlet container that implements core Java
Enterprise specifications like Java Servlets and JavaServer Pages (JSP). JSTL,
however, is an extension specification rather than a core component of the
standard servlet container. Because it is a separate library, web application
developers must explicitly download and bundle the JSTL library files within
their individual web applications.

```
+-------------------------------------------------------------------------------+
| Container Layer (Provided by Tomcat 9)                                        |
| - javax.servlet-api (Servlet 4.0/3.1)                                         |
| - javax.servlet.jsp-api (JSP 2.3)                                             |
| - javax.el-api (Unified EL 3.0)                                               |
+---------------------------------------+---------------------------------------+
                                        | (Tomcat does NOT bundle JSTL)
                                        v
+-------------------------------------------------------------------------------+
| Application Layer (Your WEB-INF/lib)                                          |
| - Spring 5.3.39 JARs (Core, Beans, Context, Web, WebMVC)                      |
| - JSTL 1.2 (jstl-1.2.jar OR taglibs-standard-spec + impl)                     |
+-------------------------------------------------------------------------------+
```

#### 1. The javax.* vs jakarta.* Namespace Boundary

Tomcat 9 belongs to the Java EE 8 generation and uses the `javax.*` package namespace
(`javax.servlet`, `javax.servlet.jsp.jstl`).

**JSTL 1.2** is written for the `javax.*` namespace.

**Why not JSTL 2.0 or 3.0?**

JSTL 2.0+ was renamed to Jakarta EE and uses `jakarta.servlet.jsp.jstl.*`.
If you put JSTL 2.0/3.0 on Tomcat 9, it will fail with
`ClassNotFoundException: javax.servlet.jsp.jstl...` because Tomcat 9 does not understand
the `jakarta.*` namespace. (Jakarta JSTL is strictly for Tomcat 10+).

#### 2. Why Doesn't Tomcat 9 Include JSTL Automatically?

Tomcat is a **Servlet/JSP Container**, NOT a full Java EE Application Server (like WildFly or WebLogic).

Tomcat natively provides the Servlet API (`servlet-api.jar`), JSP API (`jsp-api.jar`), and Expression
Language (`el-api.jar`) in its own `lib/` directory.

JSTL was standardized as an optional add-on library. Therefore, the web container expects the
web application *itself* to supply the JSTL implementation inside `WEB-INF/lib/`.


---

## Setup Instructions

### Step 1: Download the Library Files

We will use the JSTL 1.2 version.

Download the required binary and source files from the official Maven Central Repository:
1. Navigate to the [javax.servlet/jstl/1.2](https://mvnrepository.com/artifact/javax.servlet/jstl/1.2)
   page on Maven Central.
1. Click on View All button under the Files section.
1. This will navigate you to the Archives page at
   [https://repo1.maven.org/maven2/javax/servlet/jstl/1.2/](https://repo1.maven.org/maven2/javax/servlet/jstl/1.2/)
1. Download the main binary library file: **`jstl-1.2.jar`**
1. Download the developer source code file: **`jstl-1.2-sources.jar`**

*Note: A separate Javadoc archive is not required. The `-sources.jar` file contains the complete documentation comments embedded directly within the source code files.*

*Also, this JAR packages both the JSTL API specifications (interfaces) and the implementation classes together into a single file.*

### Step 2: Add the Binary JAR to the Project

1. Open the project inside the **Eclipse IDE**.
1. Navigate through the project directory structure to find the deployment
   folder: `src/main/webapp/WEB-INF/lib/`.
1. Copy **`jstl-1.2.jar`** from the local download location and paste it
   directly into this `lib/` directory.
1. Right-click the root folder of the project in Eclipse and select **Refresh**
   (or press `F5`) to update the workspace.
1. Because this JAR sits inside `WEB-INF/lib`, Eclipse automatically maps it
   under a virtual folder called **Web App Libraries**, present under Java
   Resources -> Libraries.

### Step 3: Configure Source Code Attachments

Linking the source code allows the IDE to display Javadoc information on hover
and enables code navigation using `Ctrl` + click.

1. In the Eclipse **Project Explorer**, expand the project tree.
1. Expand the **`Libraries`** virtual folder, then expand
   **`Web App Libraries`**.
1. Right-click on the newly added **`jstl-1.2.jar`** file and select
   **Properties**.
1. Select **Java Source Attachment** from the left-hand configuration menu.
1. Click the **External File...** button on the right panel.
1. Browse to the local file system, select the downloaded
   **`jstl-1.2-sources.jar`** file, and click **Open**.
1. Click **Apply and Close** to save the configuration settings.

---

## Verification

To verify that the library is configured correctly, add the standard core tag
library definition at the very top of any `.jsp` file:

```jsp
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
```

* **Verify Javadocs**: Insert a standard tag (e.g., `<c:out value="test" />`)
  into the JSP page. Hovering the mouse pointer over the tag attribute or name
  will display its descriptive documentation.
* **Verify Navigation**: Using **`Ctrl` + Left Click** on JSTL classes or
  standard library exceptions within associated Java Servlet files will
  automatically open the underlying source code file inside the editor workspace.

# Information about JSTL

Sources:
- [www.geeksforgeeks.org/advance-java/jstl-jsp-standard-tag-library/](https://www.geeksforgeeks.org/advance-java/jstl-jsp-standard-tag-library/)

## JSTL Tag Libraries

| Library | Prefix | Description |
| :------ | :----- | :---------: |
| **[Core Tags](https://www.geeksforgeeks.org/java/jstl-core-tags/)** | `c` | General-purpose tags for variables, flow control, loops, and URL handling |
| **[Formatting Tags](https://www.geeksforgeeks.org/java/jstl-formatting-tags/)** | `fmt` | For number, date, and message formatting with localization support |
| **[SQL Tags](https://www.geeksforgeeks.org/java/jstl-sql-tags/)** | `sql` | For executing database queries and updates (for demo/testing only) |
| XML Tags | `x` | For parsing and transforming XML documents |
| **[Function Tags](https://www.geeksforgeeks.org/java/jstl-function-tags/)** | `fn` | Contains utility functions for string and collection operations |

## Declare JSTL Tag Libraries in JSP

After adding the dependency, include the required JSTL tag libraries at the top of your JSP file.

```jsp
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
```

Explanation:

- **c:** Core tags (conditions, loops, variable handling)
- **fmt:** Formatting and internationalization
- **fn:** Utility functions for strings and collections
- **sql:** Lets us run SQL just using tags in JSP

These URIs are standard and fixed identifiers used by JSP to locate JSTL tags. They do not represent actual URLs.
