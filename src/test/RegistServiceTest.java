package test;

import org.junit.Test;
import service.registservice.IRegistService;
import service.registservice.RegistService;
import vo.Invoice;
import vo.Register;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class RegistServiceTest {

    @Test
    public void maxInvoceAndCaseNumber() throws SQLException {
        IRegistService registService=new RegistService();
        System.out.println(registService.MaxInvoceAndCaseNumber("root"));
    }

    @Test
    public void findRegisterByCaseNumber() throws SQLException {
        IRegistService registService=new RegistService();
        System.out.println(registService.findRegisterByCaseNumber("600618"));
    }
    @Test
    public void findDocrew() throws SQLException, ParseException {
        IRegistService registService=new RegistService();
        SimpleDateFormat fo=new SimpleDateFormat("yyyy-MM-dd");
        Date d1=fo.parse("2019-03-28");
        Date d2=fo.parse("2019-03-28");
        java.sql.Date da1=new java.sql.Date(d1.getTime());
        java.sql.Date da2=new java.sql.Date(d2.getTime());
        System.out.println(registService.findDocCrew(da1));
    }
    @Test
    public void quto() throws SQLException, ParseException {
        IRegistService registService=new RegistService();
        SimpleDateFormat fo=new SimpleDateFormat("yyyy-MM-dd");
        Date d1=fo.parse("2019-03-28");
        Date d2=fo.parse("2019-03-28");
        java.sql.Date da1=new java.sql.Date(d1.getTime());
        java.sql.Date da2=new java.sql.Date(d2.getTime());
        System.out.println(registService.findUsedQuto("root",da1));
    }
    @Test
    public void sffs() throws SQLException, ParseException {
        IRegistService registService=new RegistService();
        System.out.println(registService.fianShouFeiFangShi());

    }
    @Test
    public void fapiao() throws SQLException, ParseException {
        IRegistService registService=new RegistService();
        Register register=new Register();
        register.setId(1001);
        register.setRealName("lym");
        register.setCaseNumber("600620");
        register.setGender(1);
        register.setIdNumber("5131281112554");
        register.setAge(24);
        register.setBirthDate(new Date(new Date().getTime()-21*3600000));
        register.setAgeTpye("岁");
        DateFormat af=new SimpleDateFormat("yyyy-MM-dd");
        String da1="2019-05-22";
        Date dataStr=af.parse(da1);
        register.setVisitDate(dataStr);
        register.setNoon("am");
        register.setDeptID(1);
        register.setUserID(1);
        register.setRegistTime(new Date());
        register.setVisitState(1);
        register.setIsBook("否");
        Invoice iv=new Invoice();
        iv.setId(1001);
        iv.setInvoiceNum("1235645");
        iv.setMoney(8);
        iv.setState(1);
        iv.setCreationTime(new Date());
        iv.setUserID(1);
        iv.setRegistID(1);
        System.out.println(registService.registered(register, iv, 12));
    }
}