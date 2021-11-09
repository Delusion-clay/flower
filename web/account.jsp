<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2020/12/18
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>info</title>
    <!--js-->
    <script src="js/jquery-1.8.2.min.js"></script>
    <script src="js/common.js"></script>
    <script src="js/jquery.easing.1.3.js"></script>
    <script src="js/ddsmoothmenu.js"></script>
    <script src="js/jquery.flexslider.js"></script>
    <script src="js/jquery.elastislide.js"></script>
    <script src="js/jquery.jcarousel.min.js"></script>
    <script src="js/jquery.accordion.js"></script>
    <script src="js/light_box.js"></script>
    <script type="text/javascript">$(document).ready(function(){$(".inline").colorbox({inline:true, width:"50%"});});</script>
    <!--end js-->

    <!-- Mobile Specific Metas ================================================== -->
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">


    //<link rel="stylesheet" href="css/info.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/orange.css">
    <link rel="stylesheet" href="css/skeleton.css">
    <link rel="stylesheet" href="css/layout.css">
    <link rel="stylesheet" href="css/ddsmoothmenu.css"/>
    <link rel="stylesheet" href="css/elastislide.css"/>
    <link rel="stylesheet" href="css/home_flexslider.css"/>

    <link rel="stylesheet" href="css/light_box.css"/>
    <script src="js/html5.js"></script>

</head>
<body>
<div class="mainContainer sixteen container">
    <!--Header Block-->
    <div class="header-wrapper">
        <header class="container">
            <div class="head-right">
                <ul class="top-nav">
                    <li class=""><a href="account.jsp" title="我的账户">我的账户</a></li>
                    <li class="my-wishlist"><a href="cart.jsp" title="购物清单">购物清单</a></li>

                    <li class="checkout"><a href="cart.jsp" title="结算">结算</a></li>
                    <li class="log-in"><a href="login.html" title="登录">登录</a></li>
                </ul>

                <section class="header-bottom">
                    <div class="cart-block">
                        <ul>
                            <li><a href="cart.jsp" title="Cart"><img title="Item" alt="Item" src="images/item_icon.png" /></a></li>
                            <li>购物车</li>
                        </ul>
                    </div>
                    <div class="search-block">
                        <input type="text" value="搜索" />
                        <input type="submit" value="Search" title="Search" />
                    </div>
                </section>
            </div>
            <h1 class="logo"><a href="index.html" title="Logo">
                <img title="Logo" alt="Logo" src="images/logo.png" />
            </a></h1>
            <nav id="smoothmenu1" class="ddsmoothmenu mainMenu">
                <ul id="nav">
                    <li class=""><a href="index.html">首页</a></li>
                    <li class=""><a href="category.html">全部商品</a></li>

                    <li class="active"><a href="contact_us.html" title="Footwear">留言板</a></li>
                </ul>
            </nav>

            <div class="mobMenu">
                <h1>
                    <span>菜单</span>
                    <a class="menuBox highlight" href="javascript:void(0);">ccc</a>
                    <span class="clearfix"></span>
                </h1>
                <div id="menuInnner" style="display:none;">
                    <ul class="accordion">
                        <li class=""><a href="index-2.html" title="Home">首页</a></li>
                        <li class="parent"><a href="category.html" title="Shop by">全部商品</a>

                        </li>
                        <li class=""><a href="blog.html" title="Blog">Blog</a></li>
                        <li class=""><a href="faq.html" title="Faq">Faq</a></li>
                        <li class=""><a href="about_us.html" title="About us">About us</a></li>
                        <li class=""><a href="#" title="Pages">Pages</a></li>
                        <li class=""><a href="contact_us.html" title="Footwear">留言板</a></li>
                        <span class="clearfix"></span>
                    </ul>

                </div>
            </div>

        </header>
    </div>
    <div class="form">
        <div class="form-content">
            <div class="form-left">
                <span>我的账户<br></span>
                <span> MY ACCOUNT</span>
            </div>
            <div class="form-middle">
                <form action="">
                    <ul>
                        <li><span>用户名</span>
                            <c:if test="${empty sessionScope.username}">
                                <input type="text" class="username-field-info" placeholder="用户名">
                             </c:if>
                            <c:if test="${not empty sessionScope.username}">
                                <input type="text" class="username-field-info" value="${sessionScope.username}">
                            </c:if>
                        </li>
                        <li><span>密码</span>
                            <c:if test="${empty sessionScope.user}">
                                <input type="text" class="password-field-info" placeholder="用户密码">
                            </c:if>
                            <c:if test="${not empty sessionScope.user}">
                                <input type="text" class="password-field-info" value="${sessionScope.user.password}">
                            </c:if>
                        </li>
                        <li>
                            <span>Email</span>
                            <c:if test="${empty sessionScope.user}">
                                <input type="text" class="email-friend-info">
                            </c:if>
                            <c:if test="${not empty sessionScope.user}">
                                <input type="text"  value="${sessionScope.user.email}">
                            </c:if>
                            </li>
                        <li><span>出生日期</span><input type="date" id="birthdy" name="birthdy" placeholder="年 /月/日"></li>
                    </ul>
                </form>
            </div>

        </div>
    </div>
    <section class="content-wrapper">
        <div class="content-container container">

            <div class="clearfix"></div>
            <div class="news-letter-container">
                <div class="free-shipping-block">
                    <h1>享受免费送货服务</h1>
                    <p>我们把所有的订单当做节日礼物送给你！</p>
                </div>
                <div class="news-letter-block">
                    <h2>免费送货电话</h2>
                    <input type="text" value="手机号"/>
                    <input class="submit-btn" type="submit" value="提交" />
                </div>
            </div>
        </div>
    </section>

</div>
<!--页尾模块-->
<section class="footer-wrapper">
    <footer class="container">
        <div class="link-block">
            <ul>
                <li class="link-title"><a href="about_us.html">关于我们 </a></li>
                <li><a href="#">售后政策 </a></li>
                <li><a href="#">客户服务</a></li>
                <li><a href="#">隐私权政策</a></li>
            </ul>
            <ul>
                <li class="link-title"><a href="#">客户服务</a></li>
                <li><a href="#">退换货</a></li>
                <li><a href="#">购物保障</a></li>
                <li><a href="contact_us.html">留言板</a></li>
            </ul>
            <ul>
                <li class="link-title"><a href="#">服务条款</a></li>
                <li><a href="#">新闻中心</a></li>
                <li><a href="#">帮助</a></li>
                <li><a href="#">服务条款</a></li>
            </ul>
            <ul>
                <li class="link-title"><a href="#">我们的实力</a></li>
                <li class="aboutus-block">本店商品已向全国2603个区县提供自营配送服务，支持货到付款、POS机刷卡和售后上门服务，让您购物无忧！<a href="#">更多</a> </li>
            </ul>


            </li>
            </ul>
        </div>
        <div class="footer-bottom-block">
            <ul class="bottom-links">
                <li><a href="index.html">首页</a></li>
                <li><a href="contact_us.html">留言板</a></li>
            </ul>
            <p class="copyright-block">Copyright &copy; 2020.如意花店 All rights reserved.</p>
        </div>
    </footer>
</section>
</body>
<script type="text/javascript">

</script>
</html>
