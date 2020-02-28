<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>梦的浏览与查询</title>

<style>
.demo2-bg{
    background: url(img/dan1.jpg) no-repeat;
    background-size: cover;
    width: 100%;
    height: 100%;
    position: relative;
}
.demo2{
    position: absolute;
    left: 0;
    right: 0;
    top: 0;
    bottom: 0;
    width: 100%;
    height: 100%;
    line-height: 50px;
    
    background:rgba(255,255,255,0.3);
}
</style>

</head>
<body class="demo2-bg" style="font-size:20px;font-family:微软黑体">
 <link href="https://cdn.bootcss.com/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
 <div class="demo2">
	<div >
	清梦主界面
	</div>
	<div style="margin:auto;width:346px; height:50px;">
	<form action="findDream" method="post">
			
			<div style="margin-bottom:30px;">
			<input type="radio" name="bid" value="1" checked="checked">全部&nbsp;
			<input type="radio" name="bid" value="2" >开心&nbsp;
			<input type="radio" name="bid" value="3" >悲伤&nbsp;
			<input type="radio" name="bid" value="4" >恐惧&nbsp;
			<input type="radio" name="bid" value="5" >愤怒<br>
			</div>
			<div style="margin-bottom:30px;">
			<input name="Dream.dreamname" type="text" style="height:33px;" value="${Dream.dreamname}"/> 
			<input class="btn btn-primary" type="submit" style="position:absolute;height:30px" value="搜梦" />
			</div>
	</form>
	</div>
	<div style="margin:auto;width:346px; height:50px;">
		<form action="User/alterpassword.jsp" method="post">
			<div align="center" class="one" style="float:left;margin-left:10px;">
			 	<input class="btn btn-success" type="submit" value="用户修改密码" >	
			</div>
		</form>
		
		<form action="time" method="post">
			<div align="center" class="two" style="float:left;margin-left:10px;">
			 	<input class="btn btn-info" type="submit" value="编写梦境" >	
			</div>
		</form>
	</div>
	<br>
	<br>
	
	<table align="center">
		</table>
		<table width="70%" border="0" cellpadding="3" cellspacing="1"
			align="center">
			<tr bgcolor="#8899cc">
				<td>标题</td>
				<td>睡觉时间</td>
				<td>睡醒时间</td>
				<td>操作</td>
			</tr>
			<s:iterator var="dream1" value="dreams" status="list">
				<tr>					
					<td><s:property value="#dream1.dreamname" /></td>
					<s:date name="#dream1.starttime" var="abc"/>
					<td><s:property value="#abc" /></td>
					<s:date name="#dream1.endtime" var="abc"/>
					<td><s:property value="#abc" /></td>
					
					<td><a class="btn btn-info" href="findiddreamtext?id=${dream1.id}">查看</a>
						<a class="btn btn-warning" href="findiddream?id=${dream1.id}">编辑</a>						
						<a class="btn btn-danger" onclick="return confirm('你确定要删除吗！！！！')" href="deleteDream?id=${dream1.id}" >删除</a></td>
				</tr>

			</s:iterator>
		</table>
		
		

</div>
</body>
</html>