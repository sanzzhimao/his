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
