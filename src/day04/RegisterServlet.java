package day04;

import day02.pool.C3p0Pool;
import day04.bean.User;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Map;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、处理前端发过来请求数据的中文乱码问题
        req.setCharacterEncoding("utf-8");

        /*String username = req.getParameter("username");
        System.out.println("username = " + username);*/

        Map<String, String[]> parameterMap = req.getParameterMap();

        User user = new User();
        try {
            //将前端传递过来的表单数组，自动映射到JavaBean对象里
            BeanUtils.populate(user , parameterMap);
            //数据库中若某列是存放多个值的话，   （xxx , xxx）以逗号分隔的
            String[] hobbies = parameterMap.get("hobby");
            String hobby = Arrays.toString(hobbies);
            hobby = hobby.substring(1 , hobby.length() - 1);
            //自动映射之后，不满足的属性设定，可以单独再次处理
            user.setHobby(hobby);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        Integer rows = register(user);

        if(rows > 0){//注册成功
            System.out.println("注册成功，跳转登录~~");
            resp.sendRedirect(req.getContextPath() + "/login.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req , resp);
    }

    /**
     * 注册方法
     * @param user
     * @return
     */
    public Integer register(User user){

        try {
            QueryRunner qr = new QueryRunner(C3p0Pool.getDataSource());
            int rows = qr.update("insert into user values(null , ? , ? ,? ,? ,? ,?)"
                    , user.getName() , user.getUsername() , user.getPassword() , user.getSex() , user.getPhone() , user.getHobby());
            return rows;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
