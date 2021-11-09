<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2020/12/23
  Time: 23:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!--编码格式-->
    <meta charset="utf-8">
    <title>购物车</title>
    <!--引用js文件-->
    <script src="js/jquery-1.8.2.min.js"></script>
    <script src="js/common.js"></script>
    <script src="js/jquery.easing.1.3.js"></script>
    <script src="js/ddsmoothmenu.js"></script>
    <script src="js/jquery.flexslider.js"></script>
    <script src="js/jquery.elastislide.js"></script>
    <script src="js/jquery.jcarousel.min.js"></script>
    <script src="js/jquery.accordion.js"></script>
    <script src="js/light_box.js"></script>
    <script src="js/etao.js"></script>
    <script src="js/cart.js"></script>
    <script
            type="text/javascript">$(document).ready(function () {
        $(".inline").colorbox({inline: true, width: "50%"});
    });</script>


    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/orange.css">
    <link rel="stylesheet" href="css/skeleton.css">
    <link rel="stylesheet" href="css/layout.css">
    <link rel="stylesheet" href="css/ddsmoothmenu.css"/>
    <link rel="stylesheet" href="css/elastislide.css"/>
    <link rel="stylesheet" href="css/home_flexslider.css"/>
    <link rel="stylesheet" href="css/light_box.css"/>
    <link rel="stylesheet" href="css/cart.css"/>
    <script src="js/html5.js"></script>
</head>
<body>
<div class="mainContainer big container">
    <!--主要内容区-->
    <!--Header Block-->
    <div class="header-wrapper">
        <header class="container">
            <div class="head-right">
                <ul class="top-nav">
                    <li class=""><a href="account.jsp">我的账户</a></li>
                    <li class="my-wishlist"><a href="favorites.jsp">收藏</a></li>
                    <li class="checkout"><a href="cart.jsp">结算</a></li>
                    <li class="log-in"><a href="login.html">登录</a></li>
                </ul>

                <section class="header-bottom">
                    <!--搜索和购物车-->
                    <!--section新标签，与div类似，语义化-->
                    <div class="cart-block">
                        <!--购物车-->
                        <ul>
                            <li><a href="cart.jsp" title="购物车"><img title="购物车" alt="购物车"
                                                                    src="images/item_icon.png"/></a></li>
                            <li>购物车</li>
                        </ul>
                    </div>
                    <!--搜索框-->

                    <div class="search-block">
                        <input type="text" value="搜索"/>
                        <!--定义单行的输入字段，用户可在其中输入文本。默认宽度为 20 个字符。
                                并不是所有的主流浏览器都支持新的input类型。-->
                        <input type="submit" value="submit"/>
                        <!--submit定义提交按钮。提交按钮会把表单数据发送到服务器-->
                    </div>
                </section>
            </div>

            <!--LOGO-->
            <h1 class="logo">
                <img title="Logo" alt="Logo" src="images/logo.png"/></h1>

            <nav id="smoothmenu1" class="ddsmoothmenu mainMenu">
                <!--nav标签定义导航链接的部分，是H5的新标签，优点是语义化-->
                <ul id="nav">
                    <!--无序列表-->
                    <li class="active"><a href="index.html">首页</a></li>
                    <li><a href="category.html">全部商品</a></li>
                    <li><a href="contact_us.html">留言板</a></li>
                </ul>
            </nav>

            <!--响应式导航菜单-->
            <div class="mobMenu">
                <h1>
                    <span>菜单</span>
                    <a class="menuBox highlight" href="javascript:void(0);"></a>
                    <!--javascript：void（0）空链接，没有跳转-->
                    <span class="clearfix"></span>
                    <!--清除浮动对后面元素的影响-->
                </h1>

                <div id="menuInnner" style="display:none;">
                    <!--设置默认状态是不显示-->
                    <ul class="accordion">
                        <!--accordion：可折叠的-->
                        <!--无序列表-->
                        <li class="active"><a href="index.html">首页</a></li>
                        <li class="parent"><a href="category.html">全部商品</a></li>
                        <li class=""><a href="contact_us.html">留言板</a></li>
                        <span class="clearfix"></span>
                    </ul>
                </div>
            </div>
        </header>
    </div>

    <div class="cart-wrap">
        <table id="cartTable" class="cart table table-condensed">
            <c:if test="${empty sessionScope.cart}">
                <tr class="cart-top-two">
                    <div class="ShowIfo">
                        您的购物车为空,请检查登录或者去添加商品!!!
                    </div>
                </tr>
            </c:if>


            <c:if test="${not empty sessionScope.cart}">

            <thead class="cart-thead">
            <tr class="cart-top-one">
                <th class="t-checkbox"><label><input class="check-all check" type="checkbox"/>全选</label></th>
                <th class="t-goods text-center"><label>产品型号</label></th>
                <th class="t-selling-price text-center"><label>单价</label></th>
                <th class="t-qty text-center"><label>数量</label></th>
                <th class="t-subtotal text-center"><label>小计</label></th>
                <th class="t-action"><label>操作</label></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${sessionScope.cart}" var="cart">
                <tr class="cart-top-two">
                    <td colspan="2" class="goods">
                        <label class="label-row">
                            <input type="checkbox" class="check-one check"/>
                            <img src="${cart.img_path}" alt="" class="check-img">
                        </label>
                    </td>
                    <td></td>
                    <td class="selling-price number small-bold-red text-right" style="padding-top: 1.1rem;"
                        data-bind="${cart.price}">
                            ${cart.price}</td>
                    <td>
                        <div class="input-group input-group-sm">
                            <span class="input-group-addon minus">-</span> <input type="text"
                                                                                  class="number form-control input-sm"
                                                                                  value="${cart.count}"/>
                            <span class="input-group-addon plus">+</span>
                        </div>
                    </td>
                    <td class="subtotal number small-bold-red text-right" style="padding-top: 1.1rem;"></td>
                    <td class="action" style="padding-top: 1.1rem;"><span
                            class="delete btn btn-xs btn-warning">删除</span></td>
                </tr>
            </c:forEach>
            </c:if>
            </tbody>
        </table>

        <div class="row">
            <div class="col-md-12 col-lg-12 col-sm-12">
                <div class="cart-summary">
                    <div style="margin-left: 1rem; margin-top: 0.4rem;" class="pull-right total">
                        <label>金额合计:<span id="priceTotal" class="price-total large-bold-red">0.00</span></label>
                    </div>
                    <div style="margin-top: 4px;" class="pull-right">
                        <label>您选择了<span id="itemCount" class="large-bold-red"
                                         style="margin: 0 4px;"></span>种产品型号，共计<span
                                id="qtyCount" class="large-bold-red" style="margin: 0 4px;"></span>件
                        </label>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<section class="content-wrapper">
    <div class="content-container container">
        <div class="news-letter-container">
            <div class="free-shipping-block">
                <h1>享受免费送货服务</h1>
                <p>我们把所有的订单当做节日礼物送给你！</p>
            </div>
            <div class="news-letter-block">
                <h2>免费送货电话</h2>
                <input type="text" value="手机号"/>
                <input class="submit-btn" type="submit" value="提交"/>
            </div>
        </div>
    </div>
</section>
<!--Footer Block-->
<section class="footer-wrapper">
    <footer class="container">
        <div class="link-block">
            <ul>
                <li class="link-title"><a href="#">关于我们</a></li>
                <li><a href="#">售后政策</a></li>
                <li><a href="#">售后服务</a></li>
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
                <li class="aboutus-block">本店商品已向全国2603个区县提供自营配送服务，支持货到付款、POS机刷卡和售后上门服务，让您购物无忧！ <a href="#">更多</a></li>
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
</html>
