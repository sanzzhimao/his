package service.registservice;

import dao.registdao.IRegistDao;
import dao.registdao.RegistDao;
import util.JdbcUtil;
import vo.Register;

import java.sql.Connection;
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
    public List<String> MaxInvoceAndCaseNumber(String name) throws SQLException {
        IRegistDao registDao=new RegistDao();
        registDao.setConnection(con);
        int userid=registDao.selectUserIDByUserName(name);
        String invoicenum=registDao.selectMaxInvoiceNum(userid);
        String caseNumberr=registDao.selectCaseNumber();
        List<String> list=new LinkedList<>();
        list.add(invoicenum);
        list.add(caseNumberr);
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
    public Register findRegisterByCaseNumber(String caseNumber) throws SQLException {
        IRegistDao registDao=new RegistDao();
        registDao.setConnection(con);
        Register register=registDao.reRegisterByCaseNumber(caseNumber);
        JdbcUtil.release(con,null,null);
        return register;
    }

}
