package dao;

import util.JdbcUtil;
import vo.CheckInfo;

import javax.servlet.http.Part;
import java.lang.reflect.ParameterizedType;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class PatientTest implements IPatientTest{
    Connection con=null;
    @Override
    public void setCon(Connection con) {
        this.con = con;
    }

    /**
     * @Author lym
     * @Description:通过名字查询患者的信息（病历号，名字，挂号id，发票号）
     * @Param [name]
     * @return java.util.List<vo.CheckInfo>
     **/
    @Override
    public CheckInfo selectCheckInfoByName(String name) throws SQLException {
        String sql="select r.id,r.casenumber,r.realname,i.invoicenum from register r,invoice i" +
                " where r.id=i.registid and r.realname=? and i.state=4";
        PreparedStatement psmt=con.prepareStatement(sql);
        psmt.setString(1,name);
        ResultSet rs=psmt.executeQuery();
        CheckInfo checkInfo=null;
        while (rs.next()){
            checkInfo=new CheckInfo();
            checkInfo.setId(rs.getInt(1));
            checkInfo.setRegisteNum(rs.getString(2));
            checkInfo.setName(rs.getString(3));
            checkInfo.setInvoiceNUm(rs.getString(4));
            checkInfo.setRecordType(1);
        }
        JdbcUtil.release(null,psmt,rs);
        return checkInfo;
    }
}
