<%--
  Created by IntelliJ IDEA.
  User: cypc
  Date: 2019-5-5
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>目录添加</title>
</head>
<body>
<form action="/insertMenu.do" method="post">
    <textarea name="menuName" id="menuName" rows="2" cols="5"/><br>
    <textarea name="menuUrl" id="menuUrl" rows="2" cols="5"/><br>
    <textarea name="parentID" id="parentID" rows="2" cols="5"/><br>
    <input type="submit" name="创建"/>
</form>
</body>
</html>
