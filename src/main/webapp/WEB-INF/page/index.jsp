<%--
  Created by IntelliJ IDEA.
  User: xuy
  Date: 2019/5/4
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>许洋的crm系统</title>
</head>
<body>
<c:choose>
    <c:when test="${menuList ne null && fn:length(menuList) gt 0}">
        <c:forEach items="${menuList}" var="item" varStatus="stat">
            <button><c:out value="${stat.index + 1 }"/><a href="${item.menuUrl}"><c:out value="${item.menuName}"/></a></button>
        </c:forEach>
    </c:when>
    <c:otherwise>
        没有相关的文件目录，<button><a hrf="getInsertMenu.do">点我创建</a></button>
    </c:otherwise>
</c:choose>
</body>
</html>
