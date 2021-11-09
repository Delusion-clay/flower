package web.admin;

import bean.User;
import service.impl.UserServiceImpl;
import util.HttpServiceUtils;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response = HttpServiceUtils.setHeader(response);
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        User user = new User();
        user.setUser_name(username);
        user.setPassword(password);
        user.setEmail(email);
        UserServiceImpl userService = new UserServiceImpl();
        int i = userService.registUser(user);
        HttpServiceUtils.send(response,i+"");
    }
}
