<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- * Scope is Very Important
     * Session is one of the most important Scope for a bean
     * If we use session in scope,a cookie is set on the browser and that cookie has a time-out which it might be 10min for Tomcat
     * We can change the time-out configuring web.xml
     *-->
	<jsp:useBean id="user3" class="beans.User" scope="request"></jsp:useBean>

	<jsp:setProperty name="user3" property="email" value="Hello@yahoo.com" />

	<jsp:setProperty name="user3" property="password" value="letmein" />
	
	<!--  Wont't Work because redirect will call 2nd request,and request can only take one request -->
	<% //response.sendRedirect("getRequestBean.jsp"); %>
	<!-- Forward will only replace the content ,it does not request--So it work's -->
	<jsp:forward page="getRequestBean.jsp"></jsp:forward>
<h2>Beans Set </h2>
</body>
</html>