$(function () {
    $(".Info").click(function () {
        $.ajax({
            url:"http://localhost:8080/flower/AjaxServlet",
            type:"POST",
            data:{
                action:"peopleInfo"
            },
            success:function(data){
            },
            datatype:"json"
        })
    });
    $(".cart-block").click(function () {
        $.ajax({
            url:"http://localhost:8080/flower/AjaxServlet",
            type:"POST",
            data:{
                action:"cartItemShow"
            },
            success:function(data){
            },
            datatype:"json"
        })
    });
    $(".delete-block-fa").click(function () {
        var img_path = $(this).parent().parent().children(".pro-img").find("img").attr("src");
        if (confirm("确定要从收藏中删除此产品？")) {
            $(this).parent().parent().remove();
            $.ajax({
                url:"http://localhost:8080/flower/AjaxServlet",
                type:"POST",
                data:{
                    action:"deleteFavorite",
                    imgpath:img_path
                },
                success:function(data){
                },
                datatype:"json"
            })
        }
    })
});