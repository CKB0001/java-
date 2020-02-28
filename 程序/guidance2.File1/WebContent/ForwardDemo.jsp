<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
    	request.setAttribute("userName", "JSP Practice Referece Book");
    	pageContext.setAttribute("userName","JSP Practice Referece Book", pageContext.PAGE_SCOPE);
    %>
    <jsp:forward page="Forwarded.jsp"></jsp:forward>

</body>
</html>