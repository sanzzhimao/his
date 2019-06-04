package dao.information;

import vo.*;

import java.sql.Connection;
import java.sql.SQLException;

import java.util.Date;
import java.util.List;

/**
 * 医生排班管理Dao层接口
 */
public interface IDoctorCrewDao {
    void setConnection(Connection con);
    //通过开始时间和结束时间查询医生排班
    List<DoctorCrew> selectDoctorCrew(Date starttime, Date endtime) throws SQLException;

    //获取有效科室
    List<Department> selectDepartment() throws SQLException;

    //获取有效挂号级别
    List<RegistLevel> selectRegistLevel() throws SQLException;

    //按条件查询参与排班的医生
    List<User> selectUser(int deptID,int registLeID) throws SQLException;

    //按条件查询排班规则
    List<Rule> selectRule(int id) throws SQLException;

    //新增排班规则
    void addRule(Rule rule) throws SQLException;

    //新增排班计划


    //批量删除排班计划
    void deleteRule() throws SQLException;
}
