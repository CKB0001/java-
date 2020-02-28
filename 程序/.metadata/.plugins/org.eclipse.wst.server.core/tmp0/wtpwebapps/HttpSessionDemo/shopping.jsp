<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="com.bookBean.*,com.bookDOM.*,java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<%

List<Book> list =(List<Book>)request.getAttribute("list");

%>
<body>
<table border=1 cellpadding="10" cellspacing="0">
     <thead>
          <tr>
             <th>书籍编号</th>
             <th>书名</th>
             <th>作者</th>
             <th>出版社</th>
             <th>价格</th>
             <th>书籍剩余库存的数量</th>
          </tr>
      </thead>
    <tbody>
    <%
  
        for(Book book:list){
     %>
     <tr>
        <td><%=book.getId()%></td>
        <td><%=book.getBookname()%></td>
        <td><%=book.getAuthor() %> </td>
        <td><%=book.getPublisher() %></td>
        <td><%=book.getPrice() %></td>
        <td><%=book.getNum() %></td>        
     
     </tr>
    <%
       }
    %>
    <tr>
    	<td><input name="pclog" type="button" align="middle" value="返回" onClick="location.href='ListBookServelt'"></td>
    </tr>
    </tbody>
   </table>
</body>
</html>