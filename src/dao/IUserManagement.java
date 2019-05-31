package dao;

import vo.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserManagement {
    void addUSer(User user) throws SQLException;
    void delUser(String userName) throws SQLException;
    void changeUser(User user) throws SQLException;
    List<User> selectUser(String name) throws SQLException;

}
