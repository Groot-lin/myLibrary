package cqut.cn.edu.web;

import com.alibaba.fastjson.JSON;
import cqut.cn.edu.pojo.Book;
import cqut.cn.edu.service.Bookservice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;


@WebServlet(urlPatterns = { "/DeletebyidsServlet"})
public class DeletebyidsServlet extends HttpServlet {
    Bookservice bookservice = new Bookservice();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //接收数据
        BufferedReader br = req.getReader();
        String params = br.readLine();
        int[] ids = JSON.parseObject(params,int[].class);

        bookservice.deletebyids(ids);
        System.out.println(ids);
        //获取字符输出流
        res.getWriter().write("success");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        this.doGet(req,res);
    }
}
