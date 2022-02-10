<%--
  Created by IntelliJ IDEA.
  User: Think
  Date: 2022/2/10
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>include4</title>
</head>
<body>
    This is include4 page

    <!--动态包含 -- 推荐使用的-->
    <jsp:include page="include3.jsp"/>

    <!--内部转发的方式-->
    <jsp:forward page="include2.jsp"/>
</body>
</html>
