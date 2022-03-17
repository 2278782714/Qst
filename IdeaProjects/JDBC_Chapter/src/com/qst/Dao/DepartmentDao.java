package com.qst.Dao;

/**
 * @Author Qin Zhenli
 * @Date 2022/3/15 20:52
 */
public interface DepartmentDao {
    //查询所有数据
    public void getdeptList();
    //添加
    public void add(int deptno,String dname,String loc);
    //修改
    public void update(int deptno,String dname);
    //删除
    public void delete(int deptno);
    //根据条件查询数据
    public void getDeptByDname(String dname);

}
