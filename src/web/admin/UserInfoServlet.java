package web.admin;


import service.impl.UserServiceImpl;
import util.HttpServiceUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserInfoServlet")
public class UserInfoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response = HttpServiceUtils.setHeader(response);
        String username = request.getParameter("username");
        UserServiceImpl userService = new UserServiceImpl();
        String user = userService.getUser(username);
        HttpServiceUtils.send(response,user);
    }
}
