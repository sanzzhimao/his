package dao.drugstoredao;

import org.junit.Test;
import util.JdbcUtil;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class DrugDaoTest {

    @Test
    public void selectDrugs() throws SQLException {
        IDrugDao idd=new DrugDao();
        idd.setConnection(JdbcUtil.getConnection());
        System.out.println(idd.selectDrugs("z"));
    }
}