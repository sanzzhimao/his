package test;

import dao.doctor.IMedicalDao;
import dao.doctor.MedicalDao;
import org.junit.Test;
import util.JdbcUtil;

import java.sql.SQLException;

public class MedicalDaoTest {
    IMedicalDao imd=new MedicalDao();

    @Test
    public void setConnection() {
    }

    @Test
    public void selectMedicalByUserID() {
    }

    @Test
    public void selectMedicalByDeptID() {
    }

    @Test
    public void updateMedicalHome() {
    }

    @Test
    public void updaMedical() {
    }

    @Test
    public void selectExamine() throws SQLException {
        imd.setConnection(JdbcUtil.getConnection());
        System.out.println(imd.selectExamine(1,""));
    }
}