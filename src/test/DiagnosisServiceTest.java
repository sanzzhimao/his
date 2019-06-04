package test;

import org.junit.Test;
import service.information.DiagnosisService;
import service.information.IDiagnosisService;

import java.sql.SQLException;

public class DiagnosisServiceTest {

    @Test
    public void selectAllDiseCategory() throws SQLException {
        IDiagnosisService ids=new DiagnosisService();
        System.out.println(ids.selectAllDiseCategory());
    }

    @Test
    public void selectDiseCategory() throws SQLException{
        IDiagnosisService ids=new DiagnosisService();
        System.out.println(ids.selectDiseCategory("白"));
    }

    @Test
    public void selectDiseCategoryByID() throws SQLException{
        IDiagnosisService ids=new DiagnosisService();
        System.out.println(ids.selectDiseCategoryByID(2));
    }

    @Test
    public void selectDicaCode() throws SQLException{
        IDiagnosisService ids=new DiagnosisService();
        System.out.println(ids.selectDicaCode("AZ"));
    }

    @Test
    public void addDiseCategory() throws SQLException{
    }

    @Test
    public void updateDiseCategory() throws SQLException{
    }

    @Test
    public void deleteDiseCategory() throws SQLException{
    }

    @Test
    public void deleteMoreDiseCaregory() throws SQLException{
    }

    @Test
    public void selectDisease() throws SQLException{
        IDiagnosisService ids=new DiagnosisService();
        System.out.println(ids.selectDicaCode("AZ"));
    }

    @Test
    public void selectDiseaseCode()throws SQLException {
    }

    @Test
    public void selectDiseaseICD() throws SQLException{
    }

    @Test
    public void addDisease() throws SQLException{
    }

    @Test
    public void selectDiseaseByID() throws SQLException{
    }

    @Test
    public void updateDisease() throws SQLException{
    }

    @Test
    public void deleteDisease() throws SQLException{
    }

    @Test
    public void deleteMoreDisease() throws SQLException{
    }
}