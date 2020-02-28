<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title>登录成功</title>
</head>
<body>

     <s:bean name="java.util.Date" var="d">
     	<s:param name="date" value="10"></s:param>
     </s:bean>
     <s:date name="#d" nice="false" var="abc"/>
      	系统时间为：<s:property value="#abc"/>    	
  <form action="bookall" method="post">	  	 
     <table border=1 cellpadding="10" cellspacing="0">
                  欢迎你，<input type="text" value="${user.userRealName}" name ="user.userRealName" readonly> ，你登入成功！！<br> 
    	${ s }
	       <tbody>
			  <s:iterator value="booklist" var="a">		
					<tr> 
						<td><s:property value="#a.bookid" />	</td>
						<td><s:property value="#a.title" />	</td>
						<td><s:property value="#a.author" />	</td>
						<td><s:property value="#a.publisher" />	</td>
					    <td><s:property value="#a.price" />	</td>
					</tr>			
			  </s:iterator>
		  </tbody>		  
	  </table>
 	  <input type="submit" value="查看所有书籍">
 	 
  </form>
	 <form action="findbookname"method="post">
     	 	<input type="text" name="bookname" >
      		<input type="submit" value="根据书名查找">
      </form>
      	
      <form action="findbookauther"method="post">
    	    <input type="text" name="auther" >
      		<input type="submit" value="根据作者查找">
    	</form>
</body>
</html>
