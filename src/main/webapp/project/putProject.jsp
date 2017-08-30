<%--
  Created by IntelliJ IDEA.
  User: WU
  Date: 2017/8/29
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script type="text/javascript" src="../resources/js/jquery-3.1.1.js"></script>
    <title>输入项目信息</title>
    <script type="text/javascript">
       var req=new XMLHttpRequest();
       function queryInfo() {
           //设置传送方式，对应Controllor路径，是否异步处理
           req.open("POST","/User/selectUser",true);
           //如果设置数据传送方式为post.则必须设置请求头信息
           req.setRequestHeader("Content-type","application/x-www-form-urlencoded");
           //设置回调函数，当前操作完成后进行的操作
           req.onreadystatechange = callback;

           //Ajax请求发送的数据不是表单,需要拼接数据,格式跟get方式一样
           var reqData = "uName="+document.getElementById("uName").value();

           //发送请求
           req.send(reqData);

       }
    </script>

</head>
<body>
<form action="/project/putProject" method="post">
    <div>
        <tr>
            <td>项目名称</td>
            <td><input type="text" name="pName"></td>
        </tr>
        <br>
        <tr>
            <td>项目描述</td>
            <td><input type="text" name="pDescribe"></td>
            <td><input type="checkbox" name="pSensitive" value="1">是否屏蔽敏感词汇</td>
        </tr>
        <br>
        <tr>
            <td>是否公开</td>
            <td><input type="radio" value="0" name="ispublic" checked="checked">公开</td>
            <td><input type="radio" value="1" name="ispublic">私密</td>
        </tr>
        <br>
        <tr>
            <td>添加组员</td>
            <td><input type="text" id="uName" name="uName"></td>
            <td><button  id="selectUser" onclick="queryInfo()" >查询</button></td>
        </tr>
        <br>
        <tr>
            <c:forEach items="${userList}" var="user">
               <input type="checkbox" name="selectUser" value="${user.UName}">
                <span>${user.UName}</span>
            </c:forEach>
        </tr>
        <br>
        <div>

        </div>
        <br>
      <tr>
          <input type="submit" value="提交">
      </tr>


    </div>
</form>
</body>
</html>
