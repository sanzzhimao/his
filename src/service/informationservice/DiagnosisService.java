package service.informationservice;

import dao.informationdao.DiagnosisDao;
import dao.informationdao.IDiagnosisDao;
import util.JdbcUtil;
import vo.DiseCategory;
import vo.Disease;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DiagnosisService implements IDiagnosisService{
    /**
     * 查询所有有效疾病分类(已测试)
     */
    @Override
    public List<DiseCategory> selectAllDiseCategory() throws SQLException {
        List<DiseCategory> list=null;
        Connection con=null;
        try {
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IDiagnosisDao idcd=new DiagnosisDao();
            idcd.setConnection(con);
            list=idcd.selectAllDiseCategory();
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
     * 通过疾病分类或者编码查询疾病分类(已测试)
     */
    @Override
    public List<DiseCategory> selectDiseCategory(String dica) throws SQLException {
        List<DiseCategory> list=null;
        Connection con=null;
        try {
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IDiagnosisDao idcd=new DiagnosisDao();
            idcd.setConnection(con);
            list=idcd.selectDiseCategory(dica);
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
     * 通过ID查询疾病信息(已测试)
     */
    @Override
    public DiseCategory selectDiseCategoryByID(int id) throws SQLException {
        DiseCategory dis=null;
        Connection con=null;
        try {
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IDiagnosisDao idcd=new DiagnosisDao();
            idcd.setConnection(con);
            dis=idcd.selectDiseCategoryByID(id);
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
        return dis;
    }

    /**
     * 判断编码是否存在(已测试)
     */
    @Override
    public boolean selectDicaCode(String dicacode) throws SQLException {
        boolean b=true;
        Connection con=null;
        try {
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IDiagnosisDao idcd=new DiagnosisDao();
            idcd.setConnection(con);
            b=idcd.selectDicaCode(dicacode);
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
        return b;
    }

    @Override
    public void addDiseCategory(DiseCategory dis) throws SQLException {

    }

    @Override
    public void updateDiseCategory(String dicacode, String dicaname, int sequenceno, int id) throws SQLException {

    }

    @Override
    public void deleteDiseCategory(int id) throws SQLException {

    }

    @Override
    public void deleteMoreDiseCaregory(int id) throws SQLException {

    }

    @Override
    public List<Disease> selectDisease(String dis) throws SQLException {
        List<Disease> list=null;
        Connection con=null;
        try {
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IDiagnosisDao idcd=new DiagnosisDao();
            idcd.setConnection(con);
            list=idcd.selectDisease(dis);
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
        return list;
    }

    @Override
    public boolean selectDiseaseCode(String code) throws SQLException {
        return false;
    }

    @Override
    public boolean selectDiseaseICD(String icd) throws SQLException {
        return false;
    }

    @Override
    public void addDisease(Disease dis) throws SQLException {

    }

    @Override
    public Disease selectDiseaseByID(int id) throws SQLException {
        return null;
    }

    @Override
    public void updateDisease(Disease dis) throws SQLException {

    }

    @Override
    public void deleteDisease(int id) throws SQLException {

    }

    @Override
    public void deleteMoreDisease(int id) throws SQLException {

    }
}
