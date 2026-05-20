# Employee Management System - Mini Project

Employee Management System (Mini) Project built using Servlets 4.0, JSP, JDK 8.

This is a monolithic, server rendered, MVC style application.

Note that, this project *DOES NOT USE* Maven/Gradle or any build system. We
manually manage the JAR files of libraries used.

Data is kept in local MySQL & connection pooling (by HikariCP) is used.

# Setup Instructions

## Library JARs Used

Copy the below library JARs by downloading from mvnrepository.com using the
links to the specific versions for each as provided below.

These JAR files need to be copied into the project's `src/main/webapp/WEB-INF/lib/`
directory.

Only the binary JARs (i.e. the ones containing just the bytecode .class files)
need to copied in the `WEB-INF/lib/` directory.

We will also download, the `-sources.jar` file and the `-javadoc.jar` file (if
available), along with each library listed below. These will not be placed
under `lib/` directory, but need to be linked with the binary JARs, to provide
for Source Code & Javadoc access for ease of development in Eclipse IDE.

Without the **sources** and/or the **javadoc** JARs linked to the binary JARs
if we need to *Ctrl+Click* to a library's member (class/interface/method/etc)
then we are taken to a bytecode file, which is not readable.

The procedure to do that is discussed here:
[#link-the-sources-jar-for-these-jars](https://github.com/manishbhatt94/ch-labs-servlet-jsp/tree/main/12-jstl-sql#link-the-sources-jar-for-these-jars).

Below are the libraries used:

1. **mysql-connector-j**:<br>
    - MySQL Connector/J is a JDBC Type 4 driver, implementing the JDBC 4.2 specification. The Type 4 designation means that the driver is a pure Java implementation of the MySQL protocol and does not rely on the MySQL client libraries.
    - Version used: `8.2.0`.
    - MVN Repository Link: [com.mysql/mysql-connector-j/8.2.0](https://mvnrepository.com/artifact/com.mysql/mysql-connector-j/8.2.0)
1. **HikariCP**:<br>
    - HikariCP is a JDBC **Connection Pooling** library.
    - Version used: `3.1.0`.
    - MVN Repository Link: [com.zaxxer/HikariCP/3.1.0](https://mvnrepository.com/artifact/com.zaxxer/HikariCP/3.1.0)
1. **SLF4J**:<br>
    (Since `org.slf4j.LoggerFactory` class is used by HikariCP)<br>
    - slf4j is a dependency of HikariCP.
    - Version used: `1.7.5`.
    - MVN Repository Link: [org.slf4j/slf4j-api/1.7.5](https://mvnrepository.com/artifact/org.slf4j/slf4j-api/1.7.5)
1. **JSTL**:<br>
    (Since `org.slf4j.LoggerFactory` class is used by HikariCP)<br>
    - JavaServer Pages Standard Tag Library (JSTL) is used for simplifying JSP
      code with custom tags that offer commonly needed packaged functionality.
    - Version used: `1.2`.
    - MVN Repository Link: [javax.servlet/jstl/1.2](https://mvnrepository.com/artifact/javax.servlet/jstl/1.2)
