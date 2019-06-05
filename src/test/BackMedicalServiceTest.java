package test;

import org.junit.Test;
import service.drugstoreservice.BackMedicalService;
import service.drugstoreservice.SendMedicalService;

import java.sql.SQLException;
import java.text.ParseException;

import static org.junit.Assert.*;

public class BackMedicalServiceTest {

    @Test
    public void selectSendMedicalService() throws SQLException, ParseException {
        BackMedicalService s=new BackMedicalService();
        System.out.println(s.selectSendMedicalService("600601", "2019-06-05 09:48:13"));
    }

    @Test
    public void modifyState() throws SQLException {
        BackMedicalService s=new BackMedicalService();
        s.modifyState(2);
    }
}