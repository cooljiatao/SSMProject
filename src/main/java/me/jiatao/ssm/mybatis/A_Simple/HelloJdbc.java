package me.jiatao.ssm.mybatis.A_Simple;

import java.sql.*;

public class HelloJdbc {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取连接
        String url = "jdbc:mysql://localhost:3306/mybatis";
        String userName = "root";
        String password = "jia";
        Connection conn = DriverManager.getConnection(url, userName, password);
        //3.获取Statement对象
        String sql = "select * from tb_user where id = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setLong(1, 1);
        //4.获取结果集
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString("name"));
            System.out.println(rs.getString("user_name"));
        }
        //5.释放资源
        rs.close();
        statement.close();
        conn.close();
    }
}
