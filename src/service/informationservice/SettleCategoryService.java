package service.informationservice;

import dao.informationdao.ISettleCategoryDao;
import dao.informationdao.SettleCategoryDao;
import util.JdbcUtil;
import vo.SettleCategory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SettleCategoryService implements ISettleCategoryService {
    @Override
    public void addSettleCategory(SettleCategory settleCategory) throws SQLException {
        Connection con=null;
        try {
            con=JdbcUtil.getConnection();
            con.setAutoCommit(false);
            ISettleCategoryDao reg=new SettleCategoryDao();
            reg.setCon(con);
            reg.addSettleCategory(settleCategory);
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
    }

    @Override
    public void delSettleCategory(String settle) throws SQLException {
        Connection con=null;
        try {
            con=JdbcUtil.getConnection();
            con.setAutoCommit(false);
            ISettleCategoryDao reg=new SettleCategoryDao();
            reg.setCon(con);
            reg.delSettleCategory(settle);
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
    }

    @Override
    public void delSettleCategory(int id) throws SQLException {
        Connection con=null;
        try {
            con=JdbcUtil.getConnection();
            con.setAutoCommit(false);
            ISettleCategoryDao reg=new SettleCategoryDao();
            reg.setCon(con);
            reg.delSettleCategory(id);
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
    }

    @Override
    public void changeSettleCategory(SettleCategory settleCategory) throws SQLException {
        Connection con=null;
        try {
            con=JdbcUtil.getConnection();
            con.setAutoCommit(false);
            ISettleCategoryDao reg=new SettleCategoryDao();
            reg.setCon(con);
            reg.changeSettleCategory(settleCategory);
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
    }

    @Override
    public List<SettleCategory> selectSettleCategory(String settle) throws SQLException {
        List<SettleCategory> set=null;
        Connection con=null;
        try {
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            ISettleCategoryDao iset=new SettleCategoryDao();
            iset.setCon(con);
            set=iset.selectSettleCategory(settle);
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
        return set;
    }

    @Override
    public List<SettleCategory> selectSettleCategory() throws SQLException {
        List<SettleCategory> sec=null;
        Connection con=null;
        try {
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            ISettleCategoryDao isec=new SettleCategoryDao();
            isec.setCon(con);
            sec=isec.selectSettleCategory();
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
        return sec;
    }
}
