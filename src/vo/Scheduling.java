package vo;

import java.util.Date;

/**
 * 排班表
 * */
public class Scheduling {
    //唯一标识
    private  int id;
    //排班日期
    private Date schedDate;
    //科室id
    private int deptID;
    //医生id
    private int userID;
    //午别（上午/下午）
    private  String noon;
    //排版规则id
    private int ruleID;

    public Scheduling(Date schedDate, int deptID, int userID, String noon, int ruleID) {
        this.schedDate = schedDate;
        this.deptID = deptID;
        this.userID = userID;
        this.noon = noon;
        this.ruleID = ruleID;
    }

    public Scheduling() {
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

    public String getNoon() {
        return noon;
    }

    public void setNoon(String noon) {
        this.noon = noon;
    }

    public int getRuleID() {
        return ruleID;
    }

    public void setRuleID(int ruleID) {
        this.ruleID = ruleID;
    }

    @Override
    public String toString() {
        return "Scheduling{" +
                "id=" + id +
                ", schedDate=" + schedDate +
                ", deptID=" + deptID +
                ", userID=" + userID +
                ", noon='" + noon + '\'' +
                ", ruleID=" + ruleID +
                '}';
    }
}
