package day04;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookieTest")
public class CookieTestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //使用请求对象去请求头获取cookie信息
        Cookie[] cookies = req.getCookies();
        if(null != cookies){
            for (Cookie c : cookies){
                //浏览器读取服务器设定的cookie值
                if( c.getName().equals("test")){
                    System.out.println(c.getValue());
                }
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req , resp);
    }
}
