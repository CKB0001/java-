<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3 align="center">客户信息管理系统</h3>
<form action="ListCustomerServlet" method="post">
	<fieldset>显示所有客户信息&emsp;&emsp;<input type="submit" value="确定"></fieldset>	
	<fieldset>添加客户信息&emsp;&emsp;&emsp;&emsp;<input name="pclog" type="button" align="middle" value="确定" onClick="location.href='add.jsp'"></fieldset>
	<fieldset>修改客户信息&emsp;&emsp;&emsp;&emsp;<input name="pclog" type="button" align="middle" value="确定" onClick="location.href='alter.jsp'"></fieldset>
	<fieldset>删除客户信息&emsp;&emsp;&emsp;&emsp;<input name="pclog" type="button" align="middle" value="确定" onClick="location.href='delete.jsp'"></fieldset>	
</form>
</body>
</html>

