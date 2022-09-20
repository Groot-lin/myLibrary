package cqut.cn.edu.web;

import com.alibaba.fastjson.JSON;
import cqut.cn.edu.pojo.Book;
import cqut.cn.edu.pojo.User;
import cqut.cn.edu.service.Bookservice;
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

import java.util.List;

@WebServlet(urlPatterns = { "/SelectAllServlet"})
public class SelectAllSerlvet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Bookservice bookservice = new Bookservice();

        List<Book> books = bookservice.selectAll();

        String jsonString = JSON.toJSONString(books);

        res.setContentType("text/json;charset=utf-8");
        res.getWriter().write(jsonString);



//        jsp老方法
//        List<Book> books = bookservice.selectAll();
//        System.out.println(books);
//        req.setAttribute("Books",books);
//        req.getRequestDispatcher("/book.jsp").forward(req,res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        this.doGet(req,res);
    }
}