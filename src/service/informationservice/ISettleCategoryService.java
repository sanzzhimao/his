package service.informationservice;

import vo.SettleCategory;

import java.sql.SQLException;
import java.util.List;

public interface ISettleCategoryService {
    void addSettleCategory(SettleCategory settleCategory) throws SQLException;
    void delSettleCategory(String settle) throws SQLException;
    void delSettleCategory(int id) throws SQLException;
    void changeSettleCategory(SettleCategory settleCategory) throws SQLException;
    List<SettleCategory> selectSettleCategory(String settle) throws SQLException;
    List<SettleCategory> selectSettleCategory() throws SQLException;
}
