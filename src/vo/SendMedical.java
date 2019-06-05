/*
发药管理类
 */
package vo;

import java.util.Date;

public class SendMedical {
    private String DrugsName;//药品名
    private double DrugsPrice;//单价
    private double Amount;//数量
    private int delmark;//药品状态
    private String RealName;//医生名字
    private String PrescriptionName;//处方名
    private Date date;//开处方时间
    private int id;//处方明细id
    public SendMedical() {
    }

    public SendMedical(String drugsName, double drugsPrice, double amount, int delmark, String realName, String prescriptionName, Date date, int id) {
        DrugsName = drugsName;
        DrugsPrice = drugsPrice;
        Amount = amount;
        this.delmark = delmark;
        RealName = realName;
        PrescriptionName = prescriptionName;
        this.date = date;
        this.id = id;
    }

    public String getDrugsName() {
        return DrugsName;
    }

    public void setDrugsName(String drugsName) {
        DrugsName = drugsName;
    }

    public double getDrugsPrice() {
        return DrugsPrice;
    }

    public void setDrugsPrice(double drugsPrice) {
        DrugsPrice = drugsPrice;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }

    public int getDelmark() {
        return delmark;
    }

    public void setDelmark(int delmark) {
        this.delmark = delmark;
    }

    public String getRealName() {
        return RealName;
    }

    public void setRealName(String realName) {
        RealName = realName;
    }

    public String getPrescriptionName() {
        return PrescriptionName;
    }

    public void setPrescriptionName(String prescriptionName) {
        PrescriptionName = prescriptionName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "SendMedical{" +
                "DrugsName='" + DrugsName + '\'' +
                ", DrugsPrice=" + DrugsPrice +
                ", Amount=" + Amount +
                ", delmark=" + delmark +
                ", RealName='" + RealName + '\'' +
                ", PrescriptionName='" + PrescriptionName + '\'' +
                ", date=" + date +
                ", id=" + id +
                '}';
    }
}
