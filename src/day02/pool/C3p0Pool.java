package day02.pool;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * C3p0数据库连接池 - 开源免费
 * 1、可以支持配置连接池容量、连接超时时间、支持多线程下连接（并发）
 * 2、不需要主动释放连接，自动归还连接。（自行回收）
 * 3、目前应用主流技术栈 ： Hibernate、Spring
 * 4、支持独有的配置文件自动识别读取 c3p0-config.xml
 *
 * c3p0-config.xml : 自动识别的位置
 *
 * 1、早期放于src根目录下即可
 * 2、新版本 webapp 可能有一个resource目录，c3p0-config.xml放于该处
 */
public class C3p0Pool {

    private static ComboPooledDataSource dataSource;

    /*private static String driverClass = "";
    private static String url = "";
    private static String username = "";
    private static String password = "";*/

    static {
        dataSource = new ComboPooledDataSource();
       /* ResourceBundle rb = ResourceBundle.getBundle("day02/db");
        driverClass = rb.getString("db.driverClass");
        url = rb.getString("db.url");
        username = rb.getString("db.username");
        password = rb.getString("db.password");

        try {
            dataSource.setJdbcUrl(url);
            dataSource.setPassword(password);
            dataSource.setUser(username);
            dataSource.setDriverClass(driverClass);
            dataSource.setMinPoolSize(5);
            dataSource.setInitialPoolSize(5);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }*/
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
