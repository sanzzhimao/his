package service.registservice;

import vo.Invoice;
import vo.PatientCosts;
import vo.Register;

/**
 * @Author lym
 * @Description患者退号--
 * @Param
 * @return
**/
public interface IExistRegistService {
    /**
     * @Author lym
     * @Description通过病历号查询一个挂号信息
     * @Param [caseNumber]
     * @return vo.Register
    **/
 Register findRegister(String caseNumber);
 /**
  * @Author lym
  * @Description:病历号为caseNumber的患者退号
  * @Param [caseNumber]
  * @return boolean
 **/
 boolean existRegist(String caseNumber, Invoice iv, PatientCosts pc);

 }