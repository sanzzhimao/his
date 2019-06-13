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
    /**
     * @Author lym
     * @Description：通过患者的病历号找到患者的
     * @Param [caseNumber]
     * @return java.util.List<vo.PatientInfo>
    **/
    List<PatientInfo> selectPatientInfoByCaseNumber(String caseNumber) throws SQLException;
}
