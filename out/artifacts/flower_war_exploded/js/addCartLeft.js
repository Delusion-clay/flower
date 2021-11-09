$(function(){
    $(".left").click(function(){
         var imgPath =$(this).parent().parent().children(".pro-img").find("img").attr("src");
         var type = $(this).parent().parent().find(".pro-content").find("p").text();
         var price = $(this).parent().parent().find(".pro-price").text();
         $.ajax({
             url:"http://localhost:8080/flower/AjaxServlet",
             type:"POST",
             data:{
                 action:"addCartItemLeft",
                 imgpath:imgPath,
                 type:type,
                 price:price
             },
             success:function(data){
                 // if(!data.isLogin){
                 //     alert("您还未登录,请先登录!")
                 //     window.location.href="http://localhost:8080/flower/login.html";
                 // }
             },
             datatype:"json"
         })
    });
    $(".checkout a").click(function () {
        $.ajax({
            url:"http://localhost:8080/flower/AjaxServlet",
            type:"POST",
            data:{
                action:"cartItemShow"
            }
        })
    });
});