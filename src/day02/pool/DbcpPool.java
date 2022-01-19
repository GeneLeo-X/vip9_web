package day02.pool;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * 1、可以支持配置连接池容量、连接超时时间、支持多线程下连接（并发）
 * 2、没有独立的配置文件需要使用属性文件读取相关信息
 */
public class DbcpPool {

    private static BasicDataSource dataSource;

    static {
        dataSource = new BasicDataSource();
        ResourceBundle rb = ResourceBundle.getBundle("day02/db");
        dataSource.setDriverClassName(rb.getString("db.driverClass"));
        dataSource.setUrl(rb.getString("db.url"));
        dataSource.setUsername(rb.getString("db.username"));
        dataSource.setPassword(rb.getString("db.password"));
    }

    public static Connection getConnection(){

        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
