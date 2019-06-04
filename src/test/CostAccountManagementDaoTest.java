package test;

import dao.CostAccountManagementDao;
import dao.ICostAccountManagementDao;
import org.junit.Test;
import util.JdbcUtil;
import vo.ExpenseClass;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class CostAccountManagementDaoTest {

    @Test
    public void selectExpenseClassByname() throws SQLException {
        ICostAccountManagementDao ic=new CostAccountManagementDao();
        ic.setCon(JdbcUtil.getConnection());
        System.out.println(ic.selectExpenseClassByname("GHF"));
    }
    @Test
    public void repeat() throws SQLException {
        ICostAccountManagementDao ic=new CostAccountManagementDao();
        ic.setCon(JdbcUtil.getConnection());
        System.out.println(ic.repeatOfExpCode("GHF"));
    }
    @Test
    public void addExpenseclass() throws SQLException {
        ICostAccountManagementDao ic=new CostAccountManagementDao();
        ic.setCon(JdbcUtil.getConnection());
        ExpenseClass expenseClass=new ExpenseClass();
        expenseClass.setExpCode("ccfy");
        expenseClass.setExpName("cc费用");
        System.out.println(ic.addEXpClass(expenseClass));
    }
    @Test
    public void chanageExpenseclass() throws SQLException {
        ICostAccountManagementDao ic=new CostAccountManagementDao();
        ic.setCon(JdbcUtil.getConnection());
        ExpenseClass expenseClass=new ExpenseClass();
        expenseClass.setExpCode("ddfy");
        expenseClass.setExpName("cc费用");
        expenseClass.setId(22);
        System.out.println(ic.changeExpClass(expenseClass));
    }
    @Test
    public void delExpenseclass() throws SQLException {
        ICostAccountManagementDao ic=new CostAccountManagementDao();
        ic.setCon(JdbcUtil.getConnection());
        System.out.println(ic.delExpClass(23));
    }
}