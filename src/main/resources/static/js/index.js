$(function () {
   var flag=true;
    $(".nav-left>ul>li:nth-child(2)>a").click(function () {
        if(flag){
            $(".nav-left>ul>li:nth-child(2)").css("backgroundColor","#203040");
            $(".ulhidden").show();
            console.log(111);
        }else {
            $(".nav-left>ul>li:nth-child(2)").css("backgroundColor","#2f4050");
            $(".ulhidden").hide();
        }
       flag=!flag;
    })
    $(".nav-top>.row>.row1>ul>li:nth-child(3)").mouseenter(function () {
        $(".ulhidden2").show();
    })
    $(".nav-top>.row>.row1>ul>li:nth-child(3)").mouseleave(function () {
        $(".ulhidden2").hide();
    })
})