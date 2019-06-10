package service.informationservice;

import dao.DepartmentDao;
import dao.IDepartmentDao;
import util.JdbcUtil;
import vo.ConstantItem;
import vo.Department;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DepartmentService implements IDepartmentService {

    @Override
    public List<Department> selectDepartment(String sting) throws SQLException {
        List<Department> dep=null;
        Connection con=null;
        try {
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IDepartmentDao idep=new DepartmentDao();
            idep.setConnection(con);
            dep= idep.selectDepartment(sting,sting);
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
    public List<ConstantItem> selectConstantItem() throws SQLException {
        List<ConstantItem> cnt=null;
        Connection con=null;
        try {
            con=JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IDepartmentDao idep=new DepartmentDao();
            idep.setConnection(con);
            cnt=idep.selectConstantItem();
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
        return null;
    }

    @Override
    public void addnewDepartment(Department department) throws SQLException {
        Connection con=null;
        try {
            con=JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IDepartmentDao dep=new DepartmentDao();
            dep.setConnection(con);
            dep.addnewDepartment(department);
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
    }

    @Override
    public void updateDepartment(Department department) throws SQLException {
        Connection con=null;
        try {
            con=JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IDepartmentDao dep=new DepartmentDao();
            dep.setConnection(con);
            dep.updateDepartment(department);
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
    }

    @Override
    public void deleteDepartment(int id) throws SQLException {
        Connection con=null;
        try {
            con=JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IDepartmentDao dep=new DepartmentDao();
            dep.setConnection(con);
            dep.deleteDepartment(id);
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
    }
}
