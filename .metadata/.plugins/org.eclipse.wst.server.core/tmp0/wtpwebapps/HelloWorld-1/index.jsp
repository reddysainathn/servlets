<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
Anything between scriptlest is just uses .goGet() and .doPost() Methods<br>
</head>
<body>
Hello World
<br>

<%@ page import="java.util.*,gui.*" %>


<%= 
new Date() %>

<%

TextOutput testOutput = new TextOutput();
out.println(testOutput.getInfo());



%>
</body>
</html>