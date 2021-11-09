package web;

import bean.CartItem;
import bean.Contact_us;
import bean.Favorite;
import bean.User;
import service.*;
import service.impl.*;
import util.JsonTransformation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@WebServlet("/AjaxServlet")
public class AjaxServlet extends BaseServlet {
    JsonTransformation jsonTransformation = new JsonTransformation();
    Contact_usService contact_usService = new Contact_usServiceImpl();
    CartItemService cartItemService = new CartItemServiceImpl();
    UserService userService = new UserServiceImpl();
    CartShowService cartShowService = new CartShowServiceImpl();
    QueryInfoService queryInfoService = new QueryInfoServiceImpl();
    FavoriteService favoriteService = new FavoriteServiceImpl();
    protected void ContactAjax(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String proposal = request.getParameter("proposal");
        Contact_us contact_us = new Contact_us(username, email, phone, proposal);
        System.out.println(contact_us);
        contact_usService.save(contact_us);
    }
    protected void addCartItemLeft(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HashMap<String, Object> map = new HashMap<>();
        String username = (String) request.getSession().getAttribute("username");
        if (username==null){
            System.out.println("没登录");
            map.put("isLogin",false);
            System.out.println(map);
            String json = jsonTransformation.MapToJson(map);
            response.getWriter().write(json);
            //request.getRequestDispatcher("http://localhost:8080/flower/login.html").forward(request,response);
        }else {
            map.put("isLogin",true);
            int id = userService.getIdByUsername(username);
            System.out.println(id);
            String img_path = request.getParameter("imgpath");
            String type = request.getParameter("type");
            String price = request.getParameter("price");
            String subPrice = price.substring(1);
            System.out.println(cartItemService.queryCartItem(id,img_path));
            if (!cartItemService.queryCartItem(id,img_path)){
                CartItem item = new CartItem(id, img_path, type, subPrice);
                System.out.println(item);
                cartItemService.addCart(item);
            }else {
                int i = cartItemService.queryCount(img_path);
                cartItemService.updateCount(img_path,i+1);
            }
        }
    }
    protected void addCartItemRight(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = (String) request.getSession().getAttribute("username");
        HashMap<String, Object> map = new HashMap<>();
        if (username==null){
            System.out.println("没登录");
            map.put("isLogin",false);
            System.out.println(map);
            String json = jsonTransformation.MapToJson(map);
            response.getWriter().write(json);
            //request.getRequestDispatcher("http://localhost:8080/flower/login.html").forward(request,response);
        }else {
            map.put("isLogin",true);
            int id = userService.getIdByUsername(username);
            String img_path = request.getParameter("imgpath");
            String type = request.getParameter("type");
            String price = request.getParameter("price");
            String subPrice = price.substring(1);
            int count = Integer.parseInt(request.getParameter("count"));
            if (!cartItemService.queryCartItem(id,img_path)){
                CartItem item = new CartItem(id,img_path,type,count,subPrice);
                System.out.println(item);
                cartItemService.addCart(item);
            }else {
                int i = cartItemService.queryCount(img_path);
                cartItemService.updateCount(img_path,i+count);
            }
        }


    }
    protected void cartItemShow(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = (String) request.getSession().getAttribute("username");
        System.out.println(username);
        if (username==null){
            System.out.println("未登录！");
        }else {
            int idByUsername = userService.getIdByUsername(username);
            List<CartItem> cartList = cartShowService.findAll(idByUsername);
            System.out.println(cartList);
            request.getSession().setAttribute("cart",cartList);
            System.out.println(request.getSession().getAttribute("cartList"));
        }
    }
    protected void cartItemDelete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String imgpath = request.getParameter("imgpath");
        String username = (String) request.getSession().getAttribute("username");
        int id = userService.getIdByUsername(username);
        cartItemService.deleteCartItem(id,imgpath);

    }
    protected void peopleInfo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = (String) request.getSession().getAttribute("username");
        User user = queryInfoService.queryInfo(username);
        System.out.println(user);
       request.getSession().setAttribute("user",user);
    }
    protected void favoriteLeft(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HashMap<String, Object> map = new HashMap<>();
        String username = (String) request.getSession().getAttribute("username");
        if (username==null){
            System.out.println("没登录");
            map.put("isLogin",false);
            System.out.println(map);
            String json = jsonTransformation.MapToJson(map);
            response.getWriter().write(json);
            //request.getRequestDispatcher("http://localhost:8080/flower/login.html").forward(request,response);
        }else {
            map.put("isLogin",true);
            int id = userService.getIdByUsername(username);
            System.out.println(id);
            String img_path = request.getParameter("imgpath");
            String type = request.getParameter("type");
            String price = request.getParameter("price");
            System.out.println(price);
            String subPrice = price.substring(1);
            System.out.println(favoriteService.queryFavoriteItem(id,img_path));
            if (!favoriteService.queryFavoriteItem(id,img_path)){
                Favorite favorite = new Favorite(id, img_path, type, subPrice);
                System.out.println(favorite);
                favoriteService.addFavorite(favorite);
            }else {
                System.out.println("已存在");
            }
        }
    }
    protected void favoritesInfo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = (String) request.getSession().getAttribute("username");
        System.out.println(username);
        if (username==null){
            System.out.println("未登录！");
        }else {
            int idByUsername = userService.getIdByUsername(username);
            List<Favorite> favoriteList = favoriteService.findAll(idByUsername);
            System.out.println(favoriteList);
            request.getSession().setAttribute("favoriteList",favoriteList);
            System.out.println(request.getSession().getAttribute("favoriteList"));
        }
    }
    protected void deleteFavorite(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String imgpath = request.getParameter("imgpath");
        favoriteService.deleteFavorite(imgpath);
    }
}
