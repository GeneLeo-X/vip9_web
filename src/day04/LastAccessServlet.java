package day04;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/lastAccess")
public class LastAccessServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //处理向浏览器输入值的乱码问题
        resp.setContentType("text/html;charset=utf-8");
        //Cookie里面储存不建议中文、空格
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd+HH:mm:ss");
        String lastAccessTime = df.format(new Date());

        //使用请求对象去请求头获取cookie信息
        Cookie[] cookies = req.getCookies();
        String time = null;
        if(null != cookies){
            for (Cookie c : cookies){
                //浏览器读取服务器设定的cookie值
                if( c.getName().equals("lastAccessTime")){
                    time = c.getValue();
                }
            }
        }
        if(time == null){
            resp.getWriter().write("欢迎您，您是第一次访问我们的网站....");
        }else{
            resp.getWriter().write("欢迎您回来，您上次访问的时间为:" + time.replace("+" , " "));
        }

        Cookie cookie = new Cookie("lastAccessTime" , lastAccessTime);
        cookie.setMaxAge(60*60*24*7);//一周
        //cookie.setPath("/lastAccess");可以限制路径
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req , resp);
    }
}
