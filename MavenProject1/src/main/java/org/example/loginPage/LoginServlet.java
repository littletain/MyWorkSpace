package org.example.loginPage;

import org.example.dao.JdbcUserDao;
import org.example.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset-UTF-8");

        //验证码核对
        HttpSession session = request.getSession();
        String str = request.getParameter("checkCode");
        String targetCode = (String)session.getAttribute("targetCode");
        //System.out.println("target:" + targetCode);
        //System.out.println("check:" + str);
        if (targetCode.equalsIgnoreCase(str)){//忽略大小写的字符串比较，如果验证码正确
            System.out.println("Bingo!");
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
            JdbcUserDao jdbcUserDao = new JdbcUserDao();
            User user = jdbcUserDao.login(userName,password);
            if (user != null){ //如果存在此用户
                request.setAttribute("userName",userName);
                request.getRequestDispatcher("/LoginSuccess").forward(request,response);
            } else {
                response.getWriter().write("<script>alert(\"验证码错误\");</script>");
                response.sendRedirect("/MavenProject1/login.html");
            }
        } else {
            System.out.println("Oh,No!");
            //用jsp技术无法动静分离，ajax只是异步加载，好像不是同一个事物，要了解前端框架才可以
            //现在的写法只能跳转，看不到alert
            response.getWriter().write("<script>alert(\"验证码错误\");</script>");
            response.sendRedirect("/MavenProject1/login.html");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
