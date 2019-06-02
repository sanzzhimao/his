package com.neusoft.his.dao;

import com.neusoft.his.vo.ConstantItem;
import com.neusoft.his.vo.Department;

import java.sql.SQLException;

public interface IDepartmentDao {
    //读取当前有效费用科目
    Department findInfByCodeorName(String deptc, String deptn)throws SQLException;
   //从常熟表中读取所有科室分类
    ConstantItem getConstantItem()throws SQLException;
    //新增科室
    void addNewDepartment(String deptc,String deptn,int deptcat,int deptt,int delmark)throws SQLException;
    //根据ID读取科室信息
    Department getInfByID(int id)throws SQLException;
    //更新科室信息
    void updateDepartment(String deptc,String deptn,int deptcat,int deptt,int delmark)throws SQLException;
    //删除科室
    void invalideDepartment(int id)throws SQLException;
}
