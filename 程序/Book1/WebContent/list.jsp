<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border=1 cellpadding="10" cellspacing="0">
	     <thead>
	          <tr>
	             <th>编号</th>
	             <th>书名</th>
	             <th>作者</th>
	             <th>出版社</th>
	             <th>价格</th>
	          </tr>
	      </thead> 
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
</body>
</html>