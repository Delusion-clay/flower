$(function () {
    $(".form-button").click(function(){
        var username = $(".form-fields #user-name-label").val();
        var email = $(".form-fields #email-label").val();
        var emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
        //3 使用 test 方法验证是否合法
        if (!emailPatt.test(email)) {
            //4 提示用户
            $("#email-label").val("邮箱格式不合法！").css("color:#FE6732");
            return false;
        }
        var phone = $(".form-fields #phone-label").val();
        // var phonePatt = /^1(3|4|5|6|7|8|9)d{9}$/;
        // if(!phonePatt.test(phone)){
        //     $("#phone-label").val("电话号码格式有误").css("color:#FE6732");
        //     return false;
        // }
        var proposal= $(".form-fields #proposal-label").val();
        $.ajax({
            url:"http://localhost:8080/flower/AjaxServlet",
            type:"POST",
            data:{
                action:"ContactAjax",
                username:username,
                email:email,
                phone:phone,
                proposal:proposal
            },
            success:function(data){
                alert("提交成功!")
            },
            datatype:"json"
        })
    });
});