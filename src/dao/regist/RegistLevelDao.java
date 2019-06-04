package dao.regist;
/**
 * @Author lym
 * @Description //TODO
**/
import dao.regist.IRegistLevelDao;
import util.JdbcUtil;
import vo.RegistLevel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class RegistLevelDao implements IRegistLevelDao {
    Connection con;

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    /**
    * @Author lym
    * @Description:增加一个挂号级别
    * @Param [registLevel]对象
    * @return void
   **/

    @Override
    public void addRegistLevel(RegistLevel registLevel) throws SQLException {
        String sql="insert into registlevel(registcode,registname,sequenceno,registfree,registquota,delmark) values(?,?,?,?,?,?,1)";
        PreparedStatement ptmt=con.prepareStatement(sql);
        ptmt.setString(1,registLevel.getRegistCode());
        ptmt.setString(2,registLevel.getRegistName());
        ptmt.setInt(3,registLevel.getSequenceNo());
        ptmt.setDouble(4,registLevel.getRegistFree());
        ptmt.setInt(5,registLevel.getRegistquota());
        ptmt.setInt(6,registLevel.getDelMark());
        JdbcUtil.transactionController(con);
        ptmt.executeUpdate();
        if (reRegistLevelID(registLevel.getRegistCode())==0){
            JdbcUtil.commitTransaction(con);
        }else {
            JdbcUtil.rollbackTransaction(con);
        }
            JdbcUtil.release(null,ptmt,null);
    }
    //删除一个挂号级别（通过顺序号删除）
/**
 * @Author lym
 * @Description；通过顺序号进行删除
 * @Param [sequenceNo]
 * @return void
**/
@Override
    public void delRegistLevel(int id) throws SQLException {
        String sql="update registlevel set delmark=0 where id=?";
        PreparedStatement ptmt =con.prepareStatement(sql);
        ptmt.setInt(1,id);
        JdbcUtil.transactionController(con);
        try {
            ptmt.executeUpdate();
            JdbcUtil.commitTransaction(con);
        }catch (SQLException e){
            JdbcUtil.rollbackTransaction(con);
        }finally {
            JdbcUtil.release(null,ptmt,null);
        }
    }
   /**
    * @Author lym
    * @Description //TODO 
    * @Date 13:36 
    * @Param [registLevel]RegistLevel对象
    * @return void
   **/
    //修改顺序号
    @Override
    public void changeRegistLevel(RegistLevel registLevel) throws SQLException {
        String sql="update registlevel set registcode=?,registname=?,sequenceno=?,registefree=?,registquota=? where id=?";
        PreparedStatement ptmt = con.prepareStatement(sql);
        ptmt.setString(1,registLevel.getRegistCode());
        ptmt.setString(2,registLevel.getRegistName());
        ptmt.setInt(3,registLevel.getSequenceNo());
        ptmt.setDouble(4,registLevel.getRegistFree());
        ptmt.setInt(5,registLevel.getRegistquota());
        ptmt.setInt(6,registLevel.getId());
        JdbcUtil.transactionController(con);
        ptmt.executeUpdate();
        if (reRegistLevelID(registLevel.getRegistCode())==0){
            JdbcUtil.commitTransaction(con);
        }else {
            JdbcUtil.rollbackTransaction(con);
        }
        JdbcUtil.release(null,ptmt,null);
    }
    //查询挂号级别
    /**
     * @Author lym
     * @Description 查询：通过名字或者编码
     * @Date
     * @Param [strName]名字或者编码或者是null
     * @return java.util.List<vo.RegistLevel>
    **/
    @Override
    public List<RegistLevel> selectRegistLevel(String strName) throws SQLException {
        String sql=null;
        PreparedStatement ptmt=null;
        if (strName==null  || strName.length()==0){
            sql="select * from registlevel";
            ptmt =con.prepareStatement(sql);
        }else{
            sql="select * from registlevel where (registcode like \"%\"?\"%\" or registname like \"%\"?\"%\") and delmark=1 order by  sequenceno";
            ptmt =con.prepareStatement(sql);
            ptmt.setString(1,strName);
            ptmt.setString(2,strName);
        }
        ResultSet rs=ptmt.executeQuery();
        List<RegistLevel> registLevels=new LinkedList<>();
        while (rs.next()){
            RegistLevel registLevel=new RegistLevel();
            registLevel.setId(rs.getInt(1));
            registLevel.setRegistCode(rs.getString(2));
            registLevel.setRegistName(rs.getString(3));
            registLevel.setSequenceNo(rs.getInt(4));
            registLevel.setRegistFree(rs.getDouble(5));
            //挂号限额
            registLevel.setRegistquota(rs.getInt(6));
            registLevel.setDelMark(rs.getInt(7));
            registLevels.add(registLevel);
        }
        JdbcUtil.release(null,ptmt,rs);
        return registLevels;
    }
    /**
     * @Author lym
     * @Description：查询所有
     * @Param []
     * @return java.util.List<vo.RegistLevel>
    **/
    @Override
    public List<RegistLevel> selectRegistLevel() throws SQLException {
        String sql="select * from registlevel";
        PreparedStatement  ptmt =con.prepareStatement(sql);
        ResultSet rs=ptmt.executeQuery();
        List<RegistLevel> registLevels=new LinkedList<>();
        while (rs.next()){
            RegistLevel registLevel=new RegistLevel();
            registLevel.setId(rs.getInt(1));
            registLevel.setRegistCode(rs.getString(2));
            registLevel.setRegistName(rs.getString(3));
            registLevel.setSequenceNo(rs.getInt(4));
            registLevel.setRegistFree(rs.getDouble(5));
            //挂号限额
            registLevel.setRegistquota(rs.getInt(6));
            registLevel.setDelMark(rs.getInt(7));
            registLevels.add(registLevel);
        }
        JdbcUtil.release(null,ptmt,rs);
        return registLevels;
    }
    /**
     * @Author lym
     * @Description：通过id查询
     * @Param [id]
     * @return java.util.List<vo.RegistLevel>
    **/
    @Override
    public List<RegistLevel> selectRegistLevel(int id) throws SQLException {
        String sql="select * from registlevel where id=?";
        PreparedStatement ptmt =con.prepareStatement(sql);
        ptmt.setInt(1,id);
        ResultSet rs=ptmt.executeQuery();
        List<RegistLevel> registLevels=new LinkedList<>();
        while (rs.next()){
            RegistLevel registLevel=new RegistLevel();
            registLevel.setId(rs.getInt(1));
            registLevel.setRegistCode(rs.getString(2));
            registLevel.setRegistName(rs.getString(3));
            registLevel.setSequenceNo(rs.getInt(4));
            registLevel.setRegistFree(rs.getDouble(5));
            //挂号限额
            registLevel.setRegistquota(rs.getInt(6));
            registLevel.setDelMark(rs.getInt(7));
            registLevels.add(registLevel);
        }
        JdbcUtil.release(null,ptmt,rs);
        return registLevels;
    }
    /**
     * @Author lym
     * @Description编码是否重复
     * @Param [registCode]
     * @return int
    **/
    @Override
    public int reRegistLevelID(String registCode) throws SQLException {
        int num=0;
        String sql="SELECT count(id) \n" +
                "FROM RegistLevel\n" +
                "where RegistCode = ?\n" +
                "and DelMark = 1";
        PreparedStatement ptmt=con.prepareStatement(sql);
        ptmt.setString(1,registCode);
        ResultSet rs=ptmt.executeQuery();

        while (rs.next()){
            num=rs.getInt(1);
        }
        return num;
    }
}
