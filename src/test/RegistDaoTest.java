package test;

import dao.RegistDao;
import org.junit.Test;
import util.JdbcUtil;

import java.sql.SQLException;

import static org.junit.Assert.*;

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
}