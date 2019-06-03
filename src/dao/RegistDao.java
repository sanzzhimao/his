package dao;

import sun.awt.image.ImageWatched;
import util.JdbcUtil;
import vo.*;

import java.beans.FeatureDescriptor;
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

}
