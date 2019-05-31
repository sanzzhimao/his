package vo;

import java.util.Date;

/**
 * 实体类：发票
 */
public class Invoice {
    private int id;
    private  String invoiceNum;//发票号码
    private double money;//发票金额
    private int state;//发票状态
    private Date creationTime;//收/退费时间
    private int userID;//收/退费人员ID
    private int registID;//挂号ID
    private int feeType;//收费方式
    private String back;//冲红发票号码
    private int dailyState;//日结审核状态

    public Invoice() {
    }

    public Invoice(String invoiceNum, double money, int state, Date creationTime, int userID, int registID, int feeType, String back, int dailyState) {
        this.invoiceNum = invoiceNum;
        this.money = money;
        this.state = state;
        this.creationTime = creationTime;
        this.userID = userID;
        this.registID = registID;
        this.feeType = feeType;
        this.back = back;
        this.dailyState = dailyState;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(String invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getRegistID() {
        return registID;
    }

    public void setRegistID(int registID) {
        this.registID = registID;
    }

    public int getFeeType() {
        return feeType;
    }

    public void setFeeType(int feeType) {
        this.feeType = feeType;
    }

    public String getBack() {
        return back;
    }

    public void setBack(String back) {
        this.back = back;
    }

    public int getDailyState() {
        return dailyState;
    }

    public void setDailyState(int dailyState) {
        this.dailyState = dailyState;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", invoiceNum='" + invoiceNum + '\'' +
                ", money=" + money +
                ", state=" + state +
                ", creationTime=" + creationTime +
                ", userID=" + userID +
                ", registID=" + registID +
                ", feeType=" + feeType +
                ", back='" + back + '\'' +
                ", dailyState=" + dailyState +
                '}';
    }
}
