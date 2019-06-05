package service.registservice;

import vo.*;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public interface IRegistService {
    /**
     * @Author lym
     * @Description:页面加载的时候返回两个字符--发票号--病历号
     * @Param name
     * @return java.util.List<java.lang.String>
    **/
    List<String> MaxInvoceAndCaseNumber(String name) throws SQLException;
    /**
     * @Author lym
     * @Description:通过病历号查找以前的一些挂号信息
     * @Param [caseNumber]
     * @return vo.Register
    **/
    Register findRegisterByCaseNumber(String caseNumber) throws SQLException;
    /**
     * @Author lym
     * @Description通过日期查询一生的排班信息
     * @Param [date]
     * @return vo.DoctorCrew
    **/
    List<DoctorCrew> findDocCrew(Date date);
    /**
     * @Author lym
     * @Description
     * @Param [userName, visidate]
     * @return int
     **/
    int findUsedQuto(String userName,Date visidate);
    /**
     * @Author lym
     * @Description :挂号开始--1判断医生的额度是否还有  1--有 插入  没有 不插入（返回fasle）
     *                        2 插入病例后。。开发票
     *                        3在患者记录明细里面加入新的费用记录
     * @Param [register]
     * @return boolean
    **/
    boolean registered(Register register, DoctorCrew doctorCrew, Invoice iv, PatientCosts pc);
    /**
     * @Author lym
     * @Description：收费方式有多少种--！！！！
     * @Param []
     * @return java.util.List<vo.ConstantItem>
    **/
    List<ConstantItem> fianShouFeiFangShi();
}
