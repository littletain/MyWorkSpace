package org.example.servlet;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/ServletDemo1")
public class ServletDemo1 extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setAttribute("req","Hello,Request");
        HttpSession session = request.getSession();
        session.setAttribute("ses","hello,session");
        ServletContext context = this.getServletContext();
        context.setAttribute("con","hello,context");

        System.out.println("ServletDemo1...");

        //测试上方三个作用域的不同
        String cmd = request.getParameter("cmd");
        if (cmd.equals("1")){
            //PrintUtil.work(request);
            System.out.println("request: " + request.getAttribute("req"));
            System.out.println("session: " + session.getAttribute("ses"));
            System.out.println("context: " + context.getAttribute("con"));
        }
        else if (cmd.equals("2")){
            String path = request.getContextPath();
            System.out.println(path);
            response.sendRedirect(path + "/ServletDemo2");
        }
    }

}
