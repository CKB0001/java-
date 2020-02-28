<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>阶乘值</title>
</head>
<body>
<%
	String number=request.getParameter("num");
	int num=Integer.valueOf(number);
	long sum=1;
	
	if(num==0)
		
	{
		out.print("数字0的阶乘是1");
	}
	else
	{
		for(int i=1;i<=num;i++)
		{
			sum=sum*i;
		}
		out.print("数字"+num+"的阶乘是"+sum);
	}
%>
<form action="factorial.jsp">
<input type="submit" value="重新输入数字">
</form>
</body>
</html>