<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%out.println(session.getAttribute("NAME")); %>
<%out.println(session.getAttribute("MARKS1")); %>
<%out.println(session.getAttribute("MARKS2")); %>
<%out.println(session.getAttribute("MARKS3")); %>
</body>
</html>