<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Struts2 OGNL与标签应用示例</title>
</head>
<body>	
	<h3>（3）构造Map，并显示其信息</h3>
	<s:set name="foobar" value="#{'foo1':'bar1','foo2':'bar2'}" />
	The value of key "foo1" is
	<s:property value="#foobar['foo1']" /><br>
	<h3>（4）创建list 集合，并且遍历出集合中的值</h3>	
	<s:set name="list" value="{'eeeee','ddddd','ccccc','bbbbb','aaaaa'}"></s:set>
	<s:iterator value="#list" var="a">		
		<s:property value="a" />	<br>		
	</s:iterator>
	
	<br>	
	<hr />
</body>
</html>