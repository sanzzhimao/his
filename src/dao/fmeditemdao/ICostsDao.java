package dao.fmeditemdao;

import vo.PatientInfo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author lym
 * @Description:收费的dao层
 * @Param
 * @return
**/
public interface ICostsDao {
    public void setCon(Connection con);
    List<PatientInfo> selectPatientInfoByCaseNumber(String caseNumber) throws SQLException;
}
