package day02;

import day02.bean.Order;
import day02.pool.C3p0Pool;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class Example4 {

    public static void main(String[] args) {
        System.out.println(getOrderList());

        System.out.println("------------------");

        System.out.println("订单总数为：" + getTotalOrders());

        System.out.println("--------根据订单号取订单----------");

        System.out.println(getOrderByOno("8787843"));
    }

    public static List<Order> getOrderList(){

        try {
            //默认要给该对象设置数据源 - 让其关联某个数据库
            //数据库起名的时候，最好不要与mysql库中的默认表冲突
            QueryRunner qr = new QueryRunner(C3p0Pool.getDataSource());
            List<Order> orderList = qr.query("select o.oid , o.ono , o.create_time createTime" +
                    " , o.total_price as totalPrice from t_order o ", new BeanListHandler<>(Order.class));

            return orderList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.EMPTY_LIST;//空集合
    }

    public static Long getTotalOrders(){
        try {
            QueryRunner qr = new QueryRunner(C3p0Pool.getDataSource());
            //count : 函数 ，里面使用 * -- 推荐的 , oid 主键 ， 1 （用的时候 要保证列的值不能为空）
            Long count = (Long)qr.query("select count(*) from t_order", new ScalarHandler());
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0L;
    }

    /**
     * 根据订单号 去查询订单条目 （前提订单号是不重复的）
     * @param ono
     * @return
     */
    public static Order getOrderByOno(String ono){
        try {
            QueryRunner qr = new QueryRunner(C3p0Pool.getDataSource());
            Order order = qr.query("select o.oid , o.ono , o.create_time createTime" +
                    " , o.total_price as totalPrice from t_order o where o.ono = ? ", new BeanHandler<>(Order.class), ono);
            return order;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
