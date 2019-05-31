package dao;
/**
 * 挂号级别的dao层
 *
 * */
import util.JdbcUtil;
import vo.RegistLevel;
import vo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class RegistLevelDao implements IRegistLevelDao{
    Connection con;
//增加一个挂号级别
    @Override
    public void addRegistLevel(RegistLevel registLevel) {

    }

    @Override
    public void delRegistLevel(int sequenceNo) {

    }

    @Override
    public void changeRegistLevel(RegistLevel registLevel) {

    }
    //查询挂号级别
    @Override
    public List<RegistLevel> select(String strName) throws SQLException {
        String sql=null;
        if (strName.length()==0){
            sql="select * from registlevel";
        }else{
            sql="select * from registlevel where registcode like '%'"+strName+"'%' or registname like '%'"+strName+"'%'";
        }
        PreparedStatement ptmt =con.prepareStatement(sql);
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
}
