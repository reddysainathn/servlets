<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<%
		/* Directive Tag*/
	%>

	<!-- Page Directive (Pages will be loaded)-->
	<%@ page import="java.util.*"%>


	<%
		/* Expression Tag(Expressions can be written Here,Mainly to print)*/
	%>
	<%="Hello From Expression Tag<br>"%>
	<%=new Date()%>

	<%
		/* Declaration Tag*(We can declare JAVA code Here)*/
	%>
	<%!private String info = "<br>Some Info from Delcaration Tag";%>
	<%=info%>

	<%
		/* Scriptlet Tag(We can put some methods here)*/
	%>
	<%
		for (int i = 0; i <= 5; i++) {
	%>

	This is Looped.
	<p></p>

	<%
		}
	%>


</body>
</html>