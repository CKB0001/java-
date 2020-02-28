<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
  <% System.out.println(this.getServletContext().getContextPath());
  String prjurl=this.getServletContext().getContextPath();
  %>

<html>
<head>
<title>登录界面</title>
</head>
<body>
	<form method="post" action="logincheck">
		<table>
			<tr>
				<th colspan="2">用户登录</th>
			</tr>
			<tr>
				<td align="right">用户名：</td>
				<td><input type="text" name="user.userName" /></td>
			</tr>
			<tr>
				<td align="right">密码：</td>
				<td><input type="password" name="user.userPassword" /></td>
			</tr>
			<tr>
				<td align="left"><input type="submit" value="登录" /></td>
				<td>未注册者，请先注册，单击 <a href="<%=prjurl%>register.jsp">注册</a></td>
			</tr>

		</table>
	</form>
	<br>
</body>
</html>
