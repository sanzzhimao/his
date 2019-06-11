package dao.fmeditemdao;

import vo.PatientInfo;
import vo.Register;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CostsDao implements ICostsDao{
    Connection con=null;

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    @Override
    public List<PatientInfo> selectPatientInfoByCaseNumber(String caseNumber) throws SQLException {
        String sql="select r.id,r.casenumber,r.realname,r.idNumber,\n" +
                "                r.homeaddress,p.ItemName,p.price,c.Num,p.CreationDate\n" +
                "                from  register r,fmeditem p,checkapply c \n" +
                "                where r.casenumber=?\n" +
                "                and c.registid=r.id \n" +
                "                and c.itemid=p.id  \n" +
                "                and c.state=3";
        PreparedStatement psmt=con.prepareStatement(sql);
        psmt.setString(1,caseNumber);
        ResultSet rs=psmt.executeQuery();
        List<PatientInfo> list=new LinkedList<>();
        PatientInfo pi=null;
        while (rs.next()){
            pi = new PatientInfo();
            pi.setId(rs.getInt(1));
            pi.setCaseNumber(rs.getString(2));
            pi.setRealName(rs.getString(3));
            pi.setIdentityNumber(rs.getString(4));
            pi.setHomeAddress(rs.getString(5));
            pi.setItemNmae(rs.getString(6));
            pi.setItemPrice(rs.getDouble(7));
            pi.setNumber(rs.getInt(8));
            pi.setOpenDate(rs.getDate(9));
            pi.setOpenState(3);
            list.add(pi);
        }
        return list;
    }
}
