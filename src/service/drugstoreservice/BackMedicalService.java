package service.drugstoreservice;

import dao.drugstoredao.BackMedicalDao;
import util.JdbcUtil;
import vo.SendMedical;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class BackMedicalService implements IBackMedicalService {
    Connection con=null;
    //返回已发药处方信息集合
    @Override
    public List<SendMedical> selectSendMedicalService(String st, String date) throws SQLException, ParseException {
        List<SendMedical> list=null;
       try{
           con=JdbcUtil.getConnection();
           con.setAutoCommit(false);
           BackMedicalDao bmd=new BackMedicalDao();
           bmd.setConnection(con);
           list=bmd.backMedical(st,date);
           con.commit();
       }catch (SQLException e){
           con.rollback();
           e.printStackTrace();
       }  finally {
           JdbcUtil.release(con,null,null);
       }
        return list;
    }

    @Override
    public List<SendMedical> selectSendMedicalService2(String st) throws SQLException, ParseException {
        List<SendMedical> list=null;
        try{
            con=JdbcUtil.getConnection();
            con.setAutoCommit(false);
            BackMedicalDao bmd=new BackMedicalDao();
            bmd.setConnection(con);
            list=bmd.backMedical2(st);
            con.commit();
        }catch (SQLException e){
            con.rollback();
            e.printStackTrace();
        }  finally {
            JdbcUtil.release(con,null,null);
        }
        return list;
    }

    //更改成功返回true  失败返回false
    @Override
    public boolean modifyState(int id) throws SQLException {
        boolean check=true;
        try {
            BackMedicalDao bmd=new BackMedicalDao();
            con=JdbcUtil.getConnection();
            con.setAutoCommit(false);
            bmd.setConnection(con);
            bmd.modifyStatus(id);
            con.commit();
        } catch (SQLException e) {
            check=false;
            con.rollback();
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
            return check;
        }

    }
}
