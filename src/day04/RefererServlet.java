package day04;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/referer")
public class RefererServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("----------防盗链referer----------");
        //referer : 必须有来源才会存在的头
        String refererUrl = req.getHeader("referer");

        //http://localhost:8081 : 判断是否是自己服务器来的请求
        if(null != refererUrl && refererUrl.contains("http://localhost:8081")){
            resp.sendRedirect(req.getContextPath() + "/news_detail.html");
        }else{
            System.out.println("别的网站过来的，不允许访问...");
        }

        System.out.println("测试取request域的值 ： " + req.getAttribute("name"));


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req , resp);
    }
}
