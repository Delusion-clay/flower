$(function(){
    $(".my-wishlist a").click(function(){
        $.ajax({
            url:"http://localhost:8080/flower/AjaxServlet",
            type:"POST",
            data:{
                action:"favoritesInfo"
            }
        })
    });
    $(".add-wishlist").click(function(){
        var imgPath =$(this).parent().parent().children(".pro-img").find("img").attr("src");
        var type = $(this).parent().parent().find(".pro-content").find("p").text();
        var price = $(this).parent().parent().find(".pro-price").text();
        $.ajax({
            url:"http://localhost:8080/flower/AjaxServlet",
            type:"POST",
            data:{
                action:"favoriteLeft",
                imgpath:imgPath,
                type:type,
                price:price
            },
            success:function(data){
                // if(!data.isLogin){
                //     alert("您还未登录,请先登录!")
                //     window.location.href="http://localhost:8080/flower/login.html";
                // }
                alert("添加收藏成功");
            },
            datatype:"json"
        })
    });
});