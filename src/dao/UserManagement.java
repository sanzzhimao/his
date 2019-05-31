package dao;
/**
 * 用户管理的da层
 * */
import util.JdbcUtil;
import vo.User;

import javax.jws.soap.SOAPBinding;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
public class UserManagement implements IUserManagement {
   Connection con;
   String isScheduling="否";
   //增加一个用户（医院人员）
    @Override
    public void addUSer(User user) throws SQLException {
       String sql="insert into user(username,password,realname,usertype,doctitleid,isscheduling,deptid,registleid,delmark) value(?,?,?,?,?,?,?,?,1)";
        PreparedStatement ptmt =con.prepareStatement(sql);
        ptmt.setString(1,user.getUserName());
        ptmt.setString(2,user.getPassword());
        ptmt.setString(3,user.getRealName());
        ptmt.setInt(4,user.getUseType());
        ptmt.setInt(5,user.getDocTileID());
        if (user.getScheduling())isScheduling="是";
        ptmt.setString(6,isScheduling);
        ptmt.setInt(7,user.getDeptid());
        ptmt.setInt(8,user.getRegistLeID());
        //设置不自动提交
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
    //删除一个用户（医院人员）
    @Override
    public void delUser(String userName) throws SQLException {
      String sql="delete from user where username=?";
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
  //改变医院人员的信息
    @Override
    public void changeUser(User user) throws SQLException {
     String sql="update user set  username=?,password=?,realname=?,usertype=?doctitleid=?,isscheduling=?,deptid=?,registleid=?";
     PreparedStatement ptmt =con.prepareStatement(sql);
     ptmt.setString(1,user.getUserName());
     ptmt.setString(2,user.getPassword());
     ptmt.setString(3,user.getRealName());
     ptmt.setInt(4,user.getUseType());
     ptmt.setInt(5,user.getDocTileID());
     if (user.getScheduling())isScheduling="是";
     ptmt.setString(6,isScheduling);
     ptmt.setInt(7,user.getDeptid());
     ptmt.setInt(8,user.getRegistLeID());
     //设置不自动提交
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
//查询用户（医院人员）【通过登录名或者名字查询】
    @Override
    public List<User> selectUser(String name) throws SQLException {
     String sql=null;
     if (name.length()==0){
       sql="select * from user";
     }else{
       sql="select * from user where username like '%'"+name+"'%' or realname like '%'"+name+"'%'";
     }
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
      boolean ischeduling=false;
      if (rs.getString(7).equals("是"))ischeduling=true;
      user.setScheduling(ischeduling);
      user.setDeptid(rs.getInt(8));
      user.setRegistLeID(rs.getInt(9));
      user.setDelMark(rs.getInt(10));
      users.add(user);
     }
     JdbcUtil.release(null,ptmt,rs);
        return users;
    }
}
