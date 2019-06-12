package dao.doctordao;

import vo.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface IMedicalDao {
    void setConnection(Connection con);

    //通过医生ID查病历
    List<MedicalRecord> selectMedical() throws SQLException;

    //通过科室ID查病历
    MedicalRecord selectMedicalByID(int id) throws SQLException;

    //修改病历首页
    void updateMedicalHome(MedicalRecord me) throws SQLException;

    //修改病历其他内容
    void updaMedical(MedicalRecord me) throws SQLException;

    //查询检查、检验、处置医技
    List<NoDrug> selectExamine(int recordtype,String name) throws  SQLException;

    //通过病历ID查询患者检查、检验、处置申请
    List<CheckApply> selectCheckApply(int id,int type) throws  SQLException;

    //增加检查、检验、处置申请
    void addCheckApply(CheckApply checkApply) throws SQLException;

    //查询所有成药有效处方
    List<Prescription> selectPrescription() throws SQLException;

    //新增成药处方
    void addPrescription(Prescription pre) throws SQLException;

    //根据成药处方ID查询处方明细
    List<PrescriptionDetailed> selectPrescriptionDetailed(int id) throws SQLException;

    //成药处方新增药品
    void addPrescriptionDetailed(PrescriptionDetailed pd) throws SQLException;

    //查询所有草药有效处方
    List<HerbalPrescription> selectHerbalPrescription() throws  SQLException;

    //根据草药处方ID查询处方明细
    List<HerbalDetailed> selectHerbalDetailed(int id) throws SQLException;

    //患者费用查询
    List<PatientCosts> selectPatientCosts() throws SQLException;
}
