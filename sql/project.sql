/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : project

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 05/10/2019 23:57:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for email
-- ----------------------------
DROP TABLE IF EXISTS `email`;
CREATE TABLE `email`  (
  `emailID` int(11) NOT NULL AUTO_INCREMENT COMMENT '邮件id',
  `titleName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `message` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sendName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sendNumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sendPassword` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `receiveName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `receiveNumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `receivePassword` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`emailID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for file
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file`  (
  `fileID` int(11) NOT NULL AUTO_INCREMENT COMMENT '文件id',
  `systemName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '系统文件名',
  `fileName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件名称',
  `fileType` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件类型',
  `filePath` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件路径',
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '文件创建时间',
  PRIMARY KEY (`fileID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of file
-- ----------------------------
INSERT INTO `file` VALUES (2, '5b4b3921-5931-4426-a85c-43cad6912092.jpg', 't01cc232bc928731f48.webp.jpg', NULL, 'D:\\file\\photo\\5b4b3921-5931-4426-a85c-43cad6912092.jpg', '2019-09-08 12:00:59');
INSERT INTO `file` VALUES (3, 'f92417ce-2c46-4706-9ee1-1708d9629060.jpg', 't01cc232bc928731f48.webp.jpg', NULL, 'D:\\file\\photo\\f92417ce-2c46-4706-9ee1-1708d9629060.jpg', '2019-09-08 12:01:15');
INSERT INTO `file` VALUES (5, '0d27c9e6-32bf-4730-b79e-87810c029952.jpg', 't01cc232bc928731f48.webp.jpg', '图片', 'D:\\file\\photo\\0d27c9e6-32bf-4730-b79e-87810c029952.jpg', '2019-09-08 12:27:19');
INSERT INTO `file` VALUES (6, '739ac1ba-ac29-4276-9f77-6d756f743c7d.jpg', 't01cc232bc928731f48.webp.jpg', '图片', 'D:\\file\\photo\\739ac1ba-ac29-4276-9f77-6d756f743c7d.jpg', '2019-09-08 12:39:55');
INSERT INTO `file` VALUES (7, '7198a3d9-4d96-413c-85c9-72fe526b185d.jpg', 't01cc232bc928731f48.webp.jpg', '图片', 'D:\\file\\photo\\7198a3d9-4d96-413c-85c9-72fe526b185d.jpg', '2019-09-08 12:41:28');
INSERT INTO `file` VALUES (8, '473d5d0b-8ac8-4360-8e43-e9fad5230bc9.jpg', 't01cc232bc928731f48.webp.jpg', '图片', 'D:\\file\\photo\\473d5d0b-8ac8-4360-8e43-e9fad5230bc9.jpg', '2019-09-08 12:42:24');
INSERT INTO `file` VALUES (9, 'a7069580-f97c-41b6-8467-9e92474db127.jpg', 't01cc232bc928731f48.webp.jpg', '图片', 'D:\\file\\photo\\a7069580-f97c-41b6-8467-9e92474db127.jpg', '2019-09-08 12:42:50');
INSERT INTO `file` VALUES (10, '33d8be71-f1ba-46dc-b151-aa1c2bcecf1e.jpg', 't01cc232bc928731f48.webp.jpg', '图片', 'D:\\file\\photo\\33d8be71-f1ba-46dc-b151-aa1c2bcecf1e.jpg', '2019-09-08 18:37:43');
INSERT INTO `file` VALUES (11, '6654dac7-4fdb-4a4d-a304-136d27573654.jpg', 't01cc232bc928731f48.webp.jpg', '图片', 'D:\\file\\photo\\6654dac7-4fdb-4a4d-a304-136d27573654.jpg', '2019-09-08 18:37:55');
INSERT INTO `file` VALUES (12, 'c27bb35f-35db-4fc0-aa9b-f91d75b3a817.jpg', 't01cc232bc928731f48.webp.jpg', '图片', 'D:\\file\\photo\\c27bb35f-35db-4fc0-aa9b-f91d75b3a817.jpg', '2019-09-11 00:42:47');
INSERT INTO `file` VALUES (13, '4d278a8f-a3b8-4a45-9bab-6f5970a5cd8d.pptx', 'ECN系统改进及业务流程优化功能培训201904(各单位).pptx', '其他', 'D:\\file\\word\\4d278a8f-a3b8-4a45-9bab-6f5970a5cd8d.pptx', '2019-09-11 00:57:26');
INSERT INTO `file` VALUES (14, '7266a728-997f-47e3-b8a1-6dc0cd15f542.exe', '360安全浏览器_10.0.1840.0.exe', '其他', 'D:\\file\\word\\7266a728-997f-47e3-b8a1-6dc0cd15f542.exe', '2019-09-11 01:06:23');
INSERT INTO `file` VALUES (15, '7266a728-997f-47e3-b8a1-6dc0cd15f542.exe', '360安全浏览器_10.0.1840.0.exe', '其他', 'D:\\file\\word\\7266a728-997f-47e3-b8a1-6dc0cd15f542.exe', '2019-09-11 01:09:48');
INSERT INTO `file` VALUES (16, '7266a728-997f-47e3-b8a1-6dc0cd15f542.exe', '360安全浏览器_10.0.1840.0.exe', '其他', 'D:\\file\\word\\7266a728-997f-47e3-b8a1-6dc0cd15f542.exe', '2019-09-11 01:13:50');
INSERT INTO `file` VALUES (17, '7266a728-997f-47e3-b8a1-6dc0cd15f542.exe', '360安全浏览器_10.0.1840.0.exe', '其他', 'D:\\file\\word\\7266a728-997f-47e3-b8a1-6dc0cd15f542.exe', '2019-09-11 01:16:13');
INSERT INTO `file` VALUES (18, 'fcf05f2d-189b-4465-8c47-f6250331e79a.zip', 'apache-ant-1.9.14-bin.zip', '其他', 'D:\\file\\word\\fcf05f2d-189b-4465-8c47-f6250331e79a.zip', '2019-09-11 01:24:16');
INSERT INTO `file` VALUES (19, 'f6a03fd3-f89c-4a1b-8bc5-e2dfeb974451.exe', 'datagrip-2019.1.3.exe', '其他', 'D:\\file\\word\\f6a03fd3-f89c-4a1b-8bc5-e2dfeb974451.exe', '2019-09-11 02:21:41');

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log`  (
  `logID` int(11) NOT NULL AUTO_INCREMENT COMMENT '日志id',
  `logContent` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '日志内容',
  `logResult` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '日志结果',
  `logType` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '日志类型',
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`logID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES (1, 'Files(fileID=4, systemName=09d0e208-f832-44b9-b14a-76cc916c2980.jpg, fileName=t01cc232bc928731f48.webp.jpg, fileByte=null, fileNum=null, createTime=null, filePath=D:\\file\\photo\\09d0e208-f832-44b9-b14a-76cc916c2980.jpg, multipartFile=org.springframework.web.multipart.commons.CommonsMultipartFile@4dd98a6b)', NULL, '文件', '2019-09-08 12:01:53');
INSERT INTO `log` VALUES (2, 'Files(fileID=5, systemName=0d27c9e6-32bf-4730-b79e-87810c029952.jpg, fileName=t01cc232bc928731f48.webp.jpg, fileByte=null, fileNum=null, createTime=null, filePath=D:\\file\\photo\\0d27c9e6-32bf-4730-b79e-87810c029952.jpg, fileType=图片, multipartFile=org.springframework.web.multipart.commons.CommonsMultipartFile@586f65ba)', NULL, '文件', '2019-09-08 12:27:31');
INSERT INTO `log` VALUES (3, 'Files(fileID=6, systemName=739ac1ba-ac29-4276-9f77-6d756f743c7d.jpg, fileName=t01cc232bc928731f48.webp.jpg, fileByte=null, fileNum=null, createTime=null, filePath=D:\\file\\photo\\739ac1ba-ac29-4276-9f77-6d756f743c7d.jpg, fileType=图片, multipartFile=org.springframework.web.multipart.commons.CommonsMultipartFile@510a799f)', NULL, '文件', '2019-09-08 12:39:55');
INSERT INTO `log` VALUES (4, 'Files(fileID=7, systemName=7198a3d9-4d96-413c-85c9-72fe526b185d.jpg, fileName=t01cc232bc928731f48.webp.jpg, fileByte=null, fileNum=null, createTime=null, filePath=D:\\file\\photo\\7198a3d9-4d96-413c-85c9-72fe526b185d.jpg, fileType=图片, multipartFile=org.springframework.web.multipart.commons.CommonsMultipartFile@3864d226)', NULL, '文件', '2019-09-08 12:41:28');
INSERT INTO `log` VALUES (5, 'Files(fileID=8, systemName=473d5d0b-8ac8-4360-8e43-e9fad5230bc9.jpg, fileName=t01cc232bc928731f48.webp.jpg, fileByte=null, fileNum=null, createTime=null, filePath=D:\\file\\photo\\473d5d0b-8ac8-4360-8e43-e9fad5230bc9.jpg, fileType=图片, multipartFile=org.springframework.web.multipart.commons.CommonsMultipartFile@35e541dc)', NULL, '文件', '2019-09-08 12:42:24');
INSERT INTO `log` VALUES (6, 'Files(fileID=9, systemName=a7069580-f97c-41b6-8467-9e92474db127.jpg, fileName=t01cc232bc928731f48.webp.jpg, fileByte=null, fileNum=null, createTime=null, filePath=D:\\file\\photo\\a7069580-f97c-41b6-8467-9e92474db127.jpg, fileType=图片, multipartFile=org.springframework.web.multipart.commons.CommonsMultipartFile@18f366c4)', NULL, '文件', '2019-09-08 12:42:50');
INSERT INTO `log` VALUES (7, 'Files(fileID=10, systemName=33d8be71-f1ba-46dc-b151-aa1c2bcecf1e.jpg, fileName=t01cc232bc928731f48.webp.jpg, fileByte=null, fileNum=null, createTime=null, filePath=D:\\file\\photo\\33d8be71-f1ba-46dc-b151-aa1c2bcecf1e.jpg, fileType=图片, multipartFile=org.springframework.web.multipart.commons.CommonsMultipartFile@565407da)', NULL, '文件', '2019-09-08 18:37:44');
INSERT INTO `log` VALUES (8, 'Files(fileID=11, systemName=6654dac7-4fdb-4a4d-a304-136d27573654.jpg, fileName=t01cc232bc928731f48.webp.jpg, fileByte=null, fileNum=null, createTime=null, filePath=D:\\file\\photo\\6654dac7-4fdb-4a4d-a304-136d27573654.jpg, fileType=图片, multipartFile=org.springframework.web.multipart.commons.CommonsMultipartFile@4662cf48)', NULL, '文件', '2019-09-08 18:37:55');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `messageID` int(11) NOT NULL AUTO_INCREMENT COMMENT '文件id',
  `messageName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件标题',
  `messageDes` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `messageContent` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件内容',
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`messageID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (1, '1111', '11111111111111111111111', '11111111111111111111111111111111111', '2019-09-09 00:10:44');
INSERT INTO `message` VALUES (2, '出现这个异常原因', 'java.lang.IllegalArgumentException: Invalid character found in the request target. The valid charact', '当你出现这个异常的时候，不要去听行网上说的什么@RequestMapper这些注解的问题，其实就是你请求参数的问题，如果你的请求参数是给路径，传到后端就出现这个问题', '2019-09-09 00:23:57');
INSERT INTO `message` VALUES (3, '每天一记', '每天一记', '周一起床，比平时多一个小时先醒，可能和自己是1点开始睡有关。哎，这睡眠质量真的没谁了', '2019-09-09 06:36:23');
INSERT INTO `message` VALUES (4, '每天一记', '今天上班，又要开启苦逼的上班日子了', '上班过程想想怎么后面还有什么功能可以实现的吧，顺带找找可以内网穿透的东西，这个网站还真的发布到网上去，不一定要给别人看，但我自己的用它做点事吧，总不能天天背着电脑开着服务到处跑吧', '2019-09-09 06:39:13');
INSERT INTO `message` VALUES (5, '关于全局异常捕获机制', 'mvc中实现全部异常机制', '代码如下：public class ExceptionsController {\r\n\r\n    /**\r\n     * 全局异常\r\n     * @param exception\r\n     * @return\r\n     */\r\n    @ResponseBody\r\n    @ExceptionHandler(Exception.class)\r\n    public Object exceptionHandler(HttpServletRequest request, Exception exception){\r\n       return null;\r\n    }\r\n}', '2019-09-10 00:12:12');
INSERT INTO `message` VALUES (6, '今天结束这个项目开发吧', '感觉它已经差不都了，有文件，有记录这些东西。现在啥也不缺。就这样吧', '那就这样吧，我要结束这个项目的开发了', '2019-09-11 00:24:54');
INSERT INTO `message` VALUES (7, '下面准备开启第二个项目开发', '这个项目将是一个前端显示博客的界面，没错。就是上次看到的那个', '我要做一个属于那样的项目，至于具体显示什么那就再说吧。可能也是文本，也可能是其他的。但至少都是存在实用性。', '2019-09-11 00:27:17');
INSERT INTO `message` VALUES (8, '我知道后面开发什么了', '这次前端界面 不变，我要 把这个项目转到springbooot里面去，我要走一个这个项目', '基于springboot实现项目基本开发', '2019-09-11 00:28:54');
INSERT INTO `message` VALUES (9, '学习elastic', '最近搞到了elastic的相关工具，等下可以开始elastic的学习了', '学习elastic的增删改查等相关基础功能，先入个门吧', '2019-09-11 00:30:06');
INSERT INTO `message` VALUES (10, '关于hashSet的用户', 'hashSet是一种map的用法，一般去重的话用它最好，它有个特性会自动对重复数据进行覆盖', '添加元素：\r\n\r\nhashset.add(E e)：返回boolean型，如果此 set 中尚未包含指定元素，则添加指定元素；如果此 set 已包含该元素，则该调用不更改 set 并返回 false。\r\n\r\n删除元素：\r\n\r\nhashset.clear()：从此 set 中移除所有元素。\r\n\r\nhashset.remove(Object o)：如果指定元素存在于此 set 中，则将其移除。\r\n\r\nhashset.isEmpty()：如果此 set 不包含任何元素，则返回 true。\r\n\r\nhashset.contains(Object o)：如果此 set 包含指定元素，则返回 true。\r\n\r\nhashset.size()：返回此 set 中的元素的数量（set 的容量）。', '2019-09-11 21:27:53');
INSERT INTO `message` VALUES (11, '关于request请求获取参数', '当你用get方式请求后端，你可以通过request的getQueryString获取到请求的参数\r\n当你想获取json串的参数，那需要其他方法，这个还在查询中', '', '2019-09-13 15:08:59');
INSERT INTO `message` VALUES (12, 'springboot集成log4j的bug', 'Exception in thread \"main\" java.lang.IllegalStateException: Logback configuration error detected: E', '当你配置：logging.config就会出现这个异常。按照网上知识，它表示是logback存在bug。具体原因还在查询中。至于关于集成logback的内容，可以用lombok就可以使用', '2019-09-14 03:25:48');
INSERT INTO `message` VALUES (13, 'zipkin安装', 'zipkin入门级别的教程：https://blog.csdn.net/qq924862077/article/details/80285536', 'zipkin入门级别的教程：https://blog.csdn.net/qq924862077/article/details/80285536', '2019-09-14 04:03:26');
INSERT INTO `message` VALUES (14, 'zuul的使用', 'zuul按照现在学习情况，它本质上就是一个nginx，反响代理的功能。可以通过配置路由规则实现一个网关管理多个服务。但这个前提条件是注册中心必须是同一个', 'zuul网关和注册中心学习', '2019-09-14 20:51:09');
INSERT INTO `message` VALUES (15, 'zuulFilter过滤器', '通过继承方式，重写四给方法package com.chhliu.springcloud.zuul;\r\n \r\nimport javax.servlet.http.HttpServletRequest;\r\n \r\nimport com.netflix.zuul.ZuulFilter;\r\nimport com.netflix.zuul.context.RequestContext;\r\n \r\npublic class AccessUserNameFilter extends ZuulFilter {\r\n	@Override\r\n	public Object run() {\r\n		RequestContext ctx = RequestContext.getCurrentContext();\r\n        HttpServletRequest request = ctx.getRequest();\r\n \r\n        System.out.println(String.format(\"%s AccessUserNameFilter request to %s\", request.getMethod(), request.getRequestURL().toString()));\r\n \r\n        String username = request.getParameter(\"username\");// 获取请求的参数\r\n        if(null != username && username.equals(\"chhliu\")) {// 如果请求的参数不为空，且值为chhliu时，则通过\r\n            ctx.setSendZuulResponse(true);// 对该请求进行路由\r\n            ctx.setResponseStatusCode(200);\r\n            ctx.set(\"isSuccess\", true);// 设值，让下一个Filter看到上一个Filter的状态\r\n            return null;\r\n        }else{\r\n            ctx.setSendZuulResponse(false);// 过滤该请求，不对其进行路由\r\n            ctx.setResponseStatusCode(401);// 返回错误码\r\n            ctx.setResponseBody(\"{\\\"result\\\":\\\"username is not correct!\\\"}\");// 返回错误内容\r\n            ctx.set(\"isSuccess\", false);\r\n            return null;\r\n        }\r\n	}\r\n \r\n	@Override\r\n	public boolean shouldFilter() {\r\n		return true;// 是否执行该过滤器，此处为true，说明需要过滤\r\n	}\r\n \r\n	@Override\r\n	public int filterOrder() {\r\n		return 0;// 优先级为0，数字越大，优先级越低\r\n	}\r\n \r\n	@Override\r\n	public String filterType() {\r\n		return \"pre\";// 前置过滤器\r\n	}\r\n}\r\n', '通过继承ZuulFilter然后覆写上面的4个方法，就可以实现一个简单的过滤器，下面就相关注意点进行说明\r\nfilterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：\r\n\r\npre：可以在请求被路由之前调用\r\nroute：在路由请求时候被调用\r\npost：在route和error过滤器之后被调用\r\nerror：处理请求时发生错误时被调用\r\n     Zuul的主要请求生命周期包括“pre”，“route”和“post”等阶段。对于每个请求，都会运行具有这些类型的所有过滤器。\r\nfilterOrder：通过int值来定义过滤器的执行顺序\r\n\r\nshouldFilter：返回一个boolean类型来判断该过滤器是否要执行，所以通过此函数可实现过滤器的开关。在上例中，我们直接返回true，所以该过滤器总是生效\r\n\r\nrun：过滤器的具体逻辑。需要注意，这里我们通过ctx.setSendZuulResponse(false)令zuul过滤该请求，不对其进行路由，然后通过ctx.setResponseStatusCode(401)设置了其返回的错误码\r\n————————————————\r\n版权声明：本文为CSDN博主「牛奋lch」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。\r\n原文链接：https://blog.csdn.net/liuchuanhong1/article/details/62236793', '2019-09-15 00:25:31');
INSERT INTO `message` VALUES (16, 'zuulFilter继续学习', '1、继承ZuulFilter类，为了验证Filter的特性，我们这里创建3个Filter\r\n根据用户名来过滤', 'package com.chhliu.springcloud.zuul;\r\n \r\nimport javax.servlet.http.HttpServletRequest;\r\n \r\nimport com.netflix.zuul.ZuulFilter;\r\nimport com.netflix.zuul.context.RequestContext;\r\n \r\npublic class AccessUserNameFilter extends ZuulFilter {\r\n	@Override\r\n	public Object run() {\r\n		RequestContext ctx = RequestContext.getCurrentContext();\r\n        HttpServletRequest request = ctx.getRequest();\r\n \r\n        System.out.println(String.format(\"%s AccessUserNameFilter request to %s\", request.getMethod(), request.getRequestURL().toString()));\r\n \r\n        String username = request.getParameter(\"username\");// 获取请求的参数\r\n        if(null != username && username.equals(\"chhliu\")) {// 如果请求的参数不为空，且值为chhliu时，则通过\r\n            ctx.setSendZuulResponse(true);// 对该请求进行路由\r\n            ctx.setResponseStatusCode(200);\r\n            ctx.set(\"isSuccess\", true);// 设值，让下一个Filter看到上一个Filter的状态\r\n            return null;\r\n        }else{\r\n            ctx.setSendZuulResponse(false);// 过滤该请求，不对其进行路由\r\n            ctx.setResponseStatusCode(401);// 返回错误码\r\n            ctx.setResponseBody(\"{\\\"result\\\":\\\"username is not correct!\\\"}\");// 返回错误内容\r\n            ctx.set(\"isSuccess\", false);\r\n            return null;\r\n        }\r\n	}\r\n \r\n	@Override\r\n	public boolean shouldFilter() {\r\n		return true;// 是否执行该过滤器，此处为true，说明需要过滤\r\n	}\r\n \r\n	@Override\r\n	public int filterOrder() {\r\n		return 0;// 优先级为0，数字越大，优先级越低\r\n	}\r\n \r\n	@Override\r\n	public String filterType() {\r\n		return \"pre\";// 前置过滤器\r\n	}\r\n}\r\n', '2019-09-15 00:26:41');
INSERT INTO `message` VALUES (17, 'zuulFilter过滤器', '再建一个过滤器，根据密码来过滤：', 'package com.chhliu.springcloud.zuul;\r\n \r\nimport javax.servlet.http.HttpServletRequest;\r\n \r\nimport com.netflix.zuul.ZuulFilter;\r\nimport com.netflix.zuul.context.RequestContext;\r\n \r\npublic class AccessPasswordFilter extends ZuulFilter {\r\n \r\n	@Override\r\n	public Object run() {\r\n		RequestContext ctx = RequestContext.getCurrentContext();\r\n        HttpServletRequest request = ctx.getRequest();\r\n \r\n        System.out.println(String.format(\"%s AccessPasswordFilter request to %s\", request.getMethod(), request.getRequestURL().toString()));\r\n \r\n        String username = request.getParameter(\"password\");\r\n        if(null != username && username.equals(\"123456\")) {\r\n        	ctx.setSendZuulResponse(true);\r\n            ctx.setResponseStatusCode(200);\r\n            ctx.set(\"isSuccess\", true);\r\n            return null;\r\n        }else{\r\n            ctx.setSendZuulResponse(false);\r\n            ctx.setResponseStatusCode(401);\r\n            ctx.setResponseBody(\"{\\\"result\\\":\\\"password is not correct!\\\"}\");\r\n            ctx.set(\"isSuccess\", false);\r\n            return null;\r\n        }\r\n	}\r\n \r\n	@Override\r\n	public boolean shouldFilter() {\r\n		RequestContext ctx = RequestContext.getCurrentContext();\r\n		return (boolean) ctx.get(\"isSuccess\");// 如果前一个过滤器的结果为true，则说明上一个过滤器成功了，需要进入当前的过滤，如果前一个过滤器的结果为false，则说明上一个过滤器没有成功，则无需进行下面的过滤动作了，直接跳过后面的所有过滤器并返回结果\r\n	}\r\n \r\n	@Override\r\n	public int filterOrder() {\r\n		return 1; // 优先级设置为1\r\n	}\r\n \r\n	@Override\r\n	public String filterType() {\r\n		return \"pre\";\r\n	}\r\n}\r\n', '2019-09-15 00:27:15');
INSERT INTO `message` VALUES (18, 'zuulFilter过滤器', '最后建一个post过滤器', 'package com.chhliu.springcloud.zuul;\r\n \r\nimport javax.servlet.http.HttpServletRequest;\r\n \r\nimport com.netflix.zuul.ZuulFilter;\r\nimport com.netflix.zuul.context.RequestContext;\r\n \r\npublic class AccessTokenFilter extends ZuulFilter {\r\n	@Override\r\n	public Object run() {\r\n		RequestContext ctx = RequestContext.getCurrentContext();\r\n		HttpServletRequest request = ctx.getRequest();\r\n \r\n		System.out.println(String.format(\"%s AccessTokenFilter request to %s\", request.getMethod(),\r\n				request.getRequestURL().toString()));\r\n		\r\n		ctx.setSendZuulResponse(true);\r\n		ctx.setResponseStatusCode(200);\r\n		ctx.setResponseBody(\"{\\\"name\\\":\\\"chhliu\\\"}\");// 输出最终结果\r\n		return null;\r\n	}\r\n \r\n	@Override\r\n	public boolean shouldFilter() {\r\n		return true;\r\n	}\r\n \r\n	@Override\r\n	public int filterOrder() {\r\n		return 0;\r\n	}\r\n \r\n	@Override\r\n	public String filterType() {\r\n		return \"post\";// 在请求被处理之后，会进入该过滤器\r\n	}\r\n}\r\n', '2019-09-15 00:27:53');
INSERT INTO `message` VALUES (19, '@LoadBalanced实现本地负载均衡', '我们知道restTemplate是可以调用restful接口，但在微服务中，如果服务已经通过注册机进行了注册，那么就可以通过\r\nhttp://admin(注册名称)/index.do(接口名实现接口调用)', '两种案例：\r\nhttp://localhost:9001/index.do\r\nhttp://admin/index.do', '2019-10-04 21:49:05');
INSERT INTO `message` VALUES (20, 'eureka集群搭建原理', '实现原理：各个注册机相互注册就是实现注册机实现集群搭建', 'server:\r\n  port: 9000\r\neureka:\r\n  instance:\r\n    hostname: localhost\r\n  client:\r\n    ##集群配置：进行相互注册\r\n    registerWithEureka: true\r\n    fetchRegistry: true\r\n    serviceUrl:\r\n      defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/\r\n\r\ndefaultZone 为注册中心地址，通过registerWithEureka，fetchRegistry改成true，实现注册中心相互注册，就是实现注册中心的集群。具体看代码吧', '2019-10-04 22:00:39');
INSERT INTO `message` VALUES (21, '其他自服务实现多集群注册', '就是在defaultZone中写两个或者两个以上地址，那么它就会根据你的情况将服务注册到不同的服务上', '例子：defaultZone: http://locahost:9001/eureka/, http://locahost:9002/eureka/\r\n这个就是两个注册机，将服务注册在两个服务商，分别是9001和9002这个服务上', '2019-10-04 22:04:57');

SET FOREIGN_KEY_CHECKS = 1;
