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
<script src="../js/jquery-1.11.3.min.js"></script>
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


    function testJQAjaxGet(){
        $.get("${pageContext.request.contextPath}/ajax", { "name": "John", "time": "2pm" },
            function(data){//回调监听 - 只有成功才会监听到
                alert("Data Loaded: " + data);
            } , "text");//"text" : 响应回的数据格式
    }
    
    function testJQAjaxFn() {
        $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/ajax",
            data: "name=tom&location=Boston",
            success: function(msg){
                //alert(msg)
                alert( "Data Saved: " + msg.pname);
            },
            dataType:"json" ,
            error: function (data) {
                alert("服务端响应出问题的时候弹出")
            }

        });
    }
</script>

<body>

<input value="JS使用Ajax异步" type="button" onclick="testJSAjax()"/><br/>
<input value="JS使用Ajax同步" type="button" onclick="testJSAjaxPOST()"/><br/>

<input value="test测试" type="button" onclick="alert('test点击')"/><br/>

<input value="JQ使用Ajax异步GET" type="button" onclick="testJQAjaxGet()"/><br/>

<input value="JQ使用Ajax异步ajax方法" type="button" onclick="testJQAjaxFn()"/><br/>
</body>
</html>
