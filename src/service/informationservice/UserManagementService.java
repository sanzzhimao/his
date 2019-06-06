package service.informationservice;

import dao.informationdao.IUserManagementDao;
import dao.informationdao.UserManagementDao;
import util.JdbcUtil;
import vo.ConstantItem;
import vo.Department;
import vo.RegistLevel;
import vo.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserManagementService implements IUserManagementService {

    @Override
    public void addUSer(User user) throws SQLException {
        Connection con=null;
        try {
            con=JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IUserManagementDao users=new UserManagementDao();
            users.setConnection(con);
            users.addUSer(user);
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
    }

    @Override
    public void delUser(String userName) throws SQLException {
        Connection con=null;
        try {
            con=JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IUserManagementDao users=new UserManagementDao();
            users.setConnection(con);
            users.delUser(userName);
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
    }

    @Override
    public void delUser(int id) throws SQLException {
        Connection con=null;
        try {
            con=JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IUserManagementDao users=new UserManagementDao();
            users.setConnection(con);
            users.delUser(id);
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
    }

    @Override
    public void changeUser(User user) throws SQLException {
        Connection con=null;
        try {
            con=JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IUserManagementDao users=new UserManagementDao();
            users.setConnection(con);
            users.changeUser(user);
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
    }

    @Override
    public List<User> selectUser(String name) throws SQLException {
        List<User> user=null;
        Connection con=null;
        try {
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IUserManagementDao iuser=new UserManagementDao();
            iuser.setConnection(con);
            user=iuser.selectUser(name);
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
        return user;
    }

    @Override
    public int reName(String name) throws SQLException {
        int namea=0;
        Connection con=null;
        try {
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IUserManagementDao inamea=new UserManagementDao();
            inamea.setConnection(con);
            namea=inamea.reName(name);
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
        return namea;
    }

    @Override
    public List<User> selectUser(int id) throws SQLException {
        List<User> ida=null;
        Connection con=null;
        try {
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IUserManagementDao iid=new UserManagementDao();
            iid.setConnection(con);
            ida=iid.selectUser(id);
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
        return ida;
    }

    @Override
    public List<Department> selectDetpID() throws SQLException {
        List<Department> dep=null;
        Connection con=null;
        try {
            con=JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IUserManagementDao idep=new UserManagementDao();
            idep.setConnection(con);
            dep=idep.selectDetpID();
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
        return dep;
    }

    @Override
    public List<User> selectUser() throws SQLException {
        List<User> user=null;
        Connection con=null;
        try {
            con=JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IUserManagementDao iuser=new UserManagementDao();
            iuser.setConnection(con);
            user=iuser.selectUser();
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
        return user;
    }

    @Override
    public List<ConstantItem> selectDoc() throws SQLException {
        List<ConstantItem> cot=null;
        Connection con=null;
        try {
            con=JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IUserManagementDao icot=new UserManagementDao();
            icot.setConnection(con);
            cot=icot.selectDoc();
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
        return cot;
    }

    @Override
    public List<RegistLevel> selectRegistLevel() throws SQLException {
        List<RegistLevel> reg=null;
        Connection con=null;
        try {
            con=JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IUserManagementDao ireg=new UserManagementDao();
            ireg.setConnection(con);
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
}
