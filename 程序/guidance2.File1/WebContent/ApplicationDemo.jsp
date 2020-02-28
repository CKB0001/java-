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
    	Integer i = 0;
    	i = (Integer) application.getAttribute("count");
    	if (null == i){
    		application.setAttribute("count", 1);
    		out.println("<h1>你是第1位访问者</h1>");
    	}else{
    		++i;
    		application.setAttribute("count",i);
    		out.println("<h1>你是第"+i+"位访问者</h1>");
    	}
   %>

</body>
</html>