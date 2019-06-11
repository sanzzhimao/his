package dao;

import vo.ConstantItem;
import vo.Department;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface IDepartmentDao {
    public void setConnection(Connection con);
    //依据科室编号查询科室
    List<Department> selectDepartment(String deptCode, String deptName) throws SQLException;
    //根据id查询科室
    Department selectDepartmentByID(int id) throws SQLException;
    //查询科室分类
    List<ConstantItem> selectConstantItem()throws SQLException;
    //新增科室
    void addnewDepartment(Department department) throws SQLException;
    //编辑科室信息
    void updateDepartment(Department department) throws SQLException;
    //删除科室
    void deleteDepartment(int id) throws SQLException;
}
