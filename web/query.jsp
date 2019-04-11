<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/14
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table border="1px" >
        <tr>
            <td>id</td>
            <td>name</td>
            <td>action</td>
        </tr>

       <c:forEach var="book" items="${all}">
           <tr>
               <td>${book.id}</td>
               <td>${book.name}</td>


               <td>
                   <a href="BookServlet?action=delete&id=${book.id}">delete</a>
                   <a href="BookServlet?action=queryOne&id=${book.id}">update</a>
               </td>
           </tr>
       </c:forEach>
    </table>
    <a href="add.jsp">add</a>
</body>
</html>
