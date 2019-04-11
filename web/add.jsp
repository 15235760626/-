<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/14
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


    <form action="BookServlet">
        <input type="hidden" name="action" value="add">
        <table>
            <tr>
                <td>name</td>
                <td>
                    <input type="text" name="name" >
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="add" >
                    <input type="reset" value="reset">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
