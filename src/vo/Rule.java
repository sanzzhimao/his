package vo;

import java.util.TreeMap;

/**
 * 排班规则版
 * */
public class Rule {
    //唯一标识
    private int id;
    //规则名称
    private String ruleNmae;
    //科室id
    private int deptID;
    //医生id
    private int userID;
    /*
     星期
     14位1和0组成的字符串，1代表有班0代表无班
     14为字符串从左到右依次表示星期一到星期日
     每天两位标识上下午
     */
    private String week;
    //删除标记
    private int delMark;

    public Rule() {
    }

    public Rule(String ruleNmae, int deptID, int userID, String week, int delMark) {
        this.ruleNmae = ruleNmae;
        this.deptID = deptID;
        this.userID = userID;
        this.week = week;
        this.delMark = delMark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRuleNmae() {
        return ruleNmae;
    }

    public void setRuleNmae(String ruleNmae) {
        this.ruleNmae = ruleNmae;
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

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public int getDelMark() {
        return delMark;
    }

    public void setDelMark(int delMark) {
        this.delMark = delMark;
    }

    @Override
    public String toString() {
        return "Rule{" +
                "id=" + id +
                ", ruleNmae='" + ruleNmae + '\'' +
                ", deptID=" + deptID +
                ", userID=" + userID +
                ", week='" + week + '\'' +
                ", delMark=" + delMark +
                '}';
    }
}
