package day04;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //若存在session则获取使用，否则创建一个新的session
        //servletContext > session也是域对象 > request
        HttpSession session = req.getSession();

        String JSEESIONID = session.getId();

        //System.out.println("JSEESIONID = " + JSEESIONID);

        Cookie cookie = new Cookie("JSESSIONID" , JSEESIONID);
        cookie.setMaxAge(60*60);//一个小时与session时效保持一致
        resp.addCookie(cookie);

        session.setAttribute("name","张三");



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req , resp);
    }
}
