package service.fmeditemservice;

import dao.fmeditemdao.CostsDao;
import dao.fmeditemdao.ICostsDao;
import dao.registdao.RegistDao;
import util.JdbcUtil;
import vo.Invoice;
import vo.PatientCosts;
import vo.PatientInfo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CostsService implements ICostsService{
    Connection con= JdbcUtil.getConnection();
    /**
     * @Author lym
     * @Description找到病人的相关信息
     * @Param [caseNumber]
     * @return java.util.List<vo.PatientInfo>
    **/
  public List<PatientInfo> findPatientInfoByCaseNumber(String caseNumber){
        ICostsDao costsDao=new CostsDao();
        costsDao.setCon(con);
      List list= null;
      try {
          list = costsDao.selectPatientInfoByCaseNumber(caseNumber);
      } catch (SQLException e) {
          e.printStackTrace();
      }
      return list;
    }
    /**
     * @Author lym
     * @Description开发票--同时加入患者明细表--
     * @Param [iv]
     * @return void
    **/
    @Override
    public void addIvoice(Invoice iv,PatientCosts pc) {
        RegistDao registDao=new RegistDao();
          registDao.setConnection(con);
        try {
            registDao.addInvoice(iv);
            registDao.addPatientCosts(pc);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
    }

}
