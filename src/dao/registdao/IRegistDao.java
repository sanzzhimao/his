package dao.registdao;

import vo.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author lym
 * @Description:挂号接口
 * @Param
 * @return
**/
public interface IRegistDao {
    /**
     * @Author lym
     * @Description:设置con
     * @Param [con]
     * @return void
    **/
    void setConnection(Connection con);
    /**
     * @Author lym
     * @Description：读取最大发票号
     * @Param [id]
     * @return java.lang.String
    **/
    String selectMaxInvoiceNum(int id) throws SQLException;
    /**
     * @Author lym
     * @Description:读取当前的最大病历号
     * @Param []
     * @return java.lang.String
    **/
    String selectCaseNumber()throws SQLException;
    /**
     * @Author lym
     * @Description:查询有效的结算类别
     * @Param []
     * @return vo.SettleCategory
    **/
    List<SettleCategory> selectSettleCategory() throws SQLException;
    /**
     * @Author lym
     * @Description：查询有效的挂号级别
     * @Param []
     * @return vo.RegistLevel
    **/
    List<RegistLevel> selectRegistLevel() throws SQLException;
    /**
     * @Author lym
     * @Description:通过id去查询挂号费和初始号额度
     * @Param [id]
     * @return vo.RegistLevel
    **/
    RegistLevel selectRegistLevelById(int id) throws SQLException;
    /**
     * @Author lym
     * @Description:读取有效的临床科室
     * @Param []
     * @return java.util.List<vo.Department>
    **/
    List<Department>selectDepartment() throws SQLException;
    /**
     * @Author lym
     * @Description:找出医生的id和姓名
     * @Param []
     * @return java.util.List<vo.User>
    **/
    List<User>selectDoctorInfo(Register register)throws SQLException;
    /**
     * @Author lym
     * @Description:通过医生的id和看诊的时间查找已经用去的名额
     * @Param [userID, date]
     * @return int
    **/
     int selectDoctorUsedId(int userID, Date date) throws SQLException;
     /**
      * @Author lym
      * @Description:插入一个挂号病人
      * @Param [reg]
      * @return java.lang.Boolean
     **/
     Boolean addRegist(Register reg) throws SQLException;
     /**
      * @Author lym
      * @Description：记录使用的发票(加入)
      * @Param [iv]
      * @return boolean
     **/
     boolean addInvoice(Invoice iv) throws SQLException;
     /**
      * @Author lym
      * @Description:记录患者的情况
      * @Param [pc]
      * @return void
     **/
    boolean addPatientCosts(PatientCosts pc) throws SQLException;
    /**
     * @Author lym
     * @Description:通过病历号去查询未看诊的挂号记录
     * @Param [caseNumber]
     * @return vo.Register
    **/
    Register reRegisterByCaseNumber(String caseNumber) throws SQLException;
    /**
     * @Author lym
     * @Description：通过医生名字（登录名）找到id
     * @Param [name]
     * @return int
     **/
    int selectUserIDByUserName(String name) throws SQLException;
    /**
     * @Author lym
     * @Description:通过收费方式的名字找到其id
     * @Param [constantName]
     * @return int
    **/
    int selectConstantIDByConstantName(String constantName) throws  SQLException;
    int selectRegistID(String caseNum,String visitDate) throws SQLException;
    boolean addmedical(MedicalRecord medicalRecord) throws SQLException;
}
