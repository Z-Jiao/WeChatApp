$(function () {
    if($(window).width() < 650 ) {
        $(".indexbox").hide();
        $(".indexbox2").show();
    }else if($(window).width() > 650){
        $(".indexbox").show();
        $(".indexbox2").hide();
    }
    $(".nav-left>ul>li").click(function () {
        var index = $(this).index();
        if($(this).children("p").html() === "﹀"){
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
        }
    })




    $(".nav-top>.row>.row1>ul>li:nth-child(3)").mouseenter(function () {
        $(".ulhidden2").show();
    })
    $(".nav-top>.row>.row1>ul>li:nth-child(3)").mouseleave(function () {
        $(".ulhidden2").hide();
    })

    $(window).resize(function () {          //当浏览器大小变化时
        if($(window).width() < 650 ) {
            $(".indexbox").hide();
            $(".indexbox2").show();
        }else if($(window).width() > 650){
            $(".indexbox").show();
            $(".indexbox2").hide();
        }
    });
    $(".logindiv>form>.btn").on("click",function () {
        location.href='register.html';

    })
    $(".ahidden>form>.btn2").on("click",function () {
        location.href='login.html';
    })

})