package service.registservice;

import dao.registdao.ExistRegistDao;
import dao.registdao.IExistRegistDao;
import dao.registdao.IRegistDao;
import dao.registdao.RegistDao;
import util.JdbcUtil;
import vo.Invoice;
import vo.PatientCosts;
import vo.Register;

import java.sql.Connection;
import java.sql.SQLException;

public class ExistRegistService implements IExistRegistService {
    private Connection con= JdbcUtil.getConnection();
    /**
     * @Author lym通过病历号查询一个挂号信息
     * @Description
     * @Param [caseNumber]
     * @return vo.Register
    **/
    @Override
    public Register findRegister(String caseNumber) {
        RegistDao registDao=new RegistDao();
        registDao.setConnection(con);
        Register register=null;
        try {
            register=registDao.reRegisterByCaseNumber(caseNumber);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return register;
    }
    /**
     * @Author lym
     * @Description:患者退药 1只有患者的看诊状态为1（已挂号）
     *                         才能退号退好成功之后才能打印冲红发票以及增加患者的费用明细
     *                         之后返回true--
     *                       2不是返回false---
     * @Param [caseNumber, iv, pc]
     * @return boolean
    **/
    @Override
    public boolean existRegist(String caseNumber, Invoice iv, PatientCosts pc) {
        IRegistDao registDao=new RegistDao();
        registDao.setConnection(con);
        IExistRegistDao existRegistDao=new ExistRegistDao();
        existRegistDao.setCon(con);
        Register register=null;
        try {
            register=registDao.reRegisterByCaseNumber(caseNumber);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (register.getVisitState()==1){
            try {
                existRegistDao.changeByCaseNumber(caseNumber);
                registDao.addPatientCosts(pc);
                registDao.addInvoice(iv);
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        JdbcUtil.release(con,null,null);
        return false;
    }
}
