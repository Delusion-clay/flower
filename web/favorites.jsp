<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2020/12/22
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>如意花店-首页</title>

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
    <script src="js/addCartRight.js"></script>
    <script src="js/account.js"></script>
    <script
            type="text/javascript">$(document).ready(function () { $(".inline").colorbox({ inline: true, width: "50%" }); });</script>

    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">


    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/orange.css">
    <link rel="stylesheet" href="css/skeleton.css">
    <link rel="stylesheet" href="css/layout.css">
    <link rel="stylesheet" href="css/ddsmoothmenu.css" />
    <link rel="stylesheet" href="css/elastislide.css" />
    <link rel="stylesheet" href="css/home_flexslider.css" />

    <link rel="stylesheet" href="css/light_box.css" />
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
                    <li class=""><a href="account.jsp" class="Info" >我的账户</a></li>
                    <li class="my-wishlist"><a href="favorites.jsp">收藏</a></li>
                    <li class="checkout"><a href="cart.jsp" class="remain_cart">结算</a></li>
                    <li class="log-in"><a href="login.html">登录</a></li>
                </ul>

                <section class="header-bottom">
                    <!--搜索和购物车-->
                    <!--section新标签，与div类似，语义化-->
                    <div class="cart-block">
                        <!--购物车-->
                        <ul>
                            <li><a href="./cart.jsp" title="购物车"><img title="购物车" alt="购物车" src="images/item_icon.png" /></a></li>
                            <li><a href="./cart.jsp">购物车</a></li>
                        </ul>
                    </div>
                    <!--搜索框-->

                    <div class="search-block">
                        <input type="text" value="搜索" />
                        <!--定义单行的输入字段，用户可在其中输入文本。默认宽度为 20 个字符。
                                并不是所有的主流浏览器都支持新的input类型。-->
                        <input type="submit" value="submit" />
                        <!--submit定义提交按钮。提交按钮会把表单数据发送到服务器-->
                    </div>
                </section>
            </div>



            <!--LOGO-->

            <h1 class="logo">
                <img title="Logo" alt="Logo" src="images/logo.png" /></h1>

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

    <!--Content Block-->
    <!--内容区-->
    <section class="content-wrapper">
        <div class="content-container container">
            <div class="heading-block">
                <h1>收藏夹</h1>
            </div>
            <div class="new-product-block">
                <ul class="product-grid">
                    <c:if test="${empty sessionScope.favoriteList}">
                        <div class="ShowIfo">
                            您的收藏夹为空!!!
                        </div>
                    </c:if>

                    <c:if test="${not empty sessionScope.favoriteList}">

                        <c:forEach items="${sessionScope.favoriteList}" var="favorite">
                            <li>
                                <div class="pro-img">
                                    <img title="Freature Product" alt="Freature Product" src="${favorite.img_path}" />
                                </div>
                                <div class="pro-content">
                                    <p class="flower-type">${favorite.type}</p>
                                </div>
                                <div class="pro-price">￥${favorite.price}</div>
                                <div class="pro-btn-block">
                                    <a class="add-cart left delete-block-fa">删除收藏</a>
                                    <a class="add-cart right quickCart inline" href="#quick-view-container" title="快速浏览">查看商品</a>
                                </div>
                            </li>
                        </c:forEach>
                    </c:if>


                </ul>
            </div>

            <div class="news-letter-container">
                <div class="free-shipping-block">
                    <h1>享受免费送货服务</h1>
                    <p>我们把所有的订单当做节日礼物送给你！</p>
                </div>
                <div class="news-letter-block">
                    <h2>免费送货电话</h2>
                    <input type="text" value="手机号" />
                    <input type="submit" value="提交" />
                    <!--submit：定义提交按钮-->
                </div>
            </div>
        </div>
    </section>
</div>
<script type="text/javascript">
    jQuery(function () {
        var tabContainers = jQuery('div.tabs > div');
        tabContainers.hide().filter(':first').show();
        jQuery('div.tabs ul.tabNavigation a').click(function () {
            tabContainers.hide();
            tabContainers.filter(this.hash).show();
            jQuery('div.tabs ul.tabNavigation a').removeClass('selected');
            jQuery(this).addClass('selected');
            return false;
        }).filter(':first').click();
    });
</script>



<article style="display:none;">
    <!--<article> 标签是H5的新标签,语义化
<article>标签定义的内容本身必须是有意义的且必须是独立于文档的其余部分-->
    <section id="quick-view-container" class="quick-view-wrapper">
        <div class="quick-view-container">
            <div class="quick-view-left">
                <!--快速浏览左边内容-->
                <h2>百合花束 鲜花花束</h2>
                <div class="product-img-box">
                    <p class="product-image">
                        <img src="images/sale_icon_img.png" title="Sale" alt="Sale" class="sale-img" />
                        <a href="index.html"><img src="images/quick_view_img1.png" title="Image" alt="Image" /></a> </p>
                    <!--            <ul class="thum-img">-->
                    <!--              <li><img src="images/quick_thum_img1.png" title="小图" alt="image" /></li>-->
                    <!--              <li><img src="images/quick_thum_img2.png" title="小图" alt="image" /></li>-->
                    <!--            </ul>-->
                </div>
            </div>


            <div class="quick-view-right tabs">
                <!--tab：标签页-->
                <!--快速浏览右边内容-->
                <ul class="tab-block tabNavigation">
                    <!--Navigation：导航-->
                    <li><a class="selected" href="#tabDetail">概览</a></li>
                    <li><a href="#tabDes">鲜花详情</a></li>
                </ul>

                <div id="tabDetail" class="tabDetail">
                    <div class="first-review">此商品为鲜活易腐类，不支持7天无理由退货</div>
                    <div class="price-box">
                        <span class="price">￥69.00</span></div>
                    <div class="availability">有库存</div>


                    <div class="color-size-block">
                        <div class="label-row">
                            <!--label：标签；row：行，排-->
                            <label><em>*</em> 颜色</label>
                            <span class="required">* 必填项</span>
                        </div>
                        <div class="select-row">
                            <select>
                                <option> 红色 </option>
                                <option> 蓝色 </option>
                                <option> 粉色 </option>
                                <option> 紫色 </option>
                            </select>
                            <!--select元素用来创建下拉列表，
                                     <select>元素中的<option>标签定义了列表中的可用选项-->
                        </div>


                        <div class="label-row">
                            <label><em>*</em>支付方式</label>
                        </div>
                        <div class="select-row">
                            <select id="paymentMethod">
                                <option>余额宝支付</option>
                            </select>
                        </div>
                    </div>

                    <div class="add-to-cart-box">
                        <!--快速浏览的加入购物车-->
                        <span class="qty-box">
                <label for="qty">数量:</label>
                <a class="prev" href="#"><img alt="" title="" src="images/qty_prev.png"></a>
                <input type="text" name="qty" class="input-text qty count-type" id="qty" maxlength="12" value="1">
                <a class="next" href="#"><img alt="" title="" src="images/qty_next.png"></a> </span>
                        <button title="加入购物车" class="form-button"><span>加入购物车</span></button>
                        <!--<button> 标签定义一个按钮。
                          在 <button> 元素内部可以放置内容，比如文本或图像。
                          这是该元素与使用 <input>元素创建的按钮之间的不同之处-->
                    </div>
                </div>



                <div id="tabDes" class="tabDes">
                    <div> 如意花店适用场景: 爱意表达 生日 祝福 婚礼 探望 其他 求婚 友情 周年纪念</div>
                    <div>鲜花主花材: 百合适用对象: 爱人 老师 客户 领导/长辈 朋友/同事 病人鲜花朵数: 11朵</div>
                    <div>适用节日: 情人节 圣诞节 春节 3.8妇女节 母亲节 感恩节 教师节 中秋节 七夕 白色情人节</div>
                    <div>鲜花绿植工艺: 鲜花(鲜切花)鲜花规格(直径X高): 35*55花束辅材: 黄莺/满天星/勿忘我</div>
                </div>
            </div>
            <div class="clearfix"></div>
        </div>
    </section>
</article>








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
                <li class="aboutus-block">本店商品已向全国2603个区县提供自营配送服务，支持货到付款、POS机刷卡和售后上门服务，让您购物无忧！ <a href="#">更多</a> </li>
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
