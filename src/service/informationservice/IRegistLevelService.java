package service.informationservice;

import vo.RegistLevel;

import java.sql.SQLException;
import java.util.List;

public interface IRegistLevelService {
    void addRegistLevel(RegistLevel registLevel) throws SQLException;
    void delRegistLevel(int sequenceNo) throws SQLException;
    void changeRegistLevel(RegistLevel registLevel) throws SQLException;
    List<RegistLevel> selectRegistLevel(String strName) throws SQLException;
    List<RegistLevel> selectRegistLevel() throws SQLException;
    List<RegistLevel> selectRegistLevel(int id) throws SQLException;
    int reRegistLevelID(String registCode) throws SQLException;
}
