package test;

import org.junit.Test;
import service.registservice.IRegistService;
import service.registservice.RegistService;

import java.sql.SQLException;
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
}