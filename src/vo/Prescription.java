package vo;

import java.util.Date;

/**
 * 实体类：患者成药处方表
 */
public class Prescription {
    private int id;//主键
    private int medicalID;//病历id
    private int regitID;//挂号id
    private int userID;//开立医生
    private String prescriptionName;//处方名称
    private Date prescriptionTime;//开立时间
    private int prescriptionState;//处方状态

    public Prescription() {
    }

    public Prescription(int medicalID, int regitID, int userID, String prescriptionName, Date prescriptionTime, int prescriptionState) {
        this.medicalID = medicalID;
        this.regitID = regitID;
        this.userID = userID;
        this.prescriptionName = prescriptionName;
        this.prescriptionTime = prescriptionTime;
        this.prescriptionState = prescriptionState;
    }

    public int getMedicalID() {
        return medicalID;
    }

    public void setMedicalID(int medicalID) {
        this.medicalID = medicalID;
    }

    public int getRegitID() {
        return regitID;
    }

    public void setRegitID(int regitID) {
        this.regitID = regitID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getPrescriptionName() {
        return prescriptionName;
    }

    public void setPrescriptionName(String prescriptionName) {
        this.prescriptionName = prescriptionName;
    }

    public Date getPrescriptionTime() {
        return prescriptionTime;
    }

    public void setPrescriptionTime(Date prescriptionTime) {
        this.prescriptionTime = prescriptionTime;
    }

    public int getPrescriptionState() {
        return prescriptionState;
    }

    public void setPrescriptionState(int prescriptionState) {
        this.prescriptionState = prescriptionState;
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "id=" + id +
                ", medicalID=" + medicalID +
                ", regitID=" + regitID +
                ", userID=" + userID +
                ", prescriptionName='" + prescriptionName + '\'' +
                ", prescriptionTime=" + prescriptionTime +
                ", prescriptionState=" + prescriptionState +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
