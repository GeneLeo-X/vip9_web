package day02;

import day02.bean.Student;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Example1 {


    public static void main(String[] args) {
        Student stu = new Student();
        stu.setSno("2022008");
        stu.setSname("张三");
        stu.setAge(22);
        stu.setSid(6);
        System.out.println(updateStudent(stu));
    }


    public static Integer updateStudent(Student stu){
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = JdbcUtil.getConnection();
            stmt = conn.createStatement();
            //Statement 对象如果要进行变量使用的话，只能进行字符串拼接操作
            String sql = "update student set sno = '"+stu.getSno()+"' , sname = '"+stu.getSname()
                    +"' , age = "+stu.getAge()+" where sid = " + stu.getSid();
            int rows = stmt.executeUpdate(sql);
            return rows;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.releaseRes(conn , stmt , null);
        }
        return 0;
    }
}
