package service.drugstoreservice;

import dao.drugstoredao.DrugDao;
import dao.drugstoredao.IDrugDao;
import util.JdbcUtil;
import vo.ConstantItem;
import vo.Drugs;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DrugService implements IDrugService{
    /**
     * 查询药品(已测试)
     * @param mnemonicCode
     * @return
     * @throws SQLException
     */
    @Override
    public List<Drugs> selectDrugs(String mnemonicCode) throws SQLException {
        List<Drugs> list=null;
        Connection con=null;
        try {
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IDrugDao idd=new DrugDao();
            idd.setConnection(con);
            list=idd.selectDrugs(mnemonicCode);
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

    @Override
    public List<ConstantItem> selectDrugsDosage() throws SQLException {
        List<ConstantItem> list=null;
        Connection con=null;
        try {
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IDrugDao idd=new DrugDao();
            idd.setConnection(con);
            list=idd.selectDrugsDosage();
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

    @Override
    public List<ConstantItem> selectDrugsType() throws SQLException {
        List<ConstantItem> list=null;
        Connection con=null;
        try {
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IDrugDao idd=new DrugDao();
            idd.setConnection(con);
            list=idd.selectDrugsType();
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

    @Override
    public Drugs selectDrug(int id) throws SQLException {
        Drugs drug=null;
        Connection con=null;
        try {
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IDrugDao idd=new DrugDao();
            idd.setConnection(con);
            drug=idd.selectDrug(id);
            con.commit();
            return drug;
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
        return null;
    }

    @Override
    public void addDrugs(Drugs drug) throws SQLException {
        Connection con=null;
        try {
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IDrugDao idd=new DrugDao();
            idd.setConnection(con);
            idd.addDrugs(drug);
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
    }

    @Override
    public void updateDrugs(Drugs drug) throws SQLException {
        Connection con=null;
        try {
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IDrugDao idd=new DrugDao();
            idd.setConnection(con);
            idd.updateDrugs(drug);
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
    }

    @Override
    public void deleteDrugs(int id) throws SQLException {
        Connection con=null;
        try {
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IDrugDao idd=new DrugDao();
            idd.setConnection(con);
            idd.deleteDrugs(id);
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
    }
}
