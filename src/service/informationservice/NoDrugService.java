package service.informationservice;

import dao.informationdao.INoDrugDao;
import dao.informationdao.NoDrugDao;
import util.JdbcUtil;
import vo.Department;
import vo.ExpenseClass;
import vo.NoDrug;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 非药品收费项目管理业务
 */
public class NoDrugService implements INoDrugService {
    /**
     * 点击查询非药品收费项目按钮（根据编码或者名称查询当前有效非药品收费项目）
     * @param item
     * @return
     * @throws SQLException
     */
    @Override
    public List<NoDrug> selectNoDrug(String item) throws SQLException {
        List<NoDrug> list=null;
        Connection con=null;
        try {
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            INoDrugDao idcd=new NoDrugDao();
            idcd.setConnection(con);
            list=idcd.selectNoDrug(item);
            con.commit();

        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
        return list;
    }

    /**
     * 点击编辑按钮（根据ID查询当前非药品信息）
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public NoDrug selectNoDrugByID(int id) throws SQLException {
        NoDrug noDrug=null;
        Connection con=null;
        try {
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            INoDrugDao idcd=new NoDrugDao();
            idcd.setConnection(con);
            noDrug=idcd.selectNoDrugByID(id);
            con.commit();
            return noDrug;
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
        return null;
    }

    /**
     * 查询有效费用分类
     * @return
     * @throws SQLException
     */
    @Override
    public List<ExpenseClass> selectExpenseClass() throws SQLException {
        List<ExpenseClass> list=null;
        Connection con=null;
        try {
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            INoDrugDao idcd=new NoDrugDao();
            idcd.setConnection(con);
            list=idcd.selectExpenseClass();
            con.commit();
            return list;
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
        return null;
    }

    /**
     *查询有效执行科室
     * @return
     * @throws SQLException
     */
    @Override
    public List<Department> selectDepartment() throws SQLException {
        List<Department> list=null;
        Connection con=null;
        try {
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            INoDrugDao idcd=new NoDrugDao();
            idcd.setConnection(con);
            list=idcd.selectDepartment();
            con.commit();
            return list;
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
        return null;
    }

    /**
     * 新增按钮中的保存（新增非药品信息）
     * @param nodrug
     * @throws SQLException
     */
    @Override
    public void addNoDrug(NoDrug nodrug) throws SQLException {
        Connection con=null;
        try {
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            INoDrugDao idcd=new NoDrugDao();
            idcd.setConnection(con);
            idcd.addNoDrug(nodrug);
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
    }

    /**
     * 编辑按钮弹出框的保存按钮（修改药品信息）
     * @param nodrug
     * @throws SQLException
     */
    @Override
    public void updateNoDrug(NoDrug nodrug) throws SQLException {
        Connection con=null;
        try {
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            INoDrugDao idcd=new NoDrugDao();
            idcd.setConnection(con);
            idcd.updateNoDrug(nodrug);
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
    }

    /**
     * 删除按钮（根据ID删除选中非药品）
     * @param id
     * @throws SQLException
     */
    @Override
    public void deleteNoDrug(int id) throws SQLException {
        Connection con=null;
        try {
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            INoDrugDao idcd=new NoDrugDao();
            idcd.setConnection(con);
            idcd.deleteNoDrug(id);
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
    }

    @Override
    public void deleteAllNoDrug(int[] id) throws SQLException {

    }

}
