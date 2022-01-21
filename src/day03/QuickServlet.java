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
 */
public class QuickServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init method called...");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service method called...");
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
