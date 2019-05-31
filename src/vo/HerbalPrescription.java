package vo;

import java.util.Date;

/*
    患者草药处方
 */
public class HerbalPrescription {
    private int id;
    //病历ID
    private int medicalID;
    //挂号ID
    private int registID;
    //开立医生ID
    private int doctorID;
    //处方名称
    private String prescriptionName;
    //开立时间
    private Date creationTime;
    //处方类型
    private String prescriptioType;
    //付数
    private int payNumber;
    //频次
    private String frequency;
    //用法
    private String drugsUsage;
    //治法
    private String therapy;
    //治法详细
    private String detailed;
    //医嘱
    private String advice;
    //状态
    private int state;

    public HerbalPrescription() {
    }

    public HerbalPrescription(int medicalID, int registID, int doctorID, String prescriptionName, Date creationTime, String prescriptioType, int payNumber, String frequency, String drugsUsage, String therapy, String detailed, String advice, int state) {
        this.medicalID = medicalID;
        this.registID = registID;
        this.doctorID = doctorID;
        this.prescriptionName = prescriptionName;
        this.creationTime = creationTime;
        this.prescriptioType = prescriptioType;
        this.payNumber = payNumber;
        this.frequency = frequency;
        this.drugsUsage = drugsUsage;
        this.therapy = therapy;
        this.detailed = detailed;
        this.advice = advice;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public String getPrescriptionName() {
        return prescriptionName;
    }

    public void setPrescriptionName(String prescriptionName) {
        this.prescriptionName = prescriptionName;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public String getPrescriptioType() {
        return prescriptioType;
    }

    public void setPrescriptioType(String prescriptioType) {
        this.prescriptioType = prescriptioType;
    }

    public int getPayNumber() {
        return payNumber;
    }

    public void setPayNumber(int payNumber) {
        this.payNumber = payNumber;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getDrugsUsage() {
        return drugsUsage;
    }

    public void setDrugsUsage(String drugsUsage) {
        this.drugsUsage = drugsUsage;
    }

    public String getTherapy() {
        return therapy;
    }

    public void setTherapy(String therapy) {
        this.therapy = therapy;
    }

    public String getDetailed() {
        return detailed;
    }

    public void setDetailed(String detailed) {
        this.detailed = detailed;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "HerbalPrescription{" +
                "id=" + id +
                ", medicalID=" + medicalID +
                ", registID=" + registID +
                ", doctorID=" + doctorID +
                ", prescriptionName='" + prescriptionName + '\'' +
                ", creationTime=" + creationTime +
                ", prescriptioType='" + prescriptioType + '\'' +
                ", payNumber=" + payNumber +
                ", frequency='" + frequency + '\'' +
                ", drugsUsage='" + drugsUsage + '\'' +
                ", therapy='" + therapy + '\'' +
                ", detailed='" + detailed + '\'' +
                ", advice='" + advice + '\'' +
                ", state=" + state +
                '}';
    }
}
