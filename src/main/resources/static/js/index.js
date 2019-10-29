$(function () {
  /* var flag=true;
    $(".nav-left>ul>li:nth-child(2)>a").click(function () {
        if(flag){
            $(".nav-left>ul>li:nth-child(2)").css("height","80px");
            $(".nav-left>ul>li:nth-child(2)").css("backgroundColor","#203040");
            $(".ulhidden").show();

        }else {
            $(".nav-left>ul>li:nth-child(2)").css("height","40px");
            $(".nav-left>ul>li:nth-child(2)").css("backgroundColor","#2f4050");
            $(".ulhidden").hide();
        }
       flag=!flag;
    })*/
   /* $(".nav-left>ul>li:nth-child(2)").mouseleave(function () {
        $(".nav-left>ul>li:nth-child(2)").css("height","40px");
        $(".nav-left>ul>li:nth-child(2)").css("backgroundColor","#2f4050");
        $(".ulhidden").hide();
    })*/
    $(".nav-left>ul>li").click(function () {
        var index = $(this).index();
        if($(this).children("p").html() === "﹀"){
            $(this).children("p").html(">");
            if(index === 1 || index === 0 ){
                $(this).css("height","40px","backgroundColor","#2f4050");
                $(this).children("ul").hide();
            }
        }else{
            $(this).children("p").html("﹀");
            $(this).siblings().children("p").html(">");
            if(index === 1 || index === 0){
                $(this).css("height","80px","backgroundColor","#203040");
                $(this).children("ul").show();
            }

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
            console.log($(window).width());
            $(".indexbox").hide();
           /* $(".indexbox>.logindiv").show();*/
            $(".indexbox2").show();
        }else if($(window).width() > 650){
            $(".indexbox").show();
            $(".indexbox2").hide();
        }
    });

})