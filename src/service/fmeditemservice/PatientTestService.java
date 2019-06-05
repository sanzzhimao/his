package service.fmeditemservice;

import dao.fmeditemdao.PatientTestDao;
import util.JdbcUtil;
import vo.CheckInfo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PatientTestService implements IPatientTestServcie {
    Connection con= JdbcUtil.getConnection();
    @Override
    public List<CheckInfo> findCheckInfoByName(String name) {
        PatientTestDao ptd=new PatientTestDao();
        ptd.setCon(con);
        List<CheckInfo> list = null;
        try {
            list = ptd.selectCheckInfoByName(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JdbcUtil.release(con,null,null);
        return list;
    }
}
