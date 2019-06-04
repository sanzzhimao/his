package dao.regist;

import vo.RegistLevel;
import vo.SettleCategory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author lym
 * @Description:挂号接口
 * @Param
 * @return
**/
public interface IRegistDao {
    /**
     * @Author lym
     * @Description:设置con
     * @Param [con]
     * @return void
    **/
    void setConnection(Connection con);
    /**
     * @Author lym
     * @Description：读取最大发票号
     * @Param [id]
     * @return java.lang.String
    **/
    String selectMaxInvoiceNum(int id) throws SQLException;
    /**
     * @Author lym
     * @Description:读取当前的最大病历号
     * @Param []
     * @return java.lang.String
    **/
    String selectCaseNumber()throws SQLException;
    /**
     * @Author lym
     * @Description:查询有效的结算类别
     * @Param []
     * @return vo.SettleCategory
    **/
    List<SettleCategory> selectSettleCategory() throws SQLException;
    /**
     * @Author lym
     * @Description：查询有效的挂号级别
     * @Param []
     * @return vo.RegistLevel
    **/
    List<RegistLevel> selectRegistLevel() throws SQLException;
    /**
     * @Author lym
     * @Description:通过id去查询挂号费和初始号额度
     * @Param [id]
     * @return vo.RegistLevel
    **/
    RegistLevel selectRegistLevelById(int id) throws SQLException;
}
