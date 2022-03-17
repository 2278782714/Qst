package com.qst.test;

import com.qst.Dao.DepartmentDao;
import com.qst.Dao.DepartmentDaoImpl;

/**
 * @Author Qin Zhenli
 * @Date 2022/3/15 22:44
 */
public class TestMain {
    public static void main(String[] args) {
        DepartmentDao departmentDao=new DepartmentDaoImpl();
        departmentDao.getdeptList();
        departmentDao.add(1200,"dddd","sdfsd");
        departmentDao.update(1200,"abcd");
        departmentDao.delete(1200);
        departmentDao.getDeptByDname("OPERATIONS");
    }
}
