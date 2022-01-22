package day04;

import day02.pool.C3p0Pool;
import day04.bean.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = login(username , password);
        if(user != null){
            HttpSession session = req.getSession();
            session.setAttribute("user",user);
            resp.sendRedirect(req.getContextPath() + "/index.html");
        }else{
            req.setAttribute("msg" , "用户名或密码错误！");
            req.getRequestDispatcher("/login.html").forward(req , resp);
        }

    }

    private User login(String username, String password) {

        QueryRunner qr = new QueryRunner(C3p0Pool.getDataSource());

        try {
            User user = qr.query("select u.name , u.uid  from user u where username = ? " +
                    "and password = ?" ,new BeanHandler<>(User.class), username , password);
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req , resp);
    }
}
