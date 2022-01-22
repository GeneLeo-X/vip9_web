package day04;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookie")
public class CookieServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //实例化一个cookie对象
        Cookie cookie = new Cookie("name","tom");
        //为cookie设定时效
        cookie.setMaxAge(10 * 60);//10 min

        //设定指定某个路径下才会携带 cookie信息
        cookie.setPath("/cookie");
        //resp 将一个cookie设定于浏览器中
        resp.addCookie(cookie);

        Cookie c1 = new Cookie("age" , "33");
        resp.addCookie(c1);

        Cookie c2 = new Cookie("test" , "test-val");
        resp.addCookie(c2);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req , resp);
    }
}
