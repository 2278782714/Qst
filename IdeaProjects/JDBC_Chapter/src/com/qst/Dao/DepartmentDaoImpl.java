package com.qst.Dao;

import java.sql.SQLException;

/**
 * @Author Qin Zhenli
 * @Date 2022/3/15 20:56
 */
public class DepartmentDaoImpl extends BaseDao implements DepartmentDao {

    @Override
    public void getdeptList() {
        String sql="select * from department;";
        Object[] params=null;
        rs=this.executeSQl(sql,params);
        try {
            while (rs.next()) {
                int deptno=rs.getInt("deptno");
                String dname=rs.getString("dname");
                String loc=rs.getString("loc");
                System.out.println("deptno: "+deptno+"======"+"dname: "+dname+"========"+"loc: "+loc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.closeResources();
        }

    }

    @Override
    public void add(int deptno, String dname, String loc) {
        String sql = "insert into department values(?,?,?);";
        Object[] params = {deptno, dname, loc};
        int i = this.executeUpdate(sql, params);
        try {
            if (i > 0) {
                System.out.println("插入数据成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeResources();
        }
    }

    @Override
    public void update(int deptno, String dname) {
        String sql="update department set dname=? where deptno=?;";
        Object[] params={dname,deptno};
        int i=this.executeUpdate(sql,params);
        try {
            if (i>0){
                System.out.println("数据修改成功");
            }
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeResources();
        }
    }

    @Override
    public void delete(int deptno) {
        String sql="delete from department where deptno=?;";
        Object[] params={deptno};
        int i=this.executeUpdate(sql,params);
        try {
            if(i>0){
                System.out.println("删除数据成功");
            }
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeResources();
        }
    }


    @Override
    public void getDeptByDname(String dname) {
        String sql="select * from department where dname=?;";
        Object[] params = {dname};
        rs=this.executeSQl(sql,params);

        try {
            if (rs.next()) {
                int deptno=rs.getInt("deptno");
                String loc=rs.getString("loc");
                System.out.println("deptno: "+deptno+"========"+"loc: "+loc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this .closeResources();
        }
    }
}
