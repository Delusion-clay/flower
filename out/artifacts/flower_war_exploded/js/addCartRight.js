$(function(){
    $(".inline").click(function(){
        var img_path = $(this).parent().parent().parent().children(".pro-img").find("img").attr("src");
        var price = $(this).parent().parent().parent().children(".pro-price").text();
        function setBanager(){
                $(".product-image a img").attr("src",img_path).css({"width":"243px","height":"260px"});
                $(".price-box .price").text(price);
        }
        setBanager();

    });
    $(".right").click(function(){
        var imgPath =$(this).parent().parent().children(".pro-img").find("img").attr("src");
        var type = $(this).parent().parent().find(".pro-content").find("p").text();
        var price = $(this).parent().parent().find(".pro-price").text();
        function setImgRight(){
            $(".product-image a img").attr("src",imgPath).css({"width":"243px","height":"260px"});
            $(".price-box .price").text(price);
        }
        setImgRight();
        $(".form-button").click(function(){
            var count = $(".count-type").val();
            $.ajax({
                url:"http://localhost:8080/flower/AjaxServlet",
                type:"POST",
                data:{
                    action:"addCartItemRight",
                    imgpath:imgPath,
                    type:type,
                    price:price,
                    count:count
                },
                success:function(data){
                },
                datatype:"json"
            });

        });
    });

});
