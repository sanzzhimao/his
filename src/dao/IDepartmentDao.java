package dao;

import vo.Department;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDepartmentDao {
    public void setConnection(Connection con);
    //新增科室
    void addnewDepartment(Department department) throws SQLException;
    //读取当前有效费用科目
    Department selectDepartment(String deptCode,String deptName) throws SQLException;
    //更新科室信息
    void updateDepartment( String deptCode,String deptName,String deptCategoryID,int deptType,int delMark);
    //删除科室
    void deleteDepartment(int id);
}
