<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
<style>
.demo2-bg{
    background: url(../img/main.jpg) no-repeat;
    background-size: cover;
    width: 100%;
    height: 600px;
    position: relative;/* 父div*/
}
.demo2{/*子div*/
    position: absolute;
    left: 0;
    right: 0;
    top: 0;
    bottom: 0;
    width: 500px;
    height: 300px;
    
    text-align: center;
    margin: auto;
    background:rgba(255,255,255,0.3);  }
.button2
			{
			background-color:#FFD700; 
		    border: none;
		    color: white;
		    padding:  8px 10px;
		    text-align: center;
		    text-decoration: none;
		    display: inline-block;
		    font-size: 16px;
		    line-height:16px;
		     box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19)
			}
	.button1
	       {
			background-color:#ed1941; 
		    border: none;
		    color: white;
		    padding:  8px 10px;
		    text-align: center;
		    text-decoration: none;
		    display: inline-block;
		    font-size: 16px;
		    line-height:16px;
		     box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19)
			}

</style>
<script type="text/javascript">    
	function isValidate(form) {		
		var username=document.getElementById("username").value;			
		var userpass=document.getElementById("userpassword").value;		
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

<body class="demo2-bg">
<div class="demo2">
	<h3 align="left">欢迎注册我们的系统，请认真填写您的信息</h3>
	<form name="register" action="register" method="post" onsubmit="return isValidate()">
		<table>
			<tr>
				<td align="right">账户名：</td>
				<td><input type="text" name="user.u_name" id="username" style="width:200px;height:20px"></td>
			</tr>
			<tr>
				<td align="right">为您的账户设置密码：</td>
				<td><input type="password" name="user.u_password" id="userpassword" style="width:200px;height:20px"></td>
			</tr>

			<tr>
				<td align="right">再次确认您的密码：</td>
				<td><input type="password" name="userpass1" id="userpass1" style="width:200px;height:20px"></td>
				<td></td>
			</tr>
			<tr>
				<td align="right"><input class="button1" type="submit" value="提交"></td>
				<td ><input class="button2" type="reset" value="重新填写"></td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>
