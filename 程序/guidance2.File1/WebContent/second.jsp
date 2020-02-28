<%@ page language="java" import="java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1><%=max(3,5) %></h1>
<h1><%=(i+a+c)/3 %></h1>
<h1><%=date.toString() %></h1>
<%!
    	public int max(int a, int b){
    		if (a>b){
    			return a;
    		}
    		return b;
    	}
		int i = 3, a = 5, c=4;
		Date date = new Date();
%>


</body>
</html>