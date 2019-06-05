package test;

import dao.registdao.RegistDao;
import org.junit.Test;
import util.JdbcUtil;
import vo.Register;
import vo.User;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



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
    @Test
    public void selectDepartment() throws SQLException {
        RegistDao registDao=new RegistDao();
        registDao.setConnection(JdbcUtil.getConnection());
        System.out.println(registDao.selectDepartment());
    }
    @Test
    public void selectDoctorInfo() throws SQLException, ParseException {
        RegistDao registDao=new RegistDao();
        registDao.setConnection(JdbcUtil.getConnection());
        Register register=new Register();
        User user=new User();
        DateFormat df= new SimpleDateFormat("yyyy-MM-dd");
        Date date=df.parse("2019-04-01");
        register.setVisitDate(date);
        register.setDeptID(1);
        register.setUserID(2);
        register.setNoon("上午");
        register.setRegistLeID(1);
        System.out.println(registDao.selectDoctorInfo(register));
    }
    @Test
    public void reRegisterByCaseNumber() throws SQLException {
        RegistDao registDao=new RegistDao();
        registDao.setConnection(JdbcUtil.getConnection());
        System.out.println(registDao.reRegisterByCaseNumber("600616"));
    }
    @Test
    public void selectID() throws SQLException {
        RegistDao registDao=new RegistDao();
        registDao.setConnection(JdbcUtil.getConnection());
        System.out.println(registDao.selectUserIDByUserName("root"));
    }
}