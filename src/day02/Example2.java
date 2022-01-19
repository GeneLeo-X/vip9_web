package day02;

import day02.bean.User;

import java.sql.*;

public class Example2 {

    public static void main(String[] args) {
        //SQL片段的方式进行SQL攻击的
        User user = loginForPreparedStmt("tom123", "123456");

        if(null != user) System.out.println("欢迎," + user.getName());
        else System.out.println("用户名或密码错误!");
    }

    /**
     * PreparedStatement 应用
     * 1、防止sql攻击
     * 2、预编译SQL语句
     * @param username
     * @param password
     * @return
     */
    public static User loginForPreparedStmt(String username , String password){
        Connection conn = null;

        PreparedStatement pstmt = null;

        ResultSet rs = null;

        User user = null;
        try {
            conn = JdbcUtil.getConnection();
            //使用？去占位
            String sql = "select u.uid , u.name from user u where u.username = ? and u.password = ?";
            //sql预加载 ，访问数据库执行sql语句的时候更高效
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1 , username);
            pstmt.setString(2 , password);

            rs = pstmt.executeQuery();

            if(rs.next()){
                user = new User();
                user.setName(rs.getString("name"));
                user.setUid(rs.getInt("uid"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.releaseRes(conn , pstmt , rs);
        }
        return user;
    }

    public static User login(String username , String password){
        Connection conn = null;

        Statement stmt = null;

        ResultSet rs = null;

        User user = null;
        try {
            conn = JdbcUtil.getConnection();
            stmt = conn.createStatement();
            //给表起别名  表名 别名
            String sql = "select u.uid , u.name from user u where u.username = '"+username
                    +"' and password = '"+password+"'";
            rs = stmt.executeQuery(sql);

            System.out.println(sql);
            if(rs.next()){
                user = new User();
                user.setName(rs.getString("name"));
                user.setUid(rs.getInt("uid"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.releaseRes(conn , stmt , rs);
        }

        return user;
    }
}
