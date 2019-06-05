package service.informationservice;

import vo.ConstantItem;
import vo.Department;

import java.sql.SQLException;
import java.util.List;

public interface IDepartmentService {
    //依据科室编号或名称查询
    List<Department> selectDepartment(String sting) throws SQLException;
    //查询科室分类
    List<ConstantItem>selectConstantItem() throws SQLException;
    //新增科室
    void addnewDepartment(Department department) throws SQLException;
    //编辑科室信息
    void updateDepartment(Department department) throws SQLException;
    //删除科室信息
    void deleteDepartment(int id) throws SQLException;
}
