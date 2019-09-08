//点击移除上传后的图片
$(".delete").click(function(){
	$("#pickfiles").show();
	$("#showImg").hide();
	$("#link").val("");
	$("#markdown").val("");
	$("#a-link").val("");
})

//头部选项卡
layui.use('element', function(){
  var $ = layui.jquery
  ,element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块
})

var type = localStorage.getItem("type");
if(type == 1){
	
}else{
	layerOpen();
}

//公告弹出层
function layerOpen() {
	layui.use('layer', function() {
		var $ = layui.jquery,
			layer = layui.layer;
		layer.open({
			type: 1,
			title: false,
			closeBtn: false,
			area: '300px;',
			shade: 0.8,
			id: 'LAY_layuipro',
			btn: ['火速围观', '残忍拒绝'],
			btnAlign: 'c',
			moveType: 1, //拖拽模式，0或者1
			content: '<div style="padding: 50px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;">基于Cloud Studio 和 七牛云存储 搭建的图传工具 。<br>鱼跃此时海，花开彼岸天 ^_^</div>',
			success: function(layero) {
				var btn = layero.find('.layui-layer-btn');
				$(".layui-layer-btn0").click(function(){
					localStorage.setItem("type","1");
					$("#save").click()
				})
				$(".layui-layer-btn1").click(function(){
					localStorage.setItem("type","1");
					$("#save").click()
				})
			}
		});
	});
}

//二维码生成
$(document).ready(function() {
	$('#qr_gen').click(function() {
		if($("#qr_link").val() == ""){
			layer.tips('请输入需要生成二维码的内容', '#qr_link', {
			  tips: [3, '#3595CC'],
			  time: 4000
			});
		}else{
			$("#qr_container img").hide();
			$("canvas").hide();
			$('#qr_container').qrcode({
				render: "canvas",
				height: 260,
				width: 260,
				correctLevel: 0,
				text: toUtf8($('#qr_link').val())
			});
		}
	});
});

//生成二维码先转utf8
function toUtf8(str) {
    var out, i, len, c;
    out = "";
    len = str.length;
    for (i = 0; i < len; i++) {
        c = str.charCodeAt(i);
        if ((c >= 0x0001) && (c <= 0x007F)) {
            out += str.charAt(i);
        } else if (c > 0x07FF) {
            out += String.fromCharCode(0xE0 | ((c >> 12) & 0x0F));
            out += String.fromCharCode(0x80 | ((c >> 6) & 0x3F));
            out += String.fromCharCode(0x80 | ((c >> 0) & 0x3F));
        } else {
            out += String.fromCharCode(0xC0 | ((c >> 6) & 0x1F));
            out += String.fromCharCode(0x80 | ((c >> 0) & 0x3F));
        }
    }
    return out;
}

//点击将html转化为js
$("#zjs").click(function(){
	var conzq = $("#conzq").val();
	if(conzq == ""){
		layer.tips('请输入需要转换的html', '#conzq', {
		  tips: [3, '#3595CC'],
		  time: 4000
		});
	}else{
		ZHjavascript();
	};
});
//点击html转化为js
function ZHjavascript() {
    var htmlArr = $("#conzq").val().replace(/\\/g, "\\\\").replace(/\\/g, "\\/").replace(/\'/g, "\\\'").replace(/\"/g, "\\\"").split('\n');
    var len = htmlArr.length;
    var outArr = [];
    jQuery.each(htmlArr, function (index, value) {
        if (value !== "") {
            if (index === len - 1) {
                outArr.push("\"" + value + "\";");
            } else {
                outArr.push("\"" + value + "\"+\n");
            }
        }
    });
    $("#conzh").val(outArr.join(""));
};

//点击转化
$("#zh").click(function(){
	changeDiv(0,1);
	var s = $(this).attr('class')?Number($(this).attr('class')):0;
    $(this).removeClass(String(s)).addClass(String(s-180));
    s-=180;
    $(this).css('transition','all 0.5s');
    $(this).css('transform','rotate(' + s + 'deg)');
});

//两个div互换位置
function changeDiv(firstIndex,secondIndex){
    var $divs = $('.butList').find('button');
    var firstDiv = $divs.eq(firstIndex);
    var secondDiv = $divs.eq(secondIndex);
    var temp;
    temp = firstDiv.html();
    firstDiv.html(secondDiv.html());
    secondDiv.html(temp);
}
//点击翻译
$("#inputWrap").change(function(){
 	translate();
})
$(".fy").click(function(){
	translate();
})
//回车事件绑定
$('#inputWrap').bind('keyup', function(event) {
    if (event.keyCode == "13") {
        translate();
    }
});
function translate(){
	var appid = '20181130000241349';
	var key = '7W8LUiQjjmkKn3bxhIvM';
	var salt = (new Date).getTime();
	var query = $("#inputWrap").val();
	var from = $(".butList button:nth-child(1)").find("input").val();
	var to = $(".butList button:nth-child(3)").find("input").val();
	var str1 = appid + query + salt + key;
	var sign = MD5(str1);
	
	if(query == ""){
		layer.tips('请输入需要翻译的内容', '#inputWrap', {
		  tips: [3, '#3595CC'],
		  time: 4000
		});
	};
	$.ajax({
		url: 'https://api.fanyi.baidu.com/api/trans/vip/translate',
		type: 'get',
		dataType: 'jsonp',
		data: {
			q: query,
			appid: appid,
			salt: salt,
			from: from,
			to: to,
			sign: sign
		},
		success: function(data) {
			console.log(data);
			$("#sugWrap").val(data.trans_result[0].dst)
		}
	});
}
$("#videoJX").click(function(){
	$(".videoBox img").fadeOut();
	var videoUrl = $("#videoUrl").val();
	var url = 'https://cdn.yangju.vip/k/?url='+videoUrl+'';
	$("#videoIframe").attr("src",url);
})

//禁止F12,//禁止右键
$(document).bind("contextmenu", function () { return false; });
	document.oncontextmenu = function () { return false; };
	document.onkeydown = function () {
    if (window.event && window.event.keyCode == 123) {
        event.keyCode = 0;
        event.returnValue = false;
        return false;
    }
};