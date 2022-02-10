<%--
  Created by IntelliJ IDEA.
  User: Think
  Date: 2022/2/10
  Time: 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    %>
</body>

</html>
