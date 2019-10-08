<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh">
<head>
	<meta charset="utf-8"/>
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<meta http-equiv="X-UA-Compatible" content="IE=7,IE=8,IE=9,IE=10"/>
	<meta name="renderer" content="webkit|ie-comp|ie-stand"/>
	<meta name="keywords" content="彼岸天图传,图片上传,上传图片,图片上传网站,上传图片,图片上传,怎么上传图片到百度,图片上传网站,淘宝上传图片">
	<meta name="description" content="彼岸天图传,图片上传,上传图片,图片上传网站,上传图片,图片上传,怎么上传图片到百度,图片上传网站,淘宝上传图片">
	<meta charset="utf-8"/>
	<title>彼岸天图传</title>
	<link rel="stylesheet" href="${contextPath}/statics/layui/css/layui.css"/>
	<link rel="stylesheet" href="${contextPath}/statics/css/main.css"/>

	<script type="text/javascript" src="${contextPath}/statics/js/options.js"></script>
	<script type="text/javascript" src="${contextPath}/statics/layui/jquery-3.2.1.min.js"></script>
	<script src="${contextPath}/statics/layui/layui.js"></script>
	<script type="text/javascript" src="${contextPath}/statics/layui/lay/modules/upload.js"></script>
	<script type="text/javascript" src="${contextPath}/statics/js/crypto.js"></script>
	<script type="text/javascript" src="${contextPath}/statics/js/token.js"></script>
	<script type="text/javascript" src="${contextPath}/statics/js/qiniu.min.js"></script>
	<script type="text/javascript" src="${contextPath}/statics/js/main.js"></script>
	<script type="text/javascript" src="${contextPath}/statics/js/file.js"></script>

</head>

	<body>
		<header>
			<ul class="layui-nav">
				<li class="logo" >
					<a href="${contextPath}/indexPage.do">花開彼岸天</a>
				</li>
				<li class="layui-nav-item" >
					<a href="${contextPath}/loggerIndex.do">日志清单</a>
				</li>
				<li class="layui-nav-item">
					<a href="${contextPath}/loggerSqlList.do">sql日志</a>
				</li>
				<li class="layui-nav-item">
					<a href="${contextPath}/loggerMongoDBList.do">mongoDB日志</a>
				</li>
				<li class="layui-nav-item">
					<a href="${contextPath}/loggerErrorList.do">redis错误日志</a>
				</li>
				<li class="layui-nav-item">
					<a href="${contextPath}/loggerRequestList.do">redis请求日志</a>
				</li>
			</ul>
		</header>
		
		<div class="main" id="container">
			<h1>
				<a href="${contextPath}/fileIndex.do">
					系统日日志
				</a>
			</h1>
		</div>
		<footer>
			<p>Copyright Ⓒ 2018 Cat
				<a href="http://www.lihail.cn/">www.lihail.cn</a> All rights reserved. 请勿上传违反中国大陆和香港法律的图片，违者后果自负。</p>
		</footer>
	</body>
</html>