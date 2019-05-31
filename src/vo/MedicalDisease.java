package vo;

import java.util.Date;

/**
 * 实体类：诊断类
 */
public class MedicalDisease {
    private int id;//主键
    private int medicalID;//病例id
    private int registID;//挂号id
    private int disaseID;//疾病id
    private int diagnoseType;//诊断类型
    private Date getSiskDate;//发病日期
    private int diagnoseCate;//诊断种类

    public MedicalDisease() {
    }

    public MedicalDisease(int medicalID, int registID, int disaseID, int diagnoseType, Date getSiskDate, int diagnoseCate) {
        this.medicalID = medicalID;
        this.registID = registID;
        this.disaseID = disaseID;
        this.diagnoseType = diagnoseType;
        this.getSiskDate = getSiskDate;
        this.diagnoseCate = diagnoseCate;
    }

    public int getMedicalID() {
        return medicalID;
    }

    public void setMedicalID(int medicalID) {
        this.medicalID = medicalID;
    }

    public int getRegistID() {
        return registID;
    }

    public void setRegistID(int registID) {
        this.registID = registID;
    }

    public int getDisaseID() {
        return disaseID;
    }

    public void setDisaseID(int disaseID) {
        this.disaseID = disaseID;
    }

    public int getDiagnoseType() {
        return diagnoseType;
    }

    public void setDiagnoseType(int diagnoseType) {
        this.diagnoseType = diagnoseType;
    }

    public Date getGetSiskDate() {
        return getSiskDate;
    }

    public void setGetSiskDate(Date getSiskDate) {
        this.getSiskDate = getSiskDate;
    }

    public int getDiagnoseCate() {
        return diagnoseCate;
    }

    public void setDiagnoseCate(int diagnoseCate) {
        this.diagnoseCate = diagnoseCate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MedicalDisease{" +
                "id=" + id +
                ", medicalID=" + medicalID +
                ", registID=" + registID +
                ", disaseID=" + disaseID +
                ", diagnoseType=" + diagnoseType +
                ", getSiskDate=" + getSiskDate +
                ", diagnoseCate=" + diagnoseCate +
                '}';
    }
}
