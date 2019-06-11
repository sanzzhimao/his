package dao.drugstoredao;

import util.JdbcUtil;
import vo.ConstantItem;
import vo.Drugs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 药品管理Dao层
 */
public class DrugDao implements IDrugDao {
    Connection con=null;
    @Override
    public void setConnection(Connection con) {
        this.con=con;
    }

    /**
     * 通过助记码查询药品( )
     * @param mnemonicCode
     * @return
     * @throws SQLException
     */
    @Override
    public List<Drugs> selectDrugs(String mnemonicCode) throws SQLException {
        String sql="SELECT ID,DrugsCode,DrugsName,DrugsFormat,DrugsUnit,Manufacturer,DrugsDosageID,DrugsTypeID,DrugsPrice,MnemonicCode,CreationDate,LastUpdateDate,DelMark,C1.ConstantName,C2.ConstantName\n" +
                "FROM Drugs D,ConstatntItem C1,ConstatntItem C2\n" +
                "WHERE D.DrugsDosageID = C1.ID\n" +
                "and D.DrugsTypeID = C2.ID\n" +
                "MnemonicCode like \"%\"?\"%\" \n" +
                "and DelMark = 1";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,mnemonicCode);
        ResultSet rs=pstmt.executeQuery();
        List<Drugs> list=new ArrayList<>();
        Drugs drugs=null;
        while (rs.next()){
            drugs=new Drugs();
            drugs.setId(rs.getInt(1));
            drugs.setDrugCode(rs.getString(2));
            drugs.setDrugName(rs.getString(3));
            drugs.setDrugsFormat(rs.getString(4));
            drugs.setDrugsUnit(rs.getString(5));
            drugs.setMaufacturer(rs.getString(6));
            drugs.setDrugsDosageID(rs.getInt(7));
            drugs.setDrugsTpyeID(rs.getInt(8));
            drugs.setDrugsPrice(rs.getDouble(9));
            drugs.setMnemonicCode(rs.getString(10));
            drugs.setCreationDate(rs.getDate(11));
            drugs.setLastUpdateDate(rs.getDate(12));
            drugs.setDelMark(rs.getInt(13));
            drugs.setDrugsDosageName(rs.getString(14));
            drugs.setDrugsTypeName(rs.getString(15));
            list.add(drugs);
        }
        JdbcUtil.release(null,pstmt,rs);
        return list;
    }

    /**
     * 读取有效药品剂型
     * @return
     * @throws SQLException
     */
    @Override
    public List<ConstantItem> selectDrugsDosage() throws SQLException {
        String sql="select C2.ID,C2.ContantCode,C2.ConstantName \n" +
                "from ConstantType C1,ConstantItem C2\n" +
                "where C2.ConstantTypeID=C1.ID\n" +
                "and ConstantTypeCode ='Drugs_Dosage' \n" +
                "and C2.DelMark=1";
        PreparedStatement pstmt=con.prepareStatement(sql);
        ResultSet rs=pstmt.executeQuery();
        List<ConstantItem> list=new ArrayList<>();
        ConstantItem cons=null;
        while (rs.next()){
            cons=new ConstantItem();
            cons.setId(rs.getInt(1));
            cons.setContantCode(rs.getString(2));
            cons.setConstantName(rs.getString(3));
            list.add(cons);
        }
        JdbcUtil.release(null,pstmt,rs);
        return list;
    }

    /**
     * 读取有效药品类型
     * @return
     * @throws SQLException
     */
    @Override
    public List<ConstantItem> selectDrugsType() throws SQLException {
        String sql="select C2.ID,C2.ContantCode,C2.ConstantName \n" +
                "from ConstantType C1,ConstantItem C2\n" +
                "where C2.ConstantTypeID=C1.ID\n" +
                "and ConstantTypeCode ='Drugs_Type' \n" +
                "and C2.DelMark=1";
        PreparedStatement pstmt=con.prepareStatement(sql);
        ResultSet rs=pstmt.executeQuery();
        List<ConstantItem> list=new ArrayList<>();
        ConstantItem cons=null;
        while (rs.next()){
            cons=new ConstantItem();
            cons.setId(rs.getInt(1));
            cons.setContantCode(rs.getString(2));
            cons.setConstantName(rs.getString(3));
            list.add(cons);
        }
        JdbcUtil.release(null,pstmt,rs);
        return list;
    }

    /**
     * 根据ID查询当前药品信息
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public Drugs selectDrug(int id) throws SQLException {
        String sql="SELECT ID,DrugsCode,DrugsName,DrugsFormat,DrugsUnit,Manufacturer,DrugsDosageID,DrugsTypeID,DrugsPrice,MnemonicCode,CreationDate,LastUpdateDate,DelMark,C1.ConstantName,C2.ConstantName\n" +
                "FROM Drugs D,ConstatntItem C1,ConstatntItem C2\n" +
                "WHERE D.DrugsDosageID = C1.ID\n" +
                "and D.DrugsTypeID = C2.ID\n" +
                "and ID=?\n" +
                "and DelMark = 1";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setInt(1,id);
        ResultSet rs=pstmt.executeQuery();
        Drugs drugs=null;
        while (rs.next()){
            drugs=new Drugs();
            drugs.setId(rs.getInt(1));
            drugs.setDrugCode(rs.getString(2));
            drugs.setDrugName(rs.getString(3));
            drugs.setDrugsFormat(rs.getString(4));
            drugs.setDrugsUnit(rs.getString(5));
            drugs.setMaufacturer(rs.getString(6));
            drugs.setDrugsDosageID(rs.getInt(7));
            drugs.setDrugsTpyeID(rs.getInt(8));
            drugs.setDrugsPrice(rs.getDouble(9));
            drugs.setMnemonicCode(rs.getString(10));
            drugs.setCreationDate(rs.getDate(11));
            drugs.setLastUpdateDate(rs.getDate(12));
            drugs.setDelMark(rs.getInt(13));
            drugs.setDrugsDosageName(rs.getString(14));
            drugs.setDrugsTypeName(rs.getString(15));
        }
        JdbcUtil.release(null,pstmt,rs);
        return drugs;
    }

    /**
     * 判断编码是否重复
     * @param code
     * @return
     * @throws SQLException
     */
    @Override
    public boolean selectDrugsCode(String code) throws SQLException {
        String sql="SELECT count(id) \n" +
                "FROM Drugs\n" +
                "where DrugsCode = ?\n" +
                "and DelMark = 1";
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
     * 新增药品
     * @param drug
     * @throws SQLException
     */
    @Override
    public void addDrugs(Drugs drug) throws SQLException {
        String sql="insert drugs(DrugsCode,DrugsName,DrugsFormat,DrugsUnit,DrugsDosageID,DrugsTypeID,DrugsPrice,MnemonicCode,CreationDate,DelMark) values(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,drug.getDrugCode());
        pstmt.setString(2,drug.getDrugName());
        pstmt.setString(3,drug.getDrugsFormat());
        pstmt.setString(4,drug.getDrugsUnit());
        pstmt.setInt(5,drug.getDrugsDosageID());
        pstmt.setInt(6,drug.getDrugsTpyeID());
        pstmt.setDouble(7,drug.getDrugsPrice());
        pstmt.setString(8,drug.getMnemonicCode());
        java.sql.Date creationDate=new java.sql.Date(drug.getCreationDate().getTime());
        pstmt.setDate(9,creationDate);
        pstmt.setInt(10,1);
        pstmt.executeUpdate();
        JdbcUtil.release(null, pstmt, null);
    }

    /**
     * 修改药品信息
     * @param drug
     * @throws SQLException
     */
    @Override
    public void updateDrugs(Drugs drug) throws SQLException {
        String sql="update drugs set DrugsCode=?,DrugsName=?,DrugsFormat=?,DrugsUnit=?,DrugsDosageID=?,DrugsTypeID=?,DrugsPrice=?,MnemonicCode=?,LastUpdateDate=? where ID=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,drug.getDrugCode());
        pstmt.setString(2,drug.getDrugName());
        pstmt.setString(3,drug.getDrugsFormat());
        pstmt.setString(4,drug.getDrugsUnit());
        pstmt.setInt(5,drug.getDrugsDosageID());
        pstmt.setInt(6,drug.getDrugsTpyeID());
        pstmt.setDouble(7,drug.getDrugsPrice());
        pstmt.setString(8,drug.getMnemonicCode());
        java.sql.Date lastUpdateDate=new java.sql.Date(drug.getLastUpdateDate().getTime());
        pstmt.setDate(9,lastUpdateDate);
        pstmt.setInt(10,drug.getId());
        pstmt.executeUpdate();
        JdbcUtil.release(null, pstmt, null);
    }

    /**
     *删除药品
     * @param id
     * @throws SQLException
     */
    @Override
    public void deleteDrugs(int id) throws SQLException {
        String sql="update drugs set DelMark=0 where ID=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setInt(1,id);
        pstmt.executeUpdate();
        JdbcUtil.release(null, pstmt, null);
    }
}
