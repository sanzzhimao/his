package service.fmeditemservice;

import vo.Invoice;
import vo.PatientCosts;
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
        /**
         * @Author lym
         * @Description:通过病历号查询患者的一些信息
         * @Param [caseNumber]
         * @return java.util.List<vo.PatientInfo>
        **/
    List<PatientInfo> findPatientInfoByCaseNumber(String caseNumber);
    /**
     * @Author lym
     * @Description  开发票的同时，新增一个患者费用明细的一些信息
     * @Param [iv]
     * @return void
     **/
    void addIvoice(Invoice iv, PatientCosts pc) throws SQLException;
}
