package test;

import org.junit.Test;
import service.informationservice.DoctorCrewService;
import service.informationservice.IDoctorCrewService;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DoctorCrewServiceTest {

    /**
     * 医生排班管理业务测试类
     */

        @Test
        public void selectDoctor() throws ParseException, SQLException {
            SimpleDateFormat fo=new SimpleDateFormat("yyyy-MM-dd");
            Date d1=fo.parse("2019-03-28");
            Date d2=fo.parse("2019-03-29");
            java.sql.Date da1=new java.sql.Date(d1.getTime());
            java.sql.Date da2=new java.sql.Date(d2.getTime());
            IDoctorCrewService idcd=new DoctorCrewService();
            System.out.println(idcd.selectDoctor(da1,da2));
        }

        @Test
        public void selectDepartment() throws SQLException {
            IDoctorCrewService idcd=new DoctorCrewService();
            System.out.println(idcd.selectDepartment());
        }

        @Test
        public void selectRegistLevel() throws SQLException {
            IDoctorCrewService idcd=new DoctorCrewService();
            System.out.println(idcd.selectRegistLevel());
        }

        @Test
        public void selectUser() throws SQLException {
            IDoctorCrewService idcd=new DoctorCrewService();
            System.out.println(idcd.selectUser(1,0) );
        }

        @Test
        public void selectRule() throws SQLException {
            IDoctorCrewService idcd=new DoctorCrewService();
            System.out.println(idcd.selectRule(0));
        }

        @Test
        public void addRule() {
        }

        @Test
        public void deleteRule() {
        }
    }
