package web.admin;



import service.impl.UserServiceImpl;
import util.HttpServiceUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response = HttpServiceUtils.setHeader(response);
        String username = request.getParameter("username");
        String password = request.getParameter("password");
//        Cookie usernameCookie = new Cookie("username", username);
//        response.addCookie(usernameCookie);
        request.getSession().setAttribute("username",username);
        UserServiceImpl userService = new UserServiceImpl();
        String login = userService.login(username, password);
        HttpServiceUtils.send(response,login);
    }
}
