package test;

import org.junit.Test;
import service.informationservice.INoDrugService;
import service.informationservice.NoDrugService;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class NoDrugServiceTest {
    INoDrugService inds=new NoDrugService();
    @Test
    public void selectNoDrug() throws SQLException {
        System.out.println(inds.selectNoDrug("大"));
    }

    @Test
    public void selectNoDrugByID() throws SQLException {
        System.out.println(inds.selectNoDrugByID(1));
    }

    @Test
    public void selectExpenseClass() throws SQLException {
        System.out.println(inds.selectExpenseClass());
    }

    @Test
    public void selectDepartment() throws SQLException {
        System.out.println(inds.selectDepartment());
    }

    @Test
    public void addNoDrug() throws SQLException {

    }

    @Test
    public void updateNoDrug() throws SQLException {

    }

    @Test
    public void deleteNoDrug() throws SQLException {
        inds.deleteNoDrug(1);
    }

    @Test
    public void deleteAllNoDrug() throws SQLException {
    }
}