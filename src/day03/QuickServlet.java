package day03;

import javax.servlet.*;
import java.io.IOException;

/**
 * 1、下载servlet的jar包导入
 * 2、直接使用Tomcat里面内置的servlet与jsp包
 *
 * 常用方法介绍：
 * init - 初始化的，信息、数据 - 第一次访问调用
 * service - 业务方法，每次访问必会调用
 * destroy - 销亡方法，销毁的时候调用(服务器关闭)
 * getServletConfig - 获取Servlet配置对象的，需要获取Servlet相关信息的时候可以使用
 *
 * ServletContext对象
 *
 * 1、可以获取配置的全局参数
 * 2、获取某个文件的绝对路径
 * 3、它一个域对象（四大域对象），范围最大的域对象
 */
public class QuickServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init method called...");

        System.out.println("servletConfig : " + servletConfig.getInitParameter("test-param"));
        //一个web应用只有一个servletContext对象
        ServletContext servletContext = servletConfig.getServletContext();

        System.out.println("servletContext 获取全局参数配置 ： " + servletContext.getInitParameter("test-grobal-param"));

        System.out.println("绝对路径 ： " + servletContext.getRealPath("img/dfg.jpg"));
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service method called...");
        //打印流
        /*servletResponse.getWriter().write("<html lang=\"en\">");
        servletResponse.getWriter().write("<head>");
        servletResponse.getWriter().write("<meta charset=\"UTF-8\">");
        servletResponse.getWriter().write(" <title>第一个页面</title>");
        servletResponse.getWriter().write("</head>");
        servletResponse.getWriter().write("<body>");
        servletResponse.getWriter().write(" 学习web应用的第一天...");
        servletResponse.getWriter().write("<img src=\"img/dfg.jpg\"/>");
        servletResponse.getWriter().write("</body>");
        servletResponse.getWriter().write("</html>");*/

    }

    @Override
    public void destroy() {

        //统一关闭处理等
        System.out.println("destroy method called...");

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }


    @Override
    public String getServletInfo() {
        return null;
    }


}
