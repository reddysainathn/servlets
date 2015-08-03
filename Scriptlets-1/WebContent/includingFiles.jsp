<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<!-- Static Include--Conent changes Frequently -->
	<%@ include file="copyright.txt"%>

	<p />

	<!-- Dynamic Include--Content Changes a Lot -->
	<jsp:include page="updates.txt"></jsp:include>


	<!--  Most used STATIC include if it's got JAVA code in it that we want to access -->
	<!--  If you want variables from JAVA code in include we should only use include -->

	<%@ include file="variables.jsp"%>

	<p />

	<%=name%>
	<!--  Must use include JSP tage ,if you don't knowwhat file you want till run time -->
	<p />
	<strong><jsp:include page="parameters.jsp"></jsp:include></strong>
	<p />
	<%@include file="manupulations.jsp"%>

	<%
		String ids = request.getParameter("ids");
	%>
	<p />
	<%
		if (ids == null) {
	%>
	<br><jsp:include page="idNotFound.html"></jsp:include>;
	<%
		} else {
	%>
	<br><jsp:include page="idFound.html"></jsp:include>;
	<%
		}
	%>

</body>
</html>