package day02;

import java.sql.*;
import java.util.ResourceBundle;

public class JdbcUtil {
    private static String driverClass = "";
    private static String url = "";
    private static String username = "";
    private static String password = "";

    static {
        ResourceBundle rb = ResourceBundle.getBundle("day02/db");
        driverClass = rb.getString("db.driverClass");
        url = rb.getString("db.url");
        username = rb.getString("db.username");
        password = rb.getString("db.password");
    }

    /**
     * 获取数据库连接
     * @return
     */
    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName(driverClass);
            conn = DriverManager.getConnection(url , username , password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 释放资源
     */
    public static void releaseRes(Connection conn , Statement stmt , ResultSet rs){
        if(null != rs){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(null != stmt){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
