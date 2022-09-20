package cqut.cn.edu.web;

import cqut.cn.edu.pojo.User;
import cqut.cn.edu.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

//initParams = {
//@WebInitParam(name = "name", value = "lizishu")
//        }
@WebServlet(urlPatterns = { "/UsernameIsExistServlet"})
public class UsernameIsExistServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String username = req.getParameter("username");

        UserService userService = new UserService();
        User user = userService.usernameIsExist(username);

        boolean isExist = user!=null;

        res.getWriter().write(""+isExist);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        this.doGet(req,res);
    }
}
