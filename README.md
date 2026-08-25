# CH Labs - Servlets & JSP

Eclipse IDE Workspace - with multiple Java projects to get more comfortable
with Java core web foundations, i.e. Servlets & JSP.


## Deployment Descriptor (web.xml) Schema Locations / XML Preambles

Every official schema for Java EE and Jakarta EE is centralized in one of two
canonical web directories:

- Jakarta EE Namespace Registry (Servlet 5.0, 6.0, and newer):
  - URL: [https://jakarta.ee/xml/ns/jakartaee/](https://jakarta.ee/xml/ns/jakartaee/)
  - Maintained by the Eclipse Foundation. It serves as the official directory
  listing containing raw `.xsd` schemas for every Jakarta EE specification
  version (web-app_5_0.xsd, web-app_6_0.xsd, web-app_6_1.xsd, etc.).

- Oracle / Sun Java EE Schema Index (Servlet 2.4 through 4.0):
  - URL: [https://www.oracle.com/webfolder/technetwork/jsc/xml/ns/javaee/index.html](https://www.oracle.com/webfolder/technetwork/jsc/xml/ns/javaee/index.html)
  - (Legacy alias: [http://java.sun.com/xml/ns/javaee/](http://java.sun.com/xml/ns/javaee/))
  - Maintained by Oracle. It lists every historical Java EE deployment
  descriptor schema (web-app_2_4.xsd up to web-app_4_0.xsd) alongside metadata
  for EJB, JPA, and JSF.


From above, download the `.xsd` / `.dtd` for the desired Servlet version, e.g.
`web-app_6_1.xsd`, `web-app_3_1.xsd`, `web-app_2_3.dtd`, etc. and open the same
in a text editor, and you will find example of the XML header/preamble to use
for that particular Servlet version's `web.xml`, written in some documentation
comments. Example:

```xml
<!-- For Servlet 2.3: web-app_2_3.dtd (J2EE 1.3 DTDs / September 16, 2001): -->
<!--
This is the XML DTD for the Servlet 2.3 deployment descriptor.
All Servlet 2.3 deployment descriptors must include a DOCTYPE
of the following form:

  <!DOCTYPE web-app PUBLIC
	"-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN"
	"http://java.sun.com/dtd/web-app_2_3.dtd">

-->



<!-- For Servlet 2.4: web-app_2_4.xsd (J2EE 1.4 Schema Resources / February, 2004): -->
  <xsd:annotation>
    <xsd:documentation>
      <![CDATA[

	This is the XML Schema for the Servlet 2.4 deployment descriptor.
	The deployment descriptor must be named "WEB-INF/web.xml" in the
	web application's war file.  All Servlet deployment descriptors
	must indicate the web application schema by using the J2EE
	namespace:

	http://java.sun.com/xml/ns/j2ee

	and by indicating the version of the schema by
	using the version element as shown below:

	    <web-app xmlns="http://java.sun.com/xml/ns/j2ee"
	      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	      xsi:schemaLocation="..."
	      version="2.4">
	      ...
	    </web-app>

	The instance documents may indicate the published version of
	the schema using the xsi:schemaLocation attribute for J2EE
	namespace with the following location:

	http://java.sun.com/xml/ns/j2ee/web-app_2_4.xsd

	]]>
    </xsd:documentation>
  </xsd:annotation>



<!-- For Servlet 3.0: web-app_3_0.xsd (Java EE 6 Schema Resources / December 10, 2009): -->
  <xsd:annotation>
    <xsd:documentation>
      <![CDATA[[
      This is the XML Schema for the Servlet 3.0 deployment descriptor.
      The deployment descriptor must be named "WEB-INF/web.xml" in the
      web application's war file.  All Servlet deployment descriptors
      must indicate the web application schema by using the Java EE
      namespace:
      
      http://java.sun.com/xml/ns/javaee 
      
      and by indicating the version of the schema by 
      using the version element as shown below: 
      
      <web-app xmlns="http://java.sun.com/xml/ns/javaee"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="..."
      version="3.0"> 
      ...
      </web-app>
      
      The instance documents may indicate the published version of
      the schema using the xsi:schemaLocation attribute for Java EE
      namespace with the following location:
      
      http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd
      
      ]]>
    </xsd:documentation>
  </xsd:annotation>



<!-- For Servlet 3.1: web-app_3_1.xsd (Java EE 7 Schema Resources / April 30, 2013): -->
  <xsd:annotation>
    <xsd:documentation>
      <![CDATA[[
      This is the XML Schema for the Servlet 3.1 deployment descriptor.
      The deployment descriptor must be named "WEB-INF/web.xml" in the
      web application's war file.  All Servlet deployment descriptors
      must indicate the web application schema by using the Java EE
      namespace:
      
      http://xmlns.jcp.org/xml/ns/javaee 
      
      and by indicating the version of the schema by 
      using the version element as shown below: 
      
      <web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="..."
      version="3.1"> 
      ...
      </web-app>
      
      The instance documents may indicate the published version of
      the schema using the xsi:schemaLocation attribute for Java EE
      namespace with the following location:
      
      http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd
      
      ]]>
    </xsd:documentation>
  </xsd:annotation>



<!-- For Servlet 4.0: web-app_4_0.xsd (Java EE 8 Schema Resources / August 21, 2017): -->
  <xsd:annotation>
    <xsd:documentation>
      <![CDATA[
      This is the XML Schema for the Servlet 4.0 deployment descriptor.
      The deployment descriptor must be named "WEB-INF/web.xml" in the
      web application's war file.  All Servlet deployment descriptors
      must indicate the web application schema by using the Java EE
      namespace:
      
      http://xmlns.jcp.org/xml/ns/javaee
      
      and by indicating the version of the schema by
      using the version element as shown below:
      
      <web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="..."
      version="4.0">
      ...
      </web-app>
      
      The instance documents may indicate the published version of
      the schema using the xsi:schemaLocation attribute for Java EE
      namespace with the following location:
      
      http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd
      
      ]]>
    </xsd:documentation>
  </xsd:annotation>



<!-- For Servlet 5.0: web-app_5_0.xsd (Jakarta EE 9): -->
  <xsd:annotation>
    <xsd:documentation>
      <![CDATA[
      This is the XML Schema for the Servlet 5.0 deployment descriptor.
      The deployment descriptor must be named "WEB-INF/web.xml" in the
      web application's war file.  All Servlet deployment descriptors
      must indicate the web application schema by using the Jakarta EE
      namespace:
      
      https://jakarta.ee/xml/ns/jakartaee
      
      and by indicating the version of the schema by
      using the version element as shown below:
      
      <web-app xmlns="https://jakarta.ee/xml/ns/jakartaee"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="..."
      version="5.0">
      ...
      </web-app>
      
      The instance documents may indicate the published version of
      the schema using the xsi:schemaLocation attribute for Jakarta EE
      namespace with the following location:
      
      https://jakarta.ee/xml/ns/jakartaee/web-app_5_0.xsd
      
      ]]>
    </xsd:documentation>
  </xsd:annotation>

```

<br>

A couple blog posts that mention the XML Preamble for web.xml from Servlet 2.3
to Servlet 3.1:

- [mkyong.com/web-development/the-web-xml-deployment-descriptor-examples/](https://mkyong.com/web-development/the-web-xml-deployment-descriptor-examples/)
  - Archive: [archive.ph/8o53i](https://archive.ph/8o53i)
- [www.chankok.com/web-xml-namespace-declaration-and-schema-location/](https://www.chankok.com/web-xml-namespace-declaration-and-schema-location/)
  - Archive: [archive.ph/ZK4To](https://archive.ph/ZK4To)

