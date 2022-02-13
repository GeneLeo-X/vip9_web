package day06;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ajax")
public class AjaxServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");//req ： 可以获取表单与JSON格式的数据
        System.out.println(req.getParameter("name"));
        System.out.println(req.getParameter("location"));

        /*try {
            Thread.sleep(5000);//模拟业务处理与数据访问的耗时
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("{\"pname\":\"手机\",\"price\":3999}");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req , resp);
    }
}
