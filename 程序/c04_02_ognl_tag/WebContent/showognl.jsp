<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Struts2 OGNL与标签应用示例</title>
</head>
<body>
	<h3>（2）访问OGNL上下文和Action上下文——使用OGNL访问属性值</h3>
	parameters：
	<s:property value="#parameters.msg" />
	<br> request.msg：
	<s:property value="#request.msg" />
	<br> session.msg：
	<s:property value="#session.msg" />
	<br> application.msg：
	<s:property value="#application.msg" />
	<br> attr.msg：
	<s:property value="#attr.msg" />
	<br>aaaaaxxyy:<s:property value="x2" />	
</body>
</html>