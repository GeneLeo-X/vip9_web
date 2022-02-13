<%--
  Created by IntelliJ IDEA.
  User: Think
  Date: 2022/2/13
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>异步的学习与掌握</title>
</head>
<script type="text/javascript">
    function testJSAjax() {
        var xmlhttp;//创建Ajax引擎对象
        if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp=new XMLHttpRequest();
        } else {// code for IE6, IE5
            xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
        }
        //使用引擎对象绑定服务监听事件
        xmlhttp.onreadystatechange=function() {
            //4: 请求已完成，且响应已就绪  200: "OK"
            if (xmlhttp.readyState==4 && xmlhttp.status==200) {
                alert(xmlhttp.responseText);
            }
        }
        //绑定服务
        xmlhttp.open("GET","${pageContext.request.contextPath}/ajax?name=张三&age=23",true);//true : 代表异步
        //发送请求
        xmlhttp.send();
    }

    function testJSAjaxPOST() {
        var xmlhttp;//创建Ajax引擎对象
        if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp=new XMLHttpRequest();
        } else {// code for IE6, IE5
            xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
        }
        //使用引擎对象绑定服务监听事件
        xmlhttp.onreadystatechange=function() {
            //4: 请求已完成，且响应已就绪  200: "OK"
            if (xmlhttp.readyState==4 && xmlhttp.status==200) {
                alert(xmlhttp.responseText);
            }
        }
        //绑定服务
        xmlhttp.open("POST","${pageContext.request.contextPath}/ajax",false);//false : 代表同步
        //设置请求头
        xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        //发送请求
        xmlhttp.send("name=李四&age=33");
    }
</script>

<body>

<input value="JS使用Ajax异步" type="button" onclick="testJSAjax()"/><br/>
<input value="JS使用Ajax同步" type="button" onclick="testJSAjaxPOST()"/><br/>

<input value="test测试" type="button" onclick="alert('test点击')"/><br/>
</body>
</html>
