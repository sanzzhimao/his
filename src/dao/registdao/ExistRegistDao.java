package dao.registdao;

import util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExistRegistDao implements IExistRegistDao{
    Connection con=null;
    /**
     * @Author lym
     * @Description：退号之后修改挂号状态--4
     * @Param [caseNumber]通过病历号修改
     * @return vo.Register
     * w
     **/
    @Override
    public void  changeByCaseNumber(String caseNumber) throws SQLException {
        String sql="update register set visitstate=4 where casenumber=?";
        PreparedStatement psmt =con.prepareStatement(sql);
        psmt.setString(1,caseNumber);
        psmt.executeUpdate();
        JdbcUtil.release(null,psmt,null);
    }
    /**
     * @Author lym
     * @Description：退号之后修改挂号状态--4
     * @Param [id]通过id修改
     * @return vo.Register
     **/
    @Override
    public void  changeByCaseNumber(int id) throws SQLException {
        String sql="update register set visitstate=4 where casenumber=?";
        PreparedStatement psmt =con.prepareStatement(sql);
        psmt.setInt(1,id);
        psmt.executeUpdate();
        JdbcUtil.release(null,psmt,null);
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
}
