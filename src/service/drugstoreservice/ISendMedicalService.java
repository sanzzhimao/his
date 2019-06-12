/*
发药管理服务层
何金华
 */
package service.drugstoreservice;

import vo.SendMedical;


import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface ISendMedicalService {
    //通过病例号查询和时间查询药品和处方信息
    List<SendMedical> selectSendMedicalService(String st, String date) throws SQLException, ParseException;
    //通过病例号查询
    List<SendMedical> selectSendMedicalService2(String st) throws SQLException, ParseException;
    //发药成功改变处方明细状态为已发药
    boolean modifyState(int id) throws SQLException;
}
