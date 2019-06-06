package com.neusoft.his.dao;

import com.neusoft.his.Util.JdbcUtil;
import com.neusoft.his.vo.ConstantItem;
import com.neusoft.his.vo.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentDao implements IDepartmentDao{
    Connection con=null;
    @Override
    public Department findInfByCodeorName(String deptc, String deptn) throws SQLException {
        String sql="select id,deptcode,deptname,deptcategoryid,depttype,delmark from "+
                " department where (deptcode=? or deptname=?) and delmark=1";
        con= JdbcUtil.getConnection();
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1,deptc);
        ps.setString(2,deptn);
        ResultSet rs=ps.executeQuery();
        Department user=new Department();
        while (rs.next()){
            user.setId(rs.getInt(1));
            user.setDeptcode(rs.getString(2));
            user.setDeptname(rs.getString(3));
            user.setDeptcategoryid(rs.getInt(4));
            user.setDepttype(rs.getInt(5));
            user.setDelmark(rs.getInt(6));
        }
        JdbcUtil.release(con,ps,rs);
        return user;
    }

    @Override
    public ConstantItem getConstantItem() throws SQLException {
        String sql="select C2.ID,C2.ConstantCode,C2.ConstantName \n" +
                "from ConstantType C1,ConstantItem C2\n" +
                "where C2.ConstantTypeID=C1.ID\n" +
                "and ConstantTypeCode ='DeptCategory' \n" +
                "and C2.DelMark=1" ;
        //        "and constanttypecode ='DeptCategory' and C2.delmark=1";
        con= JdbcUtil.getConnection();
        PreparedStatement ps=con.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        ConstantItem user=new ConstantItem();
        while(rs.next()){
            user.setId(rs.getInt(1));
            user.setConstantcode(rs.getString(2));
            user.setConstantname(rs.getString(3));
        }
        return user;
    }

    @Override
    public void addNewDepartment(String deptc, String deptn, int deptcat, int deptt, int delmark) throws SQLException {
        String sql1="SELECT count(id) \n" +
                "FROM department \n" +
                "WHERE DeptCode =? \n" +
                "AND DelMark = 1";
        String sql2="INSERT INTO department(DeptCode,DeptName,DeptCategoryId,DeptType,DelMark) VALUES (?,?,?,?,?)";

        con=JdbcUtil.getConnection();
        PreparedStatement ps=con.prepareStatement(sql1);
        ps.setString(1,deptc);
        ResultSet rs=ps.executeQuery();
        int num=0;
        while(rs.next()){
            num=rs.getInt(1);
        }
        //通过id的数量判断费用是否重复
        if(num==0){  //没有这个部门则将新信息添加进去
            ps=con.prepareStatement(sql2);
            ps.setString(1,deptc);
            ps.setString(2,deptn);
            ps.setInt(3,deptcat);
            ps.setInt(4,deptt);
            ps.setInt(5,delmark);
            int i=ps.executeUpdate();
            JdbcUtil.release(con,null,null);
        }else{
            JdbcUtil.release(con,null,null);
        }

    }

    @Override
    public Department getInfByID(int id) throws SQLException {
        String sql="select ID,DeptCode,DeptName,DeptCategoryID,DeptType,DelMark \n" +
                "FROM Department \n" +
                "where id=? ";
        con=JdbcUtil.getConnection();
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1,id);
        ResultSet rs=ps.executeQuery();
        Department user=new Department();
        while (rs.next()){
            user.setId(rs.getInt(1));
            user.setDeptcode(rs.getString(2));
            user.setDeptname(rs.getString(3));
            user.setDeptcategoryid(rs.getInt(4));
            user.setDepttype(rs.getInt(5));
            user.setDelmark(rs.getInt(6));
        }
        JdbcUtil.release(con,ps,rs);
        return user;
    }

    @Override
    public void updateDepartment(String deptc, String deptn, int deptcat, int deptt, int delmark) throws SQLException {
        String sql1="SELECT count(id) \n" +
                "FROM department \n" +
                "WHERE DeptCode =? \n" +
                "AND DelMark = 1 ";

        String sql2 = "update department set deptcode=?,deptname=?,deptcategoryid=?,depttype=?,delmark=?  where deptcode=?";
        con=JdbcUtil.getConnection();
        PreparedStatement ps=con.prepareStatement(sql1);
        ps.setString(1,deptc);
        ResultSet rs=ps.executeQuery();
        int num=0;
        while(rs.next()){
            num=rs.getInt(1);
        }
        //通过id的数量判断费用科目是否重复
        if(num==1){  //不重复则将jack添加进去
            ps=con.prepareStatement(sql2);
            ps.setString(1,deptc);
            ps.setString(2,deptn);
            ps.setInt(3,deptcat);
            ps.setInt(4,deptt);
            ps.setInt(5,delmark);
            ps.setString(6,deptc);
            int i=ps.executeUpdate();
            JdbcUtil.release(con,null,null);
        }else{
            JdbcUtil.release(con,null,null);
        }

    }

    @Override
    public void invalideDepartment(int id) throws SQLException {
        String sql1="SELECT COUNT(ID) \n" +
                "FROM user \n" +
                "WHERE DeptID = ? \n" +
                "AND DelMark = 1";
        String sql2="SELECT count(id) \n" +
                "FROM Register \n" +
                "WHERE DeptID = ? \n" +
                "AND VisitState in (1,2)";
        String sql3="UPDATE department \n" +
                "set DelMark = 0 \n" +
                "WHERE ID = ?";
        con= JdbcUtil.getConnection();
        PreparedStatement ps=con.prepareStatement(sql1);
        ps.setInt(1,id);
        ResultSet rs=ps.executeQuery();
        int num1=0,num2=0;
        while(rs.next()){
            num1=rs.getInt(1);
        }
        ps=con.prepareStatement(sql2);
        ps.setInt(1,id);
        rs=ps.executeQuery();
        while(rs.next()){
            num2=rs.getInt(1);
        }
        if(num1==0&&num2==0){  //如果满足条件,则使得科室无效
            ps=con.prepareStatement(sql3);
            ps.setInt(1,id);
            int i=ps.executeUpdate();
            JdbcUtil.release(con,null,null);
        }else{
            JdbcUtil.release(con,null,null);
        }

    }
}
