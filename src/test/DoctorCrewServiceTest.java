package test;

import org.junit.Test;
import service.DoctorCrewService;
import service.IDoctorCrewService;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DoctorCrewServiceTest {
    public static void main(String[] args){
        IDoctorCrewService id=new DoctorCrewService();
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        Date s11= null;
        Date s12= null;
        try {
            s11 = sdf.parse("2019-03-10");
            s12 = sdf.parse("2019-04-16");
            try {
                java.sql.Date s1=new java.sql.Date(s11.getTime());
                java.sql.Date s2=new java.sql.Date(s12.getTime());
                System.out.println(id.selectDoctor(s1,s2));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void selectDoctorCrew() {

    }
}