package dao.costdao;

import util.JdbcUtil;
import vo.ExpenseClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CostAccountManagementDao implements ICostAccountManagementDao {
    Connection con=null;
    @Override
    public void setCon(Connection con) {
        this.con = con;
    }
    /**
     * @Author lym
     * @Description:查询有效的费用科目通过名字或者编码（模糊查询）
     * @Param [strName]
     * @return vo.ExpenseClass
     **/
    @Override
    public ExpenseClass selectExpenseClassByname(String strName) throws SQLException {
        String sql="select * from expenseclass where (expcode like \"%\"?\"%\" or expname like \"%\"?\"%\") and delmark=1";
        PreparedStatement psmt =con.prepareStatement(sql);
        psmt.setString(1,strName);
        psmt.setString(2,strName);
        ResultSet rs=psmt.executeQuery();
        ExpenseClass expenseClass=null;
        while (rs.next()){
            expenseClass =new ExpenseClass();
            expenseClass.setId(rs.getInt(1));
            expenseClass.setExpCode(rs.getString(2));
            expenseClass.setExpName(rs.getString(3));
            expenseClass.setDelMark(rs.getInt(4));
        }
        JdbcUtil.release(null,psmt,rs);
        return expenseClass;
    }

    @Override
    public ExpenseClass selectExpenseClassByID(int id) throws SQLException {
        String sql="select * from expenseclass where id=? and delmark=1";
        PreparedStatement psmt =con.prepareStatement(sql);
        psmt.setInt(1,id);
        ResultSet rs=psmt.executeQuery();
        ExpenseClass expenseClass=null;
        while (rs.next()){
            expenseClass =new ExpenseClass();
            expenseClass.setId(rs.getInt(1));
            expenseClass.setExpCode(rs.getString(2));
            expenseClass.setExpName(rs.getString(3));
            expenseClass.setDelMark(rs.getInt(4));
        }
        JdbcUtil.release(null,psmt,rs);
        return expenseClass;
    }

    /**
     * @Author lym
     * @Description 返回科目编码出现的次数
     * @Param [expCode]
     * @return int
     **/
    @Override
    public int repeatOfExpCode(String expCode) throws SQLException {
        String sql="select count(id) from expenseclass where expcode=? and delmark=1";
        PreparedStatement psmt=con.prepareStatement(sql);
        psmt.setString(1,expCode);
        ResultSet rs=psmt.executeQuery();
        int num=0;
        while (rs.next()){
            num=rs.getInt(1);
        }
        JdbcUtil.release(null,psmt,rs);
        return num;
    }
    /**
     * @Author lym
     * @Description:加入一个新的科目费用
     * @Param [expenseClass]
     * @return boolean
    **/
    @Override
    public boolean addEXpClass(ExpenseClass expenseClass) throws SQLException {
        String sql="insert  into expenseclass(expcode,expname,delmark) values(?,?,1)";
        PreparedStatement psmt =con.prepareStatement(sql);
        psmt.setString(1,expenseClass.getExpCode());
        psmt.setString(2,expenseClass.getExpName());
        psmt.executeUpdate();
        JdbcUtil.release(null,psmt,null);
        return true;
    }
    /**
     * @Author lym
     * @Description:修搞一个费用科目
     * @Param [expenseClass]
     * @return boolean
    **/
    @Override
    public boolean changeExpClass(ExpenseClass expenseClass) throws SQLException {
        String sql="update expenseclass set expcode=?,expname=?,delmark=1 where id=?";
        PreparedStatement psmt =con.prepareStatement(sql);
        psmt.setString(1,expenseClass.getExpCode());
        psmt.setString(2,expenseClass.getExpName());
        psmt.setInt(3,expenseClass.getId());
        psmt.executeUpdate();
        JdbcUtil.release(null,psmt,null);
        return true;
    }

    @Override
    public boolean delExpClass(int id) throws SQLException {
        String sql="update expenseclass set delmark=0 where id=?";
        PreparedStatement psmt =con.prepareStatement(sql);
        psmt.setInt(1,id);
        psmt.executeUpdate();
        JdbcUtil.release(null,psmt,null);
        return true;
    }
}
