<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主菜单界面</title>
</head>
<body>
<form method="post" action="listall">
<input type="submit" value="查看用户信息" />
</form>
<input name="pclog" type="button" align="middle" value="修改用户密码" onClick="location.href='update.jsp'">
<input name="pclog" type="button" align="middle" value="删除用户" onClick="location.href='delete.jsp'">
<input name="pclog" type="button" align="middle" value="添加用户" onClick="location.href='register.jsp'">
</body>
</html>