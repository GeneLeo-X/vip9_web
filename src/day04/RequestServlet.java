package day04;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

@WebServlet("/request")
public class RequestServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设定获取处理乱码问题，通常是在方法进入的时机处理
        req.setCharacterEncoding("utf-8");


        //获取请求方式 - 浏览器地址栏直接访问所有的请求都是GET方式
        String method = req.getMethod();

        System.out.println("method = " + method);

        //获取请求资源路径
        String uri = req.getRequestURI();
        System.out.println("uri 路由： " + uri);
        StringBuffer url = req.getRequestURL();

        System.out.println("url 地址 ：" + url);

        System.out.println("应用的上下文路径 : " + req.getContextPath());

//        resp.sendRedirect(req.getContextPath() + "/test.html");

        System.out.println("--------get请求方式的获取参数---------");

        //可以获取到 ? 后面的所有参数，但多个参数的时候需要使用 & 进行参数分隔
        String queryString = req.getQueryString();// - 简单了解即可
        System.out.println("queryString = " + queryString);
        //不关心本来的字符集，直接转换编码格式
        queryString = URLDecoder.decode(queryString , "utf-8");
        String[] split = queryString.split("&");
        System.out.println(Arrays.toString(split));

        System.out.println("客户端的IP地址：" + req.getRemoteAddr());

        System.out.println("----------获取请求头信息-----------");

        Enumeration<String> headerNames = req.getHeaderNames();

        while (headerNames.hasMoreElements()){
            System.out.println(headerNames.nextElement());
        }

        System.out.println("--------获取单个请求头-------");
        String header = req.getHeader("user-agent");
        System.out.println(header);

        System.out.println("----------防盗链referer----------");
        //referer : 必须有来源才会存在的头

        System.out.println("-----------------获取请求体参数(无论post、get都可以)----------");

        System.out.println("用户名: " + req.getParameter("username"));
        String username = req.getParameter("username");
        //某一个key的值的中文乱码问题，使用setCharacterEncoding方式没有处理掉的情况下，使用以下方式单独处理。
        username = new String(username.getBytes("iso8859-1"),"utf-8");


        System.out.println("爱好: " + Arrays.toString(req.getParameterValues("hobby")));

        System.out.println("-------map形式获取请求参数-------");

        Map<String, String[]> parameterMap = req.getParameterMap();

        parameterMap.forEach((k , v)-> System.out.println(k + "->" + Arrays.toString(v)));

        //servletContext > request也是一种域对象 范围是一次请求转发中
        //getRequestDispatcher : 存放请求路径 - 相当于是将处理交由其它页面或者servlet类
        //将需要其它页面或者servlet处理的内容，存储到request域中
        //内部转发地址栏不会发生变化
        req.setAttribute("name","李四");
        req.getRequestDispatcher("/requestTest").forward(req , resp);//forward : 才会执行真正的跳转


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req , resp);
    }
}
