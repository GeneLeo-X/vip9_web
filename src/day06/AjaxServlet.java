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
        req.setCharacterEncoding("utf-8");
        System.out.println(req.getParameter("name"));
        System.out.println(req.getParameter("age"));

        try {
            Thread.sleep(5000);//模拟业务处理与数据访问的耗时
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("测试响应数据");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req , resp);
    }
}
