package day02;

import day02.bean.Product;
import day02.pool.C3p0Pool;
import day02.pool.DbcpPool;
import day02.pool.MyConnectionPool;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Example3 {

    public static void main(String[] args) {
        List<Product> productList = getProductList();

        System.out.println(productList);

        System.out.println("------------------------");

        System.out.println(deleteProductById(4L));

        System.out.println("------------------------");

        Product product = new Product();
        product.setPrice(new BigDecimal(288));
        product.setPname("鞋子");
        product.setCid(5L);
        System.out.println(addProduct(product));

        System.out.println("------------根据ID获取商品信息------------");

        System.out.println(getProductByPid(1L));
    }

    public static List<Product> getProductList(){
        List<Product> productList = new ArrayList<>();
        try {
            MyConnectionPool pool = new MyConnectionPool();
            //从池子中获取连接对象
            Connection conn = pool.getConnection();
            //给列起别名方式使用 as 关键词 - as也可以省略不写
            PreparedStatement pstmt = conn.prepareStatement("select p.pid , p.pname , p.price , p.cid ,p.create_time as createTime from product p");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                Product product = new Product();
                product.setPid(rs.getLong("pid"));
                product.setCid(rs.getLong("cid"));
                product.setPname(rs.getString("pname"));
                product.setPrice(rs.getBigDecimal("price"));
                product.setCreateTime(rs.getString("createTime"));
                productList.add(product);
            }

            //向池子中归还连接对象
            pool.releaseConnection(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    /**
     * 删除商品
     * @param pid
     */
    public static Integer deleteProductById(Long pid){
        Connection conn = C3p0Pool.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement("delete from product where pid = ?");
            pstmt.setLong(1 , pid);
            int rows = pstmt.executeUpdate();
            return rows;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static Integer addProduct(Product product){
        try {
            //now() : 获取当前系统时间的
            Connection conn = C3p0Pool.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("insert into product(pname , price , cid) values(? , ? , ? )");
            pstmt.setString(1 , product.getPname());
            pstmt.setBigDecimal(2 , product.getPrice());
            pstmt.setLong(3 , product.getCid());
            int rows = pstmt.executeUpdate();

            return rows;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static Product getProductByPid(Long pid){
        Connection conn = DbcpPool.getConnection();
        Product product = null;
        try {
            PreparedStatement pstmt = conn.prepareStatement("select p.pid , p.pname , p.price , p.cid " +
                    ",p.create_time as createTime from product p where pid = ?");

            pstmt.setLong(1 , pid);
            ResultSet rs = pstmt.executeQuery();

            if(rs.next()){
                product = new Product();
                product.setPid(rs.getLong("pid"));
                product.setPname(rs.getString("pname"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }
}
