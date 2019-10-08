<%--
  Created by IntelliJ IDEA.
  User: 许洋
  Date: 2019/9/8
  Time: 2:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<!-- Mirrored from www.9416.cn/demo/lottery/admin/lottery.asp by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 07 Sep 2019 18:26:53 GMT -->
<!-- Added by HTTrack -->
<meta http-equiv="content-type" content="text/html;charset=utf-8"/><!-- /Added by HTTrack -->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>文件后台管理</title>
    <link rel="stylesheet" href="${contextPath}/statics/layui/css/layui.css"/>
    <link rel="stylesheet" href="${contextPath}/statics/css/main.css"/>

    <script src="${contextPath}/statics/layui/layui.js"></script>

</head>

<body>
<div class="layui-layout layui-layout-admin">


    <div class="layui-header">
        <div class="layui-logo">Lottery后台管理</div>

        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="${contextPath}/fileIndex.do">上传文件</a></li>
        </ul>
    </div>


    <div class="layui-main" style="padding: 15px;">
        <div class="layui-breadcrumb">
            <span>位置：</span>
            <a href="#">首页</a>
            <a href="#">文件列表</a>
        </div>

        <div class="layui-form">
            <table width="100%" class="layui-table">
                <thead>
                <tr>
                    <th>文件序号</th>
                    <th>文件名称</th>
                    <th>上传时间</th>
                    <th>文件类型</th>
                    <th>操作</th>
                </tr>
                </thead>
                <c:forEach items="${filesList}" var="list">
                    <tr>
                        <td>${list.fileID}</td>
                        <td>${list.fileName}</td>
                        <td>${list.createTime}</td>
                        <td>${list.fileType}</td>
                        <td><a href="${contextPath}/download.do?fileID=${list.fileID}">
                            <button class="layui-btn layui-btn-sm">
                                文件下载
                            </button>
                        </a></td>
                        <td>
                    </tr>
                </c:forEach>

            </table>
        </div>


    </div>
    <div class="layui-footer">
        <!-- 底部固定区域 -->
        ©9416.cn 版权所有
    </div>
</div>

</body>
</html>
