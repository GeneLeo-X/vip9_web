<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: Think
  Date: 2022/2/10
  Time: 9:16
  To change this template use File | Settings | File Templates.
--%>
<%--
    三大指令 - 所有的指令都是 <%@ 指令名称 %>
        1) page - 属性最多的，默认的指令
           contentType - 指定整个问题的字符集 ，进行编码。
           language - 支持的服务端语言 java （只能写java）
           errorPage ：跳转一个错误引导页面 (内部转发)
           isErrorPage : 指定那个页面是错误接收处理页面(标记属性)
           session : 默认是true，jsp页面是支持session会话的。false不支持 - session会话中存储的值不能访问了。
           buffer : 控制缓冲区内容空间大小的。默认8kb - out缓冲区  .若大小写为0kb - 相当于关闭了out缓冲区
           import ： 导入java类的路径的,为了代码的工整性通常放于最上面
        2)include指令 - 包含（静态包含）,jsp的任意位置包含任意jsp页面N次
          file ： 引入的文件目录
        3)taglib指令 - 可以引入标签库 jstl、structs2
            uri : 标签库位置 ，网络，本地
            prefix : 前缀 ， 别名
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="error.jsp" buffer="0kb"  session="true" %>
<html>
<head>
    <title>学习JSP</title>
</head>
<body>

    <%
        //num = 30; 方法执行是有顺序的，定义在调用语句下面的变量是无法访问的
    %>
    <!--JSP代码比较任意，存放位置可以是文件的任何位置-->
    <%
        //会被翻译到service方法的内部
        int num = 10;
        System.out.println("num = " + num);//打印到控制台
    %>

    <%
        num = 20;
        //int i = 10 / 0;
        System.out.println(num);
    %>
    <!--写于浏览器中-->
    <%= 1+1%>

    <%=num%>
    <%="这是写在浏览器的页面中的内容.."%>

    <%!
        //被翻译成成员变量的。属于类的，类中可以直接编写功能性语句吗？不能
        int count = 50;
        String str = "aaa";

        public void method(){
            System.out.println(str);
        }
    %>

    <%--模拟html注释：可见范围只能在jsp源码中看到--%>
    <%
        method();
    %>

    <%
        //方法中只可以存放功能性语句的。方法中可以定义方法吗？-- 不能

        //测试引入Java jar包中的类
        List<String> list = new ArrayList<>();
    %>

    <hr>
    <%
        //9大隐式对象应用
        out.print("aaaaaaaaaaaaaaaaaaaaaa");
        out.write("bbbbbbbbbbbbbbbbbbbbbb");
    %>
    ccccccccccccccccccccccccccccc
    <%="ddddddddddddddddddddddddd"%>
    <%
        response.getWriter().write("fffffffffffffffffffffffffff");
    %>

    <%=request.getContextPath()%>

    <%
        //request.getAttribute("name");
        //HttpSession s1 = request.getSession();
        //session.getAttribute("");

        //页面域 - 只适用当前页面
        // 应用上下文域    >  会话域  > 请求域   > 页面域
        //pageContext.setAttribute("name" , "lily");
        //request.setAttribute("name","tom");
        //session.setAttribute("name","lucy");
        application.setAttribute("name" , "jack");

        System.out.println("----------------从域中取值----------------");
        //从域中取值，就近原则
        System.out.println(pageContext.findAttribute("name"));

        //page : 翻译后的servlet实例 -- 通常不常用

        //pageContext : 获取到其它8大隐式对象

    %>
</body>

</html>
