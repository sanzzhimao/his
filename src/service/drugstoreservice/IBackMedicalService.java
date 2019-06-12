package service.drugstoreservice;

import vo.SendMedical;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface IBackMedicalService {
    //通过病例号查询和时间查询已发药 药品和处方信息
    List<SendMedical> selectSendMedicalService(String st, String date) throws SQLException, ParseException;
    //通过病例号查
    List<SendMedical> selectSendMedicalService2(String st) throws SQLException, ParseException;
    //发药成功改变处方明细状态为未发药
    boolean modifyState(int id) throws SQLException;
}
