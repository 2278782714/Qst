package com.qst;

import java.sql.*;

public class GetEmpList {
    public void getEmp(int empno){
        Connection conn=null;
        PreparedStatement preparedStatement=null;
        ResultSet res=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/ym";
            conn= DriverManager.getConnection(url,"root","root");
            String sql="select * from employee where empno=?";
            preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setInt(1,empno);
            res=preparedStatement.executeQuery();
            while(res.next()){
                String ename=res.getString("ename");
                System.out.println("====="+ename);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                res.close();
                preparedStatement.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        GetEmpList getEmpList=new GetEmpList();
        getEmpList.getEmp(7369);
    }
}
