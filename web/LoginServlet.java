package cqut.cn.edu.web;

import cqut.cn.edu.mapper.UserMapper;
import cqut.cn.edu.pojo.User;
import cqut.cn.edu.service.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

//initParams = {
//@WebInitParam(name = "name", value = "lizishu")
//        }
@WebServlet(urlPatterns = { "/LoginServlet"})
public class LoginServlet extends HttpServlet {
    private UserService service = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //接收用户名密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");


        User user = service.login(username,password);

        //获取字符输出流
        res.setContentType("text/html;charset=utf-8");
        PrintWriter writer = res.getWriter();
        //判断
        if(user!=null)
        {
            HttpSession session = req.getSession();
            session.setAttribute("user",user);

            String contextpath = req.getContextPath();
            res.sendRedirect(contextpath+"/mylibrary.html");
        }
        else
        {
            req.setAttribute("login_msg","用户名或密码错误");
            req.getRequestDispatcher("/login.jsp").forward(req,res);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        this.doGet(req,res);
    }
}
