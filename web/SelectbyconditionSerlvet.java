package cqut.cn.edu.web;

import com.alibaba.fastjson.JSON;
import cqut.cn.edu.pojo.Book;
import cqut.cn.edu.pojo.Paging;
import cqut.cn.edu.service.Bookservice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(urlPatterns = { "/SelectbyconditionServlet"})
public class SelectbyconditionSerlvet extends HttpServlet {
    Bookservice bookservice = new Bookservice();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        BufferedReader br = req.getReader();
        String params = br.readLine();
        Book book = JSON.parseObject(params,Book.class);

        int currentpage = Integer.parseInt(req.getParameter("currentpage"));
        int pagesize = Integer.parseInt(req.getParameter("pagesize"));

        Paging<Book> page = bookservice.selectbycondition(currentpage,pagesize,book);

        String jsonString = JSON.toJSONString(page);

        res.setContentType("text/json;charset=utf-8");
        res.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        this.doGet(req,res);
    }
}