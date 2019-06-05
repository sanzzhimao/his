package com.neusoft.his.dao;

import com.neusoft.his.Util.JdbcUtil;
import com.neusoft.his.vo.ExpenseClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExpenseClassDao implements IExpenseClassDao{
    Connection con=null;

    @Override
    public ExpenseClass findInfByCodeorName(String expc, String expn) throws SQLException {
        String sql="SELECT ID,ExpCode,ExpName,DelMark\n" +
                "FROM ExpenseClass\n" +
                "WHERE (ExpCode like ? Or ExpName like ?)\n" +
                "and DelMark = 1";
        con= JdbcUtil.getConnection();
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1,expc);
        ps.setString(2,expn);
        ResultSet rs=ps.executeQuery();
        ExpenseClass user=new ExpenseClass();
        while (rs.next()){
            user.setId(rs.getInt(1));
            user.setExpcode(rs.getString(2));
            user.setExpname(rs.getString(3));
            user.setDelmark(rs.getInt(4));
        }
        JdbcUtil.release(con,ps,rs);
        return user;

    }

    @Override
    public void addExpenseclass(String expc) throws SQLException {
        ExpenseClass user=new ExpenseClass("jack","杰克逊",1);
        String sql1="SELECT count(id) \n" +
                "FROM ExpenseClass\n" +
                "where ExpCode= ?\n" +
                "and DelMark = 1";

        String sql2 = "INSERT INTO ExpenseClass(ExpCode,ExpName,DelMark) VALUES (?,?,?)";

        con=JdbcUtil.getConnection();
        PreparedStatement ps=con.prepareStatement(sql1);
        ps.setString(1,expc);
        ResultSet rs=ps.executeQuery();
        int num=0;
        while(rs.next()){
            num=rs.getInt(1);
        }
        //通过id的数量判断费用科目是否重复
        if(num==1){  //不重复则将jack添加进去
             ps=con.prepareStatement(sql2);
             ps.setString(1,user.getExpcode());
             ps.setString(2,user.getExpname());
             ps.setInt(3,user.getDelmark());
            int i=ps.executeUpdate();
            JdbcUtil.release(con,null,null);
        }else{
            JdbcUtil.release(con,null,null);
        }

    }

    @Override
    public ExpenseClass findInfByID(int id) throws SQLException {
        String sql="SELECT ID,ExpCode,ExpName,DelMark\n" +
                "FROM ExpenseClass\n" +
                "where id = ?";
        con=JdbcUtil.getConnection();
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1,id);
        ResultSet rs=ps.executeQuery();
        ExpenseClass user=new ExpenseClass();
        while (rs.next()){
            user.setId(rs.getInt(1));
            user.setExpcode(rs.getString(2));
            user.setExpname(rs.getString(3));
            user.setDelmark(rs.getInt(4));
        }
        JdbcUtil.release(con,ps,rs);
        return user;

    }

    @Override
    public void setExpenseclassByExpC(String expc) throws SQLException {
        ExpenseClass user=new ExpenseClass("jack","杰克逊",1);
        String sql1="SELECT count(id) \n" +
                "FROM ExpenseClass\n" +
                "where ExpCode= ?\n" +
                "and DelMark = 1";

        String sql2 = "update ExpenseClass set expcode=?,expname=?,delmark=? where id=?";

        con=JdbcUtil.getConnection();
        PreparedStatement ps=con.prepareStatement(sql1);
        ps.setString(1,expc);
        ResultSet rs=ps.executeQuery();
        int num=0;
        while(rs.next()){
            num=rs.getInt(1);
        }
        //通过id的数量判断费用科目是否重复
        if(num==1){  //不重复则将jack添加进去
            ps=con.prepareStatement(sql2);
            ps.setString(1,user.getExpcode());
            ps.setString(2,user.getExpname());
            ps.setInt(3,user.getDelmark());
            ps.setInt(4,3);
            int i=ps.executeUpdate();
            JdbcUtil.release(con,null,null);
        }else{
            JdbcUtil.release(con,null,null);
        }

    }

    @Override
    public void invalideDelMarkByID(int id) throws SQLException {
        String sql="update  ExpenseClass\n" +
                "set DelMark = 0 \n" +
                "WHERE id = ?";
        con= JdbcUtil.getConnection();
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1,id);
        int i=ps.executeUpdate();
        JdbcUtil.release(con,null,null);
    }
}
