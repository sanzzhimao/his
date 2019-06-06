package vo;

import java.util.Date;

/**
 * 医生排班管理类
 */
public class DoctorCrew {
    private int id;
    //排班日期
    private Date schedDate;
    //科室ID
    private int deptID;
    //科室名称
    private String deptName;
    //医生ID
    private int userID;
    //医生名称
    private String realName;
    //午别
    private String noon;
    //挂号级别ID
    private int registLeID;
    //挂号级别名称
    private String registLeName;
    //挂号限额
    private int registQuota;
    //挂号费
    private double registFee;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getSchedDate() {
        return schedDate;
    }

    public void setSchedDate(Date schedDate) {
        this.schedDate = schedDate;
    }

    public int getDeptID() {
        return deptID;
    }

    public void setDeptID(int deptID) {
        this.deptID = deptID;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getNoon() {
        return noon;
    }

    public void setNoon(String noon) {
        this.noon = noon;
    }

    public int getRegistLeID() {
        return registLeID;
    }

    public void setRegistLeID(int registLeID) {
        this.registLeID = registLeID;
    }

    public String getRegistLeName() {
        return registLeName;
    }

    public void setRegistLeName(String registLeName) {
        this.registLeName = registLeName;
    }

    public int getRegistQuota() {
        return registQuota;
    }

    public void setRegistQuota(int registQuota) {
        this.registQuota = registQuota;
    }

    public double getRegistFee() {
        return registFee;
    }

    public void setRegistFee(double registFee) {
        this.registFee = registFee;
    }

    @Override
    public String toString() {
        return "DoctorCrew{" +
                "id=" + id +
                ", schedDate=" + schedDate +
                ", deptID=" + deptID +
                ", deptName='" + deptName + '\'' +
                ", userID=" + userID +
                ", realName='" + realName + '\'' +
                ", noon='" + noon + '\'' +
                ", registLeID=" + registLeID +
                ", registLeName='" + registLeName + '\'' +
                ", registQuota=" + registQuota +
                ", registFee=" + registFee +
                '}';
    }
}
