package test;

import org.junit.Test;
import service.fmeditemservice.CostsService;

import static org.junit.Assert.*;

public class CostsServiceTest {

    @Test
    public void findPatientInfoByCaseNumber() {
        CostsService costsService=new CostsService();
        System.out.println(costsService.findPatientInfoByCaseNumber("600618"));
    }
}