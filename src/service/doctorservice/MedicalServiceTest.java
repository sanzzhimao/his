package service.doctorservice;

import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class MedicalServiceTest {
    IMedicalService ims=new MedicalService();
    @Test
    public void selectMedicalByUserID() throws SQLException {
        System.out.println(ims.selectMedicalByUserID(1));
    }

    @Test
    public void selectMedicalByDeptID() throws SQLException {
        System.out.println(ims.selectMedicalByDeptID(1));
    }

    @Test
    public void updateMedicalHome() {

    }

    @Test
    public void updaMedical() {
    }

    @Test
    public void selectExamine() throws SQLException {
        System.out.println(ims.selectExamine(1,"z"));
    }

    @Test
    public void selectCheckApply() throws SQLException {
        System.out.println(ims.selectCheckApply(2,2));
    }

    @Test
    public void addCheckApply() {
    }

    @Test
    public void selectPrescription() throws SQLException {
        System.out.println(ims.selectPrescription());
    }

    @Test
    public void addPrescription() {
    }

    @Test
    public void selectPrescriptionDetailed() throws SQLException {
        System.out.println(ims.selectPrescriptionDetailed(1));
    }

    @Test
    public void addPrescriptionDetailed() {
    }

    @Test
    public void selectHerbalPrescription() throws SQLException {
        System.out.println(ims.selectHerbalPrescription());
    }

    @Test
    public void selectHerbalDetailed() {
    }

    @Test
    public void selectPatientCosts() throws SQLException {
        System.out.println(ims.selectPatientCosts());
    }
}