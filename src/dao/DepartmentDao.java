package dao;

import util.JdbcUtil;
import vo.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentDao implements IDepartmentDao {
    Connection con=null;
    @Override
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
    //增加科室
    @Override
    public void addnewDepartment(Department department) throws SQLException {
        String sql="insert into department values(?,?,?,?,?,)";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.executeUpdate();
        pstmt=con.prepareStatement(sql);
        pstmt.setString(1,department.getDeptCode());
        pstmt.setString(2,department.getDeptName());
        pstmt.setInt(3,department.getDeptCategoryID());
        pstmt.setInt(4,department.getDeptType());
        pstmt.setInt(5,department.getDelMark());
        JdbcUtil.release(null, pstmt, null);
        }
    //更新科室信息
    @Override
    public void updateDepartment(String deptCode, String deptName, String deptCategoryID, int deptType, int delMark) {
        String sql="select ID from department where DeptCode=? and DelMark=1";
        String sql2 = "update department set deptcode=?,deptname=?,deptcategoryid=?,depttype=?,delmark=?  where deptcode=?";
    }

    @Override
    public void deleteDepartment(int id) {

    }

}
