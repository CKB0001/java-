<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<%!
    	int i=0;
%>
<%
  out.println("i="+i++);
%>

 <%
    	out.println("<h1>3和5中较大的是"+max(3,5)+"</h1>");
 %>
 <%!
    	public int max(int a, int b){
    		if (a>b){
    			return a;
    		}
    		return b;
    	}
 %>


</body>
</html>