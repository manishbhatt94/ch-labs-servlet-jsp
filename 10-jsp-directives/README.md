# JSP Directive Tags

Three (3) types of Directive Tags are available in JSP:
1. Page
1. Include
1. TagLib

## Page Directive: <%@ page ... %>

The JSP `page` directive is used to define global properties for an entire JSP page, such as the scripting language, error handling, and session management. Its syntax is:
```jsp
<%@ page attribute1="value1" attribute2="value2" %>
```

**Complete List of Page Directive Attributes:**

1. **import** : Imports Java classes, interfaces, or entire packages into the JSP page. It is the only attribute that can be used multiple times in a single page.
1. **contentType** : Sets the MIME type and character encoding of the response (e.g., `text/html; charset=UTF-8`).
1. **pageEncoding** : Specifies the character encoding for the JSP page source.
1. **session** : Specifies whether the page participates in an HTTP session. Default is `true`.
1. **erroPage** : Defines the URL of another JSP page that should handle any uncaught exceptions thrown by the current page.
1. **isErrorPage** : Indicates if the current page is an error handling page. If `true`, the implicit `exception` object is available.
1. **language** : Specifies the scripting language used in scriptlets and expressions. The default (and currently only valid value) is `java`.
1. **buffer** : Sets the size of the output buffer in kilobytes (e.g., `buffer="16kb"`) or turns it off (`buffer="none"`).
1. **autoFlush** : Boolean that determines if the buffer should be automatically flushed when full (`true`) or if an exception should be thrown (`false`).
1. **isThreadSafe** : Indicates if the generated servlet can handle concurrent requests. Default is `true`.
1. **extends** : Specifies a superclass that the generated servlet must extend.
1. **info** : Provides a descriptive string about the page, accessible via the `getServletInfo()` method.
1. **isELIgnored** : Determines whether Expression Language (EL) expressions are ignored (`true`) or evaluated (`false`).
1. **isScriptingEnabled** : Determines if scripting elements (scriptlets, expressions, declarations) are allowed. Default is `true`.


## Include Directive: <%@ include ... %>

Syntax:

```jsp
<%@ include file="header.jsp" %>
```

