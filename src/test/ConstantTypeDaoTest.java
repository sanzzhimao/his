package test;

import dao.informationdao.ConstantTypeDao;
import org.junit.Test;
import util.JdbcUtil;
import vo.ConstantItem;
import vo.ConstantType;

import java.sql.SQLException;

public class ConstantTypeDaoTest {

    @Test
    public void setConnection() {
        ConstantTypeDao c1=new ConstantTypeDao();
        c1.setConnection(JdbcUtil.getConnection());
        System.out.println(9);
    }

    @Test
    public void selectAllConstantType() throws SQLException {
        ConstantTypeDao c1=new ConstantTypeDao();
        c1.setConnection(JdbcUtil.getConnection());
        System.out.println(c1.selectAllConstantType());
    }

    @Test
    public void addConstantType() throws SQLException {
        ConstantTypeDao c1=new ConstantTypeDao();
        c1.setConnection(JdbcUtil.getConnection());
        ConstantType c2=new ConstantType();
        c2.setConstantTypeCode("wer");
        c2.setConstantTypeName("何金华");
        c2.setDelMark(1);
        c1.addConstantType(c2);
    }

    @Test
    public void selectConstantType() throws SQLException {
        ConstantTypeDao c1=new ConstantTypeDao();
        c1.setConnection(JdbcUtil.getConnection());
        System.out.println(c1.selectConstantType("科室分类"));
    }

    @Test
    public void selectAllConstantItem() throws SQLException {
        ConstantTypeDao c1=new ConstantTypeDao();
        c1.setConnection(JdbcUtil.getConnection());
        System.out.println(c1.selectAllConstantType());
    }

    @Test
    public void selectConstantItem() throws SQLException {
        ConstantTypeDao c1=new ConstantTypeDao();
        c1.setConnection(JdbcUtil.getConnection());
        System.out.println(c1.selectConstantItem("WX"));
    }

    @Test
    public void addConstantItem() throws SQLException {
        ConstantTypeDao c1=new ConstantTypeDao();
        c1.setConnection(JdbcUtil.getConnection());
        ConstantItem c2=new ConstantItem();
        c2.setConstantTypeID(12);
        c2.setContantCode("qwer");
        c2.setDelMark(1);
        c2.setConstantName("何金华");
        c1.addConstantItem(c2);
    }

    @Test
    public void modifyConstantItem() {
    }
}