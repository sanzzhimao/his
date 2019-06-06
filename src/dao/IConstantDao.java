package dao;

import vo.ConstantType;

import java.sql.Connection;
import java.sql.SQLException;

public interface IConstantDao {
    public void setConnection(Connection con);
    void addConstantType(ConstantType constatnt) throws SQLException;
    ConstantType selcetConstantType(String ConstantTypeCode,String ConstantTypeName) throws SQLException;
}
