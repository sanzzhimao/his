package dao.informationdao;
/**
 * 用户管理的dao层
 * */
import util.JdbcUtil;
import vo.ConstantItem;
import vo.Department;
import vo.RegistLevel;
import vo.User;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class UserManagementDao implements IUserManagementDao {
   Connection con;

 public void setConnection(Connection con) {
  this.con = con;
 }
/**
 * @Author lym
 * @Description 增加一个用户（医院人员）
 * @Param [user]
 * @return void
 * 测试成功（已在数据库中插入数据）
**/
    @Override
    public void addUSer(User user) throws SQLException {
       String sql="insert into user(username,password,realname,usetype,doctitleid,isscheduling,deptid,registleid,delmark) value(?,?,?,?,?,?,?,?,1)";
        PreparedStatement ptmt =con.prepareStatement(sql);
        ptmt.setString(1,user.getUserName());
        ptmt.setString(2,user.getPassword());
        ptmt.setString(3,user.getRealName());
        ptmt.setInt(4,user.getUseType());
        ptmt.setInt(5,user.getDocTileID());
        ptmt.setString(6,user.getIsScheduling());
        ptmt.setInt(7,user.getDeptid());
        ptmt.setInt(8,user.getRegistLeID());
        //设置不自动提交
        JdbcUtil.transactionController(con);
        //如果名字不重复
        ptmt.executeUpdate();
        if (reName(user.getUserName())==0) {
            JdbcUtil.commitTransaction(con);
        }else {
            JdbcUtil.rollbackTransaction(con);
        }
         JdbcUtil.release(null,ptmt,null);


    }
    /**
     * @Author lym
     * @Description:删除一个用户（医院人员）
     * @Param [userName]
     * @return void
    **/
    @Override
    public void delUser(String userName) throws SQLException {
      String sql="update user set delmark=0 where username=?";
      PreparedStatement ptmt =con.prepareStatement(sql);
      ptmt.setString(1,userName);
     JdbcUtil.transactionController(con);
     try {
      ptmt.executeUpdate();
      JdbcUtil.commitTransaction(con);
     }catch (SQLException e){
      JdbcUtil.rollbackTransaction(con);
      throw e;
     }finally {
      JdbcUtil.release(null,ptmt,null);
     }
    }
    /**
     * @Author lym
     * @Description:“删除一个用户”通过id
     * @Param [id]
     * @return void
    **/
    @Override
    public void delUser(int id) throws SQLException {
        String sql="update user set delmark=0 where id=?";
        PreparedStatement ptmt =con.prepareStatement(sql);
        ptmt.setInt(1,id);
        JdbcUtil.transactionController(con);
        try {
            ptmt.executeUpdate();
            JdbcUtil.commitTransaction(con);
        }catch (SQLException e){
            JdbcUtil.rollbackTransaction(con);
            throw e;
        }finally {
            JdbcUtil.release(null,ptmt,null);
        }
    }
    /**
 * @Author lym
 * @Description  :改变医院人员的信息
 * @Param [user]
 * @return void
**/
    @Override
    public void changeUser(User user) throws SQLException {
     String sql="update user set  username=?,password=?,realname=?,usetype=?,doctitleid=?,isscheduling=?,deptid=?,registleid=? where id=?";
     PreparedStatement ptmt =con.prepareStatement(sql);
     ptmt.setString(1,user.getUserName());
     ptmt.setString(2,user.getPassword());
     ptmt.setString(3,user.getRealName());
     ptmt.setInt(4,user.getUseType());
     ptmt.setInt(5,user.getDocTileID());
     ptmt.setString(6,user.getIsScheduling());
     ptmt.setInt(7,user.getDeptid());
     ptmt.setInt(8,user.getRegistLeID());
     ptmt.setInt(9,user.getId());
     //设置不自动提交
     JdbcUtil.transactionController(con);
        ptmt.executeUpdate();
        if (reName(user.getUserName())==0){
            JdbcUtil.commitTransaction(con);
        }else {
            JdbcUtil.rollbackTransaction(con);
        }
      JdbcUtil.release(null,ptmt,null);

    }
/**
 * @Author lym
 * @Description:查询用户（医院人员）【
 * @Param [name]通过登录名或者名字查询或者null】
 * @return java.util.List<vo.User>
 *     已测试---success
**/
    @Override
    public List<User> selectUser(String name) throws SQLException {
     String sql=null;
        PreparedStatement ptmt=null;
        if (name==null || name.length()==0){
       sql="select * from user where delmark=1";
         ptmt =con.prepareStatement(sql);
     }else{
       sql="select * from user where (username like \"%\"?\"%\" or realname like \"%\"?\"%\") and delmark=1";
       ptmt=con.prepareStatement(sql);
       ptmt.setString(1,name);
       ptmt.setString(2,name);
     }
     ResultSet rs=ptmt.executeQuery();
     List<User> users=new LinkedList<>();
     while (rs.next()){
      User user=new User();
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
     JdbcUtil.release(null,ptmt,rs);
        return users;
    }

 @Override
 public int reName(String name) throws SQLException {
        int num=0;
     String sql="select count(id) from user where username=? and delmark=1";
     PreparedStatement ptmt=con.prepareStatement(sql);
     ptmt.setString(1,name);
     ResultSet rs=ptmt.executeQuery();
     while (rs.next()){
         num=rs.getInt(1);
     }
  return num;
 }
/**
 * @Author lym
 * @Description:通过id查询用户（医务人员）
 * @Param [id]
 * @return java.util.List<vo.User>
**/
 @Override
 public List<User> selectUser(int id) throws SQLException {
     String sql="select * from user where delmark=1 and id="+id;
     PreparedStatement ptmt =con.prepareStatement(sql);
     ResultSet rs=ptmt.executeQuery();
     List<User> users=new LinkedList<>();
     while (rs.next()){
         User user=new User();
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
     JdbcUtil.release(null,ptmt,rs);
     return users;
 }
/**
 * @Author lym
 * @Description：查询所有的科室
 * @Param []
 * @return java.util.List<vo.Department>
**/
    @Override
    public List<Department> selectDetpID() throws SQLException {
        String sql="select * from department where delmark = 1";
        PreparedStatement ptmt =con.prepareStatement(sql);
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
     * @Description查询所有的用户（有效）
     * @Param []
     * @return java.util.List<vo.User>
    **/
    @Override
    public List<User> selectUser() throws SQLException {

        String  sql="select * from user where delmark=1";
        PreparedStatement ptmt =con.prepareStatement(sql);
        ResultSet rs=ptmt.executeQuery();
        List<User> users=new LinkedList<>();
        while (rs.next()){
            User user=new User();
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
        JdbcUtil.release(null,ptmt,rs);
        return users;
    }
/**
 * @Author lym
 * @Description:查询医生职称（主治医生，主任。。。。。）
 * @Param []
 * @return java.util.List<vo.ConstantItem>
**/
    @Override
    public List<ConstantItem> selectDoc() throws SQLException {
        String sql="select c1.* from constanttype c2,constantitem c1 where"+
        "c1.ConstantTypeID=c2.ID"+
        "and constanttypecode='DocTitle' and c1.delmark=1";
        PreparedStatement ptmt=con.prepareStatement(sql);
        ResultSet rs=ptmt.executeQuery();
        List<ConstantItem> list=new ArrayList<>();
        while (rs.next()){
            ConstantItem constantItem=new ConstantItem();
            constantItem.setId(rs.getInt(1));
            constantItem.setConstantName(rs.getString(3));
            constantItem.setContantCode(rs.getString(2));
            constantItem.setDelMark(rs.getInt(4));
            list.add(constantItem);
        }
        JdbcUtil.release(null,ptmt,null);
        return list;
    }
    /**
     * @Author lym
     * @Description:查询挂号级别
     * @Param []
     * @return java.util.List<vo.RegistLevel>
    **/
    @Override
    public List<RegistLevel> selectRegistLevel() throws SQLException {
        String sql="select id,RegistCode,RegistName,SequenceNo,RegistFee,RegistQuota,DelMark\n" +
                "from RegistLevel \n" +
                "where DelMark=1\n" +
                "order by SequenceNo";
        PreparedStatement ptmt=con.prepareStatement(sql);
        ResultSet rs=ptmt.executeQuery();
        List<RegistLevel> list=new ArrayList();
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
}
