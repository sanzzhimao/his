package test;

import dao.IUserManagementDao;
import dao.regist.RegistDao;
import dao.UserManagementDao;
import org.junit.Test;
import util.JdbcUtil;

import java.sql.SQLException;

public class RegistDaoTest {
    @Test
    public void selectMaxInvoiceNum() throws SQLException {
        RegistDao registDao=new RegistDao();
        registDao.setConnection(JdbcUtil.getConnection());
        System.out.println(registDao.selectMaxInvoiceNum(9));
    }

    @Test
    public void selectCaseNumber() throws SQLException {
        RegistDao registDao=new RegistDao();
        registDao.setConnection(JdbcUtil.getConnection());
        System.out.println(registDao.selectCaseNumber());
    }

    @Test
    public void selectSettleCategory() throws SQLException {
        RegistDao registDao=new RegistDao();
        registDao.setConnection(JdbcUtil.getConnection());
        System.out.println(registDao.selectSettleCategory());
    }

    @Test
    public void selectRegistLevel() throws SQLException {
        RegistDao registDao=new RegistDao();
        registDao.setConnection(JdbcUtil.getConnection());
        System.out.println(registDao.selectRegistLevel());
    }
    @Test
    public void selectRegistLevelByid() throws SQLException {
        RegistDao registDao=new RegistDao();
        registDao.setConnection(JdbcUtil.getConnection());
        System.out.println(registDao.selectRegistLevelById(1));
    }

    public static class UserManagementDaoTest {

        @Test
        public void setCon() {
        }

        @Test
        public void addUSer() {
        }

        @Test
        public void delUser() {
        }

        @Test
        public void delUser1() {
        }

        @Test
        public void changeUser() {
        }

        @Test
        public void selectUser() throws SQLException {
            IUserManagementDao iuser=new UserManagementDao();
            ((UserManagementDao) iuser).setCon(JdbcUtil.getConnection());
            System.out.println(iuser.selectUser("华佗"));;
        }

        @Test
        public void reName() {
        }

        @Test
        public void selectUser1() {
        }

        @Test
        public void selectDetpID() {
        }

        @Test
        public void selectUser2() {
        }

        @Test
        public void selectDoc() {
        }

        @Test
        public void selectRegistLevel() {
        }
    }
}