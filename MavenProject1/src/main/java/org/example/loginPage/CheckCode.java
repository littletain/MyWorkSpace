package org.example.loginPage;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/CheckCode")
public class CheckCode extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        //画出图片背景以及边框
        int width = 100;
        int height = 50;
        BufferedImage img = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics graphics = img.getGraphics();//画笔
        graphics.setColor(Color.pink);
        graphics.fillRect(0,0,width,height);
        graphics.setColor(Color.BLUE);
        graphics.drawRect(0,0,width-1,height-1);

        //生成随机验证码，写入到图片，并存储到StringBuilder，写入session
        Random random = new Random();
        String str = "QWERTYUIOPASDFGHJKLZXCVBNM1234567890qwertyuiopasdfghjklzxcvbnm";
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<4; i++)
        {
            int index = random.nextInt(str.length());
            char ch = str.charAt(index);
            sb.append(ch);
            graphics.drawString(ch+"",width/5 * (i+1),height/2);
        }
        //toString操作很重要，不然在Login里面获取session会报错，详情见/test/StringToStringBuilder.java
        session.setAttribute("targetCode",sb.toString());
        ImageIO.write(img,"jpg",response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
