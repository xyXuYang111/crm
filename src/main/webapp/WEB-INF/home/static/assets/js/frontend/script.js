layui.config({
    base: '/static/assets/js/frontend/'
}).extend({
    clock: 'clock'
});

layui.use(['layer', 'laytpl', 'util', 'clock'], function () {
    BMY.layui.layer = layui.layer;
    var layer=layui.layer;
    var util = layui.util;
    var clock = layui.clock;


    clock.now();
    util.fixbar({
        bar1: '留言'
        , click: function (type) {
            //console.log(type);
            if (type === 'bar1') {
               location.href = "/msg";
               //  layer.open({
               //      type: 2,
               //      title: '智能小码',
               //      shadeClose: true,
               //      shade: false,
               //      area: ['893px', '600px'],
               //      content: '/webrobot'
               //  });
            }
        }
    });
    // if($("#robot").length > 0) {
    //     var la;
    //     la = layer.tips('Hi 我是小码，什么问题都可以问我咯。', '#robot',
    //         {
    //             tips: [1, '#3595CC'],
    //             end: function () {
    //                 if($("#robot").is(":visible")) {
    //                     la = layer.tips('可以问我笑话，天气，智能聊天，故事，查询备案等等', '#robot',
    //                         {tips: [1, '#3595CC']})
    //                 }
    //             }
    //         });
    //     window.setInterval(" if($('#robot').is(':visible')) {la=layer.tips('Hi 我是小码，什么问题都可以问我咯。', '#robot', { tips: [1, '#3595CC'],end : function(){ la=layer.tips('可以问我笑话，天气，智能聊天，故事，查询备案等等', '#robot', {tips: [1, '#3595CC']});}});}", 10000*6 );
    //     //触发事件
    //     var active = {
    //         robot: function () {
    //             layer.open({
    //                 type: 2,
    //                 title: '智能小码',
    //                 shadeClose: true,
    //                 shade: false,
    //                 area: ['893px', '600px'],
    //                 content: '/webrobot',
    //                 end: function () {
    //                     $('#robot').show();
    //                 }
    //             });
    //             layer.close(la);
    //             $('#robot').hide();
    //         }
    //     };
    //     $('#robot').on('click', function () {
    //         var othis = $(this), method = othis.data('method');
    //         active[method] ? active[method].call(this, othis) : '';
    //     });
    // }
});

$(function ($) {
    var $body = $("body");
    $body.on("click", ".layui-timeline-title", function () {
        var $this = $(this);
        var $timelineBody = $this.next(".timeline-body");
        $timelineBody.slideToggle()
    });
    $body.on("click", "#note-operate #expand", function () {
        $(".timeline-body").slideUp()
    });
    $body.on("click", "#note-operate #collaspan", function () {
        $(".timeline-body").slideDown()
    });

    $("#mobile-nav").click(function () {
        var $sideNav = $(".nav-header .layui-nav-side");
        if ($sideNav.css("width") !== "0px") {
            $sideNav.animate({
                width: "0"
            }, 200)
        } else {
            $sideNav.animate({
                width: "200px"
            }, 200);

            layer.open({
                type: 1
                , title: false
                , shade: [0.6, '#000000']
                , shadeClose: true
                , closeBtn: 0
            })

        }
    });
    $body.click(function () {
        var $sideNav = $(".nav-header .layui-nav-side");
        if ($sideNav.css("width") !== "0px") {
            $sideNav.animate({
                width: "0"
            }, 200)
        }
    });

    bottomNav();
    $(window).resize(function () {
        bottomNav();
    });

});

function bottomNav() {
    var bodyHeight = $("body").outerHeight(true);
    var windowHeight = $(window).outerHeight(true);
    var $bNav = $("div.layui-fluid.bottom-nav");
    if (bodyHeight < windowHeight) {
        $bNav.css({
            position: "fixed",
            width: "100%",
            bottom: 0
        })
    } else {
        $bNav.css({
            position: "",
            width: "",
            bottom: "'"
        })
    }
}
// var ee= window.location.href;
// if(ee.indexOf("qqCallback")==-1) {
//     layui.data('url', {
//         key: 'backurl'
//         , value: ee
//     });
// }