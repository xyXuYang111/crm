//阴影生成器
layui.use(['form','slider','element','colorpicker'], function(){
  var $ = layui.$
  ,slider = layui.slider
  ,element = layui.element
  ,colorpicker = layui.colorpicker
  form = layui.form;
  //水平
  slider.render({
    elem: '#slideTest1'
    ,min: -10 //最小值
		,max: 10 //最大值
		,value: 2 //初始值
    ,input: true //输入框
    ,change: function(value){
     	console.log(value) //动态获取滑块数值
     	$("#sp").val(value);
     	var a = $("#sp").val();
			var b = $("#wy").val();
			var c = $("#bj").val();
			var d = $("#yj").val();
			var e = $("#dx").val();
			var f = $("#nw").val();
			var g = $("#ys").val();
			triangle(a,b,c,d,e,f,g);
    }
  });
  //垂直
  slider.render({
    elem: '#slideTest2'
    ,min: -10 //最小值
		,max: 10 //最大值
		,value: 0 //初始值
    ,input: true //输入框
    ,change: function(value){
     	console.log(value) //动态获取滑块数值
     	$("#wy").val(value);
     	var a = $("#sp").val();
			var b = $("#wy").val();
			var c = $("#bj").val();
			var d = $("#yj").val();
			var e = $("#dx").val();
			var f = $("#nw").val();
			var g = $("#ys").val();
			triangle(a,b,c,d,e,f,g);
    }
  });
  //模糊
  slider.render({
    elem: '#slideTest3'
    ,min: -10 //最小值
		,max: 10 //最大值
		,value: 5 //初始值
    ,input: true //输入框
    ,change: function(value){
     	console.log(value) //动态获取滑块数值
     	$("#bj").val(value);
     	var a = $("#sp").val();
			var b = $("#wy").val();
			var c = $("#bj").val();
			var d = $("#yj").val();
			var e = $("#dx").val();
			var f = $("#nw").val();
			var g = $("#ys").val();
			triangle(a,b,c,d,e,f,g);
    }
  });
  //圆角
  slider.render({
    elem: '#slideTest4'
    ,min: 0 //最小值
	,max: 150 //最大值
	,value: 0 //初始值
    ,input: true //输入框
    ,change: function(value){
     	console.log(value) //动态获取滑块数值
     	$("#yj").val(value);
     	var a = $("#sp").val();
			var b = $("#wy").val();
			var c = $("#bj").val();
			var d = $("#yj").val();
			var e = $("#dx").val();
			var f = $("#nw").val();
			var g = $("#ys").val();
			triangle(a,b,c,d,e,f,g);
    }
  });
  //尺寸
  slider.render({
    elem: '#slideTest5'
    ,min: 0 //最小值
	,max: 50 //最大值
	,value: 0 //初始值
    ,input: true //输入框
    ,change: function(value){
     	console.log(value) //动态获取滑块数值
     	$("#dx").val(value);
     	var a = $("#sp").val();
			var b = $("#wy").val();
			var c = $("#bj").val();
			var d = $("#yj").val();
			var e = $("#dx").val();
			var f = $("#nw").val();
			var g = $("#ys").val();
			triangle(a,b,c,d,e,f,g);
    }
  });
  //内外阴影
  form.on('radio(yyradio)', function(data){
     	$("#nw").val(data.value)
     	var a = $("#sp").val();
			var b = $("#wy").val();
			var c = $("#bj").val();
			var d = $("#yj").val();
			var e = $("#dx").val();
			var f = data.value;
			var g = $("#ys").val();
			triangle(a,b,c,d,e,f,g);
  });  
  //颜色
  colorpicker.render({
    elem: '#color'
    ,color: '#666666' //设置默认色
    ,done: function(color){
    	$("#ys").val(color)
     	var a = $("#sp").val();
			var b = $("#wy").val();
			var c = $("#bj").val();
			var d = $("#yj").val();
			var e = $("#dx").val();
			var f = $("#nw").val();
			var g = color;
			triangle(a,b,c,d,e,f,g);
    }
  });
  
});

	//添加阴影
	var a = $("#sp").val();
	var b = $("#wy").val();
	var c = $("#bj").val();
	var d = $("#yj").val();
	var e = $("#dx").val();
	var f = '';
	var g = $("#ys").val();
	triangle(a,b,c,d,e,f,g);
	function triangle(a,b,c,d,e,f,g){
			document.getElementById("pre").innerHTML=""
			$("#triangle").css('box-shadow',''+a+'px '+b+'px '+c+'px '+e+'px  '+g+' '+f+''); 
			$("#triangle").css('border-radius',''+d+'px'); 
			var innerHTML = "";
			innerHTML +='<br>//阴影';
			innerHTML +='<br>';
			innerHTML +='box-shadow:'+a+'px '+b+'px '+c+'px '+e+'px '+g+' '+f+';';
			innerHTML +='<br>';
			innerHTML +='-webkit-box-shadow:'+a+'px '+b+'px '+c+'px '+e+'px '+g+' '+f+';';
			innerHTML +='<br>';
			innerHTML +='-moz-box-shadow:'+a+'px '+b+'px '+c+'px '+e+'px '+g+' '+f+';';
			innerHTML +='<br>//圆角';
			innerHTML +='<br>';
			innerHTML +='border-radius:'+d+'px';
			innerHTML +='<br>';
			$("pre").append(innerHTML);
			layui.use('code', function(){
			  layui.code({
				  title: 'box-shadow'
				});
			});
	}