package dao.informationdao;

import vo.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface IUserManagementDao {
    void setConnection(Connection con) throws SQLException;
    void addUSer(User user) throws SQLException;
    void delUser(String userName) throws SQLException;
    void delUser(int id) throws SQLException;
    void changeUser(User user) throws SQLException;
    List<User> selectUser(String name) throws SQLException;
    int reName(String name) throws SQLException;
    List<User> selectUser(int id) throws SQLException;
    List<Department> selectDetpID() throws SQLException;
    List<User> selectUser() throws SQLException;
    List<ConstantItem>selectDoc() throws SQLException;
    List<RegistLevel> selectRegistLevel() throws SQLException;
}
