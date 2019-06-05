package test;

import dao.drugstoredao.BackMedicalDao;
import org.junit.Test;
import util.JdbcUtil;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.jar.JarEntry;

import static org.junit.Assert.*;

public class BackMedicalDaoTest {

    @Test
    public void setConnection() {
    }

    @Test
    public void backMedical() throws SQLException, ParseException {
        BackMedicalDao b=new BackMedicalDao();
        b.setConnection(JdbcUtil.getConnection());
        System.out.println(b.backMedical("600601", "2019-06-05 09:48:13"));
    }

    @Test
    public void modifyStatus() {
    }
}