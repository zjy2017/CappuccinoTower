<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2017/8/29
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改邮箱</title>
</head>
<body>
<form action="/User/udpateEmail" method="post">
    <table>
        <tr>
            <td>输入密码</td>
            <td><input type="password" name="uPassword"/></td>
        </tr>
        <tr>
            <td>新邮箱</td>
            <td><input type="text" name="uEmail"/></td>
        </tr>
        <tr>
            <td><input type="submit" name="submit" value="保存"></td>
        </tr>
    </table>
</form>
</body>
</html>
