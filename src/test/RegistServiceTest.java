package test;

import org.junit.Test;
import service.registservice.IRegistService;
import service.registservice.RegistService;

import java.sql.SQLException;

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
}