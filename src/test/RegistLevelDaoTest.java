package test;

import dao.IRegistLevelDao;
import dao.RegistLevelDao;
import org.junit.Test;
import util.JdbcUtil;
import vo.RegistLevel;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class RegistLevelDaoTest {

    @Test
    public void select() throws SQLException {
        IRegistLevelDao registLevelDao=new RegistLevelDao();
        ((RegistLevelDao) registLevelDao).setCon(JdbcUtil.getConnection());
        System.out.println(registLevelDao.selectRegistLevel("zjh"));
    }
    @Test
    public void reRegistLevelDao() throws SQLException {
        IRegistLevelDao registLevelDao=new RegistLevelDao();
        ((RegistLevelDao) registLevelDao).setCon(JdbcUtil.getConnection());
        System.out.println(registLevelDao.reRegistLevelID("zsda"));
    }
    @Test
    public void delRegistLevelDao() throws SQLException {
        IRegistLevelDao registLevelDao=new RegistLevelDao();
        ((RegistLevelDao) registLevelDao).setCon(JdbcUtil.getConnection());
        registLevelDao.delRegistLevel(1);
    }
}