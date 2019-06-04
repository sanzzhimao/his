/*
药房发药实现类
何金华
 */
package dao;

import util.JdbcUtil;
import vo.SendMedical;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SendMedicalDao implements ISendMedicalDao {
    Connection con=null;
    public void setConnection(Connection con) {
        this.con=con;
    }
    public List<SendMedical> sendMedical(String st) throws SQLException {
        String sql="select distinct d.DrugsName,d.DrugsPrice,pd.Amount,d.DelMark,u.RealName,p.PrescriptionName,p.PrescriptionTime pd.id " +
                "from drugs d,prescriptiondetailed pd,user u,prescription p,MedicalRecord m " +
                "where m.ID=p.MedicalID " +
                "and p.UserID=u.ID " +
                "and pd.DrugsID=d.ID " +
                "and pd.PrescriptionID=p.id " +
                "and pd.state=3 " +
                "and m.CaseNumber=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,st);
        ResultSet rs=pstmt.executeQuery();
        List<SendMedical> list=new ArrayList<>();
        SendMedical sm=null;
        while(rs.next()){
            sm=new SendMedical();
            sm.setDrugsName(rs.getString(1));
            sm.setDrugsPrice(rs.getDouble(2));
            sm.setAmount(rs.getDouble(3));
            sm.setDelmark(rs.getInt(4));
            sm.setRealName(rs.getString(5));
            sm.setPrescriptionName(rs.getString(6));
            sm.setDate(rs.getDate(7));
            sm.setId(rs.getInt(8));//给复选框赋值
            list.add(sm);
        }
        JdbcUtil.release(null,pstmt,rs);
        return list;
    }

    @Override
    public void modifyStatus(int id) throws SQLException {
        String sql="update PrescriptionDetailed set state=4 where id=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setInt(1,id);
        pstmt.executeUpdate();
        JdbcUtil.release(null,pstmt,null);
    }

}
