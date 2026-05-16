# Project `11-jstl-intro`

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
<%@ taglib prefix="c" uri="http://sun.com" %>
```

* **Verify Javadocs**: Insert a standard tag (e.g., `<c:out value="test" />`)
  into the JSP page. Hovering the mouse pointer over the tag attribute or name
  will display its descriptive documentation.
* **Verify Navigation**: Using **`Ctrl` + Left Click** on JSTL classes or
  standard library exceptions within associated Java Servlet files will
  automatically open the underlying source code file inside the editor workspace.
