package dao;

import com.sun.org.apache.regexp.internal.RESyntaxException;
import util.JdbcUtil;
import vo.CheckApply;
import vo.CheckInfo;
import vo.MedicalTecTest;
import vo.Register;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class PatientTestDao implements IPatientTestDao {
    Connection con=null;
    @Override
    public void setCon(Connection con) {
        this.con = con;
    }

    /**
     * @Author lym
     * @Description:通过名字查询患者的信息（病历号，名字，挂号id，发票号）由于会查到多张发票号所以采用一个list存储
     * @Param [name]
     * @return java.util.List<vo.CheckInfo>
     **/
    @Override
    public List<CheckInfo> selectCheckInfoByName(String name) throws SQLException {
        String sql="select r.id,r.casenumber,r.realname,i.invoicenum from register r,invoice i,medicalrecord m" +
                " where r.id=i.registid and r.id=m.registid and r.realname=?  and i.state=3";
        PreparedStatement psmt=con.prepareStatement(sql);
        psmt.setString(1,name);
        ResultSet rs=psmt.executeQuery();
        List<CheckInfo> list=new LinkedList();
        CheckInfo checkInfo=null;
        while (rs.next()){
            checkInfo=new CheckInfo();
            checkInfo.setId(rs.getInt(1));
            checkInfo.setRegisteNum(rs.getString(2));
            checkInfo.setName(rs.getString(3));
            checkInfo.setInvoiceNUm(rs.getString(4));
            checkInfo.setRecordType(1);
            list.add(checkInfo);
        }
        JdbcUtil.release(null,psmt,rs);
        return list;
    }
    /**
     * @Author lym
     * @DescriptionL:通过名字查询患者的一些信息--
     * @Param [name]
     * @return java.util.List<vo.CheckInfo>
    **/
    public List<CheckInfo> selectCheckInfoByNameZhong(String name) throws SQLException {
        String sql="select DISTINCT r.id,r.casenumber,r.realname,r.age,s.SettleName,d.deptname,c.state,i.creationtime,u.realname docname,p.PayTime,i.InvoiceNum,c.recordtype\n" +
                "from register r,invoice i,medicalrecord m,SettleCategory s,Department d,checkapply c,user u,PatientCosts p\n" +
                "where r.id=i.registid \n" +
                "and r.id=m.registid \n" +
                "and s.id=r.SettleID \n" +
                "and p.deptid=d.id \n" +
                "and c.RegistID=r.id \n" +
                "and u.id=r.userid\n" +
                "and r.realname=? \n" +
                "and p.registid=\n" +
                "(select id from register r where r.realname=?)\n" +
                "and p.ItemType=1\n" +
                "and c.recordtype=1\n" +
                "AND p.InvoiceID=i.ID\n" +
                "and i.state=3";
        PreparedStatement psmt=con.prepareStatement(sql);
        psmt.setString(1,name);
        psmt.setString(2,name);
        ResultSet rs=psmt.executeQuery();
        List<CheckInfo> list=new LinkedList();
        CheckInfo checkInfo=null;
        while (rs.next()){
            checkInfo=new CheckInfo();
            checkInfo.setId(rs.getInt(1));
            checkInfo.setRegisteNum(rs.getString(2));
            checkInfo.setName(rs.getString(3));
            checkInfo.setAge(rs.getInt(4));
            checkInfo.setSettleName(rs.getString(5));
            checkInfo.setDepartment(rs.getString(6));
            checkInfo.setPrescriptionState(rs.getInt(7));
            checkInfo.setCreatonTime(rs.getTime(8));
            checkInfo.setDoc(rs.getString(9));
            checkInfo.setInvoiceNUm(rs.getString(10));
            checkInfo.setRecordType(11);
            list.add(checkInfo);
        }
        JdbcUtil.release(null,psmt,rs);
        return list;
    }
    /**
     * @Author lym
     * @Description:通过名字查询患者挂号信息
     * @Param [name]
     * @return java.util.List<vo.Register>
     **/
    @Override
    public Register selectRegistrByname(String name) throws SQLException {
        String sql="select distinct r.* from register r,invoice i,medicalrecord m" +
                " where r.id=i.registid and m.registid=r.id and  r.realname=? and i.state=3";
        PreparedStatement psmt=con.prepareStatement(sql);
        psmt.setString(1,name);
        ResultSet rs=psmt.executeQuery();
        List<Register> list=new LinkedList<>();
        Register register=null;
        while (rs.next()){
            register=new Register();
            register.setId(rs.getInt(1));
            register.setCaseNumber(rs.getString(2));
            register.setRealName(rs.getString(3));
            register.setGender(rs.getInt(4));
            register.setIdNumber(rs.getString(5));
            register.setBirthDate(rs.getDate(6));
            register.setAge(rs.getInt(7));
            register.setAgeTpye(rs.getString(8));
            register.setHomeAddress(rs.getString(9));
            register.setVisitDate(rs.getDate(10));
            register.setNoon(rs.getString(11));
            register.setDeptID(rs.getInt(12));
            register.setUserID(rs.getInt(13));
            register.setRegistLeID(rs.getInt(14));
            register.setSettLeID(rs.getInt(15));
            register.setIsBook(rs.getString(16));
            register.setRegistTime(rs.getTime(17));
            register.setRegisterID(rs.getInt(18));
            register.setVisitState(rs.getInt(19));
            register.setDeptName(rs.getString(20));

        }
        JdbcUtil.release(con,psmt,rs);
        return register;
    }
    /**
     * @Author lym
     * @Description：通过id找到结算类别
     * @Param [settleID]
     * @return java.lang.String
    **/
    @Override
    public String selectsettleName(int settleID) throws SQLException {
        String sql="select settlename from settlecategory where id=?";
        PreparedStatement psmt=con.prepareStatement(sql);
        psmt.setInt(1,settleID);
        ResultSet rs=psmt.executeQuery();
        String settleName=null;
        while (rs.next()){
            settleName=rs.getString(1);
        }
        JdbcUtil.release(null,psmt,rs);
        return settleName;
    }
    /**
     * @Author lym
     * @Description:通过医生的id找到医生的名字
     * @Param [docID]
     * @return java.lang.String
     **/
    @Override
    public String selectDocName(int docID) throws SQLException {
        String sql="select realname from  user where id=?";
        PreparedStatement pmst=con.prepareStatement(sql);
        String realName=null;
        pmst.setInt(1,docID);
        ResultSet rs=pmst.executeQuery();
        while (rs.next()){
            realName=rs.getString(1);
        }
        JdbcUtil.release(null,pmst,rs);
        return realName;
    }

    /**
     * @Author lym
     * @Description:通过名字找到对应的发票号
     * @Param [name]
     * @return java.util.List<java.lang.String>
     **/
    @Override
    public List<String> selectIvoiceNumberByname(String name) throws SQLException {
        String sql="select i.invoicenum from register r,invoice i,medicalrecord m" +
                " where r.id=i.registid and m.registid=r.id and r.realname=? and i.state=3";
        PreparedStatement psmt=con.prepareStatement(sql);
        psmt.setString(1,name);
        ResultSet rs=psmt.executeQuery();
        List<String> list=new LinkedList<>();
        String InvoiceNumbers=null;
        while (rs.next()){
            InvoiceNumbers=rs.getString(1);
            list.add(InvoiceNumbers);
        }
        JdbcUtil.release(null,psmt,rs);
        return list;
    }
        /**
         * @Author lym
         * @Description:通过registid找到检验的申请
         * @Param [registID](相当于casenumber)
         * @return vo.MedicalTecTest
        **/
    @Override
    public List<MedicalTecTest> selectCheckAppley(String registID) throws SQLException {
        String sql="select  c.id,f.itemname,c.position,c.num,f.format,f.price,c.state from checkapply c,fmeditem f where c.registid=" +
                "select id from register where casenumber=?" +
                "and c.recordtype=2 and c.itemid=f.id";
        PreparedStatement psmt=con.prepareStatement(sql);
        psmt.setString(1,registID);
        ResultSet rs=psmt.executeQuery();
        List list=new LinkedList();
        MedicalTecTest medicalTecTest=null;
        while (rs.next()){
            medicalTecTest=new MedicalTecTest();
            medicalTecTest.setId(rs.getInt(1));
            medicalTecTest.setMeTecTestName(rs.getString(2));
            medicalTecTest.setMeTectestPosition(rs.getString(3));
            medicalTecTest.setNum(rs.getInt(4));
            medicalTecTest.setFormat(rs.getString(5));
            medicalTecTest.setPrice(rs.getDouble(6));
            medicalTecTest.setTotalPrice(rs.getInt(4)*rs.getDouble(6));
            medicalTecTest.setState(rs.getInt(7));
            list.add(medicalTecTest);
        }
        JdbcUtil.release(null,psmt,rs);
        return list;
    }
    /**
     * @Author lym
     * @Description：用过检查/检验表的id找到检查的
     * @Param [id]
     * @return vo.MedicalTecTest
    **/
    @Override
    public MedicalTecTest selectCheckAppley(int id) throws SQLException {
        String sql="select  c.id,f.itemname,c.position,c.num,f.format,f.price,c.state from checkapply c,fmeditem f where c.id=? and c.recordtype=2 and c.itemid=f.id";
        PreparedStatement psmt=con.prepareStatement(sql);
        psmt.setInt(1,id);
        ResultSet rs=psmt.executeQuery();
        MedicalTecTest medicalTecTest=null;
        while (rs.next()){
            medicalTecTest=new MedicalTecTest();
            medicalTecTest.setId(rs.getInt(1));
            medicalTecTest.setMeTecTestName(rs.getString(2));
            medicalTecTest.setMeTectestPosition(rs.getString(3));
            medicalTecTest.setNum(rs.getInt(4));
            medicalTecTest.setFormat(rs.getString(5));
            medicalTecTest.setPrice(rs.getDouble(6));
            medicalTecTest.setTotalPrice(rs.getInt(4)*rs.getDouble(6));
            medicalTecTest.setState(rs.getInt(7));
        }
        return medicalTecTest;
    }

    /**
     * @Author lym
     * @Description：执行检验后改变状态
     * @Param [registid]病历号(casenumber)
     * @return void
    **/
    @Override
    public void changeCheckApplyStateByRegistid(String registid) throws SQLException {
        String sql="update CheckApply set state=5 where registid=" +
                "(select id from register where  casenumber=?) " +
                "and recordtype=2";
        PreparedStatement psmt=con.prepareStatement(sql);
        psmt.setString(1,registid);
        psmt.executeUpdate();
        JdbcUtil.release(null,psmt,null);
    }
    /**
     * @Author lym
     * @Description:执行检验后改变状态
     * @Param [id]
     * @return void
    **/
    @Override
    public void changeCheckApplyStateById(int id) throws SQLException {
        String sql="update CheckApply set state=5 where id=? recordtype=2";
        PreparedStatement psmt=con.prepareStatement(sql);
        psmt.setInt(1,id);
        psmt.executeUpdate();
        JdbcUtil.release(null,psmt,null);
    }

}
