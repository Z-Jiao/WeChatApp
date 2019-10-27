$(function () {
   var flag=true;
    $(".nav-left>ul>li:nth-child(2)").click(function () {
        if(flag){
            $(".nav-left>ul>li:nth-child(2)").css("backgroundColor","#203040");
            $(".ulhidden").show();
        }else {
            $(".nav-left>ul>li:nth-child(2)").css("backgroundColor","#2f4050");
            $(".ulhidden").hide();
        }
       flag=!flag;
    })
    $(".nav-top>.row ul>li:nth-child(3)").mousemove(function () {

    })
})