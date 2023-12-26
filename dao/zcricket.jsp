<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Button Page</title>
</head>
<body>
<h2>Welcome, User!</h2>

<%
// Retrieving user and password parameters from the request
String user = request.getParameter("user");
String password = request.getParameter("password");

// Displaying the received parameters
out.println("<p>User: " + user + "</p>");
out.println("<p>Password: " + password + "</p>");
%>

<br><br>
<button onclick="window.location.href='live_score.jsp'">Live Score</button>
<button onclick="window.location.href='Zschedule.html'">Schedule</button>
<button onclick="window.location.href='last_match.jsp'">Last Match Score</button>
</body>
</html>