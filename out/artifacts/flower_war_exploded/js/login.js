//登录功能
$(function () {
    var BaseUrl = "http://localhost:8080/flower/";
    window.getUrl = function (url) {
        return BaseUrl + url;
    };

    $(".login-sub").click(function () {
        var username = $("#username").val();
        var password = $("#password").val();
        $.ajax({
            url: getUrl("/admin/login"),
            type: "post",
            data: {
                username: username,
                password: password,
            },
            success:function(data) {
                data = JSON.parse(data);
                switch (data.code) {
                    case 100:
                        alert("登录成功");
                        window.location.href = "http://localhost:8080/flower/";
                        break;
                    case 102:
                        alert("登录失败");
                        break;
                    case 103:
                        alert("登录失败");
                }
            }
        })
    });
});