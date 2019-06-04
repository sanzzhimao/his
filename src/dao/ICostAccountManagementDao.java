package dao;

import com.sun.org.apache.xml.internal.resolver.readers.ExtendedXMLCatalogReader;
import vo.ExpenseClass;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author lym
 * @Description:这个一个小接口--费用科目管理
**/
public interface ICostAccountManagementDao {
    void setCon(Connection con);
    /**
     * @Author lym
     * @Description:查询有效的费用科目通过名字或者编码（模糊查询）
     * @Param [strName]
     * @return vo.ExpenseClass
    **/
    ExpenseClass selectExpenseClassByname(String strName) throws SQLException;
    /**
     * @Author lym
     * @Description:通过id查询科目费用的信息s
     * @Param [id]
     * @return vo.ExpenseClass
    **/
    ExpenseClass selectExpenseClassByID(int id) throws SQLException;
    /**
     * @Author lym
     * @Description 返回科目编码出现的次数
     * @Param [expCode]
     * @return int
     **/
    int repeatOfExpCode(String expCode) throws SQLException;
    /**
     * @Author lym
     * @Description:增加一个费用科目
     * @Param [expenseClass]
     * @return boolean
    **/
    boolean addEXpClass(ExpenseClass expenseClass) throws SQLException;
    /**
     * @Author lym
     * @Description:修改一个费用科目
     * @Param [expenseClass]
     * @return boolean
     **/
    boolean changeExpClass(ExpenseClass expenseClass) throws SQLException;
    /**
     * @Author lym
     * @Description: 删除一个费用科目（delmark=0）
     * @Param [id]
     * @return boolean
    **/
    boolean delExpClass(int id) throws SQLException;
}
