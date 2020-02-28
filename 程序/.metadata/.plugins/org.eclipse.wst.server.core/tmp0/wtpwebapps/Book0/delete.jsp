<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>删除用户</title>
</head>
<body>
<h3 align="left">删除用户，请认真填写用户删除信息</h3>
	<form name="delete" action="delete" method="post" >
		<table>
			<tr>
				<td align="right">删除用户的账户名：</td>
				<td><input type="text" name="user.userName" id="username"></td>
			</tr>
			<tr>
				<td align="right">删除用户的密码：</td>
				<td><input type="password" name="user.userPassword" id="userpassword"></td>
			</tr>
			<tr>
				<td align="right"><input type="submit" value="提交"></td>
				<td colspan="2"><input type="reset" value="重新填写"></td>
			</tr>
		</table>
	</form>
</body>
</html>