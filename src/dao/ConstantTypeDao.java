/*
常数类别实现
何金华
 */
package dao;

import util.JdbcUtil;
import vo.ConstantItem;
import vo.ConstantType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConstantTypeDao implements IConstantTypeDao {
    Connection con=null;
    @Override
    public void setConnection(Connection con) {
        this.con=con;
    }
//查询所有常数类别
    @Override
    public ArrayList<ConstantType> selectAllConstantType() throws SQLException {
        String sql="select * from constanttype where delmark=1";
        PreparedStatement pstmt=con.prepareStatement(sql);
        ResultSet rs=pstmt.executeQuery();
        ArrayList<ConstantType> alct=new ArrayList<>();
        ConstantType constantType=null;
        while(rs.next()){
            constantType=new ConstantType();
            constantType.setId(rs.getInt(1));
            constantType.setConstantTypeCode(rs.getString(2));
            constantType.setConstantTypeName(rs.getString(3));
            constantType.setDelMark(rs.getInt(4));
            alct.add(constantType);
        }
        JdbcUtil.release(null,pstmt,rs);
        return alct;
    }
//增加常数类别
    @Override
    public void addConstantType(ConstantType constantType)  throws SQLException {
        String sql="insert into constanttype(ConstantTypeCode,ConstantTypeName,DelMark) value(?,?,?)";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,constantType.getConstantTypeCode());
        pstmt.setString(2,constantType.getConstantTypeName());
        pstmt.setInt(3,1);
        pstmt.executeUpdate();
        JdbcUtil.release(null,pstmt,null);

    }
//查询常数类别
    @Override
    public ConstantType selectConstantType(String string) throws SQLException {
        String sql="select * from constanttype where (constanttypecode=? or constanttypename=?) and delmark=1";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,string);
        pstmt.setString(2,string);
        ResultSet rs=pstmt.executeQuery();
        ConstantType constantType=null;
        while(rs.next()){
            constantType=new ConstantType();
            constantType.setId(rs.getInt(1));
            constantType.setConstantTypeCode(rs.getString(2));
            constantType.setConstantTypeName(rs.getString(3));
            constantType.setDelMark(rs.getInt(4));
        }
        JdbcUtil.release(null,pstmt,rs);
        return constantType;
    }

    //查询所有常数项
    @Override
    public ArrayList<ConstantItem> selectAllConstantItem(String string) throws SQLException {
        String sql="select a.* from constantitem a,constanttype b where a.constanttypeid=b.id and b.constanttypename=? and delmark=1";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,string);
        ResultSet rs=pstmt.executeQuery();
        ArrayList<ConstantItem> alci=new ArrayList<>();
        ConstantItem constantItem=null;
        while (rs.next()){
            constantItem=new ConstantItem();
            constantItem.setId(rs.getInt(1));
            constantItem.setConstantTypeID(rs.getInt(2));
            constantItem.setContantCode(rs.getString(3));
            constantItem.setConstantName(rs.getString(4));
            constantItem.setDelMark(rs.getInt(5));
            alci.add(constantItem);
        }
        JdbcUtil.release(null,pstmt,rs);
        return alci;
    }

    @Override
    public ArrayList<ConstantItem> selectConstantItem(String string) throws SQLException {
        String sql="select * from constantitem where (ConstantCode=? or ConstantName=?) and delmark=1";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,string);
        pstmt.setString(2,string);
        ResultSet rs=pstmt.executeQuery();
        ConstantItem constantItem=null;
        ArrayList<ConstantItem> alci=new ArrayList<>();
        while (rs.next()){
            constantItem=new ConstantItem();
            constantItem.setId(rs.getInt(1));
            constantItem.setConstantTypeID(rs.getInt(2));
            constantItem.setContantCode(rs.getString(3));
            constantItem.setConstantName(rs.getString(4));
            constantItem.setDelMark(rs.getInt(5));
            alci.add(constantItem);
        }
        JdbcUtil.release(null,pstmt,rs);
        return alci;
    }

    //增加常数项
    @Override
    public void addConstantItem(ConstantItem constantItem) throws SQLException {
        String sql="insert into constantitem(constanttypeid,constantcode,constantname,delmark) value(?,?,?,?)";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setInt(1,constantItem.getConstantTypeID());
        pstmt.setString(2,constantItem.getContantCode());
        pstmt.setString(3,constantItem.getConstantName());
        pstmt.setInt(4,1);
        pstmt.executeUpdate();
        JdbcUtil.release(null,pstmt,null);
    }
//修改常数项
    @Override
    public void modifyConstantItem(ConstantItem constantItem) throws SQLException {
        String sql="update constantitem set constantcode=?,constantname=?,constanttypeid=? where id=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,constantItem.getContantCode());
        pstmt.setString(2,constantItem.getConstantName());
        pstmt.setInt(3,constantItem.getConstantTypeID());
        pstmt.setInt(4,constantItem.getId());
        pstmt.executeUpdate();
        JdbcUtil.release(null,pstmt,null);
    }
//删除常数项
    @Override
    public void delectConstantItem(ConstantItem constantItem) throws SQLException {
        String sql="update constantitem set delmark=? where id=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setInt(1,0);
        pstmt.setInt(2,constantItem.getId());
        JdbcUtil.release(null,pstmt,null);
    }
//批量删除常数项
    @Override
    public void delectDuoConstantItem() {

    }
}
