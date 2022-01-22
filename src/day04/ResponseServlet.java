package day04;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/response")
public class ResponseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过响应对象设置响应行的内容
        //状态码
        resp.setStatus(400);//主动设置状态码

        //设置响应头
        //允许同名的key存在，添加多个值。
        resp.addHeader("name","lisi");
        resp.addIntHeader("age",33);
        resp.addDateHeader("birthday",new Date().getTime());
        resp.addHeader("name","wangwu");

        System.out.println("------------------");
        //set方式设置头，相当于仅允许有一个同名key存在。--相当于set集合
        resp.setHeader("name","zhaoliu");

        //设置重定向 - 会改变地址栏请求信息（URL）
        /*resp.setStatus(302);//重定向的状态码
        resp.setHeader("Location" , "/quickServlet");*///url : 重定向跳转的地址
        //封装好的重定向方法
        resp.sendRedirect("/test.html");//应用上下文路径，Application Context - 若为/就不需要写。但是上线或者新IDEA版本自带路径的话就需要手动添加
        System.out.println("------------向响应体中输出内容----------");

        //resp.setCharacterEncoding("utf-8");//简单了解 --不使用
        resp.setContentType("text/html;charset=utf-8");//推荐使用的，兼容了setCharacterEncoding该种方式
        resp.getWriter().write("测试响应回浏览器的数据....text");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req , resp);
    }
}
