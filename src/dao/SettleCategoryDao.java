package dao;

import util.JdbcUtil;
import vo.SettleCategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class SettleCategoryDao implements ISettleCategoryDao {
    Connection con;

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    /**
     * @Author lym
     * @Description:增加一个结算类别
     * @Param [settleCategory]对象
     * @return void
    **/
    @Override
    public void addSettleCategory(SettleCategory settleCategory) throws SQLException {
        String sql="insert into settlecategory(SettleCode,SettleName,SequenceNo,DelMark) valus(?,?,?,1)";
        PreparedStatement ptmt =con.prepareStatement(sql);
        ptmt.setString(1,settleCategory.getSettleCode());
        ptmt.setString(2,settleCategory.getSettleName());
        ptmt.setInt(3,settleCategory.getSequenceNo());
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
     * @Descriptionsan删除一个挂号结算类型
     * @Param [settle]通过编码“删除”
     * @return void
    **/
    @Override
    public void delSettleCategory(String settle) throws SQLException {
        String sql="update settlecategory set DelMark=0 where SettleCode=?";
        PreparedStatement ptmt =con.prepareStatement(sql);
        ptmt.setString(1,settle);
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
 * @Description:通过id进行删除
 * @Param [id]
 * @return void
**/
    @Override
    public void delSettleCategory(int id) throws SQLException {
        String sql="update settlecategory set DelMark=0 where id=?";
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
 * @Description:修改一个结算类型
 * @Param [settleCategory]
 * @return void
**/
    @Override
    public void changeSettleCategory(SettleCategory settleCategory) throws SQLException {
        String sql = "update settlecategory set SettleCode=?,SettleName=?,SequenceNo=? where id=?";
        PreparedStatement ptmt =con.prepareStatement(sql);
        ptmt.setString(1,settleCategory.getSettleCode());
        ptmt.setString(2,settleCategory.getSettleName());
        ptmt.setInt(3,settleCategory.getSequenceNo());
        ptmt.setInt(4,settleCategory.getId());
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
     * @Description查询
     * @Param [settle]
     * @return java.util.List<vo.SettleCategory>
    **/
    @Override
    public List<SettleCategory> selectSettleCategory(String settle) throws SQLException {
        String sql=null;
        PreparedStatement ptmt=null;
        if (settle==null || settle.length()==0){
            sql="select * from settlecategory";
            ptmt =con.prepareStatement(sql);
        }else {
            sql="select * from settlecategory where SettleCode like \"%\"?\"%\" or SettleName like \"%\"?\"%\" where delmark=1";
            ptmt =con.prepareStatement(sql);
            ptmt.setString(1,settle);
            ptmt.setString(2,settle);
        }
        ResultSet rs=null;
        List<SettleCategory> list=new LinkedList<>();
             rs=ptmt.executeQuery();
            while (rs.next()){
                SettleCategory settleCategory=new SettleCategory();
                settleCategory.setId(rs.getInt(1));
                settleCategory.setSequenceNo(rs.getInt(4));
                settleCategory.setDelMark(rs.getInt(5));
                settleCategory.setSettleCode(rs.getString(2));
                settleCategory.setSettleName(rs.getString(3));
                list.add(settleCategory);
            }
            JdbcUtil.release(null,ptmt,rs);
        return list;
    }

    @Override
    public List<SettleCategory> selectSettleCategory() throws SQLException {
        String sql=null;
        PreparedStatement ptmt=null;
        sql="select * from settlecategory";
        ptmt =con.prepareStatement(sql);
        ResultSet rs=null;
        List<SettleCategory> list=new LinkedList<>();
        rs=ptmt.executeQuery();
            while (rs.next()){
                SettleCategory settleCategory=new SettleCategory();
                settleCategory.setId(rs.getInt(1));
                settleCategory.setSequenceNo(rs.getInt(4));
                settleCategory.setDelMark(rs.getInt(5));
                settleCategory.setSettleCode(rs.getString(2));
                settleCategory.setSettleName(rs.getString(3));
                list.add(settleCategory);
            }
            JdbcUtil.release(null,ptmt,rs);
        return list;
    }
}
