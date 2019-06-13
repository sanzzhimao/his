package dao.registdao;

import util.JdbcUtil;
import vo.*;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class RegistDao implements IRegistDao {
    Connection con;
    @Override
    public void setConnection(Connection con) {
        this.con=con;
    }
    /**
     * @Author lym
     * @Description：读取最大发票号
     * @Param [id]
     * @return java.lang.String
     * 已测试
     **/
    @Override
    public String selectMaxInvoiceNum(int id) throws SQLException {
        String sql="select max(invoicenum)+1 from invoice where userid=?";
        PreparedStatement ptmt = con.prepareStatement(sql);
        ptmt.setInt(1,id);
        String rsInvoiceNum=null;
        ResultSet rs=ptmt.executeQuery();
        while (rs.next()){
            rsInvoiceNum=rs.getString(1);
        }
        JdbcUtil.release(null,ptmt,rs);
        return rsInvoiceNum;
    }
    /**
     * @Author lym
     * @Description：读取当前的最大病历号+1既是生气一个新的病例号
     * @Param []
     * @return java.lang.String
    **/
    @Override
    public String selectCaseNumber() throws SQLException {
        String sql="select max(casenumber)+1 from register";
        PreparedStatement ptmt=con.prepareStatement(sql);
        ResultSet rs=ptmt.executeQuery();
        String rsCaseNumber=null;
        while (rs.next()){
            rsCaseNumber=rs.getString(1);
        }
        JdbcUtil.release(null,ptmt,rs);
        return rsCaseNumber;
    }
    /**
     * @Author lym
     * @Description:查询结算分类(自费等问题)
     * @Param []
     * @return vo.SettleCategory
    **/
    @Override
    public List<SettleCategory> selectSettleCategory() throws SQLException {
        String sql="select * from settlecategory where delmark=1 order by sequenceno";
        PreparedStatement ptmt =con.prepareStatement(sql);
        List<SettleCategory> list=new LinkedList<>();
        ResultSet rs=ptmt.executeQuery();
        while (rs.next()){
            SettleCategory settleCategory=new SettleCategory();
            settleCategory.setId(rs.getInt(1));
            settleCategory.setSettleCode(rs.getString(2));
            settleCategory.setSettleName(rs.getString(3));
            settleCategory.setSequenceNo(rs.getInt(4));
            settleCategory.setDelMark(rs.getInt(5));
            list.add(settleCategory);
        }
        JdbcUtil.release(null,ptmt,rs);
        return list;
    }
    /**
     * @Author lym
     * @Description:查询挂号等级（普通号，专家号）
     * @Param []
     * @return java.util.List<vo.RegistLevel>
    **/
    @Override
    public List<RegistLevel> selectRegistLevel() throws SQLException {
        String sql="select * from registlevel where delmark=1 order by sequenceno";
        PreparedStatement ptmt=con.prepareStatement(sql);
        ResultSet rs=ptmt.executeQuery();
        List<RegistLevel> list=new LinkedList<>();
        while (rs.next()){
            RegistLevel registLevel=new RegistLevel();
            registLevel.setId(rs.getInt(1));
            registLevel.setRegistCode(rs.getString(2));
            registLevel.setRegistName(rs.getString(3));
            registLevel.setSequenceNo(rs.getInt(4));
            registLevel.setRegistFree(rs.getDouble(5));
            registLevel.setRegistquota(rs.getInt(6));
            registLevel.setDelMark(rs.getInt(7));
            list.add(registLevel);
        }
        JdbcUtil.release(null,ptmt,rs);
        return list;
    }
    /**
     * @Author lym
     * @Description：通过id查询挂号费和初始的号额度；
     * @Param [id]
     * @return vo.RegistLevel
    **/
    @Override
    public RegistLevel selectRegistLevelById(int id) throws SQLException {
        String sql="select * from registlevel where delmark=1 and id=?";
        PreparedStatement ptmt=con.prepareStatement(sql);
        ptmt.setInt(1,id);
        ResultSet rs=ptmt.executeQuery();
       RegistLevel registLevel=null;
        while (rs.next()){
            registLevel=new RegistLevel();
            registLevel.setId(rs.getInt(1));
            registLevel.setRegistCode(rs.getString(2));
            registLevel.setRegistName(rs.getString(3));
            registLevel.setSequenceNo(rs.getInt(4));
            registLevel.setRegistFree(rs.getDouble(5));
            registLevel.setRegistquota(rs.getInt(6));
            registLevel.setDelMark(rs.getInt(7));

        }
        JdbcUtil.release(null,ptmt,rs);
        return registLevel;
    }
    /**
     * @Author lym
     * @Description:查询所有的有效科室
     * @Param []
     * @return java.util.List<vo.Department>
    **/
    @Override
    public List<Department> selectDepartment() throws SQLException {
        String sql="select * from department where depttype=1 and delmark=1";
        PreparedStatement ptmt=con.prepareStatement(sql);
        ResultSet rs=ptmt.executeQuery();
        List<Department> list=new LinkedList<>();
        while (rs.next()){
            Department department=new Department();
            department.setId(rs.getInt(1));
            department.setDeptCode(rs.getString(2));
            department.setDeptName(rs.getString(3));
            department.setDeptCategoryID(rs.getInt(4));
            department.setDeptType(rs.getInt(5));
            department.setDelMark(rs.getInt(6));
            list.add(department);
        }
        JdbcUtil.release(null,ptmt,rs);
        return list;
    }
    /**
     * @Author lym
     * @Description:通过看诊日期，午别，排班科室，挂号级别，读取当天的医生id和姓名
     * @Param [register]
     * @return java.util.List<vo.User>
    **/
    @Override
    public List<User> selectDoctorInfo(Register register) throws SQLException {
        String sql="select  user.id,user.realname " +
                "from scheduling,user where"+
                " scheduling.userid=user.deptid and " +
                "scheduling.scheddate=? and "+
                "scheduling.noon=? and " +
                "scheduling.deptid=? and " +
                "user.registleid=?";
        PreparedStatement ptmt=con.prepareStatement(sql);
        Date date=new Date(register.getVisitDate().getTime());
        ptmt.setDate(1,date);
        String noon=String.valueOf(register.getNoon());
        ptmt.setString(2,noon);
        ptmt.setInt(3,register.getDeptID());
        ptmt.setInt(4,register.getRegistLeID());
        ResultSet rs=ptmt.executeQuery();
        List<User> list=new LinkedList();
        User user=null;
        while (rs.next()){
            user=new User();
            user.setId(rs.getInt(1));
            user.setRealName(rs.getString(2));
            list.add(user);
        }
        JdbcUtil.release(null,ptmt,rs);
        return list;
    }
    /**
     * @Author lym
     * @Description:根据选中医生找到已经用去多少的号额(这个医生已经又多少个人看诊了)
     * @Param [reg]
     * @return int
    **/
    @Override
    public int selectDoctorUsedId(int userID,Date date ) throws SQLException {
        String sql="select count(id) from register \n" +
                "where userid=?\n" +
                "AND VisitDate=?\n" +
                "and VisitState in (1,2,3)" ;
        PreparedStatement ptmt=con.prepareStatement(sql);
        ptmt.setInt(1,userID);
        ptmt.setDate(2,date);
        ResultSet rs = ptmt.executeQuery();
        int allUsedId=0;
        while (rs.next()){
            allUsedId=rs.getInt(1);
        }
        JdbcUtil.release(null,ptmt,rs);
        return allUsedId;
    }
    /**
     * @Author lym
     * @Description：插入一个挂号的病人（前提是挂号的医生有班且有限额，时间是可以选定的）
     * @Param [reg]
     * @return j
     * ava.lang.Boolean
    **/
    @Override
    public Boolean addRegist(Register reg) throws SQLException {
        String sql="insert into register(casenumber,realname,gender,idnumber,birthdate,age,agetype," +
                "homeaddress,visitdate,noon,deptid,userid,registleid,settleid,isbook," +
                "registtime,registerid,visitstate) " +
                "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,1)";
        PreparedStatement pstm=con.prepareStatement(sql);
        pstm.setString(1,reg.getCaseNumber());
        pstm.setString(2,reg.getRealName());
        pstm.setInt(3,reg.getGender());
        //身份证号
        pstm.setString(4,reg.getIdNumber());
        //出生日期
        Date date=new Date(reg.getBirthDate().getTime());
        pstm.setDate(5,date);
        pstm.setInt(6,reg.getAge());
        //年龄类型？？？
        pstm.setString(7,"s");
        pstm.setString(8,reg.getHomeAddress());
        //看诊日期
        Date vistiDate=new Date(reg.getVisitDate().getTime());
        pstm.setDate(9,vistiDate);
        pstm.setString(10,reg.getNoon());
        pstm.setInt(11,reg.getDeptID());
        //挂号医生id
        pstm.setInt(12,reg.getUserID());
        //挂号级别
        pstm.setInt(13,reg.getRegistLeID());
        pstm.setInt(14,reg.getSettLeID());
        String isbook=String.valueOf(reg.getIsBook());
        pstm.setString(15,isbook);
        /*注册日期设置为当前系统日期*/
        Date registTime=new Date(System.currentTimeMillis());
        pstm.setDate(16,registTime);
        pstm.setInt(17,reg.getRegisterID());
        pstm.executeUpdate();
        JdbcUtil.release(null,pstm,null);
        return true;
    }
    /**
     * @Author lym
     * @Description:记录使用的发票
     * @Param [iv]
     * @return boolean
    **/
    @Override
    public boolean addInvoice(Invoice iv) throws SQLException {
        String sql="insert into invoice(invoicenum,money,state,creationtime,userid,registid,feetype,back,dailystate)" +
                "values(?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstm=con.prepareStatement(sql);
        pstm.setString(1,iv.getInvoiceNum());
        pstm.setDouble(2,iv.getMoney());
        pstm.setInt(3,1);
        //系统时间
        pstm.setDate(4,new Date(System.currentTimeMillis()));
        pstm.setInt(5,iv.getUserID());
        pstm.setInt(6,iv.getRegistID());
        pstm.setInt(7,iv.getFeeType());
        pstm.setString(8,iv.getBack());
        pstm.setInt(9,iv.getDailyState());
        pstm.executeUpdate();
        JdbcUtil.release(null,pstm,null);
        return true;
    }
    /**
     * @Author lym
     * @Description:患者费用明细表
     * @Param [pc]
     * @return void
    **/
    @Override
    public boolean addPatientCosts(PatientCosts pc) throws SQLException {
        String sql="insert into patientCosts(registid,invoiceid,itemid,itemtype,name,price,amount,deptid,createtime,createoperid,paytime,registerid,feetype,backid)" +
                " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setInt(1,pc.getRegistID());
        pstm.setInt(2,pc.getInvoiceID());
        pstm.setInt(3,pc.getItemID());
        pstm.setInt(4,pc.getItemType());
        pstm.setString(5,pc.getName());
        pstm.setDouble(6,pc.getPrice());
        pstm.setDouble(7,pc.getAmount());
        pstm.setInt(8,pc.getDeptID());
        Date creatTime=new Date(pc.getCreateTime().getTime());
        pstm.setDate(9,creatTime);
        pstm.setInt(10,pc.getCreateOperID());
        Date payTime=new Date(pc.getPayTime().getTime());
        pstm.setDate(11,payTime);
        pstm.setInt(12,pc.getRegisterID());
        pstm.setInt(13,pc.getFeeType());
        pstm.setInt(14,pc.getBackID());
        pstm.executeUpdate();
        JdbcUtil.release(null,pstm,null);
        return true;
    }
    /**
     * @Author lym
     * @Description:记录患者的情况
     * @Param [pc]
     * @return void
     **/
    @Override
    public Register reRegisterByCaseNumber(String  caseNumber) throws SQLException {
        String sql="select r.*,d.deptname from register r,department d where r.deptid=d.id and r.casenumber=?";
        PreparedStatement psmt=con.prepareStatement(sql);
        psmt.setString(1,caseNumber);
        ResultSet rs=psmt.executeQuery();
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
        JdbcUtil.release(null,psmt,rs);
        return register;
    }

    @Override
    public int selectUserIDByUserName(String name) throws SQLException {
        String sql="select id from user where username=?";
        PreparedStatement psmt=con.prepareStatement(sql);
        psmt.setString(1,name);
        ResultSet rs=psmt.executeQuery();
        int id=0;
        while (rs.next()){
            id=rs.getInt(1);
        }
        JdbcUtil.release(null,psmt,rs);
        return  id;
    }

    @Override
    public int selectConstantIDByConstantName(String constantName) throws SQLException {
       String sql="SELECT id FROM constantitem WHERE ConstantName=?";
       PreparedStatement psmt=con.prepareStatement(sql);
        psmt.setString(1,constantName);
        ResultSet rs=psmt.executeQuery();
        int constantID=0;
        while (rs.next()){
            constantID=rs.getInt(1);
        }
        JdbcUtil.release(null,psmt,rs);
        return constantID;
    }

    @Override
    public int selectRegistID(String caseNum, String  visitDate) throws SQLException {
        String sql="select id from register where CaseNumber=? and VisitDate=?";
        PreparedStatement psmt=con.prepareStatement(sql);
        psmt.setString(1,caseNum);
        psmt.setString(2,visitDate);
        ResultSet rs=psmt.executeQuery();
        int id=0;
        while (rs.next()){
            id=rs.getInt(1);
        }
        JdbcUtil.release(null,psmt,rs);
        return id;

    }

    @Override
    public boolean addmedical(MedicalRecord medicalRecord) throws SQLException {
        String sql="insert into medicalrecord(casenumber,registid,casestate) values(?,?,?)";
        PreparedStatement psmt=con.prepareStatement(sql);
        psmt.setString(1,medicalRecord.getCaseNumber());
        psmt.setInt(2,medicalRecord.getRegisterID());
        psmt.setInt(3,1);
        psmt.executeUpdate();
        JdbcUtil.release(null,psmt,null);
        return false;
    }

}
