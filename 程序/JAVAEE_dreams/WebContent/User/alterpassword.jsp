<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码界面</title>
<script type="text/javascript">    
	function isValidate(form) {		
		var username=document.getElementById("username").value;			
		var userpass=document.getElementById("newpassword").value;		
		var userpass1=document.getElementById("userpass1").value;		
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
</head>

<body>
	<form name="alternewpassword" action="alternewpassword" method="post" onsubmit="return isValidate()">
		<table>
			<tr>
				<td align="right">用户名：</td>
				<td><input type="text" name="user.u_name" id="username"></td>
			</tr>
			<tr>
				<td align="right">原有密码：</td>
				<td><input type="password" name="user.u_password" id="userpassword"></td>
			</tr>
			<tr>
				<td align="right">新密码：</td>
				<td><input type="password" name="newpassword" id="newpassword"></td>
			</tr>
			<tr>
				<td align="right">再次确认您的密码：</td>
				<td><input type="password" name="userpass1" id="userpass1"></td>
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
