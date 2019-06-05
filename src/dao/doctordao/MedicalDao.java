package dao.doctordao;

import util.JdbcUtil;
import vo.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 病历
 */
public class MedicalDao implements IMedicalDao {
    Connection con=null;
    @Override
    public void setConnection(Connection con) {
        this.con=con;
    }

    /**
     * 通过医生ID查病历
     * @param userid
     * @return
     * @throws SQLException
     */
    @Override
    public List<MedicalRecord> selectMedicalByUserID(int userid) throws SQLException {
        String sql="select m.*,r.RealName,r.Gender,r.Age from register r,medicalrecord m where m.RegistID=r.ID and r.UserID=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setInt(1,userid);
        ResultSet rs=pstmt.executeQuery();
        List<MedicalRecord> list=new ArrayList<>();
        MedicalRecord mr=null;
        while (rs.next()){
            mr=new MedicalRecord();
            mr.setId(rs.getInt(1));
            mr.setCaseNumber(rs.getString(2));
            mr.setRegisterID(rs.getInt(3));
            mr.setReadme(rs.getString(4));
            mr.setPresent(rs.getString(5));
            mr.setPresentTreat(rs.getString(6));
            mr.setHistory(rs.getString(7));
            mr.setAllergy(rs.getString(8));
            mr.setPhysique(rs.getString(9));
            mr.setProposal(rs.getString(10));
            mr.setCareful(rs.getString(11));
            mr.setCheckResult(rs.getString(12));
            mr.setDiagnosis(rs.getString(13));
            mr.setHandling(rs.getString(14));
            mr.setCaseState(rs.getInt(15));
            mr.setRealName(rs.getString(16));
            mr.setGender(rs.getInt(17));
            mr.setAge(rs.getInt(18));
            list.add(mr);
        }
        JdbcUtil.release(null,pstmt,rs);
        return list;
    }

    /**
     * 通过科室ID查病历
     * @param deptid
     * @return
     * @throws SQLException
     */
    @Override
    public List<MedicalRecord> selectMedicalByDeptID(int deptid) throws SQLException {
        String sql="select m.*,r.RealName,r.Gender,r.Age from register r,medicalrecord m where m.RegistID=r.ID and r.DeptID=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setInt(1,deptid);
        ResultSet rs=pstmt.executeQuery();
        List<MedicalRecord> list=new ArrayList<>();
        MedicalRecord mr=null;
        while (rs.next()){
            mr=new MedicalRecord();
            mr.setId(rs.getInt(1));
            mr.setCaseNumber(rs.getString(2));
            mr.setRegisterID(rs.getInt(3));
            mr.setReadme(rs.getString(4));
            mr.setPresent(rs.getString(5));
            mr.setPresentTreat(rs.getString(6));
            mr.setHistory(rs.getString(7));
            mr.setAllergy(rs.getString(8));
            mr.setPhysique(rs.getString(9));
            mr.setProposal(rs.getString(10));
            mr.setCareful(rs.getString(11));
            mr.setCheckResult(rs.getString(12));
            mr.setDiagnosis(rs.getString(13));
            mr.setHandling(rs.getString(14));
            mr.setCaseState(rs.getInt(15));
            mr.setRealName(rs.getString(16));
            mr.setGender(rs.getInt(17));
            mr.setAge(rs.getInt(18));
            list.add(mr);
        }
        JdbcUtil.release(null,pstmt,rs);
        return list;
    }

    /**
     * 修改病历首页
     * @param me
     * @throws SQLException
     */
    @Override
    public void updateMedicalHome(MedicalRecord me) throws SQLException {
        String sql="update medicalrecord set Readme=?,Present=?,PresentTreat=?,History=?,Allergy=?,Physique=?,Proposal=?,Careful=?,CaseState=2 where ID=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,me.getReadme());
        pstmt.setString(2,me.getPresent());
        pstmt.setString(3,me.getPresentTreat());
        pstmt.setString(4,me.getHistory());
        pstmt.setString(5,me.getAllergy());
        pstmt.setString(6,me.getPhysique());
        pstmt.setString(7,me.getProposal());
        pstmt.setString(8,me.getCareful());
        pstmt.setInt(9,me.getId());
        pstmt.executeUpdate();
        JdbcUtil.release(null,pstmt,null);
    }

    /**
     * 修改病历其他内容
     * @param me
     * @throws SQLException
     */
    @Override
    public void updaMedical(MedicalRecord me) throws SQLException {
        String sql="update medicalrecord CheckResult=?,Diagnosis=?,Handling=? set where ID=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,me.getCheckResult());
        pstmt.setString(2,me.getDiagnosis());
        pstmt.setString(3,me.getHandling());
        pstmt.setInt(4,me.getId());
        pstmt.executeUpdate();
        JdbcUtil.release(null,pstmt,null);
    }

    /**
     * 查询检查、检验、处置医技
     * @param recordtype
     * @param name
     * @return
     * @throws SQLException
     */
    @Override
    public List<NoDrug> selectExamine(int recordtype,String name) throws SQLException {
        String sql="SELECT F.ID,F.ItemCode,F.ItemName,F.Format,F.Price,F.ExpClassID,F.DeptID,F.MnemonicCode,F.CreationDate,F.LastUpdateDate,F.RecordType,F.DelMark,E.ExpName,D.DeptName\n" +
                "from Fmeditem F,ExpenseClass E,Department D\n" +
                "where F.ExpClassID = E.ID\n" +
                "and F.DeptID = D.ID\n" +
                "and F.DelMark=1\n" +
                "and RecordType=?";
        PreparedStatement pstmt=null;
        if(name!=null && name.length()!=0){
            sql+="and (F.MnemonicCode like \"%\"?\"%\" or F.ItemName like \"%\"?\"%\")";
            pstmt=con.prepareStatement(sql);
            pstmt.setInt(1,recordtype);
            pstmt.setString(2,name);
            pstmt.setString(3,name);
        }else {
            pstmt=con.prepareStatement(sql);
            pstmt.setInt(1,recordtype);
        }
        ResultSet rs=pstmt.executeQuery();
        List<NoDrug> list=new ArrayList<>();
        NoDrug nodrug=null;
        while (rs.next()){
            nodrug=new NoDrug();
            nodrug.setId(rs.getInt(1));
            nodrug.setItemCode(rs.getString(2));
            nodrug.setItemName(rs.getString(3));
            nodrug.setFormat(rs.getString(4));
            nodrug.setPrice(rs.getDouble(5));
            nodrug.setExpClassID(rs.getInt(6));
            nodrug.setDeptID(rs.getInt(7));
            nodrug.setMnemonicCode(rs.getString(8));
            nodrug.setCreationDate(rs.getDate(9));
            nodrug.setLastUpdateDate(rs.getDate(10));
            nodrug.setRecordType(rs.getInt(11));
            nodrug.setDelMark(rs.getInt(12));
            nodrug.setExpName(rs.getString(13));
            nodrug.setDeptName(rs.getString(14));
            list.add(nodrug);
        }
        JdbcUtil.release(null,pstmt,rs);
        return list;
    }

    /**
     * 通过病历ID查询患者检查、检验、处置申请
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public List<CheckApply> selectCheckApply(int id,int type) throws SQLException {
        String sql="select c.*,f.ItemName, f.Price,d.DeptName\n" +
                "from checkapply c,fmeditem f,department d \n" +
                "where f.ID=c.ItemID and f.DeptID=d.ID and c.MedicalID=? and c.RecordType=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setInt(1,id);
        pstmt.setInt(2,type);
        ResultSet rs=pstmt.executeQuery();
        List<CheckApply> list=new ArrayList<>();
        CheckApply ca=null;
        while (rs.next()){
            ca=new CheckApply();
            ca.setId(rs.getInt(1));
            ca.setMedicalID(rs.getInt(2));
            ca.setRegistID(rs.getInt(3));
            ca.setItemID(rs.getByte(4));
            ca.setName(rs.getString(5));
            ca.setObjective(rs.getString(6));
            ca.setPosition(rs.getString(7));
            ca.setIsUrgent(rs.getInt(8));
            ca.setNum(rs.getInt(9));
            ca.setCreationTime(rs.getDate(10));
            ca.setDoctorID(rs.getInt(11));
            ca.setCheckOperID(rs.getInt(12));
            ca.setResultOperID(rs.getInt(13));
            ca.setCheckTime(rs.getDate(14));
            ca.setResult(rs.getString(15));
            ca.setResultTime(rs.getDate(16));
            ca.setState(rs.getInt(17));
            ca.setRecordType(rs.getInt(18));
            ca.setItemName(rs.getString(19));
            ca.setPrice(rs.getDouble(20));
            ca.setDeptName(rs.getString(21));
            list.add(ca);
        }
        JdbcUtil.release(null,pstmt,rs);
        return list;
    }

    /**
     * 新增检查、检验、处置申请
     * @param checkApply
     * @throws SQLException
     */
    @Override
    public void addCheckApply(CheckApply checkApply) throws SQLException {
        String sql="insert CheckApply(MedicalID,RegistID,ItemID,Name,Objective,Position,IsUrgent,CreationTime,CheckOperID,ResultOperID,State,RecordType) values(?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setInt(1,checkApply.getMedicalID());
        pstmt.setInt(2,checkApply.getRegistID());
        pstmt.setInt(3,checkApply.getItemID());
        pstmt.setString(4,checkApply.getName());
        pstmt.setObject(5,checkApply.getObjective());
        pstmt.setString(6,checkApply.getPosition());
        pstmt.setInt(7,checkApply.getIsUrgent());
        java.sql.Date creationTime=new java.sql.Date(checkApply.getCreationTime().getTime());
        pstmt.setDate(8,creationTime);
        pstmt.setInt(9,checkApply.getCheckOperID());
        pstmt.setInt(10,checkApply.getResultOperID());
        pstmt.setInt(11,checkApply.getState());
        pstmt.setInt(12,checkApply.getRecordType());
        pstmt.executeUpdate();
        JdbcUtil.release(null,pstmt,null);
    }

    /**
     * 查询所有成药有效处方
     * @return
     * @throws SQLException
     */
    @Override
    public List<Prescription> selectPrescription() throws SQLException {
        String sql="select * from prescription where PrescriptionState in (1,2)";
        PreparedStatement pstmt=con.prepareStatement(sql);
        ResultSet rs=pstmt.executeQuery();
        List<Prescription> list=new ArrayList<>();
        Prescription pre=null;
        while (rs.next()){
            pre=new Prescription();
            pre.setId(rs.getInt(1));
            pre.setMedicalID(rs.getInt(2));
            pre.setRegitID(rs.getInt(3));
            pre.setUserID(rs.getInt(4));
            pre.setPrescriptionName(rs.getString(5));
            pre.setPrescriptionTime(rs.getDate(6));
            pre.setPrescriptionState(rs.getInt(7));
            list.add(pre);
        }
        JdbcUtil.release(null,pstmt,rs);
        return list;
    }

    /**
     * 新增成药处方
     * @param pre
     * @throws SQLException
     */
    @Override
    public void addPrescription(Prescription pre) throws SQLException {
        String sql="insert prescription(MedicalID,RegistID,UserID,PrescriptionName,PrescriptionTime,PrescriptionState) values(?,?,?,?,?,1)";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setInt(1,pre.getMedicalID());
        pstmt.setInt(2,pre.getRegitID());
        pstmt.setInt(3,pre.getUserID());
        pstmt.setString(4,pre.getPrescriptionName());
        java.sql.Date PrescriptionTime=new java.sql.Date(pre.getPrescriptionTime().getTime());
        pstmt.setDate(5,PrescriptionTime);
        pstmt.executeUpdate();
        JdbcUtil.release(null,pstmt,null);
    }

    /**
     * 根据成药处方ID查询处方明细
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public List<PrescriptionDetailed> selectPrescriptionDetailed(int id) throws SQLException {
        String sql="select p.*,d.DrugsName from prescriptiondetailed p,drugs d where d.ID=p.DrugsID and PrescriptionID=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setInt(1,id);
        ResultSet rs=pstmt.executeQuery();
        List<PrescriptionDetailed> list=new ArrayList<>();
        PrescriptionDetailed pre=null;
        while (rs.next()){
            pre=new PrescriptionDetailed();
            pre.setId(rs.getInt(1));
            pre.setPrescriptionID(rs.getInt(2));
            pre.setDrugsID(rs.getInt(3));
            pre.setDrugsUsage(rs.getString(4));
            pre.setDosage(rs.getString(5));
            pre.setFrequency(rs.getString(6));
            pre.setAmount(rs.getDouble(7));
            pre.setState(rs.getInt(8));
            pre.setDrugsName(rs.getString(9));
            list.add(pre);
        }
        JdbcUtil.release(null,pstmt,rs);
        return list;
    }

    /**
     * 成药处方新增药品
     * @param pd
     * @throws SQLException
     */
    @Override
    public void addPrescriptionDetailed(PrescriptionDetailed pd) throws SQLException {
        String sql="insert prescriptiondetailed(PrescriptionID,DrugsID,DrugsUsage,Dosage,Frequency,Amount,State) vaules(?,?,?,?,?,?,?)";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setInt(1,pd.getPrescriptionID());
        pstmt.setInt(2,pd.getDrugsID());
        pstmt.setString(3,pd.getDrugsUsage());
        pstmt.setString(4,pd.getDosage());
        pstmt.setString(5,pd.getFrequency());
        pstmt.setDouble(6,pd.getAmount());
        pstmt.setInt(7,pd.getState());
        pstmt.executeUpdate();
        JdbcUtil.release(null,pstmt,null);
    }

    /**
     * 查询所有草药有效处方
     * @return
     * @throws SQLException
     */
    @Override
    public List<HerbalPrescription> selectHerbalPrescription() throws SQLException {
        String sql="select * from herbalprescription ";
        PreparedStatement pstmt=con.prepareStatement(sql);
        ResultSet rs=pstmt.executeQuery();
        List<HerbalPrescription> list=new ArrayList<>();
        HerbalPrescription hp=null;
        while (rs.next()){
            hp=new HerbalPrescription();
            hp.setId(rs.getInt(1));
            hp.setMedicalID(rs.getInt(2));
            hp.setRegistID(rs.getInt(3));
            hp.setUserID(rs.getInt(4));
            hp.setPrescriptionName(rs.getString(5));
            hp.setCreationTime(rs.getDate(6));
            hp.setPrescriptioType(rs.getString(7));
            hp.setPayNumber(rs.getInt(8));
            hp.setFrequency(rs.getString(9));
            hp.setDrugsUsage(rs.getString(10));
            hp.setTherapy(rs.getString(11));
            hp.setDetailed(rs.getString(12));
            hp.setAdvice(rs.getString(13));
            hp.setState(rs.getInt(14));
            list.add(hp);
        }
        JdbcUtil.release(null,pstmt,rs);
        return list;
    }

    /**
     * 根据草药处方ID查询处方明细
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public List<HerbalDetailed> selectHerbalDetailed(int id) throws SQLException {
        String sql="select h.*,d.DrugsName from herbaldetailed h,drugs d where d.ID=h.HerbalID and HerbalPresID=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setInt(1,id);
        ResultSet rs=pstmt.executeQuery();
        List<HerbalDetailed> list=new ArrayList<>();
        HerbalDetailed hd=null;
        while (rs.next()){
            hd=new HerbalDetailed();
            hd.setId(rs.getInt(1));
            hd.setHerbalPresID(rs.getInt(2));
            hd.setHerbalID(rs.getInt(3));
            hd.setDosage(rs.getString(4));
            hd.setPrice(rs.getDouble(5));
            hd.setFootnote(rs.getString(6));
            hd.setHerbalName(rs.getString(7));
            list.add(hd);
        }
        JdbcUtil.release(null,pstmt,rs);
        return list;
    }

    /**
     * 患者费用查询
     * @return
     * @throws SQLException
     */
    @Override
    public List<PatientCosts> selectPatientCosts() throws SQLException {
        return null;
    }
}
