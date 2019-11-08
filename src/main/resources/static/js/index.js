$(function () {

    /*var ulclick = function () {
        console.log(123);
        var that = $(".slimScrollDiv>.ul-one>li");
        var index = $(this).index();
        if($(that).find("img:eq(1)")[0].src === "http://localhost:63342/wechatapp/static/images/icon/bottom.png"){

            $(that).find("img:eq(1)").attr("src","../../static/images/icon/right.png")

            if(index === 3 || index === 2 ){
                console.log(11111);
                $(that).css("height","50px","backgroundColor","#2f4050");
                $(that).children("ul").hide();
            }
        }else {
            if (index === 3 || index === 2) {
                $(that).css("height", "100px", "backgroundColor", "#203040");
                $(that).children("ul").show();
            }

            $(that).find("img:eq(1)").attr("src","../../static/images/icon/bottom.png")
            $(that).siblings("li").find("img:eq(1)").attr("src","../../static/images/icon/right.png")
            $(that).siblings("li").children("ul").hide();
            $(that).siblings("li").css("height","50px","backgroundColor","#2f4050");

        }
    }*/

    if($(window).width() < 650 ) {
        $(".indexbox").hide();
        $(".indexbox2").show();
        $(".slimScrollDiv>.ul-one>li").click(function () {
            var index = $(this).index();
            if($(this).find("img:eq(1)")[0].src === "http://localhost:63342/wechatapp/static/images/icon/bottom.png"){

                $(this).find("img:eq(1)").attr("src","../../static/images/icon/right.png")

                if(index === 3 || index === 2 ){
                    $(this).css("height","50px","backgroundColor","#2f4050");
                    $(this).children("ul").hide();
                }
            }else {
                if (index === 3 || index === 2) {
                    $(this).css("height", "100px", "backgroundColor", "#203040");
                    $(this).children("ul").show();
                }

                $(this).find("img:eq(1)").attr("src","../../static/images/icon/bottom.png")
                $(this).siblings("li").find("img:eq(1)").attr("src","../../static/images/icon/right.png")
                $(this).siblings("li").children("ul").hide();
                $(this).siblings("li").css("height","50px","backgroundColor","#2f4050");

            }
        })
    }else if($(window).width() > 650){
        $(".indexbox").show();
        $(".indexbox2").hide();
        $(".slimScrollDiv>.ul-one>li").click(function () {
            var index = $(this).index();
            if($(this).find("img:eq(1)")[0].src === "http://localhost:63342/wechatapp/static/images/icon/bottom.png"){

                $(this).find("img:eq(1)").attr("src","../../static/images/icon/right.png")

                if(index === 3 || index === 2 ){
                    $(this).css("height","50px","backgroundColor","#2f4050");
                    $(this).children("ul").hide();
                }
            }else {
                if (index === 3 || index === 2) {
                    $(this).css("height", "100px", "backgroundColor", "#203040");
                    $(this).children("ul").show();
                }

                $(this).find("img:eq(1)").attr("src","../../static/images/icon/bottom.png")
                $(this).siblings("li").find("img:eq(1)").attr("src","../../static/images/icon/right.png")
                $(this).siblings("li").children("ul").hide();
                $(this).siblings("li").css("height","50px","backgroundColor","#2f4050");

    }
    })

        /*$(".nav>li:eq(2)>a").mousemove(function () {
            $(".dropdown-menu").show();
        })
        $(".nav>li:eq(2)>a").mouseleave(function () {
            $(".dropdown-menu").hide();
        })*/
    }

    $(window).resize(function () {//当浏览器大小变化时
        if($(window).width() < 650 ) {
            $(".indexbox").hide();
            $(".indexbox2").show();

            $(".ul-one .ul-h ").hide();
            $(".ul-one>li").css("height","48px")
            $(".navleft").css("width","70px");
            $(".wrapperRight").css("marginLeft","70px");
            $(".ul-one>a").hide();
            $(".ul-one>li>a>span").hide()
            $(".ul-one>li").find("img:eq(1)").hide()

            $(".slimScrollDiv>.ul-one>li").click(function () {
                $(".navleft").css("width","200px");
                $(".wrapperRight").css("marginLeft","200px");
                $(".ul-one>a").show();
                $(".ul-one>li>a>span").show()
                $(".ul-one>li").find("img:eq(1)").show()

            })
        }else if($(window).width() > 650){
            $(".indexbox").show();
            $(".indexbox2").hide();
        }
    });




    /*main.html   JS代码*/
/*    $(".logindiv>form>.btn").on("click",function () {
        location.href='register.html';

    })
    $(".ahidden>form>.btn2").on("click",function () {
        location.href='login.html';
    })
    $(".color:nth-child(3)").mouseenter(function () {
        $(".ulhidden2").show();
    })
    $(".color:nth-child(3)").mouseleave(function () {
        $(".ulhidden2").hide();
    })*/


        /*if($(this).children("p").html() === "﹀"){
            $(this).children("p").html("〉");
            if(index === 1 || index === 0 ){
                $(this).css("height","40px","backgroundColor","#2f4050");
                $(this).children("ul").hide();
            }
        }else{
            if(index === 1 || index === 0){
                $(this).css("height","80px","backgroundColor","#203040");
                $(this).children("ul").show();
            }
            $(this).children("p").html("﹀");
            $(this).siblings().children("p").html("〉");
            $(this).siblings().children("ul").hide();
            $(this).siblings().css("height","40px","backgroundColor","#2f4050");
        }*/

})