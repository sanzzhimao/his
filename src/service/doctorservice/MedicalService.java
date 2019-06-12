package service.doctorservice;

import dao.doctordao.IMedicalDao;
import dao.doctordao.MedicalDao;
import util.JdbcUtil;
import vo.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MedicalService implements IMedicalService{
    /**
     *通过医生ID查病历
     * @param
     * @return
     * @throws SQLException
     */
    @Override
    public List<MedicalRecord> selectMedical() throws SQLException {
        List<MedicalRecord> list=null;
        Connection con=null;
        try {
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IMedicalDao idd=new MedicalDao();
            idd.setConnection(con);
            list=idd.selectMedical();
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
     * 通过科室ID查病历
     * @param
     * @return
     * @throws SQLException
     */
    @Override
    public MedicalRecord selectMedicalByID(int id) throws SQLException {
        MedicalRecord list=null;
        Connection con=null;
        try {
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IMedicalDao idd=new MedicalDao();
            idd.setConnection(con);
            list=idd.selectMedicalByID(id);
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
    public void updateCaseState(int id) throws SQLException {
        Connection con=null;
        try {
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IMedicalDao idd=new MedicalDao();
            idd.setConnection(con);
            idd.updateCaseState(id);
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
    }

    /**
     *
     * @param me
     * @throws SQLException
     */
    @Override
    public void updateMedicalHome(MedicalRecord me) throws SQLException {
        Connection con=null;
        try {
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IMedicalDao idd=new MedicalDao();
            idd.setConnection(con);
            idd.updateMedicalHome(me);
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
    }

    @Override
    public void updateMedical(MedicalRecord me) throws SQLException {
        Connection con=null;
        try {
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IMedicalDao idd=new MedicalDao();
            idd.setConnection(con);
            idd.updaMedical(me);
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
    }

    @Override
    public List<NoDrug> selectExamine(int recordtype, String name) throws SQLException {
        List<NoDrug> list=null;
        Connection con=null;
        try {
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IMedicalDao idd=new MedicalDao();
            idd.setConnection(con);
            list=idd.selectExamine(recordtype,name);
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
    public List<CheckApply> selectCheckApply(int id,int type) throws SQLException {
        List<CheckApply> list=null;
        Connection con=null;
        try {
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IMedicalDao idd=new MedicalDao();
            idd.setConnection(con);
            list=idd.selectCheckApply(id,type);
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
    public void addCheckApply(CheckApply checkApply) throws SQLException {
        Connection con=null;
        try {
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IMedicalDao idd=new MedicalDao();
            idd.setConnection(con);
            idd.addCheckApply(checkApply);
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
    }

    @Override
    public List<Prescription> selectPrescription() throws SQLException {
        List<Prescription> list=null;
        Connection con=null;
        try {
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IMedicalDao idd=new MedicalDao();
            idd.setConnection(con);
            list=idd.selectPrescription();
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
    public void addPrescription(Prescription pre) throws SQLException {
        Connection con=null;
        try {
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IMedicalDao idd=new MedicalDao();
            idd.setConnection(con);
            idd.addPrescription(pre);
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
    }

    @Override
    public List<PrescriptionDetailed> selectPrescriptionDetailed(int id) throws SQLException {
        List<PrescriptionDetailed> list=null;
        Connection con=null;
        try {
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IMedicalDao idd=new MedicalDao();
            idd.setConnection(con);
            list=idd.selectPrescriptionDetailed(id);
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
    public void addPrescriptionDetailed(PrescriptionDetailed pd) throws SQLException {
        Connection con=null;
        try {
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IMedicalDao idd=new MedicalDao();
            idd.setConnection(con);
            idd.addPrescriptionDetailed(pd);
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
    }

    @Override
    public List<HerbalPrescription> selectHerbalPrescription() throws SQLException {
        List<HerbalPrescription> list=null;
        Connection con=null;
        try {
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IMedicalDao idd=new MedicalDao();
            idd.setConnection(con);
            list=idd.selectHerbalPrescription();
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
    public List<HerbalDetailed> selectHerbalDetailed(int id) throws SQLException {
        List<HerbalDetailed> list=null;
        Connection con=null;
        try {
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IMedicalDao idd=new MedicalDao();
            idd.setConnection(con);
            list=idd.selectHerbalDetailed(id);
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
    public List<PatientCosts> selectPatientCosts() throws SQLException {
        List<PatientCosts> list=null;
        Connection con=null;
        try {
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IMedicalDao idd=new MedicalDao();
            idd.setConnection(con);
            list=idd.selectPatientCosts();
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
}
