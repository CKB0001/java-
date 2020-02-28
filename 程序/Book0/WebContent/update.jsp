<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript">    
	function isValidate(form) {		
		var username=document.getElementById("username").value;			
		var userpass=document.getElementById("newpassword").value;		
		var userpass1=document.getElementById("newpassword1").value;		
		if (userpass != userpass1) {
			alert("两次密码输入不一致，请重新输入！");			
			return false;
		}else if (userpass.length<=0 ||username.length<=0 ) {
			alert("用户名 以及密码不能为空，请重新输入！");			
			return false;
		}else{
			return true;
		}        
	}
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3 align="left">修改密码，请认真填写</h3>
	<form name="update" action="update" method="post" onsubmit="return isValidate()">
		<table>
			<tr>
				<td align="right">用户的账户名：</td>
				<td><input type="text" name="user.userName" id="username"></td>
			</tr>
			<tr>
				<td align="right">用户的原密码：</td>
				<td><input type="password" name="user.userPassword" id="userpassword"></td>
			</tr>
			<tr>
				<td align="right">为您的账户设置新密码：</td>
				<td><input type="password" name="newpassword" id="newpassword"></td>
			</tr>

			<tr>
				<td align="right">请再次确认您的新密码：</td>
				<td><input type="password" name="newpassword1" id="newpassword1"></td>
				<td></td>
			</tr>
			<tr>
				<td align="right"><input type="submit" value="提交"></td>
				<td colspan="2"><input type="reset" value="重新填写"></td>
			</tr>
		</table>
	</form>
</body>
</html>