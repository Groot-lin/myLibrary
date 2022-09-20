package cqut.cn.edu.web;

import cqut.cn.edu.mapper.UserMapper;
import cqut.cn.edu.pojo.User;
import cqut.cn.edu.util.SqlSessionFactoryUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet(urlPatterns = { "/RegisterServlet"})
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //接收用户名数据
        String username = req.getParameter("username");
        String password = req.getParameter("password1");


        //封装用户对象
        User user = new User();
        user.setName(username);
        user.setPassword(password);

        //mybatis查询
        SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

        SqlSession sqlSession = factory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //获取字符输出流
        res.setContentType("text/html;charset=utf-8");
        PrintWriter writer = res.getWriter();

        User isExist = userMapper.selectByUsername(username);
        if(isExist==null)
        {
            userMapper.add(user);
//            writer.write("注册成功");
            String contextpath = req.getContextPath();
            res.sendRedirect(contextpath+"/login.jsp");
            sqlSession.commit();//提交事务
            sqlSession.close();
        }
        else
        {
            String contextpath = req.getContextPath();
            res.sendRedirect(contextpath+"/login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        this.doGet(req,res);
    }
}
