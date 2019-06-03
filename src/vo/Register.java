package vo;
import java.util.Date;

/**
 * 患者历次挂号信息表
 */
public class Register {
    //唯一标识
    private int id;
    //病例号
    private String caseNumber;
    //真实姓名
    private String realName;
    //性别
    private int dender;
    //身份证号
    private String idNumber;
    //出生日期
    private Date birthDate;
    //年龄
    private int age;
    //年龄类型（年-月-日）
    private String ageTpye;
    //家庭住址
    private String homeAddress;
    //本次看诊日期
    private Date visitDate;
    //午别
    private String noon;
    //本次挂号科室id
    private int deptID;
    //本次挂号医生id
    private int userID;
    //挂号级别id
    private int registLeID;
    //挂号类别id
    private int settLeID;
    //是否需要病历本
    private boolean isBook;
    //挂号时间
    private Date registTime;
    //挂号员id
    private int registerID;
    //看诊状态（1-已经挂号；2-医生接诊；3-看诊结束；4-已退号）
    private int visitState;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public int getDender() {
        return dender;
    }

    public void setDender(int dender) {
        this.dender = dender;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAgeTpye() {
        return ageTpye;
    }

    public void setAgeTpye(String ageTpye) {
        this.ageTpye = ageTpye;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public String getNoon() {
        return noon;
    }

    public void setNoon(String noon) {
        this.noon = noon;
    }

    public int getDeptID() {
        return deptID;
    }

    public void setDeptID(int deptID) {
        this.deptID = deptID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getRegistLeID() {
        return registLeID;
    }

    public void setRegistLeID(int registLeID) {
        this.registLeID = registLeID;
    }

    public int getSettLeID() {
        return settLeID;
    }

    public void setSettLeID(int settLeID) {
        this.settLeID = settLeID;
    }

    public boolean isBook() {
        return isBook;
    }

    public void setBook(boolean book) {
        isBook = book;
    }

    public Date getRegistTime() {
        return registTime;
    }

    public void setRegistTime(Date registTime) {
        this.registTime = registTime;
    }

    public int getRegisterID() {
        return registerID;
    }

    public void setRegisterID(int registerID) {
        this.registerID = registerID;
    }

    public int getVisitState() {
        return visitState;
    }

    public void setVisitState(int visitState) {
        this.visitState = visitState;
    }

    public Register() {
    }

    @Override
    public String toString() {
        return "Register{" +
                "id=" + id +
                ", caseNumber='" + caseNumber + '\'' +
                ", realName='" + realName + '\'' +
                ", dender=" + dender +
                ", idNumber='" + idNumber + '\'' +
                ", birthDate=" + birthDate +
                ", age=" + age +
                ", ageTpye=" + ageTpye +
                ", homeAddress='" + homeAddress + '\'' +
                ", visitDate=" + visitDate +
                ", noon='" + noon + '\'' +
                ", deptID=" + deptID +
                ", userID=" + userID +
                ", registLeID=" + registLeID +
                ", settLeID=" + settLeID +
                ", isBook=" + isBook +
                ", registTime=" + registTime +
                ", registerID=" + registerID +
                ", visitState=" + visitState +
                '}';
    }
}
