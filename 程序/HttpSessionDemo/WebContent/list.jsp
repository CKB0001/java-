<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="com.bookBean.*,com.bookDOM.*,java.util.*,com.servelt.*"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<title>Insert title here</title>
<%
	List<Book> list = (List<Book>)request.getAttribute("list"); 
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
   	 int n=list.size();
   	 int i=0;
		System.out.print(n);
		Book accessCount[]=new Book[n];
        for(Book book:list){
     %>
     <tr>
        <td><%=book.getId()%></td>
        <td><%=book.getBookname()%></td>
        <td><%=book.getAuthor() %> </td>
        <td><%=book.getPublisher() %></td>
        <td><%=book. getPrice() %></td>
        <td><%=book.getNum() %></td>
       	<td>    
			     <a href="AddshoppingServelt?id=<%=book.getId() %>">加入购物车</a>>
       		
		</td>
     </tr>
    <%
        }
    %>
    <tr>
    	<td><input name="pclog" type="button" align="middle" value="返回" onClick="location.href='function.jsp'"></td>
    </tr>
    </tbody>
   </table>
</body>
</html>