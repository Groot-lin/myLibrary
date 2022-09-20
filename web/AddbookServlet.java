package cqut.cn.edu.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import cqut.cn.edu.mapper.UserMapper;
import cqut.cn.edu.pojo.Book;
import cqut.cn.edu.pojo.User;
import cqut.cn.edu.service.Bookservice;
import cqut.cn.edu.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



@WebServlet(urlPatterns = { "/AddbookServlet"})
public class AddbookServlet extends HttpServlet {
    Bookservice bookservice = new Bookservice();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //接收数据
        BufferedReader br = req.getReader();
        String params = br.readLine();
        Book book = JSON.parseObject(params,Book.class);
        System.out.println(book);
        bookservice.addbook(book);

        //获取字符输出流
        res.getWriter().write("success");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        this.doGet(req,res);
    }
}
