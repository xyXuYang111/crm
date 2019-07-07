<head>
    <script>
        function reloadView(){
            $.ajax({
                url:'${oneway}/index?event=reloadView',
                type:'POST',
                async:true,    //或false,是否异步
                success:function(result){

                    //eval() 函数可计算某个字符串，并执行其中的的 JavaScript 代码。
                    //在这里是将String转化为数组形式
                    var datas= eval(result);

                    var accessCountDiv = document.getElementById("accessCount"); //获取某一个div元素
                    accessCountDiv.innerHTML = ""; //将该Div元素的原有内容清空
                    var accessCount = datas[0]; //获取数组第一个内容
                    for(i=0; i<accessCount.length; i++){ //遍历该数组
                        var div = document.createElement("div"); //创建一个div元素
                        div.className = "lishi0"; //为该div元素指定class
                        var img = document.createElement("img"); //创建一个img元素
                        img.className = "lishi3-1";
                        img.src = "img/lishi1.png"; //为该img元素指定src属性
                        var p = document.createElement("p"); //创建一个p元素
                        p.className = "lishi3-2";
                        var txt = document.createTextNode(accessCount[i]); //创建一个文本内容
                        p.appendChild(txt); //将该文本内容插入到p元素中
                        div.appendChild(img); //将img元素插入到div元素中
                        div.appendChild(p);
                        accessCountDiv.appendChild(div); //将这些元素插入到获取的div元素中
                    }
                },
                error: function (XMLHttpRequest, txtStatus, errorThrown) {
                    //alert(XMLHttpRequest + "<br>" + txtStatus + "<br>" + errorThrown);
                }
            });
        }
        /**
         *   设置定时执行
         *   setTimeout(表达式,延时时间)在执行时,是在载入后延迟指定时间后,去执行一次表达式,记住,次数是一次
         *   setInterval(表达式,交互时间)则不一样,它从载入后,每隔指定的时间就执行一次表达式
         */
        setInterval('reloadView()',5000); //每15秒刷新一次页面下边显示的数据
    </script>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>有异常了，快出来看看啊</h1>
</body>
</html>