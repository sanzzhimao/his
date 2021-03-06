/*
药房发药接口
何金华
 */
package dao.drugstoredao;

import vo.SendMedical;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface ISendMedicalDao {
    void setConnection(Connection con);
    //根据病历号核时间查询药品名字，单价，数量，药品状态，开立医生，处方名字，开立时间
    List<SendMedical> sendMedical(String st,String date) throws SQLException, ParseException;
    //根据病例号查
    List<SendMedical> sendMedical2(String st) throws SQLException, ParseException;
    //开药成功改变处方明细状态
    void modifyStatus(int id) throws SQLException;
}
