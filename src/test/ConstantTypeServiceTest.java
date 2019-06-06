package test;

import org.junit.Test;
import service.informationservice.ConstantTypeService;
import vo.ConstantItem;
import vo.ConstantType;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ConstantTypeServiceTest {

    @Test
    public void selectAllConstantType() {
        ConstantTypeService c=new ConstantTypeService();
        System.out.println(c.selectAllConstantType());
    }

    @Test
    public void addConstantType() {
        ConstantTypeService c=new ConstantTypeService();
        ConstantType c1=new ConstantType();
        c1.setId(1);
        c1.setConstantTypeCode("uio");
        c1.setConstantTypeName("李徐坤");
        c1.setDelMark(1);
        System.out.println(c.addConstantType(c1));
    }

    @Test
    public void selectConstantType() {
        ConstantTypeService c=new ConstantTypeService();
        System.out.println(c.selectConstantType("李徐坤"));
    }

    @Test
    public void selectAllConstantItem() {
        ConstantTypeService c=new ConstantTypeService();
        System.out.println(c.selectAllConstantItem("WK"));
    }

    @Test
    public void selectConstantItem() {
        ConstantTypeService c=new ConstantTypeService();
        System.out.println(c.selectConstantItem("w"));
    }

    @Test
    public void addConstantItem() {
        ConstantTypeService c=new ConstantTypeService();
        ConstantItem c1=new ConstantItem();
        c1.setId(1);
        c1.setContantCode("798");
        c1.setConstantName("789");
        c1.setConstantTypeID(789);
        c1.setDelMark(1);
        System.out.println(c.addConstantItem(c1));
    }

    @Test
    public void modifyConstantItem() {
        ConstantTypeService c=new ConstantTypeService();
        ConstantItem c1=new ConstantItem();
        c1.setId(11);
        c1.setContantCode("798");
        c1.setConstantName("789");
        c1.setConstantTypeID(789);
        c1.setDelMark(1);
        c.modifyConstantItem(c1);
    }

    @Test
    public void delectConstantItem() {
        ConstantTypeService c=new ConstantTypeService();
        ConstantItem c1=new ConstantItem();
        c1.setId(11);
        c1.setContantCode("798");
        c1.setConstantName("789");
        c1.setConstantTypeID(789);
        c1.setDelMark(1);
        c.delectConstantItem(c1);
    }

    @Test
    public void delectDuoConstantItem() {
        ConstantTypeService c=new ConstantTypeService();
        ArrayList list=new ArrayList();
        list.add(12);
        list.add(14);
        System.out.println(c.delectDuoConstantItem(list));
    }
}