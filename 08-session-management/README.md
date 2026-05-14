# Project: `08-session-management`

This project demonstrates **HTTP session management** in Servlets and JSP, implementing a simple login/logout flow that maintains user state across multiple HTTP requests.

## What is Session Management?

HTTP is a **stateless protocol** — each request is independent with no memory of previous requests. Session management solves this by allowing the server to track and maintain state for individual users across multiple requests.

The Servlet API provides `HttpSession` for session management. When a client makes their first request, the server creates a unique session object and assigns it a **session ID (JSESSIONID)**. This ID is sent to the client (typically via a cookie) and included in subsequent requests, allowing the server to retrieve the same session object and access stored data.

## Key Session API Methods

### Creating/Retrieving a Session
```java
HttpSession session = request.getSession();
```
Returns existing session or creates a new one. Use `request.getSession(false)` to avoid creating a new session (returns `null` if none exists).

### Storing Data
```java
session.setAttribute("data", username);
```

### Retrieving Data
```java
String username = (String) session.getAttribute("data");
```
Returns `null` if the attribute doesn't exist.

### Removing Data
```java
session.removeAttribute("data");  // Remove specific attribute
session.invalidate();             // Destroy entire session
```

## Project Structure

```
src/main/webapp/
├── index.html                        ← Landing page
└── WEB-INF/
    ├── web.xml                       ← Deployment Descriptor
    └── view/
        ├── login.jsp                 ← Login form (protected)
        └── home.jsp                  ← Home page (protected)

src/main/java/com/controller/
├── LoginView.java                    ← Displays login form
├── Login.java                        ← Handles login/session validation
└── Logout.java                       ← Handles logout
```

## Application Flow

1. **Landing:** User visits `index.html` → clicks "LOGIN HERE" → redirected to `/login-view`
2. **Login View:** `LoginView` servlet forwards to `login.jsp` (displays form)
3. **Login Submit:** Form posts to `/login` → `Login.doPost()` validates credentials
4. **Success:** If valid (`raju`/`123456`), stores username in session and forwards to `home.jsp`
5. **Failure:** If invalid, forwards back to `login.jsp`
6. **Session Check:** `Login.doGet()` checks if session contains "data" attribute to determine if user is logged in
7. **Logout:** User clicks logout → `Logout.doGet()` removes session data and forwards to `login.jsp`

## Servlet Implementations

### `LoginView.java`
Simply forwards to the login JSP view. No session logic.

### `Login.java`
**`doGet()`:** Checks if user is already logged in by looking for session attribute "data". Forwards to home page if logged in, otherwise to login page.

**`doPost()`:** Validates submitted credentials. If valid, creates/retrieves session, stores username, and forwards to home page. Otherwise, returns to login page.

### `Logout.java`
**`doGet()`:** Removes the "data" attribute from session using `session.removeAttribute("data")` and forwards to login page.

**Note:** The code includes a commented alternative `session.invalidate()` which would destroy the entire session instead of just removing one attribute.

## Key Concepts Demonstrated

### 1. Session Creation and Retrieval
All three servlets use `request.getSession()` to work with sessions. This method is idempotent — it returns the existing session or creates a new one if needed.

### 2. Session Attributes for State Management
The application stores the username in a session attribute named "data":
- **Login:** `session.setAttribute("data", username)`
- **Check:** `session.getAttribute("data")` returns `null` if not logged in
- **Logout:** `session.removeAttribute("data")` clears the login state

### 3. Session-Based Authentication
`Login.doGet()` demonstrates a simple authentication check: if the "data" attribute exists in the session, the user is considered logged in and sees the home page. Otherwise, they see the login form.

### 4. Two Logout Approaches
- **`removeAttribute("data")`:** Removes only the user data, keeping the session alive
- **`invalidate()`:** Destroys the entire session (commented in code)

### 5. Protected Views in WEB-INF
Both JSP files are placed in `WEB-INF/view/`, making them inaccessible to direct client requests. They can only be reached via server-side forwards from servlets, ensuring session validation logic always runs first.

## How Sessions Work

1. **First Request:** Server creates `HttpSession`, generates unique ID, sends to client via `Set-Cookie: JSESSIONID=...`
2. **Subsequent Requests:** Client sends `Cookie: JSESSIONID=...` with each request
3. **Server:** Uses session ID to retrieve the same `HttpSession` object and access stored data
4. **Timeout:** Session expires after inactivity period (default: 30 minutes)
5. **Invalidation:** `session.invalidate()` immediately destroys the session

## Test Credentials

- **Username:** `raju`
- **Password:** `123456`

## Testing Scenarios

1. **Login:** Enter valid credentials → see home page
2. **Invalid Login:** Enter wrong credentials → remain on login page
3. **Session Persistence:** After login, navigate to `/login` directly → see home page (session active)
4. **Logout:** Click logout → return to login page
5. **Post-Logout:** Try accessing `/login` → see login form (session data removed)

## Technology Stack

- **Java:** 1.8
- **Web Module Version:** 2.3 (for `web.xml` support)
- **Server:** Apache Tomcat 9.0
- **IDE:** Eclipse IDE for Java EE
- **Project Type:** Dynamic Web Project

## Security Notes

- This is a learning project with hardcoded credentials
- Production apps should: validate against a database, hash passwords, use HTTPS, implement session timeout, and regenerate session IDs after login
