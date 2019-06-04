package dao;

import vo.Register;

import java.sql.SQLException;

/**
 * @Author lym
 * @Description：收费的dao
 *
**/
public interface IRegisteredfeeDao {
    /**
     * @Author lym
     * @Description：通过病历号查询患者的挂号记录
     * @Param [caseNumber]
     * @return vo.Register
    **/
    Register reRegisterByCaseNumber(String caseNumber) throws SQLException;
}
