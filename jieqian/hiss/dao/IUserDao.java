package com.neusoft.his.dao;

import com.neusoft.his.vo.ConstantItem;
import com.neusoft.his.vo.Department;
import com.neusoft.his.vo.RegistLevel;
import com.neusoft.his.vo.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDao {
    //通过username或者realname查找用户
    User findUserByName(String usern, String realn)throws SQLException;
    //从科室表中读取所有有效科室
    List<Department> getAllValideDepartment()throws SQLException;
    //从常数表读取有效医生职称
    List<ConstantItem> getAllValideDoctorTitle()throws SQLException;
    //从挂号表级别表中读取所有有效挂号级别
    List<RegistLevel> getAllValideLevel()throws SQLException;
    //新增用户名
    void addNewUser(String usern,String pass,String realn,int usert,int dectitleid,char issche,int deptid,int regisLeid,int delmark)throws SQLException;
    //根据id读取用户名
    User getUserById(int id)throws SQLException;
    //修改指定用户的信息
    void updateUserByName(String usern,String pass,String realn,int usert,int dectitleid,char issche,int deptid,int regisLeid,int delmark)throws SQLException;
    //删除用户
    void deleteUserByID(int id)throws SQLException;
}
