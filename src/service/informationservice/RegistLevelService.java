package service.informationservice;

import dao.DepartmentDao;
import dao.IDepartmentDao;
import dao.informationdao.IRegistLevelDao;
import dao.informationdao.IUserManagementDao;
import dao.informationdao.RegistLevelDao;
import dao.informationdao.UserManagementDao;
import util.JdbcUtil;
import vo.RegistLevel;
import vo.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class RegistLevelService implements IRegistLevelService {
    @Override
    public void addRegistLevel(RegistLevel registLevel) throws SQLException {
        Connection con=null;
        try {
            con=JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IRegistLevelDao reg=new RegistLevelDao();
            reg.setCon(con);
            reg.addRegistLevel(registLevel);
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
    }

    @Override
    public void delRegistLevel(int sequenceNo) throws SQLException {
        Connection con=null;
        try {
            con=JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IRegistLevelDao reg=new RegistLevelDao();
            reg.setCon(con);
            reg.delRegistLevel(sequenceNo);
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
    }

    @Override
    public void changeRegistLevel(RegistLevel registLevel) throws SQLException {
        Connection con=null;
        try {
            con=JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IRegistLevelDao reg=new RegistLevelDao();
            reg.setCon(con);
            reg.changeRegistLevel(registLevel);
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
    }

    @Override
    public List<RegistLevel> selectRegistLevel(String strName) throws SQLException {
        List<RegistLevel> reg=null;
        Connection con=null;
        try {
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);

           IRegistLevelDao ireg=new RegistLevelDao();
            ireg.setCon(con);
            reg=ireg.selectRegistLevel(strName);
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
        return reg;
    }

    @Override
    public List<RegistLevel> selectRegistLevel() throws SQLException {
        List<RegistLevel> reg=null;
        Connection con=null;
        try {
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);

            IRegistLevelDao ireg=new RegistLevelDao();
            ireg.setCon(con);
            reg=ireg.selectRegistLevel();
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
        return reg;
    }

    @Override
    public List<RegistLevel> selectRegistLevel(int id) throws SQLException {
        List<RegistLevel> reg=null;
        Connection con=null;
        try {
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);

            IRegistLevelDao ireg=new RegistLevelDao();
            ireg.setCon(con);
            reg=ireg.selectRegistLevel(id);
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
        return reg;
    }

    @Override
    public int reRegistLevelID(String registCode) throws SQLException {
        int regt=0;
        Connection con=null;
        try {
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IRegistLevelDao iregt=new RegistLevelDao();
            iregt.setCon(con);
            regt=iregt.reRegistLevelID(registCode);
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
        return regt;
    }
}
