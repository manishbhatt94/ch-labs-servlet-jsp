# Project: 03-servlet--context-config

Served at: [http://localhost:8080/03-servlet--context-config/](http://localhost:8080/03-servlet--context-config/)

## Project Console Output

```txt

============ Servlet2 ============

Servlet2 's ServletConfig: [conn-uri] = mongodb://myUser:myPassword@localhost:27017

ServletContext: [org-src-control-page] (Log from Servlet2) = https://github.com/manishbhatt94/

Servlet2: Getting the attribute [org-support-email] from ServletContext, set by Servlet1...
ServletContext: [org-support-email] (Log from Servlet2) = null

~%~%~%~%~%~%~%~%~%~%~%~%~%~%~%~%~%~%


============ Servlet1 ============

Servlet1 's ServletConfig: [conn-uri] = jdbc:mysql://localhost:3306/jfsseptkart

ServletContext: [org-src-control-page] (Log from Servlet1) = https://github.com/manishbhatt94/

Servlet1: Setting a new attribute [org-support-email] in ServletContext...

~%~%~%~%~%~%~%~%~%~%~%~%~%~%~%~%~%~%


============ Servlet2 ============

Servlet2 's ServletConfig: [conn-uri] = mongodb://myUser:myPassword@localhost:27017

ServletContext: [org-src-control-page] (Log from Servlet2) = https://github.com/manishbhatt94/

Servlet2: Getting the attribute [org-support-email] from ServletContext, set by Servlet1...
ServletContext: [org-support-email] (Log from Servlet2) = get.support@dragon-ball-z.org.in

~%~%~%~%~%~%~%~%~%~%~%~%~%~%~%~%~%~%


```
