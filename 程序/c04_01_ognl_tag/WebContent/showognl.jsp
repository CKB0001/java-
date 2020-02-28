<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Struts2 OGNL与标签应用示例</title>
</head>
<body>
	<h3>（1）读取ObjectStack里的对象的属性</h3>
	Person={姓名：
	<s:property value="person.name" />
	， 年龄：
	<s:property value="person.age" />
	， 出生日期：
	<s:property value="person.birthday" />
	}	
</body>
</html>