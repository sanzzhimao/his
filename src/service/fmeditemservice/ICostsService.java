package service.fmeditemservice;

import vo.Invoice;
import vo.PatientInfo;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author lym
 * @Description:收费的service层
 * @Param
 * @return
**/
    public interface ICostsService {
    List<PatientInfo> findPatientInfoByCaseNumber(String caseNumber);
    void addIvoice(Invoice iv) throws SQLException;
}
