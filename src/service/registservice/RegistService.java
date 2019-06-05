package service.registservice;

import dao.informationdao.ConstantTypeDao;
import dao.informationdao.DoctorCrewDao;
import dao.informationdao.IDoctorCrewDao;
import dao.registdao.IRegistDao;
import dao.registdao.RegistDao;
import org.omg.CORBA.INV_FLAG;
import util.JdbcUtil;
import vo.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class RegistService implements IRegistService{
    Connection con= JdbcUtil.getConnection();
    /**
     * @Author lym
     * @Description:这个参数是挂号人的name医院的工作人员）
     * @Param [userid]
     * @return java.util.List<java.lang.String>
    **/
    @Override
    public List<String> MaxInvoceAndCaseNumber(String name)  {
        IRegistDao registDao=new RegistDao();
        registDao.setConnection(con);
        int userid= 0;
        List<String> list=new LinkedList<>();
        try {
            userid = registDao.selectUserIDByUserName(name);
            String invoicenum=registDao.selectMaxInvoiceNum(userid);
            String caseNumberr=registDao.selectCaseNumber();
            list.add(invoicenum);
            list.add(caseNumberr);
        } catch (SQLException e) {
            e.printStackTrace();
        }



        JdbcUtil.release(con,null,null);
        return list;
    }
    /**
     * @Author lym
     * @Description:通过病历号查找以前的一些挂号信息
     * @Param [caseNumber]
     * @return vo.Register
     **/
    @Override
    public Register findRegisterByCaseNumber(String caseNumber) {
        IRegistDao registDao=new RegistDao();
        registDao.setConnection(con);
        Register register= null;
        try {
            register = registDao.reRegisterByCaseNumber(caseNumber);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JdbcUtil.release(con,null,null);
        return register;
    }
    /**
     * @Author lym
     * @Description:通过日期查到一生的排班信息
     * @Param [date]
     * @return java.util.List<vo.DoctorCrew>
    **/
    @Override
    public List<DoctorCrew> findDocCrew(Date date) {
        IDoctorCrewDao doctorCrewDao=new DoctorCrewDao();
        doctorCrewDao.setConnection(con);
        List<DoctorCrew> list=null;
        try {
            list=doctorCrewDao.selectDoctorCrew(date,date);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
        return list;
    }
    /**
     * @Author lym
     * @Description
     * @Param [userName, visidate]
     * @return int
     **/
    public int findUsedQuto(String userName, Date visidate){
        IRegistDao registDao=new RegistDao();
        registDao.setConnection(con);
        int userID =0;
        int num=0;
        try {
            userID=registDao.selectUserIDByUserName(userName);
            num=registDao.selectDoctorUsedId(userID,visidate);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
        return num;
    }
    /**
     * @Author lym
     * @Description :挂号开始--1判断医生的额度是否还有  1--有 插入  没有 不插入（返回fasle）
     *                        2 插入病例后。。开发票
     *                        3在患者记录明细里面加入新的费用记录
     * @Param [register]
     * @return boolean
     **/
    @Override
    public boolean registered(Register register, DoctorCrew doctorCrew, Invoice iv, PatientCosts pc) {
        IRegistDao registDao=new RegistDao();
        registDao.setConnection(con);
        int num=0;
        int num1=0;
        try {
            num=registDao.selectDoctorUsedId(register.getUserID(), (Date) doctorCrew.getSchedDate());
            if (num1<= num){
                registDao.addRegist(register);
                registDao.addInvoice(iv);
                registDao.addPatientCosts(pc);
                return  true;
            }else{
                return  false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.release(con,null,null);
        }
        return false;
    }
    /**
     * @Author lym
     * @Description：收费方式有多少种--！！！！
     * @Param []
     * @return java.util.List<vo.ConstantItem>
     **/
    @Override
    public List<ConstantItem> fianShouFeiFangShi() {
        ConstantTypeDao constantTypeDao=new ConstantTypeDao();
        constantTypeDao.setConnection(con);
        List<ConstantItem> list=null;
        try {
            list=constantTypeDao.selectAllConstantItem("收费方式");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
