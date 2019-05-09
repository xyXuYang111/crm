<%--
  Created by IntelliJ IDEA.
  User: cypc
  Date: 2019-5-9
  Time: 8:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>测试验证码</title>
    <script type="text/javascript">
        function refresh() {
            document.getElementById('captcha_img').src="/captcha/getCaptcha.jpg?"+Math.random();
        }
    </script>
</head>
<body>
<form action="/captcha/test.do" method="post">
    验证码:  <input type="text" placeholder="请输入验证码" name="verifyCodeActual">
    <div class="item-input">
        <img id="captcha_img" alt="点击更换" title="点击更换"
             onclick="refresh()" src="${contextPath}/captcha/getCaptcha.jpg" />
    </div>
    <input type="submit" value="提交" />
</form>

</body>
</html>