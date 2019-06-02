package service;

import dao.DoctorCrewDao;
import dao.IDoctorCrewDao;
import util.JdbcUtil;
import vo.DoctorCrew;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import java.util.List;

/**
 * 医生排班管理业务类
 */
public class DoctorCrewService implements IDoctorCrewService {
    //通过日期查询医生排班
    @Override
    public List<DoctorCrew> selectDoctor(Date starttime, Date endtime) throws SQLException {
        List<DoctorCrew> doc=null;
        Connection con=null;
        try {
            con=JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IDoctorCrewDao idcd=new DoctorCrewDao();
            idcd.setConnection(con);
            doc=idcd.selectDoctorCrew(starttime,endtime);
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
        return doc;
    }
}
