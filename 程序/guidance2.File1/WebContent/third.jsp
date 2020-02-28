<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
    	int grade = 80;
    	switch(grade/10){
    	case 10:;
    	case 9:
    %>
    	<h1>你的成绩为优秀！</h1>
    <%
    	break;
    	case 8:;
    	case 7:
    %>
    	<h1>你的成绩为良好！</h1>
    <%
    	break;
    	case 6:
    %>
    	<h1>你的成绩为及格！</h1>
    <%
    	break;
    	default:
    %>
    	<h1>你的成绩为不及格！</h1>
    <%} %>

</body>
</html>