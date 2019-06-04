package dao;

import util.JdbcUtil;
import vo.ConstantItem;
import vo.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentDao implements IDepartmentDao {
    Connection con=null;
    public void setConnection(Connection con) {
        this.con=con;
    }

    @Override
    public Department selectDepartment(String deptCode, String deptName) throws SQLException {
        String sql="select * from department where DeptCode=? or DeptName=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,deptCode);
        pstmt.setString(2,deptName);
        ResultSet rs=pstmt.executeQuery();
        Department depart=null;
        while (rs.next()){
            depart=new Department();
            depart.setId(rs.getInt(1));
            depart.setDeptCode(rs.getString(2));
            depart.setDeptName(rs.getString(3));
            depart.setDeptCategoryID(rs.getInt(4));
            depart.setDeptType(rs.getInt(5));
            depart.setDelMark(rs.getInt(6));
        }
        JdbcUtil.release(null,pstmt,null);
        return depart;
    }
    //依据ID查询科室信息
    @Override
    public Department selectDepartmentByID(int id) throws SQLException {

        String sql="select ID,DeptCode,DeptName,DeptCategoryID,DeptType,DelMark \n" +
                "FROM Department \n" +
                "where id=? ";
        con=JdbcUtil.getConnection();
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1,id);
        ResultSet rs=ps.executeQuery();
        Department depart=new Department();
        while (rs.next()){
            depart.setId(rs.getInt(1));
            depart.setDeptCode(rs.getString(2));
            depart.setDeptName(rs.getString(3));
            depart.setDeptCategoryID(rs.getInt(4));
            depart.setDeptType(rs.getInt(5));
            depart.setDelMark(rs.getInt(6));
        }
        JdbcUtil.release(con,ps,rs);
        return depart;

    }
    //从常熟表中读取所有科室分类
    @Override
    public ConstantItem getConstantItem() throws SQLException {
        String sql="select C2.ID,C2.ConstantCode,C2.ConstantName \n" +
                "from ConstantType C1,ConstantItem C2\n" +
                "where C2.ConstantTypeID=C1.ID\n" +
                "and ConstantTypeCode ='DeptCategory' \n" +
                "and C2.DelMark=1" ;
        con= JdbcUtil.getConnection();
        PreparedStatement ps=con.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        ConstantItem user=null;
        while(rs.next()){
            user.setId(rs.getInt(1));
            user.setContantCode(rs.getString(2));
            user.setConstantName(rs.getString(3));
        }
        return user;
    }


    //增加科室
    @Override
    public void addnewDepartment(Department department) throws SQLException {
        String sql="insert into department values(?,?,?,?,?,)";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,department.getDeptCode());
        pstmt.setString(2,department.getDeptName());
        pstmt.setInt(3,department.getDeptCategoryID());
        pstmt.setInt(4,department.getDeptType());
        pstmt.setInt(5,department.getDelMark());
        pstmt.executeUpdate();
        JdbcUtil.release(null, pstmt, null);
        }
    //编辑科室信息
    @Override
    public void updateDepartment(Department department) throws SQLException {
        String sql="insert into department values(?,?,?,?,?,)";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,department.getDeptCode());
        pstmt.setString(2,department.getDeptName());
        pstmt.setInt(3,department.getDeptCategoryID());
        pstmt.setInt(4,department.getDeptType());
        pstmt.setInt(5,department.getDelMark());
        pstmt.executeUpdate();
        JdbcUtil.release(null, pstmt, null);

    }
    //作废信息
    @Override
       public void deleteDepartment(int id) throws SQLException {
        String sql="update fmeditem set DelMark=0 where id=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setInt(1,id);
        pstmt.executeUpdate();
        JdbcUtil.release(null, pstmt, null);
    }

}
