package cqut.cn.edu.web;

import com.alibaba.fastjson.JSON;
import cqut.cn.edu.pojo.Book;
import cqut.cn.edu.pojo.Paging;
import cqut.cn.edu.service.Bookservice;
import scala.Int;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = { "/SelectbypageServlet"})
public class SelectByPageSerlvet extends HttpServlet {
    Bookservice bookservice = new Bookservice();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int currentpage = Integer.parseInt(req.getParameter("currentpage"));
        int pagesize = Integer.parseInt(req.getParameter("pagesize"));

        Paging<Book> page = bookservice.selectbypage(currentpage,pagesize);

        String jsonString = JSON.toJSONString(page);

        res.setContentType("text/json;charset=utf-8");
        res.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        this.doGet(req,res);
    }
}