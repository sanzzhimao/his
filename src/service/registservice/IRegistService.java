package service.registservice;

import vo.Register;

import java.sql.SQLException;
import java.util.List;

public interface IRegistService {
    /**
     * @Author lym
     * @Description:页面加载的时候返回两个字符--发票号--病历号
     * @Param name
     * @return java.util.List<java.lang.String>
    **/
    List<String> MaxInvoceAndCaseNumber(String name) throws SQLException;
    /**
     * @Author lym
     * @Description:通过病历号查找以前的一些挂号信息
     * @Param [caseNumber]
     * @return vo.Register
    **/
    Register findRegisterByCaseNumber(String caseNumber) throws SQLException;

}
