<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<sql:setDataSource var="mysqlDS" driver="org.gjt.mm.mysql.Driver" 
url="jdbc:mysql://localhost:3333/world" 
user="root" 
password="root"/>

<sql:query var="queryResult" dataSource="mysqlDS">

select * from product;
</sql:query>

<c:forEach items="${queryResult.rows }" var="record">

<c:out value="${record.product_id }"></c:out>
<c:out value="${record.product_name }"></c:out>
<c:out value="${record.product_description}"></c:out>
<c:out value="${record.product_price }"></c:out>
</c:forEach>


</body>
</html>