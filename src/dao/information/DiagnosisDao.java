package dao.information;

import util.JdbcUtil;
import vo.DiseCategory;
import vo.Disease;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 诊断目录管理Dao层类
 */
public class DiagnosisDao implements IDiagnosisDao {
    Connection con=null;
    @Override
    public void setConnection(Connection con) {
        this.con=con;
    }

    /**
     * 查询所有有效疾病分类
     * @return
     * @throws SQLException
     */
    @Override
    public List<DiseCategory> selectAllDiseCategory() throws SQLException {
        String sql="select * from disecategory where DelMark=1";
        PreparedStatement pstmt=con.prepareStatement(sql);
        ResultSet rs=pstmt.executeQuery();
        List<DiseCategory> dis=new ArrayList<>();
        DiseCategory dise=null;
        while (rs.next()){
            dise=new DiseCategory();
            dise.setId(rs.getInt(1));
            dise.setDicaCode(rs.getString(2));
            dise.setDicaName(rs.getString(3));
            dise.setSequenceNo(rs.getInt(4));
            dise.setDicaType(rs.getInt(5));
            dise.setDelMark(rs.getInt(6));
            dis.add(dise);
        }
        JdbcUtil.release(null,pstmt,rs);
        return dis;
    }

    /**
     * 通过疾病分类或者编码查询疾病分类
     * @param dica
     * @return
     * @throws SQLException
     */
    @Override
    public List<DiseCategory> selectDiseCategory(String dica) throws SQLException {
        String sql="select * from disecategory where (DicaCode like \"%\"?\"%\" or DicaName like \"%\"?\"%\") and DelMark=1 order by SequenceNo";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,dica);
        pstmt.setString(2,dica);
        ResultSet rs=pstmt.executeQuery();
        List<DiseCategory> dis=new ArrayList<>();
        DiseCategory dise=null;
        while (rs.next()){
            dise=new DiseCategory();
            dise.setId(rs.getInt(1));
            dise.setDicaCode(rs.getString(2));
            dise.setDicaName(rs.getString(3));
            dise.setSequenceNo(rs.getInt(4));
            dise.setDicaType(rs.getInt(5));
            dise.setDelMark(rs.getInt(6));
            dis.add(dise);
        }
        JdbcUtil.release(null,pstmt,rs);
        return dis;
    }

    /**
     * 通过ID查询疾病信息
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public DiseCategory selectDiseCategoryByID(int id) throws SQLException {
        String sql="select * from disecategory where ID=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setInt(1,id);
        ResultSet rs=pstmt.executeQuery();
        DiseCategory dis=null;
        while (rs.next()){
            dis=new DiseCategory();
            dis.setId(rs.getInt(1));
            dis.setDicaCode(rs.getString(2));
            dis.setDicaName(rs.getString(3));
            dis.setSequenceNo(rs.getInt(4));
            dis.setDicaType(rs.getInt(5));
            dis.setDelMark(rs.getInt(6));
        }
        JdbcUtil.release(null,pstmt,rs);
        return dis;
    }

    /**
     * 判断疾病编码是否存在
     * @param dicacode
     * @return
     * @throws SQLException
     */
    @Override
    public boolean selectDicaCode(String dicacode) throws SQLException{
        String sql="select count(*) from disecategory where DicaCode=? and DelMark=1";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,dicacode);
        ResultSet rs=pstmt.executeQuery();
        int count=0;
        while (rs.next()){
            count=rs.getInt(1);
        }
        if(count==0){
            return false;
        }else {
            return true;
        }
    }

    /**
     * 新增疾病分类
     * @param dis
     * @throws SQLException
     */
    @Override
    public void addDiseCategory(DiseCategory dis) throws SQLException {
        String sql="insert into disecategory(DicaCode,DicaName,SequenceNO,DicaType,DelMark) values(?,?,?,?,?)";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,dis.getDicaCode());
        pstmt.setString(2,dis.getDicaName());
        pstmt.setInt(3,dis.getSequenceNo());
        pstmt.setInt(4,dis.getDicaType());
        pstmt.setInt(5,dis.getDelMark());
        pstmt.executeUpdate();
        JdbcUtil.release(null, pstmt, null);
    }

    /**
     * 编辑疾病分类
     * @param dicacode
     * @param dicaname
     * @param sequenceno
     * @param id
     * @throws SQLException
     */
    @Override
    public void updateDiseCategory(String dicacode, String dicaname, int sequenceno,int id) throws SQLException {
        String sql="update disecategory set DicaCode=?,DicaName=?,SequenceNo=? where id=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,dicacode);
        pstmt.setString(2,dicaname);
        pstmt.setInt(3,sequenceno);
        pstmt.setInt(4,id);
        pstmt.executeUpdate();
        JdbcUtil.release(null, pstmt, null);
    }

    /**
     * 删除选中疾病分类
     * @param id
     * @throws SQLException
     */
    @Override
    public void deleteDiseCategory(int id) throws SQLException {
        String sql="update disecategory set DelMark=0 where id=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setInt(1,id);
        pstmt.executeUpdate();
        JdbcUtil.release(null, pstmt, null);
    }

    //批量删除选中疾病分类
    @Override
    public void deleteMoreDiseCaregory(int id) throws SQLException {

    }

    /**
     * 通过编码和名称查询疾病
     * @param dis
     * @return
     * @throws SQLException
     */
    @Override
    public List<Disease> selectDisease(String dis) throws SQLException {

        String sql="select D1.ID,D1.DiseaseCode,D1.DiseaseName,D1.DiseaseICD,D1.DiseCategoryID,D1.DelMark,D2.DicaName,D2.ID\n" +
                "FROM Disease D1,DiseCategory D2\n" +
                "WHERE D1.DiseCategoryID = D2.ID\n" +
                "and D1.DelMark = 1\n" +
                "and (D1.DiseaseCode like \"%\"?\"%\" Or D1.DiseaseName like \"%\"?\"%\")" ;
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,dis);
        pstmt.setString(2,dis);
        ResultSet rs=pstmt.executeQuery();
        List<Disease> dises=new ArrayList<>();
        Disease dise=null;
        while (rs.next()){
            dise=new Disease();
            dise.setId(rs.getInt(1));
            dise.setDiseaseCode(rs.getString(2));
            dise.setDiseaseName(rs.getString(3));
            dise.setDiseaseICD(rs.getString(4));
            dise.setDiseCategoryID(rs.getInt(5));
            dise.setDelMark(rs.getInt(6));
            dise.setDicaName(rs.getString(7));
            dises.add(dise);
        }
        JdbcUtil.release(null,pstmt,rs);
        return dises;
    }

    /**
     * 判断疾病编码是否存在
     * @param code
     * @return
     * @throws SQLException
     */
    @Override
    public boolean selectDiseaseCode(String code) throws SQLException {
        String sql="select count(*) from disease where DiseaseCode=? and DelMark=1";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,code);
        ResultSet rs=pstmt.executeQuery();
        int count=0;
        while (rs.next()){
            count=rs.getInt(1);
        }
        if(count==0){
            return false;
        }else {
            return true;
        }
    }

    /**
     * 判断国际ICD编码是否重复
     * @param icd
     * @return
     * @throws SQLException
     */
    @Override
    public boolean selectDiseaseICD(String icd) throws SQLException {
        String sql="select count(*) from disease where DiseaseICD=? and DelMark=1";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,icd);
        ResultSet rs=pstmt.executeQuery();
        int count=0;
        while (rs.next()){
            count=rs.getInt(1);
        }
        if(count==0){
            return false;
        }else {
            return true;
        }
    }

    /**
     * 新增疾病
     * @param dis
     * @throws SQLException
     */
    @Override
    public void addDisease(Disease dis) throws SQLException {
        String sql="insert disease(DiseaseCode,DiseaseName,DiseaseICD,DiseCategoryID,DelMark) values(?,?,?,?,?)";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,dis.getDiseaseCode());
        pstmt.setString(2,dis.getDiseaseName());
        pstmt.setString(3,dis.getDiseaseICD());
        pstmt.setInt(4,dis.getDiseCategoryID());
        pstmt.setInt(5,dis.getDelMark());
        pstmt.executeUpdate();
        JdbcUtil.release(null, pstmt, null);
    }

    /**
     * 根据ID查询疾病信息
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public Disease selectDiseaseByID(int id) throws SQLException {
        String sql="SELECT D1.ID, D1.DiseaseCode, D1.DiseaseName, D1.DiseaseICD, D1.DiseCategoryID, D1.DelMark, D2.DicaName, D2.ID\n" +
                "FROM Disease D1 ,DiseCategory D2\n" +
                "WHERE D1.DiseCategoryID =  D2.ID\n" +
                "and D1.ID=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setInt(1,id);
        ResultSet rs=pstmt.executeQuery();
        Disease dise=null;
        while (rs.next()){
            dise=new Disease();
            dise.setId(rs.getInt(1));
            dise.setDiseaseCode(rs.getString(2));
            dise.setDiseaseName(rs.getString(3));
            dise.setDiseaseICD(rs.getString(4));
            dise.setDiseCategoryID(rs.getInt(5));
            dise.setDelMark(rs.getInt(6));
            dise.setDicaName(rs.getString(7));
        }
        JdbcUtil.release(null,pstmt,rs);
        return dise;
    }

    /**
     * 修改疾病信息
     * @param dis
     * @throws SQLException
     */
    @Override
    public void updateDisease(Disease dis) throws SQLException {
        String sql="update disease set DiseaseCode=?,DiseaseName=?,DiseaseICD=?,DiseCategoryID=? where id=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,dis.getDiseaseCode());
        pstmt.setString(2,dis.getDiseaseName());
        pstmt.setString(3,dis.getDiseaseICD());
        pstmt.setInt(4,dis.getDiseCategoryID());
        pstmt.setInt(5,dis.getId());
        pstmt.executeUpdate();
        JdbcUtil.release(null, pstmt, null);
    }

    /**
     * 根据ID删除选中疾病
     * @param id
     * @throws SQLException
     */
    @Override
    public void deleteDisease(int id) throws SQLException {
        String sql="update disease set DelMark=0 where id=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setInt(1,id);
        pstmt.executeUpdate();
        JdbcUtil.release(null, pstmt, null);
    }

    /**
     * 批量删除选中疾病
     * @param id
     * @throws SQLException
     */
    @Override
    public void deleteMoreDisease(int id) throws SQLException {

    }

}
