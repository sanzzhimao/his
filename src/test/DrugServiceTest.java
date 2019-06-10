package test;

import org.junit.Test;
import service.drugstoreservice.DrugService;
import service.drugstoreservice.IDrugService;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class DrugServiceTest {
    IDrugService ids= new DrugService();

    @Test
    public void selectDrugs() throws SQLException {
        System.out.println(ids.selectDrugs("Z"));
    }

    @Test
    public void selectDrugsDosage() throws SQLException{
        System.out.println(ids.selectDrugsDosage());
    }

    @Test
    public void selectDrugsType() throws SQLException {
        System.out.println(ids.selectDrugsType());
    }

    @Test
    public void selectDrug() throws SQLException {
        System.out.println(ids.selectDrug(5));
    }

    @Test
    public void addDrugs() throws SQLException {

    }

    @Test
    public void updateDrugs() throws SQLException {

    }

    @Test
    public void deleteDrugs() throws SQLException {

    }
}
