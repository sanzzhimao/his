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
            return dis;
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
        return null;
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
            return b;
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
        return false;
    }

    /**
     * 新增疾病分类
     * @param dis
     * @throws SQLException
     */
    @Override
    public void addDiseCategory(DiseCategory dis) throws SQLException {
        Connection con=null;
        try {
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IDiagnosisDao idcd=new DiagnosisDao();
            idcd.setConnection(con);
            idcd.addDiseCategory(dis);
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
    }

    /**
     * 修改疾病分类
     * @param dis
     * @throws SQLException
     */
    @Override
    public void updateDiseCategory(DiseCategory dis) throws SQLException {
        Connection con=null;
        try {
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IDiagnosisDao idcd=new DiagnosisDao();
            idcd.setConnection(con);
            idcd.updateDiseCategory(dis);
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
    }

    /**
     * 删除疾病分类
     * @param id
     * @throws SQLException
     */
    @Override
    public void deleteDiseCategory(int id) throws SQLException {
        Connection con=null;
        try {
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IDiagnosisDao idcd=new DiagnosisDao();
            idcd.setConnection(con);
            idcd.deleteDiseCategory(id);
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
    }

    /**
     * 批量删除疾病分类
     * @param id
     * @throws SQLException
     */
    @Override
    public void deleteMoreDiseCaregory(int id) throws SQLException {

    }

    /**
     * 查询疾病
     * @param dis
     * @return
     * @throws SQLException
     */
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
     * 判断疾病编码是否存在
     * @param code
     * @return
     * @throws SQLException
     */
    @Override
    public boolean selectDiseaseCode(String code) throws SQLException {
        boolean b=true;
        Connection con=null;
        try {
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IDiagnosisDao idcd=new DiagnosisDao();
            idcd.setConnection(con);
            b=idcd.selectDiseaseCode(code);
            con.commit();
            return b;
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
        return false;
    }

    /**
     * 判断国际ICD编码是否重复
     * @param icd
     * @return
     * @throws SQLException
     */
    @Override
    public boolean selectDiseaseICD(String icd) throws SQLException {
        boolean b=true;
        Connection con=null;
        try {
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IDiagnosisDao idcd=new DiagnosisDao();
            idcd.setConnection(con);
            b=idcd.selectDiseaseICD(icd);
            con.commit();
            return b;
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
        return false;
    }

    /**
     * 添加疾病
     * @param dis
     * @throws SQLException
     */
    @Override
    public void addDisease(Disease dis) throws SQLException {
        Connection con=null;
        try {
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IDiagnosisDao idcd=new DiagnosisDao();
            idcd.setConnection(con);
            idcd.addDisease(dis);
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
    }

    /**
     * 根据ID查询疾病
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public Disease selectDiseaseByID(int id) throws SQLException {
        Disease dis=null;
        Connection con=null;
        try {
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IDiagnosisDao idcd=new DiagnosisDao();
            idcd.setConnection(con);
            dis=idcd.selectDiseaseByID(id);
            con.commit();
            return dis;
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
        return null;
    }

    /**
     * 新增疾病
     * @param dis
     * @throws SQLException
     */
    @Override
    public void updateDisease(Disease dis) throws SQLException {
        Connection con=null;
        try {
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IDiagnosisDao idcd=new DiagnosisDao();
            idcd.setConnection(con);
            idcd.updateDisease(dis);
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
    }

    /**
     * 根据删除疾病
     * @param id
     * @throws SQLException
     */
    @Override
    public void deleteDisease(int id) throws SQLException {
        Connection con=null;
        try {
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IDiagnosisDao idcd=new DiagnosisDao();
            idcd.setConnection(con);
            idcd.deleteDisease(id);
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
     * @param id
     * @throws SQLException
     */
    @Override
    public void deleteMoreDisease(int id) throws SQLException {

    }
}
