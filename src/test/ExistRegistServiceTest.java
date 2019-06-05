package test;

import org.junit.Test;
import service.registservice.ExistRegistService;
import service.registservice.IExistRegistService;

import static org.junit.Assert.*;

public class ExistRegistServiceTest {

    @Test
    public void findRegister() {
        IExistRegistService existRegistService=new ExistRegistService();
        System.out.println(existRegistService.findRegister("600618"));
    }
}