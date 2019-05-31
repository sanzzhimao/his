package vo;


import java.util.Date;

/*
处置申请表
 */
public class CheckApply {
    private int id;//id
    private int medicalID;//病例id
    private int registID;//挂号id
    private int itemID;//项目id
    private String name;//项目名字
    private String objective;//目的要求
    private String position;//检查部位
    private int isUrgent;//是非加急
    private int num;//数量
    private Date creationTime;//开立时间
    private int doctorID;//开立医生id
    private int checkOperID;//检查人员id
    private int resultOperID;//结果录入人员id
    private Date checkTime;//检查时间
    private String result;//检查结果
    private Date resultTime;//结果时间
    private int state;//状态
    private int recordType;//记录类型

    @Override
    public String toString() {
        return "CheckApply{" +
                "id=" + id +
                ", medicalID=" + medicalID +
                ", registID=" + registID +
                ", itemID=" + itemID +
                ", name='" + name + '\'' +
                ", objective='" + objective + '\'' +
                ", position='" + position + '\'' +
                ", isUrgent=" + isUrgent +
                ", num=" + num +
                ", creationTime=" + creationTime +
                ", doctorID=" + doctorID +
                ", checkOperID=" + checkOperID +
                ", resultOperID=" + resultOperID +
                ", checkTime=" + checkTime +
                ", result='" + result + '\'' +
                ", resultTime=" + resultTime +
                ", state=" + state +
                ", recordType=" + recordType +
                '}';
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

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getIsUrgent() {
        return isUrgent;
    }

    public void setIsUrgent(int isUrgent) {
        this.isUrgent = isUrgent;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public int getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public int getCheckOperID() {
        return checkOperID;
    }

    public void setCheckOperID(int checkOperID) {
        this.checkOperID = checkOperID;
    }

    public int getResultOperID() {
        return resultOperID;
    }

    public void setResultOperID(int resultOperID) {
        this.resultOperID = resultOperID;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Date getResultTime() {
        return resultTime;
    }

    public void setResultTime(Date resultTime) {
        this.resultTime = resultTime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getRecordType() {
        return recordType;
    }

    public void setRecordType(int recordType) {
        this.recordType = recordType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CheckApply(int medicalID, int registID, int itemID, String name, String objective, String position, int isUrgent, int num, Date creationTime, int doctorID, int checkOperID, int resultOperID, Date checkTime, String result, Date resultTime, int state, int recordType) {
        this.medicalID = medicalID;
        this.registID = registID;
        this.itemID = itemID;
        this.name = name;
        this.objective = objective;
        this.position = position;
        this.isUrgent = isUrgent;
        this.num = num;
        this.creationTime = creationTime;
        this.doctorID = doctorID;
        this.checkOperID = checkOperID;
        this.resultOperID = resultOperID;
        this.checkTime = checkTime;
        this.result = result;
        this.resultTime = resultTime;
        this.state = state;
        this.recordType = recordType;
    }

    public CheckApply() {
    }
}
