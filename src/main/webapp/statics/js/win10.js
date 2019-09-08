/* 获取当前的日期时间*/
$(function(){
	setInterval("showTime()","1000");
})
function showTime(){
     var today = new Date(); //新建一个Date对象
      var date = today.getDate();//查询当月日期
      var day = today.getDay();//查询当前星期几
      var month = today.getMonth()+1;//查询月份
      var year = today.getFullYear();//查询年份  
      var hour= addZero(today.getHours());
      var min = addZero(today.getMinutes());
      var sec = addZero(today.getSeconds());
        
      var week="";    
      if (true) {};                           
      if (day==0) week='星期日';
      if (day==1) week='星期一';
      if (day==2) week='星期二';
      if (day==3) week='星期三';
      if (day==4) week='星期四';
      if (day==5) week='星期五';
      if (day==6) week='星期六';
		
 	 $("#date").text(year+"-"+month+"-"+date);
 	 $("#time").text(hour + ":"+ min);
}
function addZero(num){
    if (num <= 9) {
        return "0"+num;
    }else {
        return num;
    }
}
//禁止鼠标右击
document.oncontextmenu = function(){
    event.returnValue = false;
}
//或者直接返回整个事件
document.oncontextmenu = function(){
    return false;
}
//全屏
function fullscreen(){
     var e = event || window.event || arguments.callee.caller.arguments[0];
       e.preventDefault();  //阻止F11默认动作
       var el = document.documentElement;
       var rfs = el.requestFullScreen || el.webkitRequestFullScreen || el.mozRequestFullScreen || el.msRequestFullScreen;//定义不同浏览器的全屏API
　　　　　　//执行全屏
       if (typeof rfs != "undefined" && rfs) {
             rfs.call(el);
       } else if(typeof window.ActiveXObject != "undefined"){
             var wscript = new ActiveXObject("WScript.Shell");
             if (wscript!=null) {
                 wscript.SendKeys("{F11}");
             }
       }
　　　　　　//监听不同浏览器的全屏事件，并件执行相应的代码
       document.addEventListener("webkitfullscreenchange", function() {//
           if (document.webkitIsFullScreen) {
                //全屏后要执行的代码
           }else{
                //退出全屏后执行的代码
       　　 }
       }, false);

       document.addEventListener("fullscreenchange", function() {
           if (document.fullscreen) {
                //全屏后执行的代码
           }else{
                //退出全屏后要执行的代码
           }
       }, false);

       document.addEventListener("mozfullscreenchange", function() {
           if (document.mozFullScreen) {
                //全屏后要执行的代码
           }else{
                //退出全屏后要执行的代码
           }
       }, false);

       document.addEventListener("msfullscreenchange", function() {
           if (document.msFullscreenElement) {
                //全屏后要执行的代码
           }else{
                //退出全屏后要执行的代码
           }
       }, false)

}
layui.use('layer', function(){ 
  var $ = layui.jquery, layer = layui.layer; 
      
  var fullscreenOpen =  layer.msg('F11执行全屏或点击按钮', {
	    time: 10000, //20s后自动关闭
	    btn: ['可以的', '我不想'],
	    offset: 't',
	    yes: function(index, layero){
		   fullscreen();
		   layer.close(fullscreenOpen);
		}
		,btn2: function(index, layero){
		   layer.close(fullscreenOpen);
		}
	  });
      
      $(".tcgj").dblclick(function(){
      	var thisText = $(this).find("p").text();
      	var tab = "tcgjtab";
      	var url = "iftc.html";
      	$(".footerTab").append('<li class="'+tab+'">'+thisText+'</li>')
      	tcgjOpen(thisText,tab,url);
      })
      
      $(".ewmsc").dblclick(function(){
      	var thisText = $(this).find("p").text();
      	var tab = "ewmsctab";
      	var url = "ifqrcode.html";
      	$(".footerTab").append('<li class="'+tab+'">'+thisText+'</li>')
      	tcgjOpen(thisText,tab,url);
      })
      
      $(".fy").dblclick(function(){
      	var thisText = $(this).find("p").text();
      	var tab = "fytab";
      	var url = "ifTranslate.html";
      	$(".footerTab").append('<li class="'+tab+'">'+thisText+'</li>')
      	tcgjOpen(thisText,tab,url);
      })
      
      $(".psb").dblclick(function(){
      	var thisText = $(this).find("p").text();
      	var tab = "psbtab";
      	var url = "ifcolor.html";
      	$(".footerTab").append('<li class="'+tab+'">'+thisText+'</li>')
      	tcgjOpen(thisText,tab,url);
      });
      
      $(".winstart,.news").click(function(){
      	layer.msg('玩命开发中...');
	  })

})

//图传工具
function tcgjOpen(thisText,tab,url){
	layer.open({
        type: 2 
        ,title: thisText
        ,area: ['900px', '500px']
        ,shade: 0
        ,offset: 'auto'
        ,content: url
        ,zIndex: layer.zIndex 
        ,cancel: function(){ 
        	$('.'+tab+'').hide()
		}
        ,success: function(layero){
          layer.setTop(layero); 
        }
      });
}
