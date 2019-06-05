package test;

import org.junit.Test;
import service.drugstoreservice.SendMedicalService;

import java.sql.SQLException;
import java.text.ParseException;

import static org.junit.Assert.*;

public class SendMedicalServiceTest {

    @Test
    public void selectSendMedicalService() throws SQLException, ParseException {
        SendMedicalService s=new SendMedicalService();
        System.out.println(s.selectSendMedicalService("600601", "2019-06-05 09:48:13"));
    }

    @Test
    public void modifyState() throws SQLException {
        SendMedicalService s=new SendMedicalService();
        s.modifyState(2);
    }
}