package dao.fmeditemdao;

import vo.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author lym
 * @Description:患者检验接口---CheckAppley的recordType为（1代表检查   ---2 代表检验  ---3代表处置）
 *  * state状态的表示--
 *  * 1-暂存
 *  * 2-已开立
 *  * 3-已交费
 *  * 4-已登记
 *  * 5-执行完
 *  * 6-已退费
 *  * 0-已作废
**/
public interface IPatientTestDao {
    public void setCon(Connection con);
    /**
     * @Author lym
     * @Description:通过名字查询患者的信息（病历号，名字，挂号id，发票号）--发票号是多个所以我们需要用list存储
     * @Param [name]
     * @return java.util.List<vo.CheckInfo>
    **/
    List<CheckInfo> selectCheckInfoByName(String name) throws SQLException;
    /**
     * @Author lym
     * @Description:通过名字查询患者的看病信息
     * @Param [name]
     * @return vo.Register
    **/
    List<CheckInfo> selectCheckInfoByNameZhong(String name) throws SQLException;
    Register selectRegistrByname(String name) throws SQLException;
    /**
     * @Author lym
     * @Description:通过结算类别的id找到结算类别的名字
     * @Param [settleID]
     * @return java.lang.String
    **/
    String  selectsettleName(int settleID) throws SQLException;
    /**
     * @Author lym
     * @Description:通过医生的id找到医生的名字
     * @Param [docID]
     * @return java.lang.String
    **/
    String selectDocName(int docID) throws  SQLException;

    /**
     * @Author lym
     * @Description:通过名字找到对应的发票号
     * @Param [name]
     * @return java.util.List<java.lang.String>
    **/
    List<String> selectIvoiceNumberByname(String name) throws SQLException;
    /**
     * @Author lym
     * @Description:通过病历号找到检验的申请--将信息显示到下方
     * @Param [registID]
     * @return vo.CheckApply
    **/
    List<MedicalTecTest> selectCheckAppley(String registID) throws SQLException;
    /**
     * @Author lym
     * @Description通过id找到检验的申请--将信息显示到下方
     * @Param [id]
     * @return vo.CheckApply
    **/
    MedicalTecTest selectCheckAppley(int id) throws SQLException;
    /***
     * @Author lym
     * @Description:通过病历号修改检查检验的状态（检验完成后状态变成--“已执行”---）--
     * @Param [registid]
     * @return void
    **/
    void changeCheckApplyStateByRegistid(String registid) throws SQLException;
    void changeCheckApplyStateById(int id) throws SQLException;

}
