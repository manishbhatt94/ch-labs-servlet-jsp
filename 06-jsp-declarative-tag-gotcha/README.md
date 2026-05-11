# Project `06-jsp-declarative-tags-gotcha`

Demonstrates the thread-safety gotcha with instance variables declared via
Declarative Tags (`<%! ... %>`) in JSP files.

## The Gotcha

As established in project `05-jsp`, code inside Declarative Tags is placed at
the **class body level** of the JSP Generated Servlet — not inside
`_jspService()`. This means any variable declared there becomes an **instance
variable** of the generated Servlet class.

Because the JSP container creates only **one instance** of the generated Servlet
to handle all incoming requests (the same single-instance model as plain
Servlets), that one instance — and all its instance variables — is **shared
across every request, from every user, handled by every thread**.

This project makes that concrete and observable.

## What the Code Does

### `index.jsp`

A simple form that accepts a name and submits it as a POST request to
`home.jsp`. Nothing interesting here — it just exists to feed input to the demo.

### `home.jsp`

This is where the demo happens. The relevant code is:

```jsp
<%!
    private String name; // instance variable — shared across ALL requests
%>

<%
    String name = request.getParameter("name");  // local variable — per-request
    this.name = this.name + name;                // appends to the shared instance variable
%>

Instance variable "name": <%=this.name%>
```

On every request, the value submitted via the form is **appended** to the
instance variable `this.name` — which persists across requests because it lives
on the single shared Servlet instance.

## Observing the Gotcha

1. Run the application and open `index.jsp`.
2. Enter a name (e.g. `"Alice"`) and submit.
   - `home.jsp` shows: `nullAlice`
   - (`null` because `String` instance variables default to `null`, and
     `null + "Alice"` in Java produces the string `"nullAlice"`)
3. Go back and submit again with a different name (e.g. `"Bob"`).
   - `home.jsp` shows: `nullAliceBob`
4. Open a **different browser** (or an incognito window) and submit `"Charlie"`.
   - `home.jsp` shows: `nullAliceBobCharlie`

Each new request from any user, in any session, keeps appending to the same
instance variable. There is no isolation between users or requests.

## Why This Happens

```
JSP Container starts up
        │
        ▼
 Translates home.jsp → HomeServlet.java
        │
        ▼
 Creates ONE instance of HomeServlet
 (this instance lives for the lifetime of the application)
        │
        ├── Request from Alice  ──► _jspService()  reads/writes this.name
        ├── Request from Bob    ──► _jspService()  reads/writes this.name
        └── Request from Charlie──► _jspService()  reads/writes this.name
```

All three threads call `_jspService()` on the **same object**, so `this.name`
refers to the same memory location every time.

## The `null` Prefix Explained

The instance variable is declared as:

```java
private String name;
```

Java initialises instance variables of reference types to `null` by default.
On the very first request, the code executes:

```java
this.name = this.name + name;
// equivalent to:
this.name = null + "Alice";
// which Java evaluates as:
this.name = "nullAlice";
```

Java's string concatenation operator (`+`) calls `String.valueOf()` on each
operand, which converts `null` to the literal string `"null"`. This is purely
a Java language behaviour — it is not specific to JSP.

## The Fix

**Never use instance variables in JSP Declarative Tags to hold request-scoped
data.** Any data that belongs to a single request should be declared as a local
variable inside a Scriptlet Tag, where it lives in `_jspService()` and is
therefore scoped to that one method call:

```jsp
<%
    // Correct: local variable, lives only for the duration of this request.
    String name = request.getParameter("name");
%>
```

Declarative Tags are appropriate for things that are genuinely meant to be
shared at the class level — utility/helper methods, or constants — never for
stateful per-request data.

## Key Takeaways

- A Declarative Tag declares class-level members of the JSP Generated Servlet.
- The JSP container creates a single Servlet instance for all requests.
- Instance variables on that Servlet are shared across all requests and all
  users, with no synchronization by default — a classic race condition in any
  real concurrent scenario.
- This is the same reason plain Servlets discourage instance variables for
  request-scoped data.
- Per-request data always belongs in local variables inside `_jspService()`,
  which means inside Scriptlet Tags (or Expression Tags) in JSP source.
