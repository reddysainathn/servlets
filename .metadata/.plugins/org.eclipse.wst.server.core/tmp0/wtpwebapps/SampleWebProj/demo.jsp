<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<%//ForToken %>



<c:set var="a" value="100"></c:set>
<c:choose>

<c:when test="${a==10 }">A value is 100</c:when>
<c:when test="${a==15 }">A value is 15</c:when>
<c:otherwise>Default Case</c:otherwise>
</c:choose>


</body>
</html>