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
	<title>点滴列表</title>
	<link rel="stylesheet" href="../../../statics/layui/css/layui.css"/>
	<link rel="stylesheet" href="../../../statics/css/main.css"/>

	<script type="text/javascript" src="../../../statics/js/options.js"></script>
	<script type="text/javascript" src="../../../statics/layui/jquery-3.2.1.min.js"></script>
	<script src="../../../statics/layui/layui.js"></script>
	<script type="text/javascript" src="../../../statics/layui/lay/modules/upload.js"></script>
	<script type="text/javascript" src="../../../statics/js/crypto.js"></script>
	<script type="text/javascript" src="../../../statics/js/token.js"></script>
	<script type="text/javascript" src="../../../statics/js/qiniu.min.js"></script>
	<script type="text/javascript" src="../../../statics/js/main.js"></script>
	<script type="text/javascript" src="../../../statics/js/file.js"></script>

</head>

	<body>
		<header>
			<ul class="layui-nav">
				<li class="logo" >
					<a href="/indexPage.do">花開彼岸天</a>
				</li>
				<li class="layui-nav-item" >
					<a href="/messageIndex.do">点滴列表</a>
				</li>
				<li class="layui-nav-item">
					<a href="/getMessageSqlList.do">通过sql查询方式</a>
				</li>
				<li class="layui-nav-item">
					<a href="/getMessageMongoDBList.do">通过mongoDB查询方式</a>
				</li>
			</ul>
		</header>

		<div class="main" id="container" style="padding:15px;">

			<form id="form1" name="form1" class="layui-form" method="post" action="/insertMessage.do">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td height="40">邮件标题</td>
						<td height="40"><input name="messageName" type="text" class="layui-input" id="messageName" style="width:250px;"
								   lay-verify="required"/></td>
					</tr>
					<tr>
						<td height="50" width="100">邮件内容</td>
						<td height="50" colspan="4"><textarea name="messageContent" class="layui-textarea"></textarea></td>
					</tr>

					<tr>
						<td height="50" width="100">发送人</td>
						<td height="50"><textarea name="messageDes" class="layui-textarea"></textarea></td>
					</tr>

					<tr>
						<td height="50" width="100">发送人账号</td>
						<td height="50"><textarea name="messageDes" class="layui-textarea"></textarea></td>
					</tr>

					<tr>
						<td height="50" width="100">发送人密码</td>
						<td height="50"><textarea name="messageDes" class="layui-textarea"></textarea></td>
					</tr>

					<tr>
						<td height="50">&nbsp;</td>
						<td colspan="4"><input name="input" type="submit" class="layui-btn" value="添加" lay-submit="lay-submit"/>
						</td>
					</tr>
				</table>
			</form>

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