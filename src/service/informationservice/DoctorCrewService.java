package service.informationservice;

import dao.informationdao.DoctorCrewDao;
import dao.informationdao.IDoctorCrewDao;
import util.JdbcUtil;
import vo.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import java.util.List;

/**
 * 医生排班管理业务类
 */
public class DoctorCrewService implements IDoctorCrewService {
    /**
     * 通过日期查询医生排班（已测试）
     */
    @Override
    public List<DoctorCrew> selectDoctor(Date starttime, Date endtime) throws SQLException {
        List<DoctorCrew> list=null;
        Connection con=null;
        try {
            con=JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IDoctorCrewDao idcd=new DoctorCrewDao();
            idcd.setConnection(con);
            list=idcd.selectDoctorCrew(starttime,endtime);
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
        return list;
    }

    /**
     * 获取有效科室(已测试)
     */
    @Override
    public List<Department> selectDepartment() throws SQLException {
        List<Department> list=null;
        Connection con=null;
        try {
            con=JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IDoctorCrewDao idcd=new DoctorCrewDao();
            idcd.setConnection(con);
            list=idcd.selectDepartment();
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
        return list;
    }

    /**
     *获取有效挂号级别(已测试)
     */
    @Override
    public List<RegistLevel> selectRegistLevel() throws SQLException {
        List<RegistLevel> list=null;
        Connection con=null;
        try {
            con=JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IDoctorCrewDao idcd=new DoctorCrewDao();
            idcd.setConnection(con);
            list=idcd.selectRegistLevel();
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
        return list;
    }

    /**
     *按条件查询参与排班的医生(已测试)
     */
    @Override
    public List<User> selectUser(int deptID, int registLeID) throws SQLException {
        List<User> list=null;
        Connection con=null;
        try {
            con=JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IDoctorCrewDao idcd=new DoctorCrewDao();
            idcd.setConnection(con);
            list=idcd.selectUser(deptID,registLeID);
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
        return list;
    }

    /**
     *按条件查询排班规则(已测试)
     */
    @Override
    public List<Rule> selectRule(int id) throws SQLException {
        List<Rule> list=null;
        Connection con=null;
        try {
            con=JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IDoctorCrewDao idcd=new DoctorCrewDao();
            idcd.setConnection(con);
            list=idcd.selectRule(id);
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
        return list;
    }

    @Override
    public void addRule(Rule rule) throws SQLException {

    }

    @Override
    public void deleteRule() throws SQLException {

    }
}
