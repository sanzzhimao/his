package test;

import dao.drugstoredao.SendMedicalDao;
import org.junit.Test;
import util.JdbcUtil;
import vo.SendMedical;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class SendMedicalDaoTest {

    @Test
    public void sendMedical() throws SQLException, ParseException {
        SendMedicalDao c1=new SendMedicalDao();
        c1.setConnection(JdbcUtil.getConnection());
//        System.out.println(c1.sendMedical("600601"));
        List<SendMedical> list=c1.sendMedical("600601");
        for (SendMedical l:list
             ) {
            System.out.println(l);

        }
    }


    @Test
    public void modifyStatus() throws SQLException {
        SendMedicalDao c1=new SendMedicalDao();
        c1.setConnection(JdbcUtil.getConnection());
        c1.modifyStatus(1);
    }
}