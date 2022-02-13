<%--
  Created by IntelliJ IDEA.
  User: Think
  Date: 2022/2/13
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSON学习与掌握</title>

    <script type="text/javascript">
        //key ： 一定是字符串  值 ：是Obj类型  JS中默认支持JSON格式的
        var user = {"name":"张三" , "age":22,"sex":"男"};//对象类型
        alert(user.name);
        alert(user.sex);

        var productList = [{"pid":1 , "pname":"华为手机","price":3999.6} , {"pid":2 , "pname":"牙刷","price":19.9}];//集合元素
        for(var i = 0 ; i < productList.length ; i++){
            alert("商品名称: " + productList[i].pname + ",商品价格: " + productList[i].price)
        }

        //{key1:val1 , key2:[] , key3:val3}
        var dataStr = {"code":200 , "data":[{"oid":1 , "ono":"qwe21376376328732"},{"oid":2 , "ono":"qwe382783676743"}] , "message":"查询订单列表成功!"};

        if(dataStr.code == 200){
            alert(dataStr.data[0].ono)
        }else{
            alert("服务器错误！")
        }

        var orderList = {"code":200 , "data":[{"oid":1 , "ono":"qwe21376376328732" , "items":[{"pid":1 , "pname":"华为手机","price":3999.6} , {"pid":2 , "pname":"牙刷","price":19.9}]}
        ,{"oid":2 , "ono":"qwe382783676743","items":[{"pid":3 , "pname":"电脑","price":4999.6}]}] , "message":"查询订单列表成功!"};
        alert("")
        alert("第二个订单的商品价格为：" + orderList.data[1].items[0].price)
    </script>
</head>
<body>

</body>
</html>
