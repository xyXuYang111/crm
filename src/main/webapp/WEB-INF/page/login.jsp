<%--
  Created by IntelliJ IDEA.
  User: cypc
  Date: 2019-5-8
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include.jsp" %>
<html>
<head>
    <title>MintLeaf-Fast登录</title>
</head>
<body>
<!--<video class="video-player" preload="auto" autoplay="autoplay" loop="loop" data-height="1080" data-width="1920" height="1080" width="1920">-->
<!--<source src="${contextPath}/static/images/login.mp4" type="video/mp4">-->
<!--&lt;!&ndash; 此视频文件为支付宝所有，在此仅供样式参考，如用到商业用途，请自行更换为其他视频或图片，否则造成的任何问题使用者本人承担，谢谢 &ndash;&gt;-->
<!--</video>-->
<img  class="video-player" height="100%" width="100%" src="${contextPath}/static/images/banner5.jpg">
<div class="video_mask"></div>
<div class="login">
    <h1>MintLeaf-Fast登录</h1>
    <form class="layui-form">
        <div class="layui-form-item">
            <input class="layui-input" name="username" value="root" placeholder="用户名" lay-verify="required" type="text" autocomplete="off">
        </div>
        <div class="layui-form-item">
            <input class="layui-input" name="password" value="123456" placeholder="密码" lay-verify="required" type="password" autocomplete="off">
        </div>
        <div class="layui-form-item form_code">
            <input class="layui-input" name="verifyCodeActual" placeholder="验证码" lay-verify="required" type="text" autocomplete="off">
            <div class="code"><img id="captcha_img" alt="点击更换" title="点击更换" onclick="refresh()" src="${contextPath}/captcha/getCaptcha.jpg" width="116" height="36"/></div>
        </div>
        <button class="layui-btn login_btn" lay-submit="" lay-filter="login">登录</button>
    </form>
</div>
</body>
<script type="text/javascript">
    function refresh() {
        document.getElementById('captcha_img').src="/captcha/getCaptcha.jpg?"+Math.random();
    }
    layui.use(['form','layer'],function(){
        var form = layui.form,
            layer = parent.layer === undefined ? layui.layer : parent.layer,
            $ = layui.jquery;

        var urls = {
            login: "/userLogin.do"
        };

        //video背景
        // $(window).resize(function(){
        //     if($(".video-player").width() > $(window).width()){
        //         $(".video-player").css({"height":$(window).height(),"width":"auto","left":-($(".video-player").width()-$(window).width())/2});
        //     }else{
        //         $(".video-player").css({"width":$(window).width(),"height":"auto","left":-($(".video-player").width()-$(window).width())/2});
        //     }
        // }).resize();

        //登录按钮事件
        form.on("submit(login)",function(data){
            $.ajax({
                url : urls.login,
                data :{
                    name:data.field.username,
                    password:data.field.password,
                    verifyCodeActual:data.field.verifyCodeActual
                },
                type : 'POST',
                success : function(obj) {
                    if (obj.code == 1) {
                        window.location.href ="/index.do";
                    }else{
                        layer.msg(obj.msg, {icon: 2});
                    }
                },
                error : function() {//失败处理函数
                    layer.msg('请求异常！', {icon: 2});
                }
            });
            return false;
        })

    });
</script>
</html>
