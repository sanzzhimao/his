package dao.informationdao;

import util.JdbcUtil;
import vo.Department;
import vo.ExpenseClass;
import vo.NoDrug;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NoDrugDao implements INoDrugDao {
    Connection con=null;
    @Override
    public void setConnection(Connection con) {
        this.con=con;
    }

    @Override
    public List<NoDrug> selectNoDrug(String item) throws SQLException {
        String sql="SELECT F.ID,F.ItemCode,F.ItemName,F.Format,F.Price,F.ExpClassID,F.DeptID,F.MnemonicCode,F.CreationDate,F.LastUpdateDate,F.RecordType,F.DelMark,E.ExpName,D.DeptName\n" +
                "FROm Fmeditem F,ExpenseClass E,Department D\n" +
                "where F.ExpClassID = E.ID\n" +
                "and F.DeptID = D.ID\n" +
                "and F.DelMark=1\n" +
                "and (F.ItemCode like \"%\"?\"%\" or F.ItemName like \"%\"?\"%\")";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,item);
        pstmt.setString(2,item);
        ResultSet rs=pstmt.executeQuery();
        List<NoDrug> nodrugs=new ArrayList<>();
        NoDrug nodrug=null;
        while (rs.next()){
            nodrug=new NoDrug();
            nodrug.setId(rs.getInt(1));
            nodrug.setItemCode(rs.getString(2));
            nodrug.setItemName(rs.getString(3));
            nodrug.setFormat(rs.getString(4));
            nodrug.setPrice(rs.getDouble(5));
            nodrug.setExpClassID(rs.getInt(6));
            nodrug.setDeptID(rs.getInt(7));
            nodrug.setMnemonicCode(rs.getString(8));
            nodrug.setCreationDate(rs.getDate(9));
            nodrug.setLastUpdateDate(rs.getDate(10));
            nodrug.setRecordType(rs.getInt(11));
            nodrug.setDelMark(rs.getInt(12));
            nodrug.setExpName(rs.getString(13));
            nodrug.setDeptName(rs.getString(14));
            nodrugs.add(nodrug);
        }
        JdbcUtil.release(null,pstmt,rs);
        return nodrugs;
    }

    @Override
    public NoDrug selectNoDrugByID(int id) throws SQLException {
        String sql="SELECT F.ID,F.ItemCode,F.ItemName,F.Format,F.Price,F.ExpClassID,F.DeptID,F.MnemonicCode,F.CreationDate,F.LastUpdateDate,F.RecordType,F.DelMark,E.ExpName,D.DeptName\n" +
                "FROm Fmeditem F,ExpenseClass E,Department D\n" +
                "where F.ExpClassID = E.ID\n" +
                "and F.DeptID = D.ID\n" +
                "and F.DelMark=1\n" +
                "and F.ID=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setInt(1,id);
        ResultSet rs=pstmt.executeQuery();
        NoDrug nodrug=null;
        while (rs.next()){
            nodrug=new NoDrug();
            nodrug.setId(rs.getInt(1));
            nodrug.setItemCode(rs.getString(2));
            nodrug.setItemName(rs.getString(3));
            nodrug.setFormat(rs.getString(4));
            nodrug.setPrice(rs.getDouble(5));
            nodrug.setExpClassID(rs.getInt(6));
            nodrug.setDeptID(rs.getInt(7));
            nodrug.setMnemonicCode(rs.getString(8));
            nodrug.setCreationDate(rs.getDate(9));
            nodrug.setLastUpdateDate(rs.getDate(10));
            nodrug.setRecordType(rs.getInt(11));
            nodrug.setDelMark(rs.getInt(12));
            nodrug.setExpName(rs.getString(13));
            nodrug.setDeptName(rs.getString(14));
        }
        JdbcUtil.release(null,pstmt,rs);
        return nodrug;
    }

    @Override
    public List<ExpenseClass> selectExpenseClass() throws SQLException {
        String sql="SELECT ID,ExpCode,ExpName,DelMark \n" +
                "FROM ExpenseClass\n" +
                "WHERE DelMark = 1";
        PreparedStatement pstmt=con.prepareStatement(sql);
        ResultSet rs=pstmt.executeQuery();
        List<ExpenseClass> exps=new ArrayList<>();
        ExpenseClass exp=null;
        while(rs.next()){
            exp=new ExpenseClass();
            exp.setId(rs.getInt(1));
            exp.setExpCode(rs.getString(2));
            exp.setExpName(rs.getString(3));
            exp.setId(rs.getInt(4));
            exps.add(exp);
        }
        JdbcUtil.release(null,pstmt,rs);
        return exps;
    }

    @Override
    public List<Department> selectDepartment() throws SQLException {
        String sql="SELECT ID,DeptCode,DeptName,DeptCategoryID,DeptType,DelMark\n" +
                "FROM Department \n" +
                "WHERE DeptType = 2\n" +
                "and DelMark = 1";
        PreparedStatement pstmt=con.prepareStatement(sql);
        ResultSet rs=pstmt.executeQuery();
        List<Department> deps=new ArrayList<>();
        Department dep=null;
        while(rs.next()){
            dep=new Department();
            dep.setId(rs.getInt(1));
            dep.setDeptCode(rs.getString(2));
            dep.setDeptName(rs.getString(3));
            dep.setDeptCategoryID(rs.getInt(4));
            dep.setDeptType(rs.getInt(5));
            dep.setDelMark(rs.getInt(6));
            deps.add(dep);
        }
        JdbcUtil.release(null,pstmt,rs);
        return deps;
    }

    @Override
    public boolean selectItemCode(String itemcode) throws SQLException {
        String sql="SELECT count(id) \n" +
                "FROM Fmeditem\n" +
                "where ItemCode = ?\n" +
                "and DelMark = 1";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,itemcode);
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

    @Override
    public void addNoDrug(NoDrug nodrug) throws SQLException {
        String sql="insert Fmeditem(ItemCode,ItemName,Format,Price,ExpClassID,DeptID,MnemonicCode,CreationDate,LastUpdateDate,RecordType,DelMark) values(?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,nodrug.getItemCode());
        pstmt.setString(2,nodrug.getItemName());
        pstmt.setString(3,nodrug.getFormat());
        pstmt.setDouble(4,nodrug.getPrice());
        pstmt.setInt(5,nodrug.getExpClassID());
        pstmt.setInt(6,nodrug.getDeptID());
        pstmt.setString(7,nodrug.getMnemonicCode());
        pstmt.setDate(8,nodrug.getCreationDate());
        pstmt.setDate(9,nodrug.getLastUpdateDate());
        pstmt.setInt(10,nodrug.getRecordType());
        pstmt.setInt(11,nodrug.getDelMark());
        pstmt.executeUpdate();
        JdbcUtil.release(null, pstmt, null);
    }

    @Override
    public void updateNoDrug(NoDrug nodrug) throws SQLException {
        String sql="update fmeditem set ItemCode=?,ItemName=?,Format=?,Price=?,ExpClassID=?,DeptID=?,MnemonicCode=?,LastUpdateDate=?,RecordType=? where id=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,nodrug.getItemCode());
        pstmt.setString(2,nodrug.getItemName());
        pstmt.setString(3,nodrug.getFormat());
        pstmt.setDouble(4,nodrug.getPrice());
        pstmt.setInt(5,nodrug.getExpClassID());
        pstmt.setInt(6,nodrug.getDeptID());
        pstmt.setString(7,nodrug.getMnemonicCode());
        pstmt.setDate(8,nodrug.getLastUpdateDate());
        pstmt.setInt(9,nodrug.getRecordType());
        pstmt.setInt(10,nodrug.getId());
        pstmt.executeUpdate();
        JdbcUtil.release(null, pstmt, null);
    }

    @Override
    public void deleteNoDrug(int id) throws SQLException {
        String sql="update fmeditem set DelMark=0 where id=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setInt(1,id);
        pstmt.executeUpdate();
        JdbcUtil.release(null, pstmt, null);
    }

}
