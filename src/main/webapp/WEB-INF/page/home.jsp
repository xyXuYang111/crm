<%--
  Created by IntelliJ IDEA.
  User: cypc
  Date: 2019-5-9
  Time: 8:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include.jsp" %>
<head>
    <meta charset="UTF-8">
    <meta content="text/html;charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta http-equiv ="Pragma" content = "no-cache"/>
    <meta http-equiv="Cache-Control" content="no cache" />
    <meta http-equiv="Expires" content="0" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"/>
    <meta name="apple-mobile-web-app-status-bar-style" content="black"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="format-detection" content="telephone=no"/>
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space10">
        <div class="layui-col-md12">
            <blockquote class="layui-elem-quote">
                <span style="color: #FF5722;">MintLeaf-Fast</span>是一个基于SpringBoot2.0开发的，轻量级的，前后端分离的Java快速开发平台。开箱即用，节省开发时间，提升开发效率，能够快速开发项目并交付的接私活利器。代码简洁，注释丰富，上手容易，提供基础模块(用户管理，角色管理，菜单管理，代码生成等8个模块)，支持跨驱动多数据源,加强业务模块的扩展性。感兴趣可以Watch、Start持续关注项目最新状态。
            </blockquote>
            <blockquote class="layui-elem-quote layui-quote-nm">
                <p>
                    <a href='https://gitee.com/mintleaf/mintleaf-fast/stargazers'><img src='https://gitee.com/mintleaf/mintleaf-fast/badge/star.svg?theme=dark' alt='star'></img></a>
                    <a href='https://gitee.com/mintleaf/mintleaf-fast/members'><img src='https://gitee.com/mintleaf/mintleaf-fast/badge/fork.svg?theme=dark' alt='fork'></img></a><br><br>
                    个人兴趣爱好，整理自己所掌握的技术，并随着技术掌握程度，不定期更新优化。希望此实际项目，能给需要的朋友带来价值,有你们的支持和关注，我的动力将不会衰减，一步步的将项目完善开发下去，定期加入新技术与功能。
                </p>
            </blockquote>
        </div>

        <div class="layui-col-md6 layui-col-space5">
            <blockquote class="layui-elem-quote">
                版本更新记录
            </blockquote>
            <div class="layui-card-body layui-text">
                <script src='https://gitee.com/mintleaf/mintleaf-fast/widget_preview'></script>
                <style>
                    .pro_name a{color: #4183c4;}
                    .osc_git_title{background-color: #fff;}
                    .osc_git_box{background-color: #fff;}
                    .osc_git_box{border-color: #E3E9ED;}
                    .osc_git_info{color: #666;}
                    .osc_git_main a{color: #9B9B9B;}
                </style>
            </div>
        </div>
        <div class="layui-col-md6 layui-col-space5">
            <blockquote class="layui-elem-quote">
                图表
            </blockquote>
            <div id="main" style="width: 100%;height:400px;"></div>
        </div>
    </div>
</div>
<script type="text/javascript" src="${contextPath}/static/scripts/home/index.js"></script>
</body>
</html>

