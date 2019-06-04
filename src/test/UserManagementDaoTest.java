package test;
/**
 * UserManagementDaoTest
 * 用户管理测试
 * */
import dao.UserManagementDao;
import org.junit.Test;
import util.JdbcUtil;
import vo.User;

import java.sql.SQLException;
import java.util.List;

public class UserManagementDaoTest {


    @Test
    public void addUSer() throws SQLException {
        User user=new User();
        user.setUserName("lym");
        user.setRealName("lym");
        user.setPassword("123456");
        user.setDocTileID(1);
        UserManagementDao um =new UserManagementDao();
        um.setCon(JdbcUtil.getConnection());
        um.addUSer(user);
    }

    @Test
    public void delUser() throws SQLException {
        String name="lym";
        UserManagementDao um =new UserManagementDao();
        um.setCon(JdbcUtil.getConnection());
        um.delUser(name);
    }

    @Test
    public void changeUser() throws SQLException {
        User user=new User();
        user.setUserName("lym");
        user.setRealName("lym");
        user.setPassword("123456");
        user.setDocTileID(1);
        UserManagementDao um =new UserManagementDao();
        um.setCon(JdbcUtil.getConnection());
        um.changeUser(user);
    }

    @Test
    public void selectUser() throws SQLException {
        UserManagementDao um =new UserManagementDao();
        um.setCon(JdbcUtil.getConnection());
        List<User> users=um.selectUser("r");
        System.out.println(users);
    }

    @Test
    public void addUSer1() {
    }

    @Test
    public void delUser1() {
    }

    @Test
    public void delUser2() {
    }

    @Test
    public void changeUser1() {
    }

    @Test
    public void selectUser1() {
    }

    @Test
    public void reName() throws SQLException {
        UserManagementDao um =new UserManagementDao();
        um.setCon(JdbcUtil.getConnection());
        System.out.println(um.reName("c"));

    }

    @Test
    public void selectUser2() {
    }

    @Test
    public void selectDetpID() {
    }

    @Test
    public void selectUser3() {
    }
}