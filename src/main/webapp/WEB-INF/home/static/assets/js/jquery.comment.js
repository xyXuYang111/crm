(function($){

    function crateCommentInfo(obj,index){

        if(typeof(obj.time) == "undefined" || obj.time == ""){
            obj.time = getNowDateFormat();
        }

        var el = "<div class='detail-about detail-about-reply'><div class='fly-avatar'><img   src='"+obj.img+"'></div><div class='comment-right'><h3 class='fly-link'>"+obj.replyName+"</h3>" +
            "<span class='userId' style='display: none'>"+obj.userId+"</span><span class='id'  style='display: none'>"+obj.id+"</span>"

            +"<div class='detail-hits'><span class='dtime'>"+dateFormatter(obj.time) +"</span>";

        if(typeof(obj.address) != "undefined" && obj.browse != ""){
            el =el+"<span><i class='fa fa-location-arrow'></i>"+obj.address+"</span>" +
                "<span style='float: right;font-size: 20px ;color: #000;'>"+index+"楼</span>";
        }
        el = el+"</div><div class='detail-body layui-text jieda-body photos'>"+obj.content+"</div><div class='comment-content-footer'><div class='layui-row'><div class='layui-col-md4'>";

        if(typeof(obj.osname) != "undefined" && obj.osname != ""){
            el =el+"<span ><i class='glyphicon glyphicon-pushpin'></i> 来自:"+obj.osname+"</span>";
        }

        if(typeof(obj.browse) != "undefined" && obj.browse != ""){
            el = el + "<span><i class='glyphicon glyphicon-globe'></i> "+obj.browse+"</span>";
        }

        el = el + "</div><div class='layui-col-md8 jieda-reply'><span class='reply-btn' ><i class='iconfont icon-svgmoban53'></i>回复</span></div></div></div><div class='reply-list'>";

        if(obj.replyBody  && obj.replyBody.length > 0){
            var arr = obj.replyBody;
            for(var j=0;j<arr.length;j++){
                var replyObj = arr[j];
                el = el+createReplyComment(replyObj);
            }
        }
        el = el+"</div></div></div>";
        return el;
    }
    function dateFormatter (date) {
        if (date.indexOf("T") > -1) {
            var temp = date.split("T");
            var t = temp[0] + " " + temp[1];
            if (t.indexOf(".") > -1) {
                return t.substring(0, t.indexOf("."));
            } else {
                return t;
            }
        } else {
            return date;
        }
    }
    //返回每个回复体内容
    function createReplyComment(reply){
        var replyEl = "<div class='reply'><div style='margin-bottom: 10px'><a href='javascript:void(0)' class='replyname'><span style='color: #12b5f6'>"+reply.replyName+"</span></a><a href='javascript:void(0)'>回复<span style='color: #12b5f6'>"+reply.beReplyName+"</span></a>:<p style='margin: 5px;" +
            "    color: #000;'>"+reply.content+"</p></div>"
            + "<p class='jieda-reply'><span>"+dateFormatter(reply.time)+"</span><span class='ruserId' style='display: none'>"+reply.userId+"</span><span class='reply-list-btn'><i class='iconfont icon-svgmoban53'></i>回复</span></p></div>";
        return replyEl;
    }
	function getNowDateFormat(){
		var nowDate = new Date();
		var year = nowDate.getFullYear();
		var month = filterNum(nowDate.getMonth()+1);
		var day = filterNum(nowDate.getDate());
		var hours = filterNum(nowDate.getHours());
		var min = filterNum(nowDate.getMinutes());
		var seconds = filterNum(nowDate.getSeconds());
		return year+"-"+month+"-"+day+" "+hours+":"+min+":"+seconds;
	}
	function filterNum(num){
		if(num < 10){
			return "0"+num;
		}else{
			return num;
		}
	}
	function replyClick(el){
        var name2;
        if(el.parent().parent().hasClass("reply")){
            console.log("1111");
            name2=el.parent().parent().find("a:first").text();console.log(el.parent().parent().find("a:first").text());
            console.log(name2);

        }else{

            name2=el.parent().parent().parent().parent().find("h3").text();
            console.log(el.parent().parent().parent().parent().find("h3").text());
            console.log(name2);
        }

        el.parent().parent().append("<div class='replybox'>" +
            "<textarea cols='80' rows='50' placeholder='回复:"+name2+"' class='mytextarea' ></textarea>" +
            "<button class='send layui-btn-danger layui-btn layui-btn-sm' >回复</button>" +
            "</div>")
			.find(".send").click(function(){
			var content = $(this).prev().val();
			if(content){

				var parentEl = $(this).parent().parent().parent().parent();

				var obj = new Object();

				if(el.parent().parent().hasClass("reply")){
					console.log("1111");
					obj.beReplyName = el.parent().parent().find("a:first").text();
                    obj.parentId= parentEl.find(".id").text();
                    obj.useredId=el.parent().parent().find(".ruserId").text();
				}else{
					console.log("2222");
					obj.beReplyName=parentEl.find("h3").text();
					obj.parentId=parentEl.find(".id").text();
                    obj.useredId=parentEl.find(".userId").text();
				}
				obj.comment=content;
                obj.content=content;
				obj.time = getNowDateFormat();
				obj.articleId=articleId;
                obj.enable=true;
                   if(su){
                  var index = layer.load();
                   	obj.replyName=su.nickname;
                    obj.userId=su.id;
                    obj.user=su.id;
                    console.log(obj);

                   $.post("/token/comment/sub",obj, function (resp) {
                       layer.close(index);
                       layer.msg(resp.message);

                       setTimeout(function () {
                           if (resp.code === 200) {
                               var replyString = createReplyComment(obj);
                               $(".replybox").remove();
                               parentEl.find(".reply-list").append(replyString).find(".reply-list-btn:last").click(function(){  layer.msg("不能回复自己");});
                           }
                       }, 1000);
                   });
               }
               else {
                       layer.msg("请登录!");
				   }


			}else{
                layer.msg("不能为空!");

			}
		});
	}
	
	
	$.fn.addCommentList=function(options){

		var defaults = {
			data:[],
			add:""
		}
		var option = $.extend(defaults, options);


		//加载数据
		if(option.data.length > 0){
			var dataList = option.data;
			var totalString = "";
			for(var i=0;i<dataList.length;i++){
				var obj = dataList[i];
				var objString = crateCommentInfo(obj,i+1);
				totalString = totalString+objString;
			}
			$(this).append(totalString).find(".reply-btn").click(function(){
				if($(this).parent().parent().find(".replybox").length > 0){
					$(".replybox").remove();
				}else{
					$(".replybox").remove();
					replyClick($(this));
				}
			});
			$(".reply-list-btn").click(function(){
				if($(this).parent().parent().find(".replybox").length > 0){
					$(".replybox").remove();
				}else{
					$(".replybox").remove();
					replyClick($(this));
				}
			})
		}
		
		//添加新数据
		if(option.add != ""){
			obj = option.add;
			var str = crateCommentInfo(obj);
			$(this).prepend(str).find(".reply-btn").click(function(){
                layer.msg("不能回复自己");
			});
		}
	}
	
	
})(jQuery);


function detectOS() {
    var sUserAgent = navigator.userAgent;
    var isWin = (navigator.platform == "Win32") || (navigator.platform == "Windows");
    var isMac = (navigator.platform == "Mac68K") || (navigator.platform == "MacPPC") || (navigator.platform == "Macintosh") || (navigator.platform == "MacIntel");
    if (isMac) return "Mac";
    var isUnix = (navigator.platform == "X11") && !isWin && !isMac;
    if (isUnix) return "Unix";
    var isLinux = (String(navigator.platform).indexOf("Linux") > -1);
    if (isLinux) return "Linux";
    if (isWin) {
        var isWin2K = sUserAgent.indexOf("Windows NT 5.0") > -1 || sUserAgent.indexOf("Windows 2000") > -1;
        if (isWin2K) return "Win2000";
        var isWinXP = sUserAgent.indexOf("Windows NT 5.1") > -1 || sUserAgent.indexOf("Windows XP") > -1;
        if (isWinXP) return "WinXP";
        var isWin2003 = sUserAgent.indexOf("Windows NT 5.2") > -1 || sUserAgent.indexOf("Windows 2003") > -1;
        if (isWin2003) return "Win2003";
        var isWin2003 = sUserAgent.indexOf("Windows NT 6.0") > -1 || sUserAgent.indexOf("Windows Vista") > -1;
        if (isWin2003) return "WinVista";
        var isWin2003 = sUserAgent.indexOf("Windows NT 6.1") > -1 || sUserAgent.indexOf("Windows 7") > -1;
        if (isWin2003) return "Win7";
        if(sUserAgent.indexOf("Windows NT 7")!=-1){
            return "win7系统";
        }else if(sUserAgent.indexOf("Windows NT 10")!=-1){
            return" win10系统";
        }

    }
    return "None";
}




