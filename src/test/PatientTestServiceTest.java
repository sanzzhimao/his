package test;

import org.junit.Test;
import service.fmeditemservice.PatientTestService;

import static org.junit.Assert.*;

public class PatientTestServiceTest {

    @Test
    public void findCheckInfoByName() {
        PatientTestService pts=new PatientTestService();
        System.out.println(pts.findCheckInfoByName("马路"));
    }
}