package com.qst.Dao;

import java.sql.*;

/**
 * @Author Qin Zhenli
 * @Date 2022/3/15 20:02
 */
public class BaseDao {
    public Connection conn;
    public PreparedStatement ps;
    public Statement stmt;
    public ResultSet rs;

    //获取数据库连接
    public boolean getConnection() {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/ym";
        String username = "root";
        String password = "root";
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    //数据的增加 删除 修改
    public int executeUpdate(String sql,Object [] params){
        int updateRows=0;
        if (getConnection()) {
            try {
                ps = conn.prepareStatement(sql);
                for (int i = 0; i < params.length;i++) {
                    ps.setObject(i+1,params[i]);
                }
                updateRows=ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return updateRows;
    }

    //查询
    public ResultSet executeSQl(String sql,Object [] params){
        if (getConnection()) {
            try {
                ps= conn.prepareStatement(sql);
                if (params!=null){
                    for (int i = 0; i < params.length; i++) {
                        ps.setObject(i+1,params[i]);
                    }
                }
                rs=ps.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rs;
    }

    //关闭连接
    public boolean closeResources(){
        if (rs!=null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }

        if (ps!=null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }

        if (stmt!=null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }

        if (conn!=null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }

        return true;
    }
}
    
    

