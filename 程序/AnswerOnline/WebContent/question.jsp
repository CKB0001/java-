<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>欢迎使用网上答题系统</title>
</head>
<body>
<form action="answer.jsp">
	一、5+5=？&nbsp;(1分)<br>
	&nbsp;&nbsp;<input type="radio" name="r1" value="3">3
 	&nbsp;&nbsp;<input type="radio" name="r1" value="4">4
	&nbsp;&nbsp;<input type="radio" name="r1" value="8">8
	&nbsp;&nbsp;<input type="radio" name="r1" value="10">10<br>
	二、下列哪些是奇数？&nbsp;(3分 多选少选均不给分)<br>
	&nbsp;&nbsp;<input type="checkbox" name="r2" value="3">3
    &nbsp;&nbsp;<input type="checkbox" name="r2" value="4">4
	&nbsp;&nbsp;<input type="checkbox" name="r2" value="5">5
	&nbsp;&nbsp;<input type="checkbox" name="r2" value="6">6<br>
	三、下列哪些是动态网页？&nbsp;(2分)<br>
	<select size="4"name="r3"multiple="multiple">
		<option value="asp">ASP</option>
		<option value="php">PHP</option>
		<option value="htm">HTML</option>
		<option value="jsp">JSP</option>
		<option value="xyz"selected="selected">XYZ</option>
	</select><br>
	四、下列组件哪个是服务器端的？&nbsp;(2分)<br>&nbsp;&nbsp;
	<select size="1" name="r4">
		<option value="jsp">JSP</option>
		<option value="servlet">SERVLET</option>
		<option value="java">JAVA</option>
		<option value="jdbc">JDBC</option>
	</select><br>
	五、在服务器端用来接受用户请求的对象是：&nbsp;(1分)<br>
	<input type="text" size="20" name="text1"><br>
	六、请说出下面图片中汽车的颜色&nbsp;(1分)<br>
	<img  src="ckb.jpg"width="20%"><br>
	&nbsp;&nbsp;<input type="radio" name="r6" value="绿色">绿色
	&nbsp;&nbsp;<input type="radio" name="r6" value="红色">红色
	&nbsp;&nbsp;<input type="radio" name="r6" value="黑色">黑色
	&nbsp;&nbsp;<input type="radio" name="r6" value="蓝色">蓝色<br>
	<div align="left">
		<input type="submit" value="提交" name="button1">
		<input type="reset" value="重置" name ="button2">
	</div>

</form>
</body>
</html>