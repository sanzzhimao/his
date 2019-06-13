package dao.registdao;

import java.sql.Connection;
import java.sql.SQLException;

public interface IExistRegistDao {
    void setCon(Connection con) ;
    /**
     * @Author lym
     * @Description：退号修改visitState为4（已作废）
     * @Param [caseNumber]
     * @return void
     **/
    void changeByCaseNumber(String caseNumber) throws SQLException;
    void changeByCaseNumber(int id) throws SQLException;

}
