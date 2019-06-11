package dao.informationdao;

import util.JdbcUtil;
import vo.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;

/**
 * 医生排班管理Dao层
 */
public class DoctorCrewDao implements IDoctorCrewDao {
    Connection con=null;
    @Override
    public void setConnection(Connection con) {
        this.con=con;
    }

    /**
     * 通过日期查询医生排班
     */
    @Override
    public List<DoctorCrew> selectDoctorCrew(Date starttime, Date endtime)  throws SQLException {
        String sql="select S.ID,S.SchedDate,S.Noon,D.DeptName,s.UserID,U.RealName,R.RegistName,R.RegistQuota\n" +
                "FROM Scheduling S,Department D,User U,RegistLevel R\n" +
                "where S.DeptID = D.ID\n" +
                "and S.UserID = U.ID\n" +
                "and U.RegistLeID = R.ID\n" +
                "and S.SchedDate between ? And ?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        java.sql.Date start=new java.sql.Date(starttime.getTime());
        java.sql.Date end=new java.sql.Date(endtime.getTime());
        pstmt.setDate(1,start);
        pstmt.setDate(2,end);
        ResultSet rs=pstmt.executeQuery();
        List<DoctorCrew> docs=new ArrayList<>();
        DoctorCrew doc=null;
        while(rs.next()){
            doc=new DoctorCrew();
            doc.setId(rs.getInt(1));
            doc.setSchedDate(rs.getDate(2));
            doc.setNoon(rs.getString(3));
            doc.setDeptName(rs.getString(4));
            doc.setUserID(rs.getInt(5));
            doc.setRealName(rs.getString(6));
           // doc.setRegistName(rs.getString(7));
           // doc.setRegistQuota(rs.getString(8));
            docs.add(doc);
        }
        JdbcUtil.release(null,pstmt,rs);
        return docs;
    }

    /**
     * 获取有效科室
     */
    @Override
    public List<Department> selectDepartment() throws SQLException {
        String sql="select * \n" +
                "from department \n" +
                "where DelMark = 1";
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

    /**
     * 获取有效挂号级别
     */
    @Override
    public List<RegistLevel> selectRegistLevel() throws SQLException {
        String sql="select id,RegistCode,RegistName \n" +
                "from RegistLevel  \n" +
                "where DelMark = 1 \n" +
                "order by SequenceNo";
        PreparedStatement pstmt=con.prepareStatement(sql);
        ResultSet rs=pstmt.executeQuery();
        List<RegistLevel> regs=new ArrayList<>();
        RegistLevel reg=null;
        while(rs.next()){
            reg=new RegistLevel();
            reg.setId(rs.getInt(1));
            reg.setRegistCode(rs.getString(2));
            reg.setRegistName(rs.getString(3));
            regs.add(reg);
        }
        JdbcUtil.release(null,pstmt,rs);
        return regs;
    }

    /**
     * 按条件查询参与排班的医生
     */
    @Override
    public List<User> selectUser(int deptID, int registLeID) throws SQLException {
        String sql="select ID,UserName,Password,RealName,UseType,DocTitleID,IsScheduling,DeptID,RegistLeID,DelMark\n" +
                "from user\n" +
                "where UseType = 3\n" +
                "and IsScheduling = '是'\n" +
                "and DeptID = ?\n" +
                "and RegistLeID =?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setInt(1,deptID);
        pstmt.setInt(2,registLeID);
        ResultSet rs=pstmt.executeQuery();
        List<User> users=new ArrayList<>();
        User user=null;
        while(rs.next()){
            user=new User();
            user.setId(rs.getInt(1));
            user.setUserName(rs.getString(2));
            user.setPassword(rs.getString(3));
            user.setRealName(rs.getString(4));
            user.setUseType(rs.getInt(5));
            user.setDocTileID(rs.getInt(6));
            user.setIsScheduling(rs.getString(7));
            user.setDeptid(rs.getInt(8));
            user.setRegistLeID(rs.getInt(9));
            user.setDelMark(rs.getInt(10));
            users.add(user);
        }
        JdbcUtil.release(null,pstmt,rs);
        return users;
    }

    /**
     * 按条件查询排班规则
     */
    @Override
    public List<Rule> selectRule(int id) throws SQLException {
        String sql="select ID,RuleName,DeptID,UserID,Week,DelMark\n" +
                "from Rule\n" +
                "where DeptID = ?\n" +
                "And DelMark=1";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setInt(1,id);
        ResultSet rs=pstmt.executeQuery();
        List<Rule> rules=new ArrayList<>();
        Rule rule=null;
        while(rs.next()){
            rule=new Rule();
            rule.setId(rs.getInt(1));
            rule.setRuleNmae(rs.getString(2));
            rule.setDeptID(rs.getInt(3));
            rule.setUserID(rs.getInt(4));
            rule.setWeek(rs.getString(5));
            rule.setDelMark(rs.getInt(6));
            rules.add(rule);
        }
        JdbcUtil.release(null,pstmt,rs);
        return rules;
    }

    /**
     * 新增排班规则
     */
    @Override
    public void addRule(Rule rule) throws SQLException {
        String sql="insert into rule(RuleName,DeptID,UserID,Week,DelMark) value (?.?.?.?.?)";
        PreparedStatement pstmt=con.prepareStatement(sql);
    }

    /**
     * 批量删除排班计划
     */
    @Override
    public void deleteRule() throws SQLException {

    }
}
