<%--
  Created by IntelliJ IDEA.
  User: cypc
  Date: 2019-5-8
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MintLeaf-Fast</title>
    <%@ include file="include.jsp" %>
</head>
<body>
<div class="layui-layout layui-layout-admin">
    <!-- 顶部 -->
    <div class="layui-header">
        <a href="./index.html" class="layui-hide-xs">
            <div class="layui-logo" style="font-size:20px;color:white;text-shadow:1px 1px 1px #393D49;font-weight:bold">
                <img style="border-radius: 0;margin-bottom: 5px" src="${contextPath}/static/images/mintleaf.png" class="layui-nav-img">MintLeaf-Fast
            </div>
        </a>
        <a href="javascript:;" class="layui-hide-xs"><div class="fsSwitchMenu"><i class="fa fa-outdent"></i></div></a>

        <!-- 顶部菜单 -->
        <ul class="layui-nav layui-layout-left fsTopMenu" id="fsTopMenu" lay-filter="fsTopMenu">
        </ul>

        <ul class="layui-nav layui-layout-right">
            <!-- 天气信息 -->
            <div class="weather layui-hide-xs" style="color:#fff; float:left; margin:15px 0 0 50px;">
                <div id="tp-weather-widget"></div>
                <script>(function(T,h,i,n,k,P,a,g,e){g=function(){P=h.createElement(i);a=h.getElementsByTagName(i)[0];P.src=k;P.charset="utf-8";P.async=1;a.parentNode.insertBefore(P,a)};T["ThinkPageWeatherWidgetObject"]=n;T[n]||(T[n]=function(){(T[n].q=T[n].q||[]).push(arguments)});T[n].l=+new Date();if(T.attachEvent){T.attachEvent("onload",g)}else{T.addEventListener("load",g,false)}}(window,document,"script","tpwidget","//widget.seniverse.com/widget/chameleon.js"))</script>
                <script>tpwidget("init", {
                    "flavor": "slim",
                    "location": "WX4FBXXFKE4F",
                    "geolocation": "enabled",
                    "language": "zh-chs",
                    "unit": "c",
                    "theme": "chameleon",
                    "container": "tp-weather-widget",
                    "bubble": "disabled",
                    "alarmType": "badge",
                    "color": "#FFFFFF",
                    "uid": "U9EC08A15F",
                    "hash": "039da28f5581f4bcb5c799fb4cdfb673"
                });
                tpwidget("show");</script>
            </div>
            <li class="layui-nav-item layui-hide-xs">
                <a href="javascript:;">
                    <img src="${contextPath}/static/images/face.jpg" class="layui-nav-img">
                    ${user.userName}
                </a>
                <dl class="layui-nav-child">
                    <dd id="userRead" userid="${user.id}"><a href="javascript:;">个人资料</a></dd>
                    <dd id="editPsw"><a href="javascript:;">修改密码</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item layui-hide-xs"><a href="/loginOut.do"><i class="fa fa-sign-out"></i> 退出</a></li>
        </ul>
    </div>

    <!-- 左边菜单 -->
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree fsLeftMenu"  lay-filter="fsLeftMenu" id="fsLeftMenu">
            </ul>
        </div>
    </div>

    <!-- 右边内容区域 -->
    <div class="layui-body layui-form">
        <div class="layui-tab layui-tab-card fsTab" lay-filter="fsTab" lay-allowClose="true">

            <!-- 菜单导航 -->
            <ul class="layui-tab-title" id="fsTabMenu">
                <li class="layui-this" lay-id="52">
                    <i class="layui-icon">&#xe702;</i>
                    <cite>了解MintLeaf-Fast</cite>
                    <p class="layui-tab-close" style="display: none;"></p>
                </li>
            </ul>

            <!-- 内容 -->
            <div class="layui-tab-content">
                <div class="layui-tab-item layui-show">
                    <iframe src="/home.do"></iframe>
                </div>
            </div>
        </div>
    </div>

    <div class="layui-footer" style="background-color: #f9f9f9;border-top: 1px solid #f9f9f9;">
        <!-- 底部固定区域 -->
        <!--©2018 <a href="https://gitee.com/ZhangMengchu" target="_black">https://gitee.com/ZhangMengchu</a>  <button id="donate" class="layui-btn layui-btn-sm layui-btn-danger">捐赠作者</button>-->
        <p>
            <span style="color: #BAB0A0;">2018 &copy; Powered by <a href="http://39.106.153.65:8088/MintLeafNetCompany/html/index.html" style="color: #01AAED;" target="_blank">MintLeaf</a></span>
            <a href="javascript:void(0);" class="layui-btn layui-btn-sm layui-btn-danger" id="donate">捐赠作者</a>
            <a href="mailto:6153629@qq.com" class="layui-btn layui-btn-sm layui-btn-warm">给作者提意见</a>
        </p>
    </div>
</div>

<!-- 移动导航 -->
<div class="site-tree-mobile layui-hide">
    <i class="layui-icon">&#xe602;</i>
</div>
<div class="site-mobile-shade"></div>
</body>
</html>
