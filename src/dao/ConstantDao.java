package dao;

import util.JdbcUtil;
import vo.ConstantType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConstantDao implements IConstantDao{
    Connection con=null;
    public void setConnection(Connection con) {
        this.con=con;
    }

    @Override
    public void addConstantType(ConstantType constatnt) throws SQLException {
        String sql="insert into constanttype values(?,?,?,)";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,constatnt.getConstantTypeCode());
        pstmt.setString(2,constatnt.getConstantTypeName());
        pstmt.setInt(3,constatnt.getId());
        pstmt.executeUpdate();
        JdbcUtil.release(null,pstmt,null);
    }

    @Override
    public ConstantType selcetConstantType(String ConstantTypeCode, String ConstantTypeName) throws SQLException {
        String sql="select * from constanttype where ConstantTypeCode=? or ConstantTypeName=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,ConstantTypeCode);
        pstmt.setString(2,ConstantTypeName);
        ResultSet rs=pstmt.executeQuery();
        ConstantType cot=null;
        while (rs.next()){
            cot=new ConstantType();
            cot.setId(rs.getInt(1));
            cot.setConstantTypeCode(rs.getString(2));
            cot.setConstantTypeName(rs.getString(3));
            cot.setId(rs.getInt(4));
        }
        JdbcUtil.release(null,pstmt,null);
        return cot;
    }
}