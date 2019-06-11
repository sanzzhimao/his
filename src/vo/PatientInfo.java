package vo;

import java.util.Date;

/**
 * @Author lym
 * @Description:病人的信息
 * @Param
 * @return
**/
public class PatientInfo {
    //唯一标识
    private  int id;
    //病历号
    private String caseNumber;
    //真实姓名
    private String realName;
    //身份证好嘛
    private String identityNumber;
    //家庭住址
    private String HomeAddress;
    //项目名称
    private  String itemNmae;
    //项目单价
    private  double itemPrice;
    //项目数量
    private int number;
    //开立时间
    private Date openDate;
    //开立状态
    private int openState;

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

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getHomeAddress() {
        return HomeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        HomeAddress = homeAddress;
    }

    public String getItemNmae() {
        return itemNmae;
    }

    public void setItemNmae(String itemNmae) {
        this.itemNmae = itemNmae;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public int getOpenState() {
        return openState;
    }

    public void setOpenState(int openState) {
        this.openState = openState;
    }

    @Override
    public String  toString() {
        return "PatientInfo{" +
                "id=" + id +
                ", caseNumber='" + caseNumber + '\'' +
                ", realName='" + realName + '\'' +
                ", identityNumber='" + identityNumber + '\'' +
                ", HomeAddress='" + HomeAddress + '\'' +
                ", itemNmae='" + itemNmae + '\'' +
                ", itemPrice=" + itemPrice +
                ", number=" + number +
                ", openDate=" + openDate +
                ", openState=" + openState +
                '}';
    }
}
