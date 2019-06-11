package dao.informationdao;

import vo.SettleCategory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author lym
 * @Description:结算类别接口，用来对用户的结算类型进行操作
**/
public interface ISettleCategoryDao {
    void setCon(Connection con) throws SQLException;
    void addSettleCategory(SettleCategory settleCategory) throws SQLException;
    void delSettleCategory(String settle) throws SQLException;
    void delSettleCategory(int id) throws SQLException;
    void changeSettleCategory(SettleCategory settleCategory) throws SQLException;
    List<SettleCategory> selectSettleCategory(String settle) throws SQLException;
    List<SettleCategory> selectSettleCategory() throws SQLException;

    void setCon(Connection con);
}
