<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码界面</title>

<style>
.demo2-bg{
    background: url(../img/密改.jpg) no-repeat;
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
    line-height: 50px;
    text-align: center;
    margin: auto;
    background:rgba(255,255,255,0.3);  
}

.button1{
	background-color:#00a6ac; 
    border: none;
    color: white;
    padding: 8px 10px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    
     box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19)
}
.button2{
 	background-color:#ed1941; 
    border: none;
    color: white;
    padding:  8px 10px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
     box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19)
}
</style>
</head>

<body class="demo2-bg" style="font-size:20px font-family:微软黑体;">
<div class="demo2" >

	<form name="alternewpassword" action="alternewpassword" method="post" onsubmit="return isValidate()">

				<h2 style="color:white;">请输入修改信息：</h2>
				
				<div><input type="text" placeholder="用户名：" name="user.u_name" id="username" style="width:300px;height:30px">
				</div>
				<div><input type="password" name="user.u_password" id="userpassword" placeholder="原有密码："style="width:300px;height:30px">
				</div>
				<div><input type="password" name="newpassword" id="newpassword" placeholder="新密码："style="width:300px;height:30px">
				</div>			
				<div><input type="password" name="userpass1" id="userpass1" placeholder="再次确认您的密码："style="width:300px;height:30px">
				</div>
			
				<div><input class="button1" type="submit" value="提交" >
				<input class="button2" type="reset" value="清空" ></div>
		
	</form>
</div>
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
</body>
</html>
