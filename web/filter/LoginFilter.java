package cqut.cn.edu.web.filter;


import cqut.cn.edu.pojo.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebFault;
import java.io.IOException;
import java.util.logging.LogRecord;
@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest r = (HttpServletRequest) req;

        String[] urls = {"/login.jsp","/login.html","/register.html","/LoginServlet","/RegisterServlet","/UsernameIsExistServlet","/img"};

        String url = r.getRequestURL().toString();

        for(String s:urls)
        {
            if(url.contains(s))
            {
                chain.doFilter(req,res);
                return;
            }
        }

        HttpSession session = r.getSession();
        User user = (User) session.getAttribute("user");

        if(user != null)
        {
            chain.doFilter(req,res);
        }
        else
        {
            r.setAttribute("login_msg","您尚未登录");
            r.getRequestDispatcher("/login.jsp").forward(req,res);
        }

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }


    @Override
    public void destroy() {

    }

}
