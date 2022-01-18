package day01;

import java.sql.*;

public class Example1 {


    public static void main(String[] args) {
        testJdbc();
    }

    public static void testJdbc(){
        try {
            //1、加载驱动、注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2、使用DriverManager类获取数据库连接

            //serverTimezone=Asia/Shanghai : 数据库是 8+版本的时候 需要的属性。1949年的时候 ，5个时区 - Asia/Shanghai（UTC+8）、Asia/Harbin
            //UTC : 世界标准时间  东8区
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vip9?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai" , "root","root");
            //3、根据连接对象获取Statement - 可以直接sql语句的对象
            Statement stmt = conn.createStatement();
            //4、编写sql语句的
            String sql = "select sid , sno  , sname,age from student";
            //5、执行sql语句,获取结果集对象
            ResultSet rs = stmt.executeQuery(sql);
            //数据库列的索引 从1开始
            while (rs.next()){
                System.out.println(rs.getInt(1)
                        + " " + rs.getString("sno")
                        + " " + rs.getString("sname")
                        + " " + rs.getInt("age"));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
