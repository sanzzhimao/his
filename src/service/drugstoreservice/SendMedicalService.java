package service.drugstoreservice;

import dao.drugstoredao.SendMedicalDao;
import util.JdbcUtil;
import vo.SendMedical;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class SendMedicalService implements ISendMedicalService {
    Connection con=null;
    //返回未发药处方信息集合 传入病例号 和时间
    @Override
    public List<SendMedical> selectSendMedicalService(String st, String date) throws SQLException, ParseException {
        List<SendMedical> list=null;
       try{
           SendMedicalDao smd=new SendMedicalDao();
           con=JdbcUtil.getConnection();
           con.setAutoCommit(false);
           smd.setConnection(con);
           list=smd.sendMedical(st,date);
           con.commit();
       }catch (SQLException e){
           con.rollback();
           e.printStackTrace();
       }finally {
           JdbcUtil.release(con,null,null);
       }
        return list;
    }
//更改成功返回true  失败返回false
    @Override
    public boolean modifyState(int id) throws SQLException {
        boolean check=true;
        try {
            SendMedicalDao smd=new SendMedicalDao();
            con=JdbcUtil.getConnection();
            smd.setConnection(con);
            con.setAutoCommit(false);
            smd.modifyStatus(id);
            con.commit();
        } catch (SQLException e) {
            con.rollback();
            check=false;
            e.printStackTrace();
        }finally {
            return check;
        }
    }
}
