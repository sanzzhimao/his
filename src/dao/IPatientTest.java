package dao;

import vo.CheckInfo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author lym
 * @Description:患者检验接口-----
**/
public interface IPatientTest {
    public void setCon(Connection con);
    /**
     * @Author lym
     * @Description:通过名字查询患者的信息（病历号，名字，挂号id，发票号）
     * @Param [name]
     * @return java.util.List<vo.CheckInfo>
    **/
    CheckInfo selectCheckInfoByName(String name) throws SQLException;
}
