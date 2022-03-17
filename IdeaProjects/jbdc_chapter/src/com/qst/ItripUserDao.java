package com.qst;

import java.sql.*;

public class ItripUserDao {
    public static void main(String[] args) {
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;
        try {
            //1.通过反射加载com.mysql.cj.jdbc.Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取connection连接
            String url="jdbc:mysql://localhost:3306/ym";
            connection= DriverManager.getConnection(url,"root","root");
            //3.创建statement对象
            statement=connection.createStatement();
            //4.查询
            String sql="select * from employee";
            resultSet =statement.executeQuery(sql);
            //5.遍历结果集
            while (resultSet.next()){
                int empno=resultSet.getInt("empno");
                System.out.println("======"+empno);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}
