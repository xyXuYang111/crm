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
	<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/main.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/file.js"></script>

</head>

	<body>
		<header>
			<ul class="layui-nav">
				<li class="logo" >
					<a href="${pageContext.request.contextPath}/indexPage.do">花開彼岸天</a>
				</li>
				<li class="layui-nav-item" >
					<a href="${pageContext.request.contextPath}/fileIndex.do">图传工具</a>
				</li>
				<li class="layui-nav-item">
					<a href="${pageContext.request.contextPath}/getFilesSqlList.do">通过sql查询方式</a>
				</li>
				<li class="layui-nav-item">
					<a href="${pageContext.request.contextPath}/getFilesMongoDBList.do">通过mongoDB查询方式</a>
				</li>
			</ul>
		</header>
		
		<div class="main" id="container">
			<h1>
				<a href="${pageContext.request.contextPath}/fileIndex.do">
					File Upload
				</a>
				<a href="javascipt()" class="delete">Delete</a>
			</h1>
			<section>
				<div id="uploader" class="layui-upload-drag">
					<div id="pickfiles">
						<i class="layui-icon"></i>
						<form action="${pageContext.request.contextPath}/fileTextUpload.do" enctype="multipart/form-data" method="post">
							<input type="file" name="file"/>
							<button type="submit" class="layui-btn">
								本地文件上传至服务器
							</button>
						</form>
					</div>
					<div id="showImg" style="display: none;">
						<img src="#" />
					</div>
				</div>
			</section>
			<div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
				<ul class="layui-tab-title">
					<li class="layui-this">URL</li>
					<li>Markdown</li>
					<li>HTML</li>
				</ul>
				<div class="layui-tab-content" style="height: 100px;">
					<div class="layui-tab-item layui-show">
						<input id="link" type="text" name="title" required lay-verify="required" placeholder="URL" autocomplete="off" class="layui-input" readonly="readonly">
					</div>
					<div class="layui-tab-item">
						<input id="markdown" type="text" name="title" required lay-verify="required" placeholder="Markdown" autocomplete="off" class="layui-input" readonly="readonly">
					</div>
					<div class="layui-tab-item">
						<input id="a-link" type="text" name="title" required lay-verify="required" placeholder="HTML" autocomplete="off" class="layui-input" readonly="readonly">
					</div>
				</div>
			</div>
			<div class="clear"></div>
		</div>
		<footer>
			<p>Copyright Ⓒ 2018 Cat
				<a href="http://www.lihail.cn/">www.lihail.cn</a> All rights reserved. 请勿上传违反中国大陆和香港法律的图片，违者后果自负。</p>
		</footer>
		<form style="display: none;" class="layui-form" action="#">
		  <div class="layui-form-item">
		    <label class="layui-form-label">AK</label>
		    <div class="layui-input-block">
		      <input value="7oJHSC11-ZTQ8Vx8nZYC6gASfvHxhZwkJLfbPQmI" type="text" name="ak" id="ak" lay-verify="title" autocomplete="off" placeholder="请输入AccessKey" class="layui-input">
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">SK</label>
		    <div class="layui-input-block">
		      <input value="22atloGIfChSTyTrONAnoliMLONg-ZdOeod5SKju" type="text" name="sk" id="sk" lay-verify="required" placeholder="请输入SecretKey" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">Bucket</label>
		    <div class="layui-input-block">
		      <input value="liuziting" type="text" name="bucket" id="bucket" lay-verify="required" placeholder="请输入bucket" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  <div class="layui-form-item">
		    <label class="layui-form-label">域名</label>
		    <div class="layui-input-block">
		      <input value="tc.lihail.cn" type="text" name="domain" id="domain" lay-verify="required" placeholder="请输入域名" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		   <div class="layui-form-item">
		    <div class="layui-input-block">
		      <button id="save" class="layui-btn save" >立即提交</button>
		    </div>
		  </div>
		</form>
	</body>
</html>