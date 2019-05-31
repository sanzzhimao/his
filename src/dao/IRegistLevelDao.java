package dao;

import vo.RegistLevel;

import java.sql.SQLException;
import java.util.List;

public interface IRegistLevelDao {
    void addRegistLevel(RegistLevel registLevel);
    void delRegistLevel(int sequenceNo);
    void changeRegistLevel(RegistLevel registLevel);
    List<RegistLevel> select(String strName) throws SQLException;
}
