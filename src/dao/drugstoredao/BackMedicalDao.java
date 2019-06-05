/*
药房退药实现
何金华
 */
package dao.drugstoredao;

import util.JdbcUtil;
import vo.SendMedical;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BackMedicalDao implements IBackMedicalDao{
    Connection con=null;
    @Override
    public void setConnection(Connection con) {
        this.con=con;
    }
//根据病历号查询药品名字，单价，数量，药品状态，开立医生，处方名字，开立时间   处方明细状态为4-已开药
    @Override
    public List<SendMedical> backMedical(String st,String date) throws SQLException, ParseException {
        String sql="select distinct d.DrugsName,d.DrugsPrice,pd.Amount,d.DelMark,u.RealName,p.PrescriptionName,p.PrescriptionTime,pd.id " +
                "from drugs d,prescriptiondetailed pd,user u,prescription p,MedicalRecord m " +
                "where m.ID=p.MedicalID " +
                "and p.UserID=u.ID " +
                "and pd.DrugsID=d.ID " +
                "and pd.PrescriptionID=p.id " +
                "and pd.state=4 " +
                "and m.CaseNumber=? and p.PrescriptionTime=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1=simpleDateFormat.parse(date);
        java.sql.Date date2=new java.sql.Date(date1.getTime());//date2转换缺失时分秒，查不出
        pstmt.setString(1,st);
        pstmt.setDate(2,date2);
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
//获取复选框值给id   通过id改变处方明细表状态为未发药
    @Override
    public void modifyStatus(int id) throws SQLException {
        String sql="update PrescriptionDetailed set state=3 where id=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setInt(1,id);
        pstmt.executeUpdate();
        JdbcUtil.release(null,pstmt,null);

    }
}
