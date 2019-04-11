<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-4-11
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
      response.sendRedirect(request.getContextPath()+"/BookServlet?action=query");
  %>
  </body>
</html>
