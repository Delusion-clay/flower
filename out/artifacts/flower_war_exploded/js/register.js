$(function () {
    var BaseUrl = "http://localhost:8080/flower";
    window.getUrl=function (url) {
        return BaseUrl + url;
    };

    /**
     * @description: 生成随机数
     * @param min 随机数最低取值
     * @param max 随机数最高取值
     * @return 返回所取得的随机数
     */
    function rand(min, max) {
        return Math.floor(Math.random() * (max - min) + min);
    }

    /**
     * @description: 注册页面验证码生成函数
     * @param ele 装验证码的元素
     * @return {*}
     */
    function verification(ele) {
        //验证码字体颜色
        var color = ["#0097A7", "#b2ebf2", "#FFFFFF", "#FFEB3B", "#8BC34A", "#C8E6C9", "#388E3C", "#795548", "#757575", "#512DA8", "#D1C4E9"];
        var verifi = ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "A", "S", "D", "F", "G", "H", "J", "K", "L", "Z", "X", "C", "V", "B", "N", "M"];
        var sym = ["-", "+"];
        var symLen = sym.length;
        var colorLen = color.length;
        var vLen = verifi.length;
        ele.children("span").each(function () {
            $(this).css({
                "color": color[rand(0, colorLen)],
                "fontSize": rand(22, 36) + "px",
                "fontWeight": rand(300, 900),
                "transform": "translateY(" + sym[rand(0, symLen)] + rand(0, 6) + "px)" + " " + "rotate(" + sym[rand(0, symLen)] + rand(0, 60) + "deg)"
            });
            $(this).text(verifi[rand(0, vLen)]);
        });
    }

    /**
     * @description: 验证验证码是否输入正确
     * @param target 验证码元素
     * @param input 用户输入的验证码元素
     * @return 相等返回true,否则返回false
     */
    function isEqul(target, input) {
        var v = "";
        var value = input.val();
        target.children("span").each(function () {
            v += $(this).html();
        });
        return value.toLocaleLowerCase() == v.toLocaleLowerCase();
    };

    /**
     * @description: 邮箱验证函数
     * @param 需验证的邮箱
     * @return 验证通过返回true,否则返回false
     */
    function fChkMail(szMail) {
        var szReg = /^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,5}$/;
        var bChk = szReg.test(szMail);
        return bChk;
    }

    /**
     * @description: 设置全局的ajax
     */
    $.ajaxSetup({
        beforeSend: function () {
        }
    });
    $(document).ajaxSuccess(function () {
    });

    init();
    /**
     * @description: 初始化网站首页数据
     */
    function init() {
        verification($(".vertifi"));

        $(".user .regist").on("click", function () {
            $(".user .regist-contain").css("display", "block");
            $(".user .login-contain").css("display", "none");
            verification($(".vertifi"));
            $(".user input").val("");
        });

        $(".vertifi").on("click", function () {
            verification($(this));
        });

        $(".regist-sub").on("click", function () {
            $(".user .input>div>div.massage").removeClass("mass-show");
            var username = $(".input-regist>.username>input").val();
            var password1 = $(".input-regist>.password1>input").val();
            var password2 = $(".input-regist>.password2>input").val();
            var email = $(".input-regist>.email>input").val();
            var verifiVal = $(".verification>input");
            var verifiTartget = $(".verification>.vertifi");
            if ((password1 == password2) && password1.length >= 6) {
                if (fChkMail(email)) {
                    if (isEqul(verifiTartget, verifiVal)) {
                        $.ajax({
                            url: getUrl("/admin/regist"),
                            type: "POST",
                            data: {
                                username: username,
                                password: password1,
                                email: email
                            },
                            success: function (data) {
                                data = parseInt(data);
                                if (data != -1) {
                                    alert("注册成功");
                                    window.location.href="http://localhost:8080/flower/login.html";
                                } else {
                                    $(".input-regist>.username>div.massage").addClass("mass-show");
                                }
                            }
                        });
                    } else {
                        $(".verification>div.massage").addClass("mass-show");
                        verification($(".vertifi"));
                    }
                } else {
                    $(".input-regist>.email>div.massage").addClass("mass-show");
                }
            } else {
                $(".input-regist>.password1>div.massage").addClass("mass-show");
                $(".input-regist>.password2>div.massage").addClass("mass-show");
            }
        });

    }
});