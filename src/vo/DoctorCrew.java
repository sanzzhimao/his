package vo;

import java.util.Date;

/**
 * 医生排班管理类
 */
public class DoctorCrew {
    private int id;
    //排班日期
    private Date schedDate;
    //科室名称
    private String deptName;
    //医生名称
    private String realName;
    //午别
    private String noon;
    //挂号级别名称
    private String registName;
    //挂号限额
    private String registQuota;

    public DoctorCrew() {
    }

    public DoctorCrew(Date schedDate, String deptName, String realName,String noon, String registName, String registQuota) {
        this.schedDate = schedDate;
        this.deptName = deptName;
        this.realName = realName;
        this.noon = noon;
        this.registName = registName;
        this.registQuota = registQuota;
    }

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

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
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

    public String getRegistName() {
        return registName;
    }

    public void setRegistName(String registName) {
        this.registName = registName;
    }

    public String getRegistQuota() {
        return registQuota;
    }

    public void setRegistQuota(String registQuota) {
        this.registQuota = registQuota;
    }

    @Override
    public String toString() {
        return "DoctorCrew{" +
                "id=" + id +
                ", schedDate=" + schedDate +
                ", deptName='" + deptName + '\'' +
                ", realName='" + realName + '\'' +
                ", noon=" + noon +
                ", registName='" + registName + '\'' +
                ", registQuota='" + registQuota + '\'' +
                '}';
    }
}
